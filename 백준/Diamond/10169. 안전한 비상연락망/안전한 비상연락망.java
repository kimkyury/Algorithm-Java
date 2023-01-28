import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Bridge implements Comparable<Bridge> {

  int bridgeId;
  int country1;
  int country2;
  int cost;

  Bridge(int country1, int country2, int cost, int bridgeId) {
    this.country1 = country1;
    this.country2 = country2;
    this.cost = cost;
    this.bridgeId = bridgeId;
  }

  @Override
  public int compareTo(Bridge o) {
    return this.cost - o.cost;
  }
}

class Main {

  static int N, M;
  static ArrayList<ArrayList<Bridge>> countries;
  static int[] isPassed;

  public static void bfs(int unusableId) {
    PriorityQueue<Bridge> pq = new PriorityQueue<>();

    isPassed[1] = 1;
    for (Bridge b : countries.get(1)) {
      if (b.bridgeId == unusableId) {
        continue;
      }
      pq.offer(b); // poll하면 도로 길이가 짧은 순으로 리턴됨
    }

    int totalCost = 0;
    while (!pq.isEmpty()) {
      Bridge minB = pq.poll();
      if (minB.bridgeId == unusableId) {
        continue;
      }

      int country2 = minB.country2;
      if (isPassed[country2] == 0) {
        isPassed[country2] = 1;
        totalCost += minB.cost;
        for (Bridge b : countries.get(country2)) {
          pq.offer(b);
        }
      } else {
        continue;
      }
    }

    for (int i = 1; i < N + 1; i++) {
      if (isPassed[i] == 0) {
        System.out.println("-1");
        return;
      }
    }

    System.out.println(totalCost);
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    //ArrayList<Bridge> connectBridge = new ArrayList<>();
    countries = new ArrayList<ArrayList<Bridge>>();
    for (int j = 0; j < N + 1; j++) countries.add(new ArrayList<Bridge>());

    int bridgeId = 1;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int country1 = Integer.parseInt(st.nextToken());
      int country2 = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      countries
        .get(country1)
        .add(new Bridge(country1, country2, cost, bridgeId));
      countries
        .get(country2)
        .add(new Bridge(country2, country1, cost, bridgeId));
      bridgeId++;
    }

    for (int i = 1; i <= M; i++) {
      isPassed = new int[N + 1];
      bfs(i);
    }
  }
}
