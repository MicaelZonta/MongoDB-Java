package Entidades;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity("Franquia")
public class Franquia {

	@Id
	@Property("idFranquia")
	long idFranquia;
	
	@Property("nome")
	String nome;
	
	@Embedded 
	List<Estacionamento> estacionamento;

	public long getIdFranquia() {
		return idFranquia;
	}

	public void setIdFranquia(long idFranquia) {
		this.idFranquia = idFranquia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Estacionamento> getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(List<Estacionamento> estacionamento) {
		this.estacionamento = estacionamento;
	}

}
