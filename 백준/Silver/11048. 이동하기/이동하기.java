import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );
  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );

  static int[] dx = { 1, 0, 1 }; // 우향, 하향, 우하향
  static int[] dy = { 0, 1, 1 };

  static int N, M;

  static int solve(int[][] map) {
    int[][] dp = new int[N][M];
    // start = (0,0), end = (N-1, M-1)
    dp[0][0] = map[0][0];
    for (int i = 0; i < N; i++) { // y
      for (int j = 0; j < M; j++) { //x
        int nx, ny;
        for (int k = 0; k < 3; k++) {
          ny = i + dy[k];
          nx = j + dx[k];

          if (ny > N - 1 || nx > M - 1) continue;
          int sum = dp[i][j] + map[ny][nx];
          dp[ny][nx] = Math.max(sum, dp[ny][nx]);
        }
      }
    }
    // show(dp);
    return dp[N - 1][M - 1];
  }

  // static void show(int[][] dp) {
  //   for (int i = 0; i < N; i++) {
  //     for (int j = 0; j < M; j++) {
  //       System.out.print(dp[i][j] + " ");
  //     }
  //     System.out.println("");
  //   }
  // }

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int[][] map = new int[N][M];

    for (int i = 0; i < N; i++) { // y길이
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) { // x길이
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    bw.write(String.valueOf(solve(map)));
    bw.flush();
  }
}
