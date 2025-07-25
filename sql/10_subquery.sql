-- What is a Subquery?
-- A subquery is a query inside another query.
-- It is placed in ()
-- Can be used with SELECT, FROM, WHERE, HAVING, etc.

-- when output of one query act as input to another query
-- we generally use subquery on single table
-- ex : show me employees getting salary more than rahul
		-- here first we have to find rahul's salary
		-- then use this as output to find other employees
        
use employee_db;
select * from employee1;
-- show me empoyees getting salary more than rahul
select salary from employee1 where name = "rahul";
select * from employee1 where salary > 10000;

-- solution by subquery
select * from employee1 where salary > 
(select salary from employee1 where name = "rahul");

-- show employes who lives in the city where rani lives
select * from employee1 where city =
(select city from employee1 where name="rahul");

-- show employees who are getting more than avg salary of company
select * from employee1 where salary >
(select avg(salary) from employee1);

