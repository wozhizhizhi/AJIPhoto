# AJIPhoto
---
title: 结合七牛搭建自己的相册平台
---
#### 环境
1.Tomcat 7
2.JDK1.8
3.Eclipse JavaEE
4.Mysql
5.七牛

#### 创建数据库
```
CREATE DATABASE aji DEFAULT CHARSET=utf8;

CREATE TABLE `image` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(16) DEFAULT NULL,
  `url` VARCHAR(255) DEFAULT NULL,
  `date` DATETIME DEFAULT NULL,
  `user_id` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) DEFAULT NULL,
  `password` VARCHAR(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

```
- 创建完数据库之后，把代码下载下来，配置好运行环境，记得去七牛申请账号后，替换掉里面的key,在FileUtils.java里面找到以下代码填写自己的申请的密匙
```
  // 七牛密钥
  private static final String ACCESS_KEY = ""; 
  private static final String SECRET_KEY = "";
  // Bucket 名字
  private static final String BUCKET_NAME = "";
```
- 开始运行吧！
