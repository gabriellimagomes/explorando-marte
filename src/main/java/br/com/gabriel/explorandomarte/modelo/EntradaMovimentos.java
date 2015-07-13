package br.com.gabriel.explorandomarte.modelo;

import java.util.List;

public class EntradaMovimentos implements ExecutorMovimentos {

	private final List<ExecutorMovimentos> executorMovimentos;

	public EntradaMovimentos(List<ExecutorMovimentos> executorMovimentos) {
		this.executorMovimentos = executorMovimentos;
	}
	
	public void executaMovimento(Sonda sonda) {
		
		for (ExecutorMovimentos executorMovimento : executorMovimentos) {
			executorMovimento.executaMovimento(sonda);
		}
	}

	
}
