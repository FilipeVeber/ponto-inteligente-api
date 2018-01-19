package com.curso.udemy.pontointeligente.api.services;

import java.util.Optional;

import com.curso.udemy.pontointeligente.api.entities.Empresa;

public interface EmpresaService {

	Optional<Empresa> buscarPorCnpj(String cnpj);
	
	Empresa persistir(Empresa empresa);
}