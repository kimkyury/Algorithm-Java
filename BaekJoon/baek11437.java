import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

class Main {

  static ArrayList<Integer>[] tree;
  static int[][] parents;
  static int[] levels;
  static int[] visit;
  static int N;

  public static void setFirstParent(int l, int v) {
    visit[v] = 1;
    levels[v] = l++;

    for (int nextV : tree[v]) {
      if (visit[nextV] == 1) continue;
      parents[nextV][0] = v;
      setFirstParent(l, nextV);
    }
  }

  public static void setRestOfTheParents() {
    for (int p = 1; p < 16; p++) { // parents[v][0]은 이미 세팅되어있음
      for (int v = 1; v <= N; v++) {
        int tmp = parents[v][p - 1];
        parents[v][p] = parents[tmp][p - 1];
      }
    }
  }

  public static int findLeastCommonAncetor(int v1, int v2) {
    if (levels[v1] > levels[v2]) {
      int tmp = v1;
      v1 = v2;
      v2 = tmp;
    } //v2가 더 높은 level의 vertex가 되도록

    for (int i = 15; i >= 0; i--) {
      int jump = 1 << i; //  2^15, ..., 8, 4, 2, 1
      if (levels[v2] - levels[v1] >= jump) { //레벨 차이가 존재한다면
        // 가령, 5가 차이난다면 i=2가 되겠지
        v2 = parents[v2][i]; // 더 큰 쪽(v2)의 상위 부모로 비교한다
      }
    }

    //높이를 맞추자마자 부모노드가 통일될 수도 있다
    if (v2 == v1) return v1;

    for (int i = 15; i >= 0; i--) {
      if (parents[v1][i] == parents[v2][i]) continue;

      v1 = parents[v1][i];
      v2 = parents[v2][i];
    }

    return parents[v1][0];
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    tree = new ArrayList[N + 1];
    parents = new int[N + 1][16];
    visit = new int[N + 1];
    levels = new int[N + 1];

    for (int i = 0; i <= N; i++) tree[i] = new ArrayList<Integer>();

    int cnt = 0;
    StringTokenizer st;
    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      tree[v1].add(v2);
      tree[v2].add(v1);
    }

    setFirstParent(0, 1); //setting level & hierarchical
    setRestOfTheParents();

    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      System.out.println(findLeastCommonAncetor(v1, v2));
    }
  }
}
