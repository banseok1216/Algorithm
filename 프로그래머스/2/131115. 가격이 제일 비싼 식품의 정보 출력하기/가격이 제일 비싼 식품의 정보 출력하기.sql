-- 코드를 입력하세요
SELECT PRODUCT_ID,PRODUCT_NAME,PRODUCT_CD, CATEGORY,PRICE AS PRICE FROM FOOD_PRODUCT WHERE PRICE = (SELECT MAX(PRICE) AS PRICE FROM FOOD_PRODUCT )