-- constraints : Definition of Constraints in SQL
-- Constraints in SQL are rules applied to columns in a table to enforce data integrity — i.e., 
-- to ensure valid and consistent data.

-- | Constraint             | Description                                                    |
-- | ---------------------- | -------------------------------------------------------------- |
-- | **1. PRIMARY KEY**     | Uniquely identifies each record in a table                     |
-- | **2. FOREIGN KEY**     | Links a column to the `PRIMARY KEY` in another table           |
-- | **3. NOT NULL**        | Ensures a column cannot have `NULL` values                     |
-- | **4. UNIQUE**          | Ensures all values in a column are different                   |
-- | **5. CHECK**           | Ensures a condition is true for the values in a column         |
-- | **6. DEFAULT**         | Assigns a default value if none is provided                    |
-- | **7. AUTO\_INCREMENT** | Automatically increases numeric values (MySQL-specific)        |
-- | **8. ENUM**            | Allows only one value from a predefined list (MySQL-specific)  |
-- | **9. SET**             | Allows multiple values from a predefined list (MySQL-specific) |
-- eg:-
-- CREATE TABLE employees (
--     employee_id INT PRIMARY KEY AUTO_INCREMENT,                    -- Primary Key
--     first_name VARCHAR(50) NOT NULL,                               -- NOT NULL
--     last_name VARCHAR(50) NOT NULL,
--     gender ENUM('Male', 'Female', 'Other') NOT NULL,               -- ENUM: one choice only
--     email VARCHAR(100) NOT NULL UNIQUE,                            -- UNIQUE
--     phone_number VARCHAR(15) UNIQUE,                               -- UNIQUE
--     hire_date DATE NOT NULL,
--     job_title VARCHAR(50) NOT NULL,
--     skills SET('Java', 'Python', 'SQL', 'HTML', 'CSS') DEFAULT '', -- SET: multiple values allowed
--     salary DECIMAL(10,2) CHECK (salary >= 10000),                  -- CHECK
--     department_id INT,                                             -- Foreign key

--     CONSTRAINT fk_department
--         FOREIGN KEY (department_id) REFERENCES departments(department_id)
--         ON DELETE SET NULL
-- );

-- selecting database in which we want to create table
use company;

-- creating employees table with proper constraints
CREATE TABLE departments (
    department_id INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE employees (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,                    
    first_name VARCHAR(50) NOT NULL,                               
    last_name VARCHAR(50) NOT NULL,
    gender ENUM('Male', 'Female', 'Other') NOT NULL,               
    email VARCHAR(100) NOT NULL UNIQUE,                           
    phone_number VARCHAR(15) UNIQUE,                               
    hire_date DATE NOT NULL,
    job_title VARCHAR(50) NOT NULL,
    skills SET('Java', 'Python', 'SQL', 'HTML', 'CSS') DEFAULT '', 
    salary DECIMAL(10,2) CHECK (salary >= 10000),                 
    department_id INT,     
    
    CONSTRAINT fk_department
        FOREIGN KEY (department_id) REFERENCES departments(department_id)
        ON DELETE SET NULL
);


-- getting all tables from database
show tables;

-- getting structure of newly created table - employees
desc employees;

-- inserting one correct record and multiple records
INSERT INTO departments (department_name) VALUES('Human Resources');

INSERT INTO employees(first_name, last_name, gender, email, phone_number, hire_date, job_title, skills, salary, department_id)
VALUES('Anita', 'Rao', 'Female', 'anita.rao@example.com', '9123456789', '2024-04-01', 'Backend Developer', 'Java,SQL', 65000.00, 1);


-- use below command if you have entered wrong data
-- by running below command you are going to remove all records from table
truncate employees;
-- truncate departments;	
-- Error Code: 1701. Cannot truncate a table referenced in a foreign key constraint (`company`.`employees`, CONSTRAINT `fk_department`)

-- we cannot use drop or truncate command on department table because of foreign key either we drop foreign key or drop first employees table and then department
drop table employees;
drop table departments;

-- getting all records from table
select * from employees;
select * from departments;

-- add some records before create employees and department table
INSERT INTO departments (department_name) VALUES
('Human Resources'),
('Information Technology'),
('Finance'),
('Marketing'),
('Research and Development');

INSERT INTO employees (first_name, last_name, gender, email, phone_number, hire_date, job_title, skills, salary, department_id)
VALUES
('Anita', 'Rao', 'Female', 'anita.rao@example.com', '9123456789', '2024-04-01', 'Backend Developer', 'Java,SQL', 65000.00, 2),

('Rahul', 'Verma', 'Male', 'rahul.verma@example.com', '9876543210', '2023-06-15', 'HR Manager', 'SQL', 72000.00, 1),

('Sneha', 'Kumar', 'Female', 'sneha.kumar@example.com', '8899776655', '2022-10-20', 'Financial Analyst', 'SQL', 58000.00, 3),

('Karan', 'Patel', 'Male', 'karan.patel@example.com', '7788996655', '2021-01-12', 'Frontend Developer', 'HTML,CSS', 60000.00, 4),

('Neha', 'Singh', 'Other', 'neha.singh@example.com', '9988776655', '2025-01-01', 'AI Researcher', 'Python,SQL', 90000.00, 5);



-- adding wrong data and checking what types of error we get

-- adding duplicate employees (voilating uniue constraint)

insert into employees (first_name, last_name, gender, email, phone_number, hire_date, job_title, skills, salary, department_id)
VALUES ('Neha', 'Singh', 'Other', 'neha.singh@example.com', '9988776655', '2025-01-01', 'AI Researcher', 'Python,SQL', 90000.00, 5);
-- Error Code: 1062. Duplicate entry 'neha.singh@example.com' for key 'employees.email'	

-- not adding employees (voilating not null constraint)
-- wrong way
insert into employees (first_name, last_name, gender, email, phone_number, hire_date, job_title, skills, salary, department_id)
VALUES ('Neha', 'Other', 'neha.singh@example.com', '9988776655', '2025-01-01', 'AI Researcher', 'Python,SQL', 90000.00, 5);
-- Error Code: 1136. Column count doesn't match value count at row 1	

-- not adding employees (voilating not null constraint)
-- correct way
-- not passing value to column means not specifing column name neither passing its value
insert into employees (first_name, gender, email, phone_number, hire_date, job_title, skills, salary, department_id)
VALUES ('Neha', 'Other', 'neha.singh@example.com', '9988776655', '2025-01-01', 'AI Researcher', 'Python,SQL', 90000.00, 5);
-- Error Code: 1364. Field 'last_name' doesn't have a default value
-- IMPORTANT : if there is NOT NULL cnstraint on any column then either specify default value or pass value


-- not passing  skills (checking working of default constraint)
insert into employees (first_name, last_name, gender, email, phone_number, hire_date, job_title,salary, department_id)
VALUES ('sourabh', 'sonkar','male', 'sourabh@example.com', '98983101532', '2025-01-11', 'AI Researcher', 90000.00, 5);
select * from employees;

-- paasing value not in range of check constraint (voileting check constraint)
insert into employees (first_name, last_name, gender, email, phone_number, hire_date, job_title,salary, department_id)
VALUES ('sourabh', 'sonkar','male', 'sourabh@example.com', '98983101532', '2025-01-11', 'AI Researcher', 9000.00, 5);
-- Error Code: 3819. Check constraint 'employees_chk_1' is violated.

--  passing value not specified in enum (voileting enum constraint)
insert into employees (first_name, last_name, gender, email, phone_number, hire_date, job_title,salary, department_id)
VALUES ('ruhi', 'joe','trans', 'ruhi@example.com', '98983101532', '2025-01-11', 'AI Researcher', 90000.00, 5);
-- Error Code: 1265. Data truncated for column 'gender' at row 1

--  passing value not specified in set (voileting set constraint)
insert into employees (first_name, last_name, gender, email, phone_number, hire_date, job_title,skills,salary, department_id)
VALUES ('sourabh', 'sonkar','male', 'sourabh@example.com', '98983101532', '2025-01-11', 'AI Researcher','comdey',90000.00, 5);
-- Error Code: 1265. Data truncated for column 'skills' at row 1
