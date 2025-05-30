select e.EMP_NO, e.EMP_NAME, 
case 
    when avg(g.SCORE) >= 96 then "S"
    when avg(g.SCORE) >= 90 then "A"
    when avg(g.SCORE) >= 80 then "B"
    else "C"
    end
as GRADE, 
case     
    when avg(g.SCORE) >= 96 then e.SAL * 0.2
    when avg(g.SCORE) >= 90 then e.SAL * 0.15
    when avg(g.SCORE) >= 80 then e.SAL * 0.1
    else 0
    end
as BONUS
from HR_EMPLOYEES e
join HR_GRADE g on g.EMP_NO = e.EMP_NO
group BY e.EMP_NO