-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE tvos;
-- 使用数据库

USE tvos;

-- 创建表
-- ---------------------------------------------------- tvos数据库v1.0
-- 用户登录信息表
CREATE TABLE user_info (
  'user_id' BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户id',
  'username' VARCHAR(120) NOT NULL COMMENT '用户名',
  'password' VARCHAR (120) NOT NULL COMMENT '密码',
  'state' TINYINT NOT NULL DEFAULT -1 COMMENT '登录状态:-1:无效 0:成功 ',
  'create_time' TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (user_id),
  KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT ='用户信息表';

-- 初始化数据
INSERT INTO tvos(username,password)
  values
  ('Tony','123456789'),
  ('Alice','123456789'),
  ('John','123456789'),
  ('Ben','123456789');

-- 用户照片表
CREATE TABLE user_photo (
  'user_id' BIGINT NOT NULL COMMENT '用户id',
  'username' VARCHAR(120) NOT NULL COMMENT '用户名',
  'photo_url' VARCHAR (120) NOT NULL COMMENT '照片url地址',
  'create_time' TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (user_id,username),/*联合主键*/
  KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT ='用户照片表';

-- 连接数据库控制台
mysql -uroot -p

-- 数据库修改操作记录

-- 修改操作1.0
ALTER TABLE user_info
DROP INDEX idx_create_time
add index_c_s(start_time,create_time);

-- 修改操作2.0
ALTER TABLE user_info
DROP INDEX index_c_s
add idx_create_time(create_time);