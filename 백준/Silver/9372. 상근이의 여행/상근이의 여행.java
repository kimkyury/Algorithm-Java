import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );
  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );

  // static int N, L;

  public static void solution() {}

  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      for (int i = 0; i < M; i++) {
        br.readLine();
      }

      // 다 필요없음,어차피 다 연결되어있음. 간선 종류만 return
      bw.write(String.valueOf(N - 1) + "\n");
    }

    bw.flush();
  }
}
