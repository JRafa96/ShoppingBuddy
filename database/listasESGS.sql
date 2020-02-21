CREATE TABLE `listas` (
  `id_lista` int(11) ,
  `id_user` int(11) NOT NULL,
  `nome_lista` varchar(255) NOT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


INSERT INTO `listas` (`id_lista`, `id_user`, `nome_lista`) VALUES
(null, 1, 'Pequeno-Almoço'),
(null,1,'Mensal'),
(null,1,'Jantar'),


(null, 2, 'Ginasio'),
(null,2,'Vegetariano'),
(null,2,'Simples'),

(null, 3, 'Muher'),
(null,3,'Filhos'),
(null,3,'Pais'),

(null, 6, 'Pequeno-Almoço'),
(null,6,'Mensal'),
(null,6,'Jantar');


ALTER TABLE `listas`
  ADD PRIMARY KEY (`id_lista`);

ALTER TABLE `listas`
ADD FOREIGN KEY (`id_user`) REFERENCES users(`id`);


ALTER TABLE `listas`
  MODIFY `id_lista` int(11) NOT NULL AUTO_INCREMENT;


COMMIT;