-- 创建student表
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` varchar(10) NOT NULL COMMENT '营员ID',
  `s_name` varchar(20) NOT NULL COMMENT '营员名称',
  `s_bunk` varchar(20) NOT NULL COMMENT '营员bunk',
  `s_status` varchar(2) NOT NULL COMMENT '营员状态' DEFAULT '1' , /*0 未参加  1 正常参加  2 外出就医  3 意外退出*/
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='营员表';

/*  s_id 生成策略
	年份 2019
	年龄段 1 2 3
	性别 0 1
	序号 001
	
例：201911001  2019年小龄段男生01号
*/

-- 创建counselor表
DROP TABLE IF EXISTS `counselor`;
CREATE TABLE `counselor` (
  `c_id` varchar(11) NOT NULL COMMENT 'counselorID',
  `c_name` varchar(20) NOT NULL COMMENT 'counselor名称',
  `c_bunk` varchar(20) NOT NULL COMMENT 'counselorbunk',
  `c_intro` varchar(100) NOT NULL COMMENT 'counselor介绍' ,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='counselor表';

/* counselor_id 生成策略
	身份 C
	年份 2019
	年龄段 1 2 3
	性别 0 1
	序号 001
	是否specialty 1
	
例：C2019200031 Counselor2019年中龄段女性03号是specialty
*/

-- 创建director表
DROP TABLE IF EXISTS `director`;
CREATE TABLE `director` (
  `d_id` varchar(8) NOT NULL COMMENT 'directorID',
  `d_name` varchar(20) NOT NULL COMMENT 'director名称',
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='director表';

/* director_id 生成策略
	身份 D
	年份 2019
	序号 001
	
例：D2019001 Director2019年001号
*/
-- 创建staff表
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `st_id` varchar(9) NOT NULL COMMENT 'staffID',
  `st_name` varchar(20) NOT NULL COMMENT 'staff名称',
  PRIMARY KEY (`st_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='staff表';

/* staff_id 生成策略
	身份 ST
	年份 2019
	序号 001
	
例：ST2019001 Staff2019年001号
*/

-- 创建bunk表
DROP TABLE IF EXISTS `bunk`;
CREATE TABLE `bunk` (
  `b_id` varchar(11) NOT NULL COMMENT 'bunkID',
  `b_name` varchar(20) NOT NULL COMMENT 'bunk名称',
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='bunk表';

/* b_id生成策略 时间戳	*/

-- 创建elective表
DROP TABLE IF EXISTS `elective`;
CREATE TABLE `elective` (
  `e_id` varchar(7) NOT NULL COMMENT 'electiveID',
  `e_name` varchar(20) NOT NULL COMMENT 'elective名称',
  `e_vol` int COMMENT 'elective容量',
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='elective表';

/* e_id 生成策略
	类别 E
	年龄段 001 仅小 002 仅中 003 仅大 012 中小 013 大小 023 中大 123 全龄
	序号 001
例： E023001 中大年龄段01号elective 
	
*/

DROP TABLE IF EXISTS `counselor_elective_map`;
CREATE TABLE `counselor_elective_map`  (
  `c_id` varchar(11)  NOT NULL,
  `e_id` varchar(7) NOT NULL,
  PRIMARY KEY (`c_id`, `e_id`) USING BTREE
) ENGINE = InnoDB CHARSET = utf8 ROW_FORMAT = Dynamic COMMENT='c_e_map表';

DROP TABLE IF EXISTS `student_elective_map`;
CREATE TABLE `student_elective_map`  (
  `s_id` varchar(10)  NOT NULL,
  `e_id` varchar(7) NOT NULL,
  PRIMARY KEY (`s_id`, `e_id`) USING BTREE
) ENGINE = InnoDB CHARSET = utf8 ROW_FORMAT = Dynamic COMMENT='s_e_map表';

DROP TABLE IF EXISTS `counselor_bunk_map`;
CREATE TABLE `counselor_bunk_map`  (
  `c_id` varchar(11)  NOT NULL,
  `b_id` varchar(11) NOT NULL,
  PRIMARY KEY (`c_id`, `b_id`) USING BTREE
) ENGINE = InnoDB CHARSET = utf8 ROW_FORMAT = Dynamic COMMENT='c_b_map 表';

DROP TABLE IF EXISTS `student_bunk_map`;
CREATE TABLE `student_bunk_map`  (
  `s_id` varchar(10)  NOT NULL,
  `b_id` varchar(11) NOT NULL,
  PRIMARY KEY (`s_id`, `b_id`) USING BTREE
) ENGINE = InnoDB CHARSET = utf8 ROW_FORMAT = Dynamic COMMENT='s_b_map 表';
SET FOREIGN_KEY_CHECKS = 1;

