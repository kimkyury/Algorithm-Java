import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class God {

  int x;
  int y;

  God(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Cost {

  int v1;
  int v2;
  double cost;

  Cost(int v1, int v2, double cost) {
    this.v1 = v1;
    this.v2 = v2;
    this.cost = cost;
  }
}

class Main {

  static int N, M;
  static God[] gods;
  static Cost[] costs;
  static Cost[] existCosts;
  static int[] parent; // V기준 집합정보
  static int costCnt;
  static int costIndex;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static double solve() {
    // sorting About cost
    double answerCost = 0;
    existCosts = Arrays.copyOfRange(costs, 0, costIndex);
    Arrays.sort(existCosts, (o1, o2) -> Double.compare(o1.cost, o2.cost));

    // kruskal
    for (int i = 0; i < existCosts.length; i++) {
      // Confirm: is not Cycle?
      if (find(existCosts[i].v1) != find(existCosts[i].v2)) {
        // 집합으로 묶기
        union(existCosts[i].v1, existCosts[i].v2);
        // 비용 더하기
        answerCost += existCosts[i].cost;
      }
    }

    return answerCost;
  }

  public static void union(int v1, int v2) {
    int parentV1 = find(v1);
    int parentV2 = find(v2);

    if (parentV1 != parentV2) {
      if (parentV1 < parentV2) parent[parentV2] =
        parentV1; else parent[parentV1] = parentV2;
    }
  }

  public static int find(int v) {
    if (v == parent[v]) return v;
    return parent[v] = find(parent[v]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    gods = new God[N + 1];

    costCnt = 0;
    int limit = N - 1;
    while (true) {
      if (limit == 0) break;
      costCnt += limit--;
    }
    // System.out.println(costCnt);
    costs = new Cost[costCnt]; // 여기서 NFE나타나는 듯

    // init setting
    parent = new int[N + 1];
    for (int i = 0; i < N; i++) {
      parent[i] = i;
    }

    // setting God position
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      gods[i] = new God(x, y);
    }

    // setting connect INFO
    costIndex = 0;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      union(v1, v2);
      costs[costIndex++] = new Cost(v1, v2, 0);
    }

    // setting cost INFO, executeMax: 500,000? * find함수 호출

    for (int i = 1; i <= N; i++) {
      for (int j = i + 1; j <= N; j++) {
        //연결되지 않은 것들에 대한 간선만
        if (find(i) != find(j)) {
          int diffX = gods[i].x - gods[j].x;
          int diffY = gods[i].y - gods[j].y;
          double sum = Math.abs((Math.pow(diffX, 2) + Math.pow(diffY, 2)));
          double cost = Math.sqrt(sum);
          // System.out.println("v1: " + i + " , v2: " + j + ", cost: " + cost);
          costs[costIndex++] = new Cost(i, j, cost);
        }
      }
    }

    bw.write(String.format("%.2f", solve()));
    bw.flush();
  }
}
