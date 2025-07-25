-- What Are SQL Functions?
-- SQL functions are predefined routines that take input (arguments), perform an operation, and return a result. 
-- They're used in queries to manipulate or analyze data.

-- -----------------------------------------------------------------------------------------------------------------
-- Types of SQL Functions
-- SQL functions are usually grouped into:

-- 1. Single-Row (Scalar) Functions
-- Operate on one row at a time
-- Return one value for each row

-- | Type                      | Examples                                                    |
-- | ------------------------- | ----------------------------------------------------------- |
-- | **String Functions**      | `CONCAT()`, `LENGTH()`, `UPPER()`, `LOWER()`, `SUBSTRING()` |
-- | **Numeric Functions**     | `ROUND()`, `ABS()`, `CEIL()`, `FLOOR()`, `MOD()`            |
-- | **Date & Time Functions** | `NOW()`, `CURDATE()`, `DATEDIFF()`, `DATE_FORMAT()`         |
-- | **Conversion Functions**  | `CAST()`, `CONVERT()`                                       |
-- ----------------------------------------------------------------------------------------------------------------------

use employee_db;
show tables;
-- use previous table employee with same data
select * from employee;

-- Built in functions
-- Built in functions always use with SELECT
-- STRING FUNCTION
select concat("python","java");
select concat("python","java") as new_column;
select concat(salary,name) as salary_with_name from employee;
select concat(salary," ",name) as salary_with_name from employee;
select upper(name) from employee;
select lower(name) from employee;
select concat_ws(" ",name,length(name)) from employee;
select reverse(name) from employee;

-- using separator with concat
select concat(name," ",bonus," ",salary) as separatorexample from employee;
select concat_ws(" ",name,salary) as separatorexample from employee;

-- from 2nd character to next 3 characters
-- 2nd character is a, next 3 characters including a are a,h,a
select insert("maharashtra",2,3,"*");
select insert(name,1,2,"-") from employee;

-- ----------------------------------------------------------------------------------------------------------------------
-- Group (Aggregate) Functions
-- Operate on multiple rows
-- Return one result per group or entire table

-- | Function  | Description       |
-- | --------- | ----------------- |
-- | `SUM()`   | Total of values   |
-- | `AVG()`   | Average of values |
-- | `COUNT()` | Number of rows    |
-- | `MIN()`   | Minimum value     |
-- | `MAX()`   | Maximum value     |
-- ----------------------------------------------------------------------------------------------------------------------
-- Aggrigate functions
select min(salary) from employee;
select least(20,30,10,50);
select max(salary) from employee;
select greatest(20,30,10,50);
select avg(salary) as avg_sal from employee;
select sum(salary) from employee;
select * from employee;
select count(*) from employee;
select if(10<5,"yes it is","no");
select name, if(salary>25000,"yes","no") from employee;


select * from employee where salary =(select min(salary) from employee);
select * from employee where salary = 45000;
-- select * from employee where salary = max(salary); error
-- Error Code: 1111. Invalid use of group function	

-- ----------------------------------------------------------------------------------------------------------------------
-- math function
-- abs() gives absolute value / remove sign 
select abs(90);
select abs(-90);

select ceil(40.01);
select ceil(40.99);

select floor(40.01);
select floor(40.99);

select round(40.12);
select round(40.52);

select round(40.125,2);
select round(40.512,2);
select truncate(5.236,1);
select truncate(5.236,2);
select truncate(542,1);
select truncate(542,-1);
select truncate(52.236,-1);
select pow(2,4);
select sqrt(49);
select sqrt(35);
select pow(5.916079783099616,2);
select truncate((select sqrt(35)),2);
select truncate(sqrt(35),2);

-- ----------------------------------------------------------------------------------------------------------------------
-- Date realted functions
select curdate();
select now();
select sysdate();

select year('2025-03-20');
select year(curdate());
select month(curdate());
select day(curdate());
select yearweek('2024-01-08');
select yearweek('2023-12-05');
select last_day(curdate());


select datediff('2024-01-31','2024-01-01');
select datediff('2024-02-14','2024-01-01');
select datediff(last_day(curdate()),curdate());

select date_format('2024-01-31','%Y'); -- year in 4 digit
select date_format('2024-01-31','%y'); -- year in 2 digit
select date_format('2024-01-31','%M'); -- complete month name
select date_format('2024-01-31','%b'); -- month name in 3 letters
select date_format('2024-01-31','%m'); -- month in digit
select date_format('2024-01-31','%D'); -- day with sufficks like 1st,2nd
select date_format('2024-01-31','%d'); -- day with number
select date_format('2024-01-31','%W'); -- week day name
select date_format('2024-01-31','%a'); -- week name with 3 letters
select date_format('2024-01-31','%w'); -- week day number
select date_format('2024-01-31','%d/%M/%Y'); -- date formatting
select date_format('2024-01-31','%d-%M-%Y');

-- ----------------------------------------------------------------------------------------------------------------------
-- Other Useful Functions
-- | Function                             | Purpose                          |
-- | ------------------------------------ | -------------------------------- |
-- | `IFNULL(val, default)`               | Replaces NULL with default value |
-- | `COALESCE(val1, val2, ...)`          | Returns the first non-NULL       |
-- | `IF(condition, true_val, false_val)` | Works like an if-else            |

SELECT name, COALESCE(skills, 'No Skills') FROM employee;

SELECT name, IFNULL(skills, 0) AS zero_skills FROM employee;
SELECT name, IFNULL(skills, 'Not Provided') AS skills FROM employee;

select name, if(salary>55000,"yes","no") from employee;

-- Basic Difference
-- | Feature         | `IFNULL()`                       | `COALESCE()`                              |
-- | --------------- | -------------------------------- | ----------------------------------------- |
-- | **Arguments**   | Takes **2 arguments only**       | Can take **multiple arguments**           |
-- | **Returns**     | Returns 2nd value if 1st is NULL | Returns the **first non-NULL** value      |
-- | **Portability** | Specific to **MySQL**            | **Standard SQL** (supported in many DBMS) |

--  Summary Table
-- | Use Case                                             | `IFNULL()`   | `COALESCE()` |
-- | ---------------------------------------------------- | ------------ | ------------ |
-- | Need just a fallback for one value                   | ✅            | ✅            |
-- | Need to check multiple columns                       | ❌            | ✅            |
-- | Cross-platform (MySQL, PostgreSQL, SQL Server, etc.) | ❌ MySQL only | ✅ Yes        |
-- | More flexible / standard SQL                         | ❌            | ✅            |