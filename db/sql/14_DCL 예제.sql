create user 'chul'@'%' identified by 'abc123'; # 사용자 추가

set password for 'chul'@'%' = 'def123'; # 사용자 비번 변경

drop user 'chul'@'%'; # 사용자 삭제

select user, host from mysql.user;

# 권한 부여 : grant 권환종류 on DB명.테이블명 to '사용자명'@'호스트명'
grant all privileges on shoppingmall2.product to 'chul'@'%';

# 권한 제거 : revoke 권환종류 on DB명.테이블명 from '사용자명'@'호스트명'
revoke all privileges on shoppingmall2.product from 'chul'@'%';

grant all privileges on shoppingmall2.* to 'chul'@'%';