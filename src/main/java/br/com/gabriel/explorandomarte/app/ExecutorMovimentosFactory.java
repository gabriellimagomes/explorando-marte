package br.com.gabriel.explorandomarte.app;

import java.util.LinkedList;
import java.util.List;

import br.com.gabriel.explorandomarte.modelo.EntradaMovimentos;
import br.com.gabriel.explorandomarte.modelo.ExecutorMovimento;
import br.com.gabriel.explorandomarte.modelo.Movimentador;
import br.com.gabriel.explorandomarte.modelo.PosicionadorSondas;
import br.com.gabriel.explorandomarte.modelo.ViradorDireita;
import br.com.gabriel.explorandomarte.modelo.ViradorEsquerda;

public class ExecutorMovimentosFactory {

	public static ExecutorMovimento criaMovimentos(String stringMovimentos, PosicionadorSondas posicionadorSondas) {
		
		String[] movimentos = stringMovimentos.split("");
		List<ExecutorMovimento> executoresMovimento = new LinkedList<ExecutorMovimento>();
		for (String movimento : movimentos) {
			
			switch (movimento) {
			case "L":
				executoresMovimento.add(new ViradorEsquerda());
				break;
			case "R":
				executoresMovimento.add(new ViradorDireita());
				break;
			case "M":
				executoresMovimento.add(new Movimentador(posicionadorSondas));
				break;

			default:
				break;
			}
		}
		
		return new EntradaMovimentos(executoresMovimento);
	}

}
