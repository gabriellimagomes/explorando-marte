package br.com.gabriel.explorandomarte.app;

import java.util.Scanner;

import br.com.gabriel.explorandomarte.modelo.PosicionadorSondas;
import br.com.gabriel.explorandomarte.modelo.Sonda;
import br.com.gabriel.explorandomarte.modelo.enums.Direcao;

public class ExplorandoMarteApp {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Posicao Limite X:");
		int posicaoLimiteX = scanner.nextInt();
		System.out.println("Posicao Limite Y:");
		int posicaoLimiteY = scanner.nextInt();
		PosicionadorSondas posicionadorSondas = new PosicionadorSondas(posicaoLimiteX, posicaoLimiteY);
		
		while (true) {
			
			System.out.println("Posicao X da Sonda:");
			int posicaoX = scanner.nextInt();
			System.out.println("Posicao Y da Sonda:");
			int posicaoY = scanner.nextInt();
			System.out.println("Direcao da Sonda (N|S|E|W):");
			String direcao = scanner.next();
			System.out.println("Movimentos:");
			String stringMovimentos = scanner.next();
			
			Sonda sonda = new Sonda(posicaoX, posicaoY, Direcao.getByLetra(direcao));
			posicionadorSondas.movimentaSonda(sonda, ExecutorMovimentosFactory.criaMovimentos(stringMovimentos, posicionadorSondas));
			
			System.out.println(String.format("Saída: %s %s %s", sonda.getPosicaoX(), sonda.getPosicaoY(), sonda.getDirecao().getLetra()));
			System.out.println("");
		}
		
	}

}
