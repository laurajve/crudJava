USE Merca_facil_Laura;

insert into almacen (id_almacen, codigo_almacen, nombre_almacen, direccion_almacen, telefono_almacen, gerente) values (16, '969', 'ferreteria-sucursal', 'fredonia', 8402497, 'paula');
insert into almacen (id_almacen, codigo_almacen, nombre_almacen, direccion_almacen, telefono_almacen, gerente) values (2, '123', 'ferreteria', 'venecia', 8402497, 'daniela');
insert into almacen (id_almacen, codigo_almacen, nombre_almacen, direccion_almacen, telefono_almacen, gerente) values (3, '856', 'ferreteria-sucursal', 'fredonia', 8402497, 'paula');
insert into almacen (id_almacen, codigo_almacen, nombre_almacen, direccion_almacen, telefono_almacen, gerente) values (4, '156', 'ferreteria', 'tamesis', 8402497, 'liliana');
insert into almacen (id_almacen, codigo_almacen, nombre_almacen, direccion_almacen, telefono_almacen, gerente) values (5, '325', 'ferreteria-sucursal', 'fredonia', 8402497, 'alejandra');

insert into proveedores (id_proveedor, nit, nombre, direccion, telefono)values(1,15478798,'unitec', 'medellin',84578528);
insert into proveedores (id_proveedor, nit, nombre, direccion, telefono)values(2,15474598,'soled', 'medellin',15647);
insert into proveedores (id_proveedor, nit, nombre, direccion, telefono)values(3,344,'julyjuly', 'medellin',25487);
insert into proveedores (id_proveedor, nit, nombre, direccion, telefono)values(4,354657,'minuta', 'medellin',487158);
insert into proveedores (id_proveedor, nit, nombre, direccion, telefono)values(5,7845,'cia', 'medellin',578154);

insert into cliente (id_cliente, cedula, nombre_cliente, direccion_almacen, telefono_cliente)values(6532,846524474,'fabian','fredonia',85442497 );
insert into cliente (id_cliente, cedula, nombre_cliente, direccion_almacen, telefono_cliente)values(6581,3456565,'laura','fredonia',8545241 );
insert into cliente (id_cliente, cedula, nombre_cliente, direccion_almacen, telefono_cliente)values(9852,8474,'federico','fredonia',8400033 );
insert into cliente (id_cliente, cedula, nombre_cliente, direccion_almacen, telefono_cliente)values(632244,22323,'juliana','fredonia',8401546 );
insert into cliente (id_cliente, cedula, nombre_cliente, direccion_almacen, telefono_cliente)values(23565,344589,'german','fredonia',8401156 );

insert into ventas (id_ventas, num_factura, fecha, total_compra, tipo_pago, cantidad, valor_unit)values(1, 1, "2020-03-25", 50000, 'efectivo',10,500);
insert into ventas (id_ventas, num_factura, fecha, total_compra, tipo_pago, cantidad, valor_unit)values(2, 2, "2020-03-25", 1000, 'cheque',20,50);
insert into ventas (id_ventas, num_factura, fecha, total_compra, tipo_pago, cantidad, valor_unit)values(3, 3, "2020-03-25", 10000, 'efectivo',1,10000);
insert into ventas (id_ventas, num_factura, fecha, total_compra, tipo_pago, cantidad, valor_unit)values(4, 4, "2020-03-25", 100, 'efectivo',2,50);
insert into ventas (id_ventas, num_factura, fecha, total_compra, tipo_pago, cantidad, valor_unit)values(5, 5, "2020-03-25", 100, 'efectivo',10,10);


insert into articulos (id_articulo, nombre, codigo, unidad_medida, existencia, cantidad_maxima, cantidad_minima, descripcion, grupo,almacen_id_almacen)values(20,'teclado',123456, '1', 10, 10, 1, 'teclado inhalambrico','tecnologia',2);
insert into articulos (id_articulo, nombre, codigo, unidad_medida, existencia, cantidad_maxima, cantidad_minima, descripcion, grupo,almacen_id_almacen)values(21,'computador',2, '10', 5, 5, 1, 'computador portatil','tecnologia',3);
insert into articulos (id_articulo, nombre, codigo, unidad_medida, existencia, cantidad_maxima, cantidad_minima, descripcion, grupo,almacen_id_almacen)values(22,'lapiz',3, '12', 60, 60, 1, 'lapiz negro','estudio',4);
insert into articulos (id_articulo, nombre, codigo, unidad_medida, existencia, cantidad_maxima, cantidad_minima, descripcion, grupo,almacen_id_almacen)values(23,'cuaderno',4, '1', 50, 6, 1, 'cuaderno rallado','estudio',5);
insert into articulos (id_articulo, nombre, codigo, unidad_medida, existencia, cantidad_maxima, cantidad_minima, descripcion, grupo,almacen_id_almacen)values(24,'tablet',5, '1', 5, 5, 1, 'tablet samsung','tecnologia',3);



insert into pedidos (id_pedidos, articulo, num_pedido, fecha, cantidad, proveedores_id_proveedor,articulos_id_articulo)values(30,'teclado',1 , "2020-03-25", 5,1,20 );
insert into pedidos (id_pedidos, articulo, num_pedido, fecha, cantidad, proveedores_id_proveedor,articulos_id_articulo)values(31,'computador',2 , "2020-05-25", 1,2,21 );
insert into pedidos (id_pedidos, articulo, num_pedido, fecha, cantidad, proveedores_id_proveedor,articulos_id_articulo)values(32,'cuaderno',3 , "2020-03-15", 6,3,22 );
insert into pedidos (id_pedidos, articulo, num_pedido, fecha, cantidad, proveedores_id_proveedor,articulos_id_articulo)values(33,'mouse',4 , "2020-03-15", 2,4,23);
insert into pedidos (id_pedidos, articulo, num_pedido, fecha, cantidad, proveedores_id_proveedor,articulos_id_articulo)values(34,'mouse',5 , "2020-03-15", 2,4,24);


insert into compras(id_compras, num_factura, fecha, total_compra, tipo_pago, cantidad, valor_unit, proveedores_id_proveedor, cliente_id_cliente)values(40,1,"2020-03-15",50000, 'efectivo',2, 5000, 1,6532);
insert into compras(id_compras, num_factura, fecha, total_compra, tipo_pago, cantidad, valor_unit, proveedores_id_proveedor, cliente_id_cliente)values(41,2,"2020-03-15",20000, 'efectivo',2, 5000, 1,6581);
insert into compras(id_compras, num_factura, fecha, total_compra, tipo_pago, cantidad, valor_unit, proveedores_id_proveedor, cliente_id_cliente)values(42,3,"2020-03-15",30000, 'efectivo',2, 1000, 1,9852);
insert into compras(id_compras, num_factura, fecha, total_compra, tipo_pago, cantidad, valor_unit, proveedores_id_proveedor, cliente_id_cliente)values(43,4,"2020-03-15",80000, 'efectivo',2, 2000, 1,632244);
insert into compras(id_compras, num_factura, fecha, total_compra, tipo_pago, cantidad, valor_unit, proveedores_id_proveedor, cliente_id_cliente)values(44,5,"2020-03-15",90000, 'efectivo',2, 5000, 1,23565);