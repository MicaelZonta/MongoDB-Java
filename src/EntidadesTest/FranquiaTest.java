package EntidadesTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mongodb.morphia.Datastore;

import Entidades.Andar;
import Entidades.Estacionamento;
import Entidades.Franquia;
import Entidades.Vaga;
import MorphiaDriver.MorphiaDriver;
import Negocios.FranquiaNegocios;
import junit.framework.Assert;

public class FranquiaTest {	
	
	@Test
	public void cadastrar() {
		Franquia franquia = new Franquia();
		franquia.setIdFranquia(1);
		franquia.setNome("Teste");
		
		Estacionamento estacionamento = new Estacionamento();
		estacionamento.setEndereco("Endereço12");
		estacionamento.setIdEstacionamento(1);
		estacionamento.setNome("Teste234");
		
		Estacionamento estacionamento2 = new Estacionamento();
		estacionamento2.setEndereco("Endereço");
		estacionamento2.setIdEstacionamento(2);
		estacionamento2.setNome("Teste3");
		
		
		franquia.setEstacionamento(new ArrayList<>());
		franquia.getEstacionamento().add(estacionamento);
		franquia.getEstacionamento().add(estacionamento2);
		
		Andar andar = new Andar();
		andar.setIdAndar(1);
		
		estacionamento.setAndarList(new ArrayList<>());
		estacionamento.getAndarList().add(andar);
		
		Vaga vaga = new Vaga();
		vaga.setIdVaga(1);
		vaga.setPreco(1);
		
		Vaga vaga2 = new Vaga();
		vaga2.setIdVaga(2);
		vaga2.setPreco(2);
		
		
		andar.setVagas(new ArrayList<>());
		andar.getVagas().add(vaga);
		andar.getVagas().add(vaga2);
		
		FranquiaNegocios franquiaNeg = new FranquiaNegocios();
		franquiaNeg.cadastrar(franquia);		
		
		List<Franquia> franquias = franquiaNeg.listar();
		
		Assert.assertNotSame(0, franquias.size());		
	}
	
	//Brincando com Mock
	@Test
	public void cadastrarMock() {
		
		//Cria Franquia de Mentira
		Franquia franquia = Mockito.mock(Franquia.class);
			
		//Coloca parametros de mentira
		ArgumentCaptor<String> str = ArgumentCaptor.forClass(String.class);
		franquia.setNome(str.capture());
		
		//Cadastra de Mentira
		FranquiaNegocios franquiaNeg = Mockito.mock(FranquiaNegocios.class);
		franquiaNeg.cadastrar(franquia);
		
		//Pega todas Franquias
		Mockito.when(franquiaNeg.listar()).thenReturn(Mockito.mock(ArrayList.class));
		List<Franquia> franquias = franquiaNeg.listar();
		
		//Verifica se passou no método
		Mockito.verify(franquiaNeg,Mockito.times(1)).cadastrar(franquia);
		
		//Verifica se o tamanho está certo
		Mockito.when(franquias.size()).thenReturn(1);
		System.out.println(franquias.size());
		Assert.assertNotSame(0, franquias.size());
	}
	
	

}
