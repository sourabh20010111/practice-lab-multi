-- TCL – Transaction Control Language
-- TCL (Transaction Control Language) is a subset of SQL 
-- used to manage transactions in a database. Transactions are sequences of SQL 
-- operations that are executed as a single unit to ensure data integrity and consistency.

-- | Command               | Description                                                                        |
-- | --------------------- | ---------------------------------------------------------------------------------- |
-- | **COMMIT**            | Saves all the changes made by the current transaction permanently in the database. |
-- | **ROLLBACK**          | Undoes all changes made by the current transaction (since the last `COMMIT`).      |
-- | **SAVEPOINT**         | Sets a point within a transaction to which you can later roll back.                |
-- | **RELEASE SAVEPOINT** | Deletes a savepoint so it cannot be rolled back to.                                |
-- | **SET TRANSACTION**   | Specifies characteristics of the transaction (like isolation level).               |

use employee_db;
show tables;
drop table employee;

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

-- starting transaction
start transaction;

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

-- creating insert savepint 
savepoint insertion_step;
select * from employee;

-- updating 1 record
update employee set name="raju" where id = 122;
select * from employee;

-- undo update and go to insert savepoint
rollback to insertion_step;
select * from employee;

-- deleting record
delete from employee where id=111;
select * from employee;

-- undoing delete command
rollback to insertion_step;
select * from employee;

-- deleting record
delete from employee where id=130;
select * from employee;

-- commit is used to make permenant change
commit;

-- we cant rollback since we have made commit
rollback to insertion_step;

-- ------------------------------------------------------------------------------------------------------------------------

-- Without creating a savepoint, ROLLBACK will undo only the previous command.
start transaction;
delete from employee where id=111;
select * from employee;
rollback;

update employee set name="reena" where id=113;
rollback;
select * from employee;

commit;

-- -------------------------------------------------------------------------------------------------------------------------
-- RELEASE SAVEPOINT
-- Definition:
-- RELEASE SAVEPOINT is used to remove a savepoint created earlier during a transaction. 
-- After releasing, you cannot roll back to that savepoint.

START TRANSACTION;

SAVEPOINT sp1;
UPDATE employee SET salary = salary + 1000 WHERE id = 111;
select * from employee;
rollback to sp1;


UPDATE employee SET bonus = bonus + 500 WHERE id = 111;
RELEASE SAVEPOINT sp1;
rollback to sp1; -- Error Code: 1305. SAVEPOINT sp1 does not exist
select * from employee;
-- Now this will cause an error because sp1 no longer exists:
-- ROLLBACK TO sp1; -- ❌ Error

-- ------------------------------------------------------------------------------------------------
COMMIT;
-- important note: After COMMIT, the transaction ends automatically.
-- All changes made inside the transaction are permanently saved to the database.
-- The transaction is complete, and you return to the default auto-commit mode (in MySQL).
-- You can’t use ROLLBACK or ROLLBACK TO SAVEPOINT for that transaction anymore.

-- | Step                | Action              | Can Undo?             |
-- | ------------------- | ------------------- | --------------------- |
-- | `START TRANSACTION` | Begin transaction   | Yes                   |
-- | `SAVEPOINT`         | Optional step       | Yes (until committed) |
-- | `COMMIT`            | Finalize everything | ❌ No undo after this |

-- ---------------------------------------------------------------------------------------------------
-- Definition:
-- SET TRANSACTION is used to define the isolation level or access mode of the transaction.
-- 🔒 Isolation Levels:
-- READ UNCOMMITTED – lowest isolation (can read uncommitted data)
-- READ COMMITTED
-- REPEATABLE READ – default in MySQL
-- SERIALIZABLE – strictest (no phantom reads)
-- example 1
SET TRANSACTION ISOLATION LEVEL READ COMMITTED;

START TRANSACTION;

-- Your transactional queries here

COMMIT;

-- example 2
SET TRANSACTION READ WRITE;

START TRANSACTION;

UPDATE employee SET bonus = bonus + 500 WHERE id = 112;

COMMIT;

