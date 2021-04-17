INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (1, 'Musica Electronica');
INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (2, 'Musica Urbana');
INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (4, 'Mariachis');
INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (5, 'banquetes');
INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (6, 'establesicimiento');
INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (7, 'transporte');
/*INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (8, 'Musica');
INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (9, 'Musica');
INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (10, 'Musica');
INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (11, 'Musica');
INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (12, 'Musica');
INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (13, 'Musica');
INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (14, 'Musica');
INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (15, 'Musica');
INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (16, 'Musica');
INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (17, 'Musica');
INSERT INTO CATEGORIAS(id_categoria, nombre_categoria) VALUES (18, 'Musica');*/
INSERT INTO public.estados
(id_estado, estado)
VALUES(1, 'Ocupado');
INSERT INTO public.estados
(id_estado, estado)
VALUES(2, 'Libre');

INSERT INTO DIRECCIONES(id_direccion, direccion, SERVICIOSid_servicio) VALUES (?, ?, ?);

INSERT INTO EVENTOS(numero_identificacion, id_orden, nombre_evento, id_evento) VALUES (?, ?, ?, ?);
INSERT INTO HORARIO(id_horario, fecha, hora) VALUES (?, ?, ?);
INSERT INTO MODULOS(id_modulo, nombre_modulo, descripcion_modulo) VALUES (?, ?, ?);
INSERT INTO ORDENES(id_orden, id_servicio, id_horario, id_estado, valor_total) VALUES (?, ?, ?, ?, ?);
INSERT INTO PERMISOS(id_roles, numero_identificacion, id_modulo) VALUES (?, ?, ?);
INSERT INTO ROLES(id_rol, nombre_rol, descripcion_rol) VALUES (?, ?, ?);
INSERT INTO SERVICIOS(id_categoria, id_servicio, nombre, proveedor, id_direccion) VALUES (?, ?, ?, ?, ?);
INSERT INTO TELEFONOS(id_telefono, telefono) VALUES (?, ?);
INSERT INTO TIPOS_DOCUMENTOS(tipo_documento, descripcion_corta, descripcion_larga) VALUES (?, ?, ?);
INSERT INTO USUARIOS(numero_identificacion, tipo_documento, nombre, fecha_nacimiento, telefonos, direccion, password) VALUES (?, ?, ?, ?, ?, ?, ?);
DELETE FROM CATEGORIAS