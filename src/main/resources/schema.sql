DROP TABLE IF EXISTS `serial_killer`;

CREATE TABLE `serial_killer` (
	`id` BIGINT AUTO_INCREMENT,
	`first_name` VARCHAR(255) NOT NULL,
	`last_name` VARCHAR(255) NOT NULL,
	`place` VARCHAR(255) NOT NULL,
	`confirmed_kills` INT NOT NULL,
	`zodiac_sign` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
	);