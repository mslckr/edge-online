drop table `order`;
drop table `item`;
CREATE TABLE `item` (
  `id` bigint(127) NOT NULL,
  `item_name` varchar(120) NOT NULL,
  `item_cat` varchar(45) DEFAULT NULL,
  `item_price` double NOT NULL,
  `item_inv` int(11) NOT NULL,
  `item_img` varchar(240) NOT NULL,
  `item_rating` double NOT NULL default '0.0',
  `prov_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `prov_id_idx` (`prov_id`),
  CONSTRAINT `prov_id` FOREIGN KEY (`prov_id`) REFERENCES `provider` (`id`)
);
CREATE TABLE `order` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `orderline_id` int(11) NOT NULL,
  `item_id` bigint(200) NOT NULL,
  `amount` int(11) NOT NULL DEFAULT '1',
  `complete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `item_id_idx` (`item_id`),
  CONSTRAINT `item_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
);
insert into item values(1, "Alienware Area-51 Threadripper", "Computer Tower", 2339.99, 4, "placeholder.png",4.6, 1243); 
insert into item values(2, "HP Pavilion Gaming 790-0020 Tower", "Computer Tower", 849.99, 14, "placeholder.png",3.4, 5923); 
insert into item values(3, "Alienware Area-51 Gaming Laptop", "Laptop", 2049.99, 5, "placeholder.png",4.1, 1243); 
insert into item values(4, "Razer BlackWidow Elite Mechanical Gaming Keyboard", "Keyboard", 169.99, 11, "placeholder.png",3.9, 71); 
insert into item values(5, "Razer DeathAdder Elite Gaming Mouse", "Mouse", 69.99, 36, "placeholder.png",2.9, 71); 