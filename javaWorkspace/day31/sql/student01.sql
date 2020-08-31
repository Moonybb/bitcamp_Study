-- 학번(number),이름(15),국어(3),영어(3),수학(3);
-- 테이블 생성
create table student01(
	num number,
	name varchar2(15),
	korean number(3),
	english number(3),
	math number(3)
);
delete from student01;
-- dummy data
insert into student01 values(1,'테스터1',90,80,70);
insert into student01 values(2,'테스터2',92,84,93);
insert into student01 values(3,'테스터3',70,81,83);
insert into student01 values(4,'테스터4',87,82,88);
insert into student01 values(5,'테스터5',85,73,73);
exit;