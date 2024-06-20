-- MySQL dump 10.13  Distrib 8.0.37, for Win64 (x86_64)
--
-- Host: localhost    Database: financas_fatec
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pessoa_fisica`
--

DROP TABLE IF EXISTS `pessoa_fisica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa_fisica` (
  `id` bigint NOT NULL,
  `cd_cpf` varchar(11) DEFAULT NULL,
  `nm_profissao` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK3ptg2qm4jkt70lq9pi4he9la4` FOREIGN KEY (`id`) REFERENCES `tb_cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa_fisica`
--

LOCK TABLES `pessoa_fisica` WRITE;
/*!40000 ALTER TABLE `pessoa_fisica` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoa_fisica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa_juridica`
--

DROP TABLE IF EXISTS `pessoa_juridica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa_juridica` (
  `id` bigint NOT NULL,
  `cd_cnpj` varchar(14) DEFAULT NULL,
  `nm_ramo_atividade` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKmr71f9lo4y5pg4tw48g5gax1u` FOREIGN KEY (`id`) REFERENCES `tb_cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa_juridica`
--

LOCK TABLES `pessoa_juridica` WRITE;
/*!40000 ALTER TABLE `pessoa_juridica` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoa_juridica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nm_nome` varchar(60) DEFAULT NULL,
  `ds_endereco` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_conta`
--

DROP TABLE IF EXISTS `tb_conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_conta` (
  `nr_agencia` int NOT NULL,
  `vl_saldo` double NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nm_numero` varchar(10) NOT NULL,
  `nm_titular` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_conta`
--

LOCK TABLES `tb_conta` WRITE;
/*!40000 ALTER TABLE `tb_conta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_viagem`
--

DROP TABLE IF EXISTS `tb_viagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_viagem` (
  `nm_type` tinyint NOT NULL,
  `cd_end_date_time` datetime(6) NOT NULL,
  `cd_start_date_time` datetime(6) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cd_order_number` varchar(255) NOT NULL,
  `nm_destination` varchar(255) NOT NULL,
  `nm_source` varchar(255) NOT NULL,
  `vl_amount` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `tb_viagem_chk_1` CHECK ((`nm_type` between 0 and 2))
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_viagem`
--

LOCK TABLES `tb_viagem` WRITE;
/*!40000 ALTER TABLE `tb_viagem` DISABLE KEYS */;
INSERT INTO `tb_viagem` VALUES (0,'2024-06-20 06:00:00.000000','2024-06-20 04:00:00.000000',1,'101','RJ','SP','500'),(0,'2024-06-21 06:00:00.000000','2024-06-21 04:00:00.000000',2,'102','SP','RJ','600'),(1,'2024-06-22 06:00:00.000000','2024-06-22 04:00:00.000000',3,'103','ES','MG','700'),(2,'2024-06-23 06:00:00.000000','2024-06-23 04:00:00.000000',4,'104','MG','ES','800'),(0,'2024-06-24 06:00:00.000000','2024-06-24 04:00:00.000000',5,'105','SE','BA','900'),(2,'2024-06-25 06:00:00.000000','2024-06-25 04:00:00.000000',6,'106','BA','SE','1000'),(0,'2024-06-26 06:00:00.000000','2024-06-26 04:00:00.000000',7,'107','AL','PE','1100'),(1,'2024-06-27 06:00:00.000000','2024-06-27 04:00:00.000000',8,'108','PE','AL','1200'),(1,'2024-06-28 06:00:00.000000','2024-06-28 04:00:00.000000',9,'109','PB','RN','1300'),(1,'2024-06-29 06:00:00.000000','2024-06-29 04:00:00.000000',10,'110','RN','PB','1400'),(2,'2024-06-30 06:00:00.000000','2024-06-30 04:00:00.000000',11,'111','PI','CE','1500'),(0,'2024-07-01 06:00:00.000000','2024-07-01 04:00:00.000000',12,'112','CE','PI','1600'),(1,'2024-07-02 06:00:00.000000','2024-07-02 04:00:00.000000',13,'113','PA','MA','1700'),(0,'2024-07-03 06:00:00.000000','2024-07-03 04:00:00.000000',14,'114','MA','PA','1800'),(0,'2024-07-04 06:00:00.000000','2024-07-04 04:00:00.000000',15,'115','RR','AM','1900'),(2,'2024-07-05 06:00:00.000000','2024-07-05 04:00:00.000000',16,'116','AM','RR','2000'),(0,'2024-07-07 06:00:00.000000','2024-07-07 04:00:00.000000',17,'118','AC','RO','2200'),(0,'2024-07-06 06:00:00.000000','2024-07-06 04:00:00.000000',18,'117','RO','AC','2100'),(1,'2024-07-08 06:00:00.000000','2024-07-08 04:00:00.000000',19,'119','GO','TO','2300'),(1,'2024-07-09 06:00:00.000000','2024-07-09 04:00:00.000000',20,'120','TO','GO','2400'),(2,'2024-07-10 06:00:00.000000','2024-07-10 04:00:00.000000',21,'121','MG','RJ','2550'),(0,'2024-07-11 06:00:00.000000','2024-07-11 04:00:00.000000',22,'122','ES','SP','2650'),(1,'2024-07-12 06:00:00.000000','2024-07-12 04:00:00.000000',23,'123','RJ','BA','2725'),(0,'2024-07-13 06:00:00.000000','2024-07-13 04:00:00.000000',24,'124','PE','AL','2830'),(2,'2024-07-14 06:00:00.000000','2024-07-14 04:00:00.000000',25,'125','BA','MG','2910'),(1,'2024-07-15 06:00:00.000000','2024-07-15 04:00:00.000000',26,'126','PR','RS','3035'),(0,'2024-07-16 06:00:00.000000','2024-07-16 04:00:00.000000',27,'127','RS','SC','3180'),(1,'2024-07-17 06:00:00.000000','2024-07-17 04:00:00.000000',28,'128','SP','PR','3290'),(2,'2024-07-18 06:00:00.000000','2024-07-18 04:00:00.000000',29,'129','BA','PE','3405'),(0,'2024-07-19 06:00:00.000000','2024-07-19 04:00:00.000000',30,'130','PA','AM','3560');
/*!40000 ALTER TABLE `tb_viagem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-20 19:02:34
