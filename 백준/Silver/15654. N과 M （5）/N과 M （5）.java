import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  static int[] arr;
  static int M, N;
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );
  static int[] isPassed;

  public static void solve(int pos, int[] result) throws IOException {
    // N개 중에서 M개의 수열 출력
    // 처음에는 (0, M, arr)

    // End Condition
    if (pos == M) {
      // System.out.println("size:" + result.length);
      for (int num : result) {
        bw.write(String.valueOf(num) + " ");
      }
      bw.write("\n");
      return;
    }

    // Backtraking && 재귀
    for (int i = 0; i < N; i++) {
      if (isPassed[i] != 1) {
        isPassed[i] = 1;
        result[pos] = arr[i];
        solve(pos + 1, result);
        isPassed[i] = 0;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    isPassed = new int[N];

    arr = new int[N];
    int result[] = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    solve(0, result);
    // N개 중에 M개 고르기
    // 순열

    // bw.write()
    bw.flush();
  }
}
