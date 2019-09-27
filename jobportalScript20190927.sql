CREATE DATABASE  IF NOT EXISTS `m5project` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `m5project`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: m5project
-- ------------------------------------------------------
-- Server version	5.6.42-log

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
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comments` (
  `commentid` int(11) NOT NULL AUTO_INCREMENT,
  `postid` int(11) NOT NULL,
  `username` varchar(40) NOT NULL,
  `commentmsg` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`commentid`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,1,'i','comment from i'),(2,10,'',NULL),(3,10,'',NULL),(4,10,'',NULL),(5,10,'',NULL),(6,10,'',NULL),(7,10,'',NULL),(8,10,'','io'),(9,10,'','io'),(10,10,'','\';jg'),(11,10,'','heyy'),(12,10,'','sup'),(13,10,'',''),(14,10,'','yo'),(15,10,'','yo'),(16,10,'','.ljhgfdsaxcvbnm,'),(17,10,'','.ljhgfdsaxcvbnm,'),(18,10,'i','poiuyg'),(19,0,'i',NULL),(20,0,'i',NULL),(21,0,'i',NULL),(22,0,'i',NULL),(23,0,'i',NULL),(24,0,'i',NULL),(25,0,'','uilo'),(26,0,'i','erte'),(27,0,'i','qwe'),(28,0,'i','test'),(29,0,'i','qwe'),(30,0,'i','kjhu8oiiuoui'),(31,0,'i','drfvbfgh'),(32,0,'i','tyutyutu'),(33,0,'i','tyutyutyu'),(34,0,'i','jhdgjhbdfgjhfdf'),(35,0,'i','tyutyu'),(36,20,'i','tyutyu'),(37,20,'i','ewfrwre'),(38,20,'i','et'),(39,20,'i','tryty'),(40,20,'i','tryty'),(41,20,'i','tryty'),(42,20,'i','tryty'),(43,20,'i','tryty'),(44,20,'i','wewqew'),(45,20,'','dftert'),(46,20,'','weree'),(47,20,'','weree'),(48,20,'i','43535fgh'),(49,20,'i','hgjfngfyj'),(50,20,'i','hbdfh'),(51,20,'i','hgdjgnfh'),(52,20,'i','rtyrty'),(53,20,'i','wqdasd'),(54,20,'i','werwef'),(55,20,'i','xcbgdg'),(56,12,'i','wesrwr'),(57,20,'i','etst\\'),(58,20,'i','s'),(59,20,'','i'),(60,20,'','s'),(61,20,'i',''),(62,20,'i',''),(63,20,'i','fgh'),(64,20,'i',''),(65,20,'',''),(66,20,'i','0oijl'),(67,20,'i','0oijl');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exp`
--

DROP TABLE IF EXISTS `exp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `exp` (
  `expid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `years_of_exp` varchar(40) DEFAULT NULL,
  `job_title` varchar(40) DEFAULT NULL,
  `company_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`expid`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exp`
--

LOCK TABLES `exp` WRITE;
/*!40000 ALTER TABLE `exp` DISABLE KEYS */;
INSERT INTO `exp` VALUES (40,'i','SUCCESS','dfghkdhjfg','TEST'),(54,'i','SUCCESS','ADD','TEST'),(69,'','lkj','lkj','kj'),(70,'','lkj','kj','kj'),(71,'i','o','o','o'),(72,'i','i','i','i');
/*!40000 ALTER TABLE `exp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobpost`
--

DROP TABLE IF EXISTS `jobpost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `jobpost` (
  `postid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `postTitle` varchar(40) NOT NULL,
  `postContent` varchar(500) NOT NULL,
  PRIMARY KEY (`postid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobpost`
--

LOCK TABLES `jobpost` WRITE;
/*!40000 ALTER TABLE `jobpost` DISABLE KEYS */;
INSERT INTO `jobpost` VALUES (12,'i','q','q'),(13,'i','i','i'),(14,'i','i','i'),(15,'i','o','o\r\n'),(19,'','add',''),(20,'i','update success','post');
/*!40000 ALTER TABLE `jobpost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qual`
--

DROP TABLE IF EXISTS `qual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `qual` (
  `qualid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `specialization` varchar(40) DEFAULT NULL,
  `grad_year` varchar(40) DEFAULT NULL,
  `school_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`qualid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qual`
--

LOCK TABLES `qual` WRITE;
/*!40000 ALTER TABLE `qual` DISABLE KEYS */;
INSERT INTO `qual` VALUES (8,'i','lkj','jkl','jkl'),(9,'i','for ','add qual','test'),(20,'saitama3',' ',' ',' '),(22,'i','lkj','kjl','lk'),(23,'','o','o','o'),(24,'','o','o','o'),(25,'i','i','i','o'),(26,'i','i','i','i');
/*!40000 ALTER TABLE `qual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `username` varchar(40) NOT NULL,
  `firstname` varchar(40) NOT NULL,
  `lastname` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `country` varchar(40) NOT NULL,
  `state` varchar(40) NOT NULL,
  `city` varchar(40) NOT NULL,
  `postalcode` varchar(40) NOT NULL,
  `birthdate` varchar(40) NOT NULL,
  `birthmonth` varchar(40) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('aaaa','aa','aa','a@email.com','password','a','a','a','231231','12','feb'),('cfgvbhnjmklvgbhjn','xdrcvgbnhjk','cfgvbhnjmkl','izzulraimi@gmail.com','ndhfbghdbg','sing','','','123456','12','jun'),('cftgvuybhjn','sxecfvgbhu','drtcvgyhnu','yctfgvybh@dfg.com','xdcfvbhjn','sing','','','123456','12','apr'),('cftvgbhnjkm','3wrethjk fvbhjnkl','fctvbhjnk','izzulraimi93@gmail.com','usycfavjfbhvn','singap','','','123456','12','jul'),('dcfgvbnj dcfgvbh','zsdcvbhnmk','dfcgvbnmk','izzulraimi93@gmail.com','sdjkghbfdghb ','sing','','','123456','12','jan'),('helloUser','hello','user','izzulraimi93@gmail.com','alskfd,sjhbghkyur','sing','','','123456','12','feb'),('i','o','o','o','i','o','o','o','o','o','o'),('ihcbgfhjkljugft','kuygfghjk','iujgfcbjmkl','dzgy@jsdf.com','uhjxdfxcghjui','uyjgf','','','123456','12','dec'),('iopiopi','iopio','ioiopi','iopipo@tu.hou','uiopiopiop','fyfty','drydry','ydry','575868','12','jan'),('izraimi99','izzul','raimi','izzulraimi93@gmail.com','qwertyuiop','singapore','','','776904','06','Nov'),('jhjhbmjfbv sdxhb','hgkuyjgkjyhb','jhbjhbhjbjh','shdbgv@dhfbvg.com','hyfbgjheysgdfuykhb','lduif','','','123456','12','dec'),('kjdbhfkxvb','yfvjcdgtjmcdsdvhv ','khb dfghb ','dfxkvb@dubf.com','skdhb cdkb','SING','','','123456','12','dec'),('kjhgfcgbhjkl','koiuygf','lojhubbn','losfh@gfhb.com','wdgfhvbewsfzd','sdxf','','','123465','12','dec'),('lkjcgfhjklm;gfb','olikghf','lkjhgcfc','sdygf@dhbv.com','yhesfvdhvfdshtcftc','yhvf','','','123456','12','dec'),('oiuouoiuo','80oioiiouiouo','uouoiuou','izzulraimi93@gmail.com','oiuouoiuoiuoiu','sing','','','123456','12','Jan'),('rtur','rhr','urtu','irt@tjdry.com','dfrurtitrit','rti','urtur','rtu','586584','12','jan'),('saitama','op','op','','genosisannoying','country z','','nov','','123456','2'),('saitama2','op','op','opman@gmail.com','genosisannoying','country z','1','nov','3','123456','2'),('saitama3','op','op','opman@gmail.com','genosisannoying','country z','city z','Dragon state','123456','2','nov'),('saitama4','op','op','opman@gmail.com','genosisannoying','country z','lion state','city-z','123456','2','nov'),('tgfhfc hc','ttyf','ytgfytf','tgfvsdc@hberf.com','dcwfedgvcsmdyhcv','ashb','','','123456','12','dec'),('uouoiuoiu','iouiouo','uiouoiuo','ouoiuo@iygds.com','oiudifuyhedskycg','udgcy','','','123456','12','dec'),('yhv bsdkjhvb','iohyhg','vv k,vfkjgv','iwhybcgf@bdshb.com','ehsbcdhzxb','SI','','','123456','12','dec'),('yuit','yuit','yuit','yui@fj.vom','ftudryrer','jftjtu','ifti','tjt','568658','12','jan'),('yuiyuiyui','uyiyui','yuiyui','izzulraimi93@gmail.com','lopweotiuewriptyewrui','sing','','','123456','12','jun'),('zuzuzuzu','izzul','raimi','asdlkj@askljda.com','lkjoiu12','lol','','','123456','12','jan');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'm5project'
--

--
-- Dumping routines for database 'm5project'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-27 21:08:18
