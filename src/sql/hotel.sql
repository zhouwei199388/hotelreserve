-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.17-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5168
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 hotel 的数据库结构
CREATE DATABASE IF NOT EXISTS `hotel` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hotel`;

-- 导出  表 hotel.admin 结构
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `permission` int(11) DEFAULT '0' COMMENT '权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- 正在导出表  hotel.admin 的数据：~2 rows (大约)
DELETE FROM `admin`;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id`, `user`, `password`, `permission`) VALUES
	(1, 'zouwei', '123456', 0),
	(2, 'zouwei', '123456', 1);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- 导出  表 hotel.hotelimage 结构
CREATE TABLE IF NOT EXISTS `hotelimage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotelId` int(11) NOT NULL DEFAULT '0',
  `url` varchar(300) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hotelimage_hotelinfo` (`hotelId`),
  CONSTRAINT `FK_hotelimage_hotelinfo` FOREIGN KEY (`hotelId`) REFERENCES `hotelinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='酒店图片';

-- 正在导出表  hotel.hotelimage 的数据：~0 rows (大约)
DELETE FROM `hotelimage`;
/*!40000 ALTER TABLE `hotelimage` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotelimage` ENABLE KEYS */;

-- 导出  表 hotel.hotelinfo 结构
CREATE TABLE IF NOT EXISTS `hotelinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotelName` varchar(50) DEFAULT NULL COMMENT '酒店名',
  `hotelAddress` varchar(50) DEFAULT NULL COMMENT '酒店地址',
  `phone` varchar(50) DEFAULT NULL COMMENT '酒店联系电话',
  `facility` varchar(50) DEFAULT NULL COMMENT '设施',
  `hotelText` varchar(300) DEFAULT NULL COMMENT '酒店介绍',
  `minPrice` double DEFAULT '0' COMMENT '最低价',
  `addressname` varchar(50) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='酒店信息表';

-- 正在导出表  hotel.hotelinfo 的数据：~2 rows (大约)
DELETE FROM `hotelinfo`;
/*!40000 ALTER TABLE `hotelinfo` DISABLE KEYS */;
INSERT INTO `hotelinfo` (`id`, `hotelName`, `hotelAddress`, `phone`, `facility`, `hotelText`, `minPrice`, `addressname`, `latitude`, `longitude`) VALUES
	(1, '四季星酒店', 'test', '150908240', '手动阀', '手动阀', 0, NULL, NULL, NULL),
	(2, '四季星酒店', '深圳市龙岗区布吉大道', '0217-88888888', '停车场 游泳池 健身房 wifi', '四季星酒店是一家特色经典酒店', 0, NULL, NULL, NULL);
/*!40000 ALTER TABLE `hotelinfo` ENABLE KEYS */;

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=gbk COMMENT='酒店房间';

-- 正在导出表  hotel.hotelroom 的数据：~2 rows (大约)
DELETE FROM `hotelroom`;
/*!40000 ALTER TABLE `hotelroom` DISABLE KEYS */;
INSERT INTO `hotelroom` (`id`, `hotelId`, `name`, `price`, `window`, `image`) VALUES
	(16, 1, '标间', 258, 1, NULL),
	(17, 1, '标间', 258, 1, NULL);
/*!40000 ALTER TABLE `hotelroom` ENABLE KEYS */;

-- 导出  表 hotel.hotel_order 结构
CREATE TABLE IF NOT EXISTS `hotel_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0',
  `orderNumber` varchar(255) DEFAULT NULL COMMENT '订单号',
  `roomNumber` int(11) DEFAULT '0' COMMENT '房间数',
  `people` varchar(50) DEFAULT NULL COMMENT '入住人',
  `phone` varchar(50) NOT NULL COMMENT '手机号',
  `note` varchar(50) DEFAULT NULL COMMENT '备注',
  `status` int(11) DEFAULT '0' COMMENT '入住状态',
  `price` double DEFAULT '0' COMMENT '支付金额',
  `startDate` varchar(50) DEFAULT NULL COMMENT '入住时间',
  `endDate` varchar(50) DEFAULT NULL COMMENT '离店时间',
  `hotel` varchar(50) NOT NULL COMMENT '预定的酒店',
  `hotelroom` varchar(50) NOT NULL COMMENT '预订的房间',
  PRIMARY KEY (`id`),
  KEY `FK_hotel_order_user` (`userId`),
  CONSTRAINT `FK_hotel_order_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='订单';

-- 正在导出表  hotel.hotel_order 的数据：~0 rows (大约)
DELETE FROM `hotel_order`;
/*!40000 ALTER TABLE `hotel_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotel_order` ENABLE KEYS */;

-- 导出  表 hotel.roomimage 结构
CREATE TABLE IF NOT EXISTS `roomimage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roomId` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_roomimage_hotelroom` (`roomId`),
  CONSTRAINT `FK_roomimage_hotelroom` FOREIGN KEY (`roomId`) REFERENCES `hotelroom` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='客房图片';

-- 正在导出表  hotel.roomimage 的数据：~6 rows (大约)
DELETE FROM `roomimage`;
/*!40000 ALTER TABLE `roomimage` DISABLE KEYS */;
INSERT INTO `roomimage` (`id`, `roomId`, `name`, `url`) VALUES
	(10, 16, 'test', 'https://hotelimage.oss-cn-shanghai.aliyuncs.com/hotel/9258356017_1215247113.400x400.jpg'),
	(11, 16, 'test', 'https://hotelimage.oss-cn-shanghai.aliyuncs.com/hotel/9258356017_1215247113.400x400.jpg'),
	(12, 16, 'test', 'https://hotelimage.oss-cn-shanghai.aliyuncs.com/hotel/9258356017_1215247113.400x400.jpg'),
	(17, 17, 'test', 'https://hotelimage.oss-cn-shanghai.aliyuncs.com/hotel/9258356017_1215247113.400x400.jpg'),
	(18, 17, 'test', 'https://hotelimage.oss-cn-shanghai.aliyuncs.com/hotel/9258356017_1215247113.400x400.jpg'),
	(19, 17, 'test', 'https://hotelimage.oss-cn-shanghai.aliyuncs.com/hotel/9258356017_1215247113.400x400.jpg');
/*!40000 ALTER TABLE `roomimage` ENABLE KEYS */;

-- 导出  表 hotel.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) DEFAULT NULL,
  `sessionkey` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT '0',
  `phone` varchar(50) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `avatarurl` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `codeTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 正在导出表  hotel.user 的数据：~3 rows (大约)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `openid`, `sessionkey`, `level`, `phone`, `nickname`, `gender`, `avatarurl`, `code`, `codeTime`) VALUES
	(1, '123', '123456', 111, '15090824065', NULL, NULL, NULL, NULL, NULL),
	(2, '123', '123456', 111, '18805201455', NULL, NULL, NULL, NULL, NULL),
	(8, 'ofIRZ5BAfiLYT203ahdW8oJiJAzU', 'vYWFeukUtbmcvCT4qbZWzA==', 0, '15090824065', '邹维', 1, 'https://wx.qlogo.cn/mmopen/vi_32/FC7d3bDPUHSOMpMSiaHF0cliaP0IPiauVpGjia8LamtavvqiaxAQAeS4A7CCRd54tFq8bDSibgsmGIeoyw2eeiaWuflAQ/132', NULL, NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
