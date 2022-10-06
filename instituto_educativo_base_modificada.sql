-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-10-2022 a las 17:57:56
-- Versión del servidor: 5.6.26
-- Versión de PHP: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `instituto_educativo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE IF NOT EXISTS `alumnos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `fecha_nacimiento` varchar(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`id`, `nombre`, `fecha_nacimiento`) VALUES
(1, 'Mario Dominguez', '2022-10-21'),
(2, 'Morena Diaz', ''),
(3, 'Belén Medina', ''),
(4, 'Jorge Moreira', ''),
(5, 'Martín Ríos', ''),
(6, 'Susana Gómez', ''),
(7, 'Carlos Smith', ''),
(8, 'Alejandro Perez', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno_curso_personal`
--

CREATE TABLE IF NOT EXISTS `alumno_curso_personal` (
  `id_alumno` int(11) NOT NULL,
  `id_curso_personal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumno_curso_personal`
--

INSERT INTO `alumno_curso_personal` (`id_alumno`, `id_curso_personal`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulas`
--

CREATE TABLE IF NOT EXISTS `aulas` (
  `id` int(11) NOT NULL,
  `codigo` varchar(255) NOT NULL,
  `capacidad` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `aulas`
--

INSERT INTO `aulas` (`id`, `codigo`, `capacidad`) VALUES
(1, 'A1', 50),
(2, 'A2', 15),
(3, 'A3', 30),
(4, 'A4', 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE IF NOT EXISTS `categorias` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `importe_por_hora` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id`, `nombre`, `importe_por_hora`) VALUES
(1, 'Profesor Asociado', 6175.5),
(2, 'Profesor Ordinario', 4865.75);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE IF NOT EXISTS `cursos` (
  `id` int(11) NOT NULL,
  `id_tema` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `id_docente` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`id`, `id_tema`, `fecha_inicio`, `id_docente`, `nombre`) VALUES
(1, 2, '2022-09-01', 1, 'Curso 1'),
(2, 1, '2022-09-29', 2, 'Curso 2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos_empresariales`
--

CREATE TABLE IF NOT EXISTS `cursos_empresariales` (
  `id` int(11) NOT NULL,
  `precio_total` float NOT NULL,
  `id_empresa` int(11) NOT NULL,
  `cantidad_alumnos` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cursos_empresariales`
--

INSERT INTO `cursos_empresariales` (`id`, `precio_total`, `id_empresa`, `cantidad_alumnos`, `id_curso`) VALUES
(1, 20500, 1, 20, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos_personales`
--

CREATE TABLE IF NOT EXISTS `cursos_personales` (
  `id` int(11) NOT NULL,
  `precio_por_alumno` float NOT NULL,
  `id_aula` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cursos_personales`
--

INSERT INTO `cursos_personales` (`id`, `precio_por_alumno`, `id_aula`, `id_curso`) VALUES
(1, 1500, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docentes`
--

CREATE TABLE IF NOT EXISTS `docentes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `docentes`
--

INSERT INTO `docentes` (`id`, `nombre`) VALUES
(1, 'Sergio Viera'),
(2, 'Santiago Raggazzo'),
(3, 'Marcelo Badino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

CREATE TABLE IF NOT EXISTS `empresas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empresas`
--

INSERT INTO `empresas` (`id`, `nombre`, `direccion`) VALUES
(1, 'Next DDS', 'Mitre 2'),
(2, 'Mundo UML', 'San Martín 203');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE IF NOT EXISTS `material` (
  `id` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `costo` float NOT NULL,
  `id_curso` int(11) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `material`
--

INSERT INTO `material` (`id`, `titulo`, `costo`, `id_curso`, `stock`) VALUES
(2, 'Manual de XP', 250, 2, 35),
(3, 'Lapiz optico editado', 900, 1, 120),
(4, 'Diccionario', 200, 2, 20),
(5, 'Manual de Calidad 2', 250, 1, 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE IF NOT EXISTS `profesores` (
  `id` int(11) NOT NULL,
  `profesion` varchar(255) DEFAULT NULL,
  `id_categoria` int(11) NOT NULL,
  `id_docente` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`id`, `profesion`, `id_categoria`, `id_docente`) VALUES
(1, 'Ingeniero', 1, 1),
(2, 'Licenciado', 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socios`
--

CREATE TABLE IF NOT EXISTS `socios` (
  `id` int(11) NOT NULL,
  `antiguedad` int(11) NOT NULL,
  `valor_acordado` float NOT NULL,
  `id_docente` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `socios`
--

INSERT INTO `socios` (`id`, `antiguedad`, `valor_acordado`, `id_docente`) VALUES
(1, 5, 1500, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `temas`
--

CREATE TABLE IF NOT EXISTS `temas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `duracion` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `temas`
--

INSERT INTO `temas` (`id`, `nombre`, `duracion`) VALUES
(1, 'Programación en C++', 12),
(2, 'Diseño de Sistemas', 36);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `alumno_curso_personal`
--
ALTER TABLE `alumno_curso_personal`
  ADD PRIMARY KEY (`id_alumno`,`id_curso_personal`),
  ADD KEY `id_curso_personal` (`id_curso_personal`);

--
-- Indices de la tabla `aulas`
--
ALTER TABLE `aulas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_docente` (`id_docente`),
  ADD KEY `id_tema` (`id_tema`);

--
-- Indices de la tabla `cursos_empresariales`
--
ALTER TABLE `cursos_empresariales`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cursos_empresariales` (`id_curso`),
  ADD KEY `id_empresa` (`id_empresa`);

--
-- Indices de la tabla `cursos_personales`
--
ALTER TABLE `cursos_personales`
  ADD PRIMARY KEY (`id`),
  ADD KEY `curso_personal` (`id_curso`),
  ADD KEY `id_aula` (`id_aula`);

--
-- Indices de la tabla `docentes`
--
ALTER TABLE `docentes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empresas`
--
ALTER TABLE `empresas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tema` (`id_curso`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `docente_profesor` (`id_docente`),
  ADD KEY `id_categoria` (`id_categoria`);

--
-- Indices de la tabla `socios`
--
ALTER TABLE `socios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `socio_docente` (`id_docente`);

--
-- Indices de la tabla `temas`
--
ALTER TABLE `temas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `aulas`
--
ALTER TABLE `aulas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `cursos`
--
ALTER TABLE `cursos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `cursos_empresariales`
--
ALTER TABLE `cursos_empresariales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `cursos_personales`
--
ALTER TABLE `cursos_personales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `docentes`
--
ALTER TABLE `docentes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `empresas`
--
ALTER TABLE `empresas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `material`
--
ALTER TABLE `material`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `profesores`
--
ALTER TABLE `profesores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `socios`
--
ALTER TABLE `socios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `temas`
--
ALTER TABLE `temas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumno_curso_personal`
--
ALTER TABLE `alumno_curso_personal`
  ADD CONSTRAINT `alumno_curso_personal_ibfk_1` FOREIGN KEY (`id_alumno`) REFERENCES `alumnos` (`id`),
  ADD CONSTRAINT `alumno_curso_personal_ibfk_2` FOREIGN KEY (`id_curso_personal`) REFERENCES `cursos_personales` (`id`);

--
-- Filtros para la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`id_docente`) REFERENCES `docentes` (`id`),
  ADD CONSTRAINT `cursos_ibfk_2` FOREIGN KEY (`id_tema`) REFERENCES `temas` (`id`);

--
-- Filtros para la tabla `cursos_empresariales`
--
ALTER TABLE `cursos_empresariales`
  ADD CONSTRAINT `cursos_empresariales` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`id`),
  ADD CONSTRAINT `cursos_empresariales_ibfk_1` FOREIGN KEY (`id_empresa`) REFERENCES `empresas` (`id`);

--
-- Filtros para la tabla `cursos_personales`
--
ALTER TABLE `cursos_personales`
  ADD CONSTRAINT `curso_personal` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`id`),
  ADD CONSTRAINT `cursos_personales_ibfk_1` FOREIGN KEY (`id_aula`) REFERENCES `aulas` (`id`);

--
-- Filtros para la tabla `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `material_ibfk_1` FOREIGN KEY (`id_curso`) REFERENCES `temas` (`id`);

--
-- Filtros para la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD CONSTRAINT `docente_profesor` FOREIGN KEY (`id_docente`) REFERENCES `docentes` (`id`),
  ADD CONSTRAINT `profesores_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`);

--
-- Filtros para la tabla `socios`
--
ALTER TABLE `socios`
  ADD CONSTRAINT `socio_docente` FOREIGN KEY (`id_docente`) REFERENCES `docentes` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
