import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        // dp[1] = 1
        // dp[2] => dp[1] + dp[1] = 2
        // dp[3] = dp[2] + dp[1] = 3
        // dp[4] = 1
        // dp[5] = dp[4] + dp[1] = 2
        // dp[6] = dp[5] + dp[1] = 3
        // dp[7] = dp[6] + dp[1] = 4
        // dp[8] = dp[4] + dp[4] =2 // 4의 배수
        // dp[9] = 1
        // dp[10] = dp[9] + dp[1] = 2 // 9 + 1
        // dp[11] = dp[10] + dp[1] = 3 // 9 + 1 + 1
        // dp[12] = dp[11] + dp[1] = 4 // 9 + 1 + 1 + 1
        // dp[13] = dp[9] + dp[4] = 2 // 9 + 4
        // dp[14] = dp[13] + dp[1] = 3 // 9 + 4 + 1
        // dp[15] = dp[14] + dp[1] = 4 // 9 + 4 + 1 + 1
        // dp[16] = 1
        // dp[17] = dp[16] + 1 // 16 + 1
        // dp[18] = dp[9] + dp[9] = 2 // 9 + 9

        // dp[N] = dp[본인보다 작은 제곱] + dp[N - 제곱] 중에 항이 제일 작은 것)

        int[] dp = new int[100001];
        int sqrtN = (int) Math.sqrt(N);
        for (int i = 1; i <= sqrtN; i++) {
            dp[i * i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            if (dp[i] != 0) {
                continue;
            }

            // 본인보다 작은 제곱들을 탐색
            int min = Integer.MAX_VALUE;
            int sqrt = (int) Math.sqrt(i);
            for (int j = 1; j < sqrt; j++) {
                min = Math.min(min, dp[j * j] + dp[i - j * j]);
            }
            dp[i] = min;
            // System.out.println(i + "일 때, " + dp[i]);
        }

        bw.write(dp[N] + "");
        bw.flush();
    }

    private static void print(int[][] map) {
        System.out.println("-----------------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static void print(boolean[][] passed) {
        System.out.println("-----------------");
        for (int i = 0; i < passed.length; i++) {
            for (int j = 0; j < passed[0].length; j++) {

                if (passed[i][j])
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.println("");
        }
    }
}