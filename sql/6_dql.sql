-- DQL – Data Query Language in SQL
-- DQL (Data Query Language) is a subset of SQL 
-- used to retrieve and query data from one or more tables in a database.
-- Definition:
-- DQL is focused on fetching data without changing it. 
-- It allows users to ask questions (queries) about the data stored in relational tables.

-- | Command  | Description                                                             |
-- | -------- | ----------------------------------------------------------------------- |
-- | `SELECT` | Retrieves data from a table (with options to filter, sort, group, etc.) |



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
    phone varchar(20) unique not null,
    per_day INT,
	total_leaves INT,
	bonus INT
);

show tables;

desc employee;

INSERT INTO employee (id, name, age, gender, doj, salary, skills, phone, per_day, total_leaves, bonus) VALUES
(111, 'Isha', 25, 'f', '2023-01-10', 55000, 'java', '9991000011', 2000, 2, 1000),
(112, 'Nikhil', 30, 'm', '2022-10-22', 51000, 'java,sql', '9991000012', 1900, 1, 1200),
(113, 'Tina', 22, 'f', '2021-07-14', 43000, NULL, '9991000013', 1600, 0, 900),
(114, 'Yash', 29, 'm', '2020-04-17', 62000, 'sql,python', '9991000014', 2100, 1, 3000),
(115, 'Pooja', 27, 'f', '2023-02-28', 45000, 'python', '9991000015', 1700, 3, 1500),
(116, 'Farhan', 26, 'm', '2021-12-09', 47000, 'java,python', '9991000016', 1800, 4, 2000),
(117, 'Komal', 21, 'f', '2022-05-11', 39000, NULL, '9991000017', 1500, 2, 1000),
(118, 'Harsh', 32, 'm', '2023-06-01', 47000, 'sql,java', '9991000018', 1800, 1, 500),
(119, 'Ritika', 23, 'f', '2021-08-20', 46000, 'python', '9991000019', 1700, 0, 800),
(120, 'Saurabh', 28, 'm', '2021-06-10', 54000, 'java,sql,python', '9991000020', 2100, 2, 2000),
(121, 'Neha', 24, 'f', '2022-03-15', 41000, 'sql', '9991000021', 1600, 2, 1000),
(122, 'Raj', 30, 'm', '2023-04-12', 50000, 'java,sql', '9991000022', 1900, 1, 1500),
(123, 'Snehal', 26, 'f', '2020-12-18', 48000, 'sql,python', '9991000023', 1800, 0, 1300),
(124, 'Tarun', 28, 'm', '2021-11-07', 53000, NULL, '9991000024', 2000, 3, 1800),
(125, 'Anjali', 25, 'f', '2022-06-21', 47000, 'java,python', '9991000025', 1750, 2, 1600),
(126, 'Manav', 29, 'm', '2023-05-01', 49000, 'java,sql', '9991000026', 1850, 2, 1700),
(127, 'Reema', 31, 'f', '2021-10-25', 60000, 'sql', '9991000027', 2200, 1, 2500),
(128, 'Ajay', 27, 'm', '2022-02-08', 52000, 'java,sql,python', '9991000028', 2000, 0, 3000),
(129, 'Simran', 22, 'f', '2023-03-17', 45000, NULL, '9991000029', 1700, 2, 1400),
(130, 'Karan', 30, 'm', '2020-01-29', 55000, 'sql,python', '9991000030', 2100, 3, 1900);

select * from employee;

-- SELECT WITH ARITHMATIC OPERATORS : +, -, *, /
-- show monthly salary of each employee
select name,per_day*30 as salary from employee;

-- show salary after giving bonus
select name, per_day*30+bonus as salary_bonus from employee;
select name,per_day*30 as salary, per_day*30+bonus as salary_bonus from employee;

-- show salary after removing leaves
select name, per_day*(30-total_leaves) as final_salary from employee;

-- make salary half of each employee
select name,(per_day*30)/2 as half_salary from employee;

-- SELECT WITH COMPARISION OPERATORS: <, >, <=, >=, !=, <>
select * from employee where per_day<10000;
select * from employee where per_day>1000;
select * from employee where per_day<=10000;
select * from employee where per_day>=1000;
select * from employee where per_day=1000;
select * from employee where per_day!=1000;
select * from employee where per_day<>1000;

-- show employees who are getting salary more than 30k
select * from employee where per_day*30>30000;


-- SELECT WITH LOGICAL OPERATORS : and, or, not

-- show employees who are getting per_day more than 1000 as well as  has leaves more than 2 days
select * from employee where per_day>1000 and total_leaves>2;

-- show employees who are getting either per_day more than 1000 or has leaves more than 2 days
select * from employee where per_day>1000 or total_leaves>2;

-- show employees who are getting either per_day more than 5000 or has leaves more than 3 days
select * from employee where per_day>5000 or total_leaves>3;

-- show me employees whos name is not isha
select * from employee where not name = "isha";

-- SLEECT WITH IN , NOT IN OPERATOR
-- show empoyees getting per_day either 1000 or 2000 or 3000
select * from employee where per_day=1000 or per_day=2000 or per_day=3000;

-- instead of using multiple OR statements, use IN operator
select * from employee where per_day in(1000,2000,3000);
select * from employee where per_day not in(1000,2000,3000);

-- SELECT WITH RANGE OPERATOR (BETWEEN)
-- show employees getting per_day in range 1000-2000
select * from employee where per_day between 1000 and 2000;
-- IMPORTANT : here 1000 and 2000 both values will be included

-- show employees who are not getting per_day in range 1000-2000
select * from employee where per_day not between 1000 and 2000;

-- SELECT WITH LIKE
-- % means any characher with any number
-- show me employees whos name starts with 'r'
select * from employee where name like 'r%';

-- show me employees whos name starts with 'ra'
select * from employee where name like 'ra%';

-- show me employees whos name ends with 'a'
select * from employee where name like '%a';

-- show me employees whos name ends with 'na'
select * from employee where name like '%na';

-- when we want to specify number of characters (not characters) then use _
select * from employee where name like 'r_j';

-- exactly 4 characters before 't'
select * from employee where name like '____a';

-- exactly 5 characters before 't'
select * from employee where name like '_____a';

-- name must have 'a' as second character
select * from employee where name like '_a%';

-- SELECT WITH LIMIT
-- below query will return only top 2 recods
select * from employee limit 2;
select * from employee where name like 'r%' limit 1;

-- SELECT WITH LIMIT OFFSET
-- SELECT * FROM table_name
-- LIMIT row_count OFFSET start_position;
select * from employee;
SELECT * FROM employee LIMIT 5 OFFSET 5;

-- SELECT WITH ORDER BY (defaulr oeder is ascending)
-- sort employees based on per_day ascending order
select name,per_day from employee order by per_day;

-- sort employees based on per_day descending order
select name,per_day from employee order by per_day desc;

-- sort employees based on name ascending order
select * from employee order by name;

-- order by with where condition
select * from employee where total_leaves>2 order by total_leaves;


-- SELECT WITH IS NULL
select * from employee where skills is null;
select * from employee where skills is not null;





