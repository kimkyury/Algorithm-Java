import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

  static HashMap<String, Integer> strDic;
  static HashMap<Integer, String> indexDic;
  // static HashSet<String> S;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // for 시간단축
    strDic = new HashMap<>();
    indexDic = new HashMap<>();

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= N; i++) {
      String str = br.readLine();
      strDic.put(str, i);
      indexDic.put(i, str);
    }

    for (int i = 0; i < M; i++) {
      String input = br.readLine();

      // if 숫자라면
      if (input.charAt(0) >= 65) {
        bw.write(strDic.get(input) + "\n");
      } else {
        int index = Integer.parseInt(input);
        bw.write(indexDic.get(index) + "\n");
      }
    }

    // bw.write(String.valueOf(cnt));
    bw.flush();
  }
  // pq
  // 1 4 5 -> poll:2 (3/2 +1)
  // 1 2 3 4 5 -> poll: 3 (5/2+1)

}
