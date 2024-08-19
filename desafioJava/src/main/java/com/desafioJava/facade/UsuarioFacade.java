package com.desafioJava.facade;

import com.desafioJava.model.Endereco;
import com.desafioJava.model.Usuario;
import com.desafioJava.service.UsuarioService;

import java.util.Date;
import java.util.List;

public class UsuarioFacade {
	private UsuarioService usuarioService;

	public UsuarioFacade() {
		this.usuarioService = new UsuarioService();
	}

	public void salvar(Usuario usuario) {
		usuarioService.salvar(usuario);
	}

	public void alterar(Usuario usuario) {
		usuarioService.alterar(usuario);
	}

	public void excluir(Usuario usuario) {
		usuarioService.excluir(usuario);
	}

	public Usuario buscarPorId(Integer id) {
		return usuarioService.buscarPorId(id);
	}

	public List<Usuario> buscarTodos() {
		return usuarioService.buscarTodos();
	}

	public List<Usuario> buscarPorNome(String nome) {
		return usuarioService.buscarPorNome(nome);
	}

	public List<Endereco> buscarEnderecosPorUsuario(Integer id) {
		return usuarioService.buscarEnderecosPorUsuario(id);
	}

	public List<Usuario> buscarComFiltros(String nome, String cpf, Date dataInicio, Date dataFim) {
		return usuarioService.buscarComFiltros(nome, cpf, dataInicio, dataFim);
	}
}
