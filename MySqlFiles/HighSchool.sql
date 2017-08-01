						/* Exercise 1 */
CREATE DATABASE IF NOT EXISTS high_school;
USE high_school;

CREATE SCHEMA IF NOT EXISTS school;

CREATE TABLE IF NOT EXISTS student(
	registration_number INT NOT NULL PRIMARY KEY,    
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,	
    birth_date DATE
);

CREATE TABLE IF NOT EXISTS teacher(
	teacher_id INT NOT NULL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,	
    birth_date DATE
);

CREATE TABLE IF NOT EXISTS course(
	course_id INT NOT NULL PRIMARY KEY,
    course_name VARCHAR(255) NOT NULL,
    teacher_id INT,
	hours_by_week TIME,   
    CONSTRAINT assigned_teacher_fk FOREIGN KEY(teacher_id)
    REFERENCES teacher(teacher_id)   
);

CREATE TABLE IF NOT EXISTS inscript(
	registration_number INT,
    course_id INT,
    PRIMARY KEY(registration_number,course_id),
    CONSTRAINT registrationNumber_fk
    FOREIGN KEY(registration_number) REFERENCES student(registration_number),
    CONSTRAINT courseId_fk
    FOREIGN KEY(course_id) REFERENCES course(course_id)
    );

CREATE TABLE IF NOT EXISTS historyNotes(	
	first_note NUMERIC,
    second_note NUMERIC,
    third_note NUMERIC,
    final_note NUMERIC,
    registration_number INT,
    course_id INT,
    CONSTRAINT student_notes_fk
    FOREIGN KEY(registration_number)
    REFERENCES student(registration_number)
);

CREATE TABLE IF NOT EXISTS courseCalendar(	
	schedule_time TIMESTAMP,
	course_id INT,    
    CONSTRAINT course_calendar_fk
    FOREIGN KEY(course_id)
    REFERENCES course(course_id)
);
SET SQL_SAFE_UPDATES = 0;
DELETE FROM inscript;
DELETE FROM student;
DELETE FROM course;
DELETE FROM teacher;
SET SQL_SAFE_UPDATES = 1;

					    /* Exercise 2 -Information for 3 teachers */
INSERT INTO teacher VALUES (1, 'Matias', 'Massigogge', '1980-05-06');
INSERT INTO teacher VALUES (2, 'Seba', 'Garofalo', '1980-06-06');
INSERT INTO teacher VALUES (3, 'Cristian', 'Ebbens', '1980-05-06');

						/* Information for 3 students*/
INSERT INTO course VALUES (100, 'algoritmos', 2, '06:00:00');
INSERT INTO course VALUES (101, 'bases de datos', 1, '06:00:00');
INSERT INTO course VALUES (102, 'diseño', 3, '06:00:00');

						/* Information for 10 students per course */
INSERT INTO student VALUES (1000, 'andrelo', 'vaninetti', '1986-12-18');
INSERT INTO student VALUES (1001, 'roman', 'riquelme', '1983-12-12');
INSERT INTO student VALUES (1002, 'dennis', 'bergkamp', '1978-07-06');
INSERT INTO student VALUES (1003, 'zlatan', 'ibrahimovic', '1983-04-28');
INSERT INTO student VALUES (1004, 'hector', 'bracamonte', '1980-01-14');
INSERT INTO student VALUES (1005, 'lionel', 'messi', '1987-06-13');
INSERT INTO student VALUES (1006, 'cristiano', 'ronaldo', '1985-08-26');
INSERT INTO student VALUES (1007, 'andres', 'iniesta', '1981-02-18');
INSERT INTO student VALUES (1008, 'xavi', 'fernandez', '1980-11-14');
INSERT INTO student VALUES (1009, 'ronaldo', 'asis', '1979-09-30');

						/* 10 students by course */
INSERT INTO inscript VALUES (1000,100);
INSERT INTO inscript VALUES (1001,100);
INSERT INTO inscript VALUES (1002,100);
INSERT INTO inscript VALUES (1003,100);
INSERT INTO inscript VALUES (1004,100);
INSERT INTO inscript VALUES (1005,100);
INSERT INTO inscript VALUES (1006,100);
INSERT INTO inscript VALUES (1007,100);
INSERT INTO inscript VALUES (1008,100);
INSERT INTO inscript VALUES (1009,100);

INSERT INTO inscript VALUES (1000,101);
INSERT INTO inscript VALUES (1001,101);
INSERT INTO inscript VALUES (1002,101);
INSERT INTO inscript VALUES (1003,101);
INSERT INTO inscript VALUES (1004,101);
INSERT INTO inscript VALUES (1005,101);
INSERT INTO inscript VALUES (1006,101);
INSERT INTO inscript VALUES (1007,101);
INSERT INTO inscript VALUES (1008,101);
INSERT INTO inscript VALUES (1009,101);

INSERT INTO inscript VALUES (1000,102);
INSERT INTO inscript VALUES (1001,102);
INSERT INTO inscript VALUES (1002,102);
INSERT INTO inscript VALUES (1003,102);
INSERT INTO inscript VALUES (1004,102);
INSERT INTO inscript VALUES (1005,102);
INSERT INTO inscript VALUES (1006,102);
INSERT INTO inscript VALUES (1007,102);
INSERT INTO inscript VALUES (1008,102);
INSERT INTO inscript VALUES (1009,102);

					/* EXERCISE 3 */
SELECT DISTINCT course.course_name AS 'COURSE',
	   teacher.last_name AS 'TEACHER_LASTNAME',
       teacher.first_name AS 'TEACHER_FIRSTNAME',
       student.last_name AS 'STUDENT_LASTNAME',
       student.first_name AS 'STUDENT_FIRSTNAME'
FROM course
	INNER JOIN inscript ON inscript.course_id = course.course_id
	INNER JOIN teacher ON teacher.teacher_id = course.teacher_id
	INNER JOIN student ON inscript.registration_number = student.registration_number 
WHERE inscript.course_id = "101"
ORDER BY student.last_name;