package br.com.gabriel.explorandomarte.modelo;

public class VerificadorMovimentoOeste implements VerificadorMovimento {

	public boolean isPossivelMovimentar(Sonda sonda, PosicionadorSondas posicionadorSondas) {

		if (sonda.getPosicaoX() > 0){
			return true;
		} else {
			return false;
		}
	}

}
