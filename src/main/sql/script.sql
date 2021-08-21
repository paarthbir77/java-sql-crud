create database SampleDB;
 
use SampleDB;
 
CREATE TABLE `users` (
    `userId` int(5) NOT NULL AUTO_INCREMENT,
    `firstName` varchar(20) NOT NULL,
    `lastName` varchar(20) NOT NULL,
    `email` varchar(30) NOT NULL,
    PRIMARY KEY (`userId`)
);