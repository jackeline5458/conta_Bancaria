package conta_Bancaria;


import java.util.InputMismatchException;
import java.util.Scanner;

import conta_Bancaria.controller.ContaController;
import conta_Bancaria.model.ContaCorrente;
import conta_Bancaria.model.ContaPoupanca;
import conta_Bancaria.util.Cores;

public class Menu {
	  
	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();
	
	public static void main(String[] args) {
		
			
			
			
			
		
		int opcao;

		while (true) {
			

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO Bradesco COM S               ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro!");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco Bradesco com  S - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
				cadastrarConta();
				keyPress();

				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				

				listarContas();
				keyPress();

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
				
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
				
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}

	
	private static void cadastrarConta() {
		 int agencia, tipo, aniversario;
		    String titular;
		    float saldo, limite;

		    System.out.println("Digite o Numero da Agência: ");
		    agencia = leia.nextInt();

		    System.out.println("Digite o Nome do Titular: ");
		    leia.skip("\\R");
		    titular = leia.nextLine();

		    System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
		    tipo = leia.nextInt();

		    System.out.println("Digite o Saldo da Conta (R$): ");
		    saldo = leia.nextFloat();

		    switch (tipo) {

		        case 1 -> {
		            System.out.println("Digite o Limite de Crédito (R$): ");
		            limite = leia.nextFloat();

		            contaController.cadastrar(new ContaCorrente(
		                    contaController.gerarNumero(),
		                    agencia,
		                    tipo,
		                    titular,
		                    saldo,
		                    limite));
		        }

		        case 2 -> {
		            System.out.println("Digite o dia do Aniversario da Conta: ");
		            aniversario = leia.nextInt();

		            contaController.cadastrar(new ContaPoupanca(
		                    contaController.gerarNumero(),
		                    agencia,
		                    tipo,
		                    titular,
		                    saldo,
		                    aniversario));
		        }

		        default -> System.out.println("Tipo de conta inválido!");
		    }

		    leia.nextLine();
		}
		
	


	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por:Jackeline Pessoa Gomes  ");
		System.out.println("Generation Brasil -jackelinepessoa0@gmail.com");
		System.out.println("https://github.com/jackeline5458/conta_Bancaria");
		System.out.println("*********************************************************");
		
	}
	
	private static void listarContas() {
		contaController.listarTodas();
	}
	
	private static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
		leia.nextLine();
		
	}

}
