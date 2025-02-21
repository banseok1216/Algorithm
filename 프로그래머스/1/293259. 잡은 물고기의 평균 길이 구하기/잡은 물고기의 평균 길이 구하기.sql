-- 코드를 작성해주세요

select ROUND(avg(
    CASE 
    WHEN LENGTH is not null then LENGTH
    WHEN LENGTH is null then 10
    end
),2) as AVERAGE_LENGTH from FISH_INFO
