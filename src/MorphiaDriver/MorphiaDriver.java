package MorphiaDriver;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import Entidades.Andar;
import Entidades.Estacionamento;
import Entidades.Franquia;
import Entidades.Vaga;

public class MorphiaDriver {
	
	public Datastore conectar(){
		Morphia morphia = new Morphia();
		morphia.mapPackage("Entidades");
		
		final Datastore datastore = morphia.createDatastore(new MongoClient(), "Exemplo1");
		datastore.ensureIndexes();
		
		return datastore;
		
		
	}
}
