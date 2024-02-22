-- 코드를 입력하세요
SELECT ORDER_ID,PRODUCT_ID,DATE_FORMAT(OUT_DATE,'%Y-%m-%d'),
CASE WHEN DATEDIFF(OUT_DATE,'2022-05-01') <=0 then "출고완료"
    WHEN DATEDIFF(OUT_DATE,'2022-05-01') >0 then "출고대기"
    else "출고미정" end
FROM FOOD_ORDER
order by ORDER_ID