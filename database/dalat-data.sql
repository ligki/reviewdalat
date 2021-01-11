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

 Date: 11/01/2021 16:59:15
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
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (1);

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
-- Records of news_share
-- ----------------------------
INSERT INTO `news_share` VALUES (00000001, 'Hello', 'https://www.w3schools.com/howto/img_nature_wide.jpg', '<p>Hello</p>', 'Admin', '2021-01-08 09:57:11', 1, NULL);
INSERT INTO `news_share` VALUES (00000002, 'Hello', 'https://www.w3schools.com/howto/img_nature_wide.jpg', '<p>Hello</p>', 'Admin', '2021-01-08 09:57:11', 1, NULL);
INSERT INTO `news_share` VALUES (00000003, 'Hello', 'https://www.w3schools.com/howto/img_nature_wide.jpg', '<p>Hello</p>', 'Admin', '2021-01-08 09:57:11', 1, NULL);

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

-- ----------------------------
-- Records of review_object
-- ----------------------------
INSERT INTO `review_object` VALUES (00000001, 'Quảng Trường', 1, 'https://mdbootstrap.com/img/Photos/Avatars/img%20(31).jpg', 4, 5, 8, 7, 10, ' Bà Huyện Thanh Quan, Phường 1, Thành phố Đà Lạt, Lâm Đồng\r\n', NULL, 'Quảng trường Lâm Viên là quảng trường nằm ở đường Trần Quốc Toản, đối diện hồ Xuân Hương, Phường 10, trung tâm thành phố Đà Lạt, tỉnh Lâm Đồng.', '2021-01-03 16:26:10.000000', '2021-01-08 16:11:05.000000', 1);
INSERT INTO `review_object` VALUES (00000002, 'Thiền viện Trúc lâm', 1, 'https://mdbootstrap.com/img/Photos/Avatars/img%20(31).jpg', 0, 0, 0, 0, 22, 'Hoa Cẩm Tú Cầu, Phường 3, Thành phố Đà Lạt, Lâm Đồng, Vietnam', NULL, 'Traditional Zen Buddhist temple located on a hill & featuring picturesque gardens & mountain views.', '2021-01-19 13:27:25.000000', '2021-01-08 16:11:05.000000', 1);

SET FOREIGN_KEY_CHECKS = 1;
