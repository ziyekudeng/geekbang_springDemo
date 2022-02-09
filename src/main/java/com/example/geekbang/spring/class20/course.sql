CREATE TABLE `course`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `course_name` varchar(64) DEFAULT NULL,
    `number`      int(11)     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

insert into course (id, course_name, number) VALUES (1,'英语',0);
