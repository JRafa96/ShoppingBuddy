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

CREATE TABLE `products_supermercados` (
  `id_Supermercados` bigint(20) NOT NULL ,
  `id_Produtos` bigint(528)  NOT NULL foreign key products,
  `price` double NOT NULL,
  foreign key (id_Supermercados) references supermercados(id),
  foreign key (id_Produtos) references products(id)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `products1`
--

INSERT INTO `products_supermercados` (`id_supermercados`, `id_Produtos`, `price`) VALUES
(1, 1006899027, 680.74),
(2,1006899027,700.5),
(4,1006899027,200.0)
(5,1006899027,150.0),

(1, 1006899237, 499.9),
(2,1006899237,200.5),
(4,1006899237,350.0),
(5,1006899237,300),

(1, 1030992840, 792.41),
(2,1030992840,610.99),
(4,1030992840,507.35),
(5,1030992840,750.00),

(1, 1030992910, 549.49),
(2,1030992910,500.99),
(4,1030992910,499.35),
(5,1030992910,450.00),

(1, 1032920984, 612.92),
(2,1032920984,600.99),
(4,1032920984,599.35),
(5,1032920984,610.00),

(1, 1036353270, 478.43),
(2,1036353270,400.99),
(4,1036353270,430.35),
(5,1036353270,410.00);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `products1`
--
ALTER TABLE `products1`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `products2`
--
ALTER TABLE `products2`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
