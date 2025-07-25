-- What is a Foreign Key in SQL?
-- A foreign key is a column (or set of columns) in one table that refers to the primary key in another table. 
-- It is used to maintain referential integrity between two related tables.

-- Key Points:
-- Creates a relationship between tables.
-- The foreign key must match a primary key value in the referenced table.
-- Prevents invalid data (e.g., you can't assign a department ID that doesn’t exist).

-- when there are muiltple entities in one table, it may create 
-- duplicate records (like patient and doctor data in one table)
-- so it is better to separate those 2 entities and make a new tables
-- for them. and to maintain a relationship between those tables we use primary key 
-- of one table as foreign key in another table

-- REFERENCES – Defines the Relationship
-- This line creates a foreign key relationship between two tables.
-- FOREIGN KEY (child_column) REFERENCES parent_table(parent_column)
-- It tells the database:
-- "child_column must match a value in parent_table(parent_column)"
-- It enforces referential integrity.

-- With only REFERENCES (default behavior)
-- FOREIGN KEY (dept_id) REFERENCES department(dept_id)
-- Will block deletion/update of a department if employees exist

-- With CASCADE
-- FOREIGN KEY (dept_id) REFERENCES department(dept_id)
-- ON DELETE CASCADE ON UPDATE CASCADE
-- Will auto-delete or auto-update employee rows if department changes


use employee_db;
 create table doctor(
 did int primary key,
 dname varchar(20),
 dcity varchar(20),
 dphone varchar(20)
);

INSERT INTO doctor VALUES 
(1, 'Dr. Mehta', 'Mumbai', '9876543210'),
(2, 'Dr. Sharma', 'Delhi', '9812345678'),
(3, 'Dr. Iyer', 'Chennai', '9823456789'),
(4, 'Dr. Khan', 'Hyderabad', '9834567890'),
(5, 'Dr. Roy', 'Kolkata', '9845678901'),
(6, 'Dr. Verma', 'Pune', '9856789012'),
(7, 'Dr. Das', 'Bangalore', '9867890123'),
(8, 'Dr. Joshi', 'Ahmedabad', '9878901234'),
(9, 'Dr. Reddy', 'Vijayawada', '9889012345'),
(10, 'Dr. Thomas', 'Kochi', '9890123456');


select * from doctor;

 create table patient(
 pid int primary key,
 did int, -- this will be my column act as FK to maintain ralationship between doctor and patient
 pname varchar(20),
 pcity varchar(20),
 pphone varchar(20),
 constraint fk_did foreign key(did)
 references doctor(did)
);

desc patient;

INSERT INTO patient VALUES 
(1, 1, 'Aman', 'Mumbai', '9012345678'),
(2, 2, 'Priya', 'Delhi', '9023456789'),
(3, 3, 'Karthik', 'Chennai', '9034567890'),
(4, 4, 'Anita', 'Hyderabad', '9045678901'),
(5, 5, 'Ravi', 'Kolkata', '9056789012'),
(6, 6, 'Sneha', 'Pune', '9067890123'),
(7, 7, 'Rahul', 'Bangalore', '9078901234'),
(8, 8, 'Divya', 'Ahmedabad', '9089012345'),
(9, 9, 'Imran', 'Vijayawada', '9090123456'),
(10, 10, 'Maria', 'Kochi', '9101234567');


select * from patient;

SELECT p.pname, p.pcity, d.dname, d.dcity
FROM patient p
JOIN doctor d ON p.did = d.did;

-- ----------------------------------------------------------------------------------------------------------------------
-- ON DELETE CASCADE in SQL
-- ON DELETE CASCADE is used with a foreign key so that when a record in the parent table is deleted,
-- all related records in the child table are automatically deleted.

-- Your Scenario:
-- If a doctor is deleted from the doctor table, 
-- all patients linked to that doctor in the patient table will also be deleted automatically.

CREATE TABLE new_doctor (
    doc_id INT PRIMARY KEY,
    doc_name VARCHAR(50),
    doc_city VARCHAR(30),
    doc_phone VARCHAR(15)
);
desc new_doctor;
-- Insert doctors
INSERT INTO new_doctor VALUES 
(101, 'Dr. Nair', 'Mumbai', '9000000001'),
(102, 'Dr. Banerjee', 'Delhi', '9000000002'),
(103, 'Dr. Pillai', 'Chennai', '9000000003');
select * from new_doctor;

CREATE TABLE new_patient (
    pat_id INT PRIMARY KEY,
    doc_id INT,
    pat_name VARCHAR(50),
    pat_city VARCHAR(30),
    pat_phone VARCHAR(15),
    CONSTRAINT fk_doc_id FOREIGN KEY (doc_id)
        REFERENCES new_doctor(doc_id)
        ON DELETE CASCADE
);
desc new_patient;
-- Insert patients
INSERT INTO new_patient VALUES 
(1, 101, 'Aakash', 'Mumbai', '9011111111'),
(2, 101, 'Seema', 'Mumbai', '9011111112'),
(3, 102, 'Rohit', 'Delhi', '9022222222'),
(4, 103, 'Neha', 'Chennai', '9033333333');
select * from new_patient;

-- This will delete Dr. Nair and automatically remove his patients (Aakash, Seema)
DELETE FROM new_doctor WHERE doc_id = 101;

-- See remaining patients
SELECT * FROM new_patient;

-- See remaining doctors
SELECT * FROM new_doctor;

-- What is ON UPDATE CASCADE?
-- When you update a primary key value in the parent table, 
-- ON UPDATE CASCADE ensures that the foreign key values in the child table are automatically updated to match.
CREATE TABLE new_doctor_update (
    doc_id INT PRIMARY KEY,
    doc_name VARCHAR(50),
    doc_city VARCHAR(30)
);
CREATE TABLE new_patient_update (
    pat_id INT PRIMARY KEY,
    doc_id INT,
    pat_name VARCHAR(50),
    CONSTRAINT fk_doc_update FOREIGN KEY (doc_id)
        REFERENCES new_doctor_update(doc_id)
        ON UPDATE CASCADE
);
-- Doctors
INSERT INTO new_doctor_update VALUES 
(201, 'Dr. Rao', 'Hyderabad'),
(202, 'Dr. Sen', 'Kolkata');

-- Patients
INSERT INTO new_patient_update VALUES 
(1, 201, 'Kiran'),
(2, 202, 'Manoj');

select * from new_doctor_update;
select * from new_patient_update;

UPDATE new_doctor_update
SET doc_id = 301
WHERE doc_id = 201;

SELECT * FROM new_patient_update;

-- | Action              | Result on Child Table            |
-- | ------------------- | -------------------------------- |
-- | `ON DELETE CASCADE` | Deletes child rows automatically |
-- | `ON UPDATE CASCADE` | Updates child rows automatically |


-- important note:
-- Things to Remember:
-- A foreign key can be NULL unless specified NOT NULL.
-- If you delete a record in the parent table, it may fail unless you use ON DELETE CASCADE.