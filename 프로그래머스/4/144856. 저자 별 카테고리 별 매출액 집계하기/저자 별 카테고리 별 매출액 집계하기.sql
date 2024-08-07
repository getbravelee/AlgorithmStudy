SELECT A.AUTHOR_ID
    , C.AUTHOR_NAME
    , A.CATEGORY
    , SUM(B.SALES * A.PRICE) AS TOTAL_SALES
FROM BOOK A
INNER JOIN (
    SELECT BOOK_ID, SUM(SALES) AS SALES
    FROM BOOK_SALES
    WHERE TO_CHAR(SALES_DATE, 'YYYY-MM') = '2022-01'
    GROUP BY BOOK_ID
) B
ON A.BOOK_ID = B.BOOK_ID
INNER JOIN AUTHOR C
ON A.AUTHOR_ID = C.AUTHOR_ID
GROUP BY A.AUTHOR_ID, C.AUTHOR_NAME, A.CATEGORY
ORDER BY A.AUTHOR_ID, A.CATEGORY DESC