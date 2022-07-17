/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : localhost:3306
 Source Schema         : db_chinese_poems

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 17/07/2022 16:05:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_classify
-- ----------------------------
DROP TABLE IF EXISTS `tb_classify`;
CREATE TABLE `tb_classify` (
  `id` int(16) DEFAULT NULL,
  `classify_name` varchar(255) DEFAULT NULL COMMENT '类型名称',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `parent_id` int(11) DEFAULT '0',
  `del_flag` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_dept_name_uindex` (`name`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_poems
-- ----------------------------
DROP TABLE IF EXISTS `tb_poems`;
CREATE TABLE `tb_poems` (
  `id` varchar(50) NOT NULL COMMENT '诗词歌赋id',
  `title` varchar(50) DEFAULT NULL COMMENT '题目',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `chapter` varchar(50) DEFAULT NULL COMMENT '章节  （适用于 诗经 论语）',
  `section` varchar(50) DEFAULT NULL COMMENT '回       （适用于 诗经 论语）',
  `classify_id` int(16) DEFAULT '1',
  `content` longtext COMMENT '内容',
  `create_time` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `poem_img` varchar(255) DEFAULT NULL COMMENT '诗词配图',
  `isPublish` int(2) DEFAULT '0',
  `hot` int(128) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `author` (`author`) USING BTREE,
  KEY `title` (`title`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

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
  `del_flag` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `dept_id` FOREIGN KEY (`dept_id`) REFERENCES `tb_dept` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
