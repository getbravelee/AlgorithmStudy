select fp.PRODUCT_ID, fp.PRODUCT_NAME, sum(fp.PRICE * fo.AMOUNT) as TOTAL_SALES
from FOOD_PRODUCT fp, FOOD_ORDER fo
where fp.PRODUCT_ID = fo.PRODUCT_ID
    and fo.PRODUCE_DATE between '2022-05-01' and '2022-05-31'
group by fp.PRODUCT_ID
order by TOTAL_SALES desc, fp.PRODUCT_ID