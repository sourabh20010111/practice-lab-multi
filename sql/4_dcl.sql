-- DCL – Data Control Language in SQL
-- DCL commands are used to control access and permissions on database objects. 
-- These commands manage who can do what in the database.

-- | Command  | Description                                                    |
-- | -------- | -------------------------------------------------------------- |
-- | `GRANT`  | Gives privileges to users (e.g., SELECT, INSERT, UPDATE, etc.) |
-- | `REVOKE` | Removes previously granted privileges                          |


-- defFult database where all users information is stored
show databases;

-- selecting mysql database
use mysql;

-- showing all tables present isnide mysql database
show tables;

-- using user table
select * from user; -- * means all columns in user table
select User from user; -- here User is column name present inside user table

-- creating our own users
create user 'tom'@'localhost' identified by 'tom@123';
select User from user;
create user 'jerry'@'localhost' identified by 'jerry@123';
select User from user;

-- check current user
select current_user();
select user();

-- checking permission for perticular user
show grants for 'root'@'localhost';
show grants for 'tom'@'localhost';
show grants for 'jerry'@'localhost';

-- giving permissions to users
-- GRANT permission_name(s) ON DATABASE_NAME.TABLE_NAME TO user_name
use company;
show tables;
select * from employee;

use mysql;

-- one permission on one table at a time
GRANT insert ON company.employee TO 'tom'@'localhost';
show grants for 'tom'@'localhost';

-- multiple permissions on one table at a time
GRANT select,update ON company.employee TO 'tom'@'localhost';
show grants for 'tom'@'localhost';

-- all permissions on one table at a time
GRANT all ON company.employee TO 'tom'@'localhost';
show grants for 'tom'@'localhost';

-- all permissions on all tables at a time
GRANT all ON company.* TO 'tom'@'localhost';
show grants for 'tom'@'localhost';

-- all permissions on all databases and all tables at a time
GRANT all ON *.* TO 'tom'@'localhost';
show grants for 'tom'@'localhost';

-- removing permissions
grant insert,update,delete on company.employee to 'jerry'@'localhost';
show grants for 'jerry'@'localhost';

revoke insert on company.employee from 'jerry'@'localhost';
show grants for 'jerry'@'localhost';

-- delete user from the database
drop user 'jerry'@'localhost';
use mysql;-- use mysql database first
select User from user;









