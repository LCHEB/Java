# 계정명이 abc, 비번이 abc이고 내부에서만 접근 가능한 계정을 생성하는 쿼리
create user 'abc'@'localhost' identified by 'abc';
# 모든 사용자 계정을 조회하는 쿼리
select * from mysql.user;
# abc 계정에 모든 DB에 접근하는 권한을 부여
grant all privileges on account.* to 'abc'@'localhost';

# 각 DB별 사용자 계정 권한을 조회하는 쿼리
select * from mysql.db;
#abc 계정에 계정 생성 권한을 부여
grant create user on *.* to 'abc'@'localhost';

# MySQL 에서는 and 연산자가 or 연산자보다 우선 순위가 높다
# a or b and c 와 (a or b) and c 는 결과가 다름

# 제품명에 A라는 글자가 포함된 제품을 조회하는 쿼리
use shoppingmall2;
SELECT 
    *
FROM
    product
WHERE
    pr_name LIKE '%우%';
# 제품명에 %라는 글자가 포함된 제품을 조회하는 쿼리 : %를 문자로 인식하려면 \를 붙임
SELECT 
    *
FROM
    product
WHERE
    pr_name LIKE '%\%%';

# 제품 가격순으로 순위를 추가해서 조회
select row_number() over(order by pr_pride desc) as '순위',product.* from product;
# 제품 가격순으로 순위를 추가해서 3위까지 조회
select * from
(select row_number() over(order by pr_pride desc) as '순위',product.* from product)
as product_tmp where 순위 <= 3;

# 각 카테고리별 제품 가격 평균을 조회
SELECT 
    pr_ca_num, AVG(pr_pride) AS 가격평균
FROM
    product
GROUP BY pr_ca_num;

# 각 카테고리별 제품 가격 평균이 6500원을 이상인 카테고리 조회
SELECT 
    *
FROM
    (SELECT 
        pr_ca_num, AVG(pr_pride) AS 가격평균
    FROM
        product
    GROUP BY pr_ca_num) AS product_avg
WHERE
    가격평균 >= 6500;
    
create table m(
	id varchar(10) primary key,
    pw varchar(20) not null
);

create table b(
	num int primary key,
    title text,
    id varchar(10)
);
insert into m values('abc123', 'abc123');
insert into b values(1, '제목1', 'abc123');
select * from b join m on m.id = b.id;
select * from b join m using(id); # b테이블에 id가 있고, a테이블에 id가 있을 때 using을 이용