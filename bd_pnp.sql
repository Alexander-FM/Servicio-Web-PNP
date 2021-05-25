-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-05-2021 a las 02:31:11
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
  `nombres` varchar(100) NOT NULL,
  `sexo` varchar(25) NOT NULL,
  `vigencia` bit(1) NOT NULL,
  `detalle_proteccion` varchar(500) DEFAULT NULL,
  `direccion` varchar(500) DEFAULT NULL,
  `fecha_emision` date DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `juzgado` varchar(100) DEFAULT NULL,
  `medida_proteccion` bit(1) NOT NULL,
  `numero_identificacion` varchar(11) NOT NULL,
  `rhd` varchar(500) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `tipo_identificacion_id` int(11) DEFAULT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `estado_civil_id` int(11) DEFAULT NULL,
  `informacion_adicional_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `agraviado`
--

INSERT INTO `agraviado` (`id`, `apellido_materno`, `apellido_paterno`, `nombres`, `sexo`, `vigencia`, `detalle_proteccion`, `direccion`, `fecha_emision`, `fecha_nacimiento`, `juzgado`, `medida_proteccion`, `numero_identificacion`, `rhd`, `telefono`, `tipo_identificacion_id`, `distrito_id`, `estado_civil_id`, `informacion_adicional_id`) VALUES
(1, 'MEOÑO', 'MEDINA', 'MARY LEONOR', 'Femenino', b'0', NULL, 'Calle Sucre N.° 903', NULL, '0035-10-20', NULL, b'0', '17432825', 'El sujeto me agredió físicamente tomando mis pertenencias de mi cartera y llevándose mi dinero.', '938707148', 1, 8, 1, 2),
(14, 'MEDINA', 'FUENTES', 'LUIGUI ALEXANDER', 'Masculino', b'0', NULL, 'Calle Sucre 903', NULL, '2022-01-19', NULL, b'0', '78019778', 'Mi primo me pego salvajemente', '917967148', 1, 8, 1, 3),
(15, 'MEDINA', 'FUENTES', 'LUIGUI ALEXANDER', 'Masculino', b'0', NULL, 'Calle Sucre 903', NULL, '2022-01-19', NULL, b'0', '78019778', 'El sujeto me agredió injustamente y robo mis pertenencias.', '917967148', 1, 8, 1, 3),
(16, 'MEDINA', 'FUENTES', 'LUIGUI ALEXANDER', 'Masculino', b'0', NULL, 'Calle Sucre 903', NULL, '2022-01-19', NULL, b'0', '78019778', 'Me golpeó salvajemente', '917967148', 1, 8, 1, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comisarias`
--

CREATE TABLE `comisarias` (
  `id` int(11) NOT NULL,
  `nombre_comisaria` varchar(255) NOT NULL,
  `direccion_comisaria` varchar(500) NOT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `telefono_comisaria` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comisarias`
--

INSERT INTO `comisarias` (`id`, `nombre_comisaria`, `direccion_comisaria`, `distrito_id`, `telefono_comisaria`) VALUES
(1, 'Comisaria Del Norte', 'Francisco Cuneo Salazar 1119', 1, '074229697'),
(2, 'Comisaría Campodónico', 'Dirección: Av. Jorge Chavez 801', 1, '074227351'),
(3, 'Comisaria El Porvenir', 'Arica 499', 1, '074228030'),
(4, 'Comisaria de la Familia', 'Av. José Balta, Chiclayo', 2, '074238336');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denuncia`
--

CREATE TABLE `denuncia` (
  `id` int(11) NOT NULL,
  `cod_denuncia` varchar(8) DEFAULT NULL,
  `direccion` varchar(500) NOT NULL,
  `estado_denuncia` bit(1) DEFAULT NULL,
  `fecha_denuncia` date NOT NULL,
  `fecha_hechos` date NOT NULL,
  `hora_denuncia` time NOT NULL,
  `hora_hechos` time NOT NULL,
  `referencia_direccion` varchar(500) NOT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `policia_id` int(11) DEFAULT NULL,
  `tipo_denuncia_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `vinculo_parte_denunciada_id` int(11) DEFAULT NULL,
  `comisaria_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `denuncia`
--

INSERT INTO `denuncia` (`id`, `cod_denuncia`, `direccion`, `estado_denuncia`, `fecha_denuncia`, `fecha_hechos`, `hora_denuncia`, `hora_hechos`, `referencia_direccion`, `distrito_id`, `policia_id`, `tipo_denuncia_id`, `usuario_id`, `vinculo_parte_denunciada_id`, `comisaria_id`) VALUES
(1, '? ? ?', 'Calle San Juan N.° 457', b'0', '2021-05-07', '2021-05-06', '16:10:40', '08:50:00', 'Frente al colegio Manuel Santos Chocano.', 8, 1, 1, 1, 3, 4),
(11, '? ? ?', 'Calle Bolivar N. 234', b'0', '2021-05-22', '2021-05-21', '01:02:23', '09:58:00', 'Frente al complejo deportivo', 2, 1, 1, 2, 1, 3),
(12, '? ? ?', 'Av. Quiñones N.° 234', b'0', '2021-05-23', '2021-05-23', '17:05:35', '10:00:00', 'Frente al grifo \"Los Fuentes\"', 1, 1, 1, 2, 3, 4),
(13, '? ? ?', 'Calle San Juan N.° 234', b'0', '2021-05-24', '2021-05-23', '18:56:11', '13:53:00', 'Frente al parque los olvidos', 2, 1, 1, 2, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denunciado`
--

CREATE TABLE `denunciado` (
  `id` int(11) NOT NULL,
  `apellido_materno` varchar(100) NOT NULL,
  `apellido_paterno` varchar(100) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `sexo` varchar(25) NOT NULL,
  `vigencia` bit(1) NOT NULL,
  `tipo_identificacion_id` int(11) DEFAULT NULL,
  `informacion_adicional_id` int(11) DEFAULT NULL,
  `numero_identificacion` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `denunciado`
--

INSERT INTO `denunciado` (`id`, `apellido_materno`, `apellido_paterno`, `nombres`, `sexo`, `vigencia`, `tipo_identificacion_id`, `informacion_adicional_id`, `numero_identificacion`) VALUES
(1, 'Purizaca', 'Torres', 'Juan José', 'Masculino', b'0', 1, 3, '78961236'),
(14, 'MEDINA', 'SANCHEZ', 'STEPHANO', 'Masculino', b'0', 1, 3, '65782369'),
(15, 'CORONADO', 'LLAMO', 'ROSENDO', 'Masculino', b'0', 1, 2, '45963258'),
(16, 'PÉREZ', 'MARTÍNEZ', 'CARLOS ALEJANDRO', 'Masculino', b'0', 1, 2, '98854632');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denuncia_agraviado`
--

CREATE TABLE `denuncia_agraviado` (
  `id` int(11) NOT NULL,
  `agraviado_id` int(11) DEFAULT NULL,
  `denuncia_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `denuncia_agraviado`
--

INSERT INTO `denuncia_agraviado` (`id`, `agraviado_id`, `denuncia_id`) VALUES
(1, 1, 1),
(14, 14, 11),
(15, 15, 12),
(16, 16, 13);

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
(1, 1, 1),
(14, 11, 14),
(15, 12, 15),
(16, 13, 16);

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
  `distrito` varchar(100) NOT NULL,
  `codigo_postal` varchar(5) NOT NULL,
  `estado` bit(1) NOT NULL,
  `provincia_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `distrito`
--

INSERT INTO `distrito` (`id`, `distrito`, `codigo_postal`, `estado`, `provincia_id`) VALUES
(1, 'La Victoria', '14000', b'1', 1),
(2, 'Chiclayo', '14001', b'1', 1),
(3, 'Pimentel', '14012', b'1', 1),
(4, 'Reque', '14800', b'1', 1),
(5, 'Cayaltí', '14720', b'1', 1),
(6, 'Monsefú', '14830', b'1', 1),
(7, 'Pueblo Nuevo', '14311', b'0', 2),
(8, 'Ferreñafe', '14310', b'1', 2),
(9, 'Salas', '14230', b'1', 3),
(10, 'Olmos', '14210', b'1', 3),
(11, 'José Leonardo Ortiz', '14002', b'1', 1);

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
(4, b'1', 'Viudo'),
(5, b'1', 'Divorciado');

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
(1, 'Coronel', b'1'),
(2, 'Mayor PNP', b'1'),
(3, 'Sub Oficial de tercera', b'1'),
(4, 'Oficial', b'1');

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
(1, 'Niño(a)'),
(2, 'Señor(a)'),
(3, 'Joven'),
(4, 'Población LGTBI');

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
  `nombres` varchar(100) NOT NULL,
  `sexo` varchar(25) NOT NULL,
  `vigencia` bit(1) NOT NULL,
  `direccion` varchar(500) DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `numero_identificacion` varchar(11) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `tipo_identificacion_id` int(11) DEFAULT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `estado_civil_id` int(11) DEFAULT NULL,
  `gradopnp_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `policia`
--

INSERT INTO `policia` (`id`, `apellido_materno`, `apellido_paterno`, `nombres`, `sexo`, `vigencia`, `direccion`, `estado`, `fecha_nacimiento`, `numero_identificacion`, `telefono`, `tipo_identificacion_id`, `distrito_id`, `estado_civil_id`, `gradopnp_id`) VALUES
(1, 'Tafur', 'Portocarrero', 'Ana Rosa', 'F', b'1', 'Calle San Jose N.º 423', b'1', '1980-05-03', '78546213', '963147856', 1, 2, 1, 2);

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
(2, b'1', 'Ferreñafe', 1),
(3, b'1', 'Lambayeque', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sugerencia`
--

CREATE TABLE `sugerencia` (
  `id` int(11) NOT NULL,
  `comentario` varchar(1000) NOT NULL,
  `estrellas` float NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sugerencia`
--

INSERT INTO `sugerencia` (`id`, `comentario`, `estrellas`, `usuario_id`) VALUES
(1, 'Me gusta mucho está versión se ha mejorado algunos aspectos y el módulo de denuncias se ha corregido bastante, mejor dicho se ha mejorado la experiencia de usuario.', 2, 1);

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
(2, b'1', 'Sexual'),
(3, b'1', 'Psicológica'),
(4, b'1', 'Económica');

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

--
-- Volcado de datos para la tabla `tipo_tramite`
--

INSERT INTO `tipo_tramite` (`id`, `estado`, `tipo_tramite`) VALUES
(1, b'1', 'Copia Certificada'),
(2, b'1', 'Solicitud');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tramite`
--

CREATE TABLE `tramite` (
  `id` int(11) NOT NULL,
  `cod_tramite` varchar(6) DEFAULT NULL,
  `correo` varchar(256) DEFAULT NULL,
  `estado_tramite` bit(1) NOT NULL,
  `fecha_tramite` date NOT NULL,
  `hora_tramite` time NOT NULL,
  `policia_id` int(11) DEFAULT NULL,
  `tipo_tramite_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tramite`
--

INSERT INTO `tramite` (`id`, `cod_tramite`, `correo`, `estado_tramite`, `fecha_tramite`, `hora_tramite`, `policia_id`, `tipo_tramite_id`, `usuario_id`) VALUES
(1, '---', 'maryleonormm30@hotmail.com', b'0', '2021-05-10', '23:40:52', 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `apellido_materno` varchar(100) NOT NULL,
  `apellido_paterno` varchar(100) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `sexo` varchar(25) NOT NULL,
  `vigencia` bit(1) NOT NULL,
  `contraseña` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `direccion` varchar(500) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `numero_identificacion` varchar(11) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `tipo_identificacion_id` int(11) DEFAULT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `estado_civil_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `apellido_materno`, `apellido_paterno`, `nombres`, `sexo`, `vigencia`, `contraseña`, `correo`, `direccion`, `fecha_nacimiento`, `numero_identificacion`, `telefono`, `tipo_identificacion_id`, `distrito_id`, `estado_civil_id`) VALUES
(1, 'MEOÑO', 'MEDINA', 'MARY LEONOR', 'F', b'1', 'admin', 'maryleonormm30@hotmail.com', 'Calle Sucre N.° 903', '0035-09-22', '17432825', '938707148', 1, 8, 3),
(2, 'MEDINA', 'FUENTES', 'LUIGUI ALEXANDER', 'H', b'1', 'admin', 'alexanderfuentes199912@gmail.com', 'Calle Sucre 903', '2021-12-19', '78019778', '917967148', 1, 8, 2);

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
(1, 'Familiar'),
(2, 'Laboral'),
(3, 'Otro');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `agraviado`
--
ALTER TABLE `agraviado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5gr4k3j6ihy2qhhx932fx7dc` (`tipo_identificacion_id`),
  ADD KEY `FKs10tsb03yt7jsi0i8jvenvl0c` (`distrito_id`),
  ADD KEY `FK5yttjtko7rj6ke3gexdm7ub5l` (`estado_civil_id`),
  ADD KEY `FK55h3rai4hxq4tudatpesmxnnm` (`informacion_adicional_id`);

--
-- Indices de la tabla `comisarias`
--
ALTER TABLE `comisarias`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj6j9botflyw1w76bk4oiee0qe` (`distrito_id`);

--
-- Indices de la tabla `denuncia`
--
ALTER TABLE `denuncia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8f8ks02c6l8fufy7caj02sfko` (`distrito_id`),
  ADD KEY `FKixrvil4j93k7dm6iimgs73ask` (`policia_id`),
  ADD KEY `FKgu959qvh6xjtpue63lx2eki8b` (`tipo_denuncia_id`),
  ADD KEY `FKtjlwue48v7ycj9cu55luadafn` (`usuario_id`),
  ADD KEY `FKbe8wy8rcie9vw5d87tvvc6bpe` (`vinculo_parte_denunciada_id`),
  ADD KEY `FK16wj5230tx5vsmitig4363ntv` (`comisaria_id`);

--
-- Indices de la tabla `denunciado`
--
ALTER TABLE `denunciado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6osrdikoh327sbmy599txujqh` (`tipo_identificacion_id`),
  ADD KEY `FKaomr9hna5a90wbkxtnnu3blhx` (`informacion_adicional_id`);

--
-- Indices de la tabla `denuncia_agraviado`
--
ALTER TABLE `denuncia_agraviado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKskr1nj4tddr20kyvtuoqwgg1n` (`agraviado_id`),
  ADD KEY `FK2g8otpu7x8gu1hps87mvgcv92` (`denuncia_id`);

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
  ADD KEY `FK5tlajpacafytg4x6daw6d8htv` (`tipo_identificacion_id`),
  ADD KEY `FKg8vpj6rbf1nva9nj5shv574af` (`distrito_id`),
  ADD KEY `FKk60de9n0oilaode3fgfyf1w8y` (`estado_civil_id`),
  ADD KEY `FKnoi993o4inprijmbcj9ugf3e3` (`gradopnp_id`);

--
-- Indices de la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKch1bpe1o4xybleki03vkp4vn2` (`departamento_id`);

--
-- Indices de la tabla `sugerencia`
--
ALTER TABLE `sugerencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh4gn81v71sn1ffk1mfbfqe33h` (`usuario_id`);

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
-- Indices de la tabla `tramite`
--
ALTER TABLE `tramite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbc1ma81m0yruodajj2aoccj9l` (`policia_id`),
  ADD KEY `FKj6nxvtq5mc9n9u08rct5m15e8` (`tipo_tramite_id`),
  ADD KEY `FK6lg0s1ri0dgu25ufs39iq5ft1` (`usuario_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKigmmpmww73h88p1hutybohtum` (`tipo_identificacion_id`),
  ADD KEY `FKchewm4xo4im0mko3ey1vubo4k` (`distrito_id`),
  ADD KEY `FK3r4npxs5fatiehfs7l36sr1hu` (`estado_civil_id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `comisarias`
--
ALTER TABLE `comisarias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `denuncia`
--
ALTER TABLE `denuncia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `denunciado`
--
ALTER TABLE `denunciado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `denuncia_agraviado`
--
ALTER TABLE `denuncia_agraviado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `denuncia_denunciado`
--
ALTER TABLE `denuncia_denunciado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `distrito`
--
ALTER TABLE `distrito`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `estado_civil`
--
ALTER TABLE `estado_civil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `gradopnp`
--
ALTER TABLE `gradopnp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `informacion_adicional`
--
ALTER TABLE `informacion_adicional`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `loginpnp`
--
ALTER TABLE `loginpnp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `policia`
--
ALTER TABLE `policia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `provincia`
--
ALTER TABLE `provincia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `sugerencia`
--
ALTER TABLE `sugerencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipo_denuncia`
--
ALTER TABLE `tipo_denuncia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipo_identificacion`
--
ALTER TABLE `tipo_identificacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_tramite`
--
ALTER TABLE `tipo_tramite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tramite`
--
ALTER TABLE `tramite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
-- Filtros para la tabla `comisarias`
--
ALTER TABLE `comisarias`
  ADD CONSTRAINT `FKj6j9botflyw1w76bk4oiee0qe` FOREIGN KEY (`distrito_id`) REFERENCES `distrito` (`id`);

--
-- Filtros para la tabla `denuncia`
--
ALTER TABLE `denuncia`
  ADD CONSTRAINT `FK16wj5230tx5vsmitig4363ntv` FOREIGN KEY (`comisaria_id`) REFERENCES `comisarias` (`id`),
  ADD CONSTRAINT `FK8f8ks02c6l8fufy7caj02sfko` FOREIGN KEY (`distrito_id`) REFERENCES `distrito` (`id`),
  ADD CONSTRAINT `FKbe8wy8rcie9vw5d87tvvc6bpe` FOREIGN KEY (`vinculo_parte_denunciada_id`) REFERENCES `vinculo_parte_denunciada` (`id`),
  ADD CONSTRAINT `FKgu959qvh6xjtpue63lx2eki8b` FOREIGN KEY (`tipo_denuncia_id`) REFERENCES `tipo_denuncia` (`id`),
  ADD CONSTRAINT `FKixrvil4j93k7dm6iimgs73ask` FOREIGN KEY (`policia_id`) REFERENCES `policia` (`id`),
  ADD CONSTRAINT `FKtjlwue48v7ycj9cu55luadafn` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `denunciado`
--
ALTER TABLE `denunciado`
  ADD CONSTRAINT `FK6osrdikoh327sbmy599txujqh` FOREIGN KEY (`tipo_identificacion_id`) REFERENCES `tipo_identificacion` (`id`),
  ADD CONSTRAINT `FKaomr9hna5a90wbkxtnnu3blhx` FOREIGN KEY (`informacion_adicional_id`) REFERENCES `informacion_adicional` (`id`);

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
-- Filtros para la tabla `sugerencia`
--
ALTER TABLE `sugerencia`
  ADD CONSTRAINT `FKh4gn81v71sn1ffk1mfbfqe33h` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `tramite`
--
ALTER TABLE `tramite`
  ADD CONSTRAINT `FK6lg0s1ri0dgu25ufs39iq5ft1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FKbc1ma81m0yruodajj2aoccj9l` FOREIGN KEY (`policia_id`) REFERENCES `policia` (`id`),
  ADD CONSTRAINT `FKj6nxvtq5mc9n9u08rct5m15e8` FOREIGN KEY (`tipo_tramite_id`) REFERENCES `tipo_tramite` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK3r4npxs5fatiehfs7l36sr1hu` FOREIGN KEY (`estado_civil_id`) REFERENCES `estado_civil` (`id`),
  ADD CONSTRAINT `FKchewm4xo4im0mko3ey1vubo4k` FOREIGN KEY (`distrito_id`) REFERENCES `distrito` (`id`),
  ADD CONSTRAINT `FKigmmpmww73h88p1hutybohtum` FOREIGN KEY (`tipo_identificacion_id`) REFERENCES `tipo_identificacion` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
