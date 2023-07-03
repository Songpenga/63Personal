-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: restaurant
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
-- Table structure for table `admin_login`
--

DROP TABLE IF EXISTS `admin_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_login` (
  `adminId` varchar(45) NOT NULL,
  `adminPw` varchar(100) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_login`
--

LOCK TABLES `admin_login` WRITE;
/*!40000 ALTER TABLE `admin_login` DISABLE KEYS */;
INSERT INTO `admin_login` VALUES ('aaa','1234');
/*!40000 ALTER TABLE `admin_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_menu`
--

DROP TABLE IF EXISTS `admin_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_menu` (
  `menu_code` varchar(45) NOT NULL,
  `menu_name` varchar(100) NOT NULL,
  `day` varchar(45) NOT NULL,
  `meals` varchar(45) NOT NULL,
  `menu_age1` int NOT NULL,
  `menu_age2` int NOT NULL,
  `sales-pride` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_menu`
--

LOCK TABLES `admin_menu` WRITE;
/*!40000 ALTER TABLE `admin_menu` DISABLE KEYS */;
INSERT INTO `admin_menu` VALUES ('1','맛있는 고기 냠냠','평일','중식',30,10,'상시'),('2','맛있는 고기 뇸뇸','평일','석식',30,10,'한정'),('3','맛있는 고기 앙앙','주말','조식',10,5,'한정'),('4','맛있는 고기 옹옹','주말','석식',10,5,'상시');
/*!40000 ALTER TABLE `admin_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dinning_mst`
--

DROP TABLE IF EXISTS `dinning_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dinning_mst` (
  `reserve_id` int NOT NULL AUTO_INCREMENT,
  `reserve_name` varchar(45) NOT NULL,
  `reserve_date` varchar(45) DEFAULT NULL,
  `reserve_time` varchar(100) DEFAULT NULL,
  `number` varchar(80) NOT NULL,
  `email` varchar(100) NOT NULL,
  `adult` int NOT NULL,
  `child` int NOT NULL,
  `guest` varchar(45) DEFAULT NULL,
  `request` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`reserve_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dinning_mst`
--

LOCK TABLES `dinning_mst` WRITE;
/*!40000 ALTER TABLE `dinning_mst` DISABLE KEYS */;
INSERT INTO `dinning_mst` VALUES (1,'a','2023-04-19','17:00','010-1111-4444','aaa@gmail.com',8,2,'5','qwer'),(2,'김민지','2023-05-04','17:00 ~ 20:20','-9153','aaa@gmail.com',1,2,NULL,NULL),(3,'김지은',NULL,NULL,'-12106','dlake8877@gmail.com',1,6,NULL,NULL),(4,'이다혜',NULL,NULL,'-6308','vicent7@gmail.com',6,0,NULL,NULL),(5,'정부교',NULL,NULL,'-4739','qnry46@gmail.com',2,4,NULL,NULL),(6,'김준일',NULL,NULL,'-3885','junil@gmail.com',4,0,NULL,NULL),(7,'High',NULL,NULL,'-10397','koreait@gmail.com',1,3,NULL,NULL),(8,'최향란',NULL,NULL,'-9251','lani@gmail.com',5,1,NULL,NULL),(9,'Bell',NULL,NULL,'-18271','park@gmail.com',1,1,NULL,NULL),(10,'박경자',NULL,NULL,'-13997','kyungja@gmail.com',2,0,NULL,NULL),(11,'김동형',NULL,NULL,'-8547','dungheong@gmail.com',1,2,NULL,NULL),(12,'강동훈',NULL,NULL,'-4932','dongdong@gmail.com',0,2,NULL,NULL),(13,'최훈민',NULL,NULL,'-8064','chlgnsals@gmail.com',4,2,NULL,NULL),(14,'김병규',NULL,NULL,'-11100','rlaqudrb169@gmail.com',4,0,NULL,NULL),(15,'Kon',NULL,NULL,'-13163','udc@gmail.com',6,0,NULL,NULL),(16,'문원석',NULL,NULL,'-6930','wldbftjdbf72@gmail.com',1,2,NULL,NULL),(17,'이은숙',NULL,NULL,'-11307','praise11223@gmail.com',3,3,NULL,NULL),(18,'류경은',NULL,NULL,'-10519','qksduehdwnals1349@gmail.com',2,2,NULL,NULL),(19,'김선경',NULL,NULL,'-5999','djddl456@gmail.com',1,1,NULL,NULL),(20,'김서지',NULL,NULL,'-8514','rlatjwl@gmail.com',3,0,NULL,NULL),(21,'배성윤',NULL,NULL,'-6266','ckdowldkfj4@gmail.com',5,0,NULL,NULL),(22,'김동열',NULL,NULL,'-4594','dongdugje@gmail.com',2,2,NULL,NULL),(23,'변건채',NULL,NULL,'-12813','qusrjsco@gmail.com',1,2,NULL,NULL),(24,'김은혜',NULL,NULL,'-11350','grace@gmail.com',3,0,NULL,NULL),(25,'박성호',NULL,NULL,'-14136','sungho@gmail.com',4,0,NULL,NULL),(26,'손태규',NULL,NULL,'-16982','gonggongei@gmail.com',1,2,NULL,NULL),(27,'herrypoter',NULL,NULL,'-4007','magic@gmail.com',5,0,NULL,NULL),(28,'유태오',NULL,NULL,'-4270','teoteo@gmail.com',2,0,NULL,NULL),(29,'김태리',NULL,NULL,'-3262','teri@gmail.com',2,3,NULL,NULL),(30,'전미도',NULL,NULL,'-8109','mido@gmail.com',4,0,NULL,NULL),(31,'조정석',NULL,NULL,'-5605','dkjkdjfk@gmail.com',6,0,NULL,NULL),(32,'전다은',NULL,NULL,'-5130','efjkejkfj@gmail.com',2,2,NULL,NULL),(33,'test','2023-02-21','15:00','010-1234-1234','1234a@gmail.com',3,2,'5','주중 점심 A'),(34,'1234','2023-03-21','15:00','010-1234-1234','1234a@gmail.com',3,2,'5','주중 점심 A'),(35,'1234','2023-03-21','15:00','010-1234-1234','1234a@gmail.com',3,2,'5','주중 점심 A'),(36,'1234','2023-03-21','15:00','010-1234-1234','1234a@gmail.com',3,2,'5','주중 점심 A'),(41,'asdf','2023-04-27','15:00','010-1234-1234','1234a@gmail.com',3,2,'5','주중 점심 test2'),(42,'asdf','2023-04-27','15:00','010-1234-1234','1234a@gmail.com',3,2,'5','주중 점심 test2'),(43,'asdf','2023-04-27','15:00','010-1234-1234','1234a@gmail.com',3,2,'5','주중 점심 test2'),(44,'qwer','2023-04-22','14:00','010-1111-3333','qwre@naver.com',3,2,'5',NULL),(45,'',NULL,NULL,'010--','@',0,0,'5',NULL),(46,'',NULL,NULL,'010--','@',0,0,'5',NULL),(47,'qwer','2023-04-22','20:00~22:00','010-1234-1234','1234@daum.net',11,1,NULL,'1234'),(48,'asdf','2023-04-19','20:00~22:00','010-1234-1243','qwer@daum.net',3,1,NULL,'qwer'),(49,'asdf','2023-04-06','14:00~17:00','010-1234-1234','qwer@naver.com',3,1,'4','qwer'),(50,'asdf','2023-04-07','14:00~17:00','010-1234-124','qwer@naver.com',3,1,'4','qwer'),(51,'test','2023-4-20','17:00~20:00','010-er12-asra','qerasfd@daum.net',3,3,'6','saf'),(52,'test','2023-4-7','17:00~20:00','010-1234-1231','qwer@daum.net',6,0,'6','asdfasf');
/*!40000 ALTER TABLE `dinning_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_image`
--

DROP TABLE IF EXISTS `menu_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_image` (
  `image_id` int NOT NULL AUTO_INCREMENT,
  `menu_code` varchar(45) NOT NULL,
  `save_name` varchar(100) DEFAULT NULL,
  `origin_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_image`
--

LOCK TABLES `menu_image` WRITE;
/*!40000 ALTER TABLE `menu_image` DISABLE KEYS */;
INSERT INTO `menu_image` VALUES (1,'1','save.png','origin.png'),(2,'2',NULL,NULL);
/*!40000 ALTER TABLE `menu_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'restaurant'
--

--
-- Dumping routines for database 'restaurant'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-30 20:25:52
