# abc123 회원이 주문 내역을 확인하는 쿼리
select * from `order` where or_id = "abc123";

# 기타(1)에 포함된 모든 제품을 조회하는 쿼리
select * from product where pr_ca_num = "1";

# 기타(1), 자동차(5), 의류(3)에 포함된 모든 제품을 조회하는 쿼리
select * from product where pr_ca_num = 1 or pr_ca_num = 3 or pr_ca_num = 5;
select * from product where  pr_ca_num in (1, 3, 5);

# 등록된 제품들의 카테고리 번호를 조회하는 쿼리
select distinct pr_ca_num from product;

# 가격이 높은 순으로 제품을 정렬하는 쿼리
select * from product order by pr_pride desc, pr_code;

# 제품 페이지에서 1페이제 있는 제품을 조회하는 쿼리(한 페이지에 제품은 2개 조회)
select * from product limit 0, 2;
# 2페이지에 있는 제품을 조회하는 쿼리(한 페이지에 2개 조회)
# 2번지 = 컨텐츠 개수 * (2페이지 - 1)
select * from product limit 2, 2;
# 10페이지에 있는 제품을 조회하는 쿼리
select * from product limit 18, 2;

# 카테고리 별 등록된 제품의 개수를 조회
select pr_ca_num as '카테고리번호', count(pr_ca_num) as '제품수' 
from 
	product 
group by 
	pr_ca_num;

# 카테고리 별 등록된 제품의 개수가 2개 이상인 카테고리를 조회
select pr_ca_num as '카테고리번호', count(pr_ca_num) as '제품수' 
from product group by pr_ca_num having count(pr_ca_num) >= 2;

# abc123회원이 지금까지 주문한 총 금액을 조회하는 쿼리
select or_id as '구매아이디', sum(or_money) as '총 구매금액' from `order` 
where 
	or_id = "abc123" and or_detail not in("반품", "환불")
group by 
	or_id;
 
# 제품별 판매된 개수를 조회하는 쿼리
select or_pr_code as '판매 제품', sum(or_num2) as '판매 개수'  from `order`
where 
	or_detail not in("반품", "환불")
group by 
	or_pr_code;

# 제품별 카테고리명을 조회하기 위한 inner join 쿼리
select product.*, ca_name from product join category 
# product의 외래키를 category의 기본키와 연결
# 속성명이 다르면 테이블명을 생략할 수 있다 pr_ca_num = ca_num;
on 
	product.pr_ca_num = category.ca_num;

# 기타로 등록된 제품들을 조회하는  쿼리
select * from product join category 
on 
	pr_ca_num = ca_num 
where 
	ca_name = "기타";

# abc123회원이 주문한 제품목록을 조회하는 쿼리
select * from `order` join product 
on 
	or_pr_code = pr_code
where 
	or_id = "abc123" and or_detail not in ("반품", "환불");
    
# 각 제품별 판매된 개수(판매된 제품에 한해서)
select pr_name, sum(or_num2) as 판매수 from `order` join product on or_pr_code = pr_code 
where
	or_detail not in ("반품", "환불")
group by
	pr_code;
# 각 제품별 판매된 개수(모든 제품에 한해서)
# ifnull(속성, 값) : 속성이 null인 경우 null대신 값A로 변경
select pr_name, ifnull(sum(or_num2), 0) as 판매수량 from product left join `order` on pr_code = or_pr_code
where 
	or_detail is null or or_detail not in ("반품", "환불")
group by
	pr_code;
    
# 모든 제품을 조회하는 쿼리
use shoppingmall2;
select * from product;

# 모든 카테고리를 조회하는 쿼리
select * from category;

# 제품별 카테고리를 조회. 카테고리 제품을 조회
select pr_name as 제품명, ca_name as 카테고리 from product 
join 
	category 
on 
	pr_ca_num = ca_num;
    
# 기타 카테고리에 포함된 모든 제품을 조회
select pr_name as 제품명, ca_name as 카테고리 from product 
join 
	category 
on 
	pr_ca_num = ca_num
where
	ca_name = '기타';

# abc123 회원이 주문한 제품 목록을 조회
select pr_name from `order` 
join 
	product on pr_code = or_pr_code
where 
	or_id = 'abc123';
    
# 제품별 판매수량을 조회하는 쿼리
select product.*, ifNull(sum(or_num2), 0) as 판매수량 from `order` 
right join 
	product on or_pr_code = pr_code
where
	or_detail not in ('반품', '환불') or or_detail is null
group by 
	pr_code;
    
# 인기 제품 조회. 인기 제품은 누적 판매량을 기준으로 상위 5개 제품
select product.*, ifNull(sum(or_num2), 0) as 판매수량 from `order` 
right join 
	product on or_pr_code = pr_code
where
	or_detail not in ('반품', '환불') or or_detail is null
group by 
	pr_code
order by 판매수량 desc, pr_pride asc
limit 0, 5;

# 가격이 제일 비싼 제품을 조회
select * from product
order by pr_pride desc
limit 0, 1;

-- --------------------------------------------------------------------

# 카테고리별 등록된 제품 수를 조회하는 쿼리
SELECT 
    ca_name, IF(COUNT(pr_ca_num) > 0, COUNT(pr_ca_num), '등록된 제품없음') as '카테고리별 제품수'
FROM
    product
        RIGHT JOIN
    category ON pr_ca_num = ca_num
GROUP BY ca_num;

# 회원별 누적 주문 금액을 조회하는 쿼리
SELECT 
    id, ifnull(SUM(or_money), 0) as '누적 금액'
FROM
    `order`
        RIGHT JOIN
    user ON or_id = id
GROUP BY id;

# 회원별 등급을 조회하는 쿼리, 등급은 기본이 브론즈, 누적금액이 5만원이상이면 실버, 누적금액이 8만원 이상이면 골드
# case문을 활용
SELECT 
    id, case
    when ifnull(SUM(or_money), 0) >= 80000 then '골드'
    when ifnull(SUM(or_money), 0) >= 50000 then '실버'
    else '브론즈'
    end as 등급
FROM
    `order`
        RIGHT JOIN
    user ON or_id = id
GROUP BY id;

# 제품 첨부파일을 추가한 후, 추가한 파일이 이미지인지 동영상인지 조회하는 쿼리
select 
	case right(sc_name, 3)
	when 'jpg' then '이미지'
	when 'png' then '이미지'
	when 'mp4' then '영상'
	end as 종류, sc_name
 from screen;