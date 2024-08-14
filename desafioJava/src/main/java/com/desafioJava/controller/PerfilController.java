package com.desafioJava.controller;

import com.desafioJava.model.Perfil;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.Arrays;
import java.util.List;

@Named
@RequestScoped
public class PerfilController {

	public List<Perfil> getPerfis() {
		return Arrays.asList(Perfil.values());
	}
}
