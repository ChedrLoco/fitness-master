CREATE TABLE `fitness`.`positions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL,
  `latitude` DECIMAL(10,7) NULL,
  `longitude` DECIMAL(10,7) NULL,
  `altitude` DECIMAL(10,7) NULL,
  `current_time` TIMESTAMP NOT NULL DEFAULT NOW(),
  `run_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_run_id_idx` (`run_id` ASC),
  CONSTRAINT `fk_run_id`
    FOREIGN KEY (`run_id`)
    REFERENCES `fitness`.`runs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
