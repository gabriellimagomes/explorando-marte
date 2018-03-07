package br.com.gabriel.explorandomarte.app;

import java.util.Scanner;

import br.com.gabriel.explorandomarte.modelo.ExecutorMovimento;
import br.com.gabriel.explorandomarte.modelo.PosicionadorSondas;
import br.com.gabriel.explorandomarte.modelo.Sonda;
import br.com.gabriel.explorandomarte.modelo.enums.Direcao;
import br.com.gabriel.explorandomarte.modelo.exception.PosicaoSondaForaDoPlanaltoException;

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
			System.out.println("Movimentos (L|R|M):");
			String stringMovimentos = scanner.next();
			
			Sonda sonda = new Sonda(posicaoX, posicaoY, Direcao.getByLetra(direcao));
			ExecutorMovimento executorMovimento = ExecutorMovimentosFactory.criaMovimentos(stringMovimentos);
			
			try {
				posicionadorSondas.movimentaSonda(sonda, executorMovimento);
				System.out.println(String.format("Saida: X: %s Y: %s Direcao: %s", sonda.getPosicaoX(), sonda.getPosicaoY(), sonda.getDirecao().getLetra()));
			} catch (PosicaoSondaForaDoPlanaltoException e) {
				System.out.println("Movimento nao permitido. " + e.getMessage());
			}
			
			System.out.println();
		}
		
	}

}
