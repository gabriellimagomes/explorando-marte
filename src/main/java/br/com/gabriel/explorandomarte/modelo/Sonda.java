package br.com.gabriel.explorandomarte.modelo;

import br.com.gabriel.explorandomarte.modelo.enums.Direcao;


public class Sonda {

	private Direcao direcao;

	public Sonda(Direcao direcaoInicial) {
		this.direcao = direcaoInicial;
	}

	public void virarParaEsquerda() {

		direcao = direcao.getDirecaoAEsquerda();
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void virarParaDireita() {
		
		direcao = direcao.getDirecaoADireita();
	}

}
