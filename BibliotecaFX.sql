CREATE DATABASE BibliotecaFX
GO
USE BibliotecaFX
GO 
CREATE TABLE Autores
(
id INT PRIMARY KEY IDENTITY(1,1),
nombre VARCHAR(100) NOT NULL,
)
GO
CREATE TABLE Libros
(
id INT PRIMARY KEY IDENTITY(1,1),
titulo VARCHAR(100) NOT NULL,
isbn VARCHAR(100) UNIQUE NOT NULL,
editorial VARCHAR(100) NOT NULL,
paginas INT NOT NULL
)
GO
CREATE TABLE Usuarios
(
id INT IDENTITY(1,1) PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
telefono VARCHAR(100) NOT NULL,
direccion VARCHAR(100) NOT NULL
)
GO
CREATE TABLE Copias
(
id INT IDENTITY(1,1) PRIMARY KEY,
localizacion VARCHAR(100) NOT NULL,
idLibro INT FOREIGN KEY REFERENCES Libros(id) NOT NULL
)
GO
CREATE TABLE LibroAutor
(
idAutor INT FOREIGN KEY REFERENCES Autores(id) NOT NULL,
idLibro INT FOREIGN KEY REFERENCES Libros(id) NOT NULL
)
GO
CREATE TABLE Prestamos
(
id INT IDENTITY(1,1) PRIMARY KEY,
idUsuario INT FOREIGN KEY REFERENCES Usuarios(id) NOT NULL,
idCopia INT FOREIGN KEY REFERENCES Copias(id) NOT NULL,
fechaPrestamo DATE NOT NULL,
fechaDevolucion DATE 
)
GO
INSERT INTO Autores(nombre)
VALUES('Edgar Allan Poe')
INSERT INTO Autores(nombre)
VALUES('Issac Asimov')
INSERT INTO Autores(nombre)
VALUES('H.P. Lovecraft')
INSERT INTO Autores(nombre)
VALUES('Gabriel Garcia Marquez')
INSERT INTO Autores(nombre)
VALUES('Julio Verne')
INSERT INTO Autores(nombre)
VALUES('William Shakespeare')
INSERT INTO Autores(nombre)
VALUES('Jose Milla')
INSERT INTO Autores(nombre)
VALUES('Umberto Eco')
INSERT INTO Autores(nombre)
VALUES('Sergio Pitol')
INSERT INTO Autores(nombre)
VALUES('Juan Gelmán')
GO
INSERT INTO Libros(titulo, isbn, editorial, paginas)
VALUES('Mitos de Chutulu', 'sieod', 'Piedra Santa', 100)
INSERT INTO Libros(titulo, isbn, editorial, paginas)
VALUES('Colgando la toalla', 'eetegt', 'Santillana', 342)
INSERT INTO Libros(titulo, isbn, editorial, paginas)
VALUES('Nadando', 'daserf2', 'La Novena', 90)
INSERT INTO Libros(titulo, isbn, editorial, paginas)
VALUES('Corriendo', 'saeqwc', 'Señorial', 130)
INSERT INTO Libros(titulo, isbn, editorial, paginas)
VALUES('El Cielo', 'vaegsw', 'America', 458)
INSERT INTO Libros(titulo, isbn, editorial, paginas)
VALUES('Cocos', 'toefef', 'Santillana', 4321)
INSERT INTO Libros(titulo, isbn, editorial, paginas)
VALUES('Miguel Stroggof', 'kaoe', 'San Juan', 321)
INSERT INTO Libros(titulo, isbn, editorial, paginas)
VALUES('Pedro Pablo', 'adfqew', 'America', 564)
INSERT INTO Libros(titulo, isbn, editorial, paginas)
VALUES('Elevador', 'ginfd', 'La Novena', 674)
INSERT INTO Libros(titulo, isbn, editorial, paginas)
VALUES('Carretilla', 'affes', 'America', 210)
GO
INSERT INTO Usuarios(nombre,telefono,direccion )
VALUES('Hola Qhace', '43124563', 'Guatemala')
INSERT INTO Usuarios(nombre,telefono,direccion )
VALUES('Aquiles Boy', '81234556', 'Mixco')
INSERT INTO Usuarios(nombre,telefono,direccion )
VALUES('Jacarando Freso', '93441123', 'Guatemala')
INSERT INTO Usuarios(nombre,telefono,direccion )
VALUES('Benito Jerez', '2342352234', 'Guatemala')
INSERT INTO Usuarios(nombre,telefono,direccion )
VALUES('Juan Jose', '542352523', 'Vila Nueva')
INSERT INTO Usuarios(nombre,telefono,direccion )
VALUES('Pocho Perez', '121452354', 'San Juan')
INSERT INTO Usuarios(nombre,telefono,direccion )
VALUES('Herez Joe', '234525353', 'Guatemala')
INSERT INTO Usuarios(nombre,telefono,direccion )
VALUES('Tono Coro', '2346422221', 'Mixco')
INSERT INTO Usuarios(nombre,telefono,direccion )
VALUES('Machu Pichu', '35672124', 'Guatemala')
INSERT INTO Usuarios(nombre,telefono,direccion )
VALUES('Peludo Pelon', '123141444', 'Villa Nueva')
GO
INSERT INTO Copias(localizacion, idLibros)
VALUES('Editing', 2)
INSERT INTO Copias(localizacion, idLibros)
VALUES('Salem', 9)
INSERT INTO Copias(localizacion, idLibros)
VALUES('Figun', 1)
INSERT INTO Copias(localizacion, idLibros)
VALUES('Editing', 1)
INSERT INTO Copias(localizacion, idLibros)
VALUES('Figun', 3)
INSERT INTO Copias(localizacion, idLibros)
VALUES('Figun', 10)
INSERT INTO Copias(localizacion, idLibros)
VALUES('Salem', 8)
INSERT INTO Copias(localizacion, idLibros)
VALUES('Salem', 4)
INSERT INTO Copias(localizacion, idLibros)
VALUES('Editing', 9)
INSERT INTO Copias(localizacion, idLibros)
VALUES('Figun', 7)
GO
INSERT INTO LibroAutor(idAutor,idLibro)
VALUES(1,1)
INSERT INTO LibroAutor(idAutor,idLibro)
VALUES(2,2)
INSERT INTO LibroAutor(idAutor,idLibro)
VALUES(3,3)
INSERT INTO LibroAutor(idAutor,idLibro)
VALUES(4,4)
INSERT INTO LibroAutor(idAutor,idLibro)
VALUES(5,5)
INSERT INTO LibroAutor(idAutor,idLibro)
VALUES(6,6)
INSERT INTO LibroAutor(idAutor,idLibro)
VALUES(7,7)
INSERT INTO LibroAutor(idAutor,idLibro)
VALUES(8,8)
INSERT INTO LibroAutor(idAutor,idLibro)
VALUES(9,9)
INSERT INTO LibroAutor(idAutor,idLibro)
VALUES(10,10)
GO
INSERT INTO Prestamos(idUsuario, idCopia, fechaPrestamo, fechaDevolucion)
VALUES(1, 1, '2015-09-11', '2015-09-21')
INSERT INTO Prestamos(idUsuario, idCopia, fechaPrestamo, fechaDevolucion)
VALUES(2, 2, '2015-09-03', '2005-19-20')
INSERT INTO Prestamos(idUsuario, idCopia, fechaPrestamo, fechaDevolucion)
VALUES(3, 3, '2015-10-05', NULL)
INSERT INTO Prestamos(idUsuario, idCopia, fechaPrestamo, fechaDevolucion)
VALUES(4, 4, '2015-07-11', NULL)
INSERT INTO Prestamos(idUsuario, idCopia, fechaPrestamo, fechaDevolucion)
VALUES(5, 5, '2014-10-01', NULL)
INSERT INTO Prestamos(idUsuario, idCopia, fechaPrestamo, fechaDevolucion)
VALUES(6, 6, '2015-11-10', '2015-12-11')
INSERT INTO Prestamos(idUsuario, idCopia, fechaPrestamo, fechaDevolucion)
VALUES(7, 7, '2014-01-11', NULL)
INSERT INTO Prestamos(idUsuario, idCopia, fechaPrestamo, fechaDevolucion)
VALUES(8, 8, '2014-02-20', NULL)
INSERT INTO Prestamos(idUsuario, idCopia, fechaPrestamo, fechaDevolucion)
VALUES(9, 9, '2015-05-02', '2015-05-20')
INSERT INTO Prestamos(idUsuario, idCopia, fechaPrestamo, fechaDevolucion)
VALUES(10, 10, '2014-12-22', '2015-01-30')
GO