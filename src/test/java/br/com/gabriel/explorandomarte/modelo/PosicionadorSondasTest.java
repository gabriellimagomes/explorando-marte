package br.com.gabriel.explorandomarte.modelo;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.com.gabriel.explorandomarte.modelo.enums.Direcao;
import br.com.gabriel.explorandomarte.modelo.exception.PosicaoSondaForaDoPlanaltoException;

public class PosicionadorSondasTest {

	private PosicionadorSondas posicionadorSondas;
	private ExecutorMovimento virarDireita;
	private ExecutorMovimento virarEsquerda;
	private ExecutorMovimento movimenta;

	@Before
	public void setUp() {

		posicionadorSondas = new PosicionadorSondas(5, 5);
		
		virarDireita = new ViradorDireita();
		virarEsquerda = new ViradorEsquerda();
		movimenta = new Movimentador(posicionadorSondas);
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
