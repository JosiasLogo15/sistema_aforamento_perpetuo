-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.32 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para aforamento
CREATE DATABASE IF NOT EXISTS `aforamento` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `aforamento`;

-- Copiando estrutura para tabela aforamento.aforamento
CREATE TABLE IF NOT EXISTS `aforamento` (
  `NUMERO_PROCESSO` int DEFAULT NULL,
  `CODIGO_PREFEITO` int DEFAULT NULL,
  `OBSERVACOES` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `NUMERO_AFORAMENTO` int NOT NULL,
  `DATA_AFORAMENTO` date DEFAULT NULL,
  `FOLHA` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `LIVRO` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SITUACAO` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`NUMERO_AFORAMENTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela aforamento.aforamento: ~1 rows (aproximadamente)
INSERT INTO `aforamento` (`NUMERO_PROCESSO`, `CODIGO_PREFEITO`, `OBSERVACOES`, `NUMERO_AFORAMENTO`, `DATA_AFORAMENTO`, `FOLHA`, `LIVRO`, `SITUACAO`) VALUES
	(123, 23, '', 354, '2023-08-02', '34', '3', NULL);

-- Copiando estrutura para tabela aforamento.cemiterio
CREATE TABLE IF NOT EXISTS `cemiterio` (
  `CODIGO_CEMITERIO` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(21) DEFAULT NULL,
  `ENDERECO` varchar(20) DEFAULT NULL,
  `BAIRRO` varchar(21) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_CEMITERIO`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela aforamento.cemiterio: ~2 rows (aproximadamente)
INSERT INTO `cemiterio` (`CODIGO_CEMITERIO`, `NOME`, `ENDERECO`, `BAIRRO`) VALUES
	(8, 'SÃO VICENTE DE PAULA ', 'RUA PERPETUO SOCORRO', 'SãO VICENTE DE PAULA '),
	(9, 'CRISTO REI', 'JOÃO ROBERTO SALOMÃO', 'BAIRRO DA SAUDADE');

-- Copiando estrutura para tabela aforamento.prefeito
CREATE TABLE IF NOT EXISTS `prefeito` (
  `CODIGO_PREFEITO` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `INICIO` varchar(50) NOT NULL DEFAULT '',
  `FINAL` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_PREFEITO`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela aforamento.prefeito: ~17 rows (aproximadamente)
INSERT INTO `prefeito` (`CODIGO_PREFEITO`, `NOME`, `INICIO`, `FINAL`) VALUES
	(9, 'AIRES MARQUES', '2005-05-09', '2006-11-12'),
	(10, 'FLAVIO KAYATT', '2005-01-01', '2006-12-01'),
	(11, 'PEDRO MANVAILER', '1938-01-22', '1941-10-15'),
	(12, 'JOSÉ NILO DE XEREZ RIBEIRO', '1941-12-26', '1942-01-06'),
	(13, 'LIDIO LIMA', '1942-05-28', '1943-07-13'),
	(14, 'RACHID SALDANHA DERZI', '1944-09-18', '1945-01-27'),
	(15, 'MARIO OLIVA  ', '1944-08-24', '1944-08-26'),
	(16, 'JOÃO PINTO COSTA', '1945-10-12', '1945-10-25'),
	(17, 'VINICIUS SOARES DO NASCIMENTO', '1946-03-15', '1946-10-07'),
	(18, 'APOLINÁRIO ESPINDOLA', '1947-06-12', '1947-07-13'),
	(19, 'DIOGENES CABRAL', '1947-10-06', '1947-10-07'),
	(20, 'ANTONINO CARLOS DE MIRANDA CORRÊA JUNIOR', '1948-04-29', '1949-04-28'),
	(21, 'ADE MARQUES ', '1949-09-22', '1951-01-13'),
	(22, 'JOÃO PORTELA FREIRE', '1955-03-05', '1958-12-13'),
	(23, 'HÉLIO PELUFFO FILHO', '1959-02-05', '1963-01-19'),
	(24, 'JOSÉ ISSA', '1963-02-13', '1964-02-27'),
	(25, 'SERGIO MARTINS SOBRINHO', '1964-04-13', '1966-12-21');

-- Copiando estrutura para tabela aforamento.processo
CREATE TABLE IF NOT EXISTS `processo` (
  `NUMERO_PROCESSO` int NOT NULL,
  `REQUERENTE` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MEDIDA` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FALECIDO` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DATA_ENTRADA` date DEFAULT NULL,
  `ENDERECO` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BAIRRO` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `QUADRA` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ESTACA` int DEFAULT NULL,
  `RG` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CODIGO_CEMITERIO` int DEFAULT NULL,
  `NACIONALIDADE` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`NUMERO_PROCESSO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela aforamento.processo: ~5 rows (aproximadamente)
INSERT INTO `processo` (`NUMERO_PROCESSO`, `REQUERENTE`, `MEDIDA`, `FALECIDO`, `DATA_ENTRADA`, `ENDERECO`, `BAIRRO`, `QUADRA`, `ESTACA`, `RG`, `CODIGO_CEMITERIO`, `NACIONALIDADE`) VALUES
	(123, 'JOSIAS DE OLIVEIRA', '1,50 X 2,00', 'MARCOS ANTONIO SOL´S', '2023-08-15', 'RUA CAPELINHA, 372', 'JARDIM MONTE ALTO', 'B', 312, '345.123.123-45', 8, 'BRASILEIRO'),
	(233, 'MAURO', '1,50 X 2,50', 'HENRICO FELICIANO', '1969-12-31', 'RUA ALGUMA COISA, 333', 'SAUDADE', 'H', 315, '342123133', 9, 'PORTUNHOL'),
	(432, 'OLOCO', '1.23 X 1.50 ', 'OLOQUINHO MEU', '2023-08-01', 'SLA MANO', 'ALGUM LUGAR', 'E', 345, '123', 8, 'BRASILEIRO'),
	(555, 'LUCAS', '1.30 X 3.05', 'FELICIANO', '1969-12-31', 'SLA ONDE', 'ALGUM LUGAR', 'K', 123, '321.432.543', 9, 'PORTUNHOL'),
	(667, 'LUCAS', '1.30 X 3.05', 'FELICIANO', '1969-12-31', 'SLA ONDE', 'ALGUM LUGAR', 'K', 123, '321.432.543', 9, 'PORTUNHOL');

-- Copiando estrutura para tabela aforamento.senhas
CREATE TABLE IF NOT EXISTS `senhas` (
  `CODIGO` int DEFAULT NULL,
  `NOME` varchar(9) DEFAULT NULL,
  `SENHA` int DEFAULT NULL,
  `NIVEL` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela aforamento.senhas: ~2 rows (aproximadamente)
INSERT INTO `senhas` (`CODIGO`, `NOME`, `SENHA`, `NIVEL`) VALUES
	(13, 'NILSON', 123456, 'ADMINISTRADOR'),
	(14, 'TEREZINHA', 191258, 'ADMINISTRADOR');

-- Copiando estrutura para tabela aforamento.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `codigo_usuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela aforamento.usuario: ~1 rows (aproximadamente)
INSERT INTO `usuario` (`codigo_usuario`, `nome`, `senha`) VALUES
	(4, 'teste', '123456');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
