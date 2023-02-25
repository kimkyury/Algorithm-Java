import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static int N;

  // 우, 하, 우하
  //
  public static void solve(int sx, int sy, int ex, int ey) {}

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    //        N = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    int cnt = 0;
    if (N % 5 == 0) {
      cnt += N / 5;
    } else {
      if (N < 5) {
        if (N % 2 == 0) cnt += N / 2; else {
          cnt = -1;
        }
      } else if ((N % 5) % 2 == 0) {
        cnt += N / 5;
        N = N % 5;
        cnt += N / 2;
      } else {
        if (N % 5 == 1) {
          cnt += 3;
          N = N - 6;
          cnt += N / 5;
        } else if (N % 5 == 3) {
          cnt += 4;
          N = N - 8;
          cnt += N / 5;
        }
      }
    }

    bw.write(String.valueOf(cnt));
    bw.flush();
  }
}
