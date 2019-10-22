Schema: edge_online_db

CREATE TABLE `provider` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prov_name` varchar(90) NOT NULL,
  `prov_link` varchar(240) NOT NULL,
  `prov_addr` varchar(180) DEFAULT NULL,
  `prov_logo` varchar(240) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
)

CREATE TABLE `item` (
  `id` bigint(127) NOT NULL,
  `item_name` varchar(60) NOT NULL,
  `item_cat` varchar(45) DEFAULT NULL,
  `item_price` double NOT NULL,
  `item_inv` int(11) NOT NULL,
  `item_img` varchar(240) NOT NULL,
  `prov_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `prov_id_idx` (`prov_id`),
  CONSTRAINT `prov_id` FOREIGN KEY (`prov_id`) REFERENCES `provider` (`id`)
)

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
)

CREATE TABLE `order` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `orderline_id` int(11) NOT NULL,
  `item_id` bigint(200) NOT NULL,
  `amount` int(11) NOT NULL DEFAULT '1',
  `complete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `item_id_idx` (`item_id`),
  CONSTRAINT `item_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
)