SELECT 
    CASE 
        WHEN DATE_FORMAT(DATETIME,"%H") = "09" THEN "9"
        ELSE DATE_FORMAT(DATETIME,"%H")
    END AS ll,
    COUNT(ANIMAL_ID) AS animal_count
FROM 
    ANIMAL_OUTS
GROUP BY 
    ll
HAVING 
    (ll >= "09" AND ll <= "19") or  ll = "9" 
ORDER BY 
    CAST(ll AS UNSIGNED);