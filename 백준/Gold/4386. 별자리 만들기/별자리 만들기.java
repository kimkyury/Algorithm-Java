import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Star {

  double x;
  double y;

  Star(double x, double y) {
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

  static int N;
  static Star[] stars;
  static Cost[] costs;
  static int[] parent; // V기준 집합정보
  static int costCnt;
  // static int final_cost;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static double solve() {
    // sorting About cost
    double answerCost = 0;
    Arrays.sort(costs, (o1, o2) -> Double.compare(o1.cost, o2.cost));

    // setting parent INFO
    for (int i = 0; i < N; i++) parent[i] = i;

    // kruskal
    for (int i = 0; i < costCnt; i++) {
      // Confirm: is not Cycle?
      if (find(costs[i].v1) != find(costs[i].v2)) {
        // 집합으로 묶기
        union(costs[i].v1, costs[i].v2);
        // 비용 더하기
        answerCost += costs[i].cost;
      }
    }

    return answerCost;
  }

  static int find(int v) {
    if (v == parent[v]) return v;
    return parent[v] = find(parent[v]);
  }

  static void union(int v1, int v2) {
    int parentV1 = find(v1);
    int parentV2 = find(v2);

    // Grouping 해줘야 한다면
    if (parentV1 != parentV2) {
      if (parentV1 < parentV2) parent[parentV2] =
        parentV1; else parent[parentV1] = parentV2;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());

    stars = new Star[N]; // star.x, star.y

    // costs의 최대 개수 구하기 ( (N-1) + (N-2) + ... + 1)
    int limit = N - 1;
    costCnt = 0;
    while (true) {
      if (limit == 0) break;
      costCnt += limit;
      limit--;
    }
    // System.out.println(costCnt);

    costs = new Cost[costCnt]; // [N][0] = v1, [N][1] = v2, [N][2] = cost
    parent = new int[N]; // star 수만큼 (index시작은 0부터)

    // set Star INFO (x, y)
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      double x = Double.parseDouble(st.nextToken());
      double y = Double.parseDouble(st.nextToken());
      stars[i] = new Star(x, y);
    }

    // set cost INFO (star1 - star2)
    int costIndex = 0;
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        // System.out.println("--------" + i + "--" + j + "-------");
        double diffX = stars[i].x - stars[j].x;
        double diffY = stars[i].y - stars[j].y;
        // System.out.print(diffX + diffY + " ");
        double cost = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
        costs[costIndex] = new Cost(i, j, cost);

        // System.out.println(cost);
        costIndex++;
      }
    }

    // TODO: 연결정보 확인 함수 실행
    bw.write(String.valueOf(solve()));

    bw.flush();
  }
}
