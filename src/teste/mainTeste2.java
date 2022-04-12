package teste;

import java.util.Scanner;

import FilasSequenciais.FilaSequencialInt;

public class mainTeste2 {

	public static void main(String[] args) {
		FilaSequencialInt fila = new FilaSequencialInt();
		fila.init();

		Scanner teclado = new Scanner(System.in);
		fila.init();
		int escolha = 0;

		while (escolha != 3) {
			System.out.println("\n--------*Selecione uma op��o*--------: ");
			System.out.println("1- 	Inserir um processo na fila. ");
			System.out.println("2- 	Executar o processo. ");
			System.out.println("3- 	Encerrar o programa. ");
			System.out.print("Sua escolha: ");
			escolha = teclado.nextInt();

			switch (escolha) {
			case 1:
				int processo = 0;
				System.out.print("\nInforme o PID do processo que deseja inserir na fila: ");
				processo = teclado.nextInt();
				fila.enqueue(processo);
				break;

			case 2:
				int pid = fila.dequeue();
				if (fila.isEmpty()) {
					System.out.println("\nA fila est� vazia. N�o tem como retirar nada.");
				} else {
					String desejo = "";
					System.out.println("Voc� deseja mesmo encerrar a execu��o " + pid + " (Sim/N�o)");
					desejo = teclado.next();
					if (desejo.equals("sim")) {
						System.out.println("Elemento retirado.");
					} else {
						System.out.println("Processo n�o foi retirado da fila. Seguindo com a execu��o.");
						fila.enqueue(pid);
					}
//					System.out.println("\nProcesso retirado da fila: " + fila.dequeue());
				}
				break;
			case 3:
				if (!fila.isEmpty()) {
					String desejo = "";
					System.out.print("Voc� deseja mesmo encerrar todos os processos? (Sim/N�o)");
					desejo = teclado.next();
					if (desejo.equalsIgnoreCase("sim")) {
						while (!fila.isEmpty()) {
							System.out.println("Processo retirado: " + fila.dequeue());
						}
						System.out.println("Todos os processos foram finalizados! ");
					} else {
						escolha = 0;
						System.out.println("Os processos ainda continuam em execu��o.");
					}
					break;
				}
			default:
				throw new IllegalArgumentException("Escolha '" + escolha + "' n�o est� dentro dos padr�es exigidos. ");

			}
		}
		teclado.close();
	}

}