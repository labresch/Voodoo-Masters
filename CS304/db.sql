drop table Education cascade constraints;
drop table WrittenBy cascade constraints;
drop table Author cascade constraints;
drop table Reference cascade constraints;
drop table HasTopic cascade constraints;
drop table SubscribedTo cascade constraints;
drop table PublishedIn cascade constraints;
drop table Paper cascade constraints;
drop table Subscriber cascade constraints;
drop table PublishedBy cascade constraints;
drop table Publisher cascade constraints;

alter session set NLS_DATE_FORMAT='YYYY/MM/DD';

create table Publisher(
publishername char(64),
address char(64),
primary key(publishername));

create table PublishedBy(
edition integer,
journalname char(50),
accessable char(1),                                                   
publishdate date,                   
publishername char(64),                                                    
primary key(edition, journalname),                                                    
foreign key(publishername) references Publisher(publishername));

create table Subscriber(
userID char(18),
password char(18),
joinDate date,
primary key(userID));

create table Paper(
paperID integer,
editor char(24),
datePublished date,
title char(100),
primary key(paperID));

create table PublishedIn(
paperID integer,
journalName char(50),
edition integer,
primary key(paperID, journalName, edition),
foreign key(paperID) references Paper(paperID),
foreign key(paperID, journalName, edition) references PublishedIn(paperID, journalName, edition));

create table SubscribedTo(
userID char(18),
edition integer,
journalname char(50),       
primary key(userID, edition, journalname),
foreign key(userID) references Subscriber(userID),
foreign key(edition, journalname) references PublishedBy(edition, journalname));

create table HasTopic(
topicname char(24),
paperID integer,
primary key(topicname, paperID),
foreign key(paperID, topicname) references HasTopic(paperID, topicname),
foreign key(paperID) references Paper(paperID));

create table Reference(
paperID1 integer,
paperID2 integer,
primary key(paperID1, paperID2),
foreign key(paperID1) references Paper(paperID),
foreign key(paperID2) references Paper(paperID));

create table Author(
authorID integer,
name char(24),
primary key(authorID));

create table WrittenBy(
paperID integer,
authorID integer,
primary key(paperID, authorID),
foreign key(paperID) references Paper(paperID),
foreign key(authorID) references Author(authorID));

create table Education(
authorID integer,
gradDate date,
institution char(30),
studyField char(20),
degree char(30),
primary key(authorID, gradDate, institution),
foreign key(authorID) references Author(authorID));

insert into Publisher values('Canadian Computer Science Studies','1111 This St. Vancouver, BC');
insert into Publisher values('Dinosaur Studies of North America','1234 Some Rd New York, NY');
insert into Publisher values('Institute of Information Technology in Scientific Use','194 Elm St. Toronto, ON');
insert into Publisher values('American Society of Botanists','38 Flower St. Indianapolis, IN');
insert into Publisher values('Association of Economics','154 First Ave. Boston, MS');
insert into Publisher values('M.E Sharpe','80 Business Park Drive Armonk, NY');
insert into Publisher values('EDGE','30 Monmouth Street Bath, UK');
insert into Publisher values('Blackwell Publishing','9600 Garsington Road, Oxford');
insert into Publisher values('Eastwood Printing','1280 Gothard Street, Vancouver');
insert into Publisher values('Oxwell Inc','50 Ontario Avenue, Oregon');
insert into publisher values('InfoTech Ltd','50 Novice Street, Silicon Valley');

insert into PublishedBy values(6,'Journal of Scientific Learning','n','2000/12/01','Canadian Computer Science Studies');
insert into PublishedBy values(7,'Journal of Scientific Learning','n','2001/01/03','Canadian Computer Science Studies');
insert into PublishedBy values(2,'Paleontologists Quarterly','y','2008/05/16','Dinosaur Studies of North America');
insert into PublishedBy values(3,'Paleontologists Annually','n','2010/09/03','Dinosaur Studies of North America');
insert into PublishedBy values(5,'The Ross Geller','n','2009/06/07','Dinosaur Studies of North America');
insert into PublishedBy values(1,'Information Technology Monthly','y','2009/06/17','Institute of Information Technology in Scientific Use');
insert into PublishedBy values(4,'Computers in the Classroom','n','2010/01/01','Institute of Information Technology in Scientific Use');
insert into PublishedBy values(1,'Journal of Management Information Systems','n','1990/10/09','M.E Sharpe');
insert into PublishedBy values(5,'Video Game History Periodical','n','2006/11/11','EDGE');
insert into PublishedBy values(6,'Journal of Video Games','n','2001/11/11','EDGE');
insert into PublishedBy values(7,'Journal of Video Games','n','2001/12/11','EDGE');
insert into PublishedBy values(35,'Archaeology in Oceania','y','2005/01/25','Blackwell Publishing');
insert into PublishedBy values(36,'Archaeology in Oceania','y','2006/01/27','Blackwell Publishing');
insert into PublishedBy values(37,'Archaeology in Oceania','y','2007/01/24','Blackwell Publishing');
insert into PublishedBy values(38,'Archaeology in Oceania','y','2008/01/23','Blackwell Publishing');
insert into PublishedBy values(27,'Canadian Journal of Sociology','n','2002/10/28','Blackwell Publishing');
insert into PublishedBy values(13,'Future Tech','y','2005/12/04','InfoTech Ltd');

insert into Subscriber values('n00bpwner','p4ssw0rd','2011/11/11');
insert into Subscriber values('boqoopod','dinosaurs','2010/01/15');
insert into Subscriber values('leslie7','cookies','2009/02/14');
insert into Subscriber values('timothygregson','iamtired','2008/01/22');
insert into Subscriber values('jeffchan','apassword','2010/05/30');
insert into Subscriber values('costanza','george','2012/01/01');
insert into Subscriber values('johnson','123456','2008/03/12');
insert into Subscriber values('dudeman','runman','2011/05/13'); 
insert into Subscriber values('brodude','1frodork1','2012/02/29');

insert into Paper values(188430,'David D Helgeson','2010/04/11','Relations and Schemas');
insert into Paper values(188305,'Jason Palmer','2008/05/16','The Dinosaur Anatomy');
insert into Paper values(188300,'Jason Palmer','2010/09/03','Attack of the Dactyl');
insert into Paper values(188431,'Arbit Raryname','2009/01/18','Evolution of Cloud Databases');
insert into Paper values(188432,null,'2010/04/09','Computer Simulations and Hands-on Learning');
insert into Paper values(188434,'John Doe','2001/12/01','Scientific Reasoning and the Interactive Computer');
insert into Paper values(188435,null,'2008/02/02','Improving Storage Structures for Developing Databases');
insert into Paper values(895,'Jeff Gerstman','2004/06/12','100 Video Game Secrets You Never Knew');
insert into Paper values(1000,null,'1990/10/09','Dispersed Group Decision Making Using Nonsimultaneous Computer Conferencing: A Report of Research');
insert into Paper values(19913,'Andy Rodick','2009/06/07','The Gellersaurus: A True Predator');
insert into Paper values(19914,'Andy Rodick','2009/06/07','DinoDinner');
insert into Paper values(19915,null,'2009/06/08','Attack of the Dactyl');
insert into Paper values(145551,'Michael Prachter','2001/11/11','Economy of 1985');
insert into Paper values(145553,'Michael Prachter','2001/11/11','The Crash and its effects');
insert into Paper values(1250,'George Orwell','2005/05/12','Pacific Archaeology: Assessments and Prospects.');
insert into Paper values(1251,'George Oxwell','2005/05/13','Bones of Contention: Reply to Walshe.');
insert into Paper values(1252,'George Norwell','2006/05/11','Late Pleistocene Human Occupation of Inland Rainforest, Birds Head, Papua.');
insert into Paper values(1253,'George Oxwell','2006/05/14','Mortuary Behaviour on the Hay Plain: Do Cemeteries Exist?');
insert into Paper values(1254,'George Oxwell','2007/05/15','Avifaunal Extinctions, Vegetation Change, and Polynesian Impacts in Prehistoric Hawaii');
insert into Paper values(1255,'George George','2008/12/19','Prehistoric Settlement at Anaho Bay, Nuku Hiva, Marquesas Islands: Preliminary Observations');
insert into Paper values(1256,'George Oxwell','2008/07/13','Megaliths of Muyuw (Woodlark Island)');
insert into Paper values(1487,'Ashley Lux','2002/04/15','Asymmetrical Hybridities: Youths at Francophone Games in Canada');
insert into Paper values(1670,'Steve Jobless','2005/12/03','A Phone made out of Apples');

insert into PublishedIn values(188430,'Relational Databases',3);
insert into PublishedIn values(188431,'Information Technology Monthly',1);
insert into PublishedIn values(188432,'Computers in the Classroom',12);
insert into PublishedIn values(188434,'Journal of Scientific Learning',7);
insert into PublishedIn values(188435,'Relational Databases',2);
insert into PublishedIn values(895,'Video Game History Periodical',5);
insert into PublishedIn values(1000,'Journal of Management Information Systems',1);
insert into PublishedIn values(188305,'Paleontologists Quarterly',2);
insert into Publishedin values(188300,'Paleontologists Annually',3);
insert into Publishedin values(19913,'The Ross Geller',5);
insert into Publishedin values(19914,'The Ross Geller',5);
insert into Publishedin values(19915,'The Ross Geller',5);
insert into Publishedin values(145551,'Journal of Video Games',6);
insert into Publishedin values(145553,'Journal of Video Games',7);
insert into Publishedin values(1250,'Archaeology in Oceania',35);
insert into Publishedin values(1251,'Archaeology in Oceania',35);
insert into Publishedin values(1252,'Archaeology in Oceania',36);
insert into Publishedin values(1253,'Archaeology in Oceania',36);
insert into Publishedin values(1254,'Archaeology in Oceania',37);
insert into Publishedin values(1255,'Archaeology in Oceania',38);
insert into Publishedin values(1256,'Archaeology in Oceania',38);
insert into Publishedin values(1487,'Canadian Journal of Sociology',27);
insert into Publishedin values(1670,'Future Tech',13);

insert into SubscribedTo values('n00bpwner',5,'Video Game History Periodical');
insert into SubscribedTo values('n00bpwner',6,'Journal of Video Games');
insert into SubscribedTo values('n00bpwner',7,'Journal of Video Games'); 
insert into SubscribedTo values('boqoopod',2,'Paleontologists Quarterly');
insert into SubscribedTo values('boqoopod',3,'Paleontologists Annually');
insert into SubscribedTo values('leslie7',7,'Journal of Scientific Learning');
insert into SubscribedTo values('jeffchan',1,'Information Technology Monthly');
insert into SubscribedTo values('costanza',1,'Journal of Management Information Systems');
insert into SubscribedTo values('johnson',36,'Archaeology in Oceania');
insert into SubscribedTo values('johnson',37,'Archaeology in Oceania');
insert into SubscribedTo values('johnson',38,'Archaeology in Oceania');
insert into SubscribedTo values('johnson',1,'Information Technology Monthly');
insert into SubscribedTo values('johnson',2,'Paleontologists Quarterly');	

insert into HasTopic values('databases',188431);
insert into HasTopic values('databases',188435);
insert into HasTopic values('computer simulations',188432);
insert into HasTopic values('data storage',188435);
insert into HasTopic values('video games',895);
insert into HasTopic values('computer conferencing',1000);
insert into HasTopic values('dinosaurs',188305);
insert into HasTopic values('anatomy',188305);
insert into HasTopic values('dinosaurs',188300);
insert into HasTopic values('pterodactyl',188300);
insert into HasTopic values('attack',188300);
insert into HasTopic values('dinosaurs',19913);
insert into HasTopic values('gellersaurus',19913);
insert into HasTopic values('ecology',19913);
insert into HasTopic values('dinosaurs',19914);
insert into HasTopic values('dinosaurs',19915);
insert into HasTopic values('pterodactyl',19915);
insert into HasTopic values('attack',19915);
insert into HasTopic values('video games',145551);
insert into HasTopic values('economy',145551);
insert into HasTopic values('video games',145553);
insert into HasTopic values('economy',145553);
insert into HasTopic values('archaeology',1250);
insert into HasTopic values('archaeology',1251);
insert into HasTopic values('archaeology',1252);
insert into HasTopic values('archaeology',1253);
insert into HasTopic values('archaeology',1254);
insert into HasTopic values('archaeology',1255);
insert into HasTopic values('archaeology',1256);
insert into HasTopic values('sociology',1487);
insert into HasTopic values('Canada',1487);
insert into HasTopic values('technology',1670);

insert into Reference values(188432,188434);
insert into Reference values(188430,188431);
insert into Reference values(188430,188435);
insert into Reference values(145551,1253);
insert into Reference values(1255,1251);
insert into Reference values(1250,1251);
insert into Reference values(1251,1250);
insert into Reference values(1256,1250);
insert into Reference values(1255,1250);
insert into Reference values(19914,19913);
insert into Reference values(145553,145551);
insert into Reference values(895,145553);

insert into Author values(12,'Madup Nam');
insert into Author values(999,'Daisy Chien');
insert into Author values(4318,'Tom Thompson');
insert into Author values(7778,'Sven Stevetson');
insert into Author values(9001,'Neuf Etun');
insert into Author values(15,'Matt Cassamassima');
insert into Author values(16,'Mark Bozon'); 
insert into Author values(17,'Hilary Goldstein'); 
insert into Author values(809,'Tim Stiller');
insert into Author values(1250,'Charles E. Dortch');
insert into Author values(1251,'Simon H. Bickler');
insert into Author values(1252,'Baiva Ivuyo');
insert into Author values(1253,'Ethan E. Cochrane');
insert into Author values(1254,'Juliette M. Pasveer');
insert into Author values(1255,'Simon J. Clarke');
insert into Author values(1256,'Gifford H. Miller');
insert into Author values(1257,'Chris Clarkson');
insert into Author values(1258,'Judith Littleton');
insert into Author values(1259,'Chris Clarkson');
insert into Author values(1999,'Ross Geller');
insert into Author values(2001,'Monica Geller');
insert into Author values(2005,'Joey Tribiani');
insert into Author values(2008,'Channeler Bing');
insert into Author values(1840,'George George'); 
insert into Author values(1650,'Steven Harper');
insert into Author values(25,'Michael Pachter'); 
insert into Author values(9999,'Do Nothing');

insert into WrittenBy values(188430,999);
insert into WrittenBy values(188431,999);
insert into WrittenBy values(188432,999);
insert into WrittenBy values(188434,999);
insert into WrittenBy values(188435,999);
insert into WrittenBy values(1000,4318);
insert into WrittenBy values(1000,16);
insert into WrittenBy values(188300,999);
insert into WrittenBy values(1487,12);
insert into WrittenBy values(895,15);
insert into WrittenBy values(895,16);
insert into WrittenBy values(895,17);
insert into WrittenBy values(1000,809);
insert into WrittenBy values(188305,2008);
insert into WrittenBy values(188300,1999);
insert into WrittenBy values(19913,2001);
insert into WrittenBy values(19914,2005);
insert into WrittenBy values(19915,1999);
insert into WrittenBy values(145551,25);
insert into WrittenBy values(145553,25);
insert into WrittenBy values(145553,15);
insert into WrittenBy values(1250,1250);
insert into WrittenBy values(1250,1251);
insert into WrittenBy values(1251,1251);
insert into WrittenBy values(1251,1252);
insert into WrittenBy values(1251,1250);
insert into WrittenBy values(1252,1253);
insert into WrittenBy values(1253,1254);
insert into WrittenBy values(1253,1255);
insert into WrittenBy values(1254,1256);
insert into WrittenBy values(1255,1257);
insert into WrittenBy values(1256,1258);
insert into WrittenBy values(1256,1259);
insert into WrittenBy values(1487,1840);
insert into WrittenBy values(1670,1650);

insert into Education values(12,'1987/04/18','Instutute of Institutions','Gender Studies','Bachelor of Arts');
insert into Education values(12,'1990/05/16','University West','Gender Studies','Masters');
insert into Education values(999,'1991/04/12','University of British Columbia','Computer Science','Bachelors of Computer Science');
insert into Education values(4318,'1917/07/08','National Painters Institute','Fine Arts','Bachelor of Fine Arts');
insert into Education values(9001,'1999/09/09','Harvard','Law','Doctor of Laws');
insert into Education values(15,'2000/04/13','Univeristy of California','English Literature','Bachelor of Arts');
insert into Education values(809,'2008/04/26','Stanford University','Economics','Bachelor of Commerce');
insert into Education values(809,'2010/04/30','Yale','Economics','Masters');
insert into Education values(1250,'1987/04/30','University of Sydney','Archaelogy','Bachelors');
insert into Education values(1250,'1995/04/30','University of Detroit','Archaeology','Masters');
insert into Education values(1250,'2000/04/30','University of Detroit','Archaeology','Doctoral');
insert into Education values(1250,'2003/04/30','University of Sydney','Economics','Bachelors');
insert into Education values(1251,'2001/04/30','University of Chicago','Archaeology','Bachelors');
insert into Education values(1252,'2002/04/30','University of Washington','Archaeology','Bachelors');
insert into Education values(1252,'2007/04/30','University of Chicago','Archaeology','Masters');
insert into Education values(1253,'1993/04/30','Langara College','Economics','Bachelors in Arts');
insert into Education values(1253,'1999/04/30','University of British Columbia','Economics','Masters');
insert into Education values(1253,'2001/04/30','University of British Columbia','Archaeology','Bachelors');
insert into Education values(1254,'1999/04/30','University of Waterloo','Archaeology','Bachelors');
insert into Education values(1254,'2005/04/30','University of Waterloo','Archaeology','Masters');
insert into Education values(1255,'2002/04/30','University of Sydney','Archaeology','Bachelors');
insert into Education values(1255,'2003/04/30','University of Sydney','Archaeology','Masters');
insert into Education values(1256,'2004/04/30','University of Alberta','Archaeology','Bachelors');
insert into Education values(1257,'2001/04/30','University of Waterloo','Archaeology','Bachelors');
insert into Education values(1257,'2005/04/30','University of Sydney','Archaeology','Masters');
insert into Education values(1258,'1953/04/30','Stanford','Archaeology','Bachelors');
insert into Education values(1259,'1975/04/30','Yale','Archaeology','Bachelors');
insert into Education values(1259,'1985/04/30','Yale','Archaeology','Masters');
insert into Education values(1259,'1995/04/30','Harvard','Archaeology','PhD');
insert into Education values(1999,'1995/04/30','University of New Jersey','Paleontology','Bachelors');
insert into Education values(2001,'1997/04/30','Some Culinary Arts College','Culinary Arts','Some Degree');
insert into Education values(2005,'1991/04/30','Acting School','Acting','None');
insert into Education values(2008,'2004/04/30','Simon Fraser University','Business Admin','Bachelors');
insert into Education values(1840,'1945/04/30','Harvard','English Literature','PhD');
insert into Education values(1650,'1995/04/30','University of Toronto','Politics','PhD');
insert into Education values(9999,'1995/04/30','Nonexistant University','Laziness','PhD');
