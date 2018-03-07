package br.com.gabriel.explorandomarte.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import br.com.gabriel.explorandomarte.modelo.enums.Direcao;
import br.com.gabriel.explorandomarte.modelo.exception.PosicaoSondaForaDoPlanaltoException;

public class MovimentadorTest {

	private Movimentador movimentador;
	private Sonda sonda;
	private PosicionadorSondas posicionadorSondas;

	@Before
	public void setUp() throws Exception {
		movimentador = new Movimentador();
		
		sonda = new Sonda(0, 0, Direcao.NORTE);
		posicionadorSondas = new PosicionadorSondas(2, 2);
	}

	@Test
	public void deveMovimentarUmaSonda() {
		movimentador.executaMovimento(sonda, posicionadorSondas);
		movimentador.executaMovimento(sonda, posicionadorSondas);
		
		Assert.assertEquals(0, sonda.getPosicaoX());
		Assert.assertEquals(2, sonda.getPosicaoY());
	}
	
	@Test(expected=PosicaoSondaForaDoPlanaltoException.class)
	public void deveLancarExcecaoQuandoUltrapassarLimite() {
		movimentador.executaMovimento(sonda, posicionadorSondas);
		movimentador.executaMovimento(sonda, posicionadorSondas);
		movimentador.executaMovimento(sonda, posicionadorSondas);
	}

}
