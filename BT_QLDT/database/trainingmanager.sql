use trainingmanager;

CREATE TABLE Ministry(
id bigint NOT NULL PRIMARY KEY auto_increment,
first_name varchar(30) NOT NULL,
last_name varchar(20) NOT NULL,
email varchar(150) NOT NULL,
password varchar(150) NOT NULL,
phone varchar(20) NULL,
created_at datetime NULL,
modified_at datetime NULL,
created_by varchar(50) NULL,
modified_by varchar(50) NULL
);

CREATE TABLE Classroom( 
id bigint NOT NULL PRIMARY KEY auto_increment,
name varchar(50) NOT NULL,
created_at datetime NULL,
modified_at datetime NULL,
created_by varchar(50) NULL,
modified_by varchar(50) NULL
);

CREATE TABLE Student(
id bigint NOT NULL PRIMARY KEY auto_increment,
first_name varchar(30) NOT NULL,
last_name varchar(20) NOT NULL,
classroom_id bigint NOT NULL,
note text NULL,
created_at datetime NULL,
modified_at datetime NULL,
created_by varchar(50) NULL,
modified_by varchar(50) NULL
);

ALTER TABLE Student ADD CONSTRAINT fk_classrom FOREIGN KEY (classroom_id) REFERENCES Classroom(id)