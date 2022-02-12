/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : db_test

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 12/02/2022 23:26:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept` (
  `id` int(11) DEFAULT NULL COMMENT '部门id',
  `name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_dept
-- ----------------------------
BEGIN;
INSERT INTO `tb_dept` (`id`, `name`) VALUES (1, '财务部');
INSERT INTO `tb_dept` (`id`, `name`) VALUES (2, '技术部');
COMMIT;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `dept_id` int(11) DEFAULT NULL,
  `account` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `dept_id` FOREIGN KEY (`dept_id`) REFERENCES `tb_dept` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` (`id`, `name`, `age`, `email`, `dept_id`, `account`, `password`) VALUES ('bf77df6b44f5411bbb38f5bb0a555c83', '邢爸爸1', 12, NULL, 1, 'xbb1', 'd4f3030f64e5c1c97d4feceba59577b0');
INSERT INTO `tb_user` (`id`, `name`, `age`, `email`, `dept_id`, `account`, `password`) VALUES ('c2a9b7a26676460d92dfea50929102db', '李长龙', 12, NULL, 1, 'licl', '4713e3819d037d20d62a190ee12ffeab');
INSERT INTO `tb_user` (`id`, `name`, `age`, `email`, `dept_id`, `account`, `password`) VALUES ('e1d26ef69a1a441eb4cdd39c3114ae07', '邢爸爸', 12, NULL, 1, 'xbb', '68336006bd43e19653f97727686bfe5a');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
