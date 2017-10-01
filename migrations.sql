CREATE TABLE `image` (
  `id_image` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id_image`)
);
ALTER TABLE `product` ADD `id_image` INT NOT NULL AFTER `stock`;
ALTER TABLE `product` ADD FOREIGN KEY (`id_image`) REFERENCES `image` (`id_image`);
ALTER TABLE `user` ADD `admin` BOOLEAN NOT NULL DEFAULT '0' AFTER `email`;


--/////////////////////////////////////////////////////////////////////////////////

ALTER TABLE `user` ADD `email` VARCHAR(100) NOT NULL DEFAULT '' AFTER `password`;
ALTER TABLE `user` ADD `` INT NULL DEFAULT NULL AFTER `password`;

ALTER TABLE `order_list` ADD `quantity` INT(11) NOT NULL DEFAULT '0' AFTER `id_product`;
ALTER TABLE `product` CHANGE `price` `price` DECIMAL(17,5) NOT NULL;
