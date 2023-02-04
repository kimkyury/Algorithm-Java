import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

  static HashSet<String> note;
  // static HashSet<String> S;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int TC = Integer.parseInt(br.readLine());

    for (int T = 0; T < TC; T++) {
      note = new HashSet<>();
      int N = Integer.parseInt(br.readLine());

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        note.add(st.nextToken());
      }

      int M = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; i++) {
        if (note.contains(st.nextToken())) {
          bw.write("1" + "\n");
        } else {
          bw.write("0" + "\n");
        }
      }
    }

    // bw.write(String.valueOf(cnt));
    bw.flush();
  }
}
