SELECT
    A.CATEGORY,
    A.PRICE AS MAX_PRICE,
    A.PRODUCT_NAME
FROM
    FOOD_PRODUCT A
WHERE
    (A.CATEGORY, A.PRICE) IN (
        SELECT
            CATEGORY, MAX(PRICE)
        FROM
            FOOD_PRODUCT
        WHERE
            CATEGORY IN ('과자', '국', '김치', '식용유')
        GROUP BY
            CATEGORY
    )
ORDER BY
    MAX_PRICE DESC;