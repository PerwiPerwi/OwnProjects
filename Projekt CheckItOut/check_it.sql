-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: check_it
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
-- Table structure for table `discovery`
--

DROP TABLE IF EXISTS `discovery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discovery` (
  `discovery_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `description` varchar(500) NOT NULL,
  `url` varchar(200) NOT NULL,
  `user_id` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `up_vote` int(11) NOT NULL,
  `down_vote` int(11) NOT NULL,
  PRIMARY KEY (`discovery_id`,`user_id`),
  UNIQUE KEY `discovery_id_UNIQUE` (`discovery_id`),
  UNIQUE KEY `url_UNIQUE` (`url`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discovery`
--

LOCK TABLES `discovery` WRITE;
/*!40000 ALTER TABLE `discovery` DISABLE KEYS */;
INSERT INTO `discovery` VALUES (10,'\"Sueddeutsche Zeitung\": Jarosław Kaczyński dyskredytuje przeciwników','Niemiecki dziennik \"Sueddeutsche Zeitung\" napisał, że nazwanie przez Jarosława Kaczyńskiego wieców upamiętniających wybory z 4 czerwca 1989 roku rebelią jest próbą zdyskredytowania przeciwników przypominającą działania komunistów. ','http://wiadomosci.wp.pl/kat,1356,title,Sueddeutsche-Zeitung-Jaroslaw-Kaczynski-dyskredytuje-przeciwnikow,wid,18366594,wiadomosc.html',77,'2016-06-06 12:20:52',3,0),(11,'Francuska wojna domowa?','		Nigdy nie widziałem Francji w takim stanie. Na stacjach brakuje benzyny, strajkują szybkie koleje dalekobieżne, kolejka podmiejska. Chcą strajkować piloci, personel naziemny lotnisk i kontrolerzy ruchu, podobnie jak taksówkarze. Z zewnątrz wygląda to na niemal początki wojny domowej.		','http://swiat.newsweek.pl/strajki-we-francji-jak-sie-poruszac-kto-strajkuje-terminy,artykuly,386858,1.html',76,'2016-06-06 12:22:42',1,2),(20,'Kontuzja Kamila Grosickiego','			Kamil Grosicki doznał urazu stawu skokowego w poniedziałkowym meczu towarzyskim z Litwą (0:0), ale na razie nie wiadomo, jak poważna jest kontuzja skrzydłowego reprezentacji Polski.	','http://sportowefakty.wp.pl/euro-2016/606775/kontuzja-kamila-grosickiego',83,'2016-06-06 20:16:58',1,1),(23,'Posłowie toną w długach. Rekordzista musi oddać 20 milionów','Polscy parlamentarzyści mają w sumie prawie 100 mln zł długów. Z kredytami i pożyczkami musi na co dzień zmagać się ponad 250 posłów, a średnie zadłużenie na osobę wynosi ponad 200 tys. zł. ','http://www.money.pl/gospodarka/wiadomosci/artykul/poslowie-tona-w-dlugach-rekordzista-musi,187,0,2097339.html',76,'2016-06-06 20:39:33',2,0);
/*!40000 ALTER TABLE `discovery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_name` varchar(45) NOT NULL,
  `description` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`role_name`),
  UNIQUE KEY `role_name_UNIQUE` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('admin','all privigilesuser_role'),('user','add new discovery');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `password` varchar(45) NOT NULL,
  `picture_url` varchar(200) DEFAULT 'standartProfilePicture.jpg',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (63,'User','User@wp.pl',1,'ee11cbb19052e40b07aac0ca060c23ee','standartProfilePicture.jpg'),(67,'Admin','Admin@wp.pl',1,'21232f297a57a5a743894a0e4a801fc3','standartProfilePicture.jpg'),(74,'Ewa','Ewa@wp.pl',0,'14c0f73364d8d9ce0748e89e954e9e26','standartProfilePicture.jpg'),(76,'Krokodyl','Krokodyl@wp.pl',1,'a048cd27f5bc57c529c80ed0f65c82b4','standartProfilePicture.jpg'),(77,'Joanna','Joanna@wp.pl',0,'d979871f68a9e367eb3a5df8be7c4bf4','standartProfilePicture.jpg'),(78,'Helena','Helena@buziaczek.pl',0,'8f5696351d40139b803a68a8cef76cea','standartProfilePicture.jpg'),(79,'Helenka','Helenka@wp.pl',0,'21d2124db4d2f47684c5398ad74e4e2b','standartProfilePicture.jpg'),(80,'Euzebiusz','Euzebiusz@wp.pl',0,'7ec69692246003b42354411c1b6d80f1','standartProfilePicture.jpg'),(83,'Pawel','Pawel@wp.pl',1,'a741cdf4d61e1083064d813a5a1ec8aa','standartProfilePicture.jpg'),(86,'Jan','Jan@wp.pl',1,'fa27ef3ef6570e32a79e74deca7c1bc3','standartProfilePicture.jpg');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `role_name` varchar(45) NOT NULL DEFAULT 'user',
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`role_name`,`username`),
  KEY `fk_role_has_user_role1_idx` (`role_name`),
  KEY `fk_user_role_user_username_idx` (`username`),
  CONSTRAINT `fk_role_has_user_role1` FOREIGN KEY (`role_name`) REFERENCES `role` (`role_name`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_user_username` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('admin','Admin'),('Admin','Euzebiusz'),('Admin','Ewa'),('Admin','Helena'),('User','Helenka'),('user','Jan'),('User','Joanna'),('user','Krokodyl'),('user','Pawel'),('user','User');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote` (
  `vote_id` int(11) NOT NULL AUTO_INCREMENT,
  `discovery_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`vote_id`,`discovery_id`,`user_id`),
  KEY `fk_user_has_discovery_discovery1_idx` (`discovery_id`),
  KEY `fk_user_has_discovery_user1_idx` (`user_id`),
  CONSTRAINT `fk_user_has_discovery_discovery1` FOREIGN KEY (`discovery_id`) REFERENCES `discovery` (`discovery_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_discovery_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
INSERT INTO `vote` VALUES (16,10,77,'2016-06-06 12:21:11','VOTE_UP'),(17,10,76,'2016-06-06 12:22:14','VOTE_UP'),(18,11,76,'2016-06-06 12:22:45','VOTE_DOWN'),(19,11,79,'2016-06-06 12:24:35','VOTE_DOWN'),(23,10,67,'2016-06-06 13:38:01','VOTE_UP'),(25,20,83,'2016-06-06 20:17:02','VOTE_DOWN'),(26,23,67,'2016-06-07 15:31:32','VOTE_UP'),(27,20,67,'2016-06-07 15:31:45','VOTE_UP'),(28,11,67,'2016-06-07 15:31:50','VOTE_UP'),(30,23,63,'2016-06-07 15:44:25','VOTE_UP');
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-09 15:03:19
