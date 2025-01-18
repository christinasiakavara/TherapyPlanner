CREATE TABLE `therplanner` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `username` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Therapists` (
    `therapist_id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255) NOT NULL,
    `title` VARCHAR(255) NOT NULL,
    `approach` VARCHAR(255),
    `bio` TEXT,
    `specialties` TEXT,
    `education` TEXT,
    `training` TEXT,
    `available` BOOLEAN NOT NULL
);

CREATE TABLE UserTherapist (
    `user_id` INT NOT NULL,
    `therapist_id` INT NOT NULL,
    PRIMARY KEY (`user_id`, `therapist_id`),
    FOREIGN KEY (`user_id`) REFERENCES `TherPlanner`(`id`) ON DELETE CASCADE,
    FOREIGN KEY (`therapist_id`) REFERENCES `Therapists`(`therapist_id`) ON DELETE CASCADE
);