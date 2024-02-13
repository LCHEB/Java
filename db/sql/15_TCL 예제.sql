start transaction; # 트랜젝션 시작
# begin/begin work
use shoppingmall2;
# foo002 가격을 2000원으로 수정
update product set pr_pride = 2000 where pr_code = 'foo002';

savepoint A;

update product set pr_pride = 1000 where pr_code = 'foo002';

rollback to A;

commit;
select * from product;