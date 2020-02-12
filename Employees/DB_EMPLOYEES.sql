CREATE DATABASE  IF NOT EXISTS `Employees_management` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `Employees_management`;

CREATE TABLE `countries` (
  `iso` varchar(3) NOT NULL,
  `description` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`iso`)
);

CREATE TABLE `regions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(30) DEFAULT NULL,
  `iso_country` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`iso_country`) REFERENCES `countries` (`iso`)
);

CREATE TABLE `provinces` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(30) DEFAULT NULL,
  `id_region` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_region`) REFERENCES `regions` (`id`)
);

CREATE TABLE `cities` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(30) DEFAULT NULL,
  `id_province` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_province`) REFERENCES `provinces` (`id`)
);

CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `surname` varchar(60) DEFAULT NULL,
  `taxCode` varchar(30) DEFAULT NULL,
  `id_city` int DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `gender` char(1) default null,
  `email` varchar(40) DEFAULT NULL,
  `phonenumber` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_city`) REFERENCES `cities` (`id`)
);

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `ruolo` varchar(30) DEFAULT NULL,
  `config` longtext,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_city`) REFERENCES `cities` (`id`)
);


use Employees_management;

insert into countries values ("ITA","Italia");
insert into countries values ("KK","Kazakhistan");
insert into countries values ("FR","Francia");

insert into regions values(null,"Veneto","ITA");
insert into regions values(null,"Friuli-Venezia-Giulia","ITA");
insert into regions values(null,"Bretagna","FR");
insert into provinces values (null,"Belluno","1");
insert into provinces values (null,"Vicenza","1");
insert into provinces values (null,"Padova","1");
insert into provinces values (null,"Rovigo","1");
insert into provinces values (null,"Verona","1");
insert into provinces values (null,"Treviso","1");
insert into provinces values (null,"Venezia","1");
insert into provinces values (null,"Udine","2");
insert into provinces values (null,"Gorizia","2");
insert into provinces values (null,"Pordenone","2");
insert into provinces values (null,"Triestre","2");
insert into cities values(null,"Padova",1);
insert into cities values (null,"Belluno",1);

insert into users values(null,"admin","admin","admin","{'chiave1':'valore1'}");


insert into employees values(null,"Mirco", "Pastorino","PSTMRC85J8564D",2,"Via Brombeis 15","M","mirco_pastorino@belbel.com", "3986547852" );
insert into employees values(null,"Marco", "Casarin","CSMRC3545GH782DS",1,"Via Brombeis 12","M","marco_casarin@belbel.com", "3966556155" );
insert into employees values(null,"Lorenzo", "Savian","LRZSV23545GH782DS",1,"Via Brombeis 4","M","lorenzo_sav@belbel.com", "3966558455" );
insert into employees values(null,"Igor", "Lazic","IGRLAZ3545GH782DS",1,"Via Brombeis 1","M","igor_lazic@belbel.com", "3966556743" );
insert into employees values(null,"Manuel", "Maraga","MNLMRG845GH782DS",1,"Via Brombeis 18","M","m.m@belbel.com", "393521479" );