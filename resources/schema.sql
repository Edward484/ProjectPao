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

CREATE TABLE `servicedb`.`motherboards` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `modelName` VARCHAR(45) NOT NULL,
    `manufacturer` VARCHAR(45) NOT NULL,
    `powerDrown` INT NOT NULL,
    `socket` VARCHAR(45) NOT NULL,
    `memoryType` VARCHAR(45) NOT NULL,
    `format` VARCHAR(45) NOT NULL,
    `numberOfSata` INT NOT NULL,
    `chipsetName` VARCHAR(45) NOT NULL,
     PRIMARY KEY (`id`));

CREATE TABLE `servicedb`.`mouses` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `modelName` VARCHAR(45) NOT NULL,
    `manufacturer` VARCHAR(45) NOT NULL,
    `connectionInterface` VARCHAR(45) NOT NULL,
    `numberOfButtons` INT NOT NULL,
    `dpi` INT NOT NULL,
    PRIMARY KEY (`id`));

CREATE TABLE `servicedb`.`processors` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `modelName` VARCHAR(45) NOT NULL,
    `manufacturer` VARCHAR(45) NOT NULL,
    `powerDrown` INT NOT NULL,
    `socket` VARCHAR(45) NOT NULL,
    `manufacturingProcess` INT NOT NULL,
    `numberOfCores` INT NOT NULL,
    `numberOfThreads` INT NOT NULL,
    `frequency` INT NOT NULL,
    PRIMARY KEY (`id`));