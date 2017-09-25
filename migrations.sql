ALTER TABLE `user` ADD `email` VARCHAR(100) NOT NULL DEFAULT '' AFTER `password`;
ALTER TABLE `user` ADD `` INT NULL DEFAULT NULL AFTER `password`;

ALTER TABLE `order_list` ADD `quantity` INT(11) NOT NULL DEFAULT '0' AFTER `id_product`;
ALTER TABLE `product` CHANGE `price` `price` DECIMAL(17,5) NOT NULL;
