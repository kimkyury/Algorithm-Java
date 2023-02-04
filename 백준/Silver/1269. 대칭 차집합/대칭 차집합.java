import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

  static HashSet<String> A;
  static HashSet<String> B;
  // static HashSet<String> S;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    A = new HashSet<>();
    B = new HashSet<>();

    // Handling input
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) A.add(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) B.add(st.nextToken());

    // 대칭차집합 구하기

    HashSet<String> tmpB = new HashSet<String>(B);

    Iterator<String> itA = A.iterator();
    while (itA.hasNext()) {
      String elementA = itA.next();
      if (B.contains(elementA)) B.remove(elementA);
    }

    Iterator<String> itB = tmpB.iterator();
    while (itB.hasNext()) {
      String elementB = itB.next();
      if (A.contains(elementB)) A.remove(elementB);
    }

    bw.write(String.valueOf(A.size() + B.size()) + "\n");

    // bw.write(String.valueOf(cnt));
    bw.flush();
  }
}
