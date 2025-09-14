select b.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(bs.SALES * b.PRICE) as TOTAL_SALES
from BOOK b
left join
    AUTHOR a on a.AUTHOR_ID = b.AUTHOR_ID
left join
    BOOK_SALES bs on bs.BOOK_ID = b.BOOK_ID
where bs.SALES_DATE between '2022-01-01' and '2022-01-31'
group by b.AUTHOR_ID, b.CATEGORY
order by b.AUTHOR_ID, b.CATEGORY desc