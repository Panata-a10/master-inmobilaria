DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `inmuebleusuario`()
    NO SQL
select inm.nombre, inm.creado_por from usuarios as us
INNER JOIN inmobilarias as inm ON us.pk_usuario = inm.id_usuario order by us.nombre, inm.creado_por asc$$
DELIMITER ;