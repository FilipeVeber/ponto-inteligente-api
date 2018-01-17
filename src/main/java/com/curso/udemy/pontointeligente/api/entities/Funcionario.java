package com.curso.udemy.pontointeligente.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.curso.udemy.pontointeligente.api.enums.EPerfil;

@Entity
@Table(name = "Funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private BigDecimal valorHora;
	private Float quantidadeHorasTrabalhoDia;
	private Float quantidadeHorasAlmoco;
	private EPerfil perfil;
	private Date dataCriacao;
	private Date dataAtualizacao;
	private Empresa empresa;
	private List<Lancamento> lancamentos;
	
	public Funcionario() {
	}
	
	public Funcionario(Long id, String nome, String email, String senha, String cpf, BigDecimal valorHora,
			Float quantidadeHorasTrabalhoDia, Float quantidadeHorasAlmoco, EPerfil perfil, Date dataCriacao,
			Date dataAtualizacao, Empresa empresa, List<Lancamento> lancamentos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.valorHora = valorHora;
		this.quantidadeHorasTrabalhoDia = quantidadeHorasTrabalhoDia;
		this.quantidadeHorasAlmoco = quantidadeHorasAlmoco;
		this.perfil = perfil;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
		this.empresa = empresa;
		this.lancamentos = lancamentos;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "nome", nullable = false)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "senha", nullable = false)
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Column(name = "cpf", nullable = false)
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Column(name = "valor_hora", nullable = true)
	public BigDecimal getValorHora() {
		return valorHora;
	}
	
	@Transient
	public Optional<BigDecimal> getValorHoraOpt() {
		return Optional.ofNullable(valorHora);
	}
	
	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}
	
	@Column(name = "quantidade_horas_trabalho_dia", nullable = true)
	public Float getQuantidadeHorasTrabalhoDia() {
		return quantidadeHorasTrabalhoDia;
	}
	
	@Transient
	public Optional<Float> getQuantidadeHorasTrabalhoDiaOpt() {
		return Optional.ofNullable(quantidadeHorasTrabalhoDia);
	}
	
	public void setQuantidadeHorasTrabalhoDia(Float quantidadeHorasTrabalhoDia) {
		this.quantidadeHorasTrabalhoDia = quantidadeHorasTrabalhoDia;
	}
	
	@Column(name = "quantidade_horas_almoco", nullable = true)
	public Float getQuantidadeHorasAlmoco() {
		return quantidadeHorasAlmoco;
	}
	
	@Transient
	public Optional<Float> getQuantidadeHorasAlmocoOpt() {
		return Optional.ofNullable(quantidadeHorasAlmoco);
	}
	
	public void setQuantidadeHorasAlmoco(Float quantidadeHorasAlmoco) {
		this.quantidadeHorasAlmoco = quantidadeHorasAlmoco;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	public EPerfil getPerfil() {
		return perfil;
	}
	
	public void setPerfil(EPerfil perfil) {
		this.perfil = perfil;
	}
	
	@Column(name = "data_criacao", nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	
	@Column(name = "data_atualizacao", nullable = false)
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	
	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", valorHora=" + valorHora + ", quantidadeHorasTrabalhoDia=" + quantidadeHorasTrabalhoDia
				+ ", quantidadeHorasAlmoco=" + quantidadeHorasAlmoco + ", perfil=" + perfil + ", dataCriacao="
				+ dataCriacao + ", dataAtualizacao=" + dataAtualizacao + ", empresa=" + empresa + ", lancamentos="
				+ lancamentos + "]";
	}	
}