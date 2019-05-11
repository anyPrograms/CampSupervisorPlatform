-- 创建student表
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` varchar(10) NOT NULL COMMENT '营员ID',
  `student_name` varchar(20) NOT NULL COMMENT '营员名称',
  `student_age` varchar(4) NOT NULL COMMENT '营员年龄',
  `student_bunk` varchar(20) NOT NULL COMMENT '营员bunkName',
  `student_status` varchar(2) NOT NULL COMMENT '营员状态' DEFAULT '1' , /*0 未参加  1 正常参加  2 外出就医  3 意外退出*/
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='营员表';

/*  student_id 生成策略
 * 	身份 S
	年份 2019
	年龄段 1 2 3
	性别 0 1
	序号 001
	
例：S201911001  营员2019年小龄段男生01号
*/

-- 创建counselor表
DROP TABLE IF EXISTS `counselor`;
CREATE TABLE `counselor` (
  `counselor_id` varchar(11) NOT NULL COMMENT 'counselorID',
  `counselor_name` varchar(20) NOT NULL COMMENT 'counselor名称',
  `counselor_bunk` varchar(20) NOT NULL COMMENT 'counselorbunk',
  `counselor_intro` varchar(100) NOT NULL COMMENT 'counselor介绍' ,
  PRIMARY KEY (`counselor_id`)
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
  `director_id` varchar(8) NOT NULL COMMENT 'directorID',
  `director_name` varchar(20) NOT NULL COMMENT 'director名称',
  PRIMARY KEY (`director_id`)
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
  `staff_id` varchar(9) NOT NULL COMMENT 'staffID',
  `staff_name` varchar(20) NOT NULL COMMENT 'staff名称',
  PRIMARY KEY (`staff_id`)
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
  `bunk_id` varchar(14) NOT NULL COMMENT 'bunkID',
  `bunk_name` varchar(20) NOT NULL COMMENT 'bunk名称',
  `bunk_vol` varchar(4) NOT NULL COMMENT 'bunk容量',
  PRIMARY KEY (`bunk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='bunk表';

/* bunk_id生成策略 时间戳	*/

-- 创建elective表
DROP TABLE IF EXISTS `elective`;
CREATE TABLE `elective` (
  `elective_id` varchar(14) NOT NULL COMMENT 'electiveID',
  `elective_name` varchar(20) NOT NULL COMMENT 'elective名称',
  `elective_intro` varchar(100) NOT NULL COMMENT 'elective介绍'，
  
  PRIMARY KEY (`elective_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 COMMENT='elective表';

/* elective_id 生成策略
  !此生成规则已废弃，目前使用时间戳
	类别 E
	年龄段 001 仅小 002 仅中 003 仅大 012 中小 013 大小 023 中大 123 全龄
	序号 001
例： E023001 中大年龄段01号elective 

*/

-- 创建elective_schedule表
/*记录每个时段的课程情况
  schedule_id 由period、elective_id、date联合生成
  peroid 1 2 3 4 5 6,代表一天六个课程时段
  ageGroup 1 2 3 小中大龄，适用于多个年龄以多条记录体现
*/
DROP TABLE IF EXISTS `elective_schedule`;
CREATE TABLE `elective_schedule` (
  `schedule_id` varchar(48) NOT NULL COMMENT 'scheduleID',
  `period` varchar(2) NOT NULL COMMENT '时段',
  `elective_id` varchar(14) NOT NULL COMMENT 'electiveID',
  `age_group` varchar(2) NOT NULL COMMENT '适用年龄段',
  `date` varchar(32) NOT NULL COMMENT '日期',
  `schedule_vol` varchar(6) NOT NULL COMMENT '容量',
  `location_id` INT NOT NULL 'locationID'
  PRIMARY KEY (`schedule_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='elective_schedule表';

-- 创建location表
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `location_id` varchar(14) NOT NULL AUTO_INCREMENT COMMENT 'locationID',
  `location_name` varchar(20) NOT NULL COMMENT 'location名称'
  
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 COMMENT='location表';

-- 创建counselor_elective_map表
/*
  is_specialty 0 1 0为协助位，1为主负责
*/
DROP TABLE IF EXISTS `counselor_elective_map`;
CREATE TABLE `counselor_elective_map`  (
  `counselor_id` varchar(11)  NOT NULL,
  `elective_id` varchar(14) NOT NULL,
  `is_specialty` varchar(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`counselor_id`, `elective_id`) USING BTREE
) ENGINE = InnoDB CHARSET = utf8 ROW_FORMAT = Dynamic COMMENT='counselor_elective_map表';

DROP TABLE IF EXISTS `student_elective_schedule_map`;
CREATE TABLE `student_elective_schedule_map`  (
  `student_id` varchar(10)  NOT NULL,
  `schedule_id` varchar(48) NOT NULL,
  PRIMARY KEY (`student_id`, `schedule_id`) USING BTREE
) ENGINE = InnoDB CHARSET = utf8 ROW_FORMAT = Dynamic COMMENT='student_elective_schedule_map表';

DROP TABLE IF EXISTS `counselor_bunk_map`;
CREATE TABLE `counselor_bunk_map`  (
  `counselor_id` varchar(11)  NOT NULL,
  `bunk_id` varchar(14) NOT NULL,
  PRIMARY KEY (`counselor_id`, `bunk_id`) USING BTREE
) ENGINE = InnoDB CHARSET = utf8 ROW_FORMAT = Dynamic COMMENT='counselor_bunk_map 表';

DROP TABLE IF EXISTS `student_bunk_map`;
CREATE TABLE `student_bunk_map`  (
  `student_id` varchar(10)  NOT NULL,
  `bunk_id` varchar(14) NOT NULL,
  PRIMARY KEY (`student_id`, `bunk_id`) USING BTREE
) ENGINE = InnoDB CHARSET = utf8 ROW_FORMAT = Dynamic COMMENT='student_bunk_map 表';
SET FOREIGN_KEY_CHECKS = 1;

