package br.com.gabriel.explorandomarte.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.gabriel.explorandomarte.modelo.enums.Direcao;

public class SondaTest {
	
	@Test
	public void deveSerPossivelMudarDirecaoDeUmaSonda() {
		
		Sonda sonda = new Sonda(0, 0, Direcao.NORTE);
		sonda.viraParaEsquerda();
		sonda.viraParaEsquerda();
		assertEquals(Direcao.SUL, sonda.getDirecao());
		
		sonda.viraParaDireita();
		assertEquals(Direcao.OESTE, sonda.getDirecao());			
	}
	
	@Test
	public void deveMovimentarSondaNaDirecaoQueASondaEsta() throws Exception {
		
		Sonda sonda = new Sonda(1, 2, Direcao.LESTE);
		sonda.movimenta();
		assertEquals(2, sonda.getPosicaoX());
		assertEquals(2, sonda.getPosicaoY());
		
		sonda.viraParaDireita();
		sonda.movimenta();
		sonda.movimenta();
		sonda.movimenta();
		assertEquals(2, sonda.getPosicaoX());
		assertEquals(-1, sonda.getPosicaoY());
	}
	
}
