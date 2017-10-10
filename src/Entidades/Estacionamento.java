package Entidades;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity("Estacionamento")
public class Estacionamento {

	@Id
	int idEstacionamento;
	
	@Property("Nome")
	String nome;
	
	@Property("Endereco")
	String endereco;
	
	@Embedded 
	List<Andar> andarList;

	public int getIdEstacionamento() {
		return idEstacionamento;
	}

	public void setIdEstacionamento(int idEstacionamento) {
		this.idEstacionamento = idEstacionamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Andar> getAndarList() {
		return andarList;
	}

	public void setAndarList(List<Andar> andarList) {
		this.andarList = andarList;
	}

}
