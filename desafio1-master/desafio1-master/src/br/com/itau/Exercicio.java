package br.com.itau;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.itau.modelo.Lancamento;
import br.com.itau.service.LancamentoService;

public class Exercicio {

	public static void main(String[] args) {
		List<Lancamento> lancamentos = new LancamentoService().listarLancamentos();

		// Precisamos escrever no console os gastos ordenados por meses
		List<Lancamento> sortedList = lancamentos.stream()
				.sorted(Comparator.comparingInt(Lancamento::getMes)).collect(Collectors.toList());

		sortedList.forEach(System.out::println); System.out.println("\n  ** \n ");

		// Escrever todos os lancamentos de uma mesma categoria de sua escolha
		List<Lancamento> filterList = lancamentos.stream().filter(l -> l.getCategoria() == 1)
				.collect(Collectors.toList());

		filterList.forEach(System.out::println); System.out.println("\n  ** \n ");

				
		// Mostrar o total da fatura de um mes em específico de sua escolha
		 Double totalFatura = lancamentos.stream().filter(l -> l.getMes() == 7).
				 mapToDouble(l -> l.getValor()).sum();
		 
		 System.out.println("Total fatura: R$" +  totalFatura);
	}

}
