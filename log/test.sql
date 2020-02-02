/*
 Navicat Premium Data Transfer

 Source Server         : myproject
 Source Server Type    : MySQL
 Source Server Version : 50559
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50559
 File Encoding         : 65001

 Date: 03/02/2020 00:42:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aa
-- ----------------------------
DROP TABLE IF EXISTS `aa`;
CREATE TABLE `aa`  (
  `permissionKey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限表主键'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of aa
-- ----------------------------
INSERT INTO `aa` VALUES ('000000535005413');
INSERT INTO `aa` VALUES ('000000842416447');
INSERT INTO `aa` VALUES ('000000842417546');
INSERT INTO `aa` VALUES ('000000321478568');
INSERT INTO `aa` VALUES ('000001940725034');
INSERT INTO `aa` VALUES ('000000050676655');
INSERT INTO `aa` VALUES ('000000832683632');
INSERT INTO `aa` VALUES ('000000993065919');
INSERT INTO `aa` VALUES ('000000340876385');
INSERT INTO `aa` VALUES ('000001243687027');
INSERT INTO `aa` VALUES ('000001169939296');
INSERT INTO `aa` VALUES ('000000408038861');
INSERT INTO `aa` VALUES ('000001648931571');
INSERT INTO `aa` VALUES ('000001629217296');
INSERT INTO `aa` VALUES ('000000466463505');
INSERT INTO `aa` VALUES ('000000383206620');
INSERT INTO `aa` VALUES ('000001237192899');
INSERT INTO `aa` VALUES ('000001853945985');
INSERT INTO `aa` VALUES ('000001568584604');
INSERT INTO `aa` VALUES ('000001404195360');
INSERT INTO `aa` VALUES ('000000733066041');
INSERT INTO `aa` VALUES ('000001537180547');
INSERT INTO `aa` VALUES ('000001640347693');
INSERT INTO `aa` VALUES ('000000245661432');
INSERT INTO `aa` VALUES ('000000638854618');
INSERT INTO `aa` VALUES ('000001951432768');
INSERT INTO `aa` VALUES ('000000496106894');
INSERT INTO `aa` VALUES ('000000233617007');
INSERT INTO `aa` VALUES ('000000451920009');
INSERT INTO `aa` VALUES ('000001071675853');
INSERT INTO `aa` VALUES ('000000219653999');
INSERT INTO `aa` VALUES ('000002064634502');
INSERT INTO `aa` VALUES ('000000076659855');
INSERT INTO `aa` VALUES ('000000769192847');
INSERT INTO `aa` VALUES ('000002104791428');
INSERT INTO `aa` VALUES ('000001823119039');
INSERT INTO `aa` VALUES ('000000756191472');
INSERT INTO `aa` VALUES ('000001396402649');
INSERT INTO `aa` VALUES ('000000797648918');
INSERT INTO `aa` VALUES ('000001930532514');

-- ----------------------------
-- Table structure for departmentname
-- ----------------------------
DROP TABLE IF EXISTS `departmentname`;
CREATE TABLE `departmentname`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `departmentName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of departmentname
-- ----------------------------
INSERT INTO `departmentname` VALUES ('000000029366472', '销售部门');
INSERT INTO `departmentname` VALUES ('000000029366473', '总经办');

-- ----------------------------
-- Table structure for pageparameters
-- ----------------------------
DROP TABLE IF EXISTS `pageparameters`;
CREATE TABLE `pageparameters`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `projectName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '页面名称',
  `pageNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '页面起始位置',
  `pageSizeNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '页面起始数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pageparameters
-- ----------------------------
INSERT INTO `pageparameters` VALUES ('1', '人员信息显示', '1', '5');

-- ----------------------------
-- Table structure for permissiongroups
-- ----------------------------
DROP TABLE IF EXISTS `permissiongroups`;
CREATE TABLE `permissiongroups`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '权限表ID',
  `permissionKey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限表主键',
  `permissionName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限菜单栏名称',
  `permissionCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限编码',
  `permissionNumber` int(255) NULL DEFAULT NULL COMMENT '权限编号',
  `permissionURL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限地址',
  `permissionFaterNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限菜单栏父级标签',
  `permissionSonNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限菜单栏子集',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `TK_permissionKey`(`permissionKey`) USING BTREE,
  INDEX `TK_permissionFaterNumber`(`permissionFaterNumber`) USING BTREE,
  INDEX `TK_permissionSonNumber`(`permissionSonNumber`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of permissiongroups
-- ----------------------------
INSERT INTO `permissiongroups` VALUES (1, '000000535005413', '用户管理', 'user:view', 1, NULL, '0', '000000535005413');
INSERT INTO `permissiongroups` VALUES (2, '000000842416447', '人员信息', 'user:view', 2, './sysUser/user_message', '000000535005413', '000000842416447');
INSERT INTO `permissiongroups` VALUES (3, '000000842417546', '权限分配', 'user:view', 3, './sysRole/index', '000000535005413', '000000842417546');
INSERT INTO `permissiongroups` VALUES (4, '000000321478568', '组织架构管理', 'user:view', 4, './sysDepartment/index', '000000535005413', '000000321478568');
INSERT INTO `permissiongroups` VALUES (5, '000001940725034', '系统参数设置', 'user:view', 5, NULL, '000000535005413', '000001940725034');
INSERT INTO `permissiongroups` VALUES (6, '000000050676655', '供应商管理', 'user:view', 1, NULL, '0', '000000050676655');
INSERT INTO `permissiongroups` VALUES (7, '000000832683632', '商品入库', 'user:view', 2, './stockIn/index', '000000050676655', '000000832683632');
INSERT INTO `permissiongroups` VALUES (8, '000000993065919', '商品出库', 'user:view', 3, './stockOut/index', '000000050676655', '000000993065919');
INSERT INTO `permissiongroups` VALUES (9, '000000340876385', '采购订单', 'user:view', 4, NULL, '000000050676655', '000000340876385');
INSERT INTO `permissiongroups` VALUES (10, '000001243687027', '采购单', 'user:view', 5, NULL, '000000050676655', '000001243687027');
INSERT INTO `permissiongroups` VALUES (11, '000001169939296', '采购退货', 'user:view', 6, NULL, '000000050676655', '000001169939296');
INSERT INTO `permissiongroups` VALUES (12, '000000408038861', '库存盘点', 'user:view', 7, NULL, '000000050676655', '000000408038861');
INSERT INTO `permissiongroups` VALUES (13, '000001648931571', '配送签收状态', 'user:view', 8, NULL, '000000050676655', '000001648931571');
INSERT INTO `permissiongroups` VALUES (14, '000001629217296', '库存查询', 'user:view', 9, NULL, '000000050676655', '000001629217296');
INSERT INTO `permissiongroups` VALUES (15, '000000466463505', '厂商管理', 'user:view', 1, NULL, '0', '000000466463505');
INSERT INTO `permissiongroups` VALUES (16, '000000383206620', '供货订单', 'user:view', 2, NULL, '000000466463505', '000000383206620');
INSERT INTO `permissiongroups` VALUES (17, '000001237192899', '供货单', 'user:view', 3, NULL, '000000466463505', '000001237192899');
INSERT INTO `permissiongroups` VALUES (18, '000001853945985', '商品供货入库', 'user:view', 4, NULL, '000000466463505', '000001853945985');
INSERT INTO `permissiongroups` VALUES (19, '000001568584604', '商品供货出库', 'user:view', 5, NULL, '000000466463505', '000001568584604');
INSERT INTO `permissiongroups` VALUES (20, '000001404195360', '供应商信息字典维护', 'user:view', 6, NULL, '000000466463505', '000001404195360');
INSERT INTO `permissiongroups` VALUES (21, '000000733066041', '商品信息字典维护', 'user:view', 7, NULL, '000000466463505', '000000733066041');
INSERT INTO `permissiongroups` VALUES (22, '000001537180547', '商品配送签收状态', 'user:view', 8, NULL, '000000466463505', '000001537180547');
INSERT INTO `permissiongroups` VALUES (23, '000001640347693', '零售客户管理', 'user:view', 1, NULL, '0', '000001640347693');
INSERT INTO `permissiongroups` VALUES (24, '000000245661432', '采购订单', 'user:view', 2, NULL, '000001640347693', '000000245661432');
INSERT INTO `permissiongroups` VALUES (25, '000000638854618', '采购单', 'user:view', 3, NULL, '000001640347693', '000000638854618');
INSERT INTO `permissiongroups` VALUES (26, '000001951432768', '商品入库', 'user:view', 4, NULL, '000001640347693', '000001951432768');
INSERT INTO `permissiongroups` VALUES (27, '000000496106894', '商品供应', 'user:view', 5, NULL, '000001640347693', '000000496106894');
INSERT INTO `permissiongroups` VALUES (28, '000000233617007', '收货确认', 'user:view', 6, NULL, '000001640347693', '000000233617007');
INSERT INTO `permissiongroups` VALUES (29, '000000451920009', '业务分析报表', 'user:view', 1, NULL, '0', '000000451920009');
INSERT INTO `permissiongroups` VALUES (30, '000001071675853', '库存明细报表', 'user:view', 2, NULL, '000000451920009', '000001071675853');
INSERT INTO `permissiongroups` VALUES (31, '000000219653999', '供应商供应明细报表', 'user:view', 3, NULL, '000000451920009', '000000219653999');
INSERT INTO `permissiongroups` VALUES (32, '000002064634502', '零售商采购明细报表', 'user:view', 4, NULL, '000000451920009', '000002064634502');
INSERT INTO `permissiongroups` VALUES (33, '000000076659855', '结算明细报表', 'user:view', 5, NULL, '000000451920009', '000000076659855');
INSERT INTO `permissiongroups` VALUES (34, '000000769192847', '未完成业务明细报表', 'user:view', 6, NULL, '000000451920009', '000000769192847');
INSERT INTO `permissiongroups` VALUES (35, '000002104791428', '财务管理', 'user:view', 1, NULL, '0', '000002104791428');
INSERT INTO `permissiongroups` VALUES (36, '000001823119039', '收款单', 'user:view', 2, NULL, '000002104791428', '000001823119039');
INSERT INTO `permissiongroups` VALUES (37, '000000756191472', '赊销单', 'user:view', 3, NULL, '000002104791428', '000000756191472');
INSERT INTO `permissiongroups` VALUES (38, '000001396402649', '每日财务明细', 'user:view', 4, NULL, '000002104791428', '000001396402649');
INSERT INTO `permissiongroups` VALUES (39, '000000797648918', '结算明细报表', 'user:view', 5, NULL, '000002104791428', '000000797648918');
INSERT INTO `permissiongroups` VALUES (40, '000001930532514', '未完成业务明细报表', 'user:view', 6, NULL, '000002104791428', '000001930532514');
INSERT INTO `permissiongroups` VALUES (41, '000001930532515', '基础设置', 'user:view', 1, NULL, '0', '000001930532515');
INSERT INTO `permissiongroups` VALUES (42, '000001930532516', '支付方式', 'user:view', 2, NULL, '000001930532515', '000001930532516');
INSERT INTO `permissiongroups` VALUES (43, '000001930532517', '往来客户', 'user:view', 3, NULL, '000001930532515', '000001930532517');
INSERT INTO `permissiongroups` VALUES (44, '000001930532518', '商品管理', 'user:view', 4, NULL, '000001930532515', '000001930532518');

-- ----------------------------
-- Table structure for pub_menu
-- ----------------------------
DROP TABLE IF EXISTS `pub_menu`;
CREATE TABLE `pub_menu`  (
  `menu_Id` int(11) UNSIGNED NOT NULL COMMENT '菜单栏ID',
  `menu_Number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单栏编号',
  `menu_Name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单栏名称',
  PRIMARY KEY (`menu_Id`, `menu_Number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_key`(`roleKey`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '000001347989950', 'admin', NULL, '2019-08-13 09:22:15', '2019-08-13 09:22:24', '李四');
INSERT INTO `role` VALUES (2, '000000860958988', 'manager', NULL, '2019-08-13 09:22:18', '2019-08-13 09:22:15', '李四');
INSERT INTO `role` VALUES (3, '000001457200138', 'user', NULL, '2019-08-13 09:22:21', '2019-08-13 09:22:15', '李四');
INSERT INTO `role` VALUES (4, '000001457200137', '销售人员', NULL, '2020-01-27 16:20:09', '2020-01-27 16:20:13', 'admin');

-- ----------------------------
-- Table structure for sys_commodity
-- ----------------------------
DROP TABLE IF EXISTS `sys_commodity`;
CREATE TABLE `sys_commodity`  (
  `commodity_Id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `libraryID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库位ID',
  `commodityName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名',
  `commodityCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品编码',
  `commodityType` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品类型',
  `commodityModel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品型号',
  `commoditySpecs` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品规格',
  `commodityName1` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品别名',
  `SupplierID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商',
  `commodityStock` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '库存数量',
  `commodityStockState` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '可用库存数量',
  `commodityCompany` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `purchasePrice` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '采购价',
  `stockPrice` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '商品零售价',
  `commodityRemind` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最低警戒值',
  `commodityCreteTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `backlog` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '货物积压仓提醒',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`commodity_Id`) USING BTREE,
  INDEX `commodity_Id`(`commodity_Id`) USING BTREE,
  INDEX `libraryID`(`libraryID`) USING BTREE,
  INDEX `commodityName`(`commodityName`) USING BTREE,
  INDEX `commodityName1`(`commodityType`, `commodityName1`, `SupplierID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_commodity
-- ----------------------------
INSERT INTO `sys_commodity` VALUES ('111111', NULL, '商品1', NULL, NULL, NULL, NULL, NULL, '112335', '12', '12', '1335', 12.57, 12.57, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_company
-- ----------------------------
DROP TABLE IF EXISTS `sys_company`;
CREATE TABLE `sys_company`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `companyName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品单位',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id`, `companyName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品单位表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_company
-- ----------------------------
INSERT INTO `sys_company` VALUES ('1335', '件', NULL);

-- ----------------------------
-- Table structure for sys_customer
-- ----------------------------
DROP TABLE IF EXISTS `sys_customer`;
CREATE TABLE `sys_customer`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `customerType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户类型',
  `customerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户名称',
  `customerUser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `customerPhone` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户电话',
  `customerAdress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户地址信息',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id`, `customerName`, `customerUser`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_customer
-- ----------------------------
INSERT INTO `sys_customer` VALUES ('112335', '供应商', 'xxx供应商', '刘文祥', '1231231', 'xxxx', NULL);

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `departmentName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `department_id`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_department
-- ----------------------------
INSERT INTO `sys_department` VALUES ('29366472', '销售部门');
INSERT INTO `sys_department` VALUES ('29366473', '总经办');

-- ----------------------------
-- Table structure for sys_factory_fibrary
-- ----------------------------
DROP TABLE IF EXISTS `sys_factory_fibrary`;
CREATE TABLE `sys_factory_fibrary`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `factoryLibrary

Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '仓库名称',
  `factoryLibrary

CreteDate` datetime NULL DEFAULT NULL COMMENT '仓库创建日期',
  `factoryLibrary

CretePeople` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库创建人',
  `remarks` varchar(70) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_reservoirarea
-- ----------------------------
DROP TABLE IF EXISTS `sys_reservoirarea`;
CREATE TABLE `sys_reservoirarea`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '库区主键',
  `factoryLibraryId` varbinary(255) NOT NULL COMMENT '仓库ID',
  `libraryName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '库区名称',
  `libraryCreteDate` date NULL DEFAULT NULL COMMENT '库区创建日期',
  `libraryCretePeople` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库区创建人',
  `remarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库区备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库区表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_storehouse
-- ----------------------------
DROP TABLE IF EXISTS `sys_storehouse`;
CREATE TABLE `sys_storehouse`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `factoryLibraryId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库区ID',
  `storeHouseName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '库位名称',
  `storeHouseCreteDate` datetime NULL DEFAULT NULL COMMENT '库位创建日期',
  `storeHouseCretePeople` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库位创建人',
  `storeHouseType` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库位所属类型',
  `remarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库位' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sys_userKey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户主键',
  `sys_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `sys_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '密码',
  `sys_gender` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `sys_crete_time` datetime NOT NULL COMMENT '创建日期',
  `sys_end_time` datetime NOT NULL COMMENT '最后登陆日期',
  `sys_corresponding_power` int(255) UNSIGNED NULL DEFAULT 0 COMMENT '对应权限ID',
  `sys_power_start` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '权限启用状态',
  `sys_admin_start` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '是否是管理员',
  `sys_admin_power` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '管理员对应的权限ID',
  `sys_discontinued_state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '账户停用状态',
  `sys_locked_state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '锁定状态',
  `sys_department` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `sys_telepthone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `sys_adress` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `sys_spanned` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否允许跨仓操作',
  `sys_access` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否允许别人访问数据',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_1`(`sys_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '123', '王五', '0', '男', '2020-01-27 16:35:13', '2020-01-27 16:35:16', 0, '0', '0', '0', '0', '0', '29366472', '5312313', '123', '0', '0');

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
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与功能关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_role_permissiongroups
-- ----------------------------
INSERT INTO `t_role_permissiongroups` VALUES (1, '', '000001347989950', '000000535005413');
INSERT INTO `t_role_permissiongroups` VALUES (2, '', '000001347989950', '000000842416447');
INSERT INTO `t_role_permissiongroups` VALUES (3, '', '000001347989950', '000000842417546');
INSERT INTO `t_role_permissiongroups` VALUES (4, '', '000001347989950', '000000321478568');
INSERT INTO `t_role_permissiongroups` VALUES (5, '', '000001347989950', '000001940725034');
INSERT INTO `t_role_permissiongroups` VALUES (6, '', '000001347989950', '000000050676655');
INSERT INTO `t_role_permissiongroups` VALUES (7, '', '000001347989950', '000000466463505');
INSERT INTO `t_role_permissiongroups` VALUES (8, '', '000001347989950', '000000832683632');
INSERT INTO `t_role_permissiongroups` VALUES (9, '', '000001347989950', '000000993065919');
INSERT INTO `t_role_permissiongroups` VALUES (10, '', '000001347989950', '000001930532515');
INSERT INTO `t_role_permissiongroups` VALUES (11, '', '000001347989950', '000001930532516');
INSERT INTO `t_role_permissiongroups` VALUES (12, '', '000001347989950', '000001930532517');
INSERT INTO `t_role_permissiongroups` VALUES (13, '', '000001347989950', '000001930532518');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idKey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_key`(`idKey`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与角色关联表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
