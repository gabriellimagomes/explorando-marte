package br.com.gabriel.explorandomarte.modelo;

public class VerificadorMovimentoLeste implements VerificadorMovimento {

	public boolean isPossivelMovimentar(Sonda sonda, PosicionadorSondas posicionadorSondas) {

		if (sonda.getPosicaoX() < posicionadorSondas.getPosicaoLimiteX()){
			return true;
		} else {
			return false;
		}
	}

}
