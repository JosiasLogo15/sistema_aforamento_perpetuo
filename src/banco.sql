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
CREATE DATABASE IF NOT EXISTS `aforamento` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `aforamento`;

-- Copiando estrutura para tabela aforamento.aforamento
CREATE TABLE IF NOT EXISTS `aforamento` (
  `NUMERO_PROCESSO` int NOT NULL,
  `CODIGO_PREFEITO` int DEFAULT NULL,
  `OBSERVACOES` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `NUMERO_AFORAMENTO` int NOT NULL,
  `DATA_AFORAMENTO` date DEFAULT NULL,
  `FOLHA` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `LIVRO` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `SITUACAO` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`NUMERO_AFORAMENTO`),
  KEY `FK_aforamento_prefeito` (`CODIGO_PREFEITO`) USING BTREE,
  KEY `FK_aforamento_processo` (`NUMERO_PROCESSO`),
  KEY `FK_aforamento_status_pagamento` (`SITUACAO`),
  CONSTRAINT `FK_aforamento_prefeito` FOREIGN KEY (`CODIGO_PREFEITO`) REFERENCES `prefeito` (`CODIGO_PREFEITO`),
  CONSTRAINT `FK_aforamento_processo` FOREIGN KEY (`NUMERO_PROCESSO`) REFERENCES `processo` (`NUMERO_PROCESSO`),
  CONSTRAINT `FK_aforamento_status_pagamento` FOREIGN KEY (`SITUACAO`) REFERENCES `status_pagamento` (`id_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela aforamento.cemiterio
CREATE TABLE IF NOT EXISTS `cemiterio` (
  `CODIGO_CEMITERIO` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(21) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `ENDERECO` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `BAIRRO` varchar(21) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`CODIGO_CEMITERIO`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela aforamento.prefeito
CREATE TABLE IF NOT EXISTS `prefeito` (
  `CODIGO_PREFEITO` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `INICIO` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '',
  `FINAL` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`CODIGO_PREFEITO`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb3;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela aforamento.processo
CREATE TABLE IF NOT EXISTS `processo` (
  `NUMERO_PROCESSO` int NOT NULL,
  `REQUERENTE` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `MEDIDA` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `FALECIDO` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `DATA_ENTRADA` date DEFAULT NULL,
  `ENDERECO` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `BAIRRO` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `QUADRA` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `ESTACA` int DEFAULT NULL,
  `RG` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `CODIGO_CEMITERIO` int DEFAULT NULL,
  `NACIONALIDADE` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`NUMERO_PROCESSO`),
  KEY `FK_processo_cemiterio` (`CODIGO_CEMITERIO`),
  CONSTRAINT `FK_processo_cemiterio` FOREIGN KEY (`CODIGO_CEMITERIO`) REFERENCES `cemiterio` (`CODIGO_CEMITERIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela aforamento.status_pagamento
CREATE TABLE IF NOT EXISTS `status_pagamento` (
  `id_status` int NOT NULL AUTO_INCREMENT,
  `status_pagamento` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela aforamento.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `codigo_usuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `senha` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`codigo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Exportação de dados foi desmarcado.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
