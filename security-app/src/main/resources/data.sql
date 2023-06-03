INSERT IGNORE INTO `spring_security_app`.`user` (`id`, `username`, `password`, `algorithm`) VALUES ('1', 'john', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'BCRYPT');

INSERT IGNORE INTO `spring_security_app`.`authority` (`id`, `name`, `user`) VALUES ('1', 'READ', '1');
INSERT IGNORE INTO `spring_security_app`.`authority` (`id`, `name`, `user`) VALUES ('2', 'WRITE', '1');

INSERT IGNORE INTO `spring_security_app`.`product` (`id`, `name`, `price`, `currency`) VALUES ('1', 'Chocolate', '10', 'USD');
INSERT IGNORE INTO `spring_security_app`.`product` (`id`, `name`, `price`, `currency`) VALUES ('2', 'Bread', '29', 'EUR');
INSERT IGNORE INTO `spring_security_app`.`product` (`id`, `name`, `price`, `currency`) VALUES ('3', 'Water', '0.99', 'GBP');
