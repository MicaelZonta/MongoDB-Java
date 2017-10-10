package Negocios;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.FranquiaDAO;
import Entidades.Franquia;

public class FranquiaNegocios {

	FranquiaDAO franquiaDAO = new FranquiaDAO();
	Logger LOG = Logger.getLogger(FranquiaDAO.class.getName());

	public Franquia cadastrar(Franquia franquia) {
		try {
			long id = franquiaDAO.proximoId();
			franquia.setIdFranquia(id);
			franquia = franquiaDAO.salvar(franquia);
			System.out.println("Franquia - Salva com sucesso!");
			return franquia;
		} catch (Exception e) {
			System.out.println("Franquia - Erro ao salvar!");
			return new Franquia();
		}
	}

	public Franquia atualizar(Franquia franquia) {
		try {
			franquia = franquiaDAO.salvar(franquia);
			System.out.println("Franquia - Salva com sucesso!");
			return franquia;
		} catch (Exception e) {
			System.out.println("Franquia - Erro ao salvar!");
			return new Franquia();
		}
	}

	public Franquia deletar(Franquia franquia) {
		try {
			franquia = franquiaDAO.deletar(franquia);
			System.out.println("Franquia - Deletada com sucesso!");
			return franquia;
		} catch (Exception e) {
			System.out.println("Franquia - Erro ao deletar!");
			return new Franquia();
		}
	}

	public List<Franquia> listar() {
		try {
			List<Franquia> franquia = franquiaDAO.listar();
			System.out.println("Franquia - Listado com sucesso!");
			return franquia;
		} catch (Exception e) {
			System.out.println("Franquia - Erro ao Listar!");
			return new ArrayList<>();
		}
	}

}
