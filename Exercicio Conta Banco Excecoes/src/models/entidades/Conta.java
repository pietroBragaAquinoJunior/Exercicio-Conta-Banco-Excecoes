package models.entidades;

import models.excecoes.Excecao;

public class Conta {

	private Integer numero;
	private String nome;
	private Double saldo;
	private Double limiteSaque;
	
	public Conta(Integer numero, String nome, Double limiteSaque) throws Excecao {
		if(numero < 0) {
			throw new Excecao("A conta não pode ter número negativo.");
		}
		if(limiteSaque < 0) {
			throw new Excecao("A conta não pode ter limite de saque negativo.");
		}
		this.numero = numero;
		this.nome = nome;
		this.limiteSaque = limiteSaque;
	}
	
	public Conta(Integer numero, String nome, Double saldo, Double limiteSaque) throws Excecao {
		if(numero < 0) {
			throw new Excecao("A conta não pode ter número negativo.");
		}
		if(limiteSaque < 0) {
			throw new Excecao("A conta não pode ter limite de saque negativo.");
		}
		if(saldo < 0) {
			throw new Excecao("A conta não pode iniciar com saldo negativo.");
		}
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public Double getLimiteSaque() {
		return limiteSaque;
	}
	
	public void setLimiteSaque(Double limiteSaque) throws Excecao {
		if(limiteSaque < 0) {
			throw new Excecao("A conta não pode ter limite de saque negativo.");
		}
		this.limiteSaque = limiteSaque;
	}
	
	public void depositar(Double valor) throws Excecao {
		if(valor < 0) {
			throw new Excecao("O valor a ser depositado não pode ser negativo.");
		}
		this.saldo += valor;
	}
	
	public void sacar(Double valor) throws Excecao {
		if(valor < 0) {
			throw new Excecao("O valor a ser sacado não pode ser negativo.");
		}
		if(valor > this.saldo) {
			throw new Excecao("Não é permitido sacar mais do que o saldo da conta.");
		}
		if(valor > this.limiteSaque) {
			throw new Excecao("O valor a ser sacado não pode ultrapassar o limite.");
		}
		this.saldo -= valor;
	}
	
}
