CREATE TABLE `sys_organization` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COMMENT '组织名称',
  `address` varchar(64) COMMENT '地址',
  `legal` varchar(64) COMMENT '法人',
  `description` varchar(256) DEFAULT NULL COMMENT '备注',
  `phone` varchar(16) comment '联系电话',
  `created_by` varchar(16) comment '创建人',
  `updated_by` varchar(16) comment '修改人',
  `ctime` datetime default current_timestamp comment '创建时间',
  `utime` datetime default current_timestamp on update current_timestamp comment '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织表';

CREATE TABLE `sys_department` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COMMENT '部门名称',
  `level` int COMMENT '部门等级',
  `pid` bigint COMMENT '上级部门id',
  `description` varchar(256) DEFAULT NULL COMMENT '备注',
  `seq` varchar(16) comment '部门序号',
  `org_id` bigint comment '所属组织',
  `created_by` varchar(16)  comment '创建人',
  `updated_by` varchar(16)  comment '修改人',
  `ctime` datetime default current_timestamp comment '创建时间',
  `utime` datetime default current_timestamp on update current_timestamp comment '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COMMENT '用户姓名',
  `sex` TINYINT COMMENT '用户性别',
  `age` int COMMENT '用户年龄',
  `phone` varchar(32) COMMENT '用户联系电话',
  `email` varchar(32) COMMENT '用户邮箱',
  `birthday` varchar(16) comment '用户出生日期',
  `account` varchar(32) comment '用户账号',
  `password` varchar(128) comment '用户密码',
  `description` varchar(256) comment '用户备注',
  `status` int default 0 comment '账户登录状态 0:正常 1:登录失效(暂做扩展)',
  `deleted` int default 0 comment '删除状态 0:未删除 1:已删除',
  `locked` int default 0 comment '账户状态 0:正常 1:锁定',
  `dpt_id` bigint comment '所属部门',
  `created_by` varchar(16)  comment '创建人',
  `updated_by` varchar(16)  comment '修改人',
  `ctime` datetime default current_timestamp comment '创建时间',
  `utime` datetime default current_timestamp on update current_timestamp comment '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `sys_group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COMMENT '用户组别名',
  `description` varchar(256) comment '用户组备注',
  `status` int default 0 comment '状态 0:正常 1:暂无法使用(暂做扩展)',
  `created_by` varchar(16)  comment '创建人',
  `updated_by` varchar(16)  comment '修改人',
  `ctime` datetime default current_timestamp comment '创建时间',
  `utime` datetime default current_timestamp on update current_timestamp comment '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组';

CREATE TABLE `sys_user_group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uid` bigint comment '用户id',
  `gid` bigint comment '用户组id',
  `created_by` varchar(16)  comment '创建人',
  `updated_by` varchar(16)  comment '修改人',
  `ctime` datetime default current_timestamp comment '创建时间',
  `utime` datetime default current_timestamp on update current_timestamp comment '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户——用户组中间表';

CREATE TABLE `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(16) COMMENT '角色编码',
  `name` varchar(32) COMMENT '角色名称',
  `status` int default 0 comment '状态 0:正常 1:暂无法使用(暂做扩展)',
  `description` varchar(256) comment '用户备注',
  `level` int COMMENT '角色等级',
  `pid` bigint default 0 COMMENT '父角色id',
  `seq` int comment '角色序号',
  `created_by` varchar(16)  comment '创建人',
  `updated_by` varchar(16)  comment '修改人',
  `ctime` datetime default current_timestamp comment '创建时间',
  `utime` datetime default current_timestamp on update current_timestamp comment '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

CREATE TABLE `sys_role_category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rid` bigint COMMENT '角色id',
  `name` varchar(32) COMMENT '角色类别名称',
  `status` int default 0 comment '状态 0:正常 1:暂无法使用(暂做扩展)',
  `description` varchar(256) comment '用户备注',
  `created_by` varchar(16)  comment '创建人',
  `updated_by` varchar(16)  comment '修改人',
  `ctime` datetime default current_timestamp comment '创建时间',
  `utime` datetime default current_timestamp on update current_timestamp comment '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色类别表';


CREATE TABLE `sys_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uid` bigint COMMENT 'user_id',
  `rid` bigint COMMENT 'role_id',
  `created_by` varchar(16)  comment '创建人',
  `updated_by` varchar(16)  comment '修改人',
  `ctime` datetime default current_timestamp comment '创建时间',
  `utime` datetime default current_timestamp on update current_timestamp comment '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';


CREATE TABLE `sys_group_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `gid` bigint COMMENT 'group_id',
  `rid` bigint COMMENT 'role_id',
  `created_by` varchar(16)  comment '创建人',
  `updated_by` varchar(16)  comment '修改人',
  `ctime` datetime default current_timestamp comment '创建时间',
  `utime` datetime default current_timestamp on update current_timestamp comment '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组角色表';


CREATE TABLE `sys_explorer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COMMENT '资源名称',
  `status` int default 0 comment '状态 0:正常 1:暂无法使用(暂做扩展)',
  `description` varchar(256) comment '资源备注',
  `created_by` varchar(16)  comment '创建人',
  `updated_by` varchar(16)  comment '修改人',
  `ctime` datetime default current_timestamp comment '创建时间',
  `utime` datetime default current_timestamp on update current_timestamp comment '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源控制表';

CREATE TABLE `sys_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `eid` bigint comment '资源id',
  `name` varchar(32) COMMENT '菜单名称',
  `icon` varchar(64) comment '菜单矢量图标或地址',
  `status` int default 0 comment '状态 0:正常 1:暂无法使用(暂做扩展)',
  `description` varchar(256) comment '菜单备注',
  `href` varchar(64) comment '菜单连接地址',
  `pid` bigint comment '父菜单id',
  `created_by` varchar(16)  comment '创建人',
  `updated_by` varchar(16)  comment '修改人',
  `ctime` datetime default current_timestamp comment '创建时间',
  `utime` datetime default current_timestamp on update current_timestamp comment '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

CREATE TABLE `sys_interface` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `eid` bigint  comment '资源id',
  `name` varchar(32) COMMENT '接口名称',
  `status` int default 0 comment '状态 0:正常 1:暂无法使用(暂做扩展)',
  `description` varchar(256) comment '资源备注',
  `service_name` varchar(64) comment '接口所属应用',
  `created_by` varchar(16)  comment '创建人',
  `updated_by` varchar(16)  comment '修改人',
  `ctime` datetime default current_timestamp comment '创建时间',
  `utime` datetime default current_timestamp on update current_timestamp comment '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口表';
