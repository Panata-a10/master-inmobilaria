INSERT INTO movimientos (pk_movimimento, recomendacion) VALUES(1, 20);

INSERT INTO operaciones (pk_operacion, descripcion) VALUES(1, 'Venta');
INSERT INTO operaciones (pk_operacion, descripcion) VALUES(2, 'Renta');

INSERT INTO pagos (pk_pago, descripcion) VALUES(1, 'Transacion');
INSERT INTO pagos (pk_pago, descripcion) VALUES(2, 'Cambio');
INSERT INTO pagos (pk_pago, descripcion) VALUES(3, 'Cheque');

INSERT INTO tipo_inmobilarias (pk_tip_inmobilaria, descripcion) VALUES(1, 'Familiar');
INSERT INTO tipo_inmobilarias (pk_tip_inmobilaria, descripcion) VALUES(2, 'Suit');
INSERT INTO tipo_inmobilarias (pk_tip_inmobilaria, descripcion) VALUES(3, 'Departamento');
INSERT INTO tipo_inmobilarias (pk_tip_inmobilaria, descripcion) VALUES(4, 'Terreno');
INSERT INTO tipo_inmobilarias (pk_tip_inmobilaria, descripcion) VALUES(5, 'Inmueble');

INSERT INTO empresas (pk_empresa, direccion, nombre, telefono) VALUES(1, 'Ambato-Ficoa', 'Inmueble Puerto Asis', '032822550');
INSERT INTO empresas (pk_empresa, direccion, nombre, telefono) VALUES(2, 'Quito', 'Pichincha S.A', '032822550');
INSERT INTO empresas (pk_empresa, direccion, nombre, telefono) VALUES(3, 'Lago Agrio', 'Inmueble S.A', '032822550');



INSERT INTO usuarios(pk_usuario, apellidos, cedula, email, fecha_nacimiento, nombres, habilitado, nombre, password, id_empresa) VALUES (1,'Panata','1722403423','espanata@espe.edu.ec','1987-08-31','Santiago',1,'ADMIN','qwertyuiop',null);

INSERT INTO usuarios(pk_usuario, apellidos, cedula, email, fecha_nacimiento, nombres, habilitado, nombre, password, id_empresa) VALUES (2,'Mayorga','1722403423','mayorga@espe.edu.ec','1987-08-31','Tomas',1,'ANUN','qwertyuiop',1);

INSERT INTO usuarios(pk_usuario, apellidos, cedula, email, fecha_nacimiento, nombres, habilitado, nombre, password, id_empresa) VALUES (3,'Velasco','1722403423','velasco@espe.edu.ec','1987-08-31','Diego',1,'USER','qwertyuiop',null);

INSERT INTO roles(pk_rol, nombre, fk_usuario) VALUES (1,'ROLE_ADMIN',1);

INSERT INTO roles(pk_rol, nombre, fk_usuario) VALUES (2,'ROLE_ANUN',2);

INSERT INTO roles(pk_rol, nombre, fk_usuario) VALUES (3,'ROLE_USER',3);



