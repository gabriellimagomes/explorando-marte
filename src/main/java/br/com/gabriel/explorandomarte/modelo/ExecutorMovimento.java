package br.com.gabriel.explorandomarte.modelo;

import br.com.gabriel.explorandomarte.modelo.exception.PosicaoSondaForaDoPlanaltoException;

public interface ExecutorMovimento {

	void executaMovimento(Sonda sonda) throws PosicaoSondaForaDoPlanaltoException;
}
