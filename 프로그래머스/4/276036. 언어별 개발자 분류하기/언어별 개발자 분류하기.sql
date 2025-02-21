-- 코드를 작성해주세요

select
case
    when group_concat(s.category) like "%Front End%" and group_concat(s.NAME) like "%Python%" then "A"
    when group_concat(s.NAME) like "%C#%" then "B"
    when group_concat(s.category) like "%Front End%" then "C"
    end as GRADE
,d.ID,d.EMAIL
from DEVELOPERS d
join SKILLCODES s
on d.SKILL_CODE & s.CODE > 0
group by d.ID , d.EMAIL
having GRADE is not null
order by GRADE, ID ASC