
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {

	int v;
	int totalCost;

	Edge(int v, int cost) {
		this.v = v;
		this.totalCost = cost;
	}
}

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int V, E, K;
	static boolean[] isPassed;
	static int[] costs;
	static ArrayList<ArrayList<Edge>> vertexs;

	public static void Dijkstra(int startV) {

		costs[startV] = 0; // startV -> startV 비용
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.totalCost - o2.totalCost);

//		for (Edge edge : vertexs.get(startV)) {
//			pq.offer(edge);
//		}
		pq.offer(new Edge(startV, 0));
		while (!pq.isEmpty()) {

			Edge sEdge = pq.poll();
			if (isPassed[sEdge.v])
				continue;

			isPassed[sEdge.v] = true;
			ArrayList<Edge> edges = vertexs.get(sEdge.v);

			// 한 정점에 달려있는 Edge들을 순환해서, 최단거리를 확인한다
			for (int i = 0; i < edges.size(); i++) {
				Edge edge = edges.get(i);

				if (costs[sEdge.v] + edge.totalCost < costs[edge.v]) {
					costs[edge.v] = costs[sEdge.v] + edge.totalCost;
				}

				pq.offer(new Edge(edge.v, costs[edge.v]));
			}
		}

	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		int startV = Integer.parseInt(br.readLine());
		isPassed = new boolean[V + 1];
		vertexs = new ArrayList<>();
		costs = new int[V + 1];

		for (int i = 0; i <= V; i++) {
			vertexs.add(new ArrayList<>());
			costs[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			vertexs.get(v1).add(new Edge(v2, cost));
		}

		Dijkstra(startV);

		for (int i = 1; i <= V; i++) {

			if (costs[i] == Integer.MAX_VALUE)
				bw.write("INF" + "\n");
			else
				bw.write(String.valueOf(costs[i]) + "\n");
		}

		bw.flush();
	}

}
