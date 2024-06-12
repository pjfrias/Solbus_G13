-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-06-2024 a las 05:08:53
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `solbusg13`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colectivos`
--

CREATE TABLE `colectivos` (
  `id_colectivo` int(5) NOT NULL,
  `matricula` varchar(10) NOT NULL,
  `marca` varchar(15) NOT NULL,
  `modelo` varchar(15) DEFAULT NULL,
  `capacidad` int(2) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `colectivos`
--

INSERT INTO `colectivos` (`id_colectivo`, `matricula`, `marca`, `modelo`, `capacidad`, `estado`) VALUES
(1, 'AA 232 01', 'Ford', 'Travel', 5, 1),
(2, 'AD 334 02', 'Mercedes Benz', '2115', 5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `id_horario` int(5) NOT NULL,
  `id_ruta` int(5) NOT NULL,
  `hora_salida` time NOT NULL,
  `hora_llegada` time NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `horarios`
--

INSERT INTO `horarios` (`id_horario`, `id_ruta`, `hora_salida`, `hora_llegada`, `estado`) VALUES
(1, 1, '18:00:00', '19:30:00', 1),
(2, 2, '12:00:00', '15:15:00', 1),
(3, 3, '20:00:00', '00:00:00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajeros`
--

CREATE TABLE `pasajeros` (
  `id_pasajero` int(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasajeros`
--

INSERT INTO `pasajeros` (`id_pasajero`, `nombre`, `apellido`, `dni`, `correo`, `telefono`, `estado`) VALUES
(2, 'Julio', 'Perez', '22987656', 'jperez@gmail.com', '2332876776', 1),
(3, 'Esteban', 'Turillo', '33456980', 'eturillo@gmail.com', '2657111111', 1),
(4, 'Maria Azucena', 'Baigorria', '30223887', 'azuce@gmail.com', '266335999', 1),
(5, 'Hector', 'Munoz', '36223990', 'hmunoz@hotmail.com', '266998844', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajes`
--

CREATE TABLE `pasajes` (
  `id_pasaje` int(10) NOT NULL,
  `id_pasajero` int(10) NOT NULL,
  `id_colectivo` int(5) NOT NULL,
  `id_ruta` int(5) NOT NULL,
  `fecha_viaje` date NOT NULL,
  `hora_viaje` time NOT NULL,
  `asiento` int(2) NOT NULL,
  `precio` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasajes`
--

INSERT INTO `pasajes` (`id_pasaje`, `id_pasajero`, `id_colectivo`, `id_ruta`, `fecha_viaje`, `hora_viaje`, `asiento`, `precio`) VALUES
(1, 2, 2, 3, '2024-06-11', '00:00:10', 1, 12000),
(4, 5, 2, 3, '2024-06-11', '20:00:00', 5, 15000),
(5, 3, 2, 3, '2024-06-11', '20:00:00', 3, 12000),
(6, 4, 2, 3, '2024-06-11', '20:00:00', 2, 21000),
(7, 5, 2, 3, '2024-06-11', '20:00:00', 4, 11000),
(8, 3, 1, 1, '2024-06-11', '18:00:00', 1, 11000),
(9, 3, 1, 1, '2024-06-11', '18:00:00', 4, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutas`
--

CREATE TABLE `rutas` (
  `id_ruta` int(5) NOT NULL,
  `origen` varchar(40) NOT NULL,
  `destino` varchar(40) NOT NULL,
  `duracion_estimada` time NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rutas`
--

INSERT INTO `rutas` (`id_ruta`, `origen`, `destino`, `duracion_estimada`, `estado`) VALUES
(1, 'Villa Mercedes', 'San Luis', '01:10:00', 1),
(2, 'Villa Merceds', 'Concaran', '02:00:00', 1),
(3, 'San Luis', 'Merlo', '04:00:00', 1),
(4, 'La Toma', 'Tilisarao', '00:00:01', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `colectivos`
--
ALTER TABLE `colectivos`
  ADD PRIMARY KEY (`id_colectivo`);

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`id_horario`),
  ADD KEY `id_ruta` (`id_ruta`);

--
-- Indices de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  ADD PRIMARY KEY (`id_pasajero`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Indices de la tabla `pasajes`
--
ALTER TABLE `pasajes`
  ADD PRIMARY KEY (`id_pasaje`),
  ADD KEY `id_pasajero` (`id_pasajero`),
  ADD KEY `id_colectivo` (`id_colectivo`),
  ADD KEY `id_ruta` (`id_ruta`);

--
-- Indices de la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD PRIMARY KEY (`id_ruta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `colectivos`
--
ALTER TABLE `colectivos`
  MODIFY `id_colectivo` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `id_horario` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  MODIFY `id_pasajero` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pasajes`
--
ALTER TABLE `pasajes`
  MODIFY `id_pasaje` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `rutas`
--
ALTER TABLE `rutas`
  MODIFY `id_ruta` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD CONSTRAINT `horarios_ibfk_1` FOREIGN KEY (`id_ruta`) REFERENCES `rutas` (`id_ruta`);

--
-- Filtros para la tabla `pasajes`
--
ALTER TABLE `pasajes`
  ADD CONSTRAINT `pasajes_ibfk_1` FOREIGN KEY (`id_pasajero`) REFERENCES `pasajeros` (`id_pasajero`),
  ADD CONSTRAINT `pasajes_ibfk_2` FOREIGN KEY (`id_colectivo`) REFERENCES `colectivos` (`id_colectivo`),
  ADD CONSTRAINT `pasajes_ibfk_3` FOREIGN KEY (`id_ruta`) REFERENCES `rutas` (`id_ruta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
