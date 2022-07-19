package 사전문제풀이;

import java.util.LinkedHashMap;

class UserSolution {

    static LinkedHashMap<Integer, Object[]> students;

    public void init() {
        students = new LinkedHashMap<>();
    }

    public int add(int mId, int mGrade, char mGender[], int mScore) {

        // [0] : grade, [1]: gender, [2]: score
        Object[] studentInfo = new Object[3];
        studentInfo[0] = mGrade;
        String mGenderToString = String.valueOf(mGender);
        studentInfo[1] = mGenderToString;
        studentInfo[2] = mScore;

        students.put(mId, studentInfo);

        int highScoreStudentID = 0;
        int maxScore = Integer.MIN_VALUE;
        for (int id : students.keySet()) {
            Object[] info = students.get(id);
            int grade = (int) info[0];
            String gender = String.valueOf(info[1]);
            int score = (int) info[2];

            if (grade == mGrade && gender.equals(mGenderToString)) {
                if (maxScore == score) {
                    highScoreStudentID = Math.max(highScoreStudentID, id);
                    continue;
                }
                if (maxScore < score) {
                    maxScore = score;
                    highScoreStudentID = id;
                }
            }
        }

        // System.out.println(highScoreStudentID);
        return highScoreStudentID;

    }

    public int remove(int mId) {

        // [0] : grade, [1]: gender, [2]: score

        boolean isExist = students.containsKey(mId);
        if (!isExist) {
            // System.out.println(0);
            return 0;
        }

        Object[] studentInfo = students.get(mId);
        int mGrade = (int) studentInfo[0];
        String mGenderToString = String.valueOf(studentInfo[1]);

        students.remove(mId);

        int rowScoreStudentID = Integer.MAX_VALUE;
        int minScore = Integer.MAX_VALUE;
        for (int id : students.keySet()) {
            Object[] info = students.get(id);
            int grade = (int) info[0];
            String gender = String.valueOf(info[1]);
            int score = (int) info[2];

            if (grade == mGrade && gender.equals(mGenderToString)) {

                if (minScore == score) {
                    rowScoreStudentID = Math.min(rowScoreStudentID, id);
                    continue;
                }

                if (minScore > score) {
                    minScore = score;
                    rowScoreStudentID = id;
                }
            }
        }

        if (rowScoreStudentID == Integer.MAX_VALUE) {
            // System.out.println(0);
            return 0;
        }

        // System.out.println(rowScoreStudentID);
        return rowScoreStudentID;
    }

    public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) { // mGender[][7]
        // System.out.print("query메소드 실행: ");

        LinkedHashMap<Integer, Integer> scoreInfo = new LinkedHashMap<>();

        String mGenderStrings[] = new String[mGender.length];
        for (int i = 0; i < mGender.length; i++) {
            mGenderStrings[i] = String.valueOf(mGender[i]);
        }

        // 찾는 학년집단, 성별집단에 속하며 특정점수 이상인지 확인하기
        for (int id : students.keySet()) {
            Object[] info = students.get(id);
            int grade = (int) info[0];
            String gender = String.valueOf(info[1]);
            int score = (int) info[2];

            // System.out.println(id + " " + grade + " " + gender + " " + score);

            int fitConditionCnt = 0;
            for (int i = 0; i < mGradeCnt; i++) {
                if (grade == mGrade[i]) {
                    fitConditionCnt++;
                    break;
                }
            }
            if (fitConditionCnt != 1)
                continue;

            if (mGenderCnt == 2) {
                fitConditionCnt++;
            } else {
                for (int i = 0; i < mGenderCnt; i++) {
                    if (gender.equals(mGenderStrings[i])) {
                        fitConditionCnt++;
                        break;
                    }
                }
            }

            if (fitConditionCnt != 2)
                continue;

            if (score >= mScore) {
                scoreInfo.put(id, score);
            }
        }

        // 조건을 만족하는 최소점수 ID찾기
        if (scoreInfo.isEmpty()) {
            // System.out.println(0);
            return 0;
        }

        int minScore = Integer.MAX_VALUE;
        int hasMinScoreID = 0;
        for (int id : scoreInfo.keySet()) {
            int score = scoreInfo.get(id);

            if (score == minScore) {
                hasMinScoreID = Math.min(id, hasMinScoreID);
            } else if (score < minScore) {
                minScore = score;
                hasMinScoreID = id;
            }
        }

        // 출력을 통한 확인

        // System.out.println(hasMinScoreID);
        return hasMinScoreID;
    }

}