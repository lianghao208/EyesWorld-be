-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE tvos;
-- 使用数据库

USE tvos;

-- 创建表
-- ---------------------------------------------------- tvos数据库v1.0

-- 用户登录表
CREATE TABLE user(
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255),
  password VARCHAR(255),
  creation_time BIGINT,
  modification_time BIGINT
);

-- 用户信息表
CREATE TABLE user_info(
  user_id INT PRIMARY KEY,
  gender VARCHAR(16),
  creation_time BIGINT,
  modification_time BIGINT
);

-- 省份表
CREATE TABLE province(
  id INT PRIMARY KEY AUTO_INCREMENT,
  province_name VARCHAR(32),
  creation_time BIGINT,
  modification_time BIGINT
);

-- 城市表
CREATE TABLE city(
  id INT PRIMARY KEY AUTO_INCREMENT,
  city_name VARCHAR(255),
  province_id INT,
  creation_time BIGINT,
  modification_time BIGINT
);

-- 高校表
CREATE TABLE college(
  id INT PRIMARY KEY AUTO_INCREMENT,
  college_name VARCHAR(255),
  province_id INT,
  creation_time BIGINT,
  modification_time BIGINT
);

-- 相册表
CREATE TABLE album(
  id INT PRIMARY KEY AUTO_INCREMENT,
  album_name VARCHAR(255),
  city_id INT,
  college_id INT,
  visit_amount INT,
  like_amount INT,
  creation_time BIGINT,
  modification_time BIGINT
);

-- 图片表
CREATE TABLE photo(
  id INT PRIMARY KEY AUTO_INCREMENT,
  photo_name VARCHAR(255),
  album_id INT,
  user_id INT,
  like_amount INT,
  creation_time BIGINT,
  modification_time BIGINT
);

CREATE TABLE photo_like(
  id INT PRIMARY KEY AUTO_INCREMENT,
  photo_id INT,
  user_id INT,
  creation_time BIGINT,
  modification_time BIGINT
);

CREATE TABLE photo_comment(
  id INT PRIMARY KEY AUTO_INCREMENT,
  photo_id INT,
  user_id INT,
  content TEXT,
  creation_time BIGINT,
  modification_time BIGINT
);
