-- 数据库初始化脚本

-- 数据库一定要设置好编码！！
SET NAMES gb2312;
SET character_set_database = utf8;
SET character_set_server = utf8;

-- 其它默认utf8



-- 创建数据库
CREATE DATABASE tvos;
-- 使用数据库

USE tvos;

-- 创建表
-- ---------------------------------------------------- tvos数据库v1.0

-- 用户登陆状态标识表
CREATE TABLE token_holder(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `marker` VARCHAR(255),
  `token` VARCHAR(255),
  `modification_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 用户登录表
CREATE TABLE user(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `username` VARCHAR(255) UNIQUE ,
  `password` VARCHAR(255),
  `creation_time` DATETIME,
  `modification_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 用户信息表
CREATE TABLE user_info(
  `user_id` BIGINT,
  `gender` VARCHAR(16),
  `creation_time` DATETIME,
  `modification_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 添加外键
ALTER TABLE user_info ADD FOREIGN KEY (`user_id`) REFERENCES user(`id`) ON DELETE CASCADE;

-- 用户相片表
CREATE TABLE user_photo(
  `id` BIGINT,
  `url` VARCHAR(20),
  `photo_id` BIGINT,
  `photo_name` VARCHAR(255),
  `album_id` BIGINT,
  `album_name` VARCHAR(255),
  `creation_time` DATETIME,
  `modification_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 添加外键
ALTER TABLE user_photo ADD FOREIGN KEY (`id`) REFERENCES user(`id`) ON DELETE CASCADE;
ALTER TABLE user_photo ADD FOREIGN KEY (`photo_id`) REFERENCES photo(`id`) ON DELETE CASCADE;
ALTER TABLE user_photo ADD FOREIGN KEY (`album_id`) REFERENCES album(`id`) ON DELETE CASCADE;


-- 省份表--添加字段
CREATE TABLE province(
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `province_name` VARCHAR(32),
  `spot_num` TINYINT DEFAULT 0,
  `college_num` TINYINT DEFAULT 0,
  `creation_time` DATETIME,
  `modification_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 城市表--添加字段
CREATE TABLE city(
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `city_name` VARCHAR(255),
  `province_id` INT,
  `spot_num` INT DEFAULT 0,
  `creation_time` DATETIME,
  `modification_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 添加外键
ALTER TABLE city ADD FOREIGN KEY (`province_id`) REFERENCES province(`id`) ON DELETE CASCADE;

-- 高校表--唯一约束
CREATE TABLE college(
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `college_name` VARCHAR(255) UNIQUE KEY ,
  `province_id` INT,
  `creation_time` DATETIME,
  `modification_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY (college_name,province_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 相册表(高校和景点共用，city_id为空时该相册为高校相册)-- 修改字段名:album_name\city_id\province_id为联合唯一约束
CREATE TABLE album(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `album_name` VARCHAR(255),
  `city_id` INT,
  `province_id` INT,
  `visit_amount` INT,
  `like_amount` INT,
  `url` VARCHAR(225),
  `creation_time` DATETIME,
  `modification_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   UNIQUE KEY (album_name,city_id,province_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 加外键
alter table album add foreign key (`province_id`) references province(`id`) ON DELETE CASCADE;
alter table album add foreign key (`city_id`) references city(`id`) ON DELETE CASCADE;


-- 图片表--增加字段名
CREATE TABLE photo(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `photo_name` VARCHAR(255),
  `photo_description` VARCHAR(255),
  `album_id` BIGINT,
  `album_name` VARCHAR(255),
  `user_id` BIGINT,
  `username` VARCHAR(255),
  `like_amount` INT,
  `url` VARCHAR(255),
  `creation_time` DATETIME,
  `modification_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 加外键
alter table photo add foreign key (`album_id`) references album(`id`) ON DELETE CASCADE;
alter table photo add foreign key (`user_id`) references user(`id`) ON DELETE CASCADE;

-- 图片点赞表
CREATE TABLE photo_like(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `photo_id` BIGINT,
  `user_id` BIGINT,
  `creation_time` DATETIME,
  `modification_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 加外键
alter table photo_like add foreign key (`photo_id`) references photo(`id`) ON DELETE CASCADE;
alter table photo_like add foreign key (`user_id`) references user(`id`) ON DELETE CASCADE;

-- 图片评论表
CREATE TABLE photo_comment(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `photo_id` BIGINT,
  `user_id` BIGINT,
  `content` VARCHAR(255),
  `creation_time` DATETIME,
  `modification_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 加外键
alter table photo_comment add foreign key (`photo_id`) references photo(`id`) ON DELETE CASCADE;
alter table photo_comment add foreign key (`user_id`) references user(`id`) ON DELETE CASCADE;

-- 所有外键约束都为删除时cascade类型
ON DELETE CASCADE;


-- 数据表要统一编码

alter table album convert to character set utf8;


-- 插入独立约束时
INSERT INTO TABLE (a,c) VALUES (1,3),(1,7) ON DUPLICATE KEY UPDATE c=VALUES(c);