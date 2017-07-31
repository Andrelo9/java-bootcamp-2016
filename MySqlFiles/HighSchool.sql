CREATE DATABASE high_school;

CREATE TABLE IF NOT EXISTS student(
	registration_number int NOT NULL PRIMARY KEY,
    dni_number char(8) UNIQUE NOT NULL,
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
    assigned_teacher varchar(255),
	hours_by_week time,   
    CONSTRAINT assigned_teacher_fk FOREIGN KEY(assigned_teacher)
    REFERENCES teacher(teacher_id),
    CONSTRAINT students_fk FOREIGN KEY(assigned_course)
    REFERENCES course(course_id)
);

CREATE TABLE IF NOT EXISTS notes_history(
	first_note numeric,
    second_note numeric,
    third_note numeric,
    final_note numeric,
    student_id int,
    course_id int,
    CONSTRAINT student_notes_fk 
    FOREIGN KEY(student_id,course_id)
    REFERENCES course(student_id,course_id)
);

CREATE TABLE IF NOT EXISTS course_calendar(	
	schedule_time timestamp,
	course_id int,    
    CONSTRAINT course_calendar_fk
    FOREIGN KEY(course_id)
    REFERENCES course(course_id)
);
