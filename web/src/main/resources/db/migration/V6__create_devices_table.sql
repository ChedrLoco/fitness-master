CREATE TABLE `fitness`.`devices` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL,
  `serial_number` VARCHAR(45) NOT NULL,
  `product` ENUM('Fitbit', 'Surge') NULL,
  `category` ENUM('Swimming', 'Running', 'Biking') NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_id_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `fitness`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);