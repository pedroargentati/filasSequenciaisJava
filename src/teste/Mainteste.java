package teste;

import java.util.Scanner;
import FilasSequenciais.FilaSequencialInt;

public class Mainteste {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		FilaSequencialInt fila = new FilaSequencialInt();
		fila.init();
		int escolha = 0;

		while (escolha != 3) {
			System.out.println("\nSelecione uma opção: ");
			System.out.println("1- Inserir o aluno na Fila.");
			System.out.println("2- Retirar o aluno da Fila do atendimento.");
			System.out.println("3- Encerrar o programa");
			System.out.print("Sua escolha: ");
			escolha = teclado.nextInt();

			switch (escolha) {
			case 1:
				int rm = 0;
				System.out.println("\nInforme o RM que deseja inserir na fila: ");
				rm = teclado.nextInt();
				fila.enqueue(rm);
				break;

			case 2:
				if (fila.isEmpty()) {
					System.out.println("\nA fila está vazia. Não tem como retirar nada.");
					break;
				} else {
					System.out.println("\nElemento retirado da fila: " + fila.dequeue());
					break;
				}

			case 3:
				if (!fila.isEmpty()) {
					System.out.println("A fila ainda contém elementos! ");
					break;
				} else {
					System.out.println("Encerrando o programa! ");
					System.exit(0);
				}
				break;
			default:
				throw new IllegalArgumentException("Valor não está dentro dos padrões! : " + escolha);
			}

		}
		teclado.close();

	}

}
