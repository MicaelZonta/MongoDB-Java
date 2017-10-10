package Entidades;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity("Andar")
public class Andar {

	@Id
	int idAndar;
	@Embedded 
	List<Vaga> vagas;

	public int getIdAndar() {
		return idAndar;
	}

	public void setIdAndar(int idAndar) {
		this.idAndar = idAndar;
	}

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

}
