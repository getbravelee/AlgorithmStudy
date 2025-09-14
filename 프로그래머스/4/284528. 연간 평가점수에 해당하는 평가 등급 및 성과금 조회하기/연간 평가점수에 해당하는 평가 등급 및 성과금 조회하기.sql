select he.EMP_NO,
    he.EMP_NAME,
    case
        when avg(hg.SCORE) >= 96 then 'S'
        when avg(hg.SCORE) >= 90 then 'A'
        when avg(hg.SCORE) >= 80 then 'B'
        else 'C'
    end as GRADE,
    case
        when avg(hg.SCORE) >= 96 then he.SAL * 0.2
        when avg(hg.SCORE) >= 90 then he.SAL * 0.15
        when avg(hg.SCORE) >= 80 then he.SAL * 0.1
        else 0
     end as BONUS
from HR_GRADE hg, HR_EMPLOYEES he
where hg.EMP_NO = he.EMP_NO
group by hg.EMP_NO
order by hg.EMP_NO