drop database if exists shoppingmall2;
create database if not exists shoppingmall2;

use shoppingmall2;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`id`	varchar(13)	primary key,
	`pw`	varchar(20) not null,
	`email`	varchar(30) not null,
	`phone`	varchar(13) not null,
	`authority`	varchar(10) not null default "user",
	`count`	int not null default 0
);

DROP TABLE IF EXISTS `info`;

CREATE TABLE `info` (
	`info`	int	primary key,
	`code`	char(6) not null,
	`time`	datetime not null,
	`info_id`	varchar(13)	NOT NULL
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`pr_code`	varchar(15)	primary key,
	`pr_name`	varchar(50) not null,
	`pr_content`	longtext not null,
	`pr_pride`	int not null default 0,
	`pr_ca_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`ca_num`	int	primary key,
	`ca_name`	varchar(10) not null
);

DROP TABLE IF EXISTS `basket`;

CREATE TABLE `basket` (
	`ba_num`	int	primary key,
	`ba_num2`	int not null default 0,
	`ba_id`	varchar(13)	NOT NULL,
	`ba_pr_code`	varchar(15)	NOT NULL
);

DROP TABLE IF EXISTS `screen`;

CREATE TABLE `screen` (
	`sc_num`	int	primary key,
	`sc_name`	varchar(50)	NULL,
	`sc_pr_code`	varchar(15)	NOT NULL
);

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
	`or_num`	int	primary key auto_increment,
	`or_date`	datetime  not null default current_timestamp,
	`or_detail`	varchar(10) not null default "결제완료",
	`or_num2`	int not null default 0,
	`or_money`	int not null,
	`or_id`	varchar(13)	NOT NULL,
	`or_pr_code`	varchar(15)	NOT NULL
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`id`
);

ALTER TABLE `info` ADD CONSTRAINT `PK_INFO` PRIMARY KEY (
	`info`
);

ALTER TABLE `product` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
	`pr_code`
);

ALTER TABLE `category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
	`ca_num`
);

ALTER TABLE `basket` ADD CONSTRAINT `PK_BASKET` PRIMARY KEY (
	`ba_num`
);

ALTER TABLE `screen` ADD CONSTRAINT `PK_SCREEN` PRIMARY KEY (
	`sc_num`
);

ALTER TABLE `order` ADD CONSTRAINT `PK_ORDER` PRIMARY KEY (
	`or_num`
);

ALTER TABLE `info` ADD CONSTRAINT `FK_user_TO_info_1` FOREIGN KEY (
	`info_id`
)
REFERENCES `user` (
	`id`
);

ALTER TABLE `product` ADD CONSTRAINT `FK_category_TO_product_1` FOREIGN KEY (
	`pr_ca_num`
)
REFERENCES `category` (
	`ca_num`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_user_TO_basket_1` FOREIGN KEY (
	`ba_id`
)
REFERENCES `user` (
	`id`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_product_TO_basket_1` FOREIGN KEY (
	`ba_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `screen` ADD CONSTRAINT `FK_product_TO_screen_1` FOREIGN KEY (
	`sc_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_user_TO_order_1` FOREIGN KEY (
	`or_id`
)
REFERENCES `user` (
	`id`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_product_TO_order_1` FOREIGN KEY (
	`or_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

