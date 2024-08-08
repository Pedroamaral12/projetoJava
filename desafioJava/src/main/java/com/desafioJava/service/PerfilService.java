package com.desafioJava.service;

import com.desafioJava.dao.PerfilDAO;
import com.desafioJava.model.Perfil;

import java.util.List;

public class PerfilService {
	private PerfilDAO perfilDAO;

	public PerfilService() {
		perfilDAO = new PerfilDAO();
	}

	public List<Perfil> buscarTodosPerfis() {
		return perfilDAO.buscarTodosPerfis();
	}
}
