--  用户表

CREATE TABLE `user_id_source` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000000 DEFAULT CHARSET=utf8 COMMENT='用户的id生成表';

CREATE TABLE `user_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户唯一id',
  `nickname` varchar(20) NOT NULL DEFAULT '' COMMENT '用户昵称',
  `user_status` tinyint(5) unsigned NOT NULL DEFAULT '0' COMMENT '账号状态',
  `gender` tinyint(5) unsigned NOT NULL DEFAULT '0' COMMENT '性别,0:女,1:男',
  `avatar_url` varchar(80) NOT NULL DEFAULT '' COMMENT '用户头像',
  `mobile` varchar(20) NOT NULL DEFAULT '' COMMENT '验证后的主手机号',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`),
  KEY `idx_update_time` (`update_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户基本信息表';

-- 绑定表

CREATE TABLE `user_app_bind` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户id',
  `open_id` varchar(20) NOT NULL DEFAULT '' COMMENT '第三方用户id(微信的openid应在此)',
  `unique_id` varchar(80) NOT NULL DEFAULT '' COMMENT '用户第三方唯一标识，微信unionid，或第三方唯一userid',
  `app_type` tinyint(5) unsigned NOT NULL DEFAULT '0' COMMENT '第三方类别, 1:微信',
  `bind_status` tinyint(5) unsigned NOT NULL DEFAULT '0' COMMENT '绑定状态,1:已绑定,2:已解绑',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_unique_id` (`open_id`, `unique_id`, `app_type`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_update_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='第三方用户绑定表';

CREATE TABLE `user_mobile_bind` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `address` varchar(20) NOT NULL COMMENT '手机号',
  `country_code` varchar(10) NOT NULL DEFAULT '86' COMMENT '国际区号',
  `verify_code` int(10) NOT NULL COMMENT '验证码',
  `send_times` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '验证码发送次数',
  `bind_status` tinyint(5) unsigned NOT NULL DEFAULT '0' COMMENT '0:未绑定,1:已绑定, 2:已解绑',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_address` (`address`, `country_code`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_update_time` (`update_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户手机绑定表';

-- 好友关系表

CREATE TABLE `user_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户id',
  `friend_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '好友的id',
  `relation_status` tinyint(5) unsigned NOT NULL DEFAULT '0' COMMENT '关系状态,0:未关注,1:已关注,2:已屏蔽,3:已拉黑',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_user_friend` (`user_id`, `friend_id`),
  KEY `idx_friend_id` (`friend_id`),
  KEY `idx_update_time` (`update_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='好友关系表';

-- 朋友圈

CREATE TABLE `circle_article` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户id',
  `content` varchar(500) NOT NULL DEFAULT '' COMMENT '朋友圈文字',
  `picture` varchar(500) NOT NULL DEFAULT '' COMMENT '朋友圈图片,json',
  `shared` varchar(500) NOT NULL DEFAULT '' COMMENT '分享内容,json',
  `location` varchar(200) NOT NULL DEFAULT '' COMMENT '位置',
  `article_status` tinyint(5) unsigned NOT NULL DEFAULT '0' COMMENT '文章状态,0:正常,1:已删除',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='圈子内容';

CREATE TABLE `circle_timeline` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户id',
  `article_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '圈子内容表的主键id',
  `is_own` tinyint(5) unsigned NOT NULL DEFAULT '0' COMMENT '是否是自己的,0:不是,1:是',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='圈子时间轴';

CREATE TABLE `article_comment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `article_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '圈子内容表的主键id',
  `comment_user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '评论者的userid',
  `content` varchar(500) NOT NULL DEFAULT '' COMMENT '评论内容',
  `vote_count` int(10) NOT NULL DEFAULT '0' COMMENT '该评论被点赞次数',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_article_id` (`article_id`),
  KEY `idx_comment_user_id` (`comment_user_id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='评论表';

CREATE TABLE `t_article_vote` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `article_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '圈子内容表的主键id',
  `vote_user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '点赞者的userid',
  `vote_status` tinyint(5) unsigned NOT NULL DEFAULT '0' COMMENT '点赞状态,0:取消,1:点赞',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_article_id` (`article_id`),
  KEY `idx_vote_user_id` (`vote_user_id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='圈子点赞表';

CREATE TABLE `t_comment_vote` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `comment_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '评论表的主键id',
  `vote_user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '点赞者的userid',
  `vote_status` tinyint(5) unsigned NOT NULL DEFAULT '0' COMMENT '点赞状态,0:取消,1:点赞',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_comment_id` (`comment_id`),
  KEY `idx_vote_user_id` (`vote_user_id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='评论点赞表';
