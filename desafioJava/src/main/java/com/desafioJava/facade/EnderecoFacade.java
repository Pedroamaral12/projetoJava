package com.desafioJava.facade;

import com.desafioJava.model.Endereco;
import com.desafioJava.service.EnderecoService;

import java.util.List;

public class EnderecoFacade {
	private EnderecoService enderecoService;

	public EnderecoFacade() {
		enderecoService = new EnderecoService();
	}

	public List<Endereco> buscarTodosEnderecos() {
		return enderecoService.buscarTodosEnderecos();
	}
}
