-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: easybyte.club:2223:3306
-- Tiempo de generación: 12-11-2021 a las 12:24:55
-- Versión del servidor: 8.0.27
-- Versión de PHP: 7.4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `peixepop`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulos`
--

CREATE TABLE `articulos` (
  `codigo` char(12) NOT NULL,
  `descripcion` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `stock` smallint NOT NULL,
  `precio` float NOT NULL,
  `tipo_articulo` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `articulos`
--

INSERT INTO `articulos` (`codigo`, `descripcion`, `stock`, `precio`, `tipo_articulo`) VALUES
('6567acfo7182', 'Acondicionador para agua del grifo', 9, 3.49, 4),
('6576alas6983', 'Alimento en escamas', 300, 25, 3),
('6576alks8384', 'Alimento Sticks', 9, 2.95, 3),
('6576alño8069', 'Alimento para pez pequeño', 2, 7, 3),
('6578anun6779', 'Anubia común', 200, 15, 2),
('6583asor7982', 'Aspirador', 3, 52, 4),
('6765caon6869', 'Cascada para decoración', 1, 100.4, 4),
('6776clra5152', 'Cladophora 3-4cm', 3, 2.75, 2),
('6776clsh7073', 'ClownFish', 70, 9.99, 1),
('6779coas8479', 'Comida tortugas', 30, 4, 3),
('6779core6573', 'Compresor de aire', 8, 10.08, 4),
('7073fios7983', 'Filtros', 30, 16, 4),
('7179gosh7073', 'GoldFish', 100, 5, 1),
('7182gros6765', 'Gránulos con efecto potenciador para cíclidos carnívoros', 0, 8.29, 3),
('7988oxor7982', 'Oxigenador', 400, 35, 4),
('8069peos4950', 'Pecera 120 litros', 0, 95, 5),
('8069peos5048', 'Pecera 20 litros', 0, 50, 5),
('8365sakg5048', 'Sal sintética 20kg', 21, 58.99, 4),
('8469tees6983', 'Termocalentadores', 1, 195, 4),
('8469tero8279', 'Temómetro', 60, 1, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `codigo` char(12) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`codigo`, `nombre`, `direccion`, `telefono`) VALUES
('323419092000', 'Lucas', 'Ourense', '888888888'),
('345622102002', 'Juan', 'A Coruña', '666666666'),
('460911112001', 'Santiago', 'Lugo', '543526718'),
('543228021953', 'María', 'Cádiz', '676543289'),
('556431011978', 'Sofía', 'Marbella', '87876545'),
('787902051998', 'Sara', 'Lugo', '345347891'),
('788023011988', 'Emilio', 'Wisconsin', '665544332'),
('789928032010', 'Luís', 'Lugo', '555555555'),
('874306062006', 'Mateo', 'Pontevedra', '999999999'),
('876207061965', 'Lucía', 'Tenerife', '333333338'),
('986507031989', 'Marcos', 'Lugo', '777777777');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estanques`
--

CREATE TABLE `estanques` (
  `codigo` char(12) NOT NULL,
  `tipo` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `codigo_sala` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `estanques`
--

INSERT INTO `estanques` (`codigo`, `tipo`, `nombre`, `codigo_sala`) VALUES
('esel6578exno', 'Externo', 'Estanque de Angel', 'exor7869samo'),
('esel7765inno', 'Interno', 'Estanque de Manuel', 'exva7285sald'),
('esel7773exno', 'Externo', 'Estanque de Miguel', 'inor7765maum'),
('esio6776inno', 'Interno', 'Estanque de Claudio', 'inor7769meea'),
('eslo8065exno', 'Externo', 'Estanque de Paulo', 'inva6873dior'),
('esna7765inno', 'Interno', 'Estanque de Martina', 'mlia7279saas'),
('esse7479exno', 'Externo', 'Estanque de Jose', 'suea7865saus');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `codigo` char(12) NOT NULL,
  `codigo_cliente` char(12) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `importe_total` float NOT NULL,
  `pagada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lineas_facturas`
--

CREATE TABLE `lineas_facturas` (
  `codigo` char(12) NOT NULL,
  `cantidad` smallint NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `precio` float NOT NULL,
  `codigo_factura` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lineas_pedidos`
--

CREATE TABLE `lineas_pedidos` (
  `codigo` char(12) NOT NULL,
  `codigo_articulo` char(12) NOT NULL,
  `cantidad` int NOT NULL,
  `precio` float NOT NULL,
  `codigo_pedido` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `codigo` char(12) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `recibido` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plantas`
--

CREATE TABLE `plantas` (
  `codigo` char(12) NOT NULL,
  `medio_de_vida` varchar(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `codigo_estanque` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `codigo_sala` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `plantas`
--

INSERT INTO `plantas` (`codigo`, `medio_de_vida`, `nombre`, `codigo_estanque`, `codigo_sala`) VALUES
('6589ayca6567', 'Acuatico', 'Ayahuasca', NULL, NULL),
('6765cais8469', 'Terrestre', 'Cannabis', NULL, NULL),
('6779coca8469', 'Terrestre', 'Coca', NULL, NULL),
('7279hoos6567', 'Acuatico', 'Hongos', NULL, NULL),
('7980opio6567', 'Acuatico', 'Opio', NULL, NULL),
('8069acco6567', 'Acuatico', 'Peyote', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salas`
--

CREATE TABLE `salas` (
  `codigo` char(12) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `tipo` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `salas`
--

INSERT INTO `salas` (`codigo`, `nombre`, `tipo`) VALUES
('exor7869samo', 'Sala Nemo', 'Exterior'),
('exva7285sald', 'Sala Humbold', 'Expositiva'),
('inor7765maum', 'Sala Maremagnum', 'Interior'),
('inor7769meea', 'Sala Mediterránea', 'Interior'),
('inva6873dior', 'Sala Dictaminador', 'Informativa'),
('mlia7279saas', 'Sala de Hologramas', 'Multimedia'),
('suea7865saus', 'Sala Nautilus', 'Subterránea');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiburones`
--

CREATE TABLE `tiburones` (
  `codigo` char(12) NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tamano` varchar(10) NOT NULL,
  `codigo_estanque` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tiburones`
--

INSERT INTO `tiburones` (`codigo`, `nombre`, `tamano`, `codigo_estanque`) VALUES
('baro6665time', 'Tiburón Basurero', 'Mediano', 'esna7765inno'),
('calo6765time', 'Tiburón Camello', 'Mediano', 'esel7773exno'),
('caol6765tipe', 'Tiburoncín Caracol', 'Pequeño', 'esna7765inno'),
('cies6773tipe', 'Tiburoncín Ciempiés', 'Pequeño', 'eslo8065exno'),
('cuha6785tipe', 'Tiburoncín Cucaracha', 'Pequeño', 'esse7479exno'),
('dile6873time', 'Tiburón Dientes de Sable', 'Mediano', 'esio6776inno'),
('elte6976tigr', 'Tiburonazo Elefante', 'Grande', 'esel7765inno'),
('erzo6982tipe', 'Tiburoncín Erizo', 'Pequeño', 'esna7765inno'),
('esla6983tipe', 'Tiburoncín Estrella', 'Pequeño', 'eslo8065exno'),
('grlo7182tipe', 'Tiburoncín Grillo', 'Pequeño', 'eslo8065exno'),
('haer7265tipe', 'Tiburoncín Hamster', 'Pequeño', 'esel7773exno'),
('hoga7279tipe', 'Tiburoncín Hormiga', 'Pequeño', 'esse7479exno'),
('jifa7473tigr', 'Tiburonazo Jirafa', 'Grande', 'esio6776inno'),
('lila7673tipe', 'Tiburoncín Libélula', 'Pequeño', 'esse7479exno'),
('maca7765time', 'Tiburón Mazorca', 'Mediano', 'eslo8065exno'),
('maut7765tigr', 'Tiburonazo Mamut', 'Grande', 'esel7773exno'),
('meon7458tigr', 'Megalodón', 'Grande', 'esel6578exno'),
('mesa7769time', 'Tiburón Mesa', 'Mediano', 'esio6776inno'),
('moca7779tipe', 'Tiburoncín Mosca', 'Pequeño', 'esse7479exno'),
('peso8069time', 'Tiburón Perezoso', 'Mediano', 'esio6776inno'),
('polo8079tipe', 'Tiburoncín Pollo', 'Pequeño', 'eslo8065exno'),
('poro8079time', 'Tiburón Porro', 'Mediano', 'esna7765inno'),
('puta8085time', 'Tiburón Puerta', 'Mediano', 'esse7479exno'),
('teta8469tipe', 'Tiburoncín Termita', 'Pequeño', 'esel6578exno');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores`
--

CREATE TABLE `trabajadores` (
  `codigo` char(12) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `salario` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `trabajadores`
--

INSERT INTO `trabajadores` (`codigo`, `nombre`, `direccion`, `telefono`, `salario`) VALUES
('432509081997', 'Herodes', 'Jerusalen', '000000000', 1000),
('556431011978', 'Sofía', 'Marbella', '87876545', 1000),
('654627071994', 'Marina', 'Sevilla', '878764598', 1010),
('678503032001', 'Juan', 'Madrid', '00112233445', 1000),
('767915121996', 'Paco', 'A Coruña', '333333333', 1000),
('879824031988', 'Clara', 'Ourense', '776644559', 1025.87),
('981206092000', 'Pedro', 'Valencia', '221234339', 1000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulos`
--
ALTER TABLE `articulos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `estanques`
--
ALTER TABLE `estanques`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `SALA_TIENE_ESTANQUES` (`codigo_sala`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `lineas_facturas`
--
ALTER TABLE `lineas_facturas`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `FACTURA_TIENE_LINEASFACTURA` (`codigo_factura`);

--
-- Indices de la tabla `lineas_pedidos`
--
ALTER TABLE `lineas_pedidos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `PEDIDOS_TIENE_LINEASPEDIDOS` (`codigo_pedido`),
  ADD KEY `LINEASPEDIDOS_TIENEN_ARTICULOS` (`codigo_articulo`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `plantas`
--
ALTER TABLE `plantas`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `ESTANQUE_TIENE_PLANTAS` (`codigo_estanque`),
  ADD KEY `SALA_TIENE_PLANTA` (`codigo_sala`);

--
-- Indices de la tabla `salas`
--
ALTER TABLE `salas`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `tiburones`
--
ALTER TABLE `tiburones`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `ESTANQUE_TIENE_TIBURONES` (`codigo_estanque`);

--
-- Indices de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD PRIMARY KEY (`codigo`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `estanques`
--
ALTER TABLE `estanques`
  ADD CONSTRAINT `SALA_TIENE_ESTANQUES` FOREIGN KEY (`codigo_sala`) REFERENCES `salas` (`codigo`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Filtros para la tabla `lineas_facturas`
--
ALTER TABLE `lineas_facturas`
  ADD CONSTRAINT `FACTURA_TIENE_LINEASFACTURA` FOREIGN KEY (`codigo_factura`) REFERENCES `factura` (`codigo`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Filtros para la tabla `lineas_pedidos`
--
ALTER TABLE `lineas_pedidos`
  ADD CONSTRAINT `LINEASPEDIDOS_TIENEN_ARTICULOS` FOREIGN KEY (`codigo_articulo`) REFERENCES `articulos` (`codigo`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `PEDIDOS_TIENE_LINEASPEDIDOS` FOREIGN KEY (`codigo_pedido`) REFERENCES `pedidos` (`codigo`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Filtros para la tabla `plantas`
--
ALTER TABLE `plantas`
  ADD CONSTRAINT `ESTANQUE_TIENE_PLANTAS` FOREIGN KEY (`codigo_estanque`) REFERENCES `estanques` (`codigo`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `SALA_TIENE_PLANTA` FOREIGN KEY (`codigo_sala`) REFERENCES `salas` (`codigo`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Filtros para la tabla `tiburones`
--
ALTER TABLE `tiburones`
  ADD CONSTRAINT `ESTANQUE_TIENE_TIBURONES` FOREIGN KEY (`codigo_estanque`) REFERENCES `estanques` (`codigo`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
