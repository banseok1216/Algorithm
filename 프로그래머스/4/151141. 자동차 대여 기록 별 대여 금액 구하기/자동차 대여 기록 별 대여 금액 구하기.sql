-- 코드를 입력하세요
SELECT H.HISTORY_ID, 
CASE 
    WHEN P.CAR_TYPE = "트럭" and DATEDIFF(END_DATE,START_DATE)+1 < 7  then ROUND(C.DAILY_FEE *(DATEDIFF(END_DATE,START_DATE)+1))
    WHEN P.CAR_TYPE = "트럭" and DATEDIFF(END_DATE,START_DATE)+1 >= 7 and DATEDIFF(END_DATE,START_DATE)+1 <= 29 and DURATION_TYPE LIKE "7%" then ROUND(C.DAILY_FEE *((100-P.DISCOUNT_RATE)/100) *(DATEDIFF(END_DATE,START_DATE)+1))
    WHEN P.CAR_TYPE = "트럭" and DATEDIFF(END_DATE,START_DATE)+1 >= 30 and DATEDIFF(END_DATE,START_DATE)+1 <= 89 and DURATION_TYPE LIKE "30%" then ROUND(C.DAILY_FEE *((100-P.DISCOUNT_RATE)/100) *(DATEDIFF(END_DATE,START_DATE)+1))
    WHEN P.CAR_TYPE = "트럭" and DATEDIFF(END_DATE,START_DATE)+1 >= 90 and DURATION_TYPE LIKE "90%" then ROUND(C.DAILY_FEE *((100-P.DISCOUNT_RATE)/100) *(DATEDIFF(END_DATE,START_DATE)+1))
end as ll
FROM CAR_RENTAL_COMPANY_CAR as C
LEFT OUTER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY as H
ON C.CAR_ID = H.CAR_ID
LEFT OUTER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN as P
ON C.CAR_TYPE = P.CAR_TYPE
GROUP BY H.HISTORY_ID, ll
having ll is not null
order by ll desc ,H.HISTORY_ID desc