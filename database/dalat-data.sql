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

 Date: 20/01/2021 15:20:05
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
  `point` tinyint(1) NULL DEFAULT NULL,
  `review_comment_parent` int(8) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `context` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `comment` int(0) NULL DEFAULT 0,
  `like` int(0) NULL DEFAULT 0,
  `dislike` int(0) NULL DEFAULT 0,
  `report` int(0) NULL DEFAULT 0,
  `last_update` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `created` datetime(0) NOT NULL DEFAULT '2020-01-01 00:00:00',
  `active` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of review_comment
-- ----------------------------
INSERT INTO `review_comment` VALUES (00000001, 'Người Bí Ẩn', 00000001, 3, NULL, 'Cái này hay lắm á\r\nVừa đẹp vừa xịn', NULL, 5, 2, 0, '2021-01-12 15:16:35', '2019-12-30 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000002, 'Người Bí Ẩn', NULL, NULL, 00000001, 'Cái này chán\r\nChả có gì', NULL, 0, 1, 0, '2021-01-19 10:14:24', '2020-01-07 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000003, 'Ông Lão Đánh Cá', 00000002, 4, NULL, 'Tuyệt vời ông mặt trời	', NULL, 3, 0, 0, '2021-01-19 16:38:50', '2021-01-12 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000004, 'Cá Vàng', 00000004, 5, NULL, 'Tuyệt vời ông mặt trời	', NULL, 0, 0, 0, '2021-01-19 16:38:55', '2021-01-06 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000005, 'Taophu', NULL, NULL, 00000003, 'Xàm', NULL, 2, 0, 0, '2021-01-19 10:14:12', '2021-01-22 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000006, 'Hair', 00000001, 4, NULL, 'Xàm', NULL, NULL, NULL, NULL, '2021-01-19 10:36:37', '2021-01-15 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000007, 'Pooob', 00000001, 4, 00000001, 'Gà', NULL, NULL, NULL, NULL, '2021-01-19 10:36:37', '2021-01-15 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000008, 'Dam Hai Dang', 00000001, 4, NULL, 'Hay lam do', NULL, 0, 0, 0, NULL, '2020-01-01 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000009, 'Dam Hai Dang', 00000001, 4, NULL, 'Hay lam', NULL, 0, 0, 0, NULL, '2020-01-01 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000010, 'Dam Hai Dang', 00000001, 4, NULL, 'Hay lam', NULL, 0, 0, 0, NULL, '2020-01-01 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000011, 'Hai Dang', 00000001, 4, NULL, 'Hay lam', NULL, 0, 0, 0, NULL, '2020-01-01 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000012, 'Hai Dang', 00000001, 4, NULL, 'Hay lam', NULL, 0, 0, 0, NULL, '2020-01-01 00:00:00', 1);
INSERT INTO `review_comment` VALUES (00000013, 'sdfdasf', 00000002, 2, NULL, 'fdsaf                data-dismiss=\"modal\"\n                data-dismiss=\"modal\"\n', NULL, 0, 0, 0, NULL, '2021-01-19 16:21:50', 1);
INSERT INTO `review_comment` VALUES (00000014, 'dasfdsfds', 00000002, 2, NULL, '<div class=\"form-group\">\n                <label for=\"content\" class=\"font-weight-bold\"\n                  >Nội dung review<span\n                    class=\"text-danger ml-1 font-weight-bold\"', NULL, 0, 0, 0, NULL, '2021-01-19 16:35:17', 1);
INSERT INTO `review_comment` VALUES (00000015, 'dasfdsfds', 00000002, 2, NULL, '<div class=\"form-group\">\n                <label for=\"content\" class=\"font-weight-bold\"\n                  >Nội dung review<span\n                    class=\"text-danger ml-1 font-weight-bold\"', NULL, 0, 0, 0, NULL, '2021-01-19 16:35:34', 1);
INSERT INTO `review_comment` VALUES (00000016, 'Dang 12', 00000002, 3, NULL, 'Khong biet viet gi ca', NULL, 0, 0, 0, NULL, '2021-01-19 16:45:57', 1);
INSERT INTO `review_comment` VALUES (00000017, 'Dang 14', 00000002, 3, NULL, '      console.log(\"jejeej\");\n      console.log(\"jejeej\");\n      console.log(\"jejeej\");\n', NULL, 0, 0, 0, NULL, '2021-01-19 16:48:08', 1);
INSERT INTO `review_comment` VALUES (00000018, 'Dai Ka', 00000002, 4, NULL, '          $(\'#write-review-modal\').modal(\'hide\');\n          $(\'#write-review-modal\').modal(\'hide\');\n', NULL, 0, 0, 0, NULL, '2021-01-19 17:03:55', 1);
INSERT INTO `review_comment` VALUES (00000019, 'Dai Ca', 00000001, 1, NULL, 'chán, chẳng có gì hay ho', NULL, 0, 0, 0, NULL, '2021-01-19 17:06:08', 1);
INSERT INTO `review_comment` VALUES (00000020, 'Đàm Hải Đăng', 00000007, 5, NULL, 'Rất đẹp và hoành tráng', NULL, 0, 0, 0, NULL, '2021-01-19 17:07:16', 1);
INSERT INTO `review_comment` VALUES (00000021, 'Đăng Đẹp Trai', 00000002, 4, NULL, 'Quá là xịn xò, hay lắm, rất hay luôn ', NULL, 0, 0, 0, NULL, '2021-01-19 17:18:37', 1);
INSERT INTO `review_comment` VALUES (00000022, 'Hài', 00000002, 2, NULL, '$(\'#write-review-modal\').modal(\'hide\');\n$(\'#write-review-modal\').modal(\'hide\');', NULL, 0, 0, 0, NULL, '2021-01-20 09:14:27', 1);
INSERT INTO `review_comment` VALUES (00000023, 'Chí phèo', 00000002, 5, NULL, 'this.errors.push(\"Xin hãy xác nhận lại\")this.errors.push(\"Xin hãy xác nhận lại\")this.errors.push(\"Xin hãy xác nhận lại\")', NULL, 0, 0, 0, NULL, '2021-01-20 09:18:46', 1);
INSERT INTO `review_comment` VALUES (00000024, 'Hai Dang', 00000001, 4, NULL, 'Hay lam', NULL, 0, 0, 0, NULL, '2021-01-20 09:53:43', 1);
INSERT INTO `review_comment` VALUES (00000025, 'author', NULL, NULL, 00000001, 'Rat hay', NULL, 1, 0, 0, '2021-01-20 14:09:18', '2021-01-20 13:53:30', 1);
INSERT INTO `review_comment` VALUES (00000026, 'Đăng xoài', NULL, NULL, 00000001, 'chuẩn mà', 1, 0, 0, 0, '2021-01-20 14:09:23', '2021-01-20 14:03:35', 1);
INSERT INTO `review_comment` VALUES (00000027, 'Đăng xoài', NULL, NULL, 00000001, 'chuẩn mà', 1, 0, 0, 0, '2021-01-20 14:09:23', '2021-01-20 14:06:43', 1);
INSERT INTO `review_comment` VALUES (00000028, 'Đăng xoài', NULL, NULL, 00000001, 'chuẩn mà', 0, 1, 0, 0, '2021-01-20 14:09:27', '2021-01-20 14:07:23', 1);
INSERT INTO `review_comment` VALUES (00000029, 'Đăng xoài', NULL, NULL, 00000001, 'chuẩn mà', 0, 0, 0, 1, '2021-01-20 14:09:27', '2021-01-20 14:08:23', 1);
INSERT INTO `review_comment` VALUES (00000030, 'Thi No', 00000002, 5, NULL, '          console.log(response.data);\n          console.log(response.data);\n          console.log(response.data);\n', 0, 0, 0, 0, NULL, '2021-01-20 14:31:00', 1);
INSERT INTO `review_comment` VALUES (00000031, 'Hello', NULL, NULL, 00000030, '          console.log(response.data);\n          console.log(response.data);\n          console.log(response.data);\n', 1, 0, 0, 0, NULL, '2021-01-20 14:31:22', 1);
INSERT INTO `review_comment` VALUES (00000032, 'Babe', NULL, NULL, 00000030, 'text-primarytext-primarytext-primarytext-primarytext-primary', 1, 0, 0, 0, NULL, '2021-01-20 15:04:52', 1);
INSERT INTO `review_comment` VALUES (00000033, 'Like', NULL, NULL, 00000030, 'text-primarytext-primarytext-primarytext-primary', 0, 1, 0, 0, NULL, '2021-01-20 15:05:12', 1);
INSERT INTO `review_comment` VALUES (00000034, 'Ha', NULL, NULL, 00000030, 'text-primarytext-primarytext-primarytext-primary', 0, 0, 0, 1, NULL, '2021-01-20 15:06:26', 1);
INSERT INTO `review_comment` VALUES (00000035, 'kiki', NULL, NULL, 00000030, 'text-primarytext-primarytext-primarytext-primarytext-primary', 0, 0, 1, 0, NULL, '2021-01-20 15:07:00', 1);
INSERT INTO `review_comment` VALUES (00000036, 'Hello', NULL, NULL, 00000023, 'alo      console.log(react);\n      console.log(react);\n      console.log(react);\n      console.log(react);\n', 1, 0, 0, 0, NULL, '2021-01-20 15:10:41', 1);
INSERT INTO `review_comment` VALUES (00000037, 'Babe', NULL, NULL, 00000023, '      console.log(react);\n      console.log(react);\n      console.log(react);\n      console.log(react);\n      console.log(react);\n', 0, 1, 0, 0, NULL, '2021-01-20 15:10:53', 1);
INSERT INTO `review_comment` VALUES (00000038, 'Vớ vẩn', NULL, NULL, 00000024, '      console.log(react);\n      console.log(react);\n      console.log(react);\n      console.log(react);\n      console.log(react);\n', 0, 0, 0, 1, NULL, '2021-01-20 15:13:29', 1);
INSERT INTO `review_comment` VALUES (00000039, 'Đăng', NULL, NULL, 00000003, 'Chém gió vừa thôi, sai sai sai', 1, 0, 0, 0, NULL, '2021-01-20 15:14:30', 1);

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
