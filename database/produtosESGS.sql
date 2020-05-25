-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 03-Dez-2019 às 18:33
-- Versão do servidor: 10.1.25-MariaDB
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
-- Banco de dados: `products`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `products1`
--

CREATE TABLE `products` (
  `id` bigint(20) NOT NULL,
  `name` varchar(528) COLLATE utf8_bin NOT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `products1`
--

INSERT INTO `products` (`id`, `name`) VALUES
(1006899027, 'Suspensão Smart PHILIPS HUE Beyond Colours'),
(1006899237, 'Plafon Philips Hue Beyond Colours'),
(1030992840, 'Kit SOMFY TaHoma serenity Essential Video'),
(1030992910, 'Kit Tahoma SOMFY Serenity Essential'),
(1032920984, 'Câmara NETGEAR ARLO Pro Kit 3 + Base');



--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `products1`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);
COMMIT;
--
-- Índices para tabela `products2`
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
