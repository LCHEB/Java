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