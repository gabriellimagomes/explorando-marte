package br.com.gabriel.explorandomarte.modelo;

import br.com.gabriel.explorandomarte.modelo.exception.PosicaoSondaForaDoPlanaltoException;

public class Movimentador implements ExecutorMovimentos {

	private final PosicionadorSondas posicionadorSondas;

	public Movimentador(PosicionadorSondas posicionadorSondas) {
		this.posicionadorSondas = posicionadorSondas;
	}

	public void executaMovimento(Sonda sonda) {
		
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
