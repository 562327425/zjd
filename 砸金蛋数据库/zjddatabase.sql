/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : zjddatabase

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-30 22:40:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminUser` varchar(20) NOT NULL,
  `adminpassword` varchar(20) NOT NULL,
  PRIMARY KEY (`adminUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('123456', '888888');

-- ----------------------------
-- Table structure for `hdhdlist`
-- ----------------------------
DROP TABLE IF EXISTS `hdhdlist`;
CREATE TABLE `hdhdlist` (
  `did` varchar(50) NOT NULL,
  `addtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `uid` varchar(50) DEFAULT NULL,
  `hdcount` int(50) DEFAULT NULL,
  `hdid` varchar(50) DEFAULT NULL,
  `ucount` int(20) DEFAULT NULL,
  `cjiangcount` int(20) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hdhdlist
-- ----------------------------
INSERT INTO `hdhdlist` VALUES ('HD20170730015245780', '2017-07-30 13:52:46', 'user20170730015239572', '4', '1', '1', '1');
INSERT INTO `hdhdlist` VALUES ('HD20170730015326422', '2017-07-30 13:53:27', 'user20170730015320987', '5', '1', '1', '1');
INSERT INTO `hdhdlist` VALUES ('HD20170730015411832', '2017-07-30 13:54:12', 'user20170730015406435', '6', '1', '1', '1');
INSERT INTO `hdhdlist` VALUES ('HD20170730015518351', '2017-07-30 13:55:19', 'user20170730015513532', '7', '1', '1', '0');
INSERT INTO `hdhdlist` VALUES ('HD20170730015810750', '2017-07-30 13:58:11', 'user20170730015804224', '8', '1', '1', '1');
INSERT INTO `hdhdlist` VALUES ('HD20170730020336022', '2017-07-30 14:03:36', 'user20170730020330518', '9', '1', '1', '0');
INSERT INTO `hdhdlist` VALUES ('HD20170730020442542', '2017-07-30 14:04:42', 'user20170730020436401', '10', '1', '1', '0');
INSERT INTO `hdhdlist` VALUES ('HD20170730112724293', '2017-07-30 13:58:46', 'user20170730112715632', '1', '1', '2', '1');
INSERT INTO `hdhdlist` VALUES ('HD20170730112838767', '2017-07-30 11:28:39', 'user20170730112831856', '2', '1', '1', '1');
INSERT INTO `hdhdlist` VALUES ('HD20170730112937410', '2017-07-30 11:29:38', 'user20170730112932544', '3', '1', '1', '0');

-- ----------------------------
-- Table structure for `hdinfo`
-- ----------------------------
DROP TABLE IF EXISTS `hdinfo`;
CREATE TABLE `hdinfo` (
  `hdid` varchar(30) NOT NULL,
  `hdname` varchar(20) DEFAULT NULL,
  `starttime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `endtime` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `yidengjiang` varchar(20) DEFAULT NULL,
  `yicount` int(11) DEFAULT NULL,
  `yizhongjiang` varchar(20) DEFAULT NULL,
  `erdengjiang` varchar(20) DEFAULT NULL,
  `ercount` int(11) DEFAULT NULL,
  `erzhongjiang` varchar(20) DEFAULT NULL,
  `sandengjiang` varchar(20) DEFAULT NULL,
  `sancount` int(11) DEFAULT NULL,
  `sanzhongjiang` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`hdid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hdinfo
-- ----------------------------
INSERT INTO `hdinfo` VALUES ('1', '砸金蛋', '2017-07-30 10:03:51', '2017-08-30 10:03:54', '一等奖', '2', '1/5', '二等奖', '5', '2/4/6/8/10', '三等奖', '20', '10/20');
INSERT INTO `hdinfo` VALUES ('2', '转盘', '2017-07-30 16:39:26', '2017-08-30 16:39:28', '冰箱', '3', '2/5/10', '洗衣机', '5', '1/4/9/12/13', '餐巾纸', '20', '10/20');

-- ----------------------------
-- Table structure for `hdusertable`
-- ----------------------------
DROP TABLE IF EXISTS `hdusertable`;
CREATE TABLE `hdusertable` (
  `id` varchar(60) NOT NULL,
  `usertel` varchar(20) DEFAULT NULL,
  `useraddtime` datetime DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `devname` varchar(30) DEFAULT NULL,
  `hdid` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hdusertable
-- ----------------------------
INSERT INTO `hdusertable` VALUES ('user20170730015239572', '15922532870', '2017-07-30 13:52:39', null, null, '1');
INSERT INTO `hdusertable` VALUES ('user20170730015320987', '18983387050', '2017-07-30 13:53:20', null, null, '1');
INSERT INTO `hdusertable` VALUES ('user20170730015406435', '13903187888', '2017-07-30 13:54:06', null, null, '1');
INSERT INTO `hdusertable` VALUES ('user20170730015513532', '15670823354', '2017-07-30 13:55:13', null, null, '1');
INSERT INTO `hdusertable` VALUES ('user20170730015804224', '15922532822', '2017-07-30 13:58:05', null, null, '1');
INSERT INTO `hdusertable` VALUES ('user20170730020330518', '15678922570', '2017-07-30 14:03:30', null, null, '1');
INSERT INTO `hdusertable` VALUES ('user20170730020436401', '15833560124', '2017-07-30 14:04:37', null, null, '1');

-- ----------------------------
-- Table structure for `hduserzilist`
-- ----------------------------
DROP TABLE IF EXISTS `hduserzilist`;
CREATE TABLE `hduserzilist` (
  `id` varchar(50) NOT NULL,
  `uid` varchar(50) DEFAULT NULL,
  `usetel` varchar(30) DEFAULT NULL,
  `hjitime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `usname` varchar(50) DEFAULT NULL,
  `usaddr` varchar(50) DEFAULT NULL,
  `jiangx` int(50) DEFAULT NULL,
  `lingjiang` int(50) DEFAULT NULL,
  `ljiangtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `remark` varchar(30) DEFAULT NULL,
  `hdid` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hduserzilist
-- ----------------------------
INSERT INTO `hduserzilist` VALUES ('YZ20170730015248969', 'user20170730015239572', '15922532870', '2017-07-30 13:52:46', '王五', '北碚', '2', '1', '2017-07-30 13:53:10', null, '1');
INSERT INTO `hduserzilist` VALUES ('YZ20170730015328574', 'user20170730015320987', '18983387050', '2017-07-30 13:53:27', '小龙', '渝中', '1', '1', '2017-07-30 13:53:56', null, '1');
INSERT INTO `hduserzilist` VALUES ('YZ20170730015414384', 'user20170730015406435', '13903187888', '2017-07-30 13:54:12', '小智', '北京', '2', '1', '2017-07-30 13:54:38', null, '1');
INSERT INTO `hduserzilist` VALUES ('YZ20170730015813680', 'user20170730015804224', '15922532822', '2017-07-30 13:58:11', '小李', '天津', '2', '1', '2017-07-30 13:58:32', null, '1');
INSERT INTO `hduserzilist` VALUES ('YZ20170730112726829', 'user20170730112715632', '13983187888', '2017-07-30 11:27:24', '张三', '沙坪坝', '1', '1', '2017-07-30 11:27:49', null, '1');

-- ----------------------------
-- Table structure for `hdwenti`
-- ----------------------------
DROP TABLE IF EXISTS `hdwenti`;
CREATE TABLE `hdwenti` (
  `tid` varchar(50) NOT NULL,
  `title` varchar(120) DEFAULT NULL,
  `txuanxiang` varchar(250) DEFAULT NULL,
  `ddaan` varchar(200) DEFAULT NULL,
  `addtime` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `hdid` varchar(100) DEFAULT NULL,
  `adduser` varchar(30) DEFAULT NULL,
  `remark` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hdwenti
-- ----------------------------
INSERT INTO `hdwenti` VALUES ('1', '1. “中秋”一词最早出现在哪个古书中？', '[{\"tflag\":\"A\",\"ttitle\":\"《周礼》\"},{\"tflag\":\"B\",\"ttitle\":\"《道德经》\"},{\"tflag\":\"C\",\"ttitle\":\"《诗经》\"}, {\"tflag\":\"D\",\"ttitle\":\"《春秋》\"}]', 'A', '2017-07-13 11:46:03', '1', '', '');
INSERT INTO `hdwenti` VALUES ('2', '2. 中国汉族的四大传统节日不包括?', '[{\"tflag\":\"A\",\"ttitle\":\"元宵节\"},{\"tflag\":\"B\",\"ttitle\":\"清明节\"},{\"tflag\":\"C\",\"ttitle\":\"端午节\"}, {\"tflag\":\"D\",\"ttitle\":\"中秋节\"}] ', 'A', '2017-07-12 11:46:08', '1', null, null);
INSERT INTO `hdwenti` VALUES ('3', '3.下面哪首诗中不包含月亮？', '[{\"tflag\":\"A\",\"ttitle\":\"《水调歌头》\"},{\"tflag\":\"B\",\"ttitle\":\"《一剪梅》\"},{\"tflag\":\"C\",\"ttitle\":\"《黄鹤楼》\"}, {\"tflag\":\"D\",\"ttitle\":\"《望月》\"}] ', 'B', '2017-07-12 11:46:11', '1', null, null);
INSERT INTO `hdwenti` VALUES ('4', '4. 以下哪部作品不是出自列夫托尔斯泰？', '[{\"tflag\":\"A\",\"ttitle\":\"《三个火枪手》\"},{\"tflag\":\"B\",\"ttitle\":\"《复活》\"},{\"tflag\":\"C\",\"ttitle\":\"《战争与和平》\"}, {\"tflag\":\"D\",\"ttitle\":\"《七颗钻石》\"}] ', 'D', '2017-07-12 11:46:15', '1', null, null);
INSERT INTO `hdwenti` VALUES ('5', '5. 以下哪部作品出自矛盾之手？', '[{\"tflag\":\"A\",\"ttitle\":\"《野花》\"},{\"tflag\":\"B\",\"ttitle\":\"《蚀》\"},{\"tflag\":\"C\",\"ttitle\":\"《朝花夕拾》\"}, {\"tflag\":\"D\",\"ttitle\":\"《野火》\"}] ', 'B', '2017-07-12 11:46:19', '1', null, null);
INSERT INTO `hdwenti` VALUES ('6', '1. “中秋”一词最早出现在哪个古书中？', '[{\"tflag\":\"A\",\"ttitle\":\"《周礼》\"},{\"tflag\":\"B\",\"ttitle\":\"《道德经》\"},{\"tflag\":\"C\",\"ttitle\":\"《诗经》\"}, {\"tflag\":\"D\",\"ttitle\":\"《春秋》\"}]', 'A', '2017-06-28 19:13:47', '1', null, null);
INSERT INTO `hdwenti` VALUES ('7', '', '[{\"tflag\":\"A\",\"ttitle\":\"《周礼》\"},{\"tflag\":\"B\",\"ttitle\":\"《道德经》\"},{\"tflag\":\"C\",\"ttitle\":\"《诗经》\"}, {\"tflag\":\"D\",\"ttitle\":\"《春秋》\"}]', '', null, '', null, null);

-- ----------------------------
-- Table structure for `hdyzhongjiang`
-- ----------------------------
DROP TABLE IF EXISTS `hdyzhongjiang`;
CREATE TABLE `hdyzhongjiang` (
  `yid` varchar(50) NOT NULL,
  `hdid` varchar(50) DEFAULT NULL,
  `usid` varchar(50) DEFAULT NULL,
  `num` int(50) DEFAULT NULL,
  `addtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`yid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hdyzhongjiang
-- ----------------------------
INSERT INTO `hdyzhongjiang` VALUES ('YZ20170730015248969', '1', 'user20170730015239572', '2', '2017-07-30 13:52:48');
INSERT INTO `hdyzhongjiang` VALUES ('YZ20170730015328574', '1', 'user20170730015320987', '1', '2017-07-30 13:53:29');
INSERT INTO `hdyzhongjiang` VALUES ('YZ20170730015414384', '1', 'user20170730015406435', '2', '2017-07-30 13:54:14');
INSERT INTO `hdyzhongjiang` VALUES ('YZ20170730015813680', '1', 'user20170730015804224', '2', '2017-07-30 13:58:13');
INSERT INTO `hdyzhongjiang` VALUES ('YZ20170730020338932', '1', 'user20170730020330518', '3', '2017-07-30 14:03:38');
INSERT INTO `hdyzhongjiang` VALUES ('YZ20170730020444726', '1', 'user20170730020436401', '2', '2017-07-30 14:04:44');
INSERT INTO `hdyzhongjiang` VALUES ('YZ20170730020449235', '1', 'user20170730020436401', '3', '2017-07-30 14:04:49');
INSERT INTO `hdyzhongjiang` VALUES ('YZ20170730020458535', '1', 'user20170730020436401', '3', '2017-07-30 14:04:58');
INSERT INTO `hdyzhongjiang` VALUES ('YZ20170730112726829', '1', 'user20170730112715632', '1', '2017-07-30 11:27:26');
INSERT INTO `hdyzhongjiang` VALUES ('YZ20170730112840242', '1', 'user20170730112831856', '2', '2017-07-30 11:28:41');

-- ----------------------------
-- Event structure for `是是是`
-- ----------------------------
DROP EVENT IF EXISTS `是是是`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` EVENT `是是是` ON SCHEDULE EVERY 5 SECOND STARTS '2017-07-20 12:31:52' ENDS '2017-07-21 12:31:52' ON COMPLETION PRESERVE ENABLE DO INSERT INTO www VALUES(2,2)
;;
DELIMITER ;

-- ----------------------------
-- Event structure for `清理预中奖`
-- ----------------------------
DROP EVENT IF EXISTS `清理预中奖`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` EVENT `清理预中奖` ON SCHEDULE EVERY 5 SECOND STARTS '2017-07-20 13:28:09' ENDS '2017-07-21 13:28:09' ON COMPLETION PRESERVE ENABLE DO DELETE FROM hdyzhongjiang WHERE yid IN(
SELECT yid FROM hdyzhongjiang WHERE
yid NOT in(SELECT u.id FROM hduserzilist u)
AND NOW()>ADDDATE(addtime,INTERVAL 2 HOUR)
)
;;
DELIMITER ;
