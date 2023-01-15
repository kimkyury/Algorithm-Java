import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void solve(int N, int M) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // over N  ~ under M
    int[] candidate = new int[M + 1];
    for (int i = 2; i <= M; i++) {
      if (candidate[i] == 1) continue;

      // 최초의 출력 이후 Block될 예정
      if (i >= N) bw.write(String.valueOf(i) + '\n');
      // if (i >= N) System.out.println(i);

      for (int j = i + i; j <= M; j += i) {
        candidate[j] = 1;
      }
    }

    bw.flush();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    solve(N, M);
    // for (int answer : answers) System.out.println(answer);
  }
}
