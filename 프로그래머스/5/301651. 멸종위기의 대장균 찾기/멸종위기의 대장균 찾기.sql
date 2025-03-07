with recursive ansestor as (
    select ID, 1 as GENERATION from ECOLI_DATA 
    where PARENT_ID is null
    union
    select e.ID, (a.GENERATION+1)
    from ansestor a, ECOLI_DATA e
    where e.PARENT_ID = a.ID
)

select count(*) as COUNT, a.GENERATION  from ansestor a
where a.ID not in (select PARENT_ID from ECOLI_DATA where PARENT_ID is not null)
group by a.GENERATION