import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

  static int N, M;

  static void perm(int cnt, int[] selected, int N, int M) {
    if (cnt == M) {
      for (int i : selected) {
        sb.append(i).append(" ");
      }
      sb.deleteCharAt(sb.length() - 1);
      sb.append("\n");
      return;
    }

    if (cnt == 0) {
      for (int i = 1; i <= N; i++) {
        selected[cnt] = i;
        perm(cnt + 1, selected, N, M);
      }
    } else {
      for (int i = selected[cnt - 1]; i <= N; i++) {
        selected[cnt] = i;
        perm(cnt + 1, selected, N, M);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] selected = new int[M];

    perm(0, selected, N, M);

    bw.write(sb.toString());
    bw.flush();
  }
}
