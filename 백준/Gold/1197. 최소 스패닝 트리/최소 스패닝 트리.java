import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

  int v;
  int cost;

  Edge(int v, int cost) {
    this.v = v;
    this.cost = cost;
  }

  @Override
  public int compareTo(Edge o) {
    // sort 오름차순
    return this.cost - o.cost;
  }
}

class Main {

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static int V, E;
  static int[] isPassed;
  static int cntPassed;

  public static int solve(ArrayList<ArrayList<Edge>> vertexs)
    throws IOException {
    int sum = 0;

    ArrayList<Edge> first = vertexs.get(1);
    isPassed[1] = 1;
    cntPassed++;

    PriorityQueue<Edge> pq = new PriorityQueue<>();
    for (Edge nextE : first) pq.add(nextE);

    ArrayList<Edge> tmpV;
    while (!pq.isEmpty()) {
      Edge nextE = pq.poll();
      if (isPassed[nextE.v] == 1) continue;
      isPassed[nextE.v] = 1;
      sum += nextE.cost;
      cntPassed++;
      if (cntPassed == V) break;

      tmpV = vertexs.get(nextE.v);

      for (Edge tmpE : tmpV) pq.add(tmpE);
    }

    return sum;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    ArrayList<ArrayList<Edge>> vertex = new ArrayList<>();
    cntPassed = 0;
    isPassed = new int[V + 1];

    for (int i = 0; i <= V; i++) vertex.add(new ArrayList<Edge>());

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      vertex.get(v1).add(new Edge(v2, cost));
      vertex.get(v2).add(new Edge(v1, cost));
    }

    bw.write(String.valueOf(solve(vertex)));

    // bw.write()
    bw.flush();
  }
}
