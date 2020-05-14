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
ministry_id bigint NOT NULL,
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

ALTER TABLE Student ADD CONSTRAINT fk_student_classrom FOREIGN KEY (classroom_id) REFERENCES Classroom(id);
ALTER TABLE Classroom ADD CONSTRAINT fk_classroom_ministry FOREIGN KEY (ministry_id) REFERENCES Ministry(id);

INSERT INTO Ministry (first_name, last_name, email, password, phone, created_at, created_by)
VALUES ("Nguyễn Thùy", "Chi", "nguyenthuychi@gmail.com", "Abcd1234", "0972145268", '2020-05-13 16:49:00', "Nguyễn Thùy Chi");

INSERT INTO trainingmanager.Classroom (name, ministry_id, created_at) 
VALUES ("12A1", 1, '2020-05-13 16:49:00'), 
	("12A2", 1, '2020-05-13 16:49:00');
    
SELECT * FROM classroom;