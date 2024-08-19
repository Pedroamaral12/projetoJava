package com.desafioJava.service;

import com.desafioJava.dao.EnderecoDAO;
import com.desafioJava.model.Endereco;

import java.util.List;

public class EnderecoService {
	private EnderecoDAO enderecoDAO;

	public EnderecoService() {
		this.enderecoDAO = new EnderecoDAO();
	}

	public void salvar(Endereco endereco) {
		enderecoDAO.salvar(endereco);
	}

	public void alterar(Endereco endereco) {
		enderecoDAO.alterar(endereco);
	}

	public void excluir(Endereco endereco) {
		enderecoDAO.excluir(endereco);
	}

	public Endereco buscarPorId(Integer id) {
		return enderecoDAO.buscarPorId(id);
	}

	public List<Endereco> buscarTodos() {
		return enderecoDAO.buscarTodos();
	}
}
