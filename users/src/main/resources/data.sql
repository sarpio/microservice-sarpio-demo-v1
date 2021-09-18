DROP TABLE IF EXISTS customers;

CREATE TABLE `customers`
(
    `id`         int AUTO_INCREMENT PRIMARY KEY,
    `first_name` varchar(100) NOT NULL,
    `last_name`  varchar(100) NOT NULL,
    `email`      varchar(100) NOT NULL,
    `uuid`       uuid default random_uuid()
);


INSERT INTO `customers` (`first_name`,`last_name`, `email`)
VALUES ('Peter', 'Falk', 'peter.falk@sarpio.com');

INSERT INTO `customers` (`first_name`,`last_name`, `email`)
VALUES ('John', 'Steel', 'john.steel@sarpio.com');

INSERT INTO `customers` (`first_name`,`last_name`, `email`)
VALUES ('Stephen', 'Green', 'stephen.green@sarpio.com');


