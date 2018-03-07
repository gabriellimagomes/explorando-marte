package br.com.gabriel.explorandomarte.modelo.exception;

public class PosicaoSondaForaDoPlanaltoException extends RuntimeException {

	private static final long serialVersionUID = -4532537498216782073L;

	public PosicaoSondaForaDoPlanaltoException(int posicaoX, int posicaoY, int posicaoLimiteX, int posicaoLimiteY) {
		
		super(String.format("Posicao da sonda: X: %s, Y: %s | Posicao superior direita do planalto: X: %s, Y: %s", posicaoX, posicaoY, posicaoLimiteX, posicaoLimiteY));
	}
}
