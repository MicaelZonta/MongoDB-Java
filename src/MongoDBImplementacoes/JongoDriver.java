package MongoDBImplementacoes;

import java.util.ArrayList;
import java.util.List;

import org.jongo.Jongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

//Apenas para consulta
abstract class JongoDriver {

	// Exemplo Query
	private void queryExample() {

		// Criando conexão
		Jongo jongo = new Jongo(new DB(new Mongo(), ""));
		// Pega Conexão
		// procurar critério
		// transformar em classe
		jongo.getCollection("product").find("{fulfilled: true}").limit(2).as(ProductOrder.class);

		// com agrupamento
		jongo.getCollection("product").find("{fulfilled: true , total : {$gte : # }}", 5000).sort("{total : 1}")
				.as(ProductOrder.class);

		// com or
		jongo.getCollection("produxt_orders").find(" { $or : [ { size : { $lite : # } } , { fulfilled : false } ] }",3).as(ProductOrder.class);
	}

	private void updateExample() {
		// Criando conexão
		Jongo jongo = new Jongo(new DB(new Mongo(), ""));

		// db.product_orders.update({size:3},{$set:{total:400}})
		// upsert insere e update
		// update em vários
		jongo.getCollection("product_orders").update(" {size : # }", 3).upsert().multi()
				.with(" { $set : { total : # } }", 400);
	}

	class ProductOrder {

		public ProductOrder(DBObject dbo) {

		}
	}
}
