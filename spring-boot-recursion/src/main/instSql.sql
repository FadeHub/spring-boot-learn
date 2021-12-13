DROP table if exists limit_mesh;
CREATE TABLE `limit_mesh` (
    `id` int NOT NULL AUTO_INCREMENT,
    `parent_node` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
    `child_node` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

truncate table limit_mesh;
INSERT INTO `limit_mesh`(`parent_node`, `child_node`) VALUES ('crilm', 'inst');
INSERT INTO `limit_mesh`(`parent_node`, `child_node`) VALUES ('crilm', 'cash');
INSERT INTO `limit_mesh`(`parent_node`, `child_node`) VALUES ('crilm', 'instCash');
INSERT INTO `limit_mesh`(`parent_node`, `child_node`) VALUES ('cust', 'crilm');
INSERT INTO `limit_mesh`(`parent_node`, `child_node`) VALUES ('custTotal', 'cust');
INSERT INTO `limit_mesh`(`parent_node`, `child_node`) VALUES ('cust', 'splmt');
INSERT INTO `limit_mesh`(`parent_node`, `child_node`) VALUES ('splmt', 'byj');
INSERT INTO `limit_mesh`(`parent_node`, `child_node`) VALUES ('splmt', 'ygj');