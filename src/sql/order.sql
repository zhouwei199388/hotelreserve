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

-- 导出  表 hotel.order 结构
CREATE TABLE IF NOT EXISTS `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNumber` varchar(255) NOT NULL COMMENT '订单号',
  `roomNumbeer` int(11) NOT NULL DEFAULT '0' COMMENT '房间数',
  `people` varchar(50) NOT NULL COMMENT '入住人',
  `phone` varchar(50) NOT NULL COMMENT '手机号',
  `note` varchar(50) NOT NULL COMMENT '备注',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '入住状态',
  `price` double NOT NULL DEFAULT '0' COMMENT '支付金额',
  `startTime` timestamp NULL DEFAULT NULL COMMENT '入住时间',
  `endTime` timestamp NULL DEFAULT NULL COMMENT '离店时间',
  `hotel` varchar(50) DEFAULT NULL COMMENT '预定的酒店',
  `hotelroom` varchar(50) DEFAULT NULL COMMENT '预订的房间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='订单';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
