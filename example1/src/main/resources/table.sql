CREATE TABLE `t_order_1` (
	`order_id` BIGINT(20) NOT NULL COMMENT '主键',
	`user_id` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '用户 id',
	`total_price` DECIMAL(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单价格',
	`state` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '订单状态',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
	PRIMARY KEY (`order_id`),
	INDEX `user_id` (`user_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `t_order_2` (
	`order_id` BIGINT(20) NOT NULL COMMENT '主键',
	`user_id` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '用户 id',
	`total_price` DECIMAL(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单价格',
	`state` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '订单状态',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
	PRIMARY KEY (`order_id`),
	INDEX `user_id` (`user_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
