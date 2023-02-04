import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

  static HashSet<String> enterances;
  static HashSet<String> participants;
  // static HashSet<String> S;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    enterances = new HashSet<>();
    participants = new HashSet<>();

    st = new StringTokenizer(br.readLine());
    String S, E, Q;
    S = st.nextToken();
    E = st.nextToken();
    Q = st.nextToken();

    String str;
    while ((str = br.readLine()) != null) {
      // while (!(str = br.readLine()).equals("END")) {
      st = new StringTokenizer(str);
      String time = st.nextToken();
      String name = st.nextToken();

      // "ABC".compareTo(ABD) == -1
      if (time.compareTo(S) <= 0) {
        enterances.add(name);
      } else if (time.compareTo(E) >= 0 && time.compareTo(Q) <= 0) {
        if (enterances.contains(name)) {
          participants.add(name);
        }
      }
    }

    bw.write(String.valueOf(participants.size()));

    // bw.write(String.valueOf(cnt));
    bw.flush();
  }
}
