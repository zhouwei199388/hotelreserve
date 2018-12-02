CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  'openid'varchar(255) NOT NULL COMMENT '微信id',
  'sessionKey' VARCHAR(255) NOT NULL COMMENT '微信key',
  'level' LONG NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';
