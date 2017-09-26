/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50505
 Source Host           : localhost
 Source Database       : eb_webebook

 Target Server Type    : MySQL
 Target Server Version : 50505
 File Encoding         : utf-8

 Date: 04/01/2017 16:17:48 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `eb_category`
-- ----------------------------
DROP TABLE IF EXISTS `eb_category`;
CREATE TABLE `eb_category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(250) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `del_flg` bit(1) NOT NULL,
  `createDate` datetime NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `eb_category`
-- ----------------------------
BEGIN;
INSERT INTO `eb_category` VALUES ('1', 'Tiểu thuyết', null, b'0', '2016-08-27 19:12:13', null, null), ('2', 'Lãng mạn', 'asd', b'0', '2016-08-27 19:12:15', null, null), ('3', 'Trinh thám', 'Trinh thám', b'0', '2016-08-27 23:14:15', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `eb_chaptercomment`
-- ----------------------------
DROP TABLE IF EXISTS `eb_chaptercomment`;
CREATE TABLE `eb_chaptercomment` (
  `chapterCommentId` int(11) NOT NULL AUTO_INCREMENT,
  `chapterId` int(11) NOT NULL,
  `commentId` int(11) NOT NULL,
  `del_flg` bit(1) NOT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`chapterCommentId`),
  KEY `chapterId` (`chapterId`),
  KEY `commentId` (`commentId`),
  CONSTRAINT `chapterComment_chapterId` FOREIGN KEY (`chapterId`) REFERENCES `eb_chapters` (`chapterId`),
  CONSTRAINT `chapterComment_commentId` FOREIGN KEY (`commentId`) REFERENCES `eb_comments` (`commentId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `eb_chaptercomment`
-- ----------------------------
BEGIN;
INSERT INTO `eb_chaptercomment` VALUES ('1', '1', '9', b'0', '0000-00-00 00:00:00'), ('2', '1', '7', b'0', '0000-00-00 00:00:00'), ('5', '1', '29', b'0', '0000-00-00 00:00:00'), ('6', '1', '30', b'0', '0000-00-00 00:00:00'), ('7', '1', '31', b'0', '0000-00-00 00:00:00'), ('8', '3', '33', b'0', '0000-00-00 00:00:00'), ('9', '1', '38', b'0', '0000-00-00 00:00:00'), ('10', '1', '41', b'0', '0000-00-00 00:00:00'), ('11', '1', '45', b'0', '2016-08-21 00:00:00'), ('12', '6', '52', b'0', '2016-08-28 00:00:00'), ('13', '1', '53', b'0', '2016-10-23 00:00:00'), ('14', '1', '54', b'0', '2016-10-23 00:00:00');
COMMIT;

-- ----------------------------
--  Table structure for `eb_chapters`
-- ----------------------------
DROP TABLE IF EXISTS `eb_chapters`;
CREATE TABLE `eb_chapters` (
  `chapterId` int(11) NOT NULL AUTO_INCREMENT,
  `chapterName` varchar(150) NOT NULL,
  `contents` longtext NOT NULL,
  `image` varchar(400) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `del_flg` bit(1) NOT NULL,
  `createDate` datetime NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`chapterId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `eb_chapters`
-- ----------------------------
BEGIN;
INSERT INTO `eb_chapters` VALUES ('1', 'chapter1', 'Tieen <b>truong minh<br><u>text</u><br><br></b>', null, 'djqwgdhasd', b'0', '2016-08-15 23:10:01', '2016-08-21 00:00:00', null), ('2', 'chapter2', 'ajkda asld', null, '123ajkds', b'0', '2016-08-15 23:10:19', null, null), ('3', 'chapter 3', 'kdlas', null, 'aksdl', b'0', '2016-08-15 23:10:29', null, null), ('4', 'tetchapter', 'tetchapter', null, 'tetchapter', b'0', '2016-08-21 00:00:00', null, null), ('5', 'chuogn 1011', 'afheqwe', null, 'aoidasdad', b'0', '2016-08-21 00:00:00', '2016-08-21 00:00:00', null), ('6', 'd1', 'dasdqwqdw', null, 'dasdasda', b'0', '2016-08-28 00:00:00', null, null), ('7', 'qwd', 'qdw', null, 'qwd', b'0', '2016-10-24 00:00:00', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `eb_coins`
-- ----------------------------
DROP TABLE IF EXISTS `eb_coins`;
CREATE TABLE `eb_coins` (
  `coinId` int(11) NOT NULL AUTO_INCREMENT,
  `coinAmount` double NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL,
  `dateCreate` datetime NOT NULL,
  `dateUpdate` datetime DEFAULT NULL,
  `dateDetele` datetime DEFAULT NULL,
  PRIMARY KEY (`coinId`),
  KEY `userId` (`userId`),
  CONSTRAINT `coin_userId` FOREIGN KEY (`userId`) REFERENCES `eb_users` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `eb_comments`
-- ----------------------------
DROP TABLE IF EXISTS `eb_comments`;
CREATE TABLE `eb_comments` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `comment` longtext NOT NULL,
  `typeComment` bit(1) NOT NULL COMMENT 'comment for ebook/chapter',
  `voteComment` bit(1) NOT NULL COMMENT 'thanks/not thanks',
  `del_flg` bit(1) NOT NULL,
  `createDate` datetime NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`commentId`),
  KEY `userId` (`userId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `eb_users` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `eb_comments`
-- ----------------------------
BEGIN;
INSERT INTO `eb_comments` VALUES ('1', '2', 'est', b'0', b'0', b'0', '2016-08-15 22:17:54', null, null), ('2', '1', 'www', b'0', b'0', b'0', '2016-08-15 22:18:08', null, null), ('6', '2', 'qqqq', b'0', b'0', b'0', '2016-08-16 00:00:00', null, null), ('7', '2', 'qqqq', b'1', b'0', b'0', '2016-08-16 00:00:00', '2016-08-21 00:00:00', null), ('8', '2', 'qqqqdd123', b'0', b'0', b'0', '2016-08-16 00:00:00', null, null), ('9', '2', 'eeqwe', b'1', b'1', b'0', '2016-08-16 00:00:00', '2016-08-21 00:00:00', null), ('10', '2', 'dd123asd', b'0', b'0', b'0', '2016-08-16 00:00:00', null, null), ('11', '2', 'dddd', b'0', b'0', b'0', '2016-08-16 00:00:00', null, null), ('12', '2', '213ds', b'0', b'0', b'0', '2016-08-16 00:00:00', null, null), ('13', '2', '1111111', b'0', b'0', b'0', '2016-08-16 00:00:00', null, null), ('14', '2', '1111d222', b'0', b'0', b'0', '2016-08-16 00:00:00', null, null), ('15', '2', '23', b'0', b'0', b'0', '2016-08-16 00:00:00', null, null), ('16', '2', 'e', b'0', b'0', b'0', '2016-08-16 00:00:00', null, null), ('17', '2', '2', b'0', b'0', b'0', '2016-08-16 00:00:00', null, null), ('18', '2', '22', b'0', b'0', b'0', '2016-08-16 00:00:00', null, null), ('19', '2', 'qce qwe', b'0', b'0', b'0', '2016-08-16 00:00:00', null, null), ('20', '2', '112@', b'0', b'0', b'0', '2016-08-16 00:00:00', null, null), ('21', '2', '2asc', b'0', b'0', b'0', '2016-08-17 00:00:00', null, null), ('22', '2', 'q12', b'0', b'0', b'0', '2016-08-17 00:00:00', null, null), ('23', '2', 'e', b'0', b'0', b'0', '2016-08-17 00:00:00', null, null), ('24', '2', 'test', b'0', b'0', b'0', '2016-08-17 00:00:00', null, null), ('25', '2', ',,,', b'0', b'0', b'0', '2016-08-17 00:00:00', null, null), ('26', '2', 'testaaaaa', b'0', b'0', b'0', '2016-08-17 00:00:00', null, null), ('27', '2', 'testa', b'1', b'0', b'0', '2016-08-17 00:00:00', null, null), ('28', '2', 'testa', b'1', b'0', b'0', '2016-08-17 00:00:00', null, null), ('29', '2', 'asdasd', b'1', b'0', b'0', '2016-08-17 00:00:00', null, null), ('30', '2', '111', b'1', b'0', b'0', '2016-08-17 00:00:00', null, null), ('31', '2', '222', b'1', b'0', b'0', '2016-08-17 00:00:00', null, null), ('32', '2', '123', b'0', b'0', b'0', '2016-08-17 00:00:00', null, null), ('33', '2', 'chuong 1', b'1', b'0', b'0', '2016-08-17 00:00:00', null, null), ('34', '2', 'test', b'0', b'0', b'0', '2016-08-20 00:00:00', null, null), ('35', '2', 'test', b'0', b'0', b'0', '2016-08-20 00:00:00', null, null), ('36', '2', 'test', b'0', b'0', b'0', '2016-08-20 00:00:00', null, null), ('37', '2', 'test', b'0', b'0', b'0', '2016-08-20 00:00:00', null, null), ('38', '2', 'ewe123123123', b'1', b'0', b'0', '2016-08-20 00:00:00', null, null), ('39', '2', 'ti?n ', b'0', b'0', b'0', '2016-08-21 00:00:00', '2016-08-21 00:00:00', null), ('40', '2', 'hala tiến ', b'0', b'1', b'0', '2016-08-21 00:00:00', '2016-08-21 00:00:00', null), ('41', '2', 'test tiến ', b'1', b'0', b'0', '2016-08-21 00:00:00', null, null), ('42', '2', 'qqqq', b'0', b'0', b'0', '2016-08-21 00:00:00', '2016-08-21 00:00:00', null), ('43', '2', 'haalaaaa', b'0', b'0', b'0', '2016-08-21 00:00:00', null, null), ('44', '2', 'rrr', b'0', b'0', b'0', '2016-08-21 00:00:00', null, null), ('45', '2', 'ttttt', b'1', b'0', b'0', '2016-08-21 00:00:00', null, null), ('46', '2', 'asdasd', b'0', b'0', b'0', '2016-08-25 00:00:00', null, null), ('47', '2', 'e1e1e', b'0', b'0', b'0', '2016-08-25 00:00:00', null, null), ('48', '2', 'aaa', b'0', b'0', b'0', '2016-08-26 00:00:00', '2016-08-27 00:00:00', null), ('49', '2', 'asdasdasd', b'0', b'0', b'0', '2016-08-26 00:00:00', null, null), ('50', '2', '1111', b'0', b'0', b'0', '2016-08-26 00:00:00', null, null), ('51', '1', 'qweqwe', b'0', b'0', b'0', '2016-08-28 00:00:00', null, null), ('52', '1', 'qweqwe', b'1', b'0', b'0', '2016-08-28 00:00:00', null, null), ('53', '1', '1e2', b'1', b'0', b'0', '2016-10-23 00:00:00', null, null), ('54', '2', 'qwe', b'1', b'0', b'0', '2016-10-23 00:00:00', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `eb_historychargecoins`
-- ----------------------------
DROP TABLE IF EXISTS `eb_historychargecoins`;
CREATE TABLE `eb_historychargecoins` (
  `historyId` int(11) NOT NULL AUTO_INCREMENT,
  `dateCharge` datetime NOT NULL,
  `amoutCharge` double NOT NULL,
  `coinId` int(11) NOT NULL,
  `typeCharge` varchar(50) NOT NULL,
  `dateCreate` datetime NOT NULL,
  PRIMARY KEY (`historyId`),
  KEY `coinId` (`coinId`),
  CONSTRAINT `history_coinId` FOREIGN KEY (`coinId`) REFERENCES `eb_coins` (`coinId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `eb_links`
-- ----------------------------
DROP TABLE IF EXISTS `eb_links`;
CREATE TABLE `eb_links` (
  `linkId` int(11) NOT NULL AUTO_INCREMENT,
  `postId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `linkDetail` varchar(250) DEFAULT NULL,
  `del_flg` bit(1) NOT NULL,
  `createDate` datetime NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`linkId`),
  KEY `postId` (`postId`),
  KEY `userId` (`userId`),
  CONSTRAINT `link_postID` FOREIGN KEY (`postId`) REFERENCES `eb_posts` (`postId`),
  CONSTRAINT `link_userId` FOREIGN KEY (`userId`) REFERENCES `eb_users` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `eb_orderdetails`
-- ----------------------------
DROP TABLE IF EXISTS `eb_orderdetails`;
CREATE TABLE `eb_orderdetails` (
  `orderDetailId` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) NOT NULL,
  `postId` int(11) NOT NULL,
  `postName` varchar(150) NOT NULL,
  `price` double DEFAULT NULL,
  `del_flg` bit(1) NOT NULL,
  `createDate` datetime NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`orderDetailId`),
  KEY `postId` (`postId`),
  KEY `saleId` (`orderId`),
  CONSTRAINT `detail_postId` FOREIGN KEY (`postId`) REFERENCES `eb_posts` (`postId`),
  CONSTRAINT `detail_saleId` FOREIGN KEY (`orderId`) REFERENCES `eb_orders` (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `eb_orders`
-- ----------------------------
DROP TABLE IF EXISTS `eb_orders`;
CREATE TABLE `eb_orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `amount` double NOT NULL,
  `createDate` datetime NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `userId` (`userId`),
  CONSTRAINT `sale_userId` FOREIGN KEY (`userId`) REFERENCES `eb_users` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `eb_postchapter`
-- ----------------------------
DROP TABLE IF EXISTS `eb_postchapter`;
CREATE TABLE `eb_postchapter` (
  `postChapterId` int(11) NOT NULL AUTO_INCREMENT,
  `postId` int(11) NOT NULL,
  `chapterId` int(11) NOT NULL,
  `del_flg` bit(1) NOT NULL,
  PRIMARY KEY (`postChapterId`),
  KEY `postId` (`postId`),
  KEY `chapterId` (`chapterId`),
  CONSTRAINT `post_Chapter_chapterId` FOREIGN KEY (`chapterId`) REFERENCES `eb_chapters` (`chapterId`),
  CONSTRAINT `post_Chapter_postId` FOREIGN KEY (`postId`) REFERENCES `eb_posts` (`postId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `eb_postchapter`
-- ----------------------------
BEGIN;
INSERT INTO `eb_postchapter` VALUES ('3', '1', '1', b'0'), ('4', '1', '2', b'0'), ('5', '1', '3', b'0'), ('6', '2', '1', b'0'), ('7', '2', '4', b'0'), ('8', '1', '5', b'0'), ('9', '13', '6', b'0'), ('10', '12', '7', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `eb_postcomment`
-- ----------------------------
DROP TABLE IF EXISTS `eb_postcomment`;
CREATE TABLE `eb_postcomment` (
  `postCommentId` int(11) NOT NULL AUTO_INCREMENT,
  `postId` int(11) NOT NULL,
  `commentId` int(11) NOT NULL,
  `del_flg` bit(1) NOT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`postCommentId`),
  KEY `postId` (`postId`),
  KEY `commentId` (`commentId`),
  CONSTRAINT `postComment_postId` FOREIGN KEY (`postId`) REFERENCES `eb_posts` (`postId`),
  CONSTRAINT `postcomment_commentId` FOREIGN KEY (`commentId`) REFERENCES `eb_comments` (`commentId`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `eb_postcomment`
-- ----------------------------
BEGIN;
INSERT INTO `eb_postcomment` VALUES ('23', '9', '37', b'0', '0000-00-00 00:00:00'), ('24', '1', '39', b'0', '0000-00-00 00:00:00'), ('25', '1', '40', b'0', '0000-00-00 00:00:00'), ('26', '1', '42', b'0', '2016-08-21 00:00:00'), ('27', '1', '43', b'0', '2016-08-21 00:00:00'), ('28', '1', '44', b'0', '2016-08-21 00:00:00'), ('29', '2', '46', b'0', '2016-08-25 00:00:00'), ('30', '2', '47', b'0', '2016-08-25 00:00:00'), ('31', '2', '48', b'0', '2016-08-26 00:00:00'), ('32', '2', '49', b'0', '2016-08-26 00:00:00'), ('33', '2', '50', b'0', '2016-08-26 00:00:00'), ('34', '13', '51', b'0', '2016-08-28 00:00:00');
COMMIT;

-- ----------------------------
--  Table structure for `eb_posts`
-- ----------------------------
DROP TABLE IF EXISTS `eb_posts`;
CREATE TABLE `eb_posts` (
  `postId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `postStatus` bit(1) NOT NULL COMMENT 'accpet post / wait to accept',
  `postName` varchar(150) NOT NULL,
  `contents` longtext,
  `description` varchar(250) DEFAULT NULL,
  `countChapter` int(11) DEFAULT NULL,
  `authorName` varchar(150) NOT NULL,
  `image` varchar(250) DEFAULT NULL,
  `saleoff` int(11) DEFAULT NULL COMMENT 'percent sale off',
  `price` double DEFAULT NULL,
  `linkDownload` varchar(255) DEFAULT NULL,
  `postType` bit(1) NOT NULL COMMENT 'file update/store',
  `del_flg` bit(1) NOT NULL,
  `createDate` datetime NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`postId`),
  KEY `userId` (`userId`),
  KEY `linkId` (`linkDownload`),
  KEY `linkId_2` (`linkDownload`),
  KEY `linkId_3` (`linkDownload`),
  KEY `linkId_4` (`linkDownload`),
  KEY `linkId_5` (`linkDownload`),
  KEY `linkId_6` (`linkDownload`),
  KEY `linkId_7` (`linkDownload`),
  KEY `categoryId` (`categoryId`),
  KEY `categoryId_2` (`categoryId`),
  KEY `categoryId_3` (`categoryId`),
  KEY `categoryId_4` (`categoryId`),
  KEY `categoryId_5` (`categoryId`),
  KEY `categoryId_6` (`categoryId`),
  KEY `categoryId_7` (`categoryId`),
  CONSTRAINT `catid` FOREIGN KEY (`categoryId`) REFERENCES `eb_category` (`categoryId`),
  CONSTRAINT `post_userId` FOREIGN KEY (`userId`) REFERENCES `eb_users` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `eb_posts`
-- ----------------------------
BEGIN;
INSERT INTO `eb_posts` VALUES ('1', '2', '1', b'1', 'tiến', '<b>asdasd adqq</b><br>', '<b>Text </b><div>thoi mà có gì đâu<b> </b>tự dung thấy mệt mệt<br><br></div>', '1', 'Tiến Trương ', 'http://novel.phinf.naver.net/20150720_248/novel_1437385761550CM4Jx_JPEG/mw.jpg?type=f100_80_2', '0', '1', 'linkdownload', b'0', b'0', '2016-08-14 22:39:35', '2016-08-27 00:00:00', null), ('2', '2', '2', b'1', 'test', 'sd', 'asd', '2', 'asd', 'http://novel.phinf.naver.net/20150720_248/novel_1437385761550CM4Jx_JPEG/mw.jpg?type=f100_80_2', '0', '2222', 'linkdownload', b'0', b'1', '2016-08-14 23:01:31', '2016-08-22 00:00:00', null), ('7', '1', '2', b'1', 'ti?n', '2e', 'qqq ti?n <br>', '1', 'qqq', 'http://novel.phinf.naver.net/20150720_248/novel_1437385761550CM4Jx_JPEG/mw.jpg?type=f100_80_2', '0', '222', 'linkdownload', b'0', b'1', '2016-08-20 00:00:00', '2016-08-22 00:00:00', '2016-08-20 00:00:00'), ('9', '1', '2', b'1', 'test', 'qwea <br>', 'etsaaaa agh<br>', '1', '12eq', 'http://novel.phinf.naver.net/20150720_248/novel_1437385761550CM4Jx_JPEG/mw.jpg?type=f100_80_2', '0', '123', 'linkdownload', b'1', b'1', '2016-08-20 00:00:00', '2016-08-27 00:00:00', null), ('10', '1', '3', b'1', 'qeqw', 'wq', 'qweqwe', '1', 'qweqe', 'http://novel.phinf.naver.net/20150720_248/novel_1437385761550CM4Jx_JPEG/mw.jpg?type=f100_80_2', '0', '223', 'linkdownload', b'1', b'0', '2016-08-20 00:00:00', null, null), ('11', '1', '4', b'1', 'te', 'ads', 'asdasda', '1', 'ad', 'http://novel.phinf.naver.net/20150720_248/novel_1437385761550CM4Jx_JPEG/mw.jpg?type=f100_80_2', '0', '2312', 'linkdownload', b'1', b'0', '2016-08-27 00:00:00', null, null), ('12', '2', '2', b'1', 'ad1122', 'asd', 'dqw22', '0', 'qwd11', 'http://novel.phinf.naver.net/20150720_248/novel_1437385761550CM4Jx_JPEG/mw.jpg?type=f100_80_2', '0', '1', null, b'1', b'0', '2016-08-27 00:00:00', '2016-10-25 00:00:00', null), ('13', '1', '2', b'1', 'testtest', '12', 'sd', '1', '1qdw', 'http://novel.phinf.naver.net/20150720_248/novel_1437385761550CM4Jx_JPEG/mw.jpg?type=f100_80_2', '0', '112', 'linkdownload', b'1', b'0', '2016-08-28 00:00:00', '2016-08-28 00:00:00', null), ('14', '1', '1', b'0', '4wt4ew', '2134qav qew', 'qwe', '12', '123awe', 'image/Koala.jpg', '0', '223', 'WebContent/ebookFolder/Jellyfish.jpg', b'1', b'1', '2016-09-08 00:00:00', null, null), ('15', '2', '1', b'0', 'qwe', '&nbsp;123e wfe &nbsp;er', 'qwe', '12', '123qwe', 'image/Penguins.jpg', '0', '123', 'ebookFolder/Koala.jpg', b'1', b'1', '2016-09-08 00:00:00', null, null), ('16', '2', '2', b'0', 'ets', '1e2', 'qwe', '1', '1e', 'image/unnamed.jpg', '0', '1', 'ebookFolder/unnamed.jpg', b'1', b'0', '2016-09-11 00:00:00', null, null), ('17', '2', '2', b'0', '111112222', 'qw', 'qew', '1', '12da', 'http://novel.phinf.naver.net/20150720_248/novel_1437385761550CM4Jx_JPEG/mw.jpg?type=f100_80_2', '0', '1', '/opt/apache-tomcat-8.0.37/bin/ebookFolder/unnamed.jpg', b'1', b'0', '2016-09-11 00:00:00', null, null), ('18', '2', '2', b'1', 'tein', '', 'qw', '1', 'q', 'image/10863877_1508557226085547_5536260811315515972_o.jpg', '0', '1', '/opt/apache-tomcat-8.0.37/webapps/ebook/ebookFolder/eb_webEbook.sql', b'1', b'0', '2016-09-11 00:00:00', '2016-09-11 00:00:00', null), ('19', '3', '2', b'0', 'qweqew', '12ec', 'qcwe', '0', '1e21e2', null, '0', '1', null, b'1', b'0', '2016-10-24 00:00:00', null, null), ('20', '1', '2', b'0', 'qweqwe', '12e21e', 'weqwqe', '0', 'qwe12', null, '0', '1', null, b'1', b'0', '2016-10-24 00:00:00', null, null), ('21', '2', '2', b'0', 'e121e2', '1e212e', '12e', '0', 'e1212e', null, '0', '1', null, b'1', b'0', '2016-10-25 00:00:00', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `eb_ranking`
-- ----------------------------
DROP TABLE IF EXISTS `eb_ranking`;
CREATE TABLE `eb_ranking` (
  `rankId` int(11) NOT NULL AUTO_INCREMENT,
  `rank` double NOT NULL,
  `userId` int(11) NOT NULL,
  `postId` int(11) NOT NULL,
  `del_flg` bit(1) NOT NULL,
  `createDate` datetime NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`rankId`),
  KEY `userId` (`userId`),
  KEY `postId` (`postId`),
  CONSTRAINT `rank_postId` FOREIGN KEY (`postId`) REFERENCES `eb_posts` (`postId`),
  CONSTRAINT `rank_userId` FOREIGN KEY (`userId`) REFERENCES `eb_users` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `eb_requestpost`
-- ----------------------------
DROP TABLE IF EXISTS `eb_requestpost`;
CREATE TABLE `eb_requestpost` (
  `reqPostId` int(11) NOT NULL AUTO_INCREMENT,
  `postId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `postStatus` varchar(50) NOT NULL,
  `description` varchar(250) NOT NULL,
  `del_flg` bit(1) NOT NULL,
  `createDate` datetime NOT NULL,
  `upadteDate` datetime DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`reqPostId`),
  KEY `userId` (`userId`),
  KEY `postId` (`postId`),
  CONSTRAINT `post_req_postId` FOREIGN KEY (`postId`) REFERENCES `eb_posts` (`postId`),
  CONSTRAINT `post_req_userId` FOREIGN KEY (`userId`) REFERENCES `eb_users` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `eb_requestroleupdate`
-- ----------------------------
DROP TABLE IF EXISTS `eb_requestroleupdate`;
CREATE TABLE `eb_requestroleupdate` (
  `reqUpdateRoleid` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `roleBefore` varchar(150) NOT NULL,
  `reqStatus` bit(1) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `del_flg` bit(1) NOT NULL,
  `createDate` datetime NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `deleteDate` datetime NOT NULL,
  PRIMARY KEY (`reqUpdateRoleid`),
  KEY `userId` (`userId`),
  CONSTRAINT `req_userId` FOREIGN KEY (`userId`) REFERENCES `eb_users` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `eb_requestroleupdate`
-- ----------------------------
BEGIN;
INSERT INTO `eb_requestroleupdate` VALUES ('1', '2', 'member', b'0', '11', b'0', '2016-08-24 00:06:53', null, '0000-00-00 00:00:00'), ('2', '3', 'member', b'0', '123qwe', b'0', '2016-08-24 23:28:44', '2016-08-25 00:00:00', '0000-00-00 00:00:00');
COMMIT;

-- ----------------------------
--  Table structure for `eb_roles`
-- ----------------------------
DROP TABLE IF EXISTS `eb_roles`;
CREATE TABLE `eb_roles` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `createDate` datetime NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `eb_roles`
-- ----------------------------
BEGIN;
INSERT INTO `eb_roles` VALUES ('1', 'admin', null, '2016-08-14 22:37:31', null, null), ('2', 'saler', 'post or write', '2016-08-14 22:37:55', null, null), ('3', 'member', 'buy comment', '2016-08-14 22:38:20', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `eb_users`
-- ----------------------------
DROP TABLE IF EXISTS `eb_users`;
CREATE TABLE `eb_users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `password` varchar(250) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `midName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) NOT NULL,
  `address` varchar(150) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `roleId` int(11) NOT NULL,
  `del_Flg` bit(1) NOT NULL,
  `del_Code` varchar(11) DEFAULT NULL,
  `createDate` datetime NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `RoleID` FOREIGN KEY (`roleId`) REFERENCES `eb_roles` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `eb_users`
-- ----------------------------
BEGIN;
INSERT INTO `eb_users` VALUES ('1', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'tien', 'minh', 'truong', 'toki', 'minhtien020193@gmail.com', '09123', '1', b'0', null, '2016-08-14 22:38:44', null, null), ('2', 'test', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'test', 'test', 'test', 'test', 'test', '123', '2', b'0', null, '2016-08-15 22:17:35', '2016-08-25 00:00:00', null), ('3', 'tientruong', 't', 'j', 'j', 'j', 'j', 'jj', 'j', '2', b'0', null, '2016-08-22 23:13:39', '2016-08-25 00:00:00', null), ('4', 'tien', '4edd7747c2b180d15863917e98e522cf3f15d89076b3d73ae93e50936ce18fa2', 'asd', 'asd', 'asd', 'ad', 'ad', 'ad', '3', b'0', null, '2016-08-25 00:00:00', null, null), ('7', 'aaaaaa', 'ed02457b5c41d964dbd2f2a609d63fe1bb7528dbe55e1abf5b52c249cd735797', '', '', '', '', 't@gmail.com', '', '3', b'0', '16703', '2017-02-24 00:00:00', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `eb_votes`
-- ----------------------------
DROP TABLE IF EXISTS `eb_votes`;
CREATE TABLE `eb_votes` (
  `voteId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `postId` int(11) DEFAULT NULL,
  `chapterId` int(11) DEFAULT NULL,
  `vote` bit(1) NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`voteId`),
  KEY `vote_userId` (`userId`),
  KEY `vote_postId` (`postId`),
  KEY `chapterId` (`chapterId`),
  CONSTRAINT `vote_chapterId` FOREIGN KEY (`chapterId`) REFERENCES `eb_chapters` (`chapterId`),
  CONSTRAINT `vote_postId` FOREIGN KEY (`postId`) REFERENCES `eb_posts` (`postId`),
  CONSTRAINT `vote_userId` FOREIGN KEY (`userId`) REFERENCES `eb_users` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `eb_votes`
-- ----------------------------
BEGIN;
INSERT INTO `eb_votes` VALUES ('1', '2', '1', null, b'1', '2016-10-23 00:00:00', '2016-10-23 00:00:00'), ('2', '1', '1', null, b'1', '2016-10-23 00:00:00', '2016-10-23 00:00:00'), ('3', '2', '12', null, b'1', '2016-10-23 00:00:00', '2016-10-23 00:00:00'), ('6', '2', null, '1', b'1', '2016-10-23 00:00:00', '2016-10-23 00:00:00'), ('7', '1', null, '1', b'1', '2016-10-23 00:00:00', '2016-10-23 00:00:00'), ('8', '2', null, '3', b'1', '2016-10-23 00:00:00', '2016-10-23 00:00:00');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
