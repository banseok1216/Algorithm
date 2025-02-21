select  sum(g.SCORE) as SCORE ,e.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL from HR_EMPLOYEES e
JOIN HR_GRADE g
on e.EMP_NO = g.EMP_NO
group by e.EMP_NO
order by SCORE desc
limit 1