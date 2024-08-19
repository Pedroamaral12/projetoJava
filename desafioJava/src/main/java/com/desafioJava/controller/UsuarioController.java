package com.desafioJava.controller;

import com.desafioJava.facade.EnderecoFacade;
import com.desafioJava.facade.UsuarioFacade;
import com.desafioJava.model.Endereco;
import com.desafioJava.model.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@RequestScoped
public class UsuarioController {

	private Usuario usuario = new Usuario();

	@Inject
	private UsuarioFacade usuarioFacade;

	@Inject
	private EnderecoFacade enderecoFacade;

	private String nomeFiltro;
	private String cpfFiltro;
	private Date dataInicioFiltro;
	private Date dataFimFiltro;

	private Integer id;
	private String dataFormatada;

	private List<Usuario> usuarios;
	private List<Endereco> enderecosSelecinados = new ArrayList<>();
	private List<Integer> idEnderecosSelecinados = new ArrayList<>();
	private Usuario usuarioSelecionado;

	@PostConstruct
	public void init() {
		buscarTodos();
	}

	public List<Usuario> buscarTodos() {
		usuarios = usuarioFacade.buscarTodos();

		return usuarios;
	}

	public void pesquisar() {
		usuarios = usuarioFacade.buscarComFiltros(nomeFiltro, cpfFiltro, dataInicioFiltro, dataFimFiltro);
	}

	public void limparFiltros() {
		nomeFiltro = null;
		cpfFiltro = null;
		dataInicioFiltro = null;
		dataFimFiltro = null;
		buscarTodos();
	}

	public void prepararEdicao() {
		if (usuarioSelecionado != null) {
			this.usuario = usuarioFacade.buscarPorId(usuarioSelecionado.getId());
			this.id = usuario.getId();
		}
	}

	public void prepararDetalhes() {
		dataFormatada = "";
		if (usuarioSelecionado != null) {
			usuarioSelecionado.setEnderecos(usuarioFacade.buscarEnderecosPorUsuario(usuarioSelecionado.getId()));
			formatDataCadastro();

		}
	}

	public void formatDataCadastro() {
		if (usuarioSelecionado != null && usuarioSelecionado.getDataCadastro() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			dataFormatada = sdf.format(usuarioSelecionado.getDataCadastro());
		}

	}

	public void cadastrarUsuario() {

		this.usuario.setDataCadastro(new Date());
		enderecosSelecinados.clear();
		for (Integer id : idEnderecosSelecinados) {

			Endereco endereco = enderecoFacade.buscarPorId(id);
			enderecosSelecinados.add(endereco);
		}

		usuario.setEnderecos(enderecosSelecinados);
		String nome = usuario.getNome();

		if (nome != null && !nome.isEmpty()) {
			if (usuario.getId() != null) {

				usuarioFacade.alterar(usuario);
				limparFormulario();

			} else {

				usuarioFacade.salvar(usuario);
				limparFormulario();

			}
		}

	}

	public void excluir() {
		usuarioFacade.excluir(usuarioSelecionado);
		buscarTodos();
	}

	private void limparFormulario() {
		idEnderecosSelecinados = new ArrayList<>();
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

	public EnderecoFacade getEnderecoFacade() {
		return enderecoFacade;
	}

	public void setEnderecoFacade(EnderecoFacade enderecoFacade) {
		this.enderecoFacade = enderecoFacade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Endereco> getEnderecosSelecinados() {
		return enderecosSelecinados;
	}

	public void setEnderecosSelecinados(List<Endereco> enderecosSelecinados) {
		this.enderecosSelecinados = enderecosSelecinados;
	}

	public List<Integer> getIdEnderecosSelecinados() {
		return idEnderecosSelecinados;
	}

	public void setIdEnderecosSelecinados(List<Integer> idEnderecosSelecinados) {
		this.idEnderecosSelecinados = idEnderecosSelecinados;
	}

	public String getDataFormatada() {
		return dataFormatada;
	}

	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}

}
