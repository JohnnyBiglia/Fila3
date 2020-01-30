CREATE DATABASE  IF NOT EXISTS `Employees_management` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `Employees_management`;

CREATE TABLE `countries` (
  `ISO` varchar(3) NOT NULL,
  `Description` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ISO`)
);

CREATE TABLE `regions` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Description` varchar(30) DEFAULT NULL,
  `ISO_Country` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`ISO_Country`) REFERENCES `countries` (`ISO`)
);

CREATE TABLE `provinces` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Description` varchar(30) DEFAULT NULL,
  `ID_Region` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`ID_Region`) REFERENCES `regions` (`ID`)
);

CREATE TABLE `cities` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Description` varchar(30) DEFAULT NULL,
  `ID_Province` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`ID_Province`) REFERENCES `provinces` (`ID`)
);

CREATE TABLE `employees` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(60) DEFAULT NULL,
  `Surname` varchar(60) DEFAULT NULL,
  `TaxCode` varchar(30) DEFAULT NULL,
  `ID_City` int DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Gender` char(1) default null,
  `Email` varchar(40) DEFAULT NULL,
  `PhoneNumber` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`ID_City`) REFERENCES `cities` (`ID`)
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


insert into employees values(null,"Mirco", "Pastorino","PSTMRC85J8564D",2,"Via Brombeis 15","M","mirco_pastorino@belbel.com", "3986547852" );
insert into employees values(null,"Marco", "Casarin","CSMRC3545GH782DS",1,"Via Brombeis 12","M","marco_casarin@belbel.com", "3966556155" );
insert into employees values(null,"Lorenzo", "Savian","LRZSV23545GH782DS",1,"Via Brombeis 4","M","lorenzo_sav@belbel.com", "3966558455" );
insert into employees values(null,"Igor", "Lazic","IGRLAZ3545GH782DS",1,"Via Brombeis 1","M","igor_lazic@belbel.com", "3966556743" );
insert into employees values(null,"Manuel", "Maraga","MNLMRG845GH782DS",1,"Via Brombeis 18","M","m.m@belbel.com", "393521479" );
