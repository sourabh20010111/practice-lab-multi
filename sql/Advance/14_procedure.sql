-- What is a Stored Procedure in MySQL?
-- Definition:
-- A Stored Procedure is a set of SQL statements that are saved in the database 
-- and can be executed multiple times — just like a function in programming.
-- You define it once, then call it when needed.

-- Why Use Stored Procedures?
-- Reuse SQL code (no copy-paste)
-- Encapsulate business logic
-- Improve security (restrict direct table access)
-- Improve performance for repetitive tasks

-- | Action          | Syntax Example             |
-- | --------------- | -------------------------- |
-- | Create          | `CREATE PROCEDURE`         |
-- | Call            | `CALL procedure_name(...)` |
-- | Drop            | `DROP PROCEDURE`           |
-- | List Procedures | `SHOW PROCEDURE STATUS`    |

-- ----------------------------------------------------------------------------------------------------------------------
-- Syntax of a Procedure

-- DELIMITER $$
-- CREATE PROCEDURE procedure_name(IN/OUT parameter_name datatype, ...)
-- BEGIN
--    -- SQL statements here
-- END $$
-- DELIMITER ;

-- ----------------------------------------------------------------------------------------------------------------------
-- displays all the databases 
show databases;

use employee_db;

-- Create Procedure
DELIMITER $$ 
CREATE PROCEDURE get_all_employees()
BEGIN
   SELECT * FROM employees;
END 
$$

-- Check Procedure Definition
SHOW CREATE PROCEDURE get_all_employees;
$$

-- we can call procedure like this inside $$ call procedure_name $$ or after close DELIMITER ; call procedure_name.
$$
CALL get_all_employees();
$$

DELIMITER ;

CALL get_all_employees();

-- ----------------------------------------------------------------------------------------------------------------------
-- | Line           | Meaning                                               |
-- | -------------- | ----------------------------------------------------- |
-- | `DELIMITER $$` | Temporarily change the command-end symbol to `$$`     |
-- | `... ;`        | Inside the procedure, you can use semicolons normally |
-- | `END $$`       | Marks the **end of the whole procedure**              |
-- | `DELIMITER ;`  | Switch back to **normal semicolon** afterward         |

-- | Command        | Meaning                         |
-- | -------------- | ------------------------------- |
-- | `DELIMITER $$` | Set a new end-of-command symbol |
-- | `;` inside     | Used inside procedure body      |
-- | `END $$`       | End of full CREATE PROCEDURE    |
-- | `DELIMITER ;`  | Return to default behavior      |

-- ----------------------------------------------------------------------------------------------------------------------
-- -- Set DELIMITER (e.g., $$) before starting a procedure to handle multiple statements.
-- Reset it to default (;) after the procedure is defined.

-- creating single Row Procedure (Common Reasons Why a Procedure Returns Only One Row)
-- Using SELECT ... INTO Instead of SELECT ..
-- -------------------------------------------------------IN-------------------------------------------------------------
select * from employee;
-- Procedure with Parameters
delimiter %%
create procedure setData(in x int)
begin
select * from employee where id = x;
end;
%%

call setData(114);
%%

-- This will return only one row (and may throw an error if more than one row is returned).
-- Caution: SELECT ... INTO is used only when:
-- You expect a single row
-- You're assigning values to variables

create procedure delRec(in x int)
begin
delete from employee where id = x;
select * from employee;
end;
%%

call delRec(111);
%%

-- Correct Way to Return Multiple Rows (Use a normal SELECT statement (not INTO) to return multiple rows:)

CREATE PROCEDURE get_employees_by_dept(IN dept VARCHAR(50))
BEGIN
    SELECT emp_id, name
    FROM employees 
    WHERE department = dept;
END 
%%
CALL get_employees_by_dept('Sales');
%%

-- Important Notes
-- | Case                  | Use                       |
-- | --------------------- | ------------------------- |
-- | Return 1 value        | `OUT`                     |
-- | Return 1 row          | `SELECT ... INTO`         |
-- | Return multiple rows  | `SELECT` inside procedure |
-- | Input-based filtering | Use `IN` parameters       |

-- ----------------------------------------------------------------------------------------------------------------------
-- | Usage                           | Returns         |
-- | ------------------------------- | --------------- |
-- | `SELECT * FROM table WHERE ...` | Multiple rows ✅ |
-- | `SELECT ... INTO var FROM ...`  | Only one row ❗  |

-- ------------------------------------------------OUT--------------------------------------------------------------------
-- OUT Parameters in MySQL
-- OUT parameters are used to return a single value from a stored procedure to the caller.
-- You must use the SELECT ... INTO syntax to assign a value to the OUT parameter.
-- OUT parameters cannot return multiple rows — only one scalar value (like a string, number, or date).
-- After calling the procedure, you can retrieve the result using a session variable (e.g., @result).
-- Useful when you need to compute or fetch one value such as:
-- Total count
-- Max salary
-- Single employee name by ID

create procedure getempwithphone(out y varchar(20))
begin
select name into y from employee where phone="9991000012";
end;
%%

call getempwithphone(@m);
%%
select @m;
%%

delete from employee where name=@m;
%%
select * from employee;
%%
-- --------------------------------THIS WILL GIVE ERROR ---------------------------------------------------------------------------
-- Error Code: 1172. Result consisted of more than one row	0.000 sec
create procedure storeData(out y int)
begin
select id into y from employee where bonus=1000;
end;
%%
call storeData(@s);
%%
-- Caution:
-- If more than one employee has the same bonus, 
-- SELECT INTO will throw an error — so it's safer to use LIMIT 1.
-- ----------------------------------------combine example in,out----------------------------------------------------------------
create procedure setValues(in x int , out y varchar(50))
begin
select name into y from employee where salary=x;
end;
%%

call setValues(60000,@m);
%%

select @m;
%%
-- --------------------------------------------------------INOUT-------------------------------------------------------------
-- Definition:
-- An INOUT parameter in a procedure:
-- Takes a value as input
-- Can also be modified inside the procedure
-- Returns the updated value to the caller

-- Example Use Case:
-- Suppose we want to:
-- Pass an employee ID as input
-- Get the employee's salary
-- Add a bonus to it
-- Return the new salary
-- ----------------------------------------------------------------------------------------------------------------------
-- INOUT parameters cannot return multiple rows.
-- if query returns more than one row it wil throw error
-- ----------------------------------------------------------------------------------------------------------------------
create procedure storeValuesIO(inout r int)
begin
select salary into r from employee where id=r;
end;
%%

-- Set the INOUT parameter (id value)
set @t=113;
%%
-- Call the procedure (pass employee id)
call storeValuesIO(@t);
%%
-- See the salary of employee
select @t as salary;
%%

CREATE PROCEDURE add_bonus(IN empid INT, INOUT updatedSalary DECIMAL(10,2))
BEGIN
    SELECT salary + updatedSalary
    INTO updatedSalary
    FROM employee
    WHERE id = empid;
END 
%%

-- Set the INOUT parameter (bonus value)
SET @bonus = 5000;
%%
-- Call the procedure (pass employee ID and bonus)
CALL add_bonus(116, @bonus);
%%
-- See the new salary after bonus
SELECT @bonus AS new_salary;
%%

delimiter ;
-- ----------------------------------------------------------------------------------------------------------------------

-- | Feature       | Description                                         |
-- | ------------- | --------------------------------------------------- |
-- | `INOUT`       | Pass value **in**, modify it, return out            |
-- | Syntax        | `INOUT param_name datatype`                         |
-- | Use Case      | Update + return values like counters, bonuses, etc. |
-- | Access result | Use session variable (e.g., `@x`)                   |

-- ----------------------------------------------------------------------------------------------------------------------
-- for delete a Procedure
-- DROP PROCEDURE procedure_name;

-- Parameter Types in Procedures
-- | Type    | Description           |
-- | ------- | --------------------- |
-- | `IN`    | Input only            |
-- | `OUT`   | Output only           |
-- | `INOUT` | Both input and output |

-- View Procedure List
-- SHOW PROCEDURE STATUS WHERE Db = 'your_database_name';


