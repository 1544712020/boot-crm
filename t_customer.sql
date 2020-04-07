/*
Navicat MySQL Data Transfer

Source Server         : 谢谢
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-04-07 14:33:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_customer`
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `jobs` varchar(32) NOT NULL,
  `phone` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('1', '刘为中', '学生', '123');
INSERT INTO `t_customer` VALUES ('2', '李白', '诗人', '456');
INSERT INTO `t_customer` VALUES ('3', '王维', '诗人', 'qwe');
INSERT INTO `t_customer` VALUES ('4', 'zhangsan', 'manager', '13233334444');
INSERT INTO `t_customer` VALUES ('5', 'zhangsan', 'manager', '13233334444');
