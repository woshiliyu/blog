/*
Navicat MySQL Data Transfer

Source Server         : blog
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-01-24 17:41:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(225) DEFAULT NULL COMMENT '文章标题',
  `slug` varchar(225) DEFAULT NULL COMMENT '文章缩略名',
  `content` text COMMENT '文字内容',
  `authorId` int(11) DEFAULT NULL COMMENT '作者',
  `set_top` int(1) DEFAULT '0' COMMENT '是否置顶，1置顶，0不置顶',
  `hits` int(11) DEFAULT NULL COMMENT '文章点击次数',
  `thumbImg` varchar(255) DEFAULT NULL COMMENT '文章缩略图',
  `tags` varchar(255) DEFAULT NULL COMMENT '标签列表',
  `categories_id` int(11) DEFAULT NULL COMMENT '分类列表',
  `article_type` int(1) DEFAULT '0' COMMENT '类型：原创,转载,(由参数article_type决定)',
  `public_type` int(1) DEFAULT '1' COMMENT '是否公开，1公开，0私有',
  `commentsNum` int(11) DEFAULT '0' COMMENT '内容所属评论数',
  `isenable` int(11) DEFAULT NULL COMMENT '有效性',
  `addtime` datetime DEFAULT NULL,
  `modtime` datetime DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', 'spring', null, 'asfasfsf', null, '0', null, 'C:\\Users\\liyu2\\Desktop\\timg.jpg', null, null, '0', '1', '0', null, null, null);
INSERT INTO `article` VALUES ('2', 'springboot整合druid', null, '<p></p><p></p><p></p><p></p><p></p><p></p><p></p><pre><code>var a=1+1+1+2gfgdgdgdg;</code></pre><p><img src=\"/view/timg.jpg\" style=\"max-width:100%;\"><br></p><p><br></p><p>asaa</p><p></p><p><br></p><p></p><p><br></p><p></p><p><br></p><p></p><p><br></p><p></p><p><br></p><p></p><p><br></p>', null, '0', null, null, null, null, '0', '1', '0', null, null, null);
INSERT INTO `article` VALUES ('3', 'asa', null, '<p></p><p><br></p>', null, '0', null, null, null, null, '0', '1', '0', null, null, null);
INSERT INTO `article` VALUES ('4', 'spring', null, '<p>asfasfsf</p><p><br></p>', null, '0', null, null, null, null, '0', '1', '0', null, null, null);
INSERT INTO `article` VALUES ('5', 'spring', null, '<p></p><p></p><p></p><p><b>asfasfsf</b></p><p><br></p><p></p><p><img src=\"/view/{492A0530-16B3-41E2-B26E-EB015DBA4470}.png\" style=\"max-width:100%;\"><br></p><p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"><br></p><p></p><p><br></p>', null, '0', null, null, null, null, '0', '1', '0', null, null, null);
INSERT INTO `article` VALUES ('6', 'springboot整合druid', null, '<p></p><p></p><pre><code>var a=1;</code></pre><p><img src=\"/view/timg.jpg\" style=\"max-width:100%;\"><br></p><p><br></p><p><br></p><p></p><p><br></p>', null, '0', null, null, null, null, '0', '1', '0', null, null, null);
INSERT INTO `article` VALUES ('7', 'adasd', null, '<p></p><p>asd</p>', null, '0', null, null, null, null, '0', '1', '0', null, null, null);
INSERT INTO `article` VALUES ('8', 'springboot整合log4j2', null, '<ol><li><span style=\"line-height: 1.5;\">1. 引入依赖,</span><span style=\"line-height: normal;\">过滤掉自带的spring-boot-starter-logging</span><br></li></ol><pre><code>&lt;dependency&gt;\n            &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;\n            &lt;artifactId&gt;spring-boot-starter&lt;/artifactId&gt;\n            &lt;exclusions&gt;&lt;!-- 去掉默认配置 --&gt;\n                &lt;exclusion&gt;\n                    &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;\n                    &lt;artifactId&gt;spring-boot-starter-logging&lt;/artifactId&gt;\n                &lt;/exclusion&gt;\n            &lt;/exclusions&gt;\n        &lt;/dependency&gt;\n        &lt;!-- 引入log4j2依赖 --&gt;\n        &lt;dependency&gt;\n            &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;\n            &lt;artifactId&gt;spring-boot-starter-log4j2&lt;/artifactId&gt;\n        &lt;/dependency&gt;</code></pre><ol><li>2.添加\n\nlog4j2的配置文件</li><li>xml.png</li><li><pre><code>&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt;\n&lt;Configuration status=\"INFO\"&gt;\n    &lt;Properties&gt;\n\n        &lt;Property name=\"spring.application.name\"&gt;provider&lt;/Property&gt;\n        &lt;Property name=\"app_name\"&gt;blog&lt;/Property&gt;\n        &lt;Property name=\"log_path\"&gt;logs/${spring.application.name}&lt;/Property&gt;\n\n    &lt;/Properties&gt;\n\n\n    &lt;Appenders&gt;\n        &lt;!--&lt;Console name=\"Console\" target=\"SYSTEM_OUT\" follow=\"true\"&gt;--&gt;\n            &lt;!--&lt;PatternLayout&gt;--&gt;\n                &lt;!--&lt;pattern&gt;%d %p [${ctx:spring.application.name},%X{X-B3-TraceId},%X{X-B3-SpanId},%X{X-Span-Export}] %C{1.} [%t] %m%n&lt;/pattern&gt;--&gt;\n            &lt;!--&lt;/PatternLayout&gt;--&gt;\n        &lt;!--&lt;/Console&gt;--&gt;\n        &lt;Console name=\"Console\" target=\"SYSTEM_OUT\"&gt;\n            &lt;PatternLayout pattern=\"%d %-5p (%F:%L) - %m%n\" /&gt;\n        &lt;/Console&gt;\n        &lt;!-- 按日期每天生成log文件 --&gt;\n        &lt;!--&lt;RollingFile name=\"RollingFile\" fileName=\"E:\\${ctx:spring.application.name}.log\"--&gt;\n                     &lt;!--filePattern=\"E:\\${ctx:spring.application.name}-%d{yyyy-MM-dd}.log\"&gt;--&gt;\n            &lt;!--&lt;PatternLayout&gt;--&gt;\n                &lt;!--&lt;pattern&gt;%d %p [${ctx:spring.application.name},%X{X-B3-TraceId},%X{X-B3-SpanId},%X{X-Span-Export}] %C{1.} [%t] %m%n&lt;/pattern&gt;--&gt;\n            &lt;!--&lt;/PatternLayout&gt;--&gt;\n            &lt;!--&lt;Policies&gt;--&gt;\n                &lt;!--&lt;TimeBasedTriggeringPolicy interval=\"1\"/&gt;--&gt;\n            &lt;!--&lt;/Policies&gt;--&gt;\n\n            &lt;!--&lt;!– log文件只打印error级别信息 –&gt;--&gt;\n            &lt;!--&lt;Filters&gt;--&gt;\n                &lt;!--&lt;ThresholdFilter level=\"INFO\" onMatch=\"ACCEPT\" onMismatch=\"DENY\"/&gt;--&gt;\n            &lt;!--&lt;/Filters&gt;--&gt;\n        &lt;!--&lt;/RollingFile&gt;--&gt;\n        &lt;RollingFile name=\"RollingFileInfo\" fileName=\"E:\\${ctx:spring.application.name}/info.log\"\n                     filePattern=\"${ctx:spring.application.name}/$${date:yyyy-MM}/info-%d{yyyy-MM-dd}-%i.log.gz\"&gt;\n            &lt;!--控制台只输出level及以上级别的信息（onMatch），其他的直接拒绝（onMismatch）--&gt;\n            &lt;Filters&gt;\n                &lt;ThresholdFilter level=\"INFO\" /&gt;\n                &lt;ThresholdFilter level=\"WARN\" onMatch=\"DENY\"\n                                 onMismatch=\"NEUTRAL\" /&gt;\n            &lt;/Filters&gt;\n            &lt;PatternLayout pattern=\"[%d][%t][%p][%c:%L] %m%n\" /&gt;\n            &lt;Policies&gt;\n                &lt;!-- 归档每天的文件 --&gt;\n                &lt;TimeBasedTriggeringPolicy interval=\"1\" modulate=\"true\" /&gt;\n                &lt;!-- 限制单个文件大小 --&gt;\n                &lt;SizeBasedTriggeringPolicy size=\"2 MB\" /&gt;\n            &lt;/Policies&gt;\n            &lt;!-- 限制每天文件个数 --&gt;\n            &lt;DefaultRolloverStrategy compressionLevel=\"0\" max=\"10\"/&gt;\n        &lt;/RollingFile&gt;\n\n        &lt;RollingFile name=\"RollingFileWarn\" fileName=\"E:\\${ctx:spring.application.name}/warn.log\"\n                     filePattern=\"${ctx:spring.application.name}/$${date:yyyy-MM}/warn-%d{yyyy-MM-dd}-%i.log.gz\"&gt;\n            &lt;Filters&gt;\n                &lt;ThresholdFilter level=\"WARN\" /&gt;\n                &lt;ThresholdFilter level=\"ERROR\" onMatch=\"DENY\"\n                                 onMismatch=\"NEUTRAL\" /&gt;\n            &lt;/Filters&gt;\n            &lt;PatternLayout pattern=\"[%d][%t][%p][%c:%L] %m%n\" /&gt;\n            &lt;Policies&gt;\n                &lt;!-- 归档每天的文件 --&gt;\n                &lt;TimeBasedTriggeringPolicy interval=\"1\" modulate=\"true\" /&gt;\n                &lt;!-- 限制单个文件大小 --&gt;\n                &lt;SizeBasedTriggeringPolicy size=\"2 MB\" /&gt;\n            &lt;/Policies&gt;\n            &lt;!-- 限制每天文件个数 --&gt;\n            &lt;DefaultRolloverStrategy compressionLevel=\"0\" max=\"10\"/&gt;\n        &lt;/RollingFile&gt;\n\n        &lt;RollingFile name=\"RollingFileError\" fileName=\"E:\\${ctx:spring.application.name}/error.log\"\n                     filePattern=\"${ctx:spring.application.name}/$${date:yyyy-MM}/error-%d{yyyy-MM-dd}-%i.log.gz\"&gt;\n            &lt;ThresholdFilter level=\"ERROR\" /&gt;\n            &lt;PatternLayout pattern=\"[%d][%t][%p][%c:%L] %m%n\" /&gt;\n            &lt;Policies&gt;\n                &lt;!-- 归档每天的文件 --&gt;\n                &lt;TimeBasedTriggeringPolicy interval=\"1\" modulate=\"true\" /&gt;\n                &lt;!-- 限制单个文件大小 --&gt;\n                &lt;SizeBasedTriggeringPolicy size=\"2 MB\" /&gt;\n            &lt;/Policies&gt;\n            &lt;!-- 限制每天文件个数 --&gt;\n            &lt;DefaultRolloverStrategy compressionLevel=\"0\" max=\"10\"/&gt;\n        &lt;/RollingFile&gt;\n    &lt;/Appenders&gt;\n    &lt;Loggers&gt;\n\n        &lt;root level=\"all\"&gt;\n            &lt;appender-ref ref=\"Console\" /&gt;\n            &lt;appender-ref ref=\"RollingFileInfo\" /&gt;\n            &lt;appender-ref ref=\"RollingFileWarn\" /&gt;\n            &lt;appender-ref ref=\"RollingFileError\" /&gt;\n        &lt;/root&gt;\n    &lt;/Loggers&gt;\n&lt;/Configuration&gt;</code></pre><p>各节点具体意思可以查看<a href=\"https://www.cnblogs.com/hafiz/p/6170702.html\" target=\"_blank\" style=\"line-height: normal;\">配置文件详情</a></p></li><li><span style=\"line-height: 21px;\">3.</span>修改application.yml</li><li><pre><code>spring:\nthymeleaf:\n  cache: false\n  prefix: classpath:/templates/\n  suffix: .html\n  encoding: UTF-8\n  content-type: text/html\n  mode: HTML5\n\ndruid:\n jdbc:\n   driveClassName: com.mysql.jdbc.Driver\n   jdbcUrl: jdbc:mysql://localhost:3306/mydb?useUnicode=true&amp;characterEncoding=utf8&amp;useSSL=true\n   jdbcUsername: root\n   jdbcPassword: woshiliyu921102\n   maxActive: 20\n   initialSize: 1\n   maxWait: 60000\n   minIdle: 3\n   timeBetweenEvictionRunsMillis: 60000\n   minEvictableIdleTimeMillis: 300000\n   validationQuery: SELECT \'x\'\n   testWhileIdle: true\n   testOnBrowwon: false\n   testOnReturn: false\n   filters: stat,wall\n\nlogging:\n  config: classpath:log4j2.xml\n  level:\n    root: info\n    ## 控制台打印sql语句\n    com.ly.provider.sys.dao : debug\n\nmybatis:\n   #  mybatis����mapper��xml�ļ�·��\n  mapperLocations: classpath:mapper/*.xml\n  #  ����ӳ����İ���\n  type-aliases-package: com.ly.provider.sys.entity</code></pre><p>4.测试</p></li><li><p>访问：<span style=\"line-height: 1.5;\">http://localhost:8080/sys/article/list?page=1&amp;limit=10</span></p></li><li><p>控制台图片</p></li><li><p>文件夹图片</p></li></ol>', null, '0', null, null, null, null, '0', '1', '0', null, null, null);

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `province_id` int(11) DEFAULT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '1', '温岭市', '1');

-- ----------------------------
-- Table structure for `custom`
-- ----------------------------
DROP TABLE IF EXISTS `custom`;
CREATE TABLE `custom` (
  `custom_id` varchar(255) NOT NULL,
  `custom_name` varchar(255) DEFAULT NULL,
  `custom_tel` varchar(255) DEFAULT NULL,
  `custom_type` tinyint(3) unsigned zerofill DEFAULT '000',
  `custom_address` varchar(255) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `add_user` varchar(255) DEFAULT NULL,
  `mod_time` datetime DEFAULT NULL,
  `mod_user` varchar(255) DEFAULT NULL,
  `delete_flag` tinyint(3) unsigned zerofill DEFAULT '000',
  PRIMARY KEY (`custom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom
-- ----------------------------
INSERT INTO `custom` VALUES ('8510cedc3bd24861bc771fd71724b0c2', '李万贵', '15678941564', '000', '李家嘴', '2017-11-04 16:57:46', null, null, null, '000');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `empid` int(11) DEFAULT NULL,
  `deptid` int(11) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------

-- ----------------------------
-- Table structure for `exception_record`
-- ----------------------------
DROP TABLE IF EXISTS `exception_record`;
CREATE TABLE `exception_record` (
  `id` int(11) NOT NULL,
  `exception` varchar(255) DEFAULT NULL,
  `exception_description` text,
  `type` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `real_reason` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exception_record
-- ----------------------------
INSERT INTO `exception_record` VALUES ('1', 'org.springframework.beans.factory.BeanCreationException', 'Error creating bean with name \'client\' defined in class path resource [org/spring/springcloud/config/MyEsConfig.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.elasticsearch.client.transport.TransportClient]: Factory method \'client\' threw exception; nested exception is java.lang.NoClassDefFoundError: org/apache/logging/log4j/Level', 'BeanCreationException', null, null);
INSERT INTO `exception_record` VALUES ('2', 'java.net.BindException', 'Address already in use: bind', 'BindException', null, '端口被占用/使用');

-- ----------------------------
-- Table structure for `house`
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `house_id` int(11) NOT NULL AUTO_INCREMENT,
  `house_name` varchar(255) DEFAULT NULL,
  `room_num` varchar(255) DEFAULT NULL,
  `bed_num` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT '888888',
  `add_time` datetime DEFAULT NULL,
  `mod_time` datetime DEFAULT NULL,
  `isenable` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`house_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES ('1', '1栋', '101', '1', '888888', '2018-01-29 10:34:05', '2018-02-09 16:43:06', '1');
INSERT INTO `house` VALUES ('2', '1栋', '302', '1', '888888', '2018-01-29 10:34:26', '2018-02-09 14:49:33', '1');
INSERT INTO `house` VALUES ('3', '2栋', '101', '2', '888888', '2018-01-29 10:34:47', '2018-01-29 10:34:59', '1');
INSERT INTO `house` VALUES ('4', '1栋', '101', '2', '888888', '2018-01-29 10:46:53', '2018-01-29 10:46:55', '1');
INSERT INTO `house` VALUES ('5', '1栋', '101', '2', '888888', '2018-01-29 10:51:37', '2018-01-29 10:51:39', '2');
INSERT INTO `house` VALUES ('6', '三栋', '101', '3', '888888', '2018-02-02 10:10:50', '2018-02-02 11:11:49', '1');
INSERT INTO `house` VALUES ('7', '3栋', '101', '1', '888888', '2018-02-02 10:12:46', '2018-02-02 10:51:06', '1');
INSERT INTO `house` VALUES ('8', '3栋', '123', '1', '888888', '2018-02-02 10:14:36', '2018-02-02 10:54:34', '1');
INSERT INTO `house` VALUES ('9', '3栋', '124', '1', '888888', '2018-02-02 10:15:44', '2018-02-02 10:55:08', '1');
INSERT INTO `house` VALUES ('10', '3栋', '101', '1', '888888', '2018-02-02 10:18:07', '2018-02-02 10:18:07', '1');
INSERT INTO `house` VALUES ('11', '3栋', '101', '1', '1', '2018-02-02 10:19:21', '2018-02-02 10:19:21', '1');
INSERT INTO `house` VALUES ('12', '4栋', '101', '1', '123456789', '2018-02-02 10:28:03', '2018-02-02 10:28:03', '1');
INSERT INTO `house` VALUES ('13', '4栋', '111', '2', '123456', '2018-02-02 10:29:04', '2018-02-02 10:29:04', '1');
INSERT INTO `house` VALUES ('14', '2栋', '696', '1', '123456', '2018-02-02 11:11:18', '2018-02-02 11:11:18', '1');

-- ----------------------------
-- Table structure for `order_d`
-- ----------------------------
DROP TABLE IF EXISTS `order_d`;
CREATE TABLE `order_d` (
  `order_d_id` varchar(255) NOT NULL,
  `m_id` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `price_buy` decimal(10,0) DEFAULT NULL,
  `qty_buy` decimal(10,0) DEFAULT NULL,
  `qty_receive` decimal(10,0) DEFAULT NULL,
  `qty_return` decimal(10,0) DEFAULT NULL,
  `receive_date` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `buyer` varchar(255) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `add_user` varchar(255) DEFAULT NULL,
  `mod_time` datetime DEFAULT NULL,
  `mod_user` varchar(255) DEFAULT NULL,
  `delete_flag` tinyint(1) unsigned DEFAULT '0',
  PRIMARY KEY (`order_d_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_d
-- ----------------------------

-- ----------------------------
-- Table structure for `order_m`
-- ----------------------------
DROP TABLE IF EXISTS `order_m`;
CREATE TABLE `order_m` (
  `order_m_id` int(11) NOT NULL,
  `spl_id` varchar(255) DEFAULT NULL,
  `total_amt` varchar(255) DEFAULT NULL,
  `account_way` varchar(255) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `receive_date` date DEFAULT NULL,
  `receive_address` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `delivery_way` varchar(255) DEFAULT NULL,
  `buyer` varchar(255) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `add_user` varchar(255) DEFAULT NULL,
  `mod_time` datetime DEFAULT NULL,
  `mod_user` varchar(255) DEFAULT NULL,
  `delete_flag` tinyint(1) unsigned zerofill DEFAULT '0',
  PRIMARY KEY (`order_m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_m
-- ----------------------------

-- ----------------------------
-- Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned NOT NULL,
  `title` varchar(254) NOT NULL DEFAULT '',
  `content` text,
  `created` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '1', 'MyBatis关联数据查询', '在实际项目中，经常使用关联表的查询，比如：多对一，一对多等。这些查询是如何处理的呢，这一讲就讲这个问题。我们首先创建一个 post 表，并初始化数据.', '2015-09-23 21:40:17');
INSERT INTO `post` VALUES ('2', '1', 'MyBatis开发环境搭建', '为了方便学习，这里直接建立java 工程，但一般都是开发 Web 项目。', '2015-09-23 21:42:14');
INSERT INTO `post` VALUES ('3', '2', '这个是别人发的', 'content,内容...', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for `price`
-- ----------------------------
DROP TABLE IF EXISTS `price`;
CREATE TABLE `price` (
  `price_id` varchar(255) NOT NULL,
  `spl_id` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `price_get` varchar(255) DEFAULT NULL,
  `price_buy` varchar(255) DEFAULT NULL,
  `pric_freight
price_freight` varchar(255) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `add_user` varchar(255) DEFAULT NULL,
  `mod_time` datetime DEFAULT NULL,
  `mod_user` varchar(255) DEFAULT NULL,
  `delete_flag` tinyint(1) unsigned zerofill DEFAULT '0',
  PRIMARY KEY (`price_id`),
  KEY `pk_price_spl_id` (`spl_id`),
  KEY `pk_price_product_id` (`product_id`),
  CONSTRAINT `pk_price_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `pk_price_spl_id` FOREIGN KEY (`spl_id`) REFERENCES `spl` (`spl_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of price
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_picture_real` varchar(255) DEFAULT NULL,
  `product_picture_show` varchar(255) DEFAULT NULL,
  `spl_id` varchar(255) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `add_user` varchar(255) DEFAULT NULL,
  `mod_time` datetime DEFAULT NULL,
  `mod_user` varchar(255) DEFAULT NULL,
  `delete_flag` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('3', '汉堡4', 'http://localhost:8087/images/hb1.png', 'http://localhost:8087/images/hb4.png', '2df67e469d0e47708767c8623f3cdbb2', '2017-10-09 15:04:15', '2017-10-09 15:04:15', null, null, '0');
INSERT INTO `product` VALUES ('5b929f9ce8544458a01edc9f5966bdeb', '汉堡2', 'www.baidu.com', 'http://localhost:8087/images/hb3.png', '2df67e469d0e47708767c8623f3cdbb2', '2017-10-09 15:04:15', '2017-10-09 15:04:15.0', null, null, '0');
INSERT INTO `product` VALUES ('99c322857fc6498d936d489eecd82747', '汉堡3', 'www.baidu.comaaa', 'http://localhost:8087/images/hb2.png', '2df67e469d0e47708767c8623f3cdbb2', '2017-10-09 15:04:15', '2017-10-09 15:04:15.0', null, null, '0');

-- ----------------------------
-- Table structure for `sale`
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `sale_id` varchar(255) NOT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `buyer_name` varchar(255) DEFAULT NULL,
  `buyer_tel` varchar(255) DEFAULT NULL,
  `buyer_address` varchar(255) DEFAULT NULL,
  `total_amt` double DEFAULT NULL,
  `qty_buy` double DEFAULT NULL,
  `amt_pay` double DEFAULT NULL,
  `amt_payed` double DEFAULT NULL,
  `amt_no_pay` double DEFAULT NULL,
  `profit_amt` double DEFAULT NULL,
  `pay_date` date DEFAULT NULL,
  `account_way` tinyint(4) DEFAULT NULL,
  `sale_date` date DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `delivery_way` varchar(255) DEFAULT NULL,
  `pay_flag` varchar(255) DEFAULT NULL COMMENT '付清标志',
  `recommend_user` varchar(255) DEFAULT NULL,
  `recommend_user_tel` varchar(255) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `add_user` varchar(255) DEFAULT NULL,
  `mod_time` datetime DEFAULT NULL,
  `mod_user` varchar(255) DEFAULT NULL,
  `delete_flag` tinyint(1) unsigned zerofill DEFAULT '0',
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sale
-- ----------------------------

-- ----------------------------
-- Table structure for `sale_d`
-- ----------------------------
DROP TABLE IF EXISTS `sale_d`;
CREATE TABLE `sale_d` (
  `saled_id` varchar(255) NOT NULL,
  `salem_id` varchar(255) NOT NULL,
  `product_id` varchar(255) NOT NULL,
  `qty_buy` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `amt_pay` double DEFAULT NULL,
  `amt_payed` double DEFAULT NULL,
  `amt_no_pay` double DEFAULT NULL,
  `sale_date` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `add_user` varchar(255) DEFAULT NULL,
  `mod_time` datetime DEFAULT NULL,
  `mod_user` varchar(255) DEFAULT NULL,
  `delete_flag` tinyint(3) unsigned zerofill DEFAULT '000',
  PRIMARY KEY (`saled_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sale_d
-- ----------------------------
INSERT INTO `sale_d` VALUES ('50ed1c28020a4b5db7d962da445c04df', '21e2e3e62ac5400b9718bcdce4359559', '5b929f9ce8544458a01edc9f5966bdeb', '100', '0.5', '50', '50', '0', '2017-11-17', '李瑜手动添加销售订单明细', '2017-11-04 15:47:50', '李瑜', null, null, '000');

-- ----------------------------
-- Table structure for `sale_m`
-- ----------------------------
DROP TABLE IF EXISTS `sale_m`;
CREATE TABLE `sale_m` (
  `salem_id` varchar(32) NOT NULL,
  `nbr` varchar(255) NOT NULL DEFAULT '' COMMENT '单号',
  `custom_id` varchar(255) NOT NULL COMMENT '客户id',
  `amt_pay` double DEFAULT '0' COMMENT '应付金额',
  `amt_payed` double unsigned zerofill DEFAULT '0000000000000000000000' COMMENT '已付金额',
  `amt_no_pay` double unsigned zerofill DEFAULT '0000000000000000000000',
  `profit_amt` double unsigned zerofill DEFAULT '0000000000000000000000',
  `pay_date` varchar(255) DEFAULT NULL,
  `account_way` varchar(255) DEFAULT NULL,
  `sale_date` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `delivery_way` varchar(255) DEFAULT NULL,
  `pay_flag` tinyint(3) unsigned zerofill DEFAULT '000',
  `recommend_user` varchar(255) DEFAULT NULL,
  `recommend_user_tel` varchar(255) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `add_user` varchar(255) DEFAULT NULL,
  `mod_time` datetime DEFAULT NULL,
  `mod_user` varchar(255) DEFAULT NULL,
  `delete_flag` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`salem_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sale_m
-- ----------------------------
INSERT INTO `sale_m` VALUES ('21e2e3e62ac5400b9718bcdce4359559', '1000001537490396', '1', '10000', '0000000000000000005000', '0000000000000000005000', '0000000000000000003000', '2017-10-07', '微信支付', '2017-10-07', '李瑜手动添加', '送货到家', '000', '刘伟光', '13762691876', '2017-11-04 15:09:36', null, null, null, null);

-- ----------------------------
-- Table structure for `spl`
-- ----------------------------
DROP TABLE IF EXISTS `spl`;
CREATE TABLE `spl` (
  `spl_id` varchar(32) NOT NULL,
  `spl_name` varchar(255) DEFAULT NULL,
  `spl_picture` varchar(255) DEFAULT NULL,
  `spl_location` varchar(255) DEFAULT NULL,
  `spl_user` varchar(255) DEFAULT NULL,
  `spl_tel` varchar(255) DEFAULT NULL,
  `spl_email` varchar(255) DEFAULT NULL,
  `spl_sex` varchar(255) DEFAULT NULL,
  `spl_age` varchar(255) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `add_user` varchar(255) DEFAULT NULL,
  `mod_time` datetime DEFAULT NULL,
  `mod_user` varchar(255) DEFAULT NULL,
  `delete_flag` tinyint(3) unsigned zerofill DEFAULT '000',
  PRIMARY KEY (`spl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of spl
-- ----------------------------
INSERT INTO `spl` VALUES ('2744d4eeb010456cbe7212edbe652ab6', '华为', 'www.baidu.com', '深圳坂田', '李四', '18975661873', '513422479@qq.com', '男', '24', '2017-10-21 00:00:00', '李瑜', null, null, '000');
INSERT INTO `spl` VALUES ('2df67e469d0e47708767c8623f3cdbb2', '中国电信', 'www.baidu.com', '益阳步行街', '张三', '18975661873', '513422479@qq.com', '男', '24', '2017-10-20 00:00:00', '李瑜', null, null, '000');
INSERT INTO `spl` VALUES ('39a17c93672044a6b11b22fc8224aef5', '东软', 'www.baidu.com', '深圳坂田', '孙正义', '18975661873', '513422479@qq.com', '男', '24', '2017-10-19 00:00:00', '李瑜', null, null, '000');
INSERT INTO `spl` VALUES ('3d94cf5cc4f141239ea3448258fcf097', 'huntkey', 'www.baidu.com', '深圳坂田', '罗文华', '18975661873', '513422479@qq.com', '男', '24', '2017-10-18 00:00:00', '李瑜', null, null, '000');
INSERT INTO `spl` VALUES ('473053f209d14a0b90e7d64a73681e19', '微软', 'www.baidu.com', '深圳坂田', '比尔盖茨', '18975661873', '513422479@qq.com', '男', '24', '2017-10-17 00:00:00', '李瑜', null, null, '000');
INSERT INTO `spl` VALUES ('5479bb85cf84441aa3e12bdcbd94116b', '百度', 'www.baidu.com', '深圳坂田', '李彦宏', '18975661873', '513422479@qq.com', '男', '24', '2017-10-16 00:00:00', '李瑜', null, null, '000');
INSERT INTO `spl` VALUES ('67e2bc2072cc441686211515a1bd1934', 'facebook', 'www.baidu.com', '深圳坂田', '扎克伯格', '18975661873', '513422479@qq.com', '男', '24', '2017-10-15 00:00:00', '李瑜', null, null, '000');
INSERT INTO `spl` VALUES ('76fd39da6e2d41e890e97c782b9a962d', '万科', 'www.baidu.com', '深圳坂田', '刘德华', '18975661873', '513422479@qq.com', '男', '24', '2017-10-14 00:00:00', '李瑜', null, null, '000');
INSERT INTO `spl` VALUES ('7f8c3c508186494682a8a607920ae805', '福耀', 'www.baidu.com', '深圳坂田', '曹德旺', '18975661873', '513422479@qq.com', '男', '24', '2017-10-13 00:00:00', '李瑜', null, null, '000');
INSERT INTO `spl` VALUES ('975381b95eaa4f35852e85fcaeadd727', '阿里巴巴', 'www.baidu.com', '深圳坂田', '马云', '18975661873', '513422479@qq.com', '男', '24', '2017-10-12 00:00:00', '李瑜', null, null, '000');
INSERT INTO `spl` VALUES ('ab9cc313d7014e67acbfd5e6c8987469', '360', 'www.baidu.com', '深圳坂田', '成了', '18975661873', '513422479@qq.com', '男', '24', '2017-10-11 00:00:00', '李瑜', null, null, '000');
INSERT INTO `spl` VALUES ('b94184e5a53e45c595e4480283fe563d', '中国移动', 'www.baidu.com', '益阳步行街', '张三', '18975661873', '513422479@qq.com', '男', '24', '2017-10-11 00:00:00', '李瑜', null, null, '000');
INSERT INTO `spl` VALUES ('bbfbdfe53ad14525ad1af3db5cccb5a6', '吉利', 'www.baidu.com', '深圳坂田', '李书福', '18975661873', '513422479@qq.com', '男', '24', '2017-10-09 00:00:00', '李瑜', null, null, '000');
INSERT INTO `spl` VALUES ('e812bd208d1245c2b3e88edecdb8b34f', '长江实业', 'www.baidu.com', '深圳坂田', '李嘉诚', '18975661873', '513422479@qq.com', '男', '24', '2017-10-08 00:00:00', '李瑜', null, null, '000');
INSERT INTO `spl` VALUES ('f13d1f13f695443c974b921ba10fc8f0', '腾讯', 'www.baidu.com', '深圳坂田', '马化腾', '18975661873', '513422479@qq.com', '男', '24', '2017-10-07 00:00:00', '李瑜', null, null, '000');

-- ----------------------------
-- Table structure for `sys_oper_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
  `oper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(30) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(255) DEFAULT '' COMMENT '请求参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` tinyint(4) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for `token`
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `token_id` varchar(32) NOT NULL,
  `user_id` varchar(11) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`token_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES ('1', '1', '30F870160D8DC8E308691C6A5922B053DA9E1ACF7BE10B6A373E44A9', '2017-09-28 10:23:31.317', '2017-10-28 10:23:31.317');
INSERT INTO `token` VALUES ('2', '1', '30F870160D8DC8E308691C6A5922B053DA9E1ACF7BE10B6A373E44A9', '2017-09-28 10:23:31.317', '2017-10-28 10:23:31.317');

-- ----------------------------
-- Table structure for `tt_function`
-- ----------------------------
DROP TABLE IF EXISTS `tt_function`;
CREATE TABLE `tt_function` (
  `function_id` int(11) NOT NULL AUTO_INCREMENT,
  `function_name` varchar(50) NOT NULL COMMENT '功能名称',
  `action` varchar(50) DEFAULT NULL COMMENT '操作,如add',
  `icon` varchar(50) DEFAULT NULL COMMENT '功能按钮图标',
  `remark` varchar(255) DEFAULT NULL,
  `isenale` int(5) DEFAULT '1' COMMENT '是否启用 0 不启用 1 启用',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `add_user` bigint(20) DEFAULT NULL COMMENT '添加人',
  `mod_time` datetime DEFAULT NULL COMMENT '修改时间',
  `mod_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`function_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_function
-- ----------------------------

-- ----------------------------
-- Table structure for `tt_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tt_menu`;
CREATE TABLE `tt_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL,
  `path` varchar(64) DEFAULT NULL,
  `component` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `iconCls` varchar(64) DEFAULT NULL,
  `keepAlive` tinyint(1) DEFAULT NULL,
  `requireAuth` tinyint(1) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `isenale` int(5) DEFAULT '1' COMMENT '是否启用 0 不启用 1 启用',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `add_user` bigint(20) DEFAULT NULL COMMENT '添加人',
  `mod_time` datetime DEFAULT NULL COMMENT '修改时间',
  `mod_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_menu
-- ----------------------------
INSERT INTO `tt_menu` VALUES ('1', '/', null, null, '所有', null, null, null, null, '1', '2018-05-17 00:00:00', '1', '2018-05-17 00:00:00', '1');
INSERT INTO `tt_menu` VALUES ('2', '/', '/home', 'Home', '员工资料', 'fa fa-user-circle-o', null, '1', '1', '1', '2018-05-17 00:00:00', '1', '2018-05-17 00:00:00', '1');
INSERT INTO `tt_menu` VALUES ('3', '/', '/home', 'Home', '人事管理', 'fa fa-address-card-o', null, '1', '1', '1', '2018-05-17 00:00:00', '1', '2018-05-17 00:00:00', '1');
INSERT INTO `tt_menu` VALUES ('4', '/', '/home', 'Home', '薪资管理', 'fa fa-money', null, '1', '1', '1', '2018-05-17 00:00:00', '1', '2018-05-17 00:00:00', '1');
INSERT INTO `tt_menu` VALUES ('5', '/', '/home', 'Home', '统计管理', 'fa fa-bar-chart', null, '1', '1', '1', '2018-05-17 00:00:00', '1', '2018-05-17 00:00:00', '1');
INSERT INTO `tt_menu` VALUES ('6', '/', '/home', 'Home', '系统管理', 'fa fa-windows', null, '1', '1', '1', '2018-05-17 00:00:00', '1', '2018-05-17 00:00:00', '1');

-- ----------------------------
-- Table structure for `tt_role`
-- ----------------------------
DROP TABLE IF EXISTS `tt_role`;
CREATE TABLE `tt_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(200) DEFAULT NULL COMMENT '角色描述',
  `isenale` int(5) DEFAULT '1' COMMENT '是否启用 0 不启用 1 启用',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `add_user` bigint(20) DEFAULT NULL COMMENT '添加人',
  `mod_time` datetime DEFAULT NULL COMMENT '修改时间',
  `mod_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_role
-- ----------------------------
INSERT INTO `tt_role` VALUES ('1', 'ROLE_manager', '部门主管', '1', '2018-05-17 00:00:00', '1', '2018-05-17 00:00:00', '1');
INSERT INTO `tt_role` VALUES ('2', 'ROLE_hrManager', '行政经理', '1', '2018-05-17 00:00:00', '1', '2018-05-17 00:00:00', '1');
INSERT INTO `tt_role` VALUES ('3', 'ROLE_devManager', '开发经理', '1', '2018-05-17 00:00:00', '1', '2018-05-17 00:00:00', '1');
INSERT INTO `tt_role` VALUES ('4', 'ROLE_dev', '程序员', '1', '2018-05-17 00:00:00', '1', '2018-05-17 00:00:00', '1');
INSERT INTO `tt_role` VALUES ('5', 'ROLE_test', '测试员', '1', '2018-05-17 00:00:00', '1', '2018-05-17 00:00:00', '1');
INSERT INTO `tt_role` VALUES ('6', 'ROLE_admin', '系统管理员', '1', '2018-05-17 00:00:00', '1', '2018-05-17 00:00:00', '1');

-- ----------------------------
-- Table structure for `tt_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tt_role_menu`;
CREATE TABLE `tt_role_menu` (
  `role_menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  `function_id` int(11) DEFAULT NULL,
  `actions` varchar(255) DEFAULT NULL,
  `isenale` int(5) DEFAULT '1' COMMENT '是否启用 0 不启用 1 启用',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `add_user` bigint(20) DEFAULT NULL COMMENT '添加人',
  `mod_time` datetime DEFAULT NULL COMMENT '修改时间',
  `mod_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`role_menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `tt_user`
-- ----------------------------
DROP TABLE IF EXISTS `tt_user`;
CREATE TABLE `tt_user` (
  `user_id` bigint(20) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `deptid` varchar(32) DEFAULT NULL,
  `isenale` int(5) DEFAULT '1',
  `add_time` datetime DEFAULT NULL,
  `add_user` bigint(20) DEFAULT NULL,
  `mod_time` datetime DEFAULT NULL,
  `mod_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_user
-- ----------------------------
INSERT INTO `tt_user` VALUES ('1', null, 'liyu', '123456', null, null, null, null, null, null, '1', null, null, null, null);
INSERT INTO `tt_user` VALUES ('2', null, 'liyu2', '123456', null, null, null, null, null, null, '1', null, null, null, null);

-- ----------------------------
-- Table structure for `tt_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `tt_user_role`;
CREATE TABLE `tt_user_role` (
  `ur_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `isenale` int(5) DEFAULT '1' COMMENT '是否启用 0 不启用 1 启用',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `add_user` bigint(20) DEFAULT NULL COMMENT '添加人',
  `mod_time` datetime DEFAULT NULL COMMENT '修改时间',
  `mod_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_user_role
-- ----------------------------
INSERT INTO `tt_user_role` VALUES ('1', '1', '6', '1', '2018-05-18 10:54:30', '1', null, null);
INSERT INTO `tt_user_role` VALUES ('2', '2', '5', '1', '2018-05-18 10:55:32', null, null, null);
INSERT INTO `tt_user_role` VALUES ('3', '1', '5', '1', '2018-05-18 10:58:16', null, null, null);

-- ----------------------------
-- Table structure for `t_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource` (
  `sourceid` bigint(20) NOT NULL AUTO_INCREMENT,
  `source_name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `path` varchar(200) DEFAULT NULL COMMENT '路径',
  `nodepath` text COMMENT '节点路径',
  `sourcetype` int(11) DEFAULT NULL COMMENT '资源类型 0 窗口 1 按钮',
  `target` varchar(50) DEFAULT NULL,
  `parentid` bigint(20) DEFAULT NULL COMMENT '父类资源',
  `createtime` datetime DEFAULT NULL,
  `sourcelevel` int(11) DEFAULT NULL,
  `isused` int(11) DEFAULT NULL COMMENT '资源是否启用 0 不启用 1 启用',
  `fid` varchar(255) DEFAULT NULL COMMENT '功能id',
  `fname` text COMMENT '功能名称',
  PRIMARY KEY (`sourceid`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_resource
-- ----------------------------
INSERT INTO `t_resource` VALUES ('1', '系统管理', '', '0,1', '0', null, '0', '2013-10-21 17:41:16', '0', '1', '', '');
INSERT INTO `t_resource` VALUES ('3', '角色管理', '/mgr/role/rolelist.jsp', '0,3', '0', null, '1', '2013-10-21 17:55:24', '0', '1', '1,4,13,14', '增加,删除,编辑,分配权限');
INSERT INTO `t_resource` VALUES ('4', '用户管理', '/mgr/user/userlist.jsp', '0,4', '0', null, '1', '2013-10-21 18:03:22', '0', '1', '1,4,15,16,17,18', '增加,删除,锁定,解锁,分配角色,查询');
INSERT INTO `t_resource` VALUES ('40', '系统日志', '/mgr/log/loglist.jsp', '0,40', '0', '/loglist', '1', '2013-11-09 10:37:42', '1', '1', '18', '查询');
INSERT INTO `t_resource` VALUES ('41', '地区管理', '', '0,41', '0', 'region', '0', '2013-11-09 13:30:22', '0', '1', '', '');
INSERT INTO `t_resource` VALUES ('42', '地区列表', '/mgr/region/regionlist.jsp', '0,42', '0', '/regionlist', '41', '2013-11-09 13:31:12', '1', '1', '1,4,13,18', '增加,删除,编辑,查询');
INSERT INTO `t_resource` VALUES ('69', '地产管理', '', '0,69', '0', 'company', '0', '2014-04-02 11:23:21', '0', '1', '', '');
INSERT INTO `t_resource` VALUES ('70', '合作地产列表', '/mgr/company/companylist.jsp', '0,70', '0', '/companylist', '69', '2014-04-02 11:24:13', '1', '1', '1,4,13,18', '增加,删除,编辑,查询');
INSERT INTO `t_resource` VALUES ('71', '产品管理', '', '0,71', '0', 'product', '0', '2014-04-02 15:51:23', '0', '1', '', '');
INSERT INTO `t_resource` VALUES ('72', '类型管理', '/mgr/genre/genrelist.jsp', '0,72', '0', '/genrelist', '71', '2014-04-02 16:15:52', '1', '1', '1,4,13,18', '增加,删除,编辑,查询');
INSERT INTO `t_resource` VALUES ('73', '产品列表', '/mgr/product/productlist.jsp', '0,73', '0', '/productlist', '71', '2014-04-03 09:51:28', '1', '1', '1,4,13,18', '增加,删除,编辑,查询');
INSERT INTO `t_resource` VALUES ('74', '页尾管理', '', '0,74', '0', 'footer', '0', '2014-04-10 10:23:18', '0', '1', '', '');
INSERT INTO `t_resource` VALUES ('75', '友情链接', '/mgr/link/linklist.jsp', '0,75', '0', '/linklist', '74', '2014-04-10 10:23:39', '1', '1', '1,4,13,18', '增加,删除,编辑,查询');
INSERT INTO `t_resource` VALUES ('76', '帮助中心', '/mgr/footer/footerlist.jsp', '0,76', '0', '/footerlist', '74', '2014-04-10 15:30:20', '1', '1', '1,4,13,18', '增加,删除,编辑,查询');
INSERT INTO `t_resource` VALUES ('77', '订单管理', '', '0,77', '0', 'recommend', '0', '2014-04-29 09:52:11', '0', '1', '', '');
INSERT INTO `t_resource` VALUES ('78', '推荐列表', '/mgr/recommend/recommendlist.jsp', '0,78', '0', '/recommendlist', '77', '2014-04-29 09:52:53', '1', '1', '18,24,29,30', '查询,订单处理,佣金发放,导出报表');
INSERT INTO `t_resource` VALUES ('79', '用户管理', '', '0,79', '0', 'r_user', '0', '2014-05-03 17:19:25', '0', '1', '', '');
INSERT INTO `t_resource` VALUES ('80', '前台用户列表', '/mgr/ruser/ruserlist.jsp', '0,80', '0', '/ruserlist', '79', '2014-05-03 17:40:31', '1', '1', '15,16,18,23,25,26,28', '锁定,解锁,查询,查看详细,查看佣金记录,添加用户新闻,提现');
INSERT INTO `t_resource` VALUES ('82', '关于我们', '/mgr/sitelink/aboutusform.jsp', '0,82', '0', '/aboutusform', '74', '2014-05-05 16:09:04', '1', '1', '27', '保存');
INSERT INTO `t_resource` VALUES ('83', '联系我们', '/mgr/sitelink/contactform.jsp', '0,83', '0', '/contactform', '74', '2014-05-05 16:45:56', '1', '1', '27', '保存');
INSERT INTO `t_resource` VALUES ('84', '服务声明', '/mgr/sitelink/serviceform.jsp', '0,84', '0', '/serviceform', '74', '2014-05-05 17:06:41', '1', '1', '27', '保存');
INSERT INTO `t_resource` VALUES ('85', '友情链接说明', '/mgr/sitelink/linkform.jsp', '0,85', '0', '/linkform', '74', '2014-05-05 17:09:11', '1', '1', '27', '保存');
INSERT INTO `t_resource` VALUES ('86', '常见问题', '/mgr/sitelink/questionform.jsp', '0,86', '0', '/questionform', '74', '2014-05-05 17:13:20', '1', '1', '27', '保存');
INSERT INTO `t_resource` VALUES ('87', '网站地图', '/mgr/sitelink/mapform.jsp', '0,87', '0', '/mapform', '74', '2014-05-05 17:16:18', '1', '1', '27', '保存');
INSERT INTO `t_resource` VALUES ('88', '人才招聘', '/mgr/sitelink/offersform.jsp', '0,88', '0', '/offersform', '74', '2014-05-05 17:17:57', '1', '1', '27', '保存');
INSERT INTO `t_resource` VALUES ('89', '广告管理', '', '0,89', '0', 'ad', '0', '2014-05-07 16:49:55', '0', '1', '', '');
INSERT INTO `t_resource` VALUES ('90', '广告列表', '/mgr/ad/adlist.jsp', '0,90', '0', '/adlist', '89', '2014-05-07 16:50:44', '1', '1', '1,4,13,18', '增加,删除,编辑,查询');
INSERT INTO `t_resource` VALUES ('91', '系统设置', '/mgr/sys_setting/sysform.jsp', '0,91', '0', '/sysform', '1', '2014-05-12 12:44:42', '1', '1', '27', '保存');
INSERT INTO `t_resource` VALUES ('92', '团队管理', '', '0,92', '0', 'team', '0', '2014-05-14 10:55:02', '0', '1', '', '');
INSERT INTO `t_resource` VALUES ('93', '团队列表', '/mgr/team/teamlist.jsp', '0,93', '0', '/teamlist', '92', '2014-05-14 10:56:46', '1', '1', '18', '查询');
