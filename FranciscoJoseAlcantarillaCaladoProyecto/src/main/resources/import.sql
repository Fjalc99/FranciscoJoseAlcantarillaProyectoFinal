
insert into usuario (id, nombre, apellidos, telefono, email, direccion, provincia, codigo_Postal,dni,  username, password, fecha_De_Nacimiento, admin) values (1,'Francisco','Alcantarilla Calado','98547894','fran@gmail.com','Calle Sevilla','Sevilla','41110','47841521N','admin','{bcrypt}$2a$12$Sg2p/JrA978QMZ2uhDD8tuMTJQDQ1YlVA2zEw575nE9tVrhycFKoG','1999-07-24', true);
insert into usuario (id, nombre, apellidos, telefono, email, direccion, provincia, codigo_Postal, dni,  username, password, fecha_De_Nacimiento, admin) values (2,'Marisa','Ortega Lucena','98547894','Marissa@gmail.com','Calle Cordoba','Córdoba','40010','478789521N','user','{bcrypt}$2a$12$x9MpZl8ZkWabfdBp6XkkGuN0I5Cor9IBnhovAMCrX7MhoKNECr4Dm','2004-03-17', false);
insert into usuario (id, nombre, apellidos, telefono, email, direccion, provincia, codigo_Postal, dni,   username, password,  fecha_De_Nacimiento, admin) values (3,'Candi','Alcantarilla Calado','98547894','Candi@gmail.com','Calle Sevilla','Sevilla','41110','47841523N','candi','{bcrypt}$2a$12$1d0/AmJ8Fu9t3.nkUNsb/uRE/A.bkk6yj6yYSECUS6OWVw7k4rkg2','2002-02-11', false);
insert into usuario (id, nombre, apellidos, telefono, email, direccion, provincia, codigo_Postal, dni,  username, password, fecha_De_Nacimiento, admin) values (4,'Rosa','Ortega Lucena','98647894','Rosa@gmail.com','Calle Cordoba','Cordoba','40010','47841521S', 'Roortega','{bcrypt}$2a$12$Njor/e/7paxxCUdZRDYNRuy86cW2GFw2QBNvOgzNRoQlc7VoXSEmG','2009-07-03', true);
--insert into USUARIO (id, nombre, apellidos, telefono, email, direccion, provincia, codigo_Postal, dni,  username, password, fecha_De_Nacimiento, admin) values (5,'Francisco','Alcantarilla Calado','98547894','fran@gmail.com','Sevilla','Sevilla','41110','47841521N','calado','24-07-1999', true);

ALTER SEQUENCE USUARIO_SEQ RESTART WITH (57)




/*Categorias*/
insert into categoria (id, nombre_categoria) values (1,'Balones');
insert into categoria (id, nombre_categoria) values (2,'Equipación');
insert into categoria (id, nombre_categoria) values (3,'Accesorios');

ALTER SEQUENCE CATEGORIA_SEQ RESTART WITH (53)
----------------------------------------------------
/*Tallas*/

insert into talla (id, nombre_talla) values (1, 'XS')
insert into talla (id, nombre_talla) values (2, 'S')
insert into talla (id, nombre_talla) values (3, 'M')
insert into talla (id, nombre_talla) values (4, 'XL')
insert into talla (id, nombre_talla) values (5, 'XXL')


ALTER SEQUENCE TALLA_SEQ RESTART WITH (55)
-------------------------------------------
/*Productos*/

insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (1, 1, 'Balon','balón del centario', 300.0, 'https://m.media-amazon.com/images/I/71XnnlWmbmL._AC_SL1500_.jpg', 1);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (2, 1, 'Balon de entramiento','balón con el entrenanmiento', 400.0, 'https://m.media-amazon.com/images/I/81dP3IFmfrL._AC_SL1500_.jpg', 1);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (3, 3, 'Equipación de entrenamiento de Isco','Equipación con la que entrena isco', 60.0, 'https://shop.realbetisbalompie.es/cdn/shop/files/222512-6143_2_1.jpg?crop=center&v=1714122436&width=960', 2);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (4, 4, 'Bufanda del derbi','Bufanda del derbi 23/24', 300.0, 'https://shop.realbetisbalompie.es/cdn/shop/files/000773_1.jpg?crop=center&v=1714122305&width=960', 2);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (5, 4, 'Bufanda del derbi','Bufanda del derbi 23/24', 300.0, 'https://shop.realbetisbalompie.es/cdn/shop/files/000773_1.jpg?crop=center&v=1714122305&width=960', 3);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (6, 2, 'Bufanda del derbi','Bufanda del derbi 23/24', 300.0, 'https://shop.realbetisbalompie.es/cdn/shop/files/000773_1.jpg?crop=center&v=1714122305&width=960', 3);

ALTER SEQUENCE PRODUCTO_SEQ RESTART WITH (57)
-----------------------------------------------------------------------
/*Venta*/
insert into venta (finalizada, usuario_id ,total, id) values (false, 2, 20, 1)
insert into venta (finalizada, usuario_id ,total, id) values (true, 2, 20, 2)
insert into venta (finalizada, usuario_id ,total, id) values (true, 3, 20, 3)
insert into venta (finalizada, usuario_id ,total, id) values (false, 4, 20, 4)
insert into venta (finalizada, usuario_id ,total, id) values (false, 4, 20, 5)

ALTER SEQUENCE VENTA_SEQ RESTART WITH (1000)
---------------------------------------------------------------------
/*Linea de ventas*/
insert into linea_de_venta(id, producto_id, cantidad_producto, sub_total, venta_id) values (1, 1, 3, 10, 1)
insert into linea_de_venta(id, producto_id, cantidad_producto, sub_total, venta_id) values (2, 2, 2, 10, 2)
insert into linea_de_venta(id, producto_id, cantidad_producto, sub_total, venta_id) values (3, 3, 5, 10, 3)
insert into linea_de_venta(id, producto_id, cantidad_producto, sub_total, venta_id) values (4, 4, 6, 10, 4)
insert into linea_de_venta(id, producto_id, cantidad_producto, sub_total, venta_id) values (5, 5, 7, 10, 5)

ALTER SEQUENCE LINEA_DE_VENTA_SEQ RESTART WITH (1000)