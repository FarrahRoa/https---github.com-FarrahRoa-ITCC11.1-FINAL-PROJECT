-- MySQL dump 10.13  Distrib 8.0.37, for Win64 (x86_64)
--
-- Host: localhost    Database: library
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
-- Table structure for table `bookdata`
--

DROP TABLE IF EXISTS `bookdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookdata` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `issued` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookdata`
--

LOCK TABLES `bookdata` WRITE;
/*!40000 ALTER TABLE `bookdata` DISABLE KEYS */;
INSERT INTO `bookdata` VALUES (1,'The Seven Husbands of Evelyn Hugo','Taylor Jenkins Reid','Romance novel, Historical Fiction, Contemporary romance, Psychological Fiction, Domestic Fiction, LGBT literature',575.00,0),(2,'The Lightning Thief','Rick Riordan',' Greek mythology, Novel, Fantasy',499.00,0),(3,'It Ends with Us','Colleen Hoover',' Romance novel',799.00,0),(4,'Atomic Habits','James Clear','Self-help book',1239.00,0),(5,'Milk and Honey','Rupi Kaur','Poetry',839.00,0),(6,'The Song of Achilles','Madeline Miller','Novel, Romance novel, Fantasy, Historical Fiction, War story',575.00,0);
/*!40000 ALTER TABLE `bookdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issuedbookdata`
--

DROP TABLE IF EXISTS `issuedbookdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issuedbookdata` (
  `s_no` int NOT NULL AUTO_INCREMENT,
  `book_id` int DEFAULT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `issuer_roll_no` varchar(255) DEFAULT NULL,
  `issuer_name` varchar(255) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  PRIMARY KEY (`s_no`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `issuedbookdata_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `bookdata` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issuedbookdata`
--

LOCK TABLES `issuedbookdata` WRITE;
/*!40000 ALTER TABLE `issuedbookdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `issuedbookdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `returnedbookdata`
--

DROP TABLE IF EXISTS `returnedbookdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `returnedbookdata` (
  `s_no` int NOT NULL AUTO_INCREMENT,
  `book_id` int DEFAULT NULL,
  `issuer_roll_no` varchar(255) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  PRIMARY KEY (`s_no`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `returnedbookdata_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `bookdata` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `returnedbookdata`
--

LOCK TABLES `returnedbookdata` WRITE;
/*!40000 ALTER TABLE `returnedbookdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `returnedbookdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'san','123');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-27 23:33:43
