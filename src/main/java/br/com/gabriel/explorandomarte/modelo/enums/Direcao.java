package br.com.gabriel.explorandomarte.modelo.enums;

public enum Direcao {

	NORTE,
	SUL,
	LESTE,
	OESTE;
	
	static {
		NORTE.configuraDirecoesAoLado(OESTE, LESTE);
		SUL.configuraDirecoesAoLado(LESTE, OESTE);
		LESTE.configuraDirecoesAoLado(NORTE, SUL);
		OESTE.configuraDirecoesAoLado(SUL, NORTE);
	}
	
	private Direcao direcaoAEsquerda;
	private Direcao direcaoADireita;
	
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
}