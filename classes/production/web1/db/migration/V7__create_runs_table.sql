CREATE TABLE `fitness`.`runs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL,
  `start_time` TIMESTAMP NOT NULL DEFAULT NOW(),
  `stop_time` TIMESTAMP NULL,
  `device_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_device_id_idx` (`device_id` ASC),
  CONSTRAINT `fk_device_id`
    FOREIGN KEY (`device_id`)
    REFERENCES `fitness`.`devices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);