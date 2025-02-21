-- 코드를 작성해주세요

# 아이템 ID, 아이템 명, 아이템 희귀도 출력 무엇을? 더이상 업그레이드 할 수 없는 아이템

select i.ITEM_ID	,i.ITEM_NAME,	i.RARITY from ITEM_INFO as i
join ITEM_TREE as t on i.ITEM_ID = t.ITEM_ID
where t.ITEM_ID not in (Select PARENT_ITEM_ID from ITEM_TREE where PARENT_ITEM_ID is not null )
order by i.ITEM_ID desc