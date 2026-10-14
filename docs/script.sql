CREATE DATABASE IF NOT EXISTS plazoleta_db;
USE plazoleta_db;

-- TABLA ROL
CREATE TABLE rol (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100)
);

-- TABLA USUARIO
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50),
    documentoDeIdentidad VARCHAR(50) UNIQUE,
    celular VARCHAR(50),
    fechaDeNacimiento DATE,
    correo VARCHAR(50) UNIQUE,
    clave VARCHAR(50),
    idRol INT,
    
    CONSTRAINT fk_usuario_rol
        FOREIGN KEY (idRol)
        REFERENCES rol(id)
);

-- TABLA RESTAURANTE
CREATE TABLE restaurante (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    NIT VARCHAR(50) UNIQUE,
    telefono VARCHAR(50),
    urlLogo VARCHAR(200),
    idPropietario INT,
    
    CONSTRAINT fk_restaurante_propietario
        FOREIGN KEY (idPropietario)
        REFERENCES usuario(id)
);

-- TABLA CATEGORIA
CREATE TABLE categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100)
);

-- TABLA PLATO
CREATE TABLE plato (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    precio DOUBLE,
    descripcion VARCHAR(100),
    urlImagen VARCHAR(200),
    estado TINYINT,
    idCategoria INT,
    idRestaurante INT,
    
    CONSTRAINT fk_plato_categoria
        FOREIGN KEY (idCategoria)
        REFERENCES categoria(id),
        
    CONSTRAINT fk_plato_restaurante
        FOREIGN KEY (idRestaurante)
        REFERENCES restaurante(id)
);

-- TABLA PEDIDO
CREATE TABLE pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    estado TINYINT,
    idEmpleado INT,
    idCliente INT,
    
    CONSTRAINT fk_pedido_empleado
        FOREIGN KEY (idEmpleado)
        REFERENCES usuario(id),
        
    CONSTRAINT fk_pedido_cliente
        FOREIGN KEY (idCliente)
        REFERENCES usuario(id)
);

-- TABLA EMPLEADO_RESTAURANTE
CREATE TABLE empleado_restaurante (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idRestaurante INT,
    idEmpleado INT,
    
    CONSTRAINT fk_emp_rest_restaurante
        FOREIGN KEY (idRestaurante)
        REFERENCES restaurante(id),
        
    CONSTRAINT fk_emp_rest_empleado
        FOREIGN KEY (idEmpleado)
        REFERENCES usuario(id)
);

-- TABLA PLATO_PEDIDO
CREATE TABLE plato_pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cantidad INT,
    idPedido INT,
    idPlato INT,
    
    CONSTRAINT fk_plato_pedido_pedido
        FOREIGN KEY (idPedido)
        REFERENCES pedido(id),
        
    CONSTRAINT fk_plato_pedido_plato
        FOREIGN KEY (idPlato)
        REFERENCES plato(id)
);