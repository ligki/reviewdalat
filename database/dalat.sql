/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : dalat

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 11/01/2021 16:58:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for news_share
-- ----------------------------
DROP TABLE IF EXISTS `news_share`;
CREATE TABLE `news_share`  (
  `id` int(8) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `title` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `title_image` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `html_content` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `created` datetime(0) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `last_update` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for review_object
-- ----------------------------
DROP TABLE IF EXISTS `review_object`;
CREATE TABLE `review_object`  (
  `id` int(8) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `type` tinyint(0) NULL DEFAULT NULL,
  `image_icon` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `rating1` int(0) NULL DEFAULT 0,
  `rating2` int(0) NULL DEFAULT 0,
  `rating3` int(0) NULL DEFAULT 0,
  `rating4` int(0) NULL DEFAULT 0,
  `rating5` int(0) NULL DEFAULT 0,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `last_update` datetime(6) NOT NULL ON UPDATE CURRENT_TIMESTAMP(6),
  `created` datetime(6) NULL DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
