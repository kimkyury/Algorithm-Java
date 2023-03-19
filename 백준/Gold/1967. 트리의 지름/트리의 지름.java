import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;
  static int N;

  static ArrayList<ArrayList<int[]>> edges; //edges.get(부모버텍스) -> 모든 자식들 순회 ->  [0]:자식버텍스 값 [1]: 가중치
  static int max;
  static int maxV;

  // static boolean[] isPassed;

  // 어떤 v로부터 가장 먼 거리에 있는 leafNode찾기
  // dfs로 방문함, dfs로 방문여부도 따져야 함
  public static void search(int V, int curDistance, boolean[] isPassed) {
    // 아마, V는 1로 줄 것이다

    // 현재가 가장 긴 경로로 온 Vertex라면
    isPassed[V] = true;
    if (curDistance > max) {
      max = curDistance;
      maxV = V;
    }

    ArrayList<int[]> tmpEdges = edges.get(V);

    for (int[] tmpEdge : tmpEdges) {
      int targetV = tmpEdge[0];
      int targetCost = tmpEdge[1];

      if (!isPassed[targetV]) {
        isPassed[targetV] = true;
        search(targetV, curDistance + targetCost, isPassed);
        isPassed[targetV] = false;
      }
    }
  }

  public static void main(String args[]) throws Exception {
    // st = new StringTokenizer(br.readLine());

    // 1. 트리를 어떻게 표현할 것인가
    // 2.부모 노드, 자식 노드, 가선의 가중치

    N = Integer.parseInt(br.readLine());
    edges = new ArrayList<>();

    boolean[] isPassed = new boolean[N + 1];
    for (int i = 0; i < N + 1; i++) {
      edges.add(new ArrayList<>()); // 1: root
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());

      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      int[] edgeInfo = { v2, cost };
      int[] edgeInfo2 = { v1, cost };
      edges.get(v1).add(edgeInfo);
      edges.get(v2).add(edgeInfo2);
    }

    search(1, 0, isPassed);
    isPassed = new boolean[N + 1];
    search(maxV, 0, isPassed);

    bw.write(String.valueOf(max) + "\n");
    bw.flush();
  }
}
