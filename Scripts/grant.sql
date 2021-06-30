DROP USER IF EXISTS 'user_mybatis_study'@'localhost';

create user 'user_mybatis_study'@'localhost';
GRANT ALL PRIVILEGES
	ON mybatis_study.*
	TO 'user_mybatis_study'@'localhost' identified by 'rootroot';