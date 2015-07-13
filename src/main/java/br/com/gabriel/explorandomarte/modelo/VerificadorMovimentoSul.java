package br.com.gabriel.explorandomarte.modelo;

public class VerificadorMovimentoSul implements VerificadorMovimento {

	public boolean isPossivelMovimentar(Sonda sonda, PosicionadorSondas posicionadorSondas) {

		if (sonda.getPosicaoY() > 0){
			return true;
		} else {
			return false;
		}
	}

}
