/*
 *SQL datos base de datos 
 * SELECT DATOS 
 * 
 * */


select * from categorias;
SELECT * FROM USUARIOS;
SELECT * FROM TIPOS_DOCUMENTOS;
select * from servicios;
/*
 * BORRADO DE LOS DATOS 
 * 
 * */
delete from servicios;
delete from servicios where id_servicio= 45;
delete from categorias;

/*
 * Insertar data 
 */
insert into categorias values (1,'Cosina');
insert into categorias values (2,'Comida');
insert into categorias values (3,'DJ (disc-jockey)');