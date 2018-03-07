package br.com.gabriel.explorandomarte.modelo;


public class PosicionadorSondas {

	private final int posicaoLimiteX;
	private final int posicaoLimiteY;

	public PosicionadorSondas(int posicaoLimiteX, int posicaoLimiteY) {
		this.posicaoLimiteX = posicaoLimiteX;
		this.posicaoLimiteY = posicaoLimiteY;
	}

	public void movimentaSonda(Sonda sonda, ExecutorMovimento executorMovimentos) {
		
		executorMovimentos.executaMovimento(sonda, this);
	}

	public int getPosicaoLimiteX() {
		return posicaoLimiteX;
	}

	public int getPosicaoLimiteY() {
		return posicaoLimiteY;
	}

}
