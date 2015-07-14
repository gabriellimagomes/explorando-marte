package br.com.gabriel.explorandomarte.modelo.enums;

import br.com.gabriel.explorandomarte.modelo.PosicionadorSondas;
import br.com.gabriel.explorandomarte.modelo.Sonda;

public enum Direcao {

	NORTE(1) {
		@Override
		public boolean isPossivelMovimentar(Sonda sonda, PosicionadorSondas posicionadorSondas) {			
			
			return sonda.getPosicaoY() < posicionadorSondas.getPosicaoLimiteY();
		}
	},
	SUL(-1) {
		@Override
		public boolean isPossivelMovimentar(Sonda sonda, PosicionadorSondas posicionadorSondas) {

			return sonda.getPosicaoY() > 0;
		}
	},
	LESTE(1) {
		@Override
		public boolean isPossivelMovimentar(Sonda sonda, PosicionadorSondas posicionadorSondas) {

			return sonda.getPosicaoX() < posicionadorSondas.getPosicaoLimiteX();
		}
	},
	OESTE(-1) {
		@Override
		public boolean isPossivelMovimentar(Sonda sonda, PosicionadorSondas posicionadorSondas) {
			
			return sonda.getPosicaoX() > 0;
		}
	};
	
	static {
		NORTE.configuraDirecoesAoLado(OESTE, LESTE);
		SUL.configuraDirecoesAoLado(LESTE, OESTE);
		LESTE.configuraDirecoesAoLado(NORTE, SUL);
		OESTE.configuraDirecoesAoLado(SUL, NORTE);
	}
	
	private Direcao direcaoAEsquerda;
	private Direcao direcaoADireita;
	private final int incrementoPosicao;
	
	private Direcao(int incrementoPosicao) {
		this.incrementoPosicao = incrementoPosicao;
	}
	
	public Direcao getDirecaoAEsquerda() {
		return direcaoAEsquerda;
	}
	
	public Direcao getDirecaoADireita() {
		return direcaoADireita;
	}
	
	public int getIncrementoPosicao() {
		return incrementoPosicao;
	}

	public abstract boolean isPossivelMovimentar(Sonda sonda, PosicionadorSondas posicionadorSondas);
	
	private void configuraDirecoesAoLado(Direcao direcaoAEsquerda, Direcao direcaoADireita) {
		this.direcaoAEsquerda = direcaoAEsquerda;
		this.direcaoADireita = direcaoADireita;
	}
}