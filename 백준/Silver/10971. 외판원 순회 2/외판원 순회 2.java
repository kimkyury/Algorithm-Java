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
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int N;
  static int[][] arr;

  static boolean[] isUsed;
  static int min = Integer.MAX_VALUE;

  static void saveSumCost(int[] selected) {
    int sum = 0;
    for (int i = 0; i < N - 1; i++) {
      int start = selected[i];
      int end = selected[i + 1];

      if (arr[start][end] == 0) {
        sum = Integer.MAX_VALUE;
        break;
      }
      if (i == N - 2) {
        if (arr[selected[N - 1]][selected[0]] == 0) {
          sum = Integer.MAX_VALUE;
          break;
        }

        sum += arr[selected[N - 1]][selected[0]];
      }
      sum += arr[start][end];
    }
    // System.out.println("------> " + sum);
    min = Math.min(min, sum);
  }

  static void perm(int cnt, int[] selected) {
    if (cnt == N) {
      // System.out.println(Arrays.toString(selected));
      saveSumCost(selected);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (isUsed[i]) continue;
      isUsed[i] = true;
      selected[cnt] = i;
      perm(cnt + 1, selected);
      isUsed[i] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    isUsed = new boolean[N];
    arr = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[] selected = new int[N];
    perm(0, selected);

    bw.write(String.valueOf(min));
    bw.flush();
  }
}
