/*CREATE TABLE person(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);*/


INSERT INTO PERSON
    (ID,NAME,LOCATION,BIRTH_DATE) 
VALUES(10001,'Sam','Berlin',sysdate());

INSERT INTO PERSON
    (ID,NAME,LOCATION,BIRTH_DATE) 
VALUES(10002,'James','Berlin',sysdate());

INSERT INTO PERSON
    (ID,NAME,LOCATION,BIRTH_DATE) 
VALUES(10003,'Peter','Munich',sysdate());

INSERT INTO PERSON
    (ID,NAME,LOCATION,BIRTH_DATE) 
VALUES(10004,'Olie','Berlin',sysdate());