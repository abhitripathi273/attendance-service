CREATE OR REPLACE TABLE EMPLOYEE ( 
   id INTEGER NOT NULL AUTO_INCREMENT, 
   EMP_ID INTEGER, 
   first_name VARCHAR(20) NOT NULL, 
   last_name VARCHAR(20) NOT NULL, 
   age INTEGER,
   email VARCHAR(50) not null,
   PRIMARY KEY (id)
);

CREATE TABLE employee_attendance_details (
 	id INTEGER NOT NULL AUTO_INCREMENT, 
	attendance_date varchar2, 
	emp_id INTEGER not null,
	status VARCHAR(10) not null,
	total_hours double not null,
	PRIMARY KEY(attendance_date,emp_id)
)