-- year, year_dev, id
WITH max_data as (
    SELECT YEAR(DIFFERENTIATION_DATE) as year , MAX(SIZE_OF_COLONY) as max_size
    FROM ecoli_data
    GROUP BY year
)
select m.year as year, m.max_size - e.SIZE_OF_COLONY as YEAR_DEV, e.ID as id
from  ecoli_data e
left join max_data m
        on YEAR(e.DIFFERENTIATION_DATE) = m.year
ORDER BY m.year, YEAR_DEV