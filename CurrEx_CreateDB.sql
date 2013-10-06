SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP DATABASE CurrExDB;

CREATE SCHEMA IF NOT EXISTS `CurrExDB` DEFAULT CHARACTER SET utf8 ;
USE `CurrExDB` ;

-- -----------------------------------------------------
-- Table `CurrExDB`.`Role`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `CurrExDB`.`Role` (
  `RoleId` INT NOT NULL AUTO_INCREMENT ,
  `RoleName` VARCHAR(20) NOT NULL ,
  `IsActive` TINYINT(1) NOT NULL DEFAULT 1 ,
  PRIMARY KEY (`RoleId`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CurrExDB`.`User`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `CurrExDB`.`User` (
  `UserId` INT NOT NULL AUTO_INCREMENT ,
  `FirstName` VARCHAR(45) NOT NULL ,
  `SecondName` VARCHAR(45) NOT NULL ,
  `NickName` VARCHAR(45) NULL DEFAULT NULL ,
  `Email` VARCHAR(45) NOT NULL ,
  `Phone` INT NULL DEFAULT NULL ,
  `Celll` INT NULL DEFAULT NULL ,
  `Role` VARCHAR(15) NULL DEFAULT NULL ,
  `RoleId` INT NOT NULL ,
  `Password` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`UserId`) ,
  UNIQUE INDEX `idUser_UNIQUE` (`UserId` ASC) ,
  UNIQUE INDEX `NickName_UNIQUE` (`NickName` ASC) ,
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) ,
  UNIQUE INDEX `Phone_UNIQUE` (`Phone` ASC) ,
  UNIQUE INDEX `Celll_UNIQUE` (`Celll` ASC) ,
  INDEX `fk_User_Role1_idx` (`RoleId` ASC) ,
  CONSTRAINT `fk_User_Role1`
    FOREIGN KEY (`RoleId` )
    REFERENCES `CurrExDB`.`Role` (`RoleId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CurrExDB`.`Currency`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `CurrExDB`.`Currency` (
  `CurrencyName` VARCHAR(45) NOT NULL ,
  `CurrencyCountry` VARCHAR(45) NOT NULL ,
  `CurrencyId` INT NOT NULL ,
  `CurrencySign` CHAR NULL DEFAULT NULL ,
  `CurrancyAbb` VARCHAR(15) NOT NULL ,
  PRIMARY KEY (`CurrencyId`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CurrExDB`.`Account`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `CurrExDB`.`Account` (
  `AccountNumber` INT NOT NULL AUTO_INCREMENT ,
  `IsPremium` TINYINT(1) NOT NULL DEFAULT 1 ,
  `StartDate` DATETIME NULL DEFAULT NULL ,
  `ExpirationDate` DATETIME NULL DEFAULT NULL ,
  `IsActive` TINYINT(1) NOT NULL DEFAULT 1 ,
  `Debit` DECIMAL(64,2) NOT NULL DEFAULT 0 ,
  `UserId` INT NOT NULL ,
  `CurrencyId` INT NOT NULL ,
  PRIMARY KEY (`AccountNumber`) ,
  UNIQUE INDEX `Number_UNIQUE` (`AccountNumber` ASC) ,
  INDEX `fk_Account_User1_idx` (`UserId` ASC) ,
  INDEX `fk_Account_Currency1_idx` (`CurrencyId` ASC) ,
  CONSTRAINT `fk_Account_User1`
    FOREIGN KEY (`UserId` )
    REFERENCES `CurrExDB`.`User` (`UserId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Account_Currency1`
    FOREIGN KEY (`CurrencyId` )
    REFERENCES `CurrExDB`.`Currency` (`CurrencyId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CurrExDB`.`ExchangeOrder`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `CurrExDB`.`ExchangeOrder` (
  `UserId` INT NOT NULL ,
  `OrderId` BIGINT NOT NULL AUTO_INCREMENT ,
  `IsActive` TINYINT(1) NOT NULL DEFAULT 1 ,
  `StartTime` DATETIME NOT NULL ,
  `EndTime` DATETIME NOT NULL ,
  `PartialExchangeAllowed` TINYINT(1) NOT NULL DEFAULT 1 ,
  `OrderAmount` DECIMAL(64,2) NOT NULL ,
  `MinOrderAmount` DECIMAL(64,2) NULL DEFAULT NULL ,
  `Rate` DECIMAL(40,10) NOT NULL ,
  `AccountNumber` INT NOT NULL ,
  `CurrencyId` INT NOT NULL ,
  PRIMARY KEY (`OrderId`) ,
  INDEX `fk_ExchangeOrder_Account1_idx` (`AccountNumber` ASC, `CurrencyId` ASC) ,
  INDEX `fk_ExchangeOrder_User1` (`UserId` ASC) ,
  CONSTRAINT `fk_ExchangeOrder_User1`
    FOREIGN KEY (`UserId` )
    REFERENCES `CurrExDB`.`User` (`UserId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ExchangeOrder_Account1`
    FOREIGN KEY (`AccountNumber` )
    REFERENCES `CurrExDB`.`Account` (`AccountNumber` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CurrExDB`.`TransactionHistory`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `CurrExDB`.`TransactionHistory` (
  `OrderId` BIGINT NOT NULL ,
  `TransactionId` BIGINT NOT NULL AUTO_INCREMENT ,
  INDEX `fk_TransactionHistory_ExchangeOrder1_idx` (`OrderId` ASC) ,
  PRIMARY KEY (`TransactionId`) ,
  CONSTRAINT `fk_TransactionHistory_ExchangeOrder1`
    FOREIGN KEY (`OrderId` )
    REFERENCES `CurrExDB`.`ExchangeOrder` (`OrderId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CurrExDB`.`UserAddress`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `CurrExDB`.`UserAddress` (
  `Country` VARCHAR(45) NOT NULL ,
  `State/Region` VARCHAR(45) NULL DEFAULT NULL ,
  `City` VARCHAR(45) NOT NULL ,
  `Address1` VARCHAR(45) NOT NULL ,
  `Address2` VARCHAR(45) NULL DEFAULT NULL ,
  `ZIP` VARCHAR(45) NULL DEFAULT NULL ,
  `UserId` INT NOT NULL ,
  PRIMARY KEY (`UserId`) ,
  CONSTRAINT `fk_UserAddress_User1`
    FOREIGN KEY (`UserId` )
    REFERENCES `CurrExDB`.`User` (`UserId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CurrExDB`.`UserSettings`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `CurrExDB`.`UserSettings` (
  `UserId` INT NOT NULL ,
  PRIMARY KEY (`UserId`) ,
  CONSTRAINT `fk_UserSettings_User1`
    FOREIGN KEY (`UserId` )
    REFERENCES `CurrExDB`.`User` (`UserId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `CurrExDB` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
