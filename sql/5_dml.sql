-- DML – Data Manipulation Language in SQL
-- DML (Data Manipulation Language) includes SQL commands used to work with data 
-- inside tables — like adding, modifying, and deleting records.

-- | Command    | Description                                               |
-- | ---------- | --------------------------------------------------------- |
-- | `INSERT`   | Adds new rows into a table                                |
-- | `SELECT`\* | Retrieves data from the table *(technically part of DQL)* |
-- | `UPDATE`   | Modifies existing rows                                    |
-- | `DELETE`   | Deletes rows from the table                               |

drop database employee; -- if exist

create database employee_db;

use employee_db;

create table employee(
	id int primary key,
    name varchar(20) not null,
    age int check(age>18 and age<35) not null,
    gender enum('m','f') not null,
    doj date not null,
    salary int default 0,
    skills set('java','sql','python'),
    phone varchar(20) unique not null
);

-- since we have not added auto incremet to id, so we have to pass id manually
-- INSERT
-- insert into table_name(column1,column2....) values(value1, value2......)

-- inserting without specifiying column name
--     when you are inserting data without specifing column name, 
--     you have to pass data for all columns with maintaining order of column
INSERT INTO employee VALUES (1, 'Alice', 25, 'f', '2022-05-10', 50000, 'java,python', '9990010010');
select * from employee;

-- inserting with specifiying all column names
insert into employee (id,name,age,gender,doj,salary,skills,phone)
values(2,"rani",25,"f","2020-10-28",300000,'java',9856365245);
select * from employee;

-- inserting without specifiying some column names
-- here specify only those column names on which there is no NOT NULL
-- here we have two columns - salary and skills
insert into employee (id,name,age,gender,doj,phone)
values(3,"sawant",32,"m","2020-09-28",9856365235);
select * from employee;

-- inserting wmultiple values at a time - for all columns
INSERT INTO employee (id,name,age,gender,doj,salary,skills,phone) VALUES
(4, 'Bob', 28, 'm', '2021-03-15', 55000, 'sql', '9990010011'),
(5, 'Carol', 30, 'f', '2020-07-20', 60000, 'java,sql', '9990010012'),
(6, 'David', 24, 'm', '2023-01-01', 45000, 'python', '9990010013'),
(7, 'Eva', 29, 'f', '2022-10-11', 47000, 'java,sql,python', '9990010014'),
(8, 'Frank', 26, 'm', '2021-12-05', 52000, 'sql,python', '9990010015'),
(9, 'Grace', 27, 'f', '2020-08-18', 58000, 'java', '9990010016'),
(10, 'Henry', 31, 'm', '2019-06-25', 62000, 'sql', '9990010017'),
(11, 'Isha', 22, 'f', '2023-05-14', 40000, 'python', '9990010018'),
(12, 'Jack', 32, 'm', '2022-11-30', 61000, 'java,sql', '9990010019');
select * from employee;

-- inserting data from one table to another
-- creating table with some imp details of employee (not all details)
create table employee_test(
	id int primary key,
    name varchar(20) not null,
    gender enum('m','f') not null,
    phone varchar(20) unique not null
);
select * from employee_test;
insert into employee_test select id,name,gender,phone from employee;
select * from employee_test;
select * from employee;

-- UPDATE
-- UPDATE table_name SET column_to_be_modify = value WHERE column_name_with_pk = value

-- udpdate one column at a time
select * from employee;
update employee set name = "raju" where id = 1;
select * from employee;

-- udpdate mutiple column at a time
select * from employee;
update employee set name = "raj",salary=40000 where id = 12;
select * from employee;

-- udpdate without where condition
-- not recommonded to use
-- because this replace all the name with raj
update employee set name = "raj";
select * from employee;

-- DELETE
-- DELETE FROM table_name WHERE column_name = value

-- delete one record/row at a time
delete from employee where id=1;
select * from employee;

-- delete one record/row at a time with wrong id
-- if id does not exist, then our command will not give any error
delete from employee where id=201;
select * from employee;

-- delete muliple row/record at a time
delete from employee where gender='m';
select * from employee;

-- delete without where condition
-- this command will delete all the data from the table
delete from employee;
select * from employee;

