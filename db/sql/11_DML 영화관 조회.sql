# 영화 웡카의 영화 정보를 검색하는 쿼리(배우X 감독X 제작국가X 장르X)
select * from movie where mo_title = '웡카';

# 영화 웡카에 출연한 배우 및 감독을 조회 하는 쿼리
select mo_title as 제목, ch_name as 이름, mp_role as 구분 from movie
join 
	`join` on mo_num = jo_mo_num 
join 
	movie_person on jo_mp_num = mp_num
join
	`character` on mp_ch_num = ch_num
where
	mo_title = '웡카';