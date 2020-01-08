
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


CREATE TABLE `supermercados` (
  `id` bigint(20) NOT NULL,
  `name` varchar(528) COLLATE utf8_bin NOT NULL,
  `latitude` double NOT NULL,
   `longitude` double NOT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `supermercados` (`id`, `name`, `latitude`,`longitude`,`ultimoUpdate`) VALUES
(1,'Pingo Doce Santarém - Shopping W',39.233235, -8.684948),
(2,'Continente Santarém',39.243185, -8.687846),
(3,'E.lecrc',39.246896, -8.692143),
(4,'Pingo Doce-Sra. da Guia',39.247775, -8.692738),
(5,'Pingo Doce-S.Domingos',39.239383, -8.703284);


ALTER TABLE `supermercados`
  ADD PRIMARY KEY (`id`);
COMMIT;