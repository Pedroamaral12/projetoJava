package com.desafioJava.controller;

import com.desafioJava.facade.EnderecoFacade;
import com.desafioJava.model.Endereco;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class EnderecoController {
	private Endereco endereco = new Endereco();
	private List<Endereco> todosEnderecos;

	@Inject
	private EnderecoFacade enderecoFacade;

	@PostConstruct
	public void init() {
		buscarTodos();
	}

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

	public Endereco buscarPorId(Integer id) {
		return enderecoFacade.buscarPorId(id);
	}

	public List<Endereco> buscarTodos() {

		todosEnderecos = enderecoFacade.buscarTodos();
		return todosEnderecos;
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

	public List<Endereco> getTodosEnderecos() {
		return todosEnderecos;
	}

	public void setTodosEnderecos(List<Endereco> todosEnderecos) {
		this.todosEnderecos = todosEnderecos;
	}
}
