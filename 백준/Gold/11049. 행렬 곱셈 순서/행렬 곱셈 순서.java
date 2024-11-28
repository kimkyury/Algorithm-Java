import java.io.*;
import java.util.*;
import java.math.*;
import java.time.LocalDate;
import java.util.concurrent.Semaphore;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M, K;

    static int[] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {

        // 행렬 N개를 곱하는데, 곱셈 연산의 최솟값

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new long[N][N];

        for (int cnt = 2; cnt <= N; cnt++) { // 행렬의 곱 횟수

            for (int i = 0; i < N - cnt + 1; i++) {

                // 가장 작은 단위부터 수행, 'i-j = 1' 부터 시작
                int j = i + cnt - 1;

                dp[i][j] = Long.MAX_VALUE; // 최솟값 갱신을 위한 초기값

                for (int k = i; k < j; k++) {

                    // arr[i][0] = p, arr[k][1] = q, arr[j][1] = r
                    long cost = dp[i][k] + dp[k + 1][j] + (arr[i][0] * arr[k][1] * arr[j][1]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        bw.write(dp[0][N - 1] + "");
        bw.flush();
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
