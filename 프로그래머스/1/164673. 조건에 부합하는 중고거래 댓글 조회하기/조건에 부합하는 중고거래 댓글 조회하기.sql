SELECT 
USED_GOODS_BOARD.TITLE, 
USED_GOODS_BOARD.BOARD_ID, 
USED_GOODS_REPLY.REPLY_ID, 
USED_GOODS_REPLY.WRITER_ID,
USED_GOODS_REPLY.CONTENTS,
DATE_FORMAT(USED_GOODS_REPLY.CREATED_DATE,'%Y-%m-%d')
FROM USED_GOODS_BOARD
INNER JOIN USED_GOODS_REPLY
ON USED_GOODS_BOARD.BOARD_ID = USED_GOODS_REPLY.BOARD_ID
WHERE (date(USED_GOODS_BOARD.CREATED_DATE) between '2022-10-01' and '2022-10-31')
ORDER BY USED_GOODS_REPLY.CREATED_DATE asc, TITLE ASC