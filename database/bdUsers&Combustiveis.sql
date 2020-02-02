-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 02-Fev-2020 às 20:35
-- Versão do servidor: 10.4.6-MariaDB
-- versão do PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `android_api`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `postoscombustivel`
--

CREATE TABLE `postoscombustivel` (
  `id` int(3) NOT NULL,
  `nome` varchar(50) CHARACTER SET utf8 NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `postoscombustivel`
--

INSERT INTO `postoscombustivel` (`id`, `nome`, `latitude`, `longitude`) VALUES
(1, 'Galp - Pernes', 39.384054, -8.660051),
(2, 'Galp Santarem', 39.24451, -8.688958),
(3, 'Galp - J.M.Cordeiro, Lda - N/S', 39.21145, -8.632713),
(4, 'Galp - J.M.Cordeiro, Lda - S/N', 39.21145, -8.632713),
(5, 'BP - A1 Santarem S/N', 39.391501, -8.638077),
(6, 'BP - A1 Santarem N/S', 39.393408, -8.640019),
(7, 'Prio - Alcanhoes', 39.298517, -8.660411),
(8, 'BP - Pe da Pedreira', 39.448373, -8.822941),
(9, 'Repsol - Pernes', 39.377194, -8.660908),
(10, 'BP - Santarem', 39.257334, -8.701136),
(11, 'Repsol - S. Pedro - Santarem', 39.249966, -8.695294),
(12, 'Repsol - Santarem', 39.243218, -8.696617),
(13, 'Pingo Doce - Santarem', 39.239361, -8.703315),
(14, 'E.Leclerc - Santarem', 39.246859, -8.692172),
(15, 'Gasprocar - Santarem', 39.302979, -8.685576);

-- --------------------------------------------------------

--
-- Estrutura da tabela `precoscombustivel`
--

CREATE TABLE `precoscombustivel` (
  `id` int(3) NOT NULL,
  `posto_Id` int(3) NOT NULL,
  `tipo` varchar(50) CHARACTER SET utf8 NOT NULL,
  `preço` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `precoscombustivel`
--

INSERT INTO `precoscombustivel` (`id`, `posto_Id`, `tipo`, `preço`) VALUES
(1, 13, 'Gasolina 95 Simples', 1.465),
(2, 13, 'Gasolina 98 Simples', 1.52),
(3, 13, 'Gasolina 98 Plus', 1.536),
(4, 13, 'Gasoleo Simples', 1.307),
(5, 15, 'Gasolina 95 Simples', 1.474),
(6, 15, 'Gasolina 98 Simples', 1.586),
(7, 15, 'Gasoleo Simples', 1.359),
(8, 15, 'Gasoleo Plus', 1.389),
(9, 6, 'Gasolina 95 Simples', 1.629),
(10, 6, 'Gasolina 98 Plus', 1.814),
(11, 6, 'Gasoleo Simples', 1.504),
(12, 6, 'Gasoleo Plus', 1.644),
(13, 6, 'GPL Auto', 0.814),
(14, 5, 'Gasolina 95 Simples', 1.629),
(15, 5, 'Gasolina 98 Plus', 1.814),
(16, 5, 'Gasoleo Simples', 1.504),
(17, 5, 'Gasoleo Plus', 1.644),
(18, 5, 'GPL Auto', 0.814),
(19, 1, 'Gasolina 95 Simples', 1.559),
(20, 1, 'Gasolina 95 Plus', 1.559),
(21, 1, 'Gasoleo Simples', 1.429),
(22, 1, 'Gasoleo Plus', 1.429),
(23, 2, 'Gasolina 95 Simples', 1.549),
(24, 2, 'Gasolina 95 Plus', 1.549),
(25, 2, 'Gasolina 98 Plus', 1.689),
(26, 2, 'Gasoleo Simples', 1.419),
(27, 2, 'Gasoleo Plus', 1.419),
(28, 3, 'Gasolina 95 Simples', 1.549),
(29, 3, 'Gasolina 95 Plus', 1.549),
(30, 3, 'Gasoleo Simples', 1.419),
(31, 3, 'Gasoleo Plus', 1.419),
(32, 3, 'GPL Auto', 0.759),
(33, 4, 'Gasolina 95 Simples', 1.549),
(34, 4, 'Gasolina 95 Plus', 1.549),
(35, 4, 'Gasoleo Simples', 1.419),
(36, 4, 'Gasoleo Plus', 1.419),
(37, 4, 'GPL Auto', 0.759),
(38, 8, 'Gasolina 95 Simples', 1.609),
(39, 8, 'Gasolina 98 Simples', 1.679),
(40, 8, 'Gasolina 98 Plus', 1.639),
(41, 8, 'Gasoleo Simples', 1.484),
(42, 9, 'Gasolina 95 Simples', 1.559),
(43, 9, 'Gasolina 95 Plus', 1.609),
(44, 9, 'Gasoleo Simples', 1.429),
(45, 9, 'Gasoleo Plus', 1.479),
(46, 7, 'Gasolina 95 Simples', 1.579),
(47, 7, 'Gasolina 95 Plus', 1.569),
(48, 7, 'Gasoleo Simples', 1.404),
(49, 7, 'Gasoleo Plus', 1.394),
(50, 11, 'Gasolina 95 Simples', 1.549),
(51, 11, 'Gasolina 98 Plus', 1.679),
(52, 11, 'Gasoleo Simples', 1.419),
(53, 11, 'Gasoleo Plus', 1.459),
(54, 14, 'Gasolina 95 Simples', 1.475),
(55, 14, 'Gasolina 95 Plus', 1.575),
(56, 14, 'Gasolina 98 Simples', 1.438),
(57, 14, 'Gasoleo Simples', 1.315),
(58, 14, 'Gasoleo Plus', 1.415),
(59, 14, 'GPL Auto', 0.755),
(60, 12, 'Gasolina 95 Simples', 1.549),
(61, 12, 'Gasolina 95 Plus', 1.589),
(62, 12, 'Gasoleo Simples', 1.419),
(63, 12, 'Gasoleo Plus', 1.459),
(64, 12, 'GPL Auto', 0.754),
(65, 10, 'Gasolina 95 Simples', 1.589),
(66, 10, 'Gasolina 98 Plus', 1.779),
(67, 10, 'Gasoleo Simples', 1.459),
(68, 10, 'Gasoleo Plus', 1.609);

-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `unique_id` varchar(23) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `encrypted_password` varchar(80) NOT NULL,
  `salt` varchar(10) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `users`
--

INSERT INTO `users` (`id`, `unique_id`, `name`, `email`, `encrypted_password`, `salt`, `created_at`, `updated_at`) VALUES
(1, '5df680332eb477.10645407', 'JRafa', 'test@test.com', 'T+eh3kKlyn5PbtSzsYdNZ+wL7McwMzIyMDI2Mzc0', '0322026374', '2019-12-15 18:49:23', NULL),
(2, '5df6866adf6bd8.70018264', 'Joao Rafael', 'jrafa@hotmail.com', 'KRlg4XsV14BhgT3wJ/WXxjn9BjRlMTMyYTZlNDEx', 'e132a6e411', '2019-12-15 19:15:54', NULL),
(3, '5e15e807a5f1b5.74923006', 'Teste8', 'teste8@teste.com', 'FTmnHStquvHHRT2JQpf3u3NjL0IwODY4NWJiYzE3', '08685bbc17', '2020-01-08 14:32:39', NULL),
(4, '5e2463605a9ff3.60374247', 'joao', 'joaoteste@teste.com', 'Pdkm+ejUMBbAYi6ct7CfZSYBtfI2ZGY5MzI0NzNk', '6df932473d', '2020-01-19 14:10:40', NULL),
(5, '5e3711edaa8d52.21020811', 'Teleteste', 'teleteste', '1R6Jx+7GNULlaQd9Co3kFC0MIAY1NDgzZjdhMDVl', '5483f7a05e', '2020-02-02 18:16:13', NULL);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `postoscombustivel`
--
ALTER TABLE `postoscombustivel`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `precoscombustivel`
--
ALTER TABLE `precoscombustivel`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_id` (`unique_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `postoscombustivel`
--
ALTER TABLE `postoscombustivel`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `precoscombustivel`
--
ALTER TABLE `precoscombustivel`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- AUTO_INCREMENT de tabela `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
