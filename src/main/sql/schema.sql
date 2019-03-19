-- 创建student表
CREATE TABLE `student` (
  `s_id` varchar(10) NOT NULL COMMENT '营员ID',
  `s_name` varchar(20) NOT NULL COMMENT '营员名称',
  `s_bunk` varchar(20) NOT NULL COMMENT '营员bunk',
  `s_status` varchar(2) NOT NULL COMMENT '营员状态' DEFAULT '1' , --0 未参加  1 正常参加  2 外出就医  3 意外退出
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='营员表';

/*  s_id 生成策略
	年份 2019
	年龄段 1 2 3
	性别 0 1
	序号 001
	
例：201911001  2019年小龄段男生01号
*/

-- 创建counselor表
CREATE TABLE `counselor` (
  `c_id` varchar(11) NOT NULL COMMENT 'counselorID',
  `c_name` varchar(20) NOT NULL COMMENT 'counselor名称',
  `c_bunk` varchar(20) NOT NULL COMMENT 'counselorbunk',
  `c_intro` varchar(100) NOT NULL COMMENT 'counselor介绍' ,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='counselor表';

/* counselor_id 生成策略
	身份 C
	年份 2019
	年龄段 1 2 3
	性别 0 1
	序号 001
	是否specialty 1
	
例：C2019200031 Counselor2019年中龄段女性03号是specialty
*/

