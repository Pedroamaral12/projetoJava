package com.desafioJava.model;

public enum Perfil {
	ADM("Administrador"), GERENTE("Gerente"), USUARIO("Usuário");

	private String descricao;

	Perfil(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
