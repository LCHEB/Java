show variables like 'event%';
create table certification(
	ce_num int primary key,
    ce_code char(6),
    ce_limit datetime,
    ce_me_id varchar(13)
);
# 1초마다 기간이 지난 인증번호를 삭제하도록 이벤트를 등록
create event delete_certification
on schedule every 1 second
do
	delete from certification where ce_limit <= now();

select * from shoppingmall2.certification;

select * from information_schema.events;

drop event delete_certification;

# 지정 시간에 이벤트가 1번만 실행되고 이벤트를 삭제
create event delete_certification
on schedule
at '2024-02-15 09:47:00'
on completion not preserve
do
	delete from certification where ce_limit <= now();