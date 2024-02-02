show tables;
use shoppingmall2;
# user 테이블의 권한은 일반회원 : user, 관리자 : admin
# 아이디가 admin이고, 비번이 admin, 이메일이 admin@gmail.com, 번호가 010-0000-0000인 관리자가
# 회원가입했을 때 필요한 쿼리

insert into user
	values("admin", "admin", "admin@gamil.com", "010-0000-0000", "admin", 0);
    
# 관리자가 다음의 제품을 등록할 때 필요한 쿼리
# 코드 : abc001, 제품명 : 텀블러, 가격 : 20000, 내용 : 스타벅스 텀블러입니다, 카테고리 : 기타

insert into product
	values("abc001", "텀블러", "스타벅스 텀블러입니다", 20000, 1);
    
insert into category values(null, "기타");
# 카테고리 : 전자제품, 의류, 식품, 자동차
insert into category(ca_name) values("전자제품"),("의료"),("식품"),("자동차");
select * from product;
/*
코드 : abc002, 제품명 : 볼펜, 내용 	: 모나미 볼펜, 	가격 : 1000, 카테고리 : 기타 1
코드 : abc003, 제품명 : 지우개, 내용 : 좋은 지우개, 	가격 : 500, 카테고리 : 기타 1
코드 : elc001, 제품명 : 마우스, 내용 : 무선 마우스, 	가격 : 10000, 카테고리 : 전자제품 2
코드 : elc002, 제품명 : 키보드, 내용 : 무선 키보드, 	가격 : 10000, 카테고리 : 전자제품 2
코드 : clo001, 제품명 : 모자, 내용 	: 좋은 모자, 		가격 : 10000, 카테고리 : 의류 3
코드 : clo002, 제품명 : 셔츠, 내용 	: 구김이 없는 셔츠, 가격 : 50000, 카테고리 : 의류 3
코드 : foo001, 제품명 : 만두, 내용 : 고기만두, 	가격 : 10000, 카테고리 : 식품 4
코드 : foo002, 제품명 : 라면, 내용 : 맛있는 라면, 	가격 : 3000, 카테고리 : 식품 4
코드 : car001, 제품명 : 방향제, 내용 : 향기 좋음, 	가격 : 5000, 카테고리 : 자동차 5
*/
insert into product
	values("abc002", "볼펜", "모나미 볼펜", 1000, 1);
insert into product
	values("abc003", "지우개", "잘지워지는 지우개", 500, 1);
    
insert into product
	values("elc001", "마우스", "무선 마우스", 10000, 2);
insert into product
	values("elc002", "키보드", "무선 키보드", 50000, 2);

insert into product
	values("clo001", "모자", "좋은 모자", 10000, 3);
insert into product
	values("clo002", "셔츠", "구김이 없는 셔츠", 50000, 3);
    
insert into product
	values("foo001", "만두", "고기만두", 10000, 4);
insert into product
	values("foo002", "라면", "맛있는 라면", 3000, 4);
    
insert into product
	values("car001", "방향제", "향기 좋음", 5000, 5);
    
# 아이디 : abc123, 비번 : abc123, 이메일 : abc123@kh.com 번호 : 011-1111-1111
# 아이디 : qwe123, 비번 : qwe123, 이메일 : qwe123@kh.com 번호 : 011-2222-2222

insert into user (id, pw, email, phone) values
("abc123", "abc123", "abc123@kh.com", "011-1111-1111"),
("qwe123", "qwe123", "qwe123@kh.com", "011-2222-2222");

# abc123회원이 마우스를 장바구니에 2개 담았을 때 실행되는 쿼리
insert into basket(ba_num2, ba_id, ba_pr_code)
values(2, "abc123", "elc001");
select * from basket where ba_id = "abc123";

# abc123회원이 마우스를 장바구니에 3개 담았을 때 실행되는 쿼리
update basket set ba_num2 = 3 where ba_id = "abc123" and ba_pr_code = "elc001";

# abc123회원이 키보드를 장바구니에 1개 담았을 때 실행되는 쿼리
insert into basket(ba_num2, ba_id, ba_pr_code) values(1, "abc123", "elc002");

#abc123회원이 장바구니에 담긴 모든 제품을 구매했을 때 실행되는 쿼리
insert into `order`(or_num2, or_money, or_id, or_pr_code)
values(3, 3*10000, "abc123", "elc001"),
(1, 1*10000, "abc123", "elc002");
# 장바구니에 담긴 제품을 구매하면 장바구니에는 해당 제품을 제거
delete from basket where ba_num = 1;
delete from basket where ba_num = 4;
