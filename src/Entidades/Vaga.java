package Entidades;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("Vaga")
public class Vaga {

	@Id
	int idVaga;
	double preco;

	public int getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
