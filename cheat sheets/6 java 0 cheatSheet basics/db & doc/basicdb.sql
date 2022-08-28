CREATE DATABASE  IF NOT EXISTS `basicdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `basicdb`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: basicdb
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `advancedcrud`
--

DROP TABLE IF EXISTS `advancedcrud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `advancedcrud` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adv_fk_username_id` int(11) NOT NULL,
  `adv_randomdata` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_username_id_idx` (`adv_fk_username_id`),
  CONSTRAINT `fk_username_id` FOREIGN KEY (`adv_fk_username_id`) REFERENCES `userlist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advancedcrud`
--

LOCK TABLES `advancedcrud` WRITE;
/*!40000 ALTER TABLE `advancedcrud` DISABLE KEYS */;
INSERT INTO `advancedcrud` VALUES (1,1,'zdravo'),(2,2,'hello'),(3,3,'comontapeltu'),(4,4,'gogli');
/*!40000 ALTER TABLE `advancedcrud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `basiccrud`
--

DROP TABLE IF EXISTS `basiccrud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `basiccrud` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `basic_randomdata` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basiccrud`
--

LOCK TABLES `basiccrud` WRITE;
/*!40000 ALTER TABLE `basiccrud` DISABLE KEYS */;
INSERT INTO `basiccrud` VALUES (1,'bla bla bla'),(2,'kkkkkkkkkkkkk'),(3,'nnnjjkn'),(17,'mamamamama');
/*!40000 ALTER TABLE `basiccrud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Beograd'),(2,'New York'),(3,'Paris'),(4,'London');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userlist`
--

DROP TABLE IF EXISTS `userlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userlist_username` varchar(45) NOT NULL,
  `userlist_password` varchar(45) NOT NULL,
  `userlist_sex` varchar(45) NOT NULL,
  `userlist_fk_city_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_city_id_idx` (`userlist_fk_city_id`),
  CONSTRAINT `fk_city_id` FOREIGN KEY (`userlist_fk_city_id`) REFERENCES `city` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlist`
--

LOCK TABLES `userlist` WRITE;
/*!40000 ALTER TABLE `userlist` DISABLE KEYS */;
INSERT INTO `userlist` VALUES (1,'pera','lozinka','m',1),(2,'mike','password','m',2),(3,'marie','monshery','m',3),(4,'tom','password','m',4),(5,'gg','ff','f',2),(6,'gg','ff','m',1),(7,'cira','cira','m',2),(8,'simke','simke','m',1),(9,'k','k','m',1),(10,'josip','josip','m',4);
/*!40000 ALTER TABLE `userlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-08 13:13:43
