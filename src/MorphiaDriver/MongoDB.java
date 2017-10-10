package MorphiaDriver;

import java.util.logging.Logger;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

import Entidades.Franquia;

public class MongoDB {

	public static final String DB_IP = "127.0.0.1";
	public static final int DB_PORT = 27017;
	public static final String DB_NOME = "Estacionamento_Demo";

	private static final Logger LOG = Logger.getLogger(MongoDB.class.getName());

	private static final MongoDB INSTANCE = new MongoDB();

	private final Datastore datastore;

	private MongoDB() {
		    MongoClientOptions mongoOptions = MongoClientOptions.builder()
			.socketTimeout(60000) // Tempo de espera para terminar a query em segundos
			.connectTimeout(15000) // tempo para tentar a conexão
			.maxConnectionIdleTime(600000) // tempo até a conexão morrer se parada.
			.readPreference(ReadPreference.primaryPreferred()) //Lê do Primário em vez das réplicas de preferencia
			.build();
		    MongoClient mongoClient;
		    mongoClient = new MongoClient(new ServerAddress(DB_IP, DB_PORT), mongoOptions);

		    mongoClient.setWriteConcern(WriteConcern.SAFE);
		    datastore = new Morphia().mapPackage(Franquia.class.getPackage().getName()).createDatastore(mongoClient, DB_NOME);
		    datastore.ensureIndexes();
		    datastore.ensureCaps();
		    System.out.println("Connection to database '" + DB_IP + ":" + DB_PORT + "/" + DB_NOME + "' initialized");
		  }

	public static MongoDB instance() {
		return INSTANCE;
	}

	// Criar conexões com o Mongo é pesado, então é melhor um Singleton para melhor performace
	public Datastore getDatabase() {
		return datastore;
	}

}
