create database serviceDB;
use serviceDB;

CREATE TABLE `servicedb`.`new_table` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `layout` VARCHAR(45) NULL,
    `isMechanical` TINYINT NULL,
    `connectionInterface` VARCHAR(45) NOT NULL,
    `modelName` VARCHAR(45) NOT NULL,
    `manufacturer` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`));