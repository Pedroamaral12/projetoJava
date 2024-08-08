package com.desafioJava.facade;

import com.desafioJava.model.Perfil;
import com.desafioJava.service.PerfilService;

import java.util.List;

public class PerfilFacade {
	private PerfilService perfilService;

	public PerfilFacade() {
		perfilService = new PerfilService();
	}

	public List<Perfil> buscarTodosPerfis() {
		return perfilService.buscarTodosPerfis();
	}
}
