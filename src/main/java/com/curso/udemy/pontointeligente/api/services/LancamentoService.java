package com.curso.udemy.pontointeligente.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.curso.udemy.pontointeligente.api.entities.Lancamento;

public interface LancamentoService {

	Lancamento persistir(Lancamento lancamento);

	Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);

	Optional<Lancamento> buscarPorId(Long id);

	void remover(Long id);
}