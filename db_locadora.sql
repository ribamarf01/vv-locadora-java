-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 12-Ago-2021 às 12:25
-- Versão do servidor: 10.4.20-MariaDB
-- versão do PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_locadora`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_aluguel`
--

CREATE TABLE `tb_aluguel` (
  `id` int(11) NOT NULL,
  `idPessoa` int(11) NOT NULL,
  `idFilme` int(11) NOT NULL,
  `dataAluguel` date NOT NULL,
  `dataDevolucao` date NOT NULL,
  `valorAluguel` double NOT NULL,
  `valorMulta` double NOT NULL,
  `estaPago` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_aluguel`
--

INSERT INTO `tb_aluguel` (`id`, `idPessoa`, `idFilme`, `dataAluguel`, `dataDevolucao`, `valorAluguel`, `valorMulta`, `estaPago`) VALUES
(1, 4, 1, '2021-08-11', '2021-08-15', 5.5, 0, 0),
(2, 4, 1, '2021-08-11', '2021-08-26', 16.5, 0, 0),
(3, 1, 1, '2021-08-11', '2021-08-25', 15.4, 2.5, 0),
(4, 4, 1, '2021-08-11', '2021-09-10', 33, 0, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_filme`
--

CREATE TABLE `tb_filme` (
  `id` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `descricao` text NOT NULL,
  `genero` varchar(40) NOT NULL,
  `ano` varchar(4) NOT NULL,
  `duracao` varchar(3) NOT NULL,
  `diretor` varchar(50) NOT NULL,
  `estudio` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_filme`
--

INSERT INTO `tb_filme` (`id`, `titulo`, `descricao`, `genero`, `ano`, `duracao`, `diretor`, `estudio`) VALUES
(1, 'Em busca do vale encantado II', 'Uns dinossarinhos fofos', 'Aventura', '1993', '120', 'Steven Spilberg', 'Disney');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_pessoa`
--

CREATE TABLE `tb_pessoa` (
  `id` int(11) NOT NULL,
  `nome_completo` varchar(100) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `data_nascimento` varchar(10) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_pessoa`
--

INSERT INTO `tb_pessoa` (`id`, `nome_completo`, `cpf`, `telefone`, `sexo`, `data_nascimento`, `endereco`, `email`) VALUES
(1, 'João Pessoa', '123.456.789-00', '00 12345-6789', 'M', '02/05/2001', 'Rua A', 'joao@email.com'),
(4, 'Ribamar Filho', '603.689.603-40', '85 98157-0039', 'M', '02/05/2001', 'Saul Gomes 25', 'ribamar.f01@gmail.com'),
(5, 'Dino da Silva Sauro', '987.654.321-00', '12 34567-8900', 'M', '25/11/1995', 'Pantano', 'dino@sauro.com');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_aluguel`
--
ALTER TABLE `tb_aluguel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPessoa` (`idPessoa`),
  ADD KEY `idFilme` (`idFilme`);

--
-- Índices para tabela `tb_filme`
--
ALTER TABLE `tb_filme`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_pessoa`
--
ALTER TABLE `tb_pessoa`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_aluguel`
--
ALTER TABLE `tb_aluguel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `tb_filme`
--
ALTER TABLE `tb_filme`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tb_pessoa`
--
ALTER TABLE `tb_pessoa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tb_aluguel`
--
ALTER TABLE `tb_aluguel`
  ADD CONSTRAINT `tb_aluguel_ibfk_1` FOREIGN KEY (`idPessoa`) REFERENCES `tb_pessoa` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `tb_aluguel_ibfk_2` FOREIGN KEY (`idFilme`) REFERENCES `tb_filme` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
