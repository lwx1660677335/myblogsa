/*
 Navicat Premium Data Transfer

 Source Server         : testProject_localhost
 Source Server Type    : MySQL
 Source Server Version : 50559
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50559
 File Encoding         : 65001

 Date: 18/08/2019 11:35:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permissiongroups
-- ----------------------------
DROP TABLE IF EXISTS `permissiongroups`;
CREATE TABLE `permissiongroups`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '权限表ID',
  `permissionKey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限表主键',
  `permissionName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `permissionCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限编码',
  `permissionNumber` int(255) NULL DEFAULT NULL COMMENT '权限编号',
  `permissionURL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of permissiongroups
-- ----------------------------
INSERT INTO `permissiongroups` VALUES (1, '000000535005413', '菜单栏查看权限', 'del', 1, NULL);
INSERT INTO `permissiongroups` VALUES (2, '000000842416447', '删除权限', 'admin:del', 2, NULL);
INSERT INTO `permissiongroups` VALUES (3, '000001769565922\r\n000000399633993', '添加权限', NULL, 3, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleKey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主键主键',
  `rolename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `roleCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编码',
  `roleCreteTime` datetime NULL DEFAULT NULL COMMENT '角色创建日期',
  `roleUpteTime` datetime NULL DEFAULT NULL COMMENT '角色修改日期',
  `roleUpteEndName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色修改人名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '000001347989950', 'admin', NULL, '2019-08-13 09:22:15', '2019-08-13 09:22:24', '李四');
INSERT INTO `role` VALUES (2, '000000860958988', 'manager', NULL, '2019-08-13 09:22:18', '2019-08-13 09:22:15', '李四');
INSERT INTO `role` VALUES (3, '000001457200138', 'normal', NULL, '2019-08-13 09:22:21', '2019-08-13 09:22:15', '李四');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sys_userKey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户主键',
  `sys_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `sys_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '密码',
  `sys_crete_time` datetime NOT NULL COMMENT '创建日期',
  `sys_end_time` datetime NOT NULL COMMENT '最后登陆日期',
  `sys_corresponding_power` int(255) UNSIGNED NULL DEFAULT 0 COMMENT '对应权限ID',
  `sys_power_start` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '权限启用状态',
  `sys_admin_start` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '是否是管理员',
  `sys_admin_power` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '管理员对应的权限ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_1`(`sys_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '000000029366472', '李四', '0', '2019-07-08 21:17:26', '2019-07-08 21:17:30', 0, '0', '0', '000000029366472');

-- ----------------------------
-- Table structure for t_role_permissiongroups
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permissiongroups`;
CREATE TABLE `t_role_permissiongroups`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idKey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '主键ID',
  `roleIdKey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色权限',
  `permissiongroupsKey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_role_permissiongroups
-- ----------------------------
INSERT INTO `t_role_permissiongroups` VALUES (1, '', '000001347989950', '000000535005413');
INSERT INTO `t_role_permissiongroups` VALUES (2, '', '000001347989950', '000000842416447');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idKey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, '000001592871925', '000000029366472', '000001347989950');
INSERT INTO `t_user_role` VALUES (3, 'asdsd', '000000029366472', '000000860958988');

SET FOREIGN_KEY_CHECKS = 1;
