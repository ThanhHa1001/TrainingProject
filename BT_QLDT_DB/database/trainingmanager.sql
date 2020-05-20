CREATE SCHEMA `trainingmanager` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

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
modified_by varchar(50) NULL,
role int NOT NULL
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
    
-- Insert admin 
INSERT INTO Ministry (first_name, last_name, email, password, phone, created_at, created_by, role)
VALUES ("", "admin", "admin@gmail.com", "Abcd1234", "0972145268", '2020-05-13 16:49:00', "admin", 1);

-- Insert Ministry
INSERT INTO Ministry (first_name, last_name, email, password, phone, created_at, created_by, role)
VALUES  ("Nguyễn Thùy", "Chi", "nguyenthuychi@gmail.com", "Abcd1234", "0972145268", '2020-05-13 16:49:00', "admin", 0),
		("Lê Khánh", "Linh", "phungkhanhlinh@gmail.com", "Abcd1234", "0983456741", '2020-05-13 16:49:00', "admin", 0),
		("Trần Văn", "Bình", "tranvanbinh@gmail.com", "Abcd1234", "0975142563", '2020-05-13 16:49:00', "admin", 0),
		("Trương Đức", "Hải", "truongduchai@gmail.com", "Abcd1234", "0971458632", '2020-05-13 16:49:00', "admin", 0);

INSERT INTO Classroom (name, ministry_id, created_at, created_by) 
VALUES  ("12A1", 2, '2020-05-13 16:49:00', "admin"),
		("12A2", 3, '2020-05-13 16:49:00', "admin"),
		("12A3", 4, '2020-05-13 16:49:00', "admin"),
		("12A4", 5, '2020-05-13 16:49:00', "admin"),
	    ("12A5", 1, '2020-05-13 16:49:00', "admin");
        
INSERT INTO Student (first_name, last_name, classroom_id, note, created_at, created_by)
VALUES  ("Hoài", "An", 1, NULL, '2020-05-13 16:49:00', "Nguyễn Thùy Chi"),
		("Dương Lê", "Dương", 1, NULL, '2020-05-13 16:49:00', "Nguyễn Thùy Chi"),
        ("Lê Lan", "Anh", 1, NULL, '2020-05-13 16:49:00', "Nguyễn Thùy Chi"),
		("Lê Văn", "Hùng", 2, NULL, '2020-05-14 16:49:00', "Lê Khánh Linh"),
        ("Trần Văn", "Tâm", 2, NULL, '2020-05-14 16:49:00', "Lê Khánh Linh"),
		("Nguyễn Văn", "Tuấn", 3, NULL, '2020-05-16 16:49:00', "Trần Văn Bình");
        