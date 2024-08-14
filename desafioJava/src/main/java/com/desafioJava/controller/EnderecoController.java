package com.desafioJava.controller;

import com.desafioJava.facade.EnderecoFacade;
import com.desafioJava.model.Endereco;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class EnderecoController {
	private Endereco endereco = new Endereco();

	@Inject
	private EnderecoFacade enderecoFacade;

	public void salvarEndereco() {
		enderecoFacade.salvar(endereco);
		endereco = new Endereco();
	}

	public void alterar() {
		enderecoFacade.alterar(endereco);
	}

	public void excluir(Endereco endereco) {
		enderecoFacade.excluir(endereco);
	}

	public Endereco buscarPorId(Long id) {
		return enderecoFacade.buscarPorId(id);
	}

	public List<Endereco> buscarTodos() {
		return enderecoFacade.buscarTodos();
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public EnderecoFacade getEnderecoFacade() {
		return enderecoFacade;
	}

	public void setEnderecoFacade(EnderecoFacade enderecoFacade) {
		this.enderecoFacade = enderecoFacade;
	}
}
