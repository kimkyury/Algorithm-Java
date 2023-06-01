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
  static int[] arr;

  static void perm(int tIdx, int cnt, int[] selected, int N, int M) {
    if (cnt == M) {
      for (int i : selected) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = tIdx; i < N; i++) {
      selected[cnt] = arr[i];
      perm(i, cnt + 1, selected, N, M);
    }
  }

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] selected = new int[M];
    arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    perm(0, 0, selected, N, M);

    bw.write(sb.toString());
    bw.flush();
  }
}
