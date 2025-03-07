-- 코드를 입력하세요
select year(s.sales_date) as YEAR, month(s.sales_date) as MONTH,count(distinct(u.USER_ID)) as PURCHASED_USERS, round(count(distinct(u.USER_ID))/(
    select count(*) from USER_INFO where year(JOINED) = 2021
),1) as PUCHASED_RATIO from USER_INFO as u
join ONLINE_SALE as s
on u.USER_ID = s.USER_ID
where year(u.JOINED) = 2021
group by year(s.sales_date), month(s.sales_date)
order by year(s.sales_date), month(s.sales_date)