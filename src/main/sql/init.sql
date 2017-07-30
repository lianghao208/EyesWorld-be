-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE tvos;
-- 使用数据库

USE tvos;

-- 创建表
-- ---------------------------------------------------- tvos数据库v1.0

-- 用户登录表
CREATE TABLE user(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255),
  password VARCHAR(255),
  cookie_id VARCHAR(255),
  creation_time BIGINT,
  modification_time BIGINT
);

-- 用户信息表
CREATE TABLE user_info(
  user_id BIGINT,
  gender VARCHAR(16),
  creation_time BIGINT,
  modification_time BIGINT
);
-- 添加外键
ALTER TABLE user_info ADD FOREIGN KEY (user_id) REFERENCES user(id);

-- 用户相片表
CREATE TABLE user_photo(
  id BIGINT,
  url VARCHAR(20),
  photo_id BIGINT,
  photo_name VARCHAR(255),
  album_id BIGINT,
  album_name VARCHAR(255),
  creation_time BIGINT,
  modification_time BIGINT
);
-- 添加外键
ALTER TABLE user_photo ADD FOREIGN KEY (id) REFERENCES user(id);
ALTER TABLE user_photo ADD FOREIGN KEY (photo_id) REFERENCES photo(id);
ALTER TABLE user_photo ADD FOREIGN KEY (album_id) REFERENCES album(id);


-- 省份表--添加字段
CREATE TABLE province(
  id INT PRIMARY KEY AUTO_INCREMENT,
  province_name VARCHAR(32),
  spot_num TINYINT DEFAULT 0,
  college_num TINYINT DEFAULT 0,
  creation_time BIGINT,
  modification_time BIGINT
);

-- 城市表--添加字段
CREATE TABLE city(
  id INT PRIMARY KEY AUTO_INCREMENT,
  city_name VARCHAR(255),
  province_id INT,
  spot_num INT DEFAULT 0,
  creation_time BIGINT,
  modification_time BIGINT
);
-- 添加外键
ALTER TABLE city ADD FOREIGN KEY (province_id) REFERENCES province(id);

-- 高校表
CREATE TABLE college(
  id INT PRIMARY KEY AUTO_INCREMENT,
  college_name VARCHAR(255),
  province_id INT,
  creation_time BIGINT,
  modification_time BIGINT
);

-- 相册表(高校和景点共用，city_id为空时该相册为高校相册)--修改字段名
CREATE TABLE album(
  id INT PRIMARY KEY AUTO_INCREMENT,
  album_name VARCHAR(255),
  city_id INT,
  province_id INT,
  visit_amount INT,
  like_amount INT,
  url VARCHAR(225),
  creation_time BIGINT,
  modification_time BIGINT
);
-- 加外键
alter table album add foreign key (province_id) references province(id);
alter table album add foreign key (city_id) references city(id);


-- 图片表--增加字段名
CREATE TABLE photo(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  photo_name VARCHAR(255),
  album_id INT,
  album_name VARCHAR(255),
  user_id BIGINT,
  like_amount INT,
  url VARCHAR(225),
  creation_time BIGINT,
  modification_time BIGINT
);
-- 加外键
alter table photo add foreign key (album_id) references album(id);
alter table photo add foreign key (user_id) references user(id);

-- 图片点赞表
CREATE TABLE photo_like(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  photo_id BIGINT,
  user_id BIGINT,
  creation_time BIGINT,
  modification_time BIGINT
);
-- 加外键
alter table photo_like add foreign key (photo_id) references photo(id);
alter table photo_like add foreign key (user_id) references user(id);

CREATE TABLE photo_comment(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  photo_id INT,
  user_id INT,
  content TEXT,
  creation_time BIGINT,
  modification_time BIGINT
);
