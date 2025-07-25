-- DDL – Data Definition Language in SQL
-- DDL (Data Definition Language) consists of SQL commands used to define, modify, and delete 
-- the structure of database objects like tables, schemas, indexes, etc.

-- | Command    | Description                                                |
-- | ---------- | ---------------------------------------------------------- |
-- | `CREATE`   | Creates a new table, database, index, or view              |
-- | `ALTER`    | Modifies an existing table (e.g., add/drop/modify columns) |
-- | `DROP`     | Deletes tables, views, or databases permanently            |
-- | `TRUNCATE` | Deletes all records from a table but retains its structure |
-- | `RENAME`   | Renames a table or column (depends on DBMS support)        |

-- to check all databases
show databases;

-- to create database
-- create database database_name;
create database company;

-- check employees databases created or not
show databases;

-- to drop/delete database
-- drop database database_name;
drop database company;

-- create employees database 
-- create database database_name;
create database company;

-- to select database for creating table
-- use database_name;
use company;

-- creating table inside company database
-- create table table_name (column_name datatype[(size)] [constraints]);
CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(15),
    hire_date DATE,
    job_title VARCHAR(50),
    salary DECIMAL(10, 2),
    department VARCHAR(50)
);


-- to check all tables in selected database (employees)
show tables;

-- checking structure of newly created tablec
-- describe table_name;
describe employees;

-- to drop/deleting table
-- drop table table_name;
drop table employees;

-- inserting record into table
-- insert into table_name(column1, column2 ....) values (value1, value2.....)
INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_title, salary, department)
VALUES 
('John', 'Doe', 'john.doe@example.com', '1234567890', '2022-01-15', 'Software Engineer', 60000.00, 'IT'),
('Jane', 'Smith', 'jane.smith@example.com', '9876543210', '2021-03-10', 'HR Manager', 75000.00, 'HR'),
('Robert', 'Brown', 'robert.brown@example.com', '8765432190', '2023-07-01', 'Data Analyst', 58000.00, 'Analytics');


-- to check all data inside table
-- select * from table_name
select * from employees;