package com.desafioJava.service;

import com.desafioJava.dao.UsuarioDAO;
import com.desafioJava.model.Usuario;

import java.util.List;

public class UsuarioService {
	private UsuarioDAO usuarioDAO;

	public UsuarioService() {
		this.usuarioDAO = new UsuarioDAO();
	}

	public void salvar(Usuario usuario) {
		usuarioDAO.salvar(usuario);
	}

	public void alterar(Usuario usuario) {
		usuarioDAO.alterar(usuario);
	}

	public void excluir(Usuario usuario) {
		usuarioDAO.excluir(usuario);
	}

	public Usuario buscarPorId(Long id) {
		return usuarioDAO.buscarPorId(id);
	}

	public List<Usuario> buscarTodos() {
		return usuarioDAO.buscarTodos();
	}
}
