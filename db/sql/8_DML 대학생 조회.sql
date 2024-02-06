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
    
use university2;
select * from student;
# 컴퓨터공학을 다니는 학생 정보를 조회o
select * from student where st_major = "컴퓨터공학";

# 컴퓨터공학을 다니는 1학년 학생 정보를 조회o
select * from student where st_grade = '1' and st_major = "컴퓨터공학";

#컴퓨터공학 또는 화학공학을 다니는 1학년 학생 정보를 조회
select * from student where (st_major = "컴퓨터공학" or st_major = '화학공학') and st_grade = '1';

# 컴퓨터공학을 다니는 학생 수를 조회
select st_major as 전공, count(*) as '학생 수' from student where st_major = '컴퓨터공학' group by st_major;

# 학생들이 등록된 학과를 조회
select distinct st_major from student;

# 학생들이 3명이상 등록된 학과들을 조회
select st_major as 전공, count(*) as 학생수 from student group by st_major having count(st_num) >= 3;

# 컴퓨터개론을 수강하는 학생 수를 조회
select * from lecture;

select le_title as 수강명, count(*) as 학생수 from lecture 
join 
	course 
on 
    le_num = co_le_num
where 
	le_title = '컴퓨터개론' group by le_num;

# 각 강의별 수강하는 학생 수를 조회, 강의명과 학생수를 조회
select le_title as 수강명, count(*) as 학생수 from lecture 
join 
	course 
on 
    le_num = co_le_num
group by 
	le_num;

# 홍길동 학생이 수강하는 강의목록을 조회
select le_title from course
join
	student on co_st_num = st_num
join
	lecture on co_le_num = le_num
where 
	st_name = '홍길동';
	
# 기계공학에 소속된 교수의 수를 조회
select count(*) from professor where pr_major = '기계공학';

# 김교수가 강의하는 강의명을 조회
select pr_name as 교수명,le_title as 강의명 from lecture 
join 
	professor 
on 
	le_pr_num = pr_num
 where 
	pr_name ='김교수';