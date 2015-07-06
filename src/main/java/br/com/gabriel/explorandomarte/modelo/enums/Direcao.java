package br.com.gabriel.explorandomarte.modelo.enums;

public enum Direcao {

	NORTE(1),
	SUL(-1),
	LESTE(1),
	OESTE(-1);
	
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
	
	private void configuraDirecoesAoLado(Direcao direcaoAEsquerda, Direcao direcaoADireita) {
		this.direcaoAEsquerda = direcaoAEsquerda;
		this.direcaoADireita = direcaoADireita;
	}

	public int getIncrementoPosicao() {
		return incrementoPosicao;
	}
}