-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 08-Dez-2022 às 04:49
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
  `login` varchar(23) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `senha` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `nivel` tinyint UNSIGNED DEFAULT '0',
  PRIMARY KEY (`ra`)
) ENGINE=MyISAM AUTO_INCREMENT=1000002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`ra`, `login`, `senha`, `nivel`) VALUES
(1000000, 'administrador', 'administrador', 1),
(1000001, 'Pedro', 'alencar9719', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `metricas`
--

DROP TABLE IF EXISTS `metricas`;
CREATE TABLE IF NOT EXISTS `metricas` (
  `ra` int UNSIGNED NOT NULL,
  `altura` decimal(4,0) UNSIGNED DEFAULT '0',
  `peso` decimal(4,0) UNSIGNED DEFAULT '0',
  `abdomem` decimal(4,0) UNSIGNED DEFAULT '0',
  `quadril` decimal(4,0) UNSIGNED DEFAULT '0',
  `peitoral` decimal(4,0) UNSIGNED DEFAULT '0',
  `braco` decimal(4,0) UNSIGNED DEFAULT '0',
  `perna` decimal(4,0) UNSIGNED DEFAULT '0',
  `datacadastro` varchar(12) DEFAULT NULL,
  `situacaocorporal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ra`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
  `cpf` int UNSIGNED DEFAULT NULL,
  `datanasc` varchar(12) DEFAULT NULL,
  `telefone` int UNSIGNED DEFAULT NULL,
  `datamatricula` varchar(12) DEFAULT NULL,
  `personal` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id`, `ra`, `nome`, `endereco`, `cpf`, `datanasc`, `telefone`, `datamatricula`, `personal`) VALUES
(1, 0, 'administrador', 'rua politeama 111', 4294967295, '10/08/1997', 4294967295, '05/12/2022', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
