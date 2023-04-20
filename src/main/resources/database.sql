DROP TABLE IF EXISTS `people`;
CREATE TABLE `people`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(70) CHARACTER SET utf8 COLLATE utf8_general_ci  DEFAULT NULL,
    `age`  int(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `gender`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

