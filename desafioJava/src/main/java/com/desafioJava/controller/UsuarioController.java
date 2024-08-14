package com.desafioJava.controller;

import com.desafioJava.facade.UsuarioFacade;
import com.desafioJava.model.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Date;
import java.util.List;

@Named
@RequestScoped
public class UsuarioController {

	private Usuario usuario = new Usuario();

	@Inject
	private UsuarioFacade usuarioFacade;

	private String nomeFiltro;
	private String cpfFiltro;
	private Date dataInicioFiltro;
	private Date dataFimFiltro;

	private List<Usuario> usuarios;
	private Usuario usuarioSelecionado;

	public void pesquisar() {
		usuarios = usuarioFacade.buscarComFiltros(nomeFiltro, cpfFiltro, dataInicioFiltro, dataFimFiltro);
	}

	public void limparFiltros() {
		nomeFiltro = null;
		cpfFiltro = null;
		dataInicioFiltro = null;
		dataFimFiltro = null;
	}

	public void prepararEdicao() {
		if (usuarioSelecionado != null) {
			this.usuario = usuarioSelecionado;
		}
	}

	public void cadastrarUsuario() {
		usuarioFacade.salvar(this.usuario);
		limparFormulario();
	}

	private void limparFormulario() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioFacade getUsuarioFacade() {
		return usuarioFacade;
	}

	public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
		this.usuarioFacade = usuarioFacade;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getNomeFiltro() {
		return nomeFiltro;
	}

	public void setNomeFiltro(String nomeFiltro) {
		this.nomeFiltro = nomeFiltro;
	}

	public String getCpfFiltro() {
		return cpfFiltro;
	}

	public void setCpfFiltro(String cpfFiltro) {
		this.cpfFiltro = cpfFiltro;
	}

	public Date getDataInicioFiltro() {
		return dataInicioFiltro;
	}

	public void setDataInicioFiltro(Date dataInicioFiltro) {
		this.dataInicioFiltro = dataInicioFiltro;
	}

	public Date getDataFimFiltro() {
		return dataFimFiltro;
	}

	public void setDataFimFiltro(Date dataFimFiltro) {
		this.dataFimFiltro = dataFimFiltro;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
}
