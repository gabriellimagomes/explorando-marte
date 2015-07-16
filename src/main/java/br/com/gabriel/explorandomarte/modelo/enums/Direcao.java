package br.com.gabriel.explorandomarte.modelo.enums;

import br.com.gabriel.explorandomarte.modelo.PosicionadorSondas;
import br.com.gabriel.explorandomarte.modelo.Sonda;

public enum Direcao {

	NORTE(1, "N") {
		@Override
		public boolean isPossivelMovimentar(Sonda sonda, PosicionadorSondas posicionadorSondas) {			
			
			return sonda.getPosicaoY() < posicionadorSondas.getPosicaoLimiteY();
		}
	},
	SUL(-1, "S") {
		@Override
		public boolean isPossivelMovimentar(Sonda sonda, PosicionadorSondas posicionadorSondas) {

			return sonda.getPosicaoY() > 0;
		}
	},
	LESTE(1, "E") {
		@Override
		public boolean isPossivelMovimentar(Sonda sonda, PosicionadorSondas posicionadorSondas) {

			return sonda.getPosicaoX() < posicionadorSondas.getPosicaoLimiteX();
		}
	},
	OESTE(-1, "W") {
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
	private final String letra;
	
	private Direcao(int incrementoPosicao, String letra) {
		this.incrementoPosicao = incrementoPosicao;
		this.letra = letra;
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

	public String getLetra() {
		return letra;
	}
	
	public static Direcao getByLetra(String letra) {
		
		for (Direcao direcao : Direcao.values()) {
			
			if (direcao.getLetra().equalsIgnoreCase(letra)){
				return direcao;
			}
		}
		
		return null;
	}

	public abstract boolean isPossivelMovimentar(Sonda sonda, PosicionadorSondas posicionadorSondas);
	
	private void configuraDirecoesAoLado(Direcao direcaoAEsquerda, Direcao direcaoADireita) {
		this.direcaoAEsquerda = direcaoAEsquerda;
		this.direcaoADireita = direcaoADireita;
	}

}