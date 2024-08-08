package com.desafioJava.facade;

import com.desafioJava.model.Usuario;
import com.desafioJava.service.UsuarioService;

import java.util.List;

public class UsuarioFacade {
	private UsuarioService usuarioService;

	public UsuarioFacade() {
		this.usuarioService = new UsuarioService();
	}

	public void salvarUsuario(Usuario usuario) {
		usuarioService.salvar(usuario);
	}

	public void alterarUsuario(Usuario usuario) {
		usuarioService.alterar(usuario);
	}

	public void excluirUsuario(Usuario usuario) {
		usuarioService.excluir(usuario);
	}

	public Usuario buscarPorId(Long id) {
		return usuarioService.buscarPorId(id);
	}

	public List<Usuario> buscarTodos() {
		return usuarioService.buscarTodos();
	}
}
