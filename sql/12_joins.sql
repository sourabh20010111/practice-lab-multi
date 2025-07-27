-- What is a JOIN in SQL?
-- A JOIN is used to combine rows from two or more tables based on a related column between them.

-- | Join Type       | What it Returns                        |
-- | --------------- | -------------------------------------- |
-- | INNER JOIN      | Matching rows in both tables           |
-- | LEFT JOIN       | All left rows + matched right          |
-- | RIGHT JOIN      | All right rows + matched left          |
-- | FULL OUTER JOIN | All rows from both tables              |
-- | SELF JOIN       | A table joined with itself             |
-- | CROSS JOIN      | All combinations of both tables        |
-- | NATURAL JOIN    | Auto join using columns with same name |

use employee_db;

CREATE TABLE students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(50),
    class_id INT
);
INSERT INTO students VALUES 
(1, 'Amit', 101),
(2, 'Neha', 102),
(3, 'Ravi', 103),
(4, 'Sneha', NULL),   -- No class assigned
(5, 'Pooja', 104);

CREATE TABLE classes (
    class_id INT PRIMARY KEY,
    class_name VARCHAR(50),
    teacher_name VARCHAR(50)
);

INSERT INTO classes VALUES 
(101, 'Math', 'Mr. Sharma'),
(102, 'Science', 'Mrs. Verma'),
(103, 'English', 'Ms. Rao'),
(105, 'History', 'Mr. Khan');  -- No student assigned

select * from students;
select * from classes;

-- ----------------------------------------------------------------------------------------------------------------------
-- Legend:
-- 🟢 = Matching rows
-- ⚪ = Non-matching rows
-- 🔘 = Returned rows
-- Circles represent tables

-- 1. INNER JOIN (a.k.a. JOIN)
-- Returns only matching rows from both tables.
--    Table A         Table B         INNER JOIN
--    +-----+         +-----+         +-----+
--    |🟢 A |         |🟢 B |   =>     |🟢AB |
--    +-----+         +-----+         +-----+
--          [A] ⋂ [B]   ← Common part only

SELECT s.student_name, c.class_name
FROM students s
JOIN classes c ON s.class_id = c.class_id;

-- 2. LEFT JOIN (LEFT OUTER JOIN)
-- Returns all rows from the left table, and matched rows from the right.
-- If no match, right side will be NULL.
--    Table A         Table B         LEFT JOIN
--    +-----+         +-----+         +-----+
--    |🟢 A |         |🟢 B |   =>     |🟢AB |
--    |⚪ A |                      =>  |⚪A NULL|
--    +-----+         +-----+         +-----+
--    [A] ⟕ [B]   ← Everything from A + matching B

SELECT s.student_name, c.class_name
FROM students s
LEFT JOIN classes c ON s.class_id = c.class_id;

-- 3. RIGHT JOIN (RIGHT OUTER JOIN)
-- Opposite of LEFT JOIN.
-- Returns all rows from the right table, and matched rows from the left.
--    Table A         Table B         RIGHT JOIN
--    +-----+         +-----+         +-----+
--    |🟢 A |         |🟢 B |   =>     |🟢AB |
--                    |⚪ B |  =>    |NULL ⚪B|
--    +-----+         +-----+         +-----+
--    [A] ⟖ [B]   ← Everything from B + matching A

SELECT s.student_name, c.class_name
FROM students s
RIGHT JOIN classes c ON s.class_id = c.class_id;

-- 4. FULL OUTER JOIN
-- Returns all rows from both tables, matched or not.
-- If no match, NULL values are used.
-- MySQL doesn’t support FULL OUTER JOIN directly. Use UNION.
--    Table A         Table B         FULL JOIN
--    +-----+         +-----+         +---------+
--    |🟢 A |         |🟢 B |   =>     |🟢AB     |
--    |⚪ A |                   =>     |⚪A NULL |
--                    |⚪ B |   =>     |NULL ⚪B |
--    +-----+         +-----+         +---------+
--    	[A] ⋃ [B]   ← All rows from both tables

SELECT s.student_name, c.class_name
FROM students s
LEFT JOIN classes c ON s.class_id = c.class_id
UNION
SELECT s.student_name, c.class_name
FROM students s
RIGHT JOIN classes c ON s.class_id = c.class_id;

-- 5. SELF JOIN
-- A table joins with itself.
--    employee e       employee m     SELF JOIN
--    +-------+        +-------+      +-------------+
--    | Emp1  |        | Emp1  | =>   | Emp2, Mgr1  |
--    | Emp2  |        | Mgr1  |      +-------------+
--    Table joined with itself using aliases.

SELECT s1.student_name AS Student1, s2.student_name AS Student2, s1.class_id
FROM students s1
JOIN students s2 ON s1.class_id = s2.class_id
WHERE s1.student_id != s2.student_id;

-- 6. CROSS JOIN
-- Returns all possible combinations (Cartesian Product).
--    Table A (2 rows)     Table B (3 rows)
--    A1                 B1
--    A2                 B2     =>  A1 B1
--                       B3         A1 B2
--                                  A1 B3
--                                  A2 B1
--                                  A2 B2
--                                  A2 B3
--       Result: 2 × 3 = 6 rows

SELECT s.student_name, c.class_name
FROM students s
CROSS JOIN classes c;

-- ----------------------------------------------------------------------------------------------------------------------
-- 7. NATURAL JOIN between students and classes
-- Only works if both tables have a column with same name and type. Here, it's class_id.
SELECT student_name, class_name, teacher_name
FROM students
NATURAL JOIN classes;

-- 8. JOIN USING
-- Clean way to join when column name is the same (class_id)
SELECT student_name, class_name, teacher_name
FROM students
JOIN classes USING (class_id);

SELECT s.student_name, c.class_name, c.teacher_name
FROM students s
JOIN classes c ON s.class_id = c.class_id;
-- ----------------------------------------------------------------------------------------------------------------------

