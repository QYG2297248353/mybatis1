/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100419
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 100419
 File Encoding         : 65001

 Date: 12/07/2021 10:55:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category_
-- ----------------------------
DROP TABLE IF EXISTS `category_`;
CREATE TABLE `category_`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category_
-- ----------------------------
INSERT INTO `category_` VALUES (1, 'category1');
INSERT INTO `category_` VALUES (2, 'category2');

-- ----------------------------
-- Table structure for order_
-- ----------------------------
DROP TABLE IF EXISTS `order_`;
CREATE TABLE `order_`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_
-- ----------------------------
INSERT INTO `order_` VALUES (1, 'code000A');
INSERT INTO `order_` VALUES (2, 'code000B');

-- ----------------------------
-- Table structure for order_item_
-- ----------------------------
DROP TABLE IF EXISTS `order_item_`;
CREATE TABLE `order_item_`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `oid` int NULL DEFAULT NULL,
  `pid` int NULL DEFAULT NULL,
  `number` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item_
-- ----------------------------
INSERT INTO `order_item_` VALUES (1, 1, 1, 100);
INSERT INTO `order_item_` VALUES (2, 1, 2, 100);
INSERT INTO `order_item_` VALUES (3, 1, 3, 100);
INSERT INTO `order_item_` VALUES (4, 2, 2, 100);
INSERT INTO `order_item_` VALUES (5, 2, 3, 100);
INSERT INTO `order_item_` VALUES (6, 2, 4, 100);

-- ----------------------------
-- Table structure for product_
-- ----------------------------
DROP TABLE IF EXISTS `product_`;
CREATE TABLE `product_`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` float NULL DEFAULT 0,
  `cid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_
-- ----------------------------
INSERT INTO `product_` VALUES (1, 'product a', 88.88, 1);
INSERT INTO `product_` VALUES (2, 'product b', 88.88, 1);
INSERT INTO `product_` VALUES (3, 'product c', 88.88, 1);
INSERT INTO `product_` VALUES (4, 'product x', 88.88, 2);
INSERT INTO `product_` VALUES (5, 'product y', 88.88, 2);
INSERT INTO `product_` VALUES (6, 'product z', 88.88, 2);

SET FOREIGN_KEY_CHECKS = 1;
