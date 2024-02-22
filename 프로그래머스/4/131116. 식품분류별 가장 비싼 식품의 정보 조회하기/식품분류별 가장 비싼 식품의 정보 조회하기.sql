SELECT 
    fp.CATEGORY, 
    fp.PRICE,
    fp.PRODUCT_NAME
FROM 
    FOOD_PRODUCT AS fp
JOIN 
    (
        SELECT 
            CATEGORY, 
            MAX(PRICE) AS max_price
        FROM 
            FOOD_PRODUCT
        GROUP BY 
            CATEGORY
    ) AS max_prices
ON 
    fp.CATEGORY = max_prices.CATEGORY 
    AND fp.PRICE = max_prices.max_price
WHERE fp.CATEGORY Like "과자" or fp.CATEGORY Like "국" or fp.CATEGORY Like "김치" or fp.CATEGORY Like "식용유"
ORDER BY fp.PRICE desc