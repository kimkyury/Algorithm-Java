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
  static int[] input;
  static boolean[] isUsed;
  static int max = Integer.MIN_VALUE;

  static void perm(int cnt, int[] selected) {
    if (cnt == N) {
      // System.out.println(Arrays.toString(selected));
      // 수식을 적용시킨다

      int sum = 0;
      for (int i = 0; i < N - 1; i++) {
        int tmpSum = selected[i] - selected[i + 1];
        sum += Math.abs(tmpSum);
      }

      max = Math.max(sum, max);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (isUsed[i]) continue;
      isUsed[i] = true;
      selected[cnt] = input[i];
      perm(cnt + 1, selected);
      isUsed[i] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    isUsed = new boolean[N];
    input = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    int[] selected = new int[N];
    perm(0, selected);

    bw.write(String.valueOf(max));
    bw.flush();
  }
}
