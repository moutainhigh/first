CREATE TABLE DIDI_TICKET (
   ID int NOT NULL AUTO_INCREMENT,
   ORDER_ID varchar(100) ,
   TICKET varchar(100) ,
   USERID varchar(100) ,
   USERNAME varchar(100) ,
   USERTEL varchar(11) ,
   DEPT varchar(100) ,
   FINANCEDEPT varchar(100) ,
   COMPANY varchar(100) ,
   REMARK varchar(100) ,
   REMARKINFO varchar(500) ,
   FLAG int ,
   DEF1 varchar(100) ,
   DEF2 varchar(100) ,
   DEF3 varchar(100) ,
   DEF4 varchar(100) ,
   DEF5 varchar(100) ,
   PRIMARY KEY (ID)
);
