-- MySQL Workbench Forward Engineering
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
-- -----------------------------------------------------
-- Schema magasins
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema magasins
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `magasins` DEFAULT CHARACTER SET utf8 ;
USE `magasins` ;
-- -----------------------------------------------------
-- Table `magasins`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `magasins`.`Client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `prenom` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `magasins`.`Categorie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `magasins`.`Categorie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `magasins`.`Produit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `magasins`.`Produit` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `prix` INT NULL,
  `Categorie_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Produit_Categorie1_idx` (`Categorie_id` ASC) VISIBLE,
  CONSTRAINT `fk_Produit_Categorie1`
    FOREIGN KEY (`Categorie_id`)
    REFERENCES `magasins`.`Categorie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `magasins`.`Commande`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `magasins`.`Commande` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Client_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Commande_Client1_idx` (`Client_id` ASC) VISIBLE,
  CONSTRAINT `fk_Commande_Client1`
    FOREIGN KEY (`Client_id`)
    REFERENCES `magasins`.`Client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `magasins`.`Commande_has_Produit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `magasins`.`Commande_has_Produit` (
  `Commande_id` INT NOT NULL,
  `Produit_id` INT NOT NULL,
  PRIMARY KEY (`Commande_id`, `Produit_id`),
  INDEX `fk_Commande_has_Produit_Produit1_idx` (`Produit_id` ASC) VISIBLE,
  INDEX `fk_Commande_has_Produit_Commande_idx` (`Commande_id` ASC) VISIBLE,
  CONSTRAINT `fk_Commande_has_Produit_Commande`
    FOREIGN KEY (`Commande_id`)
    REFERENCES `magasins`.`Commande` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Commande_has_Produit_Produit1`
    FOREIGN KEY (`Produit_id`)
    REFERENCES `magasins`.`Produit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;