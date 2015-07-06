package br.com.gabriel.explorandomarte.modelo;

import br.com.gabriel.explorandomarte.modelo.enums.Direcao;


public class Sonda {

	private Direcao direcao;
	private int posicaoX;
	private int posicaoY;

	public Sonda(int posicaoX, int posicaoY, Direcao direcaoInicial) {
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		this.direcao = direcaoInicial;
	}

	public void viraParaEsquerda() {

		direcao = direcao.getDirecaoAEsquerda();
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void viraParaDireita() {
		
		direcao = direcao.getDirecaoADireita();
	}

	public void movimenta() {
		
		if (Direcao.LESTE.equals(direcao) || Direcao.OESTE.equals(direcao)){
			posicaoX += direcao.getIncrementoPosicao();
		} else {
			posicaoY += direcao.getIncrementoPosicao();
		}
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

}
