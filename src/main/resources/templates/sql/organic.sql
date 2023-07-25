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

CREATE TABLE `users` (
     `id` bigint(19) UNSIGNED NOT NULL,
     `first_name` varchar(50) NOT NULL,
     `last_name` varchar(50) NOT NULL,
     `username` varchar(50) NOT NULL,
     `password` varchar(100) NOT NULL,
     `email` varchar(100) NOT NULL,
     `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
     `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `supplier` (
   `id` bigint(19) unsigned NOT NULL AUTO_INCREMENT,
   `supplier_name` varchar(100),
   `contact_person` varchar(100),
   `contact_email` varchar(100),
   `contact_phone` varchar(30),
   `address` varchar(150),
   `city` varchar(100),
   `state` varchar(100),
   `zip_code` varchar(15),
   `website` varchar(15),
   `note` varchar(75),
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `category` (
     `id` bigint(19) unsigned NOT NULL AUTO_INCREMENT,
     `category_name` varchar(85),
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/**
  stored procedure category
  **/

DELIMITER //

CREATE PROCEDURE sp_get_category()
BEGIN
    SELECT id, category_name FROM category ORDER BY category_name ASC;
END//

DELIMITER ;

/** add category **/

DELIMITER //

CREATE PROCEDURE sp_insert_category(IN p_category_name VARCHAR(255), OUT p_result INT)
BEGIN
    DECLARE category_count INT;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            SET p_result = -1;
        END;

    SELECT COUNT(id) INTO category_count FROM category WHERE category_name = p_category_name;

    IF category_count = 0 THEN
        INSERT INTO category (category_name) VALUES (p_category_name);
        SET p_result = 1;
    ELSE
        SET p_result = 0;
    END IF;
END//

DELIMITER ;

/** supplier **/
DELIMITER //

CREATE PROCEDURE sp_get_supplier()
BEGIN
    SELECT id, supplier_name FROM `supplier` ORDER BY supplier_name ASC;
END//

DELIMITER ;
