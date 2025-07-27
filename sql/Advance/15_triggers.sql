-- What is a Trigger in MySQL?
-- Definition:
-- A trigger is a set of SQL statements that automatically 
-- execute when a specific event occurs on a table — like INSERT, UPDATE, or DELETE.
-- Think of it like a "listener" that watches a table and runs code when something changes.

-- Why Use Triggers?
-- Enforce business rules
-- Log changes automatically (auditing)
-- Validate data before insert/update
-- Maintain related tables
-- ------------------------------------------------------------------------------------------------------------------------
-- OLD and NEW in Triggers
-- | Keyword | Used In       | Meaning                                        |
-- | ------- | ------------- | ---------------------------------------------- |
-- | `NEW`   | INSERT/UPDATE | Refers to new value being inserted/updated     |
-- | `OLD`   | UPDATE/DELETE | Refers to existing value being updated/deleted |
-- ----------------------------------------------------------------------------------------------------------------------
use employee_db;
create table products(pid int,pname varchar(10),price int);
insert into products values(1,"abc",10),(2,"pqr",20);

delimiter %%

create trigger setPrice
before insert on products
for each row
begin
if new.price<0 then set new.price=5;
end if;
end;
%%

insert into products values(3,"xyz",-9);
%%

select * from products;
%%

-- ----------------------------------------------------------------------------------------------------------------------

create table newemptab(eid int, ename varchar(10),city varchar(20));
%%
create table delemptab(eid int, ename varchar(10),city varchar(20));
%%
insert into newemptab values(1,"abc","mumbai"),(2,"pqr","gujrat"),(3,"xyz","goa");
%%

create trigger deleteoriginaldata
after delete on newemptab
for each row
begin
insert into delemptab values(old.eid,old.ename,old.city);
end;
%%

delete from newemptab where eid=2;
%%

select * from newemptab;
%%
select * from delemptab;
%%

-- -----------------------------------------------------------------------------------------------------------------------
-- Triggers run automatically on data changes.
-- Use BEFORE/AFTER and INSERT/UPDATE/DELETE as needed.
-- Can access row values with NEW.column and OLD.column.
-- Great for auditing, validation, and automation.
-- ------------------------------------------------------------------------------------------------------------------------
-- Types of Trigger Events
-- | Timing   | Events   | Description            |
-- | -------- | -------- | ---------------------- |
-- | `BEFORE` | `INSERT` | Before row is inserted |
-- | `BEFORE` | `UPDATE` | Before row is updated  |
-- | `BEFORE` | `DELETE` | Before row is deleted  |
-- | `AFTER`  | `INSERT` | After row is inserted  |
-- | `AFTER`  | `UPDATE` | After row is updated   |
-- | `AFTER`  | `DELETE` | After row is deleted   |
-- ----------------------------------------------------------------------------------------------------------------------

CREATE TABLE maindata (eid INT,ename VARCHAR(10),city VARCHAR(20));
%%
CREATE TABLE backupdata (eid INT,ename VARCHAR(10),city VARCHAR(20));
%%
INSERT INTO maindata VALUES
(1, 'abc', 'bombay'),
(2, 'pqr', 'gujrat'),
(3, 'xyz', 'goa');
%%
INSERT INTO backupdata VALUES
(1, 'abc', 'bombay'),
(2, 'pqr', 'gujrat'),
(3, 'xyz', 'goa');
%%

CREATE TRIGGER updatedata
AFTER UPDATE ON maindata
FOR EACH ROW
BEGIN
    UPDATE backupdata
    SET ename = NEW.ename,
        city = NEW.city
    WHERE eid = NEW.eid;
END
%%
-- Check Tables Before Update
SELECT * FROM maindata;
%%
SELECT * FROM backupdata;
%%
UPDATE maindata SET city = 'mumbai' WHERE eid = 1;
%%
-- Check backupdata Table After Trigger Fires
SELECT * FROM backupdata;
%%

-- ----------------------------------------------------------------------------------------------------------------------

create table empdata(eid int auto_increment primary key, ename varchar(20),email varchar(50));
%%
create table message(eid int auto_increment primary key,message_text varchar(50),created_at timestamp default current_timestamp);
%%

create trigger add_welcome_messages
after insert on empdata
for each row
begin
insert into message(message_text) values(concat("welcome to an our organisation, ",new.ename," !"));
end;
%%

insert into empdata(ename,email)values("sourabh","sourabh@gmail.com");
%%
select * from empdata;
%%
select * from message;
%%

-- ------------------------------------------------------------------------------------------------------------------------
delimiter ;
-- Show all triggers:
SHOW TRIGGERS;

-- Drop a trigger:
DROP TRIGGER trigger_name;
