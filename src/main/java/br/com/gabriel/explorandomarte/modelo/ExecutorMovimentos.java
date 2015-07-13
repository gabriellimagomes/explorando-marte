package br.com.gabriel.explorandomarte.modelo;

import br.com.gabriel.explorandomarte.modelo.exception.PosicaoSondaForaDoPlanaltoException;

public interface ExecutorMovimentos {

	void executaMovimento(Sonda sonda) throws PosicaoSondaForaDoPlanaltoException;
}
