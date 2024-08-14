package com.desafioJava.facade;

import com.desafioJava.model.Endereco;
import com.desafioJava.service.EnderecoService;

import java.util.List;

public class EnderecoFacade {
	private EnderecoService enderecoService;

	public EnderecoFacade() {
		this.enderecoService = new EnderecoService();
	}

	public void salvar(Endereco endereco) {
		enderecoService.salvar(endereco);
	}

	public void alterar(Endereco endereco) {
		enderecoService.alterar(endereco);
	}

	public void excluir(Endereco endereco) {
		enderecoService.excluir(endereco);
	}

	public Endereco buscarPorId(Long id) {
		return enderecoService.buscarPorId(id);
	}

	public List<Endereco> buscarTodos() {
		return enderecoService.buscarTodos();
	}
}
