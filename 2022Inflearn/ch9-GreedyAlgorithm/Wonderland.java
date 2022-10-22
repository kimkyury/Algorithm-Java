import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

    int v;
    int w;

    Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        // TODO Auto-generated method stub
        return this.w - o.w;
    }

}

class Main {

    static int N, M;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static int[] isPassed;

    public static int solution(int v) {

        int answer = 0;

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));

        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();

            int vertex = tmp.v;

            // 거친 적없는 V라면
            if (isPassed[vertex] == 0) {
                isPassed[vertex] = 1;
                answer += tmp.w;

                for (Edge edge : graph.get(vertex)) {
                    if (isPassed[edge.v] == 0) {
                        pQ.offer(new Edge(edge.v, edge.w));
                    }
                }

            }
        }

        return answer;

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isPassed = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Edge edge1 = new Edge(v2, weight);
            Edge edge2 = new Edge(v1, weight);

            graph.get(v1).add(edge1);
            graph.get(v2).add(edge2);

        }

        int answer = solution(1);

        System.out.println(answer);

    }

}