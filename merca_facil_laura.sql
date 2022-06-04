CREATE SCHEMA IF NOT EXISTS merca_facil_laura DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE merca_facil_laura ;

-- -----------------------------------------------------
-- Table `merca_facil_laura`.`almacen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS merca_facil_laura.almacen (
  id_almacen INT NOT NULL AUTO_INCREMENT,
  codigo_almacen INT NOT NULL,
  nombre_almacen VARCHAR(50) NOT NULL,
  direccion_almacen VARCHAR(30) NOT NULL,
  telefono_almacen INT NOT NULL,
  gerente VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_almacen`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `merca_facil_laura`.`articulos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merca_facil_laura`.`articulos` (
  id_articulo INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  codigo INT NOT NULL,
  unidad_medid INT NOT NULL,
  existencia INT NOT NULL,
  cantidad_maxim INT NOT NULL,
  cantidad_minima INT NOT NULL,
  descripcion VARCHAR(250) NOT NULL,
  grupo VARCHAR(45) NOT NULL,
  almacen_id_almacen INT NOT NULL,
  PRIMARY KEY (id_articulo),
  INDEX fk_articulos_almacen1_idx (almacen_id_almacen ASC) VISIBLE,
  CONSTRAINT fk_articulos_almacen1
    FOREIGN KEY (almacen_id_almacen)
    REFERENCES merca_facil_laura.almacen (id_almacen)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `merca_facil_laura`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS merca_facil_laura.cliente (
  id_cliente INT NOT NULL AUTO_INCREMENT,
  cedula INT NOT NULL,
  nombre_cliente VARCHAR(50) NOT NULL,
  direccion_almacen VARCHAR(30) NOT NULL,
  telefono_cliente INT NOT NULL,
  PRIMARY KEY (id_cliente))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `merca_facil_laura`.`proveedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS merca_facil_laura.proveedores (
  id_proveedor INT NOT NULL AUTO_INCREMENT,
  nit INT NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  direccion VARCHAR(30) NOT NULL,
  telefono INT NOT NULL,
  PRIMARY KEY (id_proveedor))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `merca_facil_laura`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS merca_facil_laura.compras (
  id_compras INT NOT NULL AUTO_INCREMENT,
  num_factura INT NOT NULL,
  fecha DATETIME NOT NULL,
  total_compra INT NOT NULL,
  tipo_pago VARCHAR(10) NOT NULL,
  cantidad INT NOT NULL,
  valor_unit INT NOT NULL,
  proveedores_id_proveedor INT NOT NULL,
  cliente_id_cliente INT NOT NULL,
  PRIMARY KEY (id_compras),
  INDEX fk_compras_proveedores1_idx (proveedores_id_proveedor ASC) VISIBLE,
  INDEX fk_compras_cliente1_idx (cliente_id_cliente ASC) VISIBLE,
  CONSTRAINT fk_compras_proveedores1
    FOREIGN KEY (proveedores_id_proveedor)
    REFERENCES merca_facil_laura.proveedores (id_proveedor)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_compras_cliente1
    FOREIGN KEY (cliente_id_cliente)
    REFERENCES merca_facil_laura.cliente (id_cliente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `merca_facil_laura`.`pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS merca_facil_laura.pedidos (
  id_pedidos INT NOT NULL AUTO_INCREMENT,
  articulo VARCHAR(30) NOT NULL,
  num_pedido INT NOT NULL,
  fecha DATETIME NOT NULL,
  cantidad INT NOT NULL,
  proveedores_id_proveedor INT NOT NULL,
  articulos_id_articulo INT NOT NULL,
  PRIMARY KEY (id_pedidos, proveedores_id_proveedor),
  INDEX fk_pedidos_proveedores1_idx (proveedores_id_proveedor ASC) VISIBLE,
  INDEX fk_pedidos_articulos1_idx (articulos_id_articulo ASC) VISIBLE,
  CONSTRAINT fk_pedidos_proveedores1
    FOREIGN KEY (proveedores_id_proveedor)
    REFERENCES merca_facil_laura.proveedores (id_proveedor)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_pedidos_articulos1
    FOREIGN KEY (articulos_id_articulo)
    REFERENCES merca_facil_laura.articulos (id_articulo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `merca_facil_laura`.`ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS merca_facil_laura.ventas (
  id_ventas INT NOT NULL AUTO_INCREMENT,
  num_factura INT NOT NULL,
  fecha DATETIME NOT NULL,
  total_compra INT NOT NULL,
  tipo_pago VARCHAR(10) NOT NULL,
  cantidad INT NOT NULL,
  valor_unit INT NOT NULL,
  PRIMARY KEY (id_ventas))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `merca_facil_laura`.`proveedores_has_articulos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS merca_facil_laura.proveedores_has_articulos (
  proveedores_id_proveedor INT NOT NULL,
  articulos_id_articulo INT NOT NULL,
  PRIMARY KEY (proveedores_id_proveedor, articulos_id_articulo),
  INDEX fk_proveedores_has_articulos_articulos1_idx (articulos_id_articulo ASC) VISIBLE,
  INDEX fk_proveedores_has_articulos_proveedores_idx (proveedores_id_proveedor ASC) VISIBLE,
  CONSTRAINT fk_proveedores_has_articulos_proveedores
    FOREIGN KEY (proveedores_id_proveedor)
    REFERENCES merca_facil_laura.proveedores (id_proveedor)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_proveedores_has_articulos_articulos1
    FOREIGN KEY (articulos_id_articulo)
    REFERENCES merca_facil_laura.articulos (id_articulo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `merca_facil_laura`.`ventas_has_proveedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS merca_facil_laura.ventas_has_proveedores (
  ventas_id_ventas INT NOT NULL,
  proveedores_id_proveedor INT NOT NULL,
  PRIMARY KEY (ventas_id_ventas, proveedores_id_proveedor),
  INDEX fk_ventas_has_proveedores_proveedores1_idx (proveedores_id_proveedor ASC) VISIBLE,
  INDEX fk_ventas_has_proveedores_ventas1_idx (ventas_id_ventas ASC) VISIBLE,
  CONSTRAINT fk_ventas_has_proveedores_ventas1
    FOREIGN KEY (ventas_id_ventas)
    REFERENCES merca_facil_laura.ventas (id_ventas)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_ventas_has_proveedores_proveedores1
    FOREIGN KEY (proveedores_id_proveedor)
    REFERENCES merca_facil_laura.proveedores (id_proveedor)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `merca_facil_laura`.`ventas_has_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS merca_facil_laura.ventas_has_cliente (
  ventas_id_ventas INT NOT NULL,
  cliente_id_cliente INT NOT NULL,
  PRIMARY KEY (ventas_id_ventas, cliente_id_cliente),
  INDEX fk_ventas_has_cliente_cliente1_idx (cliente_id_cliente ASC) VISIBLE,
  INDEX fk_ventas_has_cliente_ventas1_idx (ventas_id_ventas ASC) VISIBLE,
  CONSTRAINT fk_ventas_has_cliente_ventas1
    FOREIGN KEY (ventas_id_ventas)
    REFERENCES merca_facil_laura.ventas (id_ventas)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_ventas_has_cliente_cliente1
    FOREIGN KEY (cliente_id_cliente)
    REFERENCES merca_facil_laura.cliente (id_cliente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;