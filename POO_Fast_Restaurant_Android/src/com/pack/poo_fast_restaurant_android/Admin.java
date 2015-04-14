package com.pack.poo_fast_restaurant_android;

public class Admin {
	
	private int id;
	private String nome;
	private String senha;
	
	public Admin(){}
	
	public Admin(int id, String nome, String senha){
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "id=" + id + ", nome=" + nome + ", senha=" + senha;
	}
	
	
	
}
