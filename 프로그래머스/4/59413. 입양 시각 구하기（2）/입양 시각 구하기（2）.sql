
# select (@hour := @hour +1) as HOUR, count(*) from ANIMAL_OUTS
# group by HOUR
# set @hour = -1;
# select (@hour := @hour +1) as HOUR, (select count(*) from ANIMAL_OUTS where hour(DATETIME) = @hour) as COUNT
# FROM ANIMAL_OUTS
# WHERE @hour <23;
# select HOUR, ifnull(a.COUNT,0) as COUNT from (select 0 as HOUR union select 1 union select 2 union select 3 union select 4 union select 5 union select 6
#               union select 7 union select 8 union select 9 union select 10 union select 11 union select 12
#               union select 13 union select 14 union select 15 union select 16 union select 17 union select 18 
#               union select 19 union select 20 union select 21 union select 22 union select 23) as t
#     left join (
#         select  hour(DATETIME) as DATETIME, count(*) as COUNT from ANIMAL_OUTS 
#         group by hour(DATETIME)
#     )  as a
#     on t.HOUR = a.DATETIME

SELECT t.hr, (
    SELECT COUNT(*) 
    FROM ANIMAL_OUTS 
    WHERE HOUR(DATETIME) = t.hr
) AS count
FROM (
    SELECT ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) - 1 AS hr
    FROM INFORMATION_SCHEMA.COLUMNS
    LIMIT 24
) t;
