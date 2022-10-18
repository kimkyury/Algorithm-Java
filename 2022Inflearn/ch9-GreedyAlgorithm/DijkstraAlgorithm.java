import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

    int V;
    int W;

    Edge(int V, int W) {
        this.V = V;
        this.W = W;
    }

    @Override
    public int compareTo(Edge o) {
        return this.W - o.W;
    }
}

class Main {

    static int N, M; // 입력정보
    static ArrayList<ArrayList<Edge>> map = new ArrayList<>(); // 입력정보
    static int[] dis;

    public static void solve(int v) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(v, 0)); // v1이 v1으로 가는 길
        dis[v] = 0; // 스스로에게 가는 거리는 0

        while (!pq.isEmpty()) {
            Edge tmp = pq.poll(); // 가장 짧은 거리를 리턴받음
            int curV = tmp.V; // 가장 짧은거리의 V를 가르킴
            int curW = tmp.W; // 가장 짧은 거리의 W를 가르킴

            if (curW > dis[curV]) {
                // 현재 가중치가 이전의 가중치보다 크다면 스쳐지나갈 것 (갱신할 필요 없다)
                continue;
            }

            // 현재 가중치가 이전 가중치보다 작아서 갱신해야한다면
            for (Edge ob : map.get(curV)) {
                if (dis[ob.V] > curW + ob.W) { // 기존의 최소 가중치 > (현재가중치 + 간선 가중치) => 교체
                    dis[ob.V] = curW + ob.W;
                    pq.offer(new Edge(ob.V, curW + ob.W));
                }

            }

        }

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map.get(v1).add(new Edge(v2, weight));
        }

        solve(1);

        for (int i = 1; i <= N; i++) {
            System.out.println(i + ": " + dis[i]);

        }

    }

}