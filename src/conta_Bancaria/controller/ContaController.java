package conta_Bancaria.controller;

import java.util.ArrayList;
import java.util.List;

import conta_Bancaria.model.Conta;
import conta_Bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	private List<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void listarTodas() {

		for (var conta : listaContas) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(Conta conta) {

		listaContas.add(conta);
		System.out.printf("A conta numero %d foi criada com sucesso%n", conta.getNumero());

	}

	@Override
	public void procurarPorNumero(int numero) {

		var conta = buscarNaCollection(numero);

		if (conta != null)
			conta.visualizar();
		else
			System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");

	}

	@Override
	public void atualizar(Conta conta) {

		var buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta != null) {

			listaContas.set(listaContas.indexOf(buscaConta), conta);

			System.out.println("\nA conta numero: " + conta.getNumero() + " foi atualizada com sucesso!");

		} else
			System.out.println("\nA Conta numero: " + conta.getNumero() + " não foi encontrada!");

	}

	@Override
	public void deletar(int numero) {

		var conta = buscarNaCollection(numero);

		if (conta != null) {

			if (listaContas.remove(conta) == true)
				System.out.println("\nA Conta numero: " + numero + " foi deletada com sucesso!");

		} else
			System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");

	}

	@Override
	public void sacar(int numero, float valor) {

		var conta = buscarNaCollection(numero);

		if (conta != null) {

			if (conta.sacar(valor)) {
				System.out.println("\nO Saque na Conta numero: " + numero + " foi efetuado com sucesso!");
			}

		} else {
			System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
		}

	}

	@Override
	public void depositar(int numero, float valor) {

		var conta = buscarNaCollection(numero);

		if (conta != null) {

			conta.depositar(valor);

			System.out.println("\nO Depósito na Conta numero: " + numero + " foi efetuado com sucesso!");

		} else {
			System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
		}

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {

		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem != null && contaDestino != null) {

			if (contaOrigem.sacar(valor)) {

				contaDestino.depositar(valor);

				System.out.println("\nA Transferência foi efetuada com sucesso!");

			}

		} else {
			System.out.println("\nA Conta de Origem e/ou Destino não foram encontradas!");
		}

	}

	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {

		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}

		return null;
	}

	

}
