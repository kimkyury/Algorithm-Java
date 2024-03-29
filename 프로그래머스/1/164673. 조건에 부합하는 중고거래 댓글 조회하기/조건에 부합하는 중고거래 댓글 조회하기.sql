
-- 코드를 입력하세요
-- 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일
SELECT ugb.TITLE, ugb.BOARD_ID, ugr.REPLY_ID , ugr.WRITER_ID, ugr.CONTENTS, DATE_FORMAT(ugr.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
FROM USED_GOODS_BOARD ugb
    JOIN USED_GOODS_REPLY ugr ON ugb.BOARD_ID = ugr.BOARD_ID
WHERE YEAR(ugb.CREATED_DATE) = 2022 
    AND MONTH(ugb.CREATED_DATE) = 10
ORDER BY ugr.CREATED_DATE, ugb.TITLE