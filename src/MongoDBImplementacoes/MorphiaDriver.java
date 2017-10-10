package MongoDBImplementacoes;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.mongodb.DBObject;
import com.mongodb.operation.UpdateOperation;


//Apenas para consulta
abstract class MorphiaDriver {

	private void queryExample() {

		// Cria dataStore
		Datastore ds = null;

		// Classe, deppois campo, depois critério como lista
		ds.createQuery(ProductOrder.class).field("fulfilled").equal(true).limit(2).asList();

		// com agrupamento
		ds.createQuery(ProductOrder.class).field("fulfilled").equal(true).filter("total >= ", 5000).order("total")
				.asList();
		// .field("total").greaterThanOrEq(5000)

		// cria queru
		Query<ProductOrder> query = ds.createQuery(ProductOrder.class);
		// coloca or e criterios
		query.or(query.criteria("fulfilled").equal(false), query.criteria("size").lessThanOrEq(3));
		// lista
		query.asList();

	}

	private void updateQuery(){
		// Cria dataStore
		Datastore ds = null;
				
		// db.product_orders.update({size:3},{$set:{total:400}}) 
		// Cria a Query
		Query<ProductOrder> query = ds.createQuery(ProductOrder.class).filter("size",3);
		//Da o valor a troca
		UpdateOperations<ProductOrder> update = ds.createUpdateOperations(ProductOrder.class).set("total", 400);
		//update
		ds.update(query, update);
		// ds.updateFirst(query,update);
		
	}

	class ProductOrder {

		public ProductOrder(DBObject dbo) {

		}
	}
}
