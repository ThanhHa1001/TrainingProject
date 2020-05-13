CREATE SCHEMA company DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

use company;

CREATE TABLE Employees(
id varchar(6) NOT NULL,
name varchar(20) NULL,
birthday date null
);

CREATE TABLE Salary(
month_year int NOT NULL,
employee_id varchar(6) NOT NULL,
amount bigint NULL
);

ALTER TABLE Employees ADD CONSTRAINT PK_Employee PRIMARY KEY (id);

ALTER TABLE Salary ADD CONSTRAINT PK_Salary PRIMARY KEY (month_year, employee_id);

ALTER TABLE Salary ADD CONSTRAINT FK_EmpoyeeSalary FOREIGN KEY (employee_id) REFERENCES Employees(id);

INSERT INTO Employees VALUES('400100', 'Nguyen Van A', '1990/10/22');
INSERT INTO Employees VALUES('400200', 'Tran Thi B', '1993/5/6');
INSERT INTO Employees VALUES('400300', 'Ha Thi C', '1995/10/10');


INSERT INTO salary VALUES(201805,'400100',12100000);
INSERT INTO salary VALUES(201805,'400200',9600000);
INSERT INTO salary VALUES(201806,'400100',14100000);
INSERT INTO salary VALUES(201806,'400200',11600000);
INSERT INTO salary VALUES(201807,'400200',12700000);

SELECT Employees.id, Employees.name, sum(Salary.amount) as salary
From Employees, Salary
Where Employees.id = Salary.employee_id
Group By Salary.employee_id;


