import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

  static int[] set;
  static int N, M;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static int find(int v) {
    if (v == set[v]) return v; // END condition
    return set[v] = find(set[v]); // Update INFO
  }

  //connect
  public static void union(int v1, int v2) {
    int v1Set = find(v1);
    int v2Set = find(v2);

    // init Update INFO
    if (v1Set != v2Set) {
      if (v1Set < v2Set) {
        set[v2Set] = v1Set;
      } else {
        set[v1Set] = v2Set;
      }
    }
  }

  public static void confirm(int[] routin) throws IOException {
    int targetSet = find(routin[0]);

    for (int v : routin) {
      if (find(v) != targetSet) {
        bw.write("NO");
        return;
      }
    }

    bw.write("YES");
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    // Union info, size: 도시의 수
    set = new int[N + 1];
    // Setting init set INFO
    for (int i = 0; i <= N; i++) {
      set[i] = i;
    }

    StringTokenizer st;
    for (int i = 1; i <= N; i++) { // v1 index
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) { // v2 index
        int isConnect = Integer.parseInt(st.nextToken()); // 0: false, 1:true
        if (isConnect == 1) union(i, j);
      }
    }

    st = new StringTokenizer(br.readLine());
    int[] route = new int[M];
    for (int i = 0; i < M; i++) {
      route[i] = Integer.parseInt(st.nextToken());
    }
    // TODO: 연결정보 확인 함수 실행
    confirm(route);

    bw.flush();
  }
}
