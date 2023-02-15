import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );
  static StringTokenizer st;

  static int A, B;
  static int N;

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    if (N == 1) {
      return;
    }

    StringBuilder sb = new StringBuilder();
    int num = 2;
    while (true) {
      if (num == N) {
        sb.append(num).append(" ");
        break;
      }

      if (N % num == 0) {
        N /= num;
        // curNum *= num;
        sb.append(num).append(" ");
      } else {
        num++;
      }
    }

    st = new StringTokenizer(sb.toString());
    while (st.hasMoreTokens()) {
      bw.write(st.nextToken() + "\n");
    }



    bw.flush();
  }
}
