package br.com.gabriel.explorandomarte.modelo;

import java.util.List;

public class EntradaMovimentos implements ExecutorMovimento {

	private final List<ExecutorMovimento> executorMovimentos;

	public EntradaMovimentos(List<ExecutorMovimento> executorMovimentos) {
		this.executorMovimentos = executorMovimentos;
	}
	
	public void executaMovimento(Sonda sonda) {
		
		for (ExecutorMovimento executorMovimento : executorMovimentos) {
			executorMovimento.executaMovimento(sonda);
		}
	}

	
}
