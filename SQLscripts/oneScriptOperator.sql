drop table if exists `order`;
drop table if exists `orderline`;
drop table if exists `item`;
drop table if exists `provider`;
CREATE TABLE `provider` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prov_name` varchar(90) NOT NULL,
  `prov_link` varchar(240) NOT NULL,
  `prov_addr` varchar(180) DEFAULT NULL,
  `prov_logo` varchar(240) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);
CREATE TABLE `item` (
  `id` bigint(127) NOT NULL,
  `item_name` varchar(120) NOT NULL,
  `item_cat` varchar(45) DEFAULT NULL,
  `item_price` double NOT NULL,
  `item_stock` int(11) NOT NULL,
  `item_img` varchar(240) NOT NULL,
  `item_rating` double NOT NULL default '0.0',
  `prov_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `prov_id_idx` (`prov_id`),
  CONSTRAINT `prov_id` FOREIGN KEY (`prov_id`) REFERENCES `provider` (`id`)
);
CREATE TABLE `orderline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(90) NOT NULL,
  `user_addr` varchar(240) NOT NULL,
  `user_card_num` int(11) NOT NULL,
  `user_card_sec` int(11) NOT NULL,
  `user_card_expdate` date NOT NULL,
  `order_stage` int(11) NOT NULL DEFAULT '10',
  `auth_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
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
insert into provider values(1243, "Dell" , "https://www.dell.com/en-us", "Round Rock, Texas, USA", "images/Prov_Dell.png");
insert into provider values(5923, "HP" , "https://hp.com/country/us/en/welcome.html", "Palo Alto, CA, USA", "images/Prov_HP.png");
insert into provider values(71, "Razor" , "https://www.razer.com/Store", "Carlsbad, CA, USA", "images/Prov_Razer.png");
insert into provider values(1,"Team Edge","/about","Basking Ridge, NJ, USA","images/Prov_Team_Edge.png");
insert into item values(1, "Alienware Area-51 Threadripper", "Computer Tower", 2339.99, 4, "images/Area_51_Threadripper.png",4.6, 1243); 
insert into item values(2, "HP Pavilion Gaming 790-0020 Tower", "Computer Tower", 849.99, 14, "images/Pavilion_Tower.png",3.4, 5923); 
insert into item values(3, "Alienware Area-51 Gaming Laptop", "Laptop", 2049.99, 5, "images/Area_51_Laptop.png",4.1, 1243); 
insert into item values(4, "Razer BlackWidow Elite Mechanical Gaming Keyboard", "Keyboard", 169.99, 11, "images/Blackwidow_Elite.png",3.9, 71); 
insert into item values(5, "Razer DeathAdder Elite Gaming Mouse", "Mouse", 69.99, 36, "images/Deathadder_Elite.png",2.9, 71); 
insert into item values(10,"EDGE Online Custom Mousepad","Special",15.99,50,"images/EDGE_MousePad.png",3.7,1)