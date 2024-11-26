import java.io.*;
import java.util.*;
import java.math.*;
import java.time.LocalDate;
import java.util.concurrent.Semaphore;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, K;

    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        // 중요도, 공부시간
        // 시간을 초과하지 않으면서 중요도의 합이 최대가 되는 몇 개만 선택하기

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K + 1][N + 1];
        int[][] subj = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            subj[i][0] = Integer.parseInt(st.nextToken());
            subj[i][1] = Integer.parseInt(st.nextToken());
        }

        // solve2(subj);

        // bw.write(dp[K][N] + "");
        bw.write(solve2(subj) + "");
        bw.flush();
    }

    public static int solve2(int[][] subj) {

        int[] dp = new int[N + 1];

        // 과목을 모두 탐색
        for (int i = 0; i < K; i++) {
            for (int j = N; j >= subj[i][1]; j--) {

                // 한 과목에 대해서 돌아보고
                // 다음 과목에 대해서 돌아보고
                dp[j] = Math.max(dp[j], dp[j - subj[i][1]] + subj[i][0]);
            }
        }

        return dp[N];
    }

    public static void solve(int[][] subj) {

        // subj[i][0] : 중요도 // 가치
        // subj[i][1] : 시간 // 무게

        // 배낭 문제

        // 각 과목마다
        for (int i = 1; i <= K; i++) {

            // 시간에 따른 중요도 검사
            for (int j = 1; j <= N; j++) {
                if (subj[i - 1][1] <= j) {
                    // 해당 과목이 조건에 맞으면, 최선값인지 확인
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - subj[i - 1][1]] + subj[i - 1][0]);
                } else {
                    // 조건에 타당치 않으면 기존값 유지
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

    }

    private static void show(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
