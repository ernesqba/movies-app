-- MySQL dump 10.13  Distrib 8.0.31, for Linux (x86_64)
--
-- Host: localhost    Database: movies_db
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb3_spanish_ci NOT NULL,
  `year` int NOT NULL,
  `length` int NOT NULL,
  `country` varchar(255) COLLATE utf8mb3_spanish_ci NOT NULL,
  `directed_by` varchar(255) COLLATE utf8mb3_spanish_ci NOT NULL,
  `genre` varchar(255) COLLATE utf8mb3_spanish_ci NOT NULL,
  `synopsis` text COLLATE utf8mb3_spanish_ci NOT NULL,
  `image` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Jocker',2010,120,'España','Robert A.','Suspenso','Arthur Fleck adora hacer reír a la gente, pero su carrera como comediante es un fracaso. El repudio social, la marginación y una serie de trágicos acontecimientos lo conducen por el sendero de la locura y, finalmente, cae en el mundo del crimen.','https://i.blogs.es/9fe2f3/philips_cinema_joker_500/450_1000.jpg'),(2,'pelicula de amortito',2020,190,'Cuba','Ernesto','Romance','El amortito de los tortolitos','http://localhost:3000'),(8,'title',2011,120,'España','Robert A.','Acción','synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis synopsis ','http://localhost:3000');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-20 18:08:06
