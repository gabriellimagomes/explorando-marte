package br.com.gabriel.explorandomarte.modelo.enums;

import br.com.gabriel.explorandomarte.modelo.PosicionadorSondas;
import br.com.gabriel.explorandomarte.modelo.Sonda;
import br.com.gabriel.explorandomarte.modelo.VerificadorMovimento;

public class VerificadorMovimentoNorte implements VerificadorMovimento {

	public boolean isPossivelMovimentar(Sonda sonda, PosicionadorSondas posicionadorSondas) {

		if (sonda.getPosicaoY() < posicionadorSondas.getPosicaoLimiteY()){
			return true;
		} else {
			return false;
		}
	}

}
