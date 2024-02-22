-- 코드를 입력하세요
SELECT DISTINCT(CAR_RENTAL_COMPANY_CAR.CAR_ID)
FROM CAR_RENTAL_COMPANY_CAR
INNER JOIN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE date(START_DATE) between '2022-10-01' and '2022-10-31') AS R 
ON CAR_RENTAL_COMPANY_CAR.CAR_ID = R.CAR_ID
WHERE CAR_RENTAL_COMPANY_CAR.CAR_TYPE LIKE '세단'
ORDER BY CAR_ID desc