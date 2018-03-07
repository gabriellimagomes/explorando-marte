package br.com.gabriel.explorandomarte.modelo;

import br.com.gabriel.explorandomarte.modelo.exception.PosicaoSondaForaDoPlanaltoException;

public class Movimentador implements ExecutorMovimento {

	public void executaMovimento(Sonda sonda, PosicionadorSondas posicionadorSondas) {
		
		if (sonda.getDirecao().isPossivelMovimentar(sonda, posicionadorSondas)){
			
			sonda.movimenta();
		} else {
			
			throw new PosicaoSondaForaDoPlanaltoException(sonda.getPosicaoX(), 
													 sonda.getPosicaoY(), 
													 posicionadorSondas.getPosicaoLimiteX(), 
													 posicionadorSondas.getPosicaoLimiteY());
		}
	}

}
