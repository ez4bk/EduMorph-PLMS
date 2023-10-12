-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: lms-auth
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (id, account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username) VALUES (1,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','tgridley@umd.edu'),(2,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','aanglish@umd.edu'),(3,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','cslatten@umd.edu'),(4,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','vetchell@umd.edu'),(5,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','aadamek@umd.edu'),(6,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','acocozza@umd.edu'),(7,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','ecadwell@umd.edu'),(8,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','ctanslie@umd.edu'),(9,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','hsiveyer@umd.edu'),(10,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','lcatley@umd.edu'),(11,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','vcowderay@umd.edu'),(12,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','swray@umd.edu'),(13,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','mluciani@umd.edu'),(14,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','kclohisey@umd.edu'),(15,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','hfassum@umd.edu'),(16,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','avasilevich@umd.edu'),(17,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','ijoskovitch@umd.edu'),(18,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','dwillshear@umd.edu'),(19,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','wgeyton@umd.edu'),(20,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','vfilpi@umd.edu'),(21,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','bjanczewski@umd.edu'),(22,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','vbiles@umd.edu'),(23,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','lmackay@umd.edu'),(24,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','jkewish@umd.edu'),(25,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','vgally@umd.edu'),(26,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','vnormabell@umd.edu'),(27,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','wpriddie@umd.edu'),(28,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','badamec@umd.edu'),(29,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','eambrose@umd.edu'),(30,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','cparkin@umd.edu'),(31,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','gerricker@umd.edu'),(32,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','chilary@umd.edu'),(33,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','poseman@umd.edu'),(34,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','sranklin@umd.edu'),(35,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','jsmalecombe@umd.edu'),(36,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','aglassard@umd.edu'),(37,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','cfouch@umd.edu'),(38,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','gbenmore@umd.edu'),(39,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','lwhistlecroft@umd.edu'),(40,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','cgunn@umd.edu'),(41,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','gmizzen@umd.edu'),(42,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','skaming@umd.edu'),(43,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','alampkin@umd.edu'),(44,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','rkersting@umd.edu'),(45,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','dcreany@umd.edu'),(46,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','lwishart@umd.edu'),(47,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','nclaypoole@umd.edu'),(48,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','wvoaden@umd.edu'),(49,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','nmaginot@umd.edu'),(50,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','jdumsday@umd.edu'),(51,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','klambeth@umd.edu'),(52,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','sallberry@umd.edu'),(53,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','mlendon@umd.edu'),(54,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','jhugues@umd.edu'),(55,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','rnellies@umd.edu'),(56,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','rdu hamel@umd.edu'),(57,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','dboyd@umd.edu'),(58,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','akynge@umd.edu'),(59,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','lscatchard@umd.edu'),(60,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','bcoghill@umd.edu'),(61,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','wmatschek@umd.edu'),(62,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','mvoaden@umd.edu'),(63,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','gweine@umd.edu'),(64,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','rsandeman@umd.edu'),(65,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','kbraney@umd.edu'),(66,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','gdurning@umd.edu'),(67,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','mdemer@umd.edu'),(68,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','murien@umd.edu'),(69,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','mfant@umd.edu'),(70,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','itice@umd.edu'),(71,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','tfitchett@umd.edu'),(72,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','mnials@umd.edu'),(73,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','sbonnick@umd.edu'),(74,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','ibewsey@umd.edu'),(75,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','lburdoun@umd.edu'),(76,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','cmarquese@umd.edu'),(77,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','trappport@umd.edu'),(78,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','jivashkov@umd.edu'),(79,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','eyedy@umd.edu'),(80,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','hfidelli@umd.edu'),(81,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','hgrishechkin@umd.edu'),(82,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','fthackray@umd.edu'),(83,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','kgilloran@umd.edu'),(84,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','mvelte@umd.edu'),(85,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','nedy@umd.edu'),(86,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','esebring@umd.edu'),(87,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','emates@umd.edu'),(88,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','lburtwistle@umd.edu'),(89,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','tstopp@umd.edu'),(90,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','ebrobeck@umd.edu'),(91,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','hewins@umd.edu'),(92,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','bkrug@umd.edu'),(93,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','sadamou@umd.edu'),(94,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','sstarkey@umd.edu'),(95,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','bteek@umd.edu'),(96,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','dwillison@umd.edu'),(97,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','wdietmar@umd.edu'),(98,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','dhunte@umd.edu'),(99,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','plehon@umd.edu'),(100,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','ckimmons@umd.edu'),(101,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','cohollegan@umd.edu'),(102,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','ffellowes@umd.edu'),(103,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','tpinches@umd.edu'),(104,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','dcapper@umd.edu'),(105,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','ngeraldini@umd.edu'),(106,1,1,1,1,'$2a$10$E1YPtuH.jGsCw/45wnm3NuzrC2VFT14TdNf5i3kChoJd.Y8jSox6u','jmasurel@umd.edu');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (user_id, role_id) VALUES (102,2),(103,2),(104,2),(105,2),(106,2),(1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(7,3),(8,3),(9,3),(10,3),(11,3),(12,3),(13,3),(14,3),(15,3),(16,3),(17,3),(18,3),(19,3),(20,3),(21,3),(22,3),(23,3),(24,3),(25,3),(26,3),(27,3),(28,3),(29,3),(30,3),(31,3),(32,3),(33,3),(34,3),(35,3),(36,3),(37,3),(38,3),(39,3),(40,3),(41,3),(42,3),(43,3),(44,3),(45,3),(46,3),(47,3),(48,3),(49,3),(50,3),(51,3),(52,3),(53,3),(54,3),(55,3),(56,3),(57,3),(58,3),(59,3),(60,3),(61,4),(62,4),(63,4),(64,4),(65,4),(66,4),(67,4),(68,4),(69,4),(70,4),(71,4),(72,4),(73,4),(74,4),(75,4),(76,4),(77,4),(78,4),(79,4),(80,4),(81,4),(82,4),(83,4),(84,4),(85,4),(86,4),(87,4),(88,4),(89,4),(90,4),(91,4),(92,4),(93,4),(94,4),(95,4),(96,4),(97,4),(98,4),(99,4),(100,4),(101,4);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

