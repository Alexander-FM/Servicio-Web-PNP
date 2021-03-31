-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-03-2021 a las 23:14:55
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.1

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
  `juzgado` varchar(100) DEFAULT NULL,
  `rhd` varchar(500) NOT NULL,
  `apellidos_agraviado` varchar(100) NOT NULL,
  `detalle_proteccion` varchar(500) DEFAULT NULL,
  `fecha_emision` datetime DEFAULT NULL,
  `fecha_nac` datetime NOT NULL,
  `medida_proteccion` bit(1) NOT NULL,
  `nombre_agraviado` varchar(100) NOT NULL,
  `numero_doc` varchar(11) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `informacion_adicional_id` int(11) DEFAULT NULL,
  `tipo_identificacion_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `agraviado`
--

INSERT INTO `agraviado` (`id`, `juzgado`, `rhd`, `apellidos_agraviado`, `detalle_proteccion`, `fecha_emision`, `fecha_nac`, `medida_proteccion`, `nombre_agraviado`, `numero_doc`, `sexo`, `telefono`, `distrito_id`, `informacion_adicional_id`, `tipo_identificacion_id`) VALUES
(3, NULL, 'Me golpearon salvajemente', 'Fuentes Medina', NULL, NULL, '1999-12-19 14:30:00', b'0', 'Alexander', '78019778', 'M', '951357852', 3, 1, 1),
(4, NULL, 'Fui ultraja por tres amigos míos en una noche de fiesta', 'Rodriguez Oxenford', NULL, NULL, '1995-03-10 13:21:04', b'0', 'Martha Julia', '45542552', 'F', '978936111', 1, 1, 1),
(5, NULL, 'Fui agredida por mis tíos en casa de mis padres, trato de asesinarme con un cuchillo', 'Capitan Ballona', NULL, NULL, '1998-10-16 15:22:39', b'0', 'Katherine', '44488877', 'F', '987789944', 2, 1, 1),
(6, NULL, 'Mi tío abuso sexualmente de mi ofreciéndome un chocolate.', 'Chicoma Chicoma', NULL, NULL, '1995-03-31 07:22:39', b'0', 'Jhair', '45528791', 'M', '955996696', 4, 1, 1),
(7, 'Juzgado Familiar', 'Mi esposo me insulta todos los días y me golpea salvajemente.', 'Sirlopu Carrion', 'Que el esposo no se le acerca 1km a la redonda', '2021-03-09 13:53:25', '2000-08-31 07:22:40', b'1', 'Yadhira ', '65567887', 'F', '944987682', 1, 1, 1),
(8, NULL, 'Mi enamorado mucho me insulta cuando llego de trabajar', 'Yupanqui Torres', NULL, NULL, '1998-03-22 13:59:37', b'0', 'Camila', '58854554', 'F', '963147856', 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denuncia`
--

CREATE TABLE `denuncia` (
  `id` int(11) NOT NULL,
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

INSERT INTO `denuncia` (`id`, `direccion`, `estado_denuncia`, `fecha_denuncia`, `fecha_hechos`, `referencia_direccion`, `distrito_id`, `policia_id`, `tipo_denuncia_id`, `vinculo_parte_denunciada_id`) VALUES
(1, 'Las Palmeras', b'0', '2021-03-08 16:44:41', '2021-03-05 16:44:50', 'Frente a al parque virgen de túcume', 3, 1, 1, 3),
(2, 'Calle San Juan Bosco N.230', b'1', '2021-03-09 14:15:22', '2021-03-02 14:15:22', 'Por el parque principal de san juan bosco', 3, 2, 1, 2),
(3, 'Calle San Ramon N.º 230', b'0', '2021-03-09 15:47:49', '2021-03-03 15:47:49', 'Por el complejo deportivo', 3, 3, 3, 2),
(4, 'Calle San Tomas SN', b'0', '2020-03-09 16:45:31', '2020-02-04 16:45:31', 'No existe información', 1, 3, 1, 2),
(5, 'Av. Carrion N.º 450', b'1', '2021-03-09 16:45:31', '2021-02-01 16:45:31', 'No existe Informacion', 4, 1, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denunciado`
--

CREATE TABLE `denunciado` (
  `id` int(11) NOT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `direccion` varchar(500) DEFAULT NULL,
  `nombres` varchar(100) DEFAULT NULL,
  `numero_identificacion` varchar(11) DEFAULT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `estado_civil_id` int(11) DEFAULT NULL,
  `informacion_adicional_id` int(11) DEFAULT NULL,
  `tipo_identificacion_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `denunciado`
--

INSERT INTO `denunciado` (`id`, `apellidos`, `direccion`, `nombres`, `numero_identificacion`, `sexo`, `telefono`, `distrito_id`, `estado_civil_id`, `informacion_adicional_id`, `tipo_identificacion_id`) VALUES
(1, 'Chumioqui Quisque', 'Santa Elena N.º123', 'Alejandro Jose', '95874123', 'M', '939272190', 4, 2, 1, 1),
(2, 'Vargas Murrillo', 'Calle Jesus Maria N.º320', 'Takeshi Obed', '45547887', 'M', '915375465', 1, 2, 1, 1),
(3, 'Gastelo Díaz', 'Calle Ilo N.º450', 'Alexis', '65568558', 'M', '999555478', 4, 2, 1, 1),
(4, 'Torres Sandoval', 'Calle Marte N.º230', 'Miguel Angel', '25526336', 'M', '988876471', 2, 2, 2, 1),
(5, 'Coronado Llamo', 'Av. San Juan N.º230', 'Nahun Alfonso', '25529669', 'M', '933366636', 4, 2, 2, 1),
(6, 'Fernandez Huaman', 'Calle Junín N.º 555', 'Patrick', '20021221', 'M', '978897123', 2, 4, 2, 1),
(7, 'Medina Pisfil', 'Calle San Eduardo N.º 199', 'Alejandra María', '54458778', 'F', '978258312', 3, 2, 4, 1),
(8, 'Llanos Siesquen', 'Av. San Bartolome N.º 450', 'Francisco', '33399978', 'M', '931731982', 3, 2, 2, 1),
(9, 'Sandoval Chuquilin', 'Av. San Mariano Cornejo N.º304', 'Alejandro', '88779966', 'M', '944955966', 1, 2, 1, 1),
(10, 'Brenis Cornejo', 'Av. Santa Catalina N.º 128', 'Fernando', '22211133', 'M', '977918935', 1, 2, 1, 1);

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
-- Estructura de tabla para la tabla `detalle_denuncia`
--

CREATE TABLE `detalle_denuncia` (
  `id` int(11) NOT NULL,
  `agraviado_id` int(11) DEFAULT NULL,
  `denuncia_id` int(11) DEFAULT NULL,
  `denunciado_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_denuncia`
--

INSERT INTO `detalle_denuncia` (`id`, `agraviado_id`, `denuncia_id`, `denunciado_id`, `usuario_id`) VALUES
(1, 3, 1, 10, 1),
(2, 6, 2, 3, 4),
(3, 4, 3, 2, 2),
(4, 4, 3, 4, 2),
(5, 5, 4, 9, 3),
(6, 5, 4, 8, 3),
(7, 7, 5, 6, 8);

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
(1, 'Mayor PNP', b'1');

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
  `apellidos` varchar(100) NOT NULL,
  `estado` bit(1) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `numero_identificacion` varchar(11) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `gradopnp_id` int(11) DEFAULT NULL,
  `tipo_identificacion_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `policia`
--

INSERT INTO `policia` (`id`, `apellidos`, `estado`, `nombres`, `numero_identificacion`, `sexo`, `telefono`, `distrito_id`, `gradopnp_id`, `tipo_identificacion_id`) VALUES
(1, 'Portocarrero', b'1', 'Ana Rosa', '45541232', 'F', '963147856', 2, 1, 1),
(2, 'Torres Huallama', b'1', 'Alejandro', '11223344', 'M', '951357852', 2, 1, 1),
(3, 'Tejada Atoche', b'1', 'Jose Eduardo', '65885798', 'M', '951444789', 4, 1, 1);

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
  `contrasenia` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `numero_identificacion` varchar(11) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `vigencia` bit(1) NOT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `estado_civil_id` int(11) DEFAULT NULL,
  `tipo_identificacion_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `apellido_materno`, `apellido_paterno`, `contrasenia`, `email`, `fecha_nacimiento`, `nombres`, `numero_identificacion`, `sexo`, `telefono`, `vigencia`, `distrito_id`, `estado_civil_id`, `tipo_identificacion_id`) VALUES
(1, 'Medina', 'Fuentes', 'Sag12#', 'alexander@live.com', '1999-12-19 14:24:35', 'Alexander', '78019778', 'M', '951357852', b'1', 3, 2, 1),
(2, 'Rodriguez', 'Oxenford', '456', 'julimartha@gmail.com', '1995-03-10 13:21:04', 'Martha Julia', '45542552', 'F', '978936111', b'1', 1, 2, 1),
(3, 'Capitan', 'Ballona', 'kath123', 'kath@gmail.com', '1998-10-16 15:22:39', 'Katherine', '44488877', 'F', '987789944', b'1', 2, 2, 2),
(4, 'Mio', 'Chicoma', 'chi123', 'chicoma234', '1995-03-31 07:22:39', 'Jhair', '45528791', 'M', '955996696', b'1', 4, 2, 1),
(5, 'Portocarrero', 'Portocarrero', 'porto345', 'mipo@live.com', '1993-03-24 13:27:15', 'Milagros', '23325674', 'F', '915735111', b'1', 3, 2, 1),
(6, 'Lamadrid', 'Chaponoñan', 'S39#js', 'chapo569@hotmail.com', '1999-03-11 13:27:15', 'Juana', '65564884', 'F', '677619912', b'1', 3, 2, 1),
(7, 'Medina', 'Camacho', 'meca23', 'mecamacho@live.com', '2002-03-18 13:41:39', 'Mariacristina', '45985257', 'F', '999222555', b'1', 4, 2, 1),
(8, 'Carrion', 'Sirlopu', 'ya303', 'yadhira@gmail.com', '2000-08-31 07:22:40', 'Yadhira', '65567887', 'M', '944987682', b'1', 1, 2, 1);

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
  ADD KEY `FK55h3rai4hxq4tudatpesmxnnm` (`informacion_adicional_id`),
  ADD KEY `FK5gr4k3j6ihy2qhhx932fx7dc` (`tipo_identificacion_id`);

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
  ADD KEY `FKaomr9hna5a90wbkxtnnu3blhx` (`informacion_adicional_id`),
  ADD KEY `FK6osrdikoh327sbmy599txujqh` (`tipo_identificacion_id`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalle_denuncia`
--
ALTER TABLE `detalle_denuncia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbpai2dtcd9hwqlixp96bxtcq8` (`agraviado_id`),
  ADD KEY `FKtmswfn80r0rv4s88uosxas9k9` (`denuncia_id`),
  ADD KEY `FKspbncwa0h754uqs3o620mvbmo` (`denunciado_id`),
  ADD KEY `FKiacabek3di8fv7akjed6xhyqt` (`usuario_id`);

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
  ADD KEY `FKnoi993o4inprijmbcj9ugf3e3` (`gradopnp_id`),
  ADD KEY `FK5tlajpacafytg4x6daw6d8htv` (`tipo_identificacion_id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `denuncia`
--
ALTER TABLE `denuncia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `denunciado`
--
ALTER TABLE `denunciado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `detalle_denuncia`
--
ALTER TABLE `detalle_denuncia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

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
-- Filtros para la tabla `detalle_denuncia`
--
ALTER TABLE `detalle_denuncia`
  ADD CONSTRAINT `FKbpai2dtcd9hwqlixp96bxtcq8` FOREIGN KEY (`agraviado_id`) REFERENCES `agraviado` (`id`),
  ADD CONSTRAINT `FKiacabek3di8fv7akjed6xhyqt` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FKspbncwa0h754uqs3o620mvbmo` FOREIGN KEY (`denunciado_id`) REFERENCES `denunciado` (`id`),
  ADD CONSTRAINT `FKtmswfn80r0rv4s88uosxas9k9` FOREIGN KEY (`denuncia_id`) REFERENCES `denuncia` (`id`);

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
  ADD CONSTRAINT `FKidm7xp7d30tit4vhpe2qbfs6r` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

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
