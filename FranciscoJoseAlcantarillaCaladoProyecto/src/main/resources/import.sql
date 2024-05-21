
insert into usuario (id, nombre, apellidos, telefono, email, direccion, provincia, codigo_Postal,dni,  username, password, fecha_De_Nacimiento, admin) values (1,'Francisco','Alcantarilla Calado','98547894','fran@gmail.com','Calle Sevilla','Sevilla','41110','47841521N','admin','{bcrypt}$2a$12$Sg2p/JrA978QMZ2uhDD8tuMTJQDQ1YlVA2zEw575nE9tVrhycFKoG','1999-07-24', true);
insert into usuario (id, nombre, apellidos, telefono, email, direccion, provincia, codigo_Postal, dni,  username, password, fecha_De_Nacimiento, admin) values (2,'Marisa','Ortega Lucena','98547894','Marissa@gmail.com','Calle Cordoba','Córdoba','40010','478789521N','user','{bcrypt}$2a$12$HoQvj.xQbGKVo/jMLBWu9eDWRbDZYk7MSkThYViBpcBozxQfCLPtm','2004-03-17', false);
insert into usuario (id, nombre, apellidos, telefono, email, direccion, provincia, codigo_Postal, dni,   username, password,  fecha_De_Nacimiento, admin) values (3,'Candi','Alcantarilla Calado','98547894','Candi@gmail.com','Calle Sevilla','Sevilla','41110','47841523N','candi','{bcrypt}$2a$12$1d0/AmJ8Fu9t3.nkUNsb/uRE/A.bkk6yj6yYSECUS6OWVw7k4rkg2','2002-02-11', false);
insert into usuario (id, nombre, apellidos, telefono, email, direccion, provincia, codigo_Postal, dni,  username, password, fecha_De_Nacimiento, admin) values (4,'Rosa','Ortega Lucena','98647894','Rosa@gmail.com','Calle Cordoba','Cordoba','40010','47841521S', 'Roortega','{bcrypt}$2a$12$Njor/e/7paxxCUdZRDYNRuy86cW2GFw2QBNvOgzNRoQlc7VoXSEmG','2009-07-03', true);
--insert into USUARIO (id, nombre, apellidos, telefono, email, direccion, provincia, codigo_Postal, dni,  username, password, fecha_De_Nacimiento, admin) values (5,'Francisco','Alcantarilla Calado','98547894','fran@gmail.com','Sevilla','Sevilla','41110','47841521N','calado','24-07-1999', true);

ALTER SEQUENCE USUARIO_SEQ RESTART WITH (57)




/*Categorias*/
insert into categoria (id, nombre_categoria) values (1,'Balones');
insert into categoria (id, nombre_categoria) values (2,'Equipacion');
insert into categoria (id, nombre_categoria) values (3,'Accesorios');

ALTER SEQUENCE CATEGORIA_SEQ RESTART WITH (1000)
----------------------------------------------------
/*Tallas*/

insert into talla (id, nombre_talla) values (1, 'XS')
insert into talla (id, nombre_talla) values (2, 'S')
insert into talla (id, nombre_talla) values (3, 'M')
insert into talla (id, nombre_talla) values (4, 'XL')
insert into talla (id, nombre_talla) values (5, 'XXL')
insert into talla (id, nombre_talla) values (6, 'SN')


ALTER SEQUENCE TALLA_SEQ RESTART WITH (1000)
-------------------------------------------
/*Productos*/

insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (1, 6, 'Balon de champions','balón con el que el betis debuto en champions', 220.0, 'https://m.media-amazon.com/images/I/71XnnlWmbmL._AC_SL1500_.jpg', 1);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (2, 6, 'Balon de entramiento','balón con el entrenanmiento', 20.0, 'https://m.media-amazon.com/images/I/81dP3IFmfrL._AC_SL1500_.jpg', 1);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (3, 3, 'Equipación de entrenamiento de Isco','Equipación con la que entrena isco', 60.0, 'https://shop.realbetisbalompie.es/cdn/shop/files/222512-6143_2_1.jpg?crop=center&v=1714122436&width=960', 2);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (4, 4, 'Camiseta de la expo92','Camiseta conmemorativa por la expo92', 100.0, 'https://www.mundodeportemadrid.com/wp-content/uploads/2021/03/camiseta-retro-betis-2024-600x600.jpg.webp', 2);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (5, 6, 'Ropa de bebe','trajecito para bebe del real betis balompie', 30.0, 'https://tiendayofutbol.es/15201-large_default/camiseta-oficial-para-perros-del-real-betis-balompi%C3%A9.jpg', 3);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (6, 6, 'Playmobil exclusivo','Muñeco de playmobil exclusivo del jugador del betis Perkis', 80.0, 'https://www.wearegames.es/wp-content/uploads/2021/07/Pokeeto-Jugador-Real-Betis-Balompie%CC%81.jpg', 3);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (7, 6, 'Balon del primer partido','balón con el debuto el betis en liga en 1935', 600.0, 'https://resize.sprintercdn.com/f/2048x2048/products/a97456e6662b4f92b6865329861bb596/balon-real-betis-72670_a97456e6662b4f92b6865329861bb596_323390027.jpg?w=2048&q=75', 1);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (8, 6, 'Balon de partido de españa','balón para conmemorar el 12-1 de españa en el campo del betis', 550.0, 'https://static.futbolmega.es/6308-thickbox_default/balon-grande-de-reglamento-real-betis-verde-con-franjas-blancas.jpg', 1);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (9, 1, 'Equipación exclusiva de la final','Camiseta con la que se  jugo en la final de la copa del rey', 120.0, 'https://www.soccerfactory.es/images/58496_S0_T800.jpg', 2);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (10, 1, 'Camiseta del dia de la mujer','Camiseta conmemorativa por el dia de la mujer', 130.0, 'https://imaginasport.es/images/productos/img/102398-1-galeria.jpg', 2);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (11, 4, 'Mochila del betis','Ha llegado la mochila para sentir los colores del betis al ir a la escuela', 20.0, 'https://static.glami.es/img/800x800bt/286231069-mochila-gde-c-ruedas-compact-ext-orga-real-betis-balompie.jpg', 3);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (12, 6, 'Bolsa reutilizable','Bolsa para reciclar y ayudar contra el cambio climatico', 5.0, 'https://ih1.redbubble.net/image.3345627269.8864/ssrco,tote,cotton,canvas_creme,flatlay,square,600x600-bg,f8f8f8.1.jpg', 3);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (13, 6, 'Balon para niños','balón pequeño para que los peques puedan jugar', 55.0, 'https://shop.realbetisbalompie.es/cdn/shop/files/5715454058631-1.jpg?crop=center&v=1715241981&width=960', 1);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (14, 6, 'Balon de futbol sala','balón con el que el equipo jugo la final de futbol sala', 120.0, 'https://tiendascampeon.es/63169-large_default/kappa-balon-real-betis-21-22-38136jw.jpg', 1);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (15, 3, 'Primera equipacion del betis','Equipacion del año que el betis gano su unica liga', 400.0, 'https://www.vintagefootballclub.com/wp-content/uploads/2021/06/real-betis-sevilla-1934-35-1.jpg.webp', 2);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (16, 2, 'Camiseta de la despedida de joaquin','Camiseta en honor a una leyenda del beticismo como es joaquin sanchez', 300.0, 'https://www.todocamisetasfutbol.com/4631-thickbox_default/camiseta-real-betis-homenaje-joaquin.jpg', 2);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (17, 4, 'Monopoly de real betis','Se un autentico magnate con el monopoly de real betis y conquista la gloria', 90.0, 'https://lacuevaroja.com/9251-large_default/monopoly-real-betis-balompie.jpg', 3);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (18, 6, 'Llavero de Joaquin','Llavero exlusivo del partido de despedida en homenaje a joaquin', 75.0, 'https://shop.realbetisbalompie.es/cdn/shop/files/llavero_negro_joaking.jpg?crop=center&height=1200&v=1715241140&width=1200', 3);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (19, 6, 'Balon del dia de la mujer','balón conmemorativo para el dia de la mujer', 100.0, 'https://www.tradeinn.com/f/13930/139302559_3/kappa-balon-futbol-betis-seville-2020-21-mini.jpg', 1);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (20, 6, 'Botella del Betis','Hidratate siempre luciendo con orgullo tus colores', 30.0, 'https://images-eu.ssl-images-amazon.com/images/I/41v7WgIVxAL._AC_UL750_SR750,750_.jpg', 3);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (21, 3, 'Camiseta de Ruben castro','Camiseta de otra leyenda como es el máximo goleador del real betis', 260.0, 'https://ae01.alicdn.com/kf/HTB1wV6bLVXXXXbdXFXXq6xXFXXXb/2016-rosa-real-betis-Jersey-de-futbol-local-visitante-2017-la-mejor-calidad-JOAQUIN-RUBEN-CASTRO.jpg', 2);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (22, 6, 'Balón de las categprias inferiores','Balon con el que entrenan los jugadores del equipo filiar', 15.0, 'https://static.privatesportshop.com/img/p/3818396-11493805-thickbox.jpg', 1);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (23, 6, 'Balón firmado','Balón que esta firmado por los jugadores de toda la plantilla del año 2005', 660.0, 'https://i.ebayimg.com/images/g/YkUAAOSwBGJjpFTj/s-l1600.jpg', 1);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (24, 3, 'Segunda equipacion 21/22','Equipacion del betis que representa a sevilla mostrando sus monumentos mas importantes', 45.0, 'https://static.privatesportshop.com/img/p/3818336-11493448-thickbox.jpg', 2);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (25, 4, 'Equipacion de feria','Camiseta conmemorativa la cual se ha hecho para jugar la semanaa de feria', 80.0, 'https://www.camisetasstore.com/webp/2025/CAMISETA-DE-FUTBOL-Real-Betis-2024-2025---especial-550.webp', 2);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (26, 6, 'Albornoz del betis','Secate sintintiendo tus colores y sintiente un verdadero jugador', 25.0, 'https://shop.realbetisbalompie.es/cdn/shop/files/albornoz_betis.2.jpg?crop=center&v=1715241809&width=960', 3);
insert into producto (id, talla_id,  nombre, descripcion, precio, imagen, categoria_id) values (27, 6, 'Funda del betis','Luce una funda como las que llevan todos los jugadores de la plantilla', 10.0, 'https://lacasadelascarcasas.es/1113293/funda-para-google-pixel-7-5g-del-real-betis-balompie-escudo-verde-fondo-trama-licencia-oficial-real-betis-balompie.jpg', 3);


ALTER SEQUENCE PRODUCTO_SEQ RESTART WITH (1000)
-----------------------------------------------------------------------
/*Venta*/
insert into venta (finalizada, usuario_id ,total, id, fecha_compra) values (false, 2, 20, 1,'2024-05-15 18:56:27' )
insert into venta (finalizada, usuario_id ,total, id, fecha_compra) values (true, 2, 20, 2, '2024-03-17 12:16:37' )
insert into venta (finalizada, usuario_id ,total, id, fecha_compra) values (true, 2, 20, 3, '2024-07-20 13:15:12' )
insert into venta (finalizada, usuario_id ,total, id, fecha_compra) values (false, 3, 20, 4, '2024-02-11 14:36:15' )
insert into venta (finalizada, usuario_id ,total, id, fecha_compra) values (true, 3, 20, 5,'2024-10-31 18:16:21' )
insert into venta (finalizada, usuario_id ,total, id, fecha_compra) values (true, 3, 20, 6,'2024-10-31 18:16:21' )

ALTER SEQUENCE VENTA_SEQ RESTART WITH (1000)
---------------------------------------------------------------------
/*Linea de ventas*/
insert into linea_de_venta(id, producto_id, cantidad_producto, sub_total, venta_id) values (1, 1, 3, 10, 2)
insert into linea_de_venta(id, producto_id, cantidad_producto, sub_total, venta_id) values (2, 1, 2, 10, 2)
insert into linea_de_venta(id, producto_id, cantidad_producto, sub_total, venta_id) values (3, 3, 5, 10, 2)
insert into linea_de_venta(id, producto_id, cantidad_producto, sub_total, venta_id) values (4, 4, 6, 10, 4)
insert into linea_de_venta(id, producto_id, cantidad_producto, sub_total, venta_id) values (5, 5, 7, 10, 5)

ALTER SEQUENCE LINEA_DE_VENTA_SEQ RESTART WITH (1000)