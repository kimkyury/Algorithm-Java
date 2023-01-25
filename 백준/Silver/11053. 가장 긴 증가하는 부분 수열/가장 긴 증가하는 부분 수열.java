import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static int N;
  static int[] arr;

  public static int solve(int[] arr) {
    int len = arr.length;
    int dp[] = new int[len];
    dp[0] = 1;

    for (int i = 1; i < len; i++) {
      int tmp = 0;
      // 앞전의 dp 검색값의 최대 찾기
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          // 나보다 작은 원소중 최대 dp값 찾기
          tmp = Math.max(tmp, dp[j]);
        }
        dp[i] = tmp + 1;
      }
    }

    Arrays.sort(dp);
    // for (int a : dp) {
    //   System.out.print(a + " ");
    // }

    return dp[len - 1];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve(arr)));

    bw.flush();
  }
}
