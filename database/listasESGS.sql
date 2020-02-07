CREATE TABLE `listas` (
  `id_lista` bigint(20) NOT NULL ,
  'id_user' bigint(20) NOT NULL,
  'nome_lista' varchar(255) NOT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


INSERT INTO `lista` (`id_lista`, `id_user`, `nome_lista`) VALUES
(1, 1, 'Pequeno-Almoço'),
(2,1,'Mensal'),
(4,1,'Jantar'),


(1, 2, 'Ginasio'),
(2,2,'Vegetariano'),
(4,2,'Simples'),

(1, 3, 'Muher'),
(2,3,'Filhos'),
(4,3,'Pais');