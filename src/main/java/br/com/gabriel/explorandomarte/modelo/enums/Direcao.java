package br.com.gabriel.explorandomarte.modelo.enums;

import br.com.gabriel.explorandomarte.modelo.PosicionadorSondas;
import br.com.gabriel.explorandomarte.modelo.Sonda;
import br.com.gabriel.explorandomarte.modelo.VerificadorMovimento;
import br.com.gabriel.explorandomarte.modelo.VerificadorMovimentoLeste;
import br.com.gabriel.explorandomarte.modelo.VerificadorMovimentoOeste;
import br.com.gabriel.explorandomarte.modelo.VerificadorMovimentoSul;

public enum Direcao {

	NORTE(1, new VerificadorMovimentoNorte()),
	SUL(-1, new VerificadorMovimentoSul()),
	LESTE(1, new VerificadorMovimentoLeste()),
	OESTE(-1, new VerificadorMovimentoOeste());
	
	static {
		NORTE.configuraDirecoesAoLado(OESTE, LESTE);
		SUL.configuraDirecoesAoLado(LESTE, OESTE);
		LESTE.configuraDirecoesAoLado(NORTE, SUL);
		OESTE.configuraDirecoesAoLado(SUL, NORTE);
	}
	
	private Direcao direcaoAEsquerda;
	private Direcao direcaoADireita;
	private final int incrementoPosicao;
	private final VerificadorMovimento verificadorMovimento;
	
	private Direcao(int incrementoPosicao, VerificadorMovimento verificadorMovimento) {
		this.incrementoPosicao = incrementoPosicao;
		this.verificadorMovimento = verificadorMovimento;
	}
	
	public Direcao getDirecaoAEsquerda() {
		return direcaoAEsquerda;
	}
	
	public Direcao getDirecaoADireita() {
		return direcaoADireita;
	}
	
	private void configuraDirecoesAoLado(Direcao direcaoAEsquerda, Direcao direcaoADireita) {
		this.direcaoAEsquerda = direcaoAEsquerda;
		this.direcaoADireita = direcaoADireita;
	}

	public int getIncrementoPosicao() {
		return incrementoPosicao;
	}

	public boolean isPossivelMovimentar(Sonda sonda, PosicionadorSondas posicionadorSondas) {
		
		return verificadorMovimento.isPossivelMovimentar(sonda, posicionadorSondas);
	}
}