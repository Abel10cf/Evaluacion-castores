CREATE TABLE roles (
    idRol INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- Insertar roles
INSERT INTO roles (idRol, nombre) VALUES (1, 'Administrador');
INSERT INTO roles (idRol, nombre) VALUES (2, 'Almacenista');

-- Crear la tabla de usuarios
CREATE TABLE usuarios (
    idUsuario INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    contrasena VARCHAR(50) NOT NULL,
    idRol INT,
    estatus INT,
    FOREIGN KEY (idRol) REFERENCES roles(idRol)
);



-- Crear la tabla de productos
CREATE TABLE productos (
    idProducto INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    estado VARCHAR(10) DEFAULT 'activo' -- activo, inactivo
);


-- Crear la tabla de inventario
CREATE TABLE inventario (
    idInventario INT PRIMARY KEY,
    idProducto INT,
    cantidad INT DEFAULT 0,
    FOREIGN KEY (idProducto) REFERENCES productos(idProducto)
);


-- Crear la tabla de movimientos
CREATE TABLE movimientos (
    idMovimiento INT PRIMARY KEY,
    idProducto INT,
    tipoMovimiento VARCHAR(10), -- entrada, salida
    cantidad INT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    idUsuario INT,
    FOREIGN KEY (idProducto) REFERENCES productos(idProducto),
    FOREIGN KEY (idUsuario) REFERENCES usuarios(idUsuario)
);

select * from movimientos

-- Insertar datos
INSERT INTO usuarios (idUsuario, nombre,correo, contrasena, idRol, estatus)
VALUES (1, 'Admin','admin@gmail.com', 'adminpass', 1,1);
INSERT INTO usuarios (idUsuario, nombre,correo, contrasena, idRol, estatus)
VALUES (2, 'Almacenista','almecenista@gmail.com', 'almacenpass', 2,1);

drop table productos

INSERT INTO productos (idProducto, nombre, estado) 
VALUES(1, 'Producto1', 'activo');
INSERT INTO productos (idProducto, nombre, estado)
VALUES(2, 'Producto2', 'activo');

INSERT INTO inventario (idInventario, idProducto, cantidad) 
VALUES(1, 1, 0);
INSERT INTO inventario (idInventario, idProducto, cantidad) 
VALUES(2, 2, 0);

SELECT * FROM roles;
select * FROM usuarios;
select * from productos;
select * from inventario;


