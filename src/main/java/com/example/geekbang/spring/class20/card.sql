CREATE TABLE `card`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `student_id` int(11) DEFAULT NULL,
    `balance`    int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
