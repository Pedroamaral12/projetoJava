package com.desafioJava.service;

import com.desafioJava.dao.EnderecoDAO;
import com.desafioJava.model.Endereco;

import java.util.List;

public class EnderecoService {
	private EnderecoDAO enderecoDAO;

	public EnderecoService() {
		enderecoDAO = new EnderecoDAO();
	}

	public List<Endereco> buscarTodosEnderecos() {
		return enderecoDAO.buscarTodosEnderecos();
	}
}
