CREATE DATABASE /*!32312 IF NOT EXISTS*/`jujiayanglao` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jujiayanglao`;

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `aId` VARCHAR(42) NOT NULL,
  `aPassword` VARCHAR(42) NOT NULL,
  `aAuthority` VARCHAR(42) DEFAULT NULL,
  PRIMARY KEY (`aId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `administrator` VALUES ('13211269198','1','超级管理员'),('13767234687','1','普通管理员'),
('13433845643','1','普通管理员'),('13644978923','1','普通管理员'),('13555739476','1','普通管理员'),
('13238629574','1','普通管理员'),('13642346496','1','普通管理员'),('13456456867','1','普通管理员'),
('13433542345','1','普通管理员'),('13623467210','1','普通管理员');

DROP TABLE IF EXISTS `elder`;

CREATE TABLE `elder` (
  `eId` VARCHAR(42) NOT NULL,
  `eName` VARCHAR(42) NOT NULL,
  `ePhoneNum` VARCHAR(42) NOT NULL,
  `ePassword` VARCHAR(42) NOT NULL,
  `eGender` VARCHAR(42) NOT NULL,
  `eCity` VARCHAR(42) NOT NULL,
  `eResidence` VARCHAR(42) NOT NULL,
  `eMarriage` VARCHAR(42) DEFAULT NULL,  
  `eAddress` VARCHAR(42) NOT NULL,
  `eBirth` DATE NOT NULL,
  `eAge` INT(11) NOT NULL,  
  `eFamilyName` VARCHAR(42) NOT NULL,
  `eFamilyPhone` VARCHAR(42) NOT NULL,
  `eFamilyRelation` VARCHAR(42) NOT NULL,
  `eBloodType` VARCHAR(42) DEFAULT NULL,
  `eDisable` VARCHAR(42) DEFAULT NULL,
  `eBalance` INT(11) DEFAULT 0,
  `eIncome` INT(11) DEFAULT NULL,
  `eIdCard` VARCHAR(42) NOT NULL, 	
  PRIMARY KEY (`eId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `elder` VALUES 
('001','陈少华','13228287328','123456','男','江门','江门','已婚','江门市新会区东门路9号2座312','1950-09-25',71,'陈信达','13394362433','父子','AB','轻度失能',1000,2000,'440782195009256726'),
('002','张新生','13528376876','123456','男','江门','江门','未婚','江门市蓬江区白沙大道59号2座312','1955-11-25',66,'张晓峰','13812334213','父子','AB','轻度失能',0,3000,'440782195511257989'),
('003','陈胜利','13297432781','123456','男','澳门','珠海','离婚','珠海市香洲区九洲大道西1011号2座2302','1956-03-25',65,'陈云','13823469877','父女','A','能力完好',0,6000,'440712195603257982'),
('004','李康贝','13144365312','123456','男','珠海','珠海','已婚','珠海市香洲区格力香樟7座1801','1957-07-17',64,'李小德','13812399818','兄弟','B','轻度失能',0,2000,'440989195707177239'),
('005','王晨','13235545975','123456','女','深圳','深圳','已婚','深圳市南山区星海名城9座1005','1958-11-12',63,'王亦如','13234234459','母女','O','中度失能',0,6000,'440782195811123424'),
('006','黄佩玉','13782612434','123456','女','香港','深圳','丧偶','深圳市南山区星海名城3座508','1959-05-01',62,'黄三桂','13567787633','母子','AB','重度失能',200,2000,'440782195905016786'),
('007','李小花','13927648716','123456','女','广州','广州','丧偶','广州市越秀区锦城花园4座808','1960-10-25',61,'李大壮','13457060644','母子','A','能力完好',500,3000,'440782196010250984');

DROP TABLE IF EXISTS `balance_record`;

CREATE TABLE `balance_record` (
  `bId` INT(11) NOT NULL AUTO_INCREMENT,
  `bName` VARCHAR(42) NOT NULL,
  `bPhoneNum` VARCHAR(42) NOT NULL,
  `bReason` VARCHAR(42) NOT NULL,
  `bBeforeBal` INT(11) NOT NULL,
  `bAfterBal` INT(11) NOT NULL,
  `bCardNum` VARCHAR(42) DEFAULT NULL,
  `bCardName` VARCHAR(42) DEFAULT NULL,
  `bTime` DATETIME NOT NULL, 
  `bState` VARCHAR(42) NOT NULL,
  PRIMARY KEY (`bId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `balance_record` VALUES (1,'陈少华','13228287328','充值',0,1000,'','','2021-01-25 07:58:30','已完成'),
(2,'黄佩玉','13782612434','充值',0,100,'','','2021-01-25 18:40:30','已完成'),
(3,'黄佩玉','13782612434','政府福利发放',100,200,'','','2021-01-26 08:50:09','已完成'),
(4,'李小花','13927648716','慈善机构捐助',0,500,'','','2021-01-30 10:58','已完成');

DROP TABLE IF EXISTS `shop`;

CREATE TABLE `shop` (
  `sId` VARCHAR(42) NOT NULL,
  `sName` VARCHAR(42) NOT NULL,
  `sPhoneNum` VARCHAR(42) NOT NULL,
  `sHostName` VARCHAR(42) NOT NULL,
  `sHostCard` VARCHAR(42) NOT NULL,
  `sPassword` VARCHAR(42) NOT NULL,
  `sCity` VARCHAR(42) NOT NULL,
  `sAddress` VARCHAR(42) NOT NULL, 
  `sBalance` INT(11) DEFAULT 0, 
  
  PRIMARY KEY (`sId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `shop` VALUES 
('0000001','蓬江夕阳红餐饮店','13833148091','张鑫','6332839302958475823','123456','江门','江门市蓬江区东华路19号',300),
('0000002','东华开心理发店','13783923476','吴申生','6332839302951235823','123456','江门','江门市蓬江区东华二路49号',500),
('0000003','快乐家政连锁店','13683956481','吴爱妮','6332839302958474322','123456','江门','江门市蓬江区院士路53号',200),
('0000004','足浴修脚连锁店','13564892351','肖部','6332839302958468900','123456','江门','江门市蓬江区迎宾路123号',100),
('0000005','香洲老字号餐饮店','13833156474','张武','6332839302957070785','123456','珠海','珠海市香洲区九洲大道东1202号',100),
('0000006','柠溪理发店','13113924561','陈建国','6332839335458475823','123456','珠海','珠海市香洲区柠溪路77号',200),
('0000007','快乐家政连锁店','13683956482','李元成','6333454342958475823','123456','珠海','珠海市香洲区九洲大道西1042号',100),
('0000008','足浴修脚连锁店','13564892888','伍舜','6332839302956475453','123456','珠海','珠海市香洲区摩尔广场304号',500);

DROP TABLE IF EXISTS `shop_goods`;

CREATE TABLE `shop_goods` (
  `sId` VARCHAR(42) NOT NULL,
  `sgId` VARCHAR(42) NOT NULL,
  `sgContent` VARCHAR(256) NOT NULL,
  `sgPrice` INT(11) NOT NULL,
  PRIMARY KEY (`sgId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `shop_goods` VALUES 
('0000001','12345601','配送早餐上门（6元一次）',6),
('0000001','12345602','配送午餐上门（15元一次）',15),
('0000001','12345603','配送晚餐上门（16元一次）',16),
('0000002','12345604','上门理发（18元一次）',18),
('0000002','12345605','上门染发（40元一次）',40),
('0000003','12345606','上门打扫卫生（50元一次）',50),
('0000003','12345607','上门换洗衣物（20元一次）',20),
('0000003','12345608','上门疏通厨房、卫生间管道（40元一次）',40),
('0000003','12345609','上门做饭（20元一次）',20),
('0000004','12345610','上门修脚（50元一次）',50),
('0000004','12345611','上门泡脚（60元一次）',60),
('0000004','12345612','上门按摩（80元一次）',80),
('0000004','12345613','上门推拿（80元一次）',80),
('0000005','12345614','配送早餐上门（6元一次）',6),
('0000005','12345615','配送午餐上门（15元一次）',15),
('0000005','12345616','配送晚餐上门（16元一次）',16),
('0000006','12345617','上门理发（18元一次）',18),
('0000006','12345618','上门染发（40元一次）',40),
('0000007','12345619','上门打扫卫生（50元一次）',50),
('0000007','12345620','上门换洗衣物（20元一次）',20),
('0000007','12345621','上门疏通厨房、卫生间管道（40元一次）',40),
('0000007','12345622','上门做饭（20元一次）',20),
('0000008','12345623','上门修脚（50元一次）',50),
('0000008','12345624','上门泡脚（60元一次）',60),
('0000008','12345625','上门按摩（80元一次）',80),
('0000008','12345626','上门推拿（80元一次）',80);

DROP TABLE IF EXISTS `workorder`;

CREATE TABLE `workorder` (
  `wId` INT(11) NOT NULL AUTO_INCREMENT,
  `wEName` VARCHAR(42) NOT NULL,
  `wEPhoneNum` VARCHAR(42) NOT NULL,
  `wEAddress` VARCHAR(42) NOT NULL,
  `wSgContent` VARCHAR(42) NOT NULL,
  `wSgPrice` INT(11) NOT NULL,
  `wSName` VARCHAR(42) NOT NULL,
  `wSPhoneNum` VARCHAR(42) NOT NULL,
  `wSCity` VARCHAR(42) NOT NULL,
  `wServiceTime` DATETIME NOT NULL,
  `wAmount` INT(11) NOT NULL,
  `wSpend` INT(11) NOT NULL,
  `wState` VARCHAR(42) NOT NULL,
  PRIMARY KEY (`wId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `hospital`;

CREATE TABLE `hospital` (
  `hId` VARCHAR(42) NOT NULL,
  `hName` VARCHAR(42) NOT NULL,
  `hCity` VARCHAR(42) NOT NULL,
  `hAddress` VARCHAR(42) NOT NULL,
  `hPhoneNum` VARCHAR(42) NOT NULL,
  `hBus` VARCHAR(256) NOT NULL,
  `hContent` VARCHAR(256) NOT NULL,
  `hAdminPhone` VARCHAR(42) NOT NULL, 
  `hAdminPassword` VARCHAR(42) NOT NULL,
  PRIMARY KEY (`hId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `hospital` VALUES ('0001','江门市人民医院','江门','江门市蓬莱路高第里172号','0750-3332893','1、乘坐3路、8路、13路公交车，到人民医院站下车即到。2、乘坐K6路、19路、103路、106路公交车，到蓬莱公园站下车步行约200米即到。','心血管内科、内分泌科、胸外科、烧伤整形科、骨科、神经内科、重症医学科、临床护理、泌尿外科、眼科、耳鼻喉科、急诊科、呼吸内科、普外科、消化内科、神经外科、病理科、检验科','13748939045','123456'),
('0002','五邑中医院','江门','江门市蓬江区华园东路30号','0750-3509898','乘坐7路、20路、32路、43路、52路、113路公交车，在五邑中医院站下车即到','脑病科、心病科、肾病科、血液病科、骨伤科、泌尿外科、妇（产）科、康复科','13748932011','123456'),
('0003','珠海市人民医院','珠海','珠海市香洲区康宁路79号','0756-2222569','1、乘坐8路、9路、12路、13路、14路、20路公交车，在人民医院站站下车即到。2、乘坐2路、3a路、3路、6路、7路、8路、12路、13路、14路、026路、26路、56路、69路、204路、206路、605路、K3路公交车，在湾仔沙站站下车即到。3、乘坐2路、3a路、3路、6路、7路、8路、12路、14路、26路、56路、69路、99路、204路、206路、605路、K3路公交车，在百货公司站站下车即到。','心血管内科 、骨科、呼吸内科、心胸外科、神经外科、妇科','13978223411','123456'),
('0004','深圳市人民医院','深圳','深圳市中心路高第里172号','0750-3312563','1、乘坐3路、8路、13路公交车，到人民医院站下车即到。2、乘坐K6路、19路、103路、106路公交车，到蓬莱公园站下车步行约200米即到。','心血管内科、内分泌科、胸外科、烧伤整形科、骨科、神经内科、重症医学科、临床护理、泌尿外科、眼科、耳鼻喉科、急诊科、呼吸内科、普外科、消化内科、神经外科、病理科、检验科','13748567045','123456'),
('0005','澳门山顶医院','澳门','澳门高士德马路','6545898','乘坐7路、20路、32路、43路、52路、113路公交车，在五邑中医院站下车即到','脑病科、心病科、肾病科、血液病科、骨伤科、泌尿外科、妇（产）科、康复科','13123432011','123456'),
('0006','珠海中西医结合医院','珠海','珠海市香洲区粤华路79号','0756-2246569','1、乘坐8路、9路、12路、13路、14路、20路公交车，在人民医院站站下车即到。2、乘坐2路、3a路、3路、6路、7路、8路、12路、13路、14路、026路、26路、56路、69路、204路、206路、605路、K3路公交车，在湾仔沙站站下车即到。3、乘坐2路、3a路、3路、6路、7路、8路、12路、14路、26路、56路、69路、99路、204路、206路、605路、K3路公交车，在百货公司站站下车即到。','心血管内科 、骨科、呼吸内科、心胸外科、神经外科、妇科','13228223411','123456');
DROP TABLE IF EXISTS `office`;

CREATE TABLE `office` (
  `oId` VARCHAR(42) NOT NULL,
  `oName` VARCHAR(42) NOT NULL,
  `oHId` VARCHAR(42) NOT NULL,
  PRIMARY KEY (`oId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `office` VALUES ('00001','心血管内科','0001'),('00002','内分泌科','0001'),('00003','骨科','0001'),
('00004','急诊科','0001'),('00005','耳鼻喉科','0001'),('00006','病理科','0001'),
('00007','妇产科','0001'),('00008','康复科','0001'),('00009','脑病科','0001'),
('00010','心血管内科','0002'),('00011','内分泌科','0002'),('00012','骨科','0002'),
('00013','急诊科','0002'),('00014','耳鼻喉科','0002'),('00015','病理科','0002'),
('00016','妇产科','0002'),('00017','康复科','0002'),('00018','脑病科','0002'),
('00019','心血管内科','0003'),('00020','内分泌科','0003'),('00021','骨科','0003'),
('00022','急诊科','0003'),('00023','耳鼻喉科','0003'),('00024','病理科','0003'),
('00025','妇产科','0003'),('00026','康复科','0003'),('00027','脑病科','0003');

DROP TABLE IF EXISTS `doctor`;

CREATE TABLE `doctor` (
  `dId` VARCHAR(42) NOT NULL,
  `dName` VARCHAR(42) NOT NULL,
  `dGender` VARCHAR(42) NOT NULL,
  `dPhoneNum` VARCHAR(42) NOT NULL,
  `dContent` VARCHAR(42) NOT NULL,
  `dOId` VARCHAR(42) NOT NULL,
  PRIMARY KEY (`dId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `doctor` VALUES ('000001','陈建明','男','13339898912','10多年工作经验，治疗心血管病专家','00001'),
('000002','李心艾','女','13239818232','江门市人民医院心血管科科长','00001'),
('000003','张胜达','男','13435994412','20多年工作经验，内分泌科专家','00002'),
('000004','谭德安','男','13788554915','江门市人民医院内分泌科科长','00002'),
('000005','李伟安','男','13435895676','江门市人民医院骨科科长','00003'),
('000006','方小希','女','13976006645','10多年工作经验，治疗骨科专家','00003');

DROP TABLE IF EXISTS `remain`;

CREATE TABLE `remain` (
  `remId` VARCHAR(42) NOT NULL,
  `remDPhoneNum` VARCHAR(42) NOT NULL,
  `remDName` VARCHAR(42) NOT NULL,
  `remDate` DATE NOT NULL,
  `remSum` INT(11) NOT NULL,
  `remNum` INT(11) NOT NULL,
  PRIMARY KEY (`remId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `remain` VALUES ('0000001','13339898912','陈建明','2021-04-10',10,9),
('0000002','13339898912','陈建明','2021-04-11',5,4),
('0000003','13339898912','陈建明','2021-04-12',5,4),
('0000004','13339898912','陈建明','2021-04-13',8,7),
('0000005','13239818232','李心艾','2021-04-10',10,9),
('0000006','13239818232','李心艾','2021-04-11',15,14),
('0000007','13239818232','李心艾','2021-04-12',10,9);

DROP TABLE IF EXISTS `register`;

CREATE TABLE `register` (
  `regId` VARCHAR(42) NOT NULL,
  `regDPhoneNum` VARCHAR(42) NOT NULL,
  `regDName` VARCHAR(42) NOT NULL,
  `regDate` DATE NOT NULL,
  `regEName` VARCHAR(42) NOT NULL,
  `regEPhoneNum` VARCHAR(42) NOT NULL,
  PRIMARY KEY (`regId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `register` VALUES ('0000001','13339898912','陈建明','2021-04-10','陈少华','13228287328'),
('0000002','13339898912','陈建明','2021-04-11','陈少华','13228287328'),
('0000003','13339898912','陈建明','2021-04-12','陈少华','13228287328'),
('0000004','13339898912','陈建明','2021-04-13','陈少华','13228287328'),
('0000005','13239818232','李心艾','2021-04-10','陈少华','13228287328'),
('0000006','13239818232','李心艾','2021-04-11','陈少华','13228287328'),
('0000007','13239818232','李心艾','2021-04-12','陈少华','13228287328');

DROP TABLE IF EXISTS `vol_station`;

CREATE TABLE `vol_station` (
  `vsId` VARCHAR(42) NOT NULL,
  `vsName` VARCHAR(42) NOT NULL,
  `vsCity` VARCHAR(42) NOT NULL,
  `vsAdminName` VARCHAR(42) NOT NULL,
  `vsAdminPhone` VARCHAR(42) NOT NULL,
  `vsAdminPass` VARCHAR(42) NOT NULL,
  `vsAddress` VARCHAR(42) NOT NULL,
  PRIMARY KEY (`vsId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `vol_station` VALUES ('001','江门志愿义工服务站','江门','陈小云','13211268184','123456','江门市蓬江区白沙大道5号'),
('002','香洲志愿义工服务站','珠海','李大智','13761276555','123456','珠海市香洲区柠溪大道109号'),
('003','羊城志愿义工服务站','广州','陈琦姗','13565745474','123456','广州市增城区中心路5号'),
('004','澳门红十字志愿社','澳门','陈达云','13888268184','123456','澳门新骑士马路60号'),
('005','中山志愿义工服务站','中山','何飞智','13455865785','123456','中山市小榄镇小榄路99号'),
('006','惠州志愿义工服务站','惠州','乌达哈','13678568574','123456','惠州市区环市大道5号'),
('007','深圳志愿义工服务站','深圳','沈八本','13789768184','123456','深圳市环市大道655号'),
('008','东莞志愿义工服务站','东莞','陈卡萨','13715765785','123456','东莞市环市大道545号'),
('009','肇庆志愿义工服务站','肇庆','董思佳','13655230574','123456','肇庆市环市大道485号');

DROP TABLE IF EXISTS `volunteer`;

CREATE TABLE `volunteer` (
  `vId` VARCHAR(42) NOT NULL,
  `vName` VARCHAR(42) NOT NULL,
  `vGender` VARCHAR(42) NOT NULL,
  `vPhone` VARCHAR(42) NOT NULL,
  `vPassword` VARCHAR(42) NOT NULL,
  `vJob` VARCHAR(42) NOT NULL,
  `vHour` INT(11) DEFAULT 0,
  `vVsId` VARCHAR(42) NOT NULL,
  `vVsName` VARCHAR(42) NOT NULL,
  PRIMARY KEY (`vId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `volunteer` VALUES ('0001','李琪琪','女','13982892811','123456','学生',56,'001','江门志愿义工服务站'),
('0002','何晓莉','女','13547474654','123456','教师',124,'001','江门志愿义工服务站'),
('0003','李世杰','男','13837483922','123456','公务员',25,'001','江门志愿义工服务站'),
('0004','黄小芳','女','13273646731','123456','自由职业',10,'001','江门志愿义工服务站'),
('0005','赵思琪','女','13726582532','123456','学生',50,'001','江门志愿义工服务站'),
('0006','李海晨','男','13324327696','123456','学生',99,'001','江门志愿义工服务站');

DROP TABLE IF EXISTS `vol_activity`;

CREATE TABLE `vol_activity` (
  `vaId` VARCHAR(42) NOT NULL,
  `vaName` VARCHAR(42) NOT NULL,
  `vaVsId` VARCHAR(42) NOT NULL,
  `vaVsName` VARCHAR(42) NOT NULL,
  `vaEName` VARCHAR(42) NOT NULL,
  `vaEPhoneNum` VARCHAR(42) NOT NULL,
  `vaTime` DATETIME NOT NULL,
  `vaHourNum` INT(11) NOT NULL,
  `vaRemSum` INT(11) NOT NULL,
  `vaRemNum` INT(11) NOT NULL,
  `vaState` VARCHAR(42) NOT NULL,
  PRIMARY KEY (`vaId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `vol_activity` VALUES ('00001','上门陪老人聊天','001','江门志愿义工服务站','陈少华','13228287328','2021-04-20 09:00',1,3,2,'已结束'),
('00002','上门帮忙打扫卫生','001','江门志愿义工服务站','陈少华','13228287328','2021-04-26 14:00',2,2,1,'未结束'),
('00003','上门陪老人聊天','001','江门志愿义工服务站','张新生','13528376876','2021-04-25 09:00',1,1,0,'未结束');

DROP TABLE IF EXISTS `vol_book`;

CREATE TABLE `vol_book` (
  `vbId` VARCHAR(42) NOT NULL,
  `vbVName` VARCHAR(42) NOT NULL,
  `vbVPhoneNum` VARCHAR(42) NOT NULL,
  `vbVaId` VARCHAR(42) NOT NULL,
  `vbVaName` VARCHAR(42) NOT NULL,
  `vbVaTime` DATETIME NOT NULL,
  `vbVaHourNum` VARCHAR(42) NOT NULL,
  `vbEName` VARCHAR(42) NOT NULL,
  `vbEPhoneNum` VARCHAR(42) NOT NULL,
  `vbState` VARCHAR(42) NOT NULL,
  PRIMARY KEY (`vbId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `vol_book` VALUES ('000001','李琪琪','13982892811','00001','上门陪老人聊天','2021-04-25 09:00',1,'陈少华','13228287328','已完成'),
('000002','李琪琪','13982892811','00002','上门帮忙打扫卫生','2021-04-26 14:00',2,'陈少华','13228287328','已报名'),
('000003','何晓莉','13547474654','00003','上门陪老人聊天','2021-04-27 15:00',1,'张新生','13528376876','已报名');