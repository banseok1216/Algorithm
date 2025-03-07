set @hour = -1;
select (@hour := @hour + 1) as Hour, ifnull((select count(*) from ANIMAL_OUTS where @hour = hour(DATETIME) group by hour(DATETIME)),0) as Hour from ANIMAL_OUTS 
where @hour < 23