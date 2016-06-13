CREATE DATABASE  IF NOT EXISTS `tts` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tts`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: tts
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `id_responsible_person` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_responsible_person_idx` (`id_responsible_person`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='Projects list';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'Project1',1),(2,'Project2',4),(3,'Project3',5),(6,'Project4',3),(7,'Project6',2),(8,'Project5',1),(9,'Project7',5),(10,'Project8',5),(11,'Project9',3),(12,'Project42',2);
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsible_persons`
--

DROP TABLE IF EXISTS `responsible_persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `responsible_persons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='responsible persons';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsible_persons`
--

LOCK TABLES `responsible_persons` WRITE;
/*!40000 ALTER TABLE `responsible_persons` DISABLE KEYS */;
INSERT INTO `responsible_persons` VALUES (1,'Vasia'),(2,'Marina'),(3,'Olga'),(4,'Kolia'),(5,'Maxim');
/*!40000 ALTER TABLE `responsible_persons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spent_time`
--

DROP TABLE IF EXISTS `spent_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spent_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `hours` int(11) NOT NULL,
  `id_responsible_person` int(11) DEFAULT NULL,
  `id_task` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_spent_time_resp_pers_idx` (`id_responsible_person`),
  KEY `fk_spent_time_task_idx` (`id_task`),
  CONSTRAINT `fk_spent_time_resp_pers` FOREIGN KEY (`id_responsible_person`) REFERENCES `responsible_persons` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_spent_time_task` FOREIGN KEY (`id_task`) REFERENCES `tasks` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='Spent time to task';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spent_time`
--

LOCK TABLES `spent_time` WRITE;
/*!40000 ALTER TABLE `spent_time` DISABLE KEYS */;
INSERT INTO `spent_time` VALUES (1,'2016-05-11 21:24:02',2,3,10),(2,'2016-05-11 21:24:03',4,5,10),(3,'2016-05-11 01:01:00',2,1,11),(4,'2016-05-18 01:01:00',220036,3,11),(5,'2016-05-11 01:01:00',4,1,11),(6,'2016-05-11 01:01:00',1,2,11);
/*!40000 ALTER TABLE `spent_time` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `id_project_name` int(11) DEFAULT NULL,
  `id_responsible_person` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`id_project_name`),
  KEY `id_responsible_person_idx` (`id_responsible_person`),
  CONSTRAINT `fk_id_project_name` FOREIGN KEY (`id_project_name`) REFERENCES `projects` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_id_responsible_person` FOREIGN KEY (`id_responsible_person`) REFERENCES `responsible_persons` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='Tasks Name';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (1,'Task1',1,1),(2,'Task2',1,2),(3,'Task3',1,3),(4,'Task4',2,4),(5,'Task5',2,1),(6,'Task6',2,2),(7,'Task7',3,3),(8,'Task8',3,3),(9,'Task9',3,3),(10,'Task10',3,2),(11,'Task11',3,3),(12,'Task11',3,1),(13,'1234',1,1),(14,'Task12',7,1),(15,'Task13',10,5),(16,'Task14',11,3),(17,'Task42',12,3),(18,'Task42',12,3);
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-13 15:26:39
