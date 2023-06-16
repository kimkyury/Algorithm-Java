import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );
  // static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;
  static int max = Integer.MIN_VALUE;
  static int[][] arr;
  static int N, M;
  static int num = 1;

  static void recur(int cnt, int sum, boolean[][] isPassed) {
    // System.out.println("num:" + num++ + ", cnt: " + cnt + ", sum: " + sum);

    if (cnt == N * M) {
      max = Math.max(max, sum);
      return;
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (isPassed[i][j]) continue;

        // 0~N 연장
        isPassed[i][j] = true;
        recur(cnt + 1, sum + arr[i][j], isPassed);

        // 우 방향으로 1 ~ (M-j)만큼 연장
        //
        int length = 1;
        StringBuilder sb = new StringBuilder().append(arr[i][j]);
        int tmpSum = Integer.parseInt(sb.toString());
        for (int k = 1; k < M - j; k++) {
          if (isPassed[i][j + k]) {
            recur(cnt + length, sum + tmpSum, isPassed);
            break;
          }
          isPassed[i][j + k] = true;
          sb.append(arr[i][j + k]);
          length++;
          tmpSum = Integer.parseInt(sb.toString());
          recur(cnt + length, sum + tmpSum, isPassed);
        }

        for (int k = 0; k < length; k++) isPassed[i][j + k] = false;

        // 하 방향으로 1 ~ (N-i)만큼 연장
        isPassed[i][j] = true;
        length = 1;
        sb = new StringBuilder().append(arr[i][j]);
        tmpSum = Integer.parseInt(sb.toString());
        for (int k = 1; k < N - i; k++) {
          if (isPassed[i + k][j]) {
            recur(cnt + length, sum + tmpSum, isPassed);
            break;
          }
          isPassed[i + k][j] = true;
          sb.append(arr[i + k][j]);
          length++;
          tmpSum = Integer.parseInt(sb.toString());
          recur(cnt + length, sum + tmpSum, isPassed);
        }

        for (int k = 0; k < length; k++) isPassed[i + k][j] = false;

        return;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N][M];

    String line;
    for (int i = 0; i < N; i++) {
      line = br.readLine();
      for (int j = 0; j < M; j++) {
        arr[i][j] = line.charAt(j) - '0';
      }
    }

    boolean[][] isPassed = new boolean[N][M];
    recur(0, 0, isPassed);

    bw.write(String.valueOf(max));
    bw.flush();
  }

  static void print(boolean[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
  }
}
