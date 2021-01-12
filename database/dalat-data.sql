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

 Date: 12/01/2021 16:59:53
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
  `last_update` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `created` datetime(0) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news_share
-- ----------------------------
INSERT INTO `news_share` VALUES (00000001, 'Hello các bạn', 'https://www.w3schools.com/howto/img_nature_wide.jpg', '<p>Hello babe</p>', 'Admin', '2021-01-12 13:27:08', '2021-01-08 09:57:11', 1);
INSERT INTO `news_share` VALUES (00000002, 'Hello mấy cưng', 'https://www.w3schools.com/howto/img_nature_wide.jpg', '<p>Hello boy</p>', 'Admin', '2021-01-12 13:27:12', '2021-01-08 09:57:11', 1);
INSERT INTO `news_share` VALUES (00000003, 'Hello nè', 'https://www.w3schools.com/howto/img_nature_wide.jpg', '<p>Hello girl</p>', 'Admin', '2021-01-12 13:27:14', '2021-01-08 09:57:11', 1);

-- ----------------------------
-- Table structure for review_comment
-- ----------------------------
DROP TABLE IF EXISTS `review_comment`;
CREATE TABLE `review_comment`  (
  `id` int(8) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'Người Bí Ẩn',
  `review_object_id` int(8) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `point` tinyint(1) NULL DEFAULT 3,
  `review_comment_parent` int(8) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `context` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `like` int(0) NULL DEFAULT 0,
  `dislike` int(0) NULL DEFAULT 0,
  `report` int(0) NULL DEFAULT 0,
  `last_update` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `created` datetime(0) NOT NULL DEFAULT '2020-01-01 00:00:00',
  `active` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of review_comment
-- ----------------------------
INSERT INTO `review_comment` VALUES (00000001, 'Người Bí Ẩn', 00000001, 3, NULL, 'Cái này hay lắm á\r\nVừa đẹp vừa xịn', 5, 2, 0, '2021-01-12 15:16:35', '2019-12-30 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000002, 'Người Bí Ẩn', 00000000, NULL, 00000001, 'Cái này chán\r\nChả có gì', 0, 5, 0, '2021-01-12 16:07:33', '2020-01-07 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000003, 'Ông Lão Đánh Cá', 00000002, 4, NULL, 'Tuyệt vời ông mặt trời	', 3, 0, 0, '2021-01-12 16:09:31', '2021-01-06 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000004, 'Cá Vàng', 00000004, 5, NULL, 'Tuyệt vời ông mặt trời	', 0, 0, 0, '2021-01-12 16:09:19', '2021-01-01 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000005, 'Taophu', 00000005, NULL, 00000003, 'Xàm', 2, 0, 0, '2021-01-12 16:08:50', '2021-01-22 00:00:00', 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of review_object
-- ----------------------------
INSERT INTO `review_object` VALUES (00000001, 'Quảng Trường', 1, 'https://mdbootstrap.com/img/Photos/Avatars/img%20(31).jpg', 4, 5, 8, 7, 10, ' Bà Huyện Thanh Quan, Phường 1, Thành phố Đà Lạt, Lâm Đồng\r\n', NULL, 'Quảng trường Lâm Viên là quảng trường nằm ở đường Trần Quốc Toản, đối diện hồ Xuân Hương, Phường 10, trung tâm thành phố Đà Lạt, tỉnh Lâm Đồng.', '2021-01-03 16:26:10.000000', '2021-01-08 16:11:05.000000', 1);
INSERT INTO `review_object` VALUES (00000002, 'Thiền viện Trúc lâm', 1, 'https://mdbootstrap.com/img/Photos/Avatars/img%20(31).jpg', 0, 0, 0, 4, 25, 'Hoa Cẩm Tú Cầu, Phường 3, Thành phố Đà Lạt, Lâm Đồng, Vietnam', NULL, 'Traditional Zen Buddhist temple located on a hill & featuring picturesque gardens & mountain views.', '2021-01-12 13:23:42.325223', '2021-01-08 16:11:05.000000', 1);
INSERT INTO `review_object` VALUES (00000003, 'Ga', 2, 'https://mdbootstrap.com/img/Photos/Avatars/img%20(31).jpg', 0, 0, 0, 5, 224, 'Hoa Cẩm Tú Cầu, Phường 3, Thành phố Đà Lạt, Lâm Đồng, Vietnam', '0123 456 789', 'Traditional Zen Buddhist temple located on a hill & featuring picturesque gardens & mountain views.', '2021-01-12 13:23:43.469037', '2021-01-08 16:11:05.000000', 1);
INSERT INTO `review_object` VALUES (00000004, 'Nhà Thờ', 3, 'https://mdbootstrap.com/img/Photos/Avatars/img%20(31).jpg', 0, 0, 0, 5, 20, 'Hoa Cẩm Tú Cầu, Phường 3, Thành phố Đà Lạt, Lâm Đồng, Vietnam', '0123 455 142', 'Traditional Zen Buddhist temple located on a hill & featuring picturesque gardens & mountain views.', '2021-01-12 13:23:45.117866', '2021-01-08 16:11:05.000000', 1);
INSERT INTO `review_object` VALUES (00000005, 'Hồ Tuyền Lâm', 2, 'https://mdbootstrap.com/img/Photos/Avatars/img%20(31).jpg', 0, 1, 0, 4, 16, 'Hoa Cẩm Tú Cầu, Phường 3, Thành phố Đà Lạt, Lâm Đồng, Vietnam', '0987 356 244', 'Traditional Zen Buddhist temple located on a hill & featuring picturesque gardens & mountain views.', '2021-01-12 13:23:46.972702', '2021-01-08 16:11:05.000000', 1);
INSERT INTO `review_object` VALUES (00000006, 'Kong', 4, 'https://mdbootstrap.com/img/Photos/Avatars/img%20(31).jpg', 2, 0, 6, 0, 45, 'Hoa Cẩm Tú Cầu, Phường 3, Thành phố Đà Lạt, Lâm Đồng, Vietnam', '0966 365 254', 'Traditional Zen Buddhist temple located on a hill & featuring picturesque gardens & mountain views.', '2021-01-12 13:23:48.559859', '2021-01-08 16:11:05.000000', 1);
INSERT INTO `review_object` VALUES (00000007, 'Dream Comes True', 4, 'https://mdbootstrap.com/img/Photos/Avatars/img%20(31).jpg', 0, 6, 0, 0, 221, 'Hoa Cẩm Tú Cầu, Phường 3, Thành phố Đà Lạt, Lâm Đồng, Vietnam', '0985 254 124', 'Traditional Zen Buddhist temple located on a hill & featuring picturesque gardens & mountain views.', '2021-01-12 13:23:51.329973', '2021-01-08 16:11:05.000000', 1);

SET FOREIGN_KEY_CHECKS = 1;
