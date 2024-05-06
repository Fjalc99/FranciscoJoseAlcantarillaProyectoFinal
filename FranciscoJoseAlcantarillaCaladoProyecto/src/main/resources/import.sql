/*Socios*/
insert into socio (id, nombre, apellidos, telefono, email, direccion, provincia, codigo_Postal, dni, contrasenia, repetir_Contrasenia, fecha_De_Nacimiento) values (1,'Francisco','Alcantarilla Calado','98547894','fran@gmail.com','Calle Sevilla','Sevilla','41110','47841521N','calado','calado','1999-07-24');
insert into socio (id, nombre, apellidos, telefono, email, direccion, provincia, codigo_Postal, dni, contrasenia, repetir_Contrasenia, fecha_De_Nacimiento) values (2,'Marisa','Ortega Lucena','98547894','Marissa@gmail.com','Calle Cordoba','Córdoba','40010','478789521N','ortega','ortega','2004-03-17');
insert into socio (id, nombre, apellidos, telefono, email, direccion, provincia, codigo_Postal, dni, contrasenia, repetir_Contrasenia, fecha_De_Nacimiento) values (3,'Candi','Alcantarilla Calado','98547894','Candi@gmail.com','Calle Sevilla','Sevilla','41110','47841523N','calado','calado','2002-02-11');
insert into Socio (id, nombre, apellidos, telefono, email, direccion, provincia, codigo_Postal, dni, contrasenia, repetir_Contrasenia, fecha_De_Nacimiento) values (4,'Rosa','Ortega Lucena','98647894','Rosa@gmail.com','Calle Cordoba','Cordoba','40010','47841521S','ortega','ortega','2009-07-03');
--insert into Socio (id, nombre, apellidos, telefono, email, direccion, provincia, codigo_Postal, dni, contrasenia, repetir_Contrasenia, fecha_De_Nacimiento) values (5,'Francisco','Alcantarilla Calado','98547894','fran@gmail.com','Sevilla','Sevilla','41110','47841521N','calado','calado','24-07-1999');

ALTER SEQUENCE SOCIO_SEQ RESTART WITH (57)





-------------------------------------------
/*Productos*/

insert into producto (id, nombre, descripcion, precio, imagen) values (1,'Balon','balón del centario', 300.0, 'https://m.media-amazon.com/images/I/71XnnlWmbmL._AC_SL1500_.jpg');
insert into producto (id, nombre, descripcion, precio, imagen) values (2,'Balon de entramiento','balón con el entrenanmiento', 400.0, 'https://m.media-amazon.com/images/I/81dP3IFmfrL._AC_SL1500_.jpg');
insert into producto (id, nombre, descripcion, precio, imagen) values (3,'Equipación de entrenamiento de Isco','Equipación con la que entrena isco', 60.0, 'https://shop.realbetisbalompie.es/cdn/shop/files/222512-6143_2_1.jpg?crop=center&v=1714122436&width=960');
insert into producto (id, nombre, descripcion, precio, imagen) values (4,'Bufanda del derbi','Bufanda del derbi 23/24', 300.0, 'https://shop.realbetisbalompie.es/cdn/shop/files/000773_1.jpg?crop=center&v=1714122305&width=960');
insert into producto (id, nombre, descripcion, precio, imagen) values (5,'Bufanda del derbi','Bufanda del derbi 23/24', 300.0, 'https://shop.realbetisbalompie.es/cdn/shop/files/000773_1.jpg?crop=center&v=1714122305&width=960');
insert into producto (id, nombre, descripcion, precio, imagen) values (6,'Bufanda del derbi','Bufanda del derbi 23/24', 300.0, 'https://shop.realbetisbalompie.es/cdn/shop/files/000773_1.jpg?crop=center&v=1714122305&width=960');

ALTER SEQUENCE PRODUCTO_SEQ RESTART WITH (57)
