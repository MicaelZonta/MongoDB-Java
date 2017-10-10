package MongoDBImplementacoes;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.client.model.DBCollectionCountOptions;

//Apenas para consulta
abstract class JavaDriver {

	// Exemplo Query
	private void queryExample() {

		// Cria conexão banco
		DB db = new DB(new Mongo(), "");
		List<Object> orders = new ArrayList<>();

		// Usa DB
		// Pega coleção
		// Passa Critério
		DBCursor cursor = db.getCollection("product_orders").find(new BasicDBObject("fulfilled", true)).limit(2);

		// Adiciona dentro da lista
		while (cursor.hasNext()) {
			orders.add(new ProductOrder(cursor.next()));
		}

		// cria uma query e da append no total
		// com agrupamento
		BasicDBObject query = new BasicDBObject("fulfilled", true).append("total", new BasicDBObject("$gte", 5000));

		// Lista
		// cria lista de critérios
		BasicDBList lista = new BasicDBList();
		lista.add(new BasicDBObject("fulfilled", false));
		lista.add(new BasicDBObject("size", new BasicDBObject("$lte", 3)));

		// coloca critério do Or
		DBCursor cursor1 = db.getCollection("product_orders").find(new BasicDBObject("$or", lista));

	}

	public void updateExample() {
		// Cria conexão banco
		DB db = new DB(new Mongo(), "");
		List<Object> orders = new ArrayList<>();

		// update
		// db.product_orders.update({size:3},{$set:{total:400}})
		BasicDBObject criterio = new BasicDBObject("size", 3); // criterio
		BasicDBObject update = new BasicDBObject("$set", new BasicDBObject("total", 400)); // coloca																				// total
		DBCollection col = db.getCollection("product_orders"); // pega coleção
		col.update(criterio, update); // joga update

		
	}
	
	
	

	class ProductOrder {

		public ProductOrder(DBObject dbo) {

		}
	}

}
