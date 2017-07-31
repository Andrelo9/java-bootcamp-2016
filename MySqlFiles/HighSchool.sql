						/* Exercise 1 */
CREATE DATABASE IF NOT EXISTS high_school;
USE high_school;

CREATE TABLE IF NOT EXISTS student(
	registration_number int NOT NULL PRIMARY KEY,    
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,	
    birth_date date
);

CREATE TABLE IF NOT EXISTS teacher(
	teacher_id int NOT NULL PRIMARY KEY,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,	
    birth_date date
);

CREATE TABLE IF NOT EXISTS course(
	course_id int NOT NULL PRIMARY KEY,
    course_name varchar(255) NOT NULL,
    teacher_id int,
	hours_by_week time,   
    CONSTRAINT assigned_teacher_fk FOREIGN KEY(teacher_id)
    REFERENCES teacher(teacher_id)   
);

CREATE TABLE IF NOT EXISTS inscript(
	registration_number int,
    course_id int,
    PRIMARY KEY(registration_number,course_id),
    CONSTRAINT registrationNumber_fk
    FOREIGN KEY(registration_number) REFERENCES student(registration_number),
    CONSTRAINT courseId_fk
    FOREIGN KEY(course_id) REFERENCES course(course_id)
    );

CREATE TABLE IF NOT EXISTS historyNotes(	
	first_note numeric,
    second_note numeric,
    third_note numeric,
    final_note numeric,
    registration_number int,
    course_id int,
    CONSTRAINT student_notes_fk
    FOREIGN KEY(registration_number)
    REFERENCES student(registration_number)
);

CREATE TABLE IF NOT EXISTS courseCalendar(	
	schedule_time timestamp,
	course_id int,    
    CONSTRAINT course_calendar_fk
    FOREIGN KEY(course_id)
    REFERENCES course(course_id)
);

					    /* Exercise 2 */