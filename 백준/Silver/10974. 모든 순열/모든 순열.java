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

  static void perm(int cnt, int[] selected) {
    if (cnt == N) {
      for (int i = 0; i < N; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      if (isUsed[i]) continue;
      isUsed[i] = true;
      selected[cnt] = i + 1;
      perm(cnt + 1, selected);
      isUsed[i] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    // input = new int[N];
    isUsed = new boolean[N];

    int[] selected = new int[N];
    perm(0, selected);

    bw.write(sb.toString());
    bw.flush();
  }
}
