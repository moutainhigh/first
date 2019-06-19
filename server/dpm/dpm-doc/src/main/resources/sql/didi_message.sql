CREATE TABLE `didi_message` (
  `dept` int(11) NOT NULL,
  `message` varchar(500) DEFAULT NULL,
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `state` varchar(20) DEFAULT NULL,
  `savetime` date DEFAULT NULL,
  `userid` varchar(20) NOT NULL,
  `msgtitle` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
)