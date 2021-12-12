CREATE TABLE `limit_mesh` (
    `id` int NOT NULL AUTO_INCREMENT,
    `parent_node` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
    `child_node` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO `chapter01`.`limit_mesh`(`id`, `parent_node`, `child_node`) VALUES (1, 'crilm', 'inst');
INSERT INTO `chapter01`.`limit_mesh`(`id`, `parent_node`, `child_node`) VALUES (2, 'crilm', 'cash');
INSERT INTO `chapter01`.`limit_mesh`(`id`, `parent_node`, `child_node`) VALUES (3, 'crilm', 'instCash');
INSERT INTO `chapter01`.`limit_mesh`(`id`, `parent_node`, `child_node`) VALUES (4, 'cust', 'crilm');
INSERT INTO `chapter01`.`limit_mesh`(`id`, `parent_node`, `child_node`) VALUES (5, 'custTotal', 'cust');
INSERT INTO `chapter01`.`limit_mesh`(`id`, `parent_node`, `child_node`) VALUES (6, 'cust', 'splmt');
INSERT INTO `chapter01`.`limit_mesh`(`id`, `parent_node`, `child_node`) VALUES (7, 'splmt', 'byj');
INSERT INTO `chapter01`.`limit_mesh`(`id`, `parent_node`, `child_node`) VALUES (8, 'splmt', 'ygj');