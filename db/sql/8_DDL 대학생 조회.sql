# 컴퓨터공학 고길동 학생이 구강신청한 강의 개수를 조회하는 쿼리
select st_name as 이름, st_major as 전공, count(*) as "신청한 강의 수" from course 
join 
	student on co_st_num = st_num 
where 
	st_major = "컴퓨터공학" and st_name = "고길동";

# 컴퓨터공학 고길동 학생이 수강 신청한 학점을 조회하는 쿼리
select 
	st_name as 이름, st_major as 전공, sum(le_point) as "수강신청학점" 
from 
	course 
		join 
	student on co_st_num = st_num 
		join
	lecture on co_le_num = le_num
where 
	st_major = "컴퓨터공학" and st_name = "고길동";
    
# 24학년 신입생을 조회하는 쿼리
select * from student where st_num like "2024%" and st_grade = 1;

# 각 전공별 학생수를 조회하는 쿼리
select st_major as 전공, count(*) as 학생수 from student group by st_major;

# 강의별 수강신청한 학생 수
select le_title as 강의명, count(co_st_num) as 학생수 from lecture 
join 
	course 
on 
	le_num = co_le_num 
group by
	le_num;