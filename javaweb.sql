/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : localhost:3306
 Source Schema         : javaweb

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 11/04/2022 15:33:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alsoinfo
-- ----------------------------
DROP TABLE IF EXISTS `alsoinfo`;
CREATE TABLE `alsoinfo`  (
  `aid` int(0) NOT NULL AUTO_INCREMENT,
  `wid` int(0) NULL DEFAULT NULL,
  `eid` int(0) NULL DEFAULT NULL,
  `aremark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`aid`) USING BTREE,
  INDEX `wid`(`wid`) USING BTREE,
  INDEX `eid`(`eid`) USING BTREE,
  CONSTRAINT `alsoinfo_ibfk_1` FOREIGN KEY (`wid`) REFERENCES `borrowinfo` (`wid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `alsoinfo_ibfk_2` FOREIGN KEY (`eid`) REFERENCES `empinfo` (`eid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of alsoinfo
-- ----------------------------
INSERT INTO `alsoinfo` VALUES (4, 3, 4, '2022-10-10');

-- ----------------------------
-- Table structure for bookinfo
-- ----------------------------
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE `bookinfo`  (
  `bid` int(0) NOT NULL AUTO_INCREMENT,
  `Sid` int(0) NULL DEFAULT NULL,
  `bname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bprice` float NULL DEFAULT NULL,
  `bisbn` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bpublish` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bauth` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bcount` int(0) NULL DEFAULT NULL,
  `Sremark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bout` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`bid`) USING BTREE,
  INDEX `Sid`(`Sid`) USING BTREE,
  CONSTRAINT `bookinfo_ibfk_1` FOREIGN KEY (`Sid`) REFERENCES `booksortinfo` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bookinfo
-- ----------------------------
INSERT INTO `bookinfo` VALUES (1, 1, 'java基础', 99.5, ' 1231-4545-23', '清华大学出版社', '刘小强', 50, '学习Java必备', 0);
INSERT INTO `bookinfo` VALUES (2, 1, 'SQL Server ', 25.5, '4654-121-12', '武汉大学出版社', '赵大明', 50, '数据库类书籍', 0);

-- ----------------------------
-- Table structure for booksortinfo
-- ----------------------------
DROP TABLE IF EXISTS `booksortinfo`;
CREATE TABLE `booksortinfo`  (
  `sid` int(0) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sremark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of booksortinfo
-- ----------------------------
INSERT INTO `booksortinfo` VALUES (1, '计算机类', '很多的计算机');
INSERT INTO `booksortinfo` VALUES (2, '机械类 ', '有很多的机械');
INSERT INTO `booksortinfo` VALUES (3, '经济类', '很是经济');

-- ----------------------------
-- Table structure for borrowinfo
-- ----------------------------
DROP TABLE IF EXISTS `borrowinfo`;
CREATE TABLE `borrowinfo`  (
  `wid` int(0) NOT NULL AUTO_INCREMENT,
  `sid` int(0) NULL DEFAULT NULL,
  `bid` int(0) NULL DEFAULT NULL,
  `eid` int(0) NULL DEFAULT NULL,
  `bdate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`wid`) USING BTREE,
  INDEX `sid`(`sid`) USING BTREE,
  INDEX `bid`(`bid`) USING BTREE,
  INDEX `eid`(`eid`) USING BTREE,
  CONSTRAINT `borrowinfo_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `stuinfo` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `borrowinfo_ibfk_2` FOREIGN KEY (`bid`) REFERENCES `bookinfo` (`bid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `borrowinfo_ibfk_3` FOREIGN KEY (`eid`) REFERENCES `empinfo` (`eid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrowinfo
-- ----------------------------
INSERT INTO `borrowinfo` VALUES (3, 1, 1, 4, '2021-12-10');
INSERT INTO `borrowinfo` VALUES (4, 2, 2, 4, '2021-12-12');

-- ----------------------------
-- Table structure for collegeinfo
-- ----------------------------
DROP TABLE IF EXISTS `collegeinfo`;
CREATE TABLE `collegeinfo`  (
  `eid` int(0) NOT NULL AUTO_INCREMENT,
  `ename` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `eremark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`eid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collegeinfo
-- ----------------------------
INSERT INTO `collegeinfo` VALUES (1, '计算机学院', '有电脑');
INSERT INTO `collegeinfo` VALUES (2, '外国语学院', '会说英语');
INSERT INTO `collegeinfo` VALUES (3, '机械学院', '天天撸铁');

-- ----------------------------
-- Table structure for deptinfo
-- ----------------------------
DROP TABLE IF EXISTS `deptinfo`;
CREATE TABLE `deptinfo`  (
  `pid` int(0) NOT NULL AUTO_INCREMENT,
  `eid` int(0) NULL DEFAULT NULL,
  `pname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `premark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE,
  INDEX `eid`(`eid`) USING BTREE,
  CONSTRAINT `deptinfo_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `collegeinfo` (`eid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of deptinfo
-- ----------------------------
INSERT INTO `deptinfo` VALUES (1, 1, '网络工程系', '会接网线');
INSERT INTO `deptinfo` VALUES (2, 1, '软件工程系', '会用软件');
INSERT INTO `deptinfo` VALUES (3, 1, '硬件设备管理系', '会修电脑');
INSERT INTO `deptinfo` VALUES (4, 2, ' 英语系 ', '会说英语');
INSERT INTO `deptinfo` VALUES (5, 1, '日语系 ', '会说八嘎');

-- ----------------------------
-- Table structure for empinfo
-- ----------------------------
DROP TABLE IF EXISTS `empinfo`;
CREATE TABLE `empinfo`  (
  `eid` int(0) NOT NULL AUTO_INCREMENT,
  `ename` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `eSex` int(0) NULL DEFAULT NULL,
  `eage` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`eid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of empinfo
-- ----------------------------
INSERT INTO `empinfo` VALUES (4, '1', 1, 1);

-- ----------------------------
-- Table structure for exposureinfo
-- ----------------------------
DROP TABLE IF EXISTS `exposureinfo`;
CREATE TABLE `exposureinfo`  (
  `oid` int(0) NOT NULL AUTO_INCREMENT,
  `sid` int(0) NULL DEFAULT NULL,
  `eid` int(0) NULL DEFAULT NULL,
  `eremark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE,
  INDEX `sid`(`sid`) USING BTREE,
  INDEX `eid`(`eid`) USING BTREE,
  CONSTRAINT `exposureinfo_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `stuinfo` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `exposureinfo_ibfk_2` FOREIGN KEY (`eid`) REFERENCES `deptinfo` (`eid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exposureinfo
-- ----------------------------
INSERT INTO `exposureinfo` VALUES (1, 1, 1, '损坏书籍');

-- ----------------------------
-- Table structure for gradeinfo
-- ----------------------------
DROP TABLE IF EXISTS `gradeinfo`;
CREATE TABLE `gradeinfo`  (
  `gid` int(0) NOT NULL AUTO_INCREMENT,
  `mname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mremark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`gid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gradeinfo
-- ----------------------------
INSERT INTO `gradeinfo` VALUES (1, '2000级', '第2000的第一届');
INSERT INTO `gradeinfo` VALUES (2, '2001级', '第2001的哪一届');
INSERT INTO `gradeinfo` VALUES (3, '2002级', '2002级');
INSERT INTO `gradeinfo` VALUES (4, '2000级', 'sdfsds');

-- ----------------------------
-- Table structure for majorinfo
-- ----------------------------
DROP TABLE IF EXISTS `majorinfo`;
CREATE TABLE `majorinfo`  (
  `mid` int(0) NOT NULL AUTO_INCREMENT,
  `pid` int(0) NULL DEFAULT NULL,
  `mname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mremark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  CONSTRAINT `majorinfo_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `deptinfo` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of majorinfo
-- ----------------------------
INSERT INTO `majorinfo` VALUES (1, 1, '综合布线', '布置线');
INSERT INTO `majorinfo` VALUES (2, 1, '邮电综合信息', '发邮件很六');
INSERT INTO `majorinfo` VALUES (3, 1, 'web应用开发', '做网页');
INSERT INTO `majorinfo` VALUES (4, 1, '前端开发应用 ', '写界面的');
INSERT INTO `majorinfo` VALUES (5, 4, '商务英语', '商务用语');
INSERT INTO `majorinfo` VALUES (6, 1, '网络工程', '接网线\r\n');

-- ----------------------------
-- Table structure for myclassinfo
-- ----------------------------
DROP TABLE IF EXISTS `myclassinfo`;
CREATE TABLE `myclassinfo`  (
  `cid` int(0) NOT NULL AUTO_INCREMENT,
  `mid` int(0) NULL DEFAULT NULL,
  `gid` int(0) NULL DEFAULT NULL,
  `mname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mremark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  INDEX `gid`(`gid`) USING BTREE,
  CONSTRAINT `myclassinfo_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `majorinfo` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `myclassinfo_ibfk_2` FOREIGN KEY (`gid`) REFERENCES `gradeinfo` (`gid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of myclassinfo
-- ----------------------------
INSERT INTO `myclassinfo` VALUES (1, 1, 1, '综合布线(1)班', '一般的');
INSERT INTO `myclassinfo` VALUES (2, 1, 1, '综合布线(2)班', '不一般的');

-- ----------------------------
-- Table structure for stuinfo
-- ----------------------------
DROP TABLE IF EXISTS `stuinfo`;
CREATE TABLE `stuinfo`  (
  `sid` int(0) NOT NULL AUTO_INCREMENT,
  `mid` int(0) NULL DEFAULT NULL,
  `sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ssex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `saddress` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE,
  INDEX `my_stu`(`mid`) USING BTREE,
  CONSTRAINT `my_stu` FOREIGN KEY (`mid`) REFERENCES `myclassinfo` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stuinfo
-- ----------------------------
INSERT INTO `stuinfo` VALUES (1, 1, '赵小红', '女 ', '赵小红', '4栋305室');
INSERT INTO `stuinfo` VALUES (2, 2, '赵小花', '女', '赵小花', '4栋305室');
INSERT INTO `stuinfo` VALUES (3, 2, 'xxxx', '女 ', 'xxxx', 'dong');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `upsw` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, 'root', 'root');
INSERT INTO `userinfo` VALUES (2, 'admin', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
