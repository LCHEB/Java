drop database if exists shoppingmall;
create database if not exists shoppingmall;

use shoppingmall;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`id`	char(13)	NOT NULL,
	`pw`	varchar(20) not null,
	`email`	varchar(30) not null unique,
	`phone`	varchar(13) not null,
	`Field`	CHAR(2)	unique,
	`fail`	int
);

DROP TABLE IF EXISTS `info`;

CREATE TABLE `info` (
	`info`	varchar(30)	NOT NULL,
	`code`	varchar(15) not null,
	`time`	datetime not null,
	`id`	char(13)	NOT NULL
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`pr-code`	varchar(15)	NOT NULL,
	`pr-name`	varchar(15) not null,
	`pr-content`	longtext not null,
	`pr-pride`	varchar(15) not null,
	`ca-num`	varchar(15)	NOT NULL
);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`ca-num`	varchar(15)	NOT NULL,
	`ca-name`	varchar(15) not null
);

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
	`or-num`	varchar(15)	NOT NULL,
	`or-date`	datetime  not null,
	`or-detail`	varchar(15) not null,
	`or-num2`	int not null,
	`or-money`	int not null,
	`id`	char(13)	NOT NULL,
	`pr-code`	varchar(15)	NOT NULL
);

DROP TABLE IF EXISTS `basket`;

CREATE TABLE `basket` (
	`ba-num`	int	primary key auto_increment,
	`ba-num2`	int not null,
	`id`	char(13)	NOT NULL,
	`pr-code`	varchar(15)	NOT NULL
);

DROP TABLE IF EXISTS `screen`;

CREATE TABLE `screen` (
	`sc-num`	varchar(15)	NOT NULL,
	`sc-name`	varchar(15) not null,
	`pr-code`	varchar(15)	NOT NULL
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`id`
);

ALTER TABLE `info` ADD CONSTRAINT `PK_INFO` PRIMARY KEY (
	`info`
);

ALTER TABLE `product` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
	`pr-code`
);

ALTER TABLE `category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
	`ca-num`
);

ALTER TABLE `order` ADD CONSTRAINT `PK_ORDER` PRIMARY KEY (
	`or-num`
);

ALTER TABLE `screen` ADD CONSTRAINT `PK_SCREEN` PRIMARY KEY (
	`sc-num`
);

ALTER TABLE `info` ADD CONSTRAINT `FK_user_TO_info_1` FOREIGN KEY (
	`id`
)
REFERENCES `user` (
	`id`
);

ALTER TABLE `product` ADD CONSTRAINT `FK_category_TO_product_1` FOREIGN KEY (
	`ca-num`
)
REFERENCES `category` (
	`ca-num`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_user_TO_order_1` FOREIGN KEY (
	`id`
)
REFERENCES `user` (
	`id`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_product_TO_order_1` FOREIGN KEY (
	`pr-code`
)
REFERENCES `product` (
	`pr-code`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_user_TO_basket_1` FOREIGN KEY (
	`id`
)
REFERENCES `user` (
	`id`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_product_TO_basket_1` FOREIGN KEY (
	`pr-code`
)
REFERENCES `product` (
	`pr-code`
);

ALTER TABLE `screen` ADD CONSTRAINT `FK_product_TO_screen_1` FOREIGN KEY (
	`pr-code`
)
REFERENCES `product` (
	`pr-code`
);

