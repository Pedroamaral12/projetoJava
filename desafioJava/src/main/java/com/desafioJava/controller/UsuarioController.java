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
import java.util.List;

@Named
@ViewScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	private UsuarioFacade usuarioFacade;
	private PerfilFacade perfilFacade;
	private EnderecoFacade enderecoFacade;
	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Perfil> perfis;
	private List<Endereco> enderecos;

	@PostConstruct
	public void init() {
		usuarioFacade = new UsuarioFacade();
		perfilFacade = new PerfilFacade();
		enderecoFacade = new EnderecoFacade();
		usuario = new Usuario();
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
	}

	public void editar(Usuario usuario) {
		this.usuario = usuario;
	}

	public void excluir(Usuario usuario) {
		usuarioFacade.excluirUsuario(usuario);
		usuarios = usuarioFacade.buscarTodos();
	}

	public void detalhar(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
