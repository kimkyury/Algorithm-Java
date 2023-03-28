import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static StringBuilder sb;
  static StringTokenizer st;

  static int[][] dp; // N번째 집을 [i]색으로 칠했을 때의 최소비용

  static int[][] value;
  static int[] totalCost;
  static int N;

  public static void show(int[][] arr) {
    for (int[] ar : arr) {
      for (int a : ar) {
        System.out.print(a + " ");
      }
      System.out.println("");
    }
  }

  public static int calCost() {
    int cost = Integer.MAX_VALUE;

    dp[1][0] = value[1][0]; //
    dp[1][1] = value[1][1]; //
    dp[1][2] = value[1][2]; //

    for (int i = 2; i <= N; i++) {
      // 구하는 값: N가지의 집을 모두 칠했을 떄의 최솟값
      // 즉, dp[N-1][0] || dp[N-1][1] || dp[N-1][2]

      // 빨간집

      // 한 집
      // dp[1][0]
      int candidate1 = dp[i - 1][1] + value[i][0];
      int candidate2 = dp[i - 1][2] + value[i][0];
      dp[i][0] = Math.min(candidate1, candidate2);

      // 초록집
      candidate1 = dp[i - 1][0] + value[i][1];
      candidate2 = dp[i - 1][2] + value[i][1];
      dp[i][1] = Math.min(candidate1, candidate2);

      // 파란집
      candidate1 = dp[i - 1][0] + value[i][2];
      candidate2 = dp[i - 1][1] + value[i][2];
      dp[i][2] = Math.min(candidate1, candidate2);
    }

    // show(dp);

    cost = Math.min(dp[N][0], dp[N][1]);
    cost = Math.min(dp[N][2], cost);

    return cost;
  }

  public static void main(String[] args)
    throws NumberFormatException, IOException {
    N = Integer.parseInt(br.readLine());

    dp = new int[N + 1][3];
    value = new int[N + 1][3];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      value[i][0] = Integer.parseInt(st.nextToken());
      value[i][1] = Integer.parseInt(st.nextToken());
      value[i][2] = Integer.parseInt(st.nextToken());
    }

    int answer = calCost();

    // dp[N-1][0], do[N-1][1], dp[N-1][2] 셋 중 가장 작은 거
    System.out.println(answer);
  }
}
