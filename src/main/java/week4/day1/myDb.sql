CREATE TABLE Teacher
(TeacherId int, FirstName varchar(30), LastName varchar(30), Age int, Salary decimal);

CREATE TABLE Student
(StudentId int, FirstName varchar(30), LastName varchar(30), Grade int, GPA decimal);

CREATE TABLE Class
(ClassId int, name VARCHAR(30), description VARCHAR(60), TeacherId int);

CREATE TABLE ClassStudent
(ClassStudentId INT, ClassId INT, StudentId INT);

INSERT INTO teacher(TeacherId, FirstName, LastName, Age, Salary)
VALUES (1, 'Jim', 'Bob', 99, 56000),
       (2, 'Neo', 'Anderson', 30, 30000),
       (3, 'SuperMan', 'Steal', 50, 90000);

INSERT INTO Class
VALUES (1, 'Water Walking', 'the ultimate faith course', 1),
  (2, 'Raise The Dead', 'defy your reality', 1),
  (3, 'Dodge Bullets', 'masters course on flexibility', 2),
  (4, 'Building Jumping', 'free-running to the next extreme', 2),
  (5, 'X-ray Vision', 'lessons on how not to be creepy', 3),
  (6, 'Cape Flight', 'the dos and donts of air time', 3);

INSERT INTO Student
VALUES (1, 'Sponge', 'Bob', 5, 2.0), (2, 'Bart', 'Simpson', 6, 1.5),
  (3, 'Bill', 'Murry', 12, 3.9), (4, 'Bob', 'Saggot', 12, 3.0),
  (5, 'Tosh', 'O', 9, 4.0), (6, 'Marry', 'Poppins', 10, 2.0),
  (7, 'Ted', 'Bundy', 4, 1.0), (8, 'Max', 'Amillion', 5, 3.0),
  (9, 'Jack', 'Daniles', 7, 2.5), (10, 'Rainbow', 'Dash', 11, 3.7);

INSERT INTO ClassStudent
VALUES (1, 1, 1), (2, 2, 1), (3, 3, 1), (4, 1, 2), (5, 3, 2), (6, 6, 2), (7, 5, 3), (8, 3, 3),
  (9, 2, 3), (10, 6, 4), (11, 5, 4), (12, 3, 4), (13, 3, 5), (14, 4, 5), (15, 1, 5), (16, 1, 6),
  (17, 2, 6), (18, 6, 6), (18, 1, 7), (19, 3, 7), (20, 4, 7), (21, 6, 8), (22, 1, 8), (23, 2, 9),
  (24, 5, 9), (25, 6, 10), (26, 2, 10);

SELECT * FROM Teacher;
SELECT * FROM Student;
SELECT * FROM Class WHERE TeacherId = 1;
SELECT * FROM ClassStudent WHERE ClassID = 1;
SELECT * FROM ClassStudent WHERE StudentId = 1;
SELECT * FROM Student WHERE LastName LIKE 'A%';
UPDATE Teacher SET FirstName = 'Jumbo', LastName = 'Jim' WHERE TeacherID = 1;
UPDATE Class SET name = 'Bubble Blowing 101' WHERE ClassId = 1;
UPDATE Student SET FirstName = 'Saca', LastName = 'Tooya' WHERE StudentId = 1;
DELETE FROM Student WHERE StudentId = 10;

SELECT Teacher.FirstName, Teacher.LastName, Class.name
FROM Teacher, class WHERE Teacher.TeacherID = class.ClassID;





