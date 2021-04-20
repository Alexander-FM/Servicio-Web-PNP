-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-04-2021 a las 07:36:01
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_pnp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agraviado`
--

CREATE TABLE `agraviado` (
  `id` int(11) NOT NULL,
  `apellido_materno` varchar(100) NOT NULL,
  `apellido_paterno` varchar(100) NOT NULL,
  `direccion` varchar(500) DEFAULT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `numero_identificacion` varchar(11) NOT NULL,
  `sexo` varchar(25) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `vigencia` bit(1) NOT NULL,
  `juzgado` varchar(100) DEFAULT NULL,
  `rhd` varchar(500) NOT NULL,
  `detalle_proteccion` varchar(500) DEFAULT NULL,
  `fecha_emision` datetime DEFAULT NULL,
  `medida_proteccion` bit(1) NOT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `estado_civil_id` int(11) DEFAULT NULL,
  `tipo_identificacion_id` int(11) DEFAULT NULL,
  `informacion_adicional_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `agraviado`
--

INSERT INTO `agraviado` (`id`, `apellido_materno`, `apellido_paterno`, `direccion`, `fecha_nacimiento`, `nombres`, `numero_identificacion`, `sexo`, `telefono`, `vigencia`, `juzgado`, `rhd`, `detalle_proteccion`, `fecha_emision`, `medida_proteccion`, `distrito_id`, `estado_civil_id`, `tipo_identificacion_id`, `informacion_adicional_id`) VALUES
(3, ' Medina', 'Fuentes', '- - - ', '1999-12-19 14:30:00', 'Alexander', '78019778', 'M', '951357852', b'0', NULL, 'Me golpearon salvajemente', NULL, NULL, b'0', 3, NULL, 1, 1),
(4, ' Oxenford', 'Rodriguez', NULL, '1995-03-10 13:21:04', 'Martha Julia', '45542552', 'F', '978936111', b'0', NULL, 'Fui ultraja por tres amigos míos en una noche de fiesta', NULL, NULL, b'0', 1, NULL, 1, 1),
(5, 'Ballona', 'Capitan', NULL, '1998-10-16 15:22:39', 'Katherine', '44488877', 'F', '987789944', b'0', NULL, 'Fui agredida por mis tíos en casa de mis padres, trato de asesinarme con un cuchillo', NULL, NULL, b'0', 2, NULL, 1, 1),
(6, ' Chicoma', 'Chicoma', NULL, '1995-03-31 07:22:39', 'Jhair', '45528791', 'M', '955996696', b'0', NULL, 'Mi tío abuso sexualmente de mi ofreciéndome un chocolate.', NULL, NULL, b'0', 4, NULL, 1, 1),
(7, ' Carrion', 'Sirlopu', NULL, '2000-08-31 07:22:40', 'Yadhira ', '65567887', 'F', '944987682', b'0', 'Juzgado Familiar', 'Mi esposo me insulta todos los días y me golpea salvajemente.', 'Que el esposo no se le acerca 1km a la redonda', '2021-03-09 13:53:25', b'1', 1, NULL, 1, 1),
(8, ' Torres', 'Yupanqui', NULL, '1998-03-22 13:59:37', 'Camila', '58854554', 'F', '963147856', b'0', NULL, 'Mi enamorado mucho me insulta cuando llego de trabajar', NULL, NULL, b'0', 1, NULL, 1, 1),
(9, 'TUESTA', 'VEINTIMILLA', 'No existe información', '1975-04-27 19:00:00', 'JESUS', '01139746', 'Femenino', '968458123', b'0', NULL, 'mi esposo llegó borracho en la calle y me golpeó la cabeza con una botella de vidrio', NULL, NULL, b'0', 2, 2, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denuncia`
--

CREATE TABLE `denuncia` (
  `id` int(11) NOT NULL,
  `cod_denuncia` varchar(8) DEFAULT NULL,
  `direccion` varchar(500) NOT NULL,
  `estado_denuncia` bit(1) DEFAULT NULL,
  `fecha_denuncia` datetime NOT NULL,
  `fecha_hechos` datetime DEFAULT NULL,
  `referencia_direccion` varchar(500) NOT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `policia_id` int(11) DEFAULT NULL,
  `tipo_denuncia_id` int(11) DEFAULT NULL,
  `vinculo_parte_denunciada_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `denuncia`
--

INSERT INTO `denuncia` (`id`, `cod_denuncia`, `direccion`, `estado_denuncia`, `fecha_denuncia`, `fecha_hechos`, `referencia_direccion`, `distrito_id`, `policia_id`, `tipo_denuncia_id`, `vinculo_parte_denunciada_id`) VALUES
(1, 'D-001', 'Las Palmeras', b'0', '2021-03-08 16:44:41', '2021-03-05 16:44:50', 'Frente a al parque virgen de túcume', 3, 1, 1, 3),
(2, 'D-002', 'Calle San Juan Bosco N.230', b'1', '2021-03-09 14:15:22', '2021-03-02 14:15:22', 'Por el parque principal de san juan bosco', 3, 2, 1, 2),
(3, '???', 'Calle San Ramon N.º 230', b'0', '2021-03-09 15:47:49', '2021-03-03 15:47:49', 'Por el complejo deportivo', 3, 3, 3, 2),
(4, '???', 'Calle San Tomas SN', b'0', '2020-03-09 16:45:31', '2020-02-04 16:45:31', 'No existe información', 1, 3, 1, 2),
(5, '???', 'Av. Carrion N.º 450', b'1', '2021-03-09 16:45:31', '2021-02-01 16:45:31', 'No existe Informacion', 4, 1, 2, 1),
(23, '???', 'Villa Los Sauces Manzana V Lote 5', b'0', '2021-04-19 19:00:00', '2021-04-16 19:00:00', 'a la derecha antes de entrar por el segundo portón', 2, 1, 2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denunciado`
--

CREATE TABLE `denunciado` (
  `id` int(11) NOT NULL,
  `apellido_materno` varchar(100) NOT NULL,
  `apellido_paterno` varchar(100) NOT NULL,
  `direccion` varchar(500) DEFAULT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `numero_identificacion` varchar(11) NOT NULL,
  `sexo` varchar(25) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `vigencia` bit(1) NOT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `estado_civil_id` int(11) DEFAULT NULL,
  `tipo_identificacion_id` int(11) DEFAULT NULL,
  `informacion_adicional_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `denunciado`
--

INSERT INTO `denunciado` (`id`, `apellido_materno`, `apellido_paterno`, `direccion`, `fecha_nacimiento`, `nombres`, `numero_identificacion`, `sexo`, `telefono`, `vigencia`, `distrito_id`, `estado_civil_id`, `tipo_identificacion_id`, `informacion_adicional_id`) VALUES
(1, 'Quisque', 'Chumioqui', 'Santa Elena N.º123', '2021-04-08 16:37:21', 'Alejandro Jose', '95874123', 'M', '939272190', b'0', 4, 2, 1, 1),
(2, 'Murrillo', 'Vargas', 'Calle Jesus Maria N.º320', '2021-04-14 16:37:26', 'Takeshi Obed', '45547887', 'M', '915375465', b'0', 1, 2, 1, 1),
(3, 'Díaz', 'Gastelo', 'Calle Ilo N.º450', '2021-04-16 16:37:29', 'Alexis', '65568558', 'M', '999555478', b'0', 4, 2, 1, 1),
(4, 'Sandoval', 'Torres', 'Calle Marte N.º230', '2021-04-20 16:37:31', 'Miguel Angel', '25526336', 'M', '988876471', b'0', 2, 2, 1, 2),
(5, 'Llamo', 'Coronado', 'Av. San Juan N.º230', '2021-04-22 16:37:34', 'Nahun Alfonso', '25529669', 'M', '933366636', b'0', 4, 2, 1, 2),
(6, 'Huaman', 'Fernandez', 'Calle Junín N.º 555', '2021-04-02 16:37:36', 'Patrick', '20021221', 'M', '978897123', b'0', 2, 4, 1, 2),
(7, 'Pisfil', 'Medina', 'Calle San Eduardo N.º 199', '2021-04-16 16:37:38', 'Alejandra María', '54458778', 'F', '978258312', b'0', 3, 2, 1, 4),
(8, 'Siesquen', 'Llanos', 'Av. San Bartolome N.º 450', '2021-04-09 16:37:41', 'Francisco', '33399978', 'M', '931731982', b'0', 3, 2, 1, 2),
(9, 'Chuquilin', 'Sandoval', 'Av. San Mariano Cornejo N.º304', '2021-04-23 16:37:43', 'Alejandro', '88779966', 'M', '944955966', b'0', 1, 2, 1, 1),
(10, 'Cornejo', 'Brenis', 'Av. Santa Catalina N.º 128', '2021-04-16 16:37:46', 'Fernando', '22211133', 'M', '977918935', b'0', 1, 2, 1, 1),
(11, 'Sánchez', 'Cumpa', 'Villa Los Sauces Manzana V Lote 5', '1974-06-29 19:00:00', 'Oscar Manuel', '16620936', 'Masculino', '956322572', b'0', 1, 2, 1, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denuncia_agraviado`
--

CREATE TABLE `denuncia_agraviado` (
  `id` int(11) NOT NULL,
  `denuncia_id` int(11) DEFAULT NULL,
  `agraviado_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `denuncia_agraviado`
--

INSERT INTO `denuncia_agraviado` (`id`, `denuncia_id`, `agraviado_id`) VALUES
(1, 1, 3),
(2, 2, 6),
(3, 3, 4),
(5, 4, 5),
(7, 5, 7),
(8, 23, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denuncia_denunciado`
--

CREATE TABLE `denuncia_denunciado` (
  `id` int(11) NOT NULL,
  `denuncia_id` int(11) DEFAULT NULL,
  `denunciado_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `denuncia_denunciado`
--

INSERT INTO `denuncia_denunciado` (`id`, `denuncia_id`, `denunciado_id`) VALUES
(1, 1, 10),
(2, 2, 3),
(3, 3, 2),
(4, 3, 4),
(5, 4, 9),
(6, 4, 8),
(7, 23, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `id` int(11) NOT NULL,
  `capital` varchar(30) NOT NULL,
  `departamento` varchar(50) NOT NULL,
  `estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`id`, `capital`, `departamento`, `estado`) VALUES
(1, 'Chiclayo', 'Lambayeque', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distrito`
--

CREATE TABLE `distrito` (
  `id` int(11) NOT NULL,
  `codigo_postal` varchar(5) NOT NULL,
  `distrito` varchar(100) NOT NULL,
  `estado` bit(1) NOT NULL,
  `provincia_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `distrito`
--

INSERT INTO `distrito` (`id`, `codigo_postal`, `distrito`, `estado`, `provincia_id`) VALUES
(1, '14001', 'Chiclayo', b'1', 1),
(2, '14002', 'José Leonardo Ortiz', b'1', 1),
(3, '14311', 'Ferreñafe', b'1', 2),
(4, '14311', 'Pueblo Nuevo', b'1', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_civil`
--

CREATE TABLE `estado_civil` (
  `id` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `estado_civil` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estado_civil`
--

INSERT INTO `estado_civil` (`id`, `estado`, `estado_civil`) VALUES
(1, b'1', 'Casado'),
(2, b'1', 'Soltero'),
(3, b'1', 'Conviviente'),
(4, b'1', 'Divorciado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gradopnp`
--

CREATE TABLE `gradopnp` (
  `id` int(11) NOT NULL,
  `nombre_grado` varchar(100) NOT NULL,
  `vigencia` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `gradopnp`
--

INSERT INTO `gradopnp` (`id`, `nombre_grado`, `vigencia`) VALUES
(1, 'Mayor PNP', b'1'),
(2, 'Teniente', b'1'),
(3, 'Coronel', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informacion_adicional`
--

CREATE TABLE `informacion_adicional` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `informacion_adicional`
--

INSERT INTO `informacion_adicional` (`id`, `nombre`) VALUES
(1, 'Joven'),
(2, 'Adulto Mayor'),
(3, 'Niño'),
(4, 'Niña'),
(5, 'Población LGTBI'),
(6, 'Discapacitado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `loginpnp`
--

CREATE TABLE `loginpnp` (
  `id` int(11) NOT NULL,
  `clave` varchar(50) NOT NULL,
  `codigo_policial` varchar(10) NOT NULL,
  `estado` bit(1) NOT NULL,
  `policia_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `loginpnp`
--

INSERT INTO `loginpnp` (`id`, `clave`, `codigo_policial`, `estado`, `policia_id`) VALUES
(1, 'admin123', 'P4554', b'1', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `policia`
--

CREATE TABLE `policia` (
  `id` int(11) NOT NULL,
  `apellido_materno` varchar(100) NOT NULL,
  `apellido_paterno` varchar(100) NOT NULL,
  `direccion` varchar(500) DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  `nombres` varchar(100) NOT NULL,
  `numero_identificacion` varchar(11) NOT NULL,
  `sexo` varchar(25) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `vigencia` bit(1) NOT NULL,
  `estado` bit(1) NOT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `estado_civil_id` int(11) DEFAULT NULL,
  `tipo_identificacion_id` int(11) DEFAULT NULL,
  `gradopnp_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `policia`
--

INSERT INTO `policia` (`id`, `apellido_materno`, `apellido_paterno`, `direccion`, `fecha_nacimiento`, `nombres`, `numero_identificacion`, `sexo`, `telefono`, `vigencia`, `estado`, `distrito_id`, `estado_civil_id`, `tipo_identificacion_id`, `gradopnp_id`) VALUES
(1, 'Ramírez', 'Portocarrero', NULL, '1985-04-13 15:32:51', 'Ana Rosa', '45541232', 'F', '963147856', b'0', b'1', 2, 1, 1, 1),
(2, 'Huallama', 'Torres', '- - -', '1992-04-10 12:57:06', 'Alejandro', '11223344', 'M', '951357852', b'0', b'1', 2, 2, 1, 1),
(3, ' Atoche', 'Tejada ', '- - -', '1999-04-16 12:57:40', 'Jose Eduardo', '65885798', 'M', '951444789', b'0', b'1', 4, 3, 1, 1),
(4, 'Paz', 'Nuñez ', NULL, NULL, 'Edson Iván', '26845798', 'M', '956334276', b'0', b'1', 1, 4, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

CREATE TABLE `provincia` (
  `id` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `provincia` varchar(100) NOT NULL,
  `departamento_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `provincia`
--

INSERT INTO `provincia` (`id`, `estado`, `provincia`, `departamento_id`) VALUES
(1, b'1', 'Chiclayo', 1),
(2, b'1', 'Ferreñafe', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_denuncia`
--

CREATE TABLE `tipo_denuncia` (
  `id` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `tipo_denuncia` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_denuncia`
--

INSERT INTO `tipo_denuncia` (`id`, `estado`, `tipo_denuncia`) VALUES
(1, b'1', 'Fisica'),
(2, b'1', 'Psicológica'),
(3, b'1', 'Sexual');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_identificacion`
--

CREATE TABLE `tipo_identificacion` (
  `id` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `tipo_identificacion` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_identificacion`
--

INSERT INTO `tipo_identificacion` (`id`, `estado`, `tipo_identificacion`) VALUES
(1, b'1', 'Natural'),
(2, b'1', 'Jurídica ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_tramite`
--

CREATE TABLE `tipo_tramite` (
  `id` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `tipo_tramite` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tramites`
--

CREATE TABLE `tramites` (
  `id` int(11) NOT NULL,
  `cod_tramite` varchar(6) DEFAULT NULL,
  `estado_tramite` bit(1) NOT NULL,
  `fecha_denuncia` datetime NOT NULL,
  `policia_id` int(11) DEFAULT NULL,
  `tipo_tramite_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `apellido_materno` varchar(100) NOT NULL,
  `apellido_paterno` varchar(100) NOT NULL,
  `direccion` varchar(500) DEFAULT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `numero_identificacion` varchar(11) NOT NULL,
  `sexo` varchar(25) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `vigencia` bit(1) NOT NULL,
  `contraseña` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `estado_civil_id` int(11) DEFAULT NULL,
  `tipo_identificacion_id` int(11) DEFAULT NULL,
  `denuncia_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `apellido_materno`, `apellido_paterno`, `direccion`, `fecha_nacimiento`, `nombres`, `numero_identificacion`, `sexo`, `telefono`, `vigencia`, `contraseña`, `correo`, `distrito_id`, `estado_civil_id`, `tipo_identificacion_id`, `denuncia_id`) VALUES
(1, 'TUESTA', 'VEINTIMILLA', 'No existe información', '1975-03-27 19:00:00', 'JESUS', '01139746', 'M', '968458123', b'1', 'jesusita', 'jesusvt74@gmail.com', 1, 2, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vinculo_parte_denunciada`
--

CREATE TABLE `vinculo_parte_denunciada` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vinculo_parte_denunciada`
--

INSERT INTO `vinculo_parte_denunciada` (`id`, `nombre`) VALUES
(1, 'Laboral'),
(2, 'Familiar'),
(3, 'Otro');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `agraviado`
--
ALTER TABLE `agraviado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKs10tsb03yt7jsi0i8jvenvl0c` (`distrito_id`),
  ADD KEY `FK5yttjtko7rj6ke3gexdm7ub5l` (`estado_civil_id`),
  ADD KEY `FK5gr4k3j6ihy2qhhx932fx7dc` (`tipo_identificacion_id`),
  ADD KEY `FK55h3rai4hxq4tudatpesmxnnm` (`informacion_adicional_id`);

--
-- Indices de la tabla `denuncia`
--
ALTER TABLE `denuncia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8f8ks02c6l8fufy7caj02sfko` (`distrito_id`),
  ADD KEY `FKixrvil4j93k7dm6iimgs73ask` (`policia_id`),
  ADD KEY `FKgu959qvh6xjtpue63lx2eki8b` (`tipo_denuncia_id`),
  ADD KEY `FKbe8wy8rcie9vw5d87tvvc6bpe` (`vinculo_parte_denunciada_id`);

--
-- Indices de la tabla `denunciado`
--
ALTER TABLE `denunciado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpp8fm9pcxihmo1cvwspme94di` (`distrito_id`),
  ADD KEY `FKdkgvv68btolww5k771hfjj0ui` (`estado_civil_id`),
  ADD KEY `FK6osrdikoh327sbmy599txujqh` (`tipo_identificacion_id`),
  ADD KEY `FKaomr9hna5a90wbkxtnnu3blhx` (`informacion_adicional_id`);

--
-- Indices de la tabla `denuncia_agraviado`
--
ALTER TABLE `denuncia_agraviado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2g8otpu7x8gu1hps87mvgcv92` (`denuncia_id`),
  ADD KEY `FKskr1nj4tddr20kyvtuoqwgg1n` (`agraviado_id`);

--
-- Indices de la tabla `denuncia_denunciado`
--
ALTER TABLE `denuncia_denunciado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdxf7n0uc3pg1mretcgtixbj1o` (`denuncia_id`),
  ADD KEY `FKlein05lvcee4634u1phl787` (`denunciado_id`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `distrito`
--
ALTER TABLE `distrito`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKggh71vt60yk095b7pkandqqm3` (`provincia_id`);

--
-- Indices de la tabla `estado_civil`
--
ALTER TABLE `estado_civil`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `gradopnp`
--
ALTER TABLE `gradopnp`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `informacion_adicional`
--
ALTER TABLE `informacion_adicional`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `loginpnp`
--
ALTER TABLE `loginpnp`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj8dhm4cbleh3jm1rfl1xbs4sb` (`policia_id`);

--
-- Indices de la tabla `policia`
--
ALTER TABLE `policia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg8vpj6rbf1nva9nj5shv574af` (`distrito_id`),
  ADD KEY `FKk60de9n0oilaode3fgfyf1w8y` (`estado_civil_id`),
  ADD KEY `FK5tlajpacafytg4x6daw6d8htv` (`tipo_identificacion_id`),
  ADD KEY `FKnoi993o4inprijmbcj9ugf3e3` (`gradopnp_id`);

--
-- Indices de la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKch1bpe1o4xybleki03vkp4vn2` (`departamento_id`);

--
-- Indices de la tabla `tipo_denuncia`
--
ALTER TABLE `tipo_denuncia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_identificacion`
--
ALTER TABLE `tipo_identificacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_tramite`
--
ALTER TABLE `tipo_tramite`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tramites`
--
ALTER TABLE `tramites`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKi0hl9po658v8lxn02urfoc4oj` (`policia_id`),
  ADD KEY `FKcmdmxilpwqivw1c77wad1p7r` (`tipo_tramite_id`),
  ADD KEY `FKidm7xp7d30tit4vhpe2qbfs6r` (`usuario_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKchewm4xo4im0mko3ey1vubo4k` (`distrito_id`),
  ADD KEY `FK3r4npxs5fatiehfs7l36sr1hu` (`estado_civil_id`),
  ADD KEY `FKigmmpmww73h88p1hutybohtum` (`tipo_identificacion_id`);

--
-- Indices de la tabla `vinculo_parte_denunciada`
--
ALTER TABLE `vinculo_parte_denunciada`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `agraviado`
--
ALTER TABLE `agraviado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `denuncia`
--
ALTER TABLE `denuncia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `denunciado`
--
ALTER TABLE `denunciado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `denuncia_agraviado`
--
ALTER TABLE `denuncia_agraviado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `denuncia_denunciado`
--
ALTER TABLE `denuncia_denunciado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `distrito`
--
ALTER TABLE `distrito`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `estado_civil`
--
ALTER TABLE `estado_civil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `gradopnp`
--
ALTER TABLE `gradopnp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `informacion_adicional`
--
ALTER TABLE `informacion_adicional`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `loginpnp`
--
ALTER TABLE `loginpnp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `policia`
--
ALTER TABLE `policia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `provincia`
--
ALTER TABLE `provincia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_denuncia`
--
ALTER TABLE `tipo_denuncia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_identificacion`
--
ALTER TABLE `tipo_identificacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_tramite`
--
ALTER TABLE `tipo_tramite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tramites`
--
ALTER TABLE `tramites`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `vinculo_parte_denunciada`
--
ALTER TABLE `vinculo_parte_denunciada`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `agraviado`
--
ALTER TABLE `agraviado`
  ADD CONSTRAINT `FK55h3rai4hxq4tudatpesmxnnm` FOREIGN KEY (`informacion_adicional_id`) REFERENCES `informacion_adicional` (`id`),
  ADD CONSTRAINT `FK5gr4k3j6ihy2qhhx932fx7dc` FOREIGN KEY (`tipo_identificacion_id`) REFERENCES `tipo_identificacion` (`id`),
  ADD CONSTRAINT `FK5yttjtko7rj6ke3gexdm7ub5l` FOREIGN KEY (`estado_civil_id`) REFERENCES `estado_civil` (`id`),
  ADD CONSTRAINT `FKs10tsb03yt7jsi0i8jvenvl0c` FOREIGN KEY (`distrito_id`) REFERENCES `distrito` (`id`);

--
-- Filtros para la tabla `denuncia`
--
ALTER TABLE `denuncia`
  ADD CONSTRAINT `FK8f8ks02c6l8fufy7caj02sfko` FOREIGN KEY (`distrito_id`) REFERENCES `distrito` (`id`),
  ADD CONSTRAINT `FKbe8wy8rcie9vw5d87tvvc6bpe` FOREIGN KEY (`vinculo_parte_denunciada_id`) REFERENCES `vinculo_parte_denunciada` (`id`),
  ADD CONSTRAINT `FKgu959qvh6xjtpue63lx2eki8b` FOREIGN KEY (`tipo_denuncia_id`) REFERENCES `tipo_denuncia` (`id`),
  ADD CONSTRAINT `FKixrvil4j93k7dm6iimgs73ask` FOREIGN KEY (`policia_id`) REFERENCES `policia` (`id`);

--
-- Filtros para la tabla `denunciado`
--
ALTER TABLE `denunciado`
  ADD CONSTRAINT `FK6osrdikoh327sbmy599txujqh` FOREIGN KEY (`tipo_identificacion_id`) REFERENCES `tipo_identificacion` (`id`),
  ADD CONSTRAINT `FKaomr9hna5a90wbkxtnnu3blhx` FOREIGN KEY (`informacion_adicional_id`) REFERENCES `informacion_adicional` (`id`),
  ADD CONSTRAINT `FKdkgvv68btolww5k771hfjj0ui` FOREIGN KEY (`estado_civil_id`) REFERENCES `estado_civil` (`id`),
  ADD CONSTRAINT `FKpp8fm9pcxihmo1cvwspme94di` FOREIGN KEY (`distrito_id`) REFERENCES `distrito` (`id`);

--
-- Filtros para la tabla `denuncia_agraviado`
--
ALTER TABLE `denuncia_agraviado`
  ADD CONSTRAINT `FK2g8otpu7x8gu1hps87mvgcv92` FOREIGN KEY (`denuncia_id`) REFERENCES `denuncia` (`id`),
  ADD CONSTRAINT `FKskr1nj4tddr20kyvtuoqwgg1n` FOREIGN KEY (`agraviado_id`) REFERENCES `agraviado` (`id`);

--
-- Filtros para la tabla `denuncia_denunciado`
--
ALTER TABLE `denuncia_denunciado`
  ADD CONSTRAINT `FKdxf7n0uc3pg1mretcgtixbj1o` FOREIGN KEY (`denuncia_id`) REFERENCES `denuncia` (`id`),
  ADD CONSTRAINT `FKlein05lvcee4634u1phl787` FOREIGN KEY (`denunciado_id`) REFERENCES `denunciado` (`id`);

--
-- Filtros para la tabla `distrito`
--
ALTER TABLE `distrito`
  ADD CONSTRAINT `FKggh71vt60yk095b7pkandqqm3` FOREIGN KEY (`provincia_id`) REFERENCES `provincia` (`id`);

--
-- Filtros para la tabla `loginpnp`
--
ALTER TABLE `loginpnp`
  ADD CONSTRAINT `FKj8dhm4cbleh3jm1rfl1xbs4sb` FOREIGN KEY (`policia_id`) REFERENCES `policia` (`id`);

--
-- Filtros para la tabla `policia`
--
ALTER TABLE `policia`
  ADD CONSTRAINT `FK5tlajpacafytg4x6daw6d8htv` FOREIGN KEY (`tipo_identificacion_id`) REFERENCES `tipo_identificacion` (`id`),
  ADD CONSTRAINT `FKg8vpj6rbf1nva9nj5shv574af` FOREIGN KEY (`distrito_id`) REFERENCES `distrito` (`id`),
  ADD CONSTRAINT `FKk60de9n0oilaode3fgfyf1w8y` FOREIGN KEY (`estado_civil_id`) REFERENCES `estado_civil` (`id`),
  ADD CONSTRAINT `FKnoi993o4inprijmbcj9ugf3e3` FOREIGN KEY (`gradopnp_id`) REFERENCES `gradopnp` (`id`);

--
-- Filtros para la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD CONSTRAINT `FKch1bpe1o4xybleki03vkp4vn2` FOREIGN KEY (`departamento_id`) REFERENCES `departamento` (`id`);

--
-- Filtros para la tabla `tramites`
--
ALTER TABLE `tramites`
  ADD CONSTRAINT `FKcmdmxilpwqivw1c77wad1p7r` FOREIGN KEY (`tipo_tramite_id`) REFERENCES `tipo_tramite` (`id`),
  ADD CONSTRAINT `FKi0hl9po658v8lxn02urfoc4oj` FOREIGN KEY (`policia_id`) REFERENCES `policia` (`id`),
  ADD CONSTRAINT `FKidm7xp7d30tit4vhpe2qbfs6r` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK3r4npxs5fatiehfs7l36sr1hu` FOREIGN KEY (`estado_civil_id`) REFERENCES `estado_civil` (`id`),
  ADD CONSTRAINT `FKchewm4xo4im0mko3ey1vubo4k` FOREIGN KEY (`distrito_id`) REFERENCES `distrito` (`id`),
  ADD CONSTRAINT `FKhkkh3iy883budx4ur2vyar7vr` FOREIGN KEY (`denuncia_id`) REFERENCES `denuncia` (`id`),
  ADD CONSTRAINT `FKigmmpmww73h88p1hutybohtum` FOREIGN KEY (`tipo_identificacion_id`) REFERENCES `tipo_identificacion` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
