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

  static void perm(int cnt, int[] selected) {
    if (cnt == M) {
      for (int i : selected) {
        sb.append(i + " ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      selected[cnt] = i;
      perm(cnt + 1, selected);
    }
  }

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    int[] selected = new int[M];
    perm(0, selected);

    bw.write(sb.toString());
    bw.flush();
  }

  // ----------for log
  static void show(char[][] arr) {
    System.out.println("----------------");
    for (char[] ar : arr) {
      System.out.println(Arrays.toString(ar));
    }
  }
}
