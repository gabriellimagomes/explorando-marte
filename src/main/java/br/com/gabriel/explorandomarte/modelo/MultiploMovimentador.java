package br.com.gabriel.explorandomarte.modelo;

import java.util.List;

public class MultiploMovimentador implements ExecutorMovimento {

	private final List<ExecutorMovimento> executorMovimentos;

	public MultiploMovimentador(List<ExecutorMovimento> executorMovimentos) {
		this.executorMovimentos = executorMovimentos;
	}
	
	public void executaMovimento(Sonda sonda, PosicionadorSondas posicionadorSondas) {
		
		for (ExecutorMovimento executorMovimento : executorMovimentos) {
			executorMovimento.executaMovimento(sonda, posicionadorSondas);
		}
	}

	
}
