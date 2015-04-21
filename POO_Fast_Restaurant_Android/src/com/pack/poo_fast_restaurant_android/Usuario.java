package com.pack.poo_fast_restaurant_android;

public class Usuario {
	
	private int cpf;
	private int senha;
	private String nome;
	private int idade;
	private int telefone;
	
	public Usuario(){
		
	}

	public Usuario(int cpf, int senha, String nome, int idade, int telefone) {
		super();
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		this.idade = idade;
		this.telefone = telefone;
	}

	//--------------GETS E SETS!-------------------------
	
	public int getCpf() {
		return this.cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getSenha() {
		return this.senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getTelefone() {
		return this.telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

}
