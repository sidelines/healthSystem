/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : healthsystem

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2015-09-30 16:35:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `diagnose`
-- ----------------------------
DROP TABLE IF EXISTS `diagnose`;
CREATE TABLE `diagnose` (
  `dia_id` int(10) NOT NULL AUTO_INCREMENT,
  `d_id` int(10) DEFAULT NULL,
  `u_id` int(10) DEFAULT NULL,
  `m_id` int(10) DEFAULT NULL,
  `cond` varchar(10) DEFAULT NULL,
  `state` varchar(3) DEFAULT NULL,
  `report_name` varchar(20) DEFAULT NULL,
  `report` text,
  `d_date` date DEFAULT NULL,
  PRIMARY KEY (`dia_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diagnose
-- ----------------------------
INSERT INTO `diagnose` VALUES ('23', '3', '1', '37', '心脏病', '严重', '心脏病分析报告', '心脏病住院', '2015-05-21');
INSERT INTO `diagnose` VALUES ('24', '3', '1', '43', '心脏病', '严重', '心脏病分析报告', '心脏病住院', '2015-05-24');
INSERT INTO `diagnose` VALUES ('25', '3', '1', '53', '发烧', '轻微', '发烧的分析报告', '发烧回家', '2015-05-24');
INSERT INTO `diagnose` VALUES ('26', '3', '1', '54', '发烧', '严重', '发烧的分析报告', '发烧住院', '2015-05-24');
INSERT INTO `diagnose` VALUES ('27', '1', '9', '58', '心脏病', '一般', '心脏病分析报告', '心脏病吃药', '2015-06-01');
INSERT INTO `diagnose` VALUES ('28', '3', '1', '52', '心脏病', '严重', '心脏病分析报告', '心脏病住院', '2015-06-23');

-- ----------------------------
-- Table structure for `doctor`
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `d_id` int(10) NOT NULL AUTO_INCREMENT,
  `d_name` varchar(10) DEFAULT NULL,
  `d_age` int(5) DEFAULT NULL,
  `d_sex` varchar(2) DEFAULT NULL,
  `Indications` varchar(15) DEFAULT NULL,
  `d_username` varchar(10) DEFAULT NULL,
  `d_password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('1', '张三', '50', '女', '高血压', 'zhangsan', '123');
INSERT INTO `doctor` VALUES ('2', '李四', '52', '男', '心脏病', 'lisi', '123');
INSERT INTO `doctor` VALUES ('3', '王五', '51', '男', '发烧', 'wangwu', '123');

-- ----------------------------
-- Table structure for `monitoring`
-- ----------------------------
DROP TABLE IF EXISTS `monitoring`;
CREATE TABLE `monitoring` (
  `m_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_id` int(10) DEFAULT '0',
  `d_id` int(10) DEFAULT NULL,
  `highpressure` int(3) DEFAULT NULL,
  `lowpressure` int(3) DEFAULT NULL,
  `temperature` double(10,2) DEFAULT NULL,
  `pulse` int(3) DEFAULT NULL,
  `ECG` text,
  `warning` int(2) DEFAULT NULL,
  `m_date` date DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of monitoring
-- ----------------------------
INSERT INTO `monitoring` VALUES ('33', '1', '1', '140', '80', '38.80', '80', null, '2', '2015-05-21');
INSERT INTO `monitoring` VALUES ('34', '1', '2', '190', '110', '41.00', '90', null, '1', '2015-05-21');
INSERT INTO `monitoring` VALUES ('35', '2', '3', '190', '110', '41.00', '90', null, '2', '2015-05-21');
INSERT INTO `monitoring` VALUES ('37', '1', '3', '123', '123', '456.00', '234', null, '2', '2015-05-21');
INSERT INTO `monitoring` VALUES ('44', '1', '3', '111', '111', '111.00', '111', 'Tulips.jpg', '1', '2015-05-24');
INSERT INTO `monitoring` VALUES ('45', '0', null, null, null, null, null, '寇鑫—WEB开发工程师.pdf', null, null);
INSERT INTO `monitoring` VALUES ('46', '1', '3', '123', '234', '567.00', '222', '寇鑫—WEB开发工程师.pdf', '1', '2015-05-24');
INSERT INTO `monitoring` VALUES ('50', '1', '3', '140', '111', '2333.00', '222', '寇鑫—WEB开发工程师.pdf', '1', '2015-05-24');
INSERT INTO `monitoring` VALUES ('51', '1', '3', '140', '111', '2333.00', '222', '寇鑫—WEB开发工程师.pdf', '1', '2015-05-24');
INSERT INTO `monitoring` VALUES ('52', '1', '3', '123', '45', '45.00', '45', 'Desert.jpg', '2', '2015-05-24');
INSERT INTO `monitoring` VALUES ('53', '1', '3', '150', '100', '36.60', '80', 'Hydrangeas.jpg', '2', '2015-05-24');
INSERT INTO `monitoring` VALUES ('54', '1', '3', '150', '111', '42.00', '80', 'Tulips.jpg', '2', '2015-05-24');
INSERT INTO `monitoring` VALUES ('55', '0', null, null, null, null, null, 'Tulips.jpg', null, null);
INSERT INTO `monitoring` VALUES ('56', '0', null, null, null, null, null, 'Tulips.jpg', null, null);
INSERT INTO `monitoring` VALUES ('57', '0', null, null, null, null, null, 'Hydrangeas.jpg', null, null);
INSERT INTO `monitoring` VALUES ('58', '9', '1', '140', '80', '37.10', '70', 'Desert.jpg', '2', '2015-06-01');

-- ----------------------------
-- Table structure for `report`
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `r_id` int(10) NOT NULL AUTO_INCREMENT,
  `r_con` varchar(10) DEFAULT NULL,
  `r_st` varchar(10) DEFAULT NULL,
  `r_re` text,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES ('1', '高血压', '严重', '高血压住院');
INSERT INTO `report` VALUES ('2', '高血压', '一般', '高血压吃药');
INSERT INTO `report` VALUES ('3', '高血压', '轻微', '高血压回家');
INSERT INTO `report` VALUES ('4', '心脏病', '严重', '心脏病住院');
INSERT INTO `report` VALUES ('5', '心脏病', '一般', '心脏病吃药');
INSERT INTO `report` VALUES ('6', '心脏病', '轻微', '心脏病回家');
INSERT INTO `report` VALUES ('7', '发烧', '严重', '发烧住院');
INSERT INTO `report` VALUES ('8', '发烧', '一般', '发烧吃药');
INSERT INTO `report` VALUES ('9', '发烧', '轻微', '发烧回家');

-- ----------------------------
-- Table structure for `title`
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title` (
  `t_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_id` int(10) DEFAULT NULL,
  `d_id` int(10) DEFAULT NULL,
  `doctorname` varchar(20) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `context` text,
  `t_date` date DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of title
-- ----------------------------
INSERT INTO `title` VALUES ('1', '1', '1', '寇鑫', '发烧', '发烧了', '2015-05-21');
INSERT INTO `title` VALUES ('3', '1', '2', '阿的说法', '刘鳗鱼', '傻逼', '2015-05-21');
INSERT INTO `title` VALUES ('4', '1', '1', '让他', '按时交房', '爱妃', '2015-05-21');
INSERT INTO `title` VALUES ('5', '1', '1', '锅煽豆腐', '发烧', '发烧很严重后果很糟糕', '2015-05-21');
INSERT INTO `title` VALUES ('6', '1', '2', '爱国', '阿斯蒂芬', '啊都是发生的发生法士大夫', '2015-05-21');
INSERT INTO `title` VALUES ('7', '1', '3', '王五', '心脏病', '爱十分深刻的法律框架', '2015-05-21');
INSERT INTO `title` VALUES ('8', '1', '3', '王五', '我是猴子', '你是猴子', '2015-05-24');
INSERT INTO `title` VALUES ('9', '9', '1', '张三', '肚子疼', '肚子疼了两天了', '2015-06-01');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(10) DEFAULT NULL,
  `u_age` int(5) DEFAULT NULL,
  `u_sex` varchar(2) DEFAULT NULL,
  `u_username` varchar(10) DEFAULT NULL,
  `u_password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '寇鑫', '21', '男', 'user', '123');
INSERT INTO `user` VALUES ('2', '曹景咬', '22', '女', 'cao', '123');
INSERT INTO `user` VALUES ('6', '阿斯蒂芬', '19', '女', 'klasjdfk', 'asdf');
INSERT INTO `user` VALUES ('7', '寇鑫', '23', '男', 'kx1', 'thisthis');
INSERT INTO `user` VALUES ('9', '冯佳欣', '22', '女', 'fengjiaxin', '123');
