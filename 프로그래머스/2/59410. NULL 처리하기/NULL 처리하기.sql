-- 코드를 입력하세요
SELECT ANIMAL_TYPE ,
case when NAME is null then "No name" else NAME end,
SEX_UPON_INTAKE
FROM ANIMAL_INS
order by ANIMAL_ID