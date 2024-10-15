-- 코드를 작성해주세요
WITH rank_data AS (
    SELECT 
        ID, 
        SIZE_OF_COLONY,
        PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) as size_rank
    FROM ECOLI_DATA
)
select ID,
    CASE 
        WHEN size_rank < 0.25 THEN 'CRITICAL'
        WHEN size_rank < 0.50 THEN 'HIGH'
        WHEN size_rank < 0.75 THEN 'MEDIUM'
    ELSE 'LOW' 
    END AS COLONY_NAME   
 FROM rank_data
 ORDER BY ID;