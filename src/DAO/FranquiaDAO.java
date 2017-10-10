package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.MongoClient;

import Entidades.Estacionamento;
import Entidades.Franquia;
import MorphiaDriver.MongoDB;
import MorphiaDriver.MorphiaDriver;

public class FranquiaDAO {

	Datastore datastore = MongoDB.instance().getDatabase();

	public Franquia salvar(Franquia franquia) {
		this.datastore.save(franquia);
		return franquia;
	}

	public Franquia deletar(Franquia franquia) {
		try {
			this.datastore.delete(franquia);
			return franquia;
		} catch (Exception e) {
			return new Franquia();
		}
	}

	public List<Franquia> listar() {
		try {
			List<Franquia> franquias = datastore.createQuery(Franquia.class).asList();
			return franquias;
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	public long proximoId() {
		try {
			List<Franquia> franquia = datastore.createQuery(Franquia.class).order("-idFranquia").limit(1).asList();
			long id = franquia.get(0).getIdFranquia();
			id++;
			return id;
		} catch (Exception e) {
			return 0;
		}
	}

}
