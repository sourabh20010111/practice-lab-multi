-- In SQL, GROUP BY and HAVING are used together to group rows and filter grouped results.
-- GROUP BY Clause:
-- Used to group rows that have the same values in specified columns.
-- Often used with aggregate functions like COUNT(), SUM(), AVG(), etc.

-- HAVING Clause
-- Used to filter the results of groups created by GROUP BY.
-- Similar to WHERE, but WHERE is used before grouping, and HAVING is used after grouping.

-- always use aggrigate function with group by.
-- never ever use single column. dont write group by query without aggrigate function

use employee_db;
drop table employee;
show tables;

CREATE TABLE employee1(
    id INT PRIMARY KEY,
    name VARCHAR(20),
    city VARCHAR(20),
    gender VARCHAR(2),
    salary DOUBLE
);

INSERT INTO employee1 VALUES 
(1, 'Rahul', 'Mumbai', 'M', 55000),
(2, 'Sneha', 'Delhi', 'F', 62000),
(3, 'Amit', 'Bangalore', 'M', 58000),
(4, 'Pooja', 'Chennai', 'F', 49000),
(5, 'Vikas', 'Hyderabad', 'M', 53000),
(6, 'Neha', 'Pune', 'F', 60000),
(7, 'Karan', 'Mumbai', 'M', 47000),
(8, 'Riya', 'Delhi', 'F', 51000),
(9, 'Sahil', 'Bangalore', 'M', 62000),
(10, 'Anjali', 'Chennai', 'F', 45000),
(11, 'Manish', 'Hyderabad', 'M', 58000),
(12, 'Tina', 'Pune', 'F', 49000),
(13, 'Arjun', 'Mumbai', 'M', 67000),
(14, 'Divya', 'Delhi', 'F', 52000),
(15, 'Rohit', 'Bangalore', 'M', 60000),
(16, 'Kavita', 'Chennai', 'F', 48000),
(17, 'Deepak', 'Hyderabad', 'M', 55000),
(18, 'Meena', 'Pune', 'F', 61000),
(19, 'Sameer', 'Mumbai', 'M', 49000),
(20, 'Asha', 'Delhi', 'F', 53000);


select * from employee1;
select city from employee1;
select gender from employee1;
select distinct city from employee1;
select distinct gender from employee1;
select city from employee1 group by city;
select gender from employee1 group by gender;

-- show me city wise max salary
select * from employee1;
select max(salary),city from employee1; -- Error Code: 1140. In aggregated query without GROUP BY, expression #2 of SELECT list contains nonaggregated column 'employee_db.employee1.city'; this is incompatible with sql_mode=only_full_group_by

select max(salary),city from employee1 group by city;

select city,name from employee1 group by city; -- dont write queries like this

-- show me gender wise max salary
select max(salary),gender from employee1 group by gender;

-- city wise min salary
select min(salary),city from employee1 group by city;
-- city wise total salary
select sum(salary),city from employee1 group by city;
-- city wise total employees
select city,count(*) from employee1 group by city;

-- how many m and f are there in each city
select city,gender,count(gender) from employee1 group by city,gender;

-- show city name where company spending total salary more than 30000 
-- sum(salary)>30000;
select city, sum(salary) from employee1 group by city having sum(salary)>30000;

-- check which gender getting max salary
select max(salary), gender from employee1 group by gender;

-- important note
--  Remember:
-- Use WHERE to filter before grouping
-- Use HAVING to filter after grouping
