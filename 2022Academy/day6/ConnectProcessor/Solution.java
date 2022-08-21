import java.io.FileInputStream;
import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */

class pos {
    int x, y;

    pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Solution {

    private static int N;
    private static int index, min;
    private static int arr[][];
    private static int dx[] = { -1, 1, 0, 0 };
    private static int dy[] = { 0, 0, -1, 1 };
    private static pos core[];
    private static boolean visited[];

    // R개의 조합의 수를 구하기
    public static void combination(int num, int cnt, int R) {
        if (cnt == R) {
            dfs(0, 0);
            return;
        }
        for (int i = num; i < index; i++) {
            visited[i] = true;
            combination(i + 1, cnt + 1, R);
            visited[i] = false;
        }

    }

    public static void dfs(int idx, int cnt) {
        if (idx == index) {
            min = Math.min(min, cnt);
            return;
        }
        if (!visited[idx]) {
            dfs(idx + 1, cnt);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int x = core[idx].x, y = core[idx].y, tmp = 0;
            boolean success = false;
            while (true) {
                x += dx[i];
                y += dy[i];
                if (x < 0 || x >= N || y < 0 || y >= N) {
                    success = true;
                    break;
                }
                if (arr[x][y] != 0)
                    break;
                arr[x][y] = 2;
                tmp++;
            }
            if (success)
                dfs(idx + 1, cnt + tmp);
            while (true) {
                x -= dx[i];
                y -= dy[i];
                if (x == core[idx].x && y == core[idx].y)
                    break;
                arr[x][y] = 0;
            }
        }
    }

    public static void main(String args[]) throws Exception {
        /*
         * 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
         * 여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
         * 이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
         * 따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
         * 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
         */
        System.setIn(new FileInputStream("res/input.txt"));

        /*
         * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
         */
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        /*
         * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
         */

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            arr = new int[N][N];
            core = new pos[12];
            visited = new boolean[12];
            min = Integer.MAX_VALUE;

            // map 저장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 가장자리를 제외한 core 위치 저장
            index = 0;
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    if (arr[i][j] == 1) {
                        core[index++] = new pos(i, j);
                    }
                }
            }

            // 코어의 개수만큼 조합의 수 검색
            for (int i = index; i >= 0; i--) {
                // 코어의 전체개수부터 0개까지의 조합을 검색
                combination(0, 0, i);
                if (min < Integer.MAX_VALUE)
                    break;
            }

            System.out.println("#" + test_case + " " + min);

        }
    }
}