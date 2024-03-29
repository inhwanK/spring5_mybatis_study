create database if not exists mybatis_study;
drop database mybatis_study;



create table addresses (
	addr_id int(11) not null auto_increment comment '주소코드',
	street varchar(50) not null comment '도로',
	city varchar(50) not null comment '시',
	state varchar(50) not null comment '구',
	zip varchar(10) null comment '우편번호',
	country varchar(50) not null comment '읍',
	primary key (addr_id)
) comment '주소';

create table students ( 
	stud_id int(11) not null auto_increment comment '학생코드' ,
	name varchar(50) not null comment '이름' ,
	email varchar(50) not null comment '이메일' ,
	phone varchar(15) default null comment '연락처' ,
	dob date null comment '생일' ,
	bio longtext null comment '자기소개' ,
	pic blob null comment '사진' ,
	addr_id int(11) default null comment '주소' ,
	primary key (stud_id),
	constraint fk_students_addr foreign key (addr_id) 
	references addresses (addr_id) 
) comment '학생';

create table tutors (
	tutor_id int(11) not null auto_increment comment '교수번호',
	name varchar(50) not null comment '이름',
	email varchar(50) not null comment '이메일',
	phone varchar(15) default null comment '연락처', 
	dob date default null comment '생일',
	bio longtext default null comment '교수소개',
	pic blob default null comment '사진',
	addr_id int(11) default null comment '주소',
	primary key (tutor_id),
	constraint fk_tutors_addr foreign key (addr_id) 
	references addresses (addr_id) 
) comment '교수';

create table courses (
	course_id int(11) not null auto_increment comment '과목코드',
	name varchar(100) not null comment '과목명',
	description varchar(512) default null comment '설명',
	start_date date default null comment '시작일',
	end_date date default null comment '종료일',
	tutor_id int(11) not null comment '담당교수',
	primary key (course_id),
	constraint fk_course_tutor foreign key (tutor_id) 
	references tutors (tutor_id)
) comment '과목';

create table course_enrollment(
	course_id int(11) not null comment '과목코드',
	stud_id int(11) not null comment '학생코드',
	primary key (course_id,stud_id),
	constraint fk_enrollment_stud foreign key (stud_id) 
	references students (stud_id),
	constraint fk_enrollment_course foreign key (course_id) 
	references courses (course_id)
) comment '수강등록';

CREATE TABLE user_pics (
	id int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	name varchar(50) not NULL COMMENT 'name',
	pic longblob COMMENT 'pic',
	bio longtext COLLATE utf8_unicode_ci COMMENT 'bio',
	PRIMARY KEY (id)
);

ALTER TABLE students ADD gender tinyint unsigned;
