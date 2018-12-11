-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.51 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 hotel 的数据库结构
CREATE DATABASE IF NOT EXISTS `hotel` /*!40100 DEFAULT CHARACTER SET gbk */;
USE `hotel`;

-- 导出  表 hotel.hotelroom 结构
CREATE TABLE IF NOT EXISTS `hotelroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotelId` int(11) NOT NULL DEFAULT '0',
  `name` varchar(50) DEFAULT NULL COMMENT '房型',
  `price` double DEFAULT '0' COMMENT '价格',
  `window` int(11) DEFAULT '0' COMMENT '有无窗',
  `image` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__hotelinfo` (`hotelId`),
  CONSTRAINT `FK__hotelinfo` FOREIGN KEY (`hotelId`) REFERENCES `hotelinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='酒店房间';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
