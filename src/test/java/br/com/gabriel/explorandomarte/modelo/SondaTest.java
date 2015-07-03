package br.com.gabriel.explorandomarte.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gabriel.explorandomarte.modelo.enums.Direcao;

public class SondaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void deveSerPossivelMudarDirecaoDeUmaSonda() {
		
		Sonda sonda = new Sonda(Direcao.NORTE);
		sonda.virarParaEsquerda();
		sonda.virarParaEsquerda();
		assertEquals(Direcao.SUL, sonda.getDirecao());
		
		sonda.virarParaDireita();
		assertEquals(Direcao.OESTE, sonda.getDirecao());
	}

}
