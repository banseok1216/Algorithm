-- 코드를 입력하세요
SELECT 
year(sales_date) as Y,
month(sales_date) as M,
COUNT(DISTINCT U.USER_ID),
ROUND(COUNT(DISTINCT U.USER_ID)/(SELECT COUNT(USER_ID) 
                                      FROM USER_INFO 
                                      WHERE YEAR(JOINED) = 2021), 1) AS PUCHASED_RATIO
FROM ONLINE_SALE as S
JOIN (SELECT * FROM USER_INFO WHERE year(JOINED)  = 2021) as U
ON U.USER_ID = S.USER_ID
GROUP BY Y,M