CREATE TABLE `Empresa` (
	`id` bigint(20) NOT NULL,
	`cnpj` varchar(255) NOT NULL,
	`data_criacao` datetime NOT NULL,
	`data_atualizacao` datetime NOT NULL,
	`razao_social` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Funcionario` (
	`id` bigint(20) NOT NULL,
	`cpf` varchar(255) NOT NULL,
	`data_criacao` datetime NOT NULL,
	`data_atualizacao` datetime NOT NULL,
	`email` varchar(255) NOT NULL,
	`nome` varchar(255) NOT NULL,
	`perfil` varchar(255) NOT NULL,
	`quantidade_horas_almoco` float DEFAULT NULL,
	`quantidade_horas_trabalho_dia` float DEFAULT  NULL,
	`senha` varchar (255) NOT NULL,
	`valor_hora` decimal(19,2) DEFAULT  NULL,
	`id_empresa` bigint(20) DEFAULT  NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Lancamento` (
	`id` bigint(20) NOT NULL,
	`data` datetime NOT NULL,
	`data_criacao` datetime NOT NULL,
	`data_atualizacao` datetime NOT NULL,
	`descricao` varchar(255) DEFAULT NULL,
	`localizacao` varchar(255) DEFAULT NULL,
	`tipo` varchar(255) NOT NULL,
	`id_funcionario` bigint(20) DEFAULT  NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


---
--- Indexes for table `Empresa`
---

ALTER TABLE `Empresa`
	ADD PRIMARY KEY (`id`);

---
--- Indexes for table `Funcionario`
---

ALTER TABLE `Funcionario`
	ADD PRIMARY KEY (`id`),
	ADD KEY `FK_id_empresa` (`id_empresa`);

---
--- Indexes for table `Lancamento`
---

ALTER TABLE `Lancamento`
	ADD PRIMARY KEY (`id`),
	ADD KEY `FK_id_funcionario` (`id_funcionario`);
	
---
--- AUTO_INCREMENT for table `Empresa`
---

ALTER TABLE `Empresa`
	MODIFY `id`	bigint(20) NOT NULL AUTO_INCREMENT;
	
---
--- AUTO_INCREMENT for table `Funcionario`
---

ALTER TABLE `Funcionario`
	MODIFY `id`	bigint(20) NOT NULL AUTO_INCREMENT;
	
---
--- AUTO_INCREMENT for table `Lancamento`
---

ALTER TABLE `Lancamento`
	MODIFY `id`	bigint(20) NOT NULL AUTO_INCREMENT;
	
---
--- Constraints for dumped tables
---

---
--- Constraints for table `Funcionario`
---

ALTER TABLE `Funcionario`
	ADD CONSTRAINT `FK_id_empresa` FOREIGN KEY (`id_empresa`) REFERENCES `Empresa` (`id`);
	
---
--- Constraints for table `Lancamento`
---

ALTER TABLE `Lancamento`
	ADD CONSTRAINT `FK_id_funcionario` FOREIGN KEY (`id_funcionario`) REFERENCES `Funcionario` (`id`);