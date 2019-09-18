/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 5.0.24-community-nt : Database - truck_dispature
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`truck_dispature` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `truck_dispature`;

/*Table structure for table `driver` */

DROP TABLE IF EXISTS `driver`;

CREATE TABLE `driver` (
  `ssn` varchar(255) NOT NULL,
  `assignedtruck` varchar(255) default NULL,
  `dob` date default NULL,
  `licence_expiration` date default NULL,
  `medical_expiration` date default NULL,
  `name` varchar(255) default NULL,
  `testexpiry` date default NULL,
  `truckowner` varchar(255) default NULL,
  PRIMARY KEY  (`ssn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `driver` */

insert  into `driver`(`ssn`,`assignedtruck`,`dob`,`licence_expiration`,`medical_expiration`,`name`,`testexpiry`,`truckowner`) values ('123-24-5455','mp09123','2018-01-02','2018-02-26','2018-02-26','Rahul','2018-02-26','123-12-1234'),('123-85-4557','mp09123','2018-01-01','2018-01-30','2018-01-30','Bond','2018-01-23','123-12-1234');

/*Table structure for table `loadmaster` */

DROP TABLE IF EXISTS `loadmaster`;

CREATE TABLE `loadmaster` (
  `loadNumber` int(11) NOT NULL,
  `dispatureCommission` double default NULL,
  `dropCity` varchar(255) default NULL,
  `dropState` varchar(255) default NULL,
  `dropoffDate` date default NULL,
  `finalGross` double default NULL,
  `gross` double default NULL,
  `grossafterCommision` double default NULL,
  `pickupCity` varchar(255) default NULL,
  `pickupDate` date default NULL,
  `pickupState` varchar(255) default NULL,
  `status` int(11) default NULL,
  `totalamountpaid` double default NULL,
  `truckNumber` varchar(255) default NULL,
  PRIMARY KEY  (`loadNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `loadmaster` */

insert  into `loadmaster`(`loadNumber`,`dispatureCommission`,`dropCity`,`dropState`,`dropoffDate`,`finalGross`,`gross`,`grossafterCommision`,`pickupCity`,`pickupDate`,`pickupState`,`status`,`totalamountpaid`,`truckNumber`) values (900,500,'Delhi','delhi','2018-01-31',NULL,5000,4500,'indore','2018-01-27','mp',1,1600,'mp09123');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `loginid` varchar(255) NOT NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`loginid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login` */

/*Table structure for table `owner` */

DROP TABLE IF EXISTS `owner`;

CREATE TABLE `owner` (
  `ssn` varchar(255) NOT NULL,
  `dob` date default NULL,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`ssn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `owner` */

insert  into `owner`(`ssn`,`dob`,`name`) values ('123-12-1234','2018-01-01','James Robert'),('123-89-7895','2018-01-03','Narendra');

/*Table structure for table `transaction_details` */

DROP TABLE IF EXISTS `transaction_details`;

CREATE TABLE `transaction_details` (
  `transno` int(11) NOT NULL auto_increment,
  `advance` double default NULL,
  `advancetype` varchar(255) default NULL,
  `datetime` datetime default NULL,
  `grossaftercommission` double default NULL,
  `loadnumber` int(11) default NULL,
  PRIMARY KEY  (`transno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `transaction_details` */

insert  into `transaction_details`(`transno`,`advance`,`advancetype`,`datetime`,`grossaftercommission`,`loadnumber`) values (1,0,'ADVANCE','2018-01-27 18:17:09',4500,900),(2,500,'ADVANCE','2018-01-27 18:17:26',4000,900),(3,600,'FUEL','2018-01-27 18:18:03',3400,900),(4,500,'ADVANCE','2018-01-27 18:21:16',2900,900);

/*Table structure for table `truck` */

DROP TABLE IF EXISTS `truck`;

CREATE TABLE `truck` (
  `trucknumber` varchar(255) NOT NULL,
  `expiredate` date default NULL,
  `maxload` int(11) default NULL,
  `mileage` int(11) default NULL,
  `registrationNumber` varchar(255) default NULL,
  `ssn` varchar(255) default NULL,
  PRIMARY KEY  (`trucknumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `truck` */

insert  into `truck`(`trucknumber`,`expiredate`,`maxload`,`mileage`,`registrationNumber`,`ssn`) values ('123456','2018-01-31',200,15,'123456','123-89-7895'),('mp09123','2018-01-30',10,15,'123','123-12-1234');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
