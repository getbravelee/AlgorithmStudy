SELECT BOARD_ID
    , WRITER_ID
    , TITLE
    , PRICE
    , CASE 
        WHEN STATUS = 'DONE' THEN '거래완료'
        WHEN STATUS = 'SALE' THEN '판매중'
        WHEN STATUS = 'RESERVED' THEN '예약중'
    END AS STATUS
FROM USED_GOODS_BOARD
WHERE TO_CHAR(CREATED_DATE, 'YYYY-MM-DD') = '2022-10-05'
-- 추가로 만약 비어있거나(빈 문자열) 값이 null 일 때, 보여주고 싶지 않다면
-- AND STATUS IS NOT NULL AND STATUS <> ''
-- 1. STATUS가 null이 아니고
-- 2. STATUS 컬럼이 <> : 같지 않다 '' : 빈 문자열 => 빈 문자열이 아니다.
ORDER BY BOARD_ID DESC