-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sasquatches_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sasquatches_db` ;

-- -----------------------------------------------------
-- Schema sasquatches_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sasquatches_db` DEFAULT CHARACTER SET utf8mb3 ;
USE `sasquatches_db` ;

-- -----------------------------------------------------
-- Table `sasquatches_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sasquatches_db`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sasquatches_db`.`sightings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sasquatches_db`.`sightings` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `location` VARCHAR(255) NULL DEFAULT NULL,
  `what_happened` VARCHAR(255) NULL DEFAULT NULL,
  `date_of_sighting` DATE NULL DEFAULT NULL,
  `num_of_sasquatches` INT NULL DEFAULT NULL,
  `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sightings_users_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_sightings_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `sasquatches_db`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
