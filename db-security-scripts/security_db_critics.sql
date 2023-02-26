-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: security_db
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
-- Table structure for table `critics`
--

DROP TABLE IF EXISTS `critics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `critics` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rating` int NOT NULL,
  `opinion` text NOT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `users_id` int NOT NULL,
  `movies_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_critics_users` (`users_id`),
  CONSTRAINT `fk_critics_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `critics`
--

LOCK TABLES `critics` WRITE;
/*!40000 ALTER TABLE `critics` DISABLE KEYS */;
INSERT INTO `critics` VALUES (1,9,'Excelente película, altamente recomendada.','2022-02-15 00:00:00',1,1),(2,6,'Buena película, pero no me gustó el final.','2022-02-14 00:00:00',2,1),(3,10,'Una de las mejores películas de la década.','2022-02-13 00:00:00',3,2),(4,8,'Muy bien actuada y producida.','2022-02-12 00:00:00',1,3),(5,7,'Me pareció aburrida en algunos momentos.','2022-02-11 00:00:00',2,3),(6,9,'Una joya del cine contemporáneo.','2022-02-10 00:00:00',3,4),(7,4,'No me gustó la trama ni las actuaciones.','2022-02-09 00:00:00',2,4),(8,7,'Entretenida, pero esperaba más de la trama.','2022-02-08 00:00:00',1,5),(9,9,'Una de las mejores películas de aventuras que he visto.','2022-02-07 00:00:00',3,5),(17,8,'Buena peli, pudiera ser mejor','2023-02-26 11:56:48',2,5);
/*!40000 ALTER TABLE `critics` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-26 13:04:45
