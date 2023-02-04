import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

  // static HashMap<String, Integer> S;
  static HashSet<String> S;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    S = new HashSet<>();

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      // S.put(str, S.getOrDefault(S.get(str) + 1, 0));
      S.add(str);
    }

    int cnt = 0;
    for (int i = 0; i < M; i++) {
      String str = br.readLine();

      if (S.contains(str)) {
        cnt++;
      }
    }

    bw.write(String.valueOf(cnt));
    bw.flush();
  }
  // pq
  // 1 4 5 -> poll:2 (3/2 +1)
  // 1 2 3 4 5 -> poll: 3 (5/2+1)

}
