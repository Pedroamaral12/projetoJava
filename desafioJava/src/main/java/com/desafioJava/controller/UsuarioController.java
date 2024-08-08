package com.desafioJava.controller;

import com.desafioJava.facade.UsuarioFacade;
import com.desafioJava.facade.PerfilFacade;
import com.desafioJava.facade.EnderecoFacade;
import com.desafioJava.model.Usuario;
import com.desafioJava.model.Perfil;
import com.desafioJava.model.Endereco;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	private UsuarioFacade usuarioFacade;
	private PerfilFacade perfilFacade;
	private EnderecoFacade enderecoFacade;
	private Usuario usuario;
	private Usuario usuarioSelecionado;
	private Endereco novoEndereco;
	private List<Usuario> usuarios;
	private List<Perfil> perfis;
	private List<Endereco> enderecos;

	@PostConstruct
	public void init() {
		usuarioFacade = new UsuarioFacade();
		perfilFacade = new PerfilFacade();
		enderecoFacade = new EnderecoFacade();
		usuario = new Usuario();
		usuario.setEnderecos(new ArrayList<>());
		novoEndereco = new Endereco();
		usuarios = usuarioFacade.buscarTodos();
		perfis = perfilFacade.buscarTodosPerfis();
		enderecos = enderecoFacade.buscarTodosEnderecos();
	}

	public void salvar() {
		if (usuario.getId() == null) {
			usuarioFacade.salvarUsuario(usuario);
		} else {
			usuarioFacade.alterarUsuario(usuario);
		}
		usuarios = usuarioFacade.buscarTodos();
		usuario = new Usuario();
		usuario.setEnderecos(new ArrayList<>());
	}

	public void editar(Usuario usuario) {
		this.usuario = usuario;
	}

	public void excluir(Usuario usuario) {
		usuarioFacade.excluirUsuario(usuario);
		usuarios = usuarioFacade.buscarTodos();
	}

	public void prepararDetalhe(Usuario usuario) {
		this.usuarioSelecionado = usuario;
	}

	public void adicionarEndereco() {
		this.usuario.getEnderecos().add(novoEndereco);
		this.novoEndereco = new Endereco();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public Endereco getNovoEndereco() {
		return novoEndereco;
	}

	public void setNovoEndereco(Endereco novoEndereco) {
		this.novoEndereco = novoEndereco;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}
