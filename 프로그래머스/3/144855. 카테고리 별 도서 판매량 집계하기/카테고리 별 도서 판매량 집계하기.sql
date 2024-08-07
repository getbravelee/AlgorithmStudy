SELECT A.CATEGORY, SUM(SALES)
FROM BOOK A
INNER JOIN BOOK_SALES B
ON A.BOOK_ID = B.BOOK_ID
WHERE TO_CHAR(SALES_DATE, 'YYYYMM') = '202201'
GROUP BY A.CATEGORY
ORDER BY A.CATEGORY