import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N;
    static int[][] arr;
    static int[][] dp;

    static long max;

    static int[] dy = { -1, 0, 1, 0 }; // 상 좌, 하, 우
    static int[] dx = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {

        // 스티커, 2행 n열
        // 스티커의 상하좌우는 사용불가
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 열의 수
            arr = new int[2][N];

            // 입력 받기
            arr[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            dp = new int[2][N];
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            // DP 점화식 계산
            for (int i = 1; i < N; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], i > 1 ? dp[1][i - 2] : 0) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], i > 1 ? dp[0][i - 2] : 0) + arr[1][i];
            }

            // 결과 출력
            int maxScore = Math.max(dp[0][N - 1], dp[1][N - 1]);
            bw.write(maxScore + "\n");
        }
        bw.flush();
    }

    static void getRowSum(int j, long sum, boolean[][] selected) {

        if (j == N) {
            max = Math.max(max, getSecondRowSum(0, sum, selected));
            return;
        }

        if (j == 0) {
            selected[0][j] = true;
            getRowSum(j + 1, sum + arr[0][j], selected);
        } else if (!selected[0][j - 1]) {
            selected[0][j] = true;
            getRowSum(j + 1, sum + arr[0][j], selected);
        }

        selected[0][j] = false;
        getRowSum(j + 1, sum, selected);
    }

    static long getSecondRowSum(int j, long sum, boolean[][] selected) {

        if (j == N) {
            return sum;
        }

        if (j == 0 && !selected[0][j]) {
            selected[0][j] = true;
            getSecondRowSum(j, sum + arr[1][j], selected);
        } else if (!selected[0][j] && !selected[0][j - 1]) {
            selected[0][j] = true;
            getSecondRowSum(j, sum + arr[1][j], selected);
        }
        selected[0][j] = false;
        getRowSum(j + 1, sum, selected);

        return sum;
    }

    static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > 1 || x > N - 1) {
            return true;
        }
        return false;

    }
}
