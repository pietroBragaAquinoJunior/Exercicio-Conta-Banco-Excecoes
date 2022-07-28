package main;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import models.entidades.Conta;
import models.excecoes.Excecao;

public class Main {

	public static void main(String[] args) {
		
		/* O programa lê informações para criação de uma conta. */
		/* Posteriormente é realizado o saque da conta. */
		/* Programa em java para resolução de exceções de forma profissional. */
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Número: ");
			Integer numero = sc.nextInt();
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.print("Saldo inicial: ");
			Double saldo = sc.nextDouble();
			System.out.print("Limite de saque inicial: ");
			Double limiteSaque = sc.nextDouble();
			Conta conta = new Conta(numero, nome, saldo, limiteSaque);
			System.out.print("Digite o valor do saque: ");
			Double saque = sc.nextDouble();
			conta.sacar(saque);
			System.out.println("Novo saldo: "+ conta.getSaldo());
		}
		catch (Excecao e) {
			System.out.println(e);
		}
		catch(InputMismatchException e) {
			System.out.println("Por favor digite o valor corretamente.");
		}
			
		sc.close();
		
	}

}
