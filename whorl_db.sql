
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单表主键,标记唯一列自增',
  `parentId` bigint(20) DEFAULT NULL COMMENT '父级菜单编号.如果没有父级则父级为0',
  `menuUrl` varchar(255) DEFAULT NULL COMMENT '菜单Url',
  `menuName` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `permissionId` bigint(20) DEFAULT NULL COMMENT '关联权限表',
  `order` int(11) DEFAULT NULL COMMENT '菜单排序(同级)',
  `status` varchar(255) DEFAULT NULL COMMENT '状态EBL-可用,DBL-不可用',
  `applicationCode` varchar(255) DEFAULT NULL COMMENT '不同应用菜单的区分',
  `createAt` datetime DEFAULT NULL,
  `createBy` varchar(255) DEFAULT NULL,
  `modifyAt` datetime DEFAULT NULL,
  `modifyBy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `tid` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号,自增',
  `permissionName` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `functionNumber` varchar(11) DEFAULT NULL COMMENT '权限代码',
  `createAt` datetime DEFAULT NULL,
  `createBy` varchar(255) DEFAULT NULL,
  `modifyAt` datetime DEFAULT NULL,
  `modifyBy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `tid` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号,自增',
  `parentId` bigint(11) DEFAULT NULL COMMENT '父级角色编号',
  `roleName` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `createAt` datetime DEFAULT NULL,
  `createBy` varchar(255) DEFAULT NULL,
  `modifyAt` datetime DEFAULT NULL,
  `modifyBy` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL COMMENT 'EBL-可用,DBL-不可用',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rolepermission
-- ----------------------------
DROP TABLE IF EXISTS `rolepermission`;
CREATE TABLE `rolepermission` (
  `tid` bigint(11) NOT NULL AUTO_INCREMENT,
  `roleId` bigint(11) DEFAULT NULL COMMENT '角色编号',
  `permissionId` bigint(11) DEFAULT NULL COMMENT '权限Id',
  `status` varchar(255) DEFAULT NULL COMMENT '状态EBL-可用,DBL-不可用',
  `createAt` datetime DEFAULT NULL,
  `createBy` varchar(255) DEFAULT NULL,
  `modifyAt` datetime DEFAULT NULL,
  `modifyBy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `tid` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '记录标识,自增',
  `loginName` varchar(255) NOT NULL COMMENT '登陆账号,不为空',
  `passWord` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `userName` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `mobile` varchar(255) DEFAULT NULL COMMENT '用户手机号',
  `email` varchar(255) DEFAULT NULL COMMENT '用户时间',
  `createAt` datetime DEFAULT NULL,
  `createBy` varchar(255) DEFAULT NULL,
  `modifyAt` datetime DEFAULT NULL,
  `modifyBy` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL COMMENT 'EBL-可用,DBL-不可用',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userrole
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `tid` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户校色主编号,自增',
  `userId` bigint(11) DEFAULT NULL COMMENT '用户编号',
  `roleId` bigint(11) DEFAULT NULL COMMENT '角色编号',
  `status` varchar(255) DEFAULT NULL COMMENT '状态EBL-可用,DBL-不可用',
  `createAt` datetime DEFAULT NULL,
  `createBy` varchar(255) DEFAULT NULL,
  `modifyAt` datetime DEFAULT NULL,
  `modifyBy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
