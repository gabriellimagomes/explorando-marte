package br.com.gabriel.explorandomarte.modelo;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.com.gabriel.explorandomarte.modelo.enums.Direcao;
import br.com.gabriel.explorandomarte.modelo.exception.PosicaoSondaForaDoPlanaltoException;

public class SondaTest {
	
	private PosicionadorSondas posicionadorSondas;
	private ExecutorMovimentos virarDireita;
	private ExecutorMovimentos virarEsquerda;
	private ExecutorMovimentos movimenta;

	@Before
	public void setUp() {

		posicionadorSondas = new PosicionadorSondas(5, 5);
		
		virarDireita = new ViradorDireita();
		virarEsquerda = new ViradorEsquerda();
		movimenta = new Movimentador(posicionadorSondas);
	}

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
	
	@Test(expected=PosicaoSondaForaDoPlanaltoException.class)
	public void naoDevePoderMexerSondaParaNorteQuandoEstiverNoLimite() {
		
		posicionadorSondas.movimentaSonda(new Sonda(2, 5, Direcao.NORTE), new EntradaMovimentos(Arrays.asList(virarDireita, virarEsquerda, movimenta)));
	}
	
	@Test(expected=PosicaoSondaForaDoPlanaltoException.class)
	public void naoDevePoderMexerSondaParaSulQuandoEstiverNoLimite() {
		
		posicionadorSondas.movimentaSonda(new Sonda(2, 0, Direcao.LESTE), new EntradaMovimentos(Arrays.asList(virarDireita, movimenta)));
	}
	
	@Test(expected=PosicaoSondaForaDoPlanaltoException.class)
	public void naoDevePoderMexerSondaParaLesteQuandoEstiverNoLimite() {
		
		posicionadorSondas.movimentaSonda(new Sonda(5, 3, Direcao.LESTE), new EntradaMovimentos(Arrays.asList(movimenta)));
	}
	
	@Test(expected=PosicaoSondaForaDoPlanaltoException.class)
	public void naoDevePoderMexerSondaParaOesteQuandoEstiverNoLimite() {
		
		posicionadorSondas.movimentaSonda(new Sonda(0, 3, Direcao.OESTE), new EntradaMovimentos(Arrays.asList(movimenta)));
	}

}
