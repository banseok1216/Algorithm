-- 코드를 입력하세요
SELECT ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.NAME FROM ANIMAL_INS
LEFT OUTER JOIN ANIMAL_OUTS
ON ANIMAL_OUTS.ANIMAL_ID = ANIMAL_INS.ANIMAL_ID
WHERE ANIMAL_INS.DATETIME>ANIMAL_OUTS.DATETIME
ORDER BY ANIMAL_INS.DATETIME