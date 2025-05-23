-- 코드를 입력하세요
SELECT 
BOOK.BOOK_ID,
AUTHOR.AUTHOR_NAME,
DATE_FORMAT(BOOK.PUBLISHED_DATE,'%Y-%m-%d')
FROM BOOK
LEFT OUTER JOIN AUTHOR 
ON AUTHOR.AUTHOR_ID = BOOK.AUTHOR_ID
WHERE BOOK.CATEGORY LIKE '경제'
ORDER BY BOOK.PUBLISHED_DATE