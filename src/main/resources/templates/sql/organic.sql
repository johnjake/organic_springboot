CREATE TABLE `billing` (
   `id` bigint(19) unsigned NOT NULL AUTO_INCREMENT,
   `first_name` varchar(255),
   `last_name` varchar(255),
   `country` varchar(255),
   `address` varchar(255),
   `town` varchar(255),
   `state` varchar(255),
   `zip_code` varchar(15),
   `phone` varchar(15),
   `email` varchar(75),
   `ship_to_address` boolean,
   `user_id` bigint(19) unsigned DEFAULT NULL,
   PRIMARY KEY (`id`),
   KEY `fk_user_billing` (`user_id`),
   CONSTRAINT `fk_user_billing` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;