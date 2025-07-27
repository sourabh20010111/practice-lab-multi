-- Views in MySQL – Definition and Usage
-- Definition:
-- A view in MySQL is a virtual table that is defined by a SQL query.
-- It does not store data itself but displays data from one or more tables based on the query used to create it.
-- You can think of a view as a saved SELECT statement that can be treated like a table.

-- Why Use Views?
-- Simplify complex SQL queries
-- Hide sensitive data (security)
-- Present data in a specific format
-- Reduce code duplication
-- Provide backward compatibility in applications
-- To restrict access to specific rows/columns

-- | Action     | Syntax Example                                  |
-- | ---------- | ----------------------------------------------- |
-- | Create     | `CREATE VIEW ... AS SELECT ...`                 |
-- | Use        | `SELECT * FROM view_name;`                      |
-- | Update     | `UPDATE view_name SET ...`                      |
-- | Modify     | `CREATE OR REPLACE VIEW`                        |
-- | Delete     | `DROP VIEW view_name;`                          |
-- | List Views | `SHOW FULL TABLES ... WHERE TABLE_TYPE='VIEW';` |
-- ----------------------------------------------------------------------------------------------------------------------
use employee_db;

CREATE TABLE employees (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    department VARCHAR(50),
    salary DECIMAL(10,2),
    hire_date DATE
);
desc employees;

INSERT INTO employees (name, department, salary, hire_date) VALUES
('Amit Sharma', 'HR', 45000.00, '2020-03-15'),
('Neha Verma', 'Finance', 52000.00, '2019-07-21'),
('Rajesh Kumar', 'IT', 67000.00, '2018-12-01'),
('Sneha Joshi', 'Sales', 49000.00, '2021-04-10'),
('Vikram Singh', 'IT', 73000.00, '2017-09-18'),
('Anjali Mehta', 'Finance', 51000.00, '2020-11-25'),
('Deepak Chauhan', 'HR', 47000.00, '2019-06-14'),
('Kiran Patil', 'Sales', 56000.00, '2022-01-05'),
('Rohit Sinha', 'IT', 80000.00, '2016-02-20'),
('Pooja Desai', 'HR', 42000.00, '2023-08-01');
select * from employees;

-- Creating a View
CREATE VIEW high_salary_employees AS
SELECT emp_id, name, department, salary
FROM employees
WHERE salary > 50000;

-- Using a View
SELECT * FROM high_salary_employees;

-- Updating Data Through a View
UPDATE high_salary_employees
SET salary = 60000
WHERE name = 'neha verma';

SELECT * FROM high_salary_employees;
-- Allowed if:
-- View is from a single table
-- No use of GROUP BY, HAVING, JOIN, etc.
-- ----------------------------------------------------------------------------------------------------------------------

-- Modifying a View
CREATE OR REPLACE VIEW high_salary_employees AS
SELECT name, salary, department
FROM employees
WHERE salary > 50000;

SELECT * FROM high_salary_employees;

-- WITH CHECK OPTION
-- Ensures only rows matching the view's condition can be inserted or updated via the view.
CREATE VIEW sales_view AS
SELECT * FROM employees
WHERE department = 'Sales'
WITH CHECK OPTION;

select * from sales_view;

-- Try to Insert Data into View (Correct Department)
INSERT INTO sales_view (name, department, salary)
VALUES ('Nikhil Tiwari', 'sales', 65000.00);
-- This will work because it matches the view's WHERE condition.

-- Try to Insert Data into View (Wrong Department)
INSERT INTO sales_view (name, department, salary)
VALUES ('Suman Rao', 'HR', 48000.00);
-- Error! Rejected because department = 'HR' is not allowed in this view.

-- Try to Update an IT Employee to a Different Department
UPDATE it_employees
SET department = 'Finance'
WHERE name = 'Rajesh Kumar';
-- Error! View will reject this update.

-- | Feature           | Behavior                                   |
-- | ----------------- | ------------------------------------------ |
-- | **Insert**        | Allowed **only if condition is true**      |
-- | **Update**        | Must not change data **outside condition** |
-- | **Delete**        | Allowed — doesn't affect the condition     |
-- | **Without CHECK** | You can insert/update anything             |

-- List All Views in a Database
SHOW FULL TABLES WHERE TABLE_TYPE = 'VIEW';

-- Deleting a View
DROP VIEW high_salary_employees;

-- Important Notes:
-- Views can be queried just like tables.
-- Views do not improve performance — they just simplify access.
-- You cannot index views directly.
-- Views are re-evaluated each time you query them.




