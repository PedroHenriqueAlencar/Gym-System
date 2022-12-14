-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 14-Dez-2022 às 04:52
-- Versão do servidor: 8.0.27
-- versão do PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `ab3`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `ra` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `login` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `senha` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `nivel` tinyint UNSIGNED DEFAULT '0',
  `acesso` tinyint UNSIGNED DEFAULT '0',
  PRIMARY KEY (`ra`)
) ENGINE=MyISAM AUTO_INCREMENT=1000017 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`ra`, `login`, `senha`, `nivel`, `acesso`) VALUES
(1000000, 'administrador', 'administrador', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `mensalidade`
--

DROP TABLE IF EXISTS `mensalidade`;
CREATE TABLE IF NOT EXISTS `mensalidade` (
  `ra` int UNSIGNED NOT NULL,
  `mes` varchar(10) DEFAULT NULL,
  `valor` double(4,0) UNSIGNED NOT NULL DEFAULT '0',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `datapag` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `formapag` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`ra`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `mensalidade`
--

INSERT INTO `mensalidade` (`ra`, `mes`, `valor`, `status`, `datapag`, `formapag`) VALUES
(1000014, 'Dezembro', 60, 'Pago', '14122022', 'Dinheiro');

-- --------------------------------------------------------

--
-- Estrutura da tabela `metricas`
--

DROP TABLE IF EXISTS `metricas`;
CREATE TABLE IF NOT EXISTS `metricas` (
  `ra` int UNSIGNED NOT NULL,
  `altura` double UNSIGNED DEFAULT NULL,
  `peso` double UNSIGNED DEFAULT NULL,
  `abdomem` double UNSIGNED DEFAULT NULL,
  `quadril` double UNSIGNED DEFAULT NULL,
  `peitoral` double UNSIGNED DEFAULT NULL,
  `braco` double UNSIGNED DEFAULT NULL,
  `perna` double UNSIGNED DEFAULT NULL,
  `datacadastro` varchar(12) DEFAULT NULL,
  `situacaocorporal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ra`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `metricas`
--

INSERT INTO `metricas` (`ra`, `altura`, `peso`, `abdomem`, `quadril`, `peitoral`, `braco`, `perna`, `datacadastro`, `situacaocorporal`) VALUES
(1000014, 1.1, 1, 2, 20.22, 1, 1, 1, '14122022', 'Regular');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `ra` int UNSIGNED DEFAULT NULL,
  `nome` varchar(30) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `cpf` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `datanasc` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `telefone` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `datamatricula` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `personal` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id`, `ra`, `nome`, `endereco`, `cpf`, `datanasc`, `telefone`, `datamatricula`, `personal`) VALUES
(9, 1000014, 'Teste01', 'Teste01', '12345678900', '01102000', '01234567890', '14122022', 1),
(10, 1000015, 'Teste02', 'Teste02', '11122233345', '25121986', '11944556677', '14122022', 0),
(1, 1000000, 'Administrador', 'Feira de Santana', '12345678900', '12345678', '12345678910', '12345678', 1),
(11, 1000016, 'eqweqwe', 'qwewqe', '00112233344', '05051555', '75983719402', '14122022', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
