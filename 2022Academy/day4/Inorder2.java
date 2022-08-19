package day4;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
    private static char[] treeIndex;

    public static void InOrder(int idx, int N) {
        if (idx > N)
            return; // index > 정점 개수, than 종료
        InOrder(idx * 2, N);
        System.out.print(treeIndex[idx]);
        InOrder(idx * 2 + 1, N);
    }

    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("res/day4/aInput.txt"));

        /*
         * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
         */
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
        /*
         * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
         */
        int N;
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(sc.nextLine());
            treeIndex = new char[N + 1];
            StringTokenizer str;

            for (int i = 0; i < N; i++) {
                str = new StringTokenizer(sc.nextLine());
                str.nextToken();
                // index 1부터 조회가능
                treeIndex[i + 1] = str.nextToken().charAt(0);
            }

            System.out.print("#" + test_case + " ");
            InOrder(1, N);
            System.out.println();

        }
    }
}