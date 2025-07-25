--  ALTER Command in SQL (DDL)
-- The ALTER command is used to modify the structure of an existing table 
-- such as adding, deleting, or changing columns.


-- selecting database
use company;
show tables;

-- creating emp table with name column
CREATE TABLE emp (
    emp_name VARCHAR(100)
);

show tables;
desc emp;

-- adding  column (by deafult added at the end)
alter table emp add column emp_age int not null;
desc emp;

-- adding emp_id column (add at the begining)
alter table emp add column  emp_id int primary key first;
desc emp;

-- adding "doj" column between name and age
-- there is only "after" command in sql. there is no "before"
alter table emp add column emp_doj date after emp_name;
desc emp;

-- adding multipe column at a time
alter table emp add column (emp_phone varchar(15), gender enum('male','female'));
desc emp;

-- changing column structure size,data type, or add constraint
-- we can modify one column at time
alter table emp modify column emp_phone varchar(20);
desc emp;

alter table emp modify column emp_phone int unique;
desc emp;

-- remianing column
alter table emp rename column emp_phone to phone_number;
desc emp;

-- remianing column
alter table emp rename to employee;
desc employee;



-- adding constraints - add uqiue  constraint on name column
alter table employee add constraint unique_name unique(emp_name);
desc employee;

-- removing constraint
alter table employee drop constraint unique_name;
desc employee;

-- adding constraints - add check  constraint on age column
alter table employee add constraint check_age check(emp_age>18 and emp_age<35);
insert into employee values(1,"sourabh",17,"2025-01-11",84454545,"male"); 
-- Error Code: 3819. Check constraint 'check_age' is violated.	0.000 sec
desc employee;

-- removing constraint
alter table employee drop constraint check_age;
desc employee;