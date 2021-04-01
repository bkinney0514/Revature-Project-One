

drop table if exists employees cascade;
drop table if exists reimbursements cascade;
drop schema if exists ers cascade;

create schema ers;

create table employees (
	emp_id SERIAL primary key,
	emp_firstname VARCHAR(100),
	emp_lastname VARCHAR(100),
	emp_username VARCHAR(100) UNIQUE,
	emp_password VARCHAR(50),
	emp_title VARCHAR(50)
);

insert into ers.employees values (default, 'Brian', 'Kinney', 'bkinney', 'pass1', 'manager');
insert into ers.employees values (default, 'Christian', 'Cherry', 'ccherry', 'pass2', 'employee');
insert into ers.employees values (default, 'Tevin', 'Gray', 'tgray', 'pass3', 'employee');
insert into ers.employees values (default, 'Gabe', 'Harper', 'gharper', 'pass4', 'employee');

create table reimbursements (
	reimb_id SERIAL primary key,
	emp_id INTEGER references employees(emp_id) on delete cascade,
	amount DECIMAL,
	reason VARCHAR(500),
	status VARCHAR(15)
);

insert into ers.reimbursements values (default, 2, 20.00, 'Whiteboard for office', 'Pending');
insert into ers.reimbursements values (default, 3, 1000.00, 'Travel expenses (conference)', 'Pending');
insert into ers.reimbursements values (default, 2, 50.00, '', 'Pending');
insert into ers.reimbursements values (default, 4, 10.00, 'Lunch on Wednesday', 'Pending');


revoke all on schema ers from bossman;
revoke all on ers.employees from bossman;
revoke all on ers.reimbursements from bossman;

drop user if exists bossman;
create user bossman with password 'bossman';

grant all on schema ers to bossman;
grant all on ers.employees to bossman;
grant all on ers.reimbursements to bossman;
grant select, insert, update, delete on reimbursements_reimb_id_seq to bossman;
grant select, insert, update, delete on employees_emp_id_seq to bossman;

alter schema ers owner to bossman;