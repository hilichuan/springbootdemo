--数据库初始化脚本
--创建数据库
CREATE database seckill;
--使用数据库
use seckill;
--创建秒杀库存表
CREATE table `seckill`(
`seckill_id` bigint not null auto_increment comment '商品库存id',
`name` VARCHAR (120) not null comment '商品名称',
`number` int not null comment '库存数量',
`start_time` TIMESTAMP not null comment '秒杀开启时间',
`end_time` TIMESTAMP not null comment '秒杀结束时间',
`create_time` TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP comment '创建时间',
PRIMARY key(`seckill_id`),
key idx_start_time(`start_time`),
key idx_end_time(`end_time`),
key idx_create_time(`create_time`)
)engine=innodb auto_increment=1000 DEFAULT charset=utf8;
--初始化数据
insert into seckill(name,number,start_time,end_time)
VALUES
  ('1000元秒杀iphone6',100,'2017-10-19 00:00:00','2017-10-20 00:00:00'),
('5000元秒杀iphone7',200,'2017-10-19 00:00:00','2017-10-20 00:00:00'),
('7000元秒杀iphone8',300,'2017-10-19 00:00:00','2017-10-20 00:00:00'),
('8000元秒杀iphone9',400,'2017-10-19 00:00:00','2017-10-20 00:00:00')

-- 用户登录认证相关信息(简化为手机号)
CREATE TABLE success_killed (
  `seckill_id`  BIGINT    NOT NULL
  COMMENT '秒杀商品ID',
  `user_phone`  BIGINT    NOT NULL
  COMMENT '用户手机号',
  `state`       TINYINT   NOT NULL DEFAULT -1
  COMMENT '状态标识:-1:无效 0:成功 1:已付款 2:已发货',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  PRIMARY KEY (seckill_id, user_phone), /*联合主键*/
  KEY idx_create_time(create_time)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT = '秒杀成功明细表'