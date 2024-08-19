package com.desafioJava.util;

import com.desafioJava.model.Endereco;
import com.desafioJava.facade.EnderecoFacade;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
@FacesConverter(value = "enderecoConverter", managed = true)
public class EnderecoConverter implements Converter<Endereco> {

	@Inject
	private EnderecoFacade enderecoFacade;

	@Override
	public Endereco getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}
		try {
			Integer id = Integer.valueOf(value);
			return enderecoFacade.buscarPorId(id);
		} catch (NumberFormatException e) {
			throw new ConverterException("Erro de conversão: o valor não é um ID de endereço válido.", e);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Endereco endereco) {
		if (endereco == null) {
			return "";
		}
		return String.valueOf(endereco.getId());
	}
}
