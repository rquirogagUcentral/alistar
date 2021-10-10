/*
 *SQL datos base de datos 
 * SELECT DATOS 
 * 
 * */


select * from categorias;
SELECT * FROM USUARIOS;
SELECT * FROM TIPOS_DOCUMENTOS;
select * from servicios;
select * from eventos;
select * from Prueba;

/*
 * BORRADO DE LOS DATOS 
 * 
 * */
delete from servicios;
delete from servicios where id_servicio= 45;
delete from categorias;
delete from usuarios u where u.numero_identificacion =999999999;

/*
 * Insertar data 
 */
insert into categorias values (1,'Cosina');
insert into categorias values (2,'Comida');
insert into categorias values (3,'DJ (disc-jockey)');




 



