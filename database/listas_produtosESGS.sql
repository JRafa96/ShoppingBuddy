CREATE TABLE `listas_produtos` (
  `id_listasproduct` int(11) NOT NULL ,
  `id_lista` int(11) NOT NULL ,
  'id_products' bigint(20) NOT NULL,
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

  INSERT INTO `listas_produtos` (`id_listasproduct`,`id_lista`, `id_products`, `price`) VALUES
(null,1, 1006899027, 680.74),
(null,1, 1006899027,700.5),
(null,1, 1006899027,200.0)
(null,1, 1006899027,150.0),

(null,6, 1006899237, 499.9),
(null,6,1006899237,200.5),
(null,6, 1006899237,350.0),
(null,6,1006899237,300),

(null, 1030992840, 792.41),
(null,1030992840,610.99),
(null,1030992840,507.35),
(null,1030992840,750.00),

(null, 1030992910, 549.49),
(null,1030992910,500.99),
(null,1030992910,499.35),
(null,1030992910,450.00),

(null, 1032920984, 612.92),
(null,1032920984,600.99),
(null,1032920984,599.35),
(null,1032920984,610.00),

(null, 1036353270, 478.43),
(null,1036353270,400.99),
(null,1036353270,430.35),
(null,1036353270,410.00);

ALTER TABLE `listas`
  ADD PRIMARY KEY (`id_listasproduct`);

ALTER TABLE 'lista_products'
ADD FOREIGN KEY ('id_lista') REFERENCES lista('id_listas');

ALTER TABLE 'lista_products'
ADD FOREIGN KEY ('id_user') REFERENCES users('id');

ALTER TABLE `lista_products`
  MODIFY `id_lista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

  ALTER TABLE `lista_products`
  MODIFY `id_listasproduct` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;
