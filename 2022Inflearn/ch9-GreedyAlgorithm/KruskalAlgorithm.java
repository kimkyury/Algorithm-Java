import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int weight;

    Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

class Main {

    static int N, M; // 입력정보
    static ArrayList<Edge> edges = new ArrayList<>();;
    static int[] unf;

    public static int find(int v) {
        if (v == unf[v])
            return unf[v];
        else
            return unf[v] = find(unf[v]);
    }

    // 연결관계 저장하기
    public static void union(int v1, int v2) {

        int findV1 = find(v1);
        int findV2 = find(v2);

        if (findV1 != findV2)
            unf[findV1] = findV2;

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        unf = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(v1, v2, weight));
        }

        int answer = 0;
        Collections.sort(edges);

        for (Edge edges : edges) {

            int fv1 = find(edges.v1);
            int fv2 = find(edges.v2);

            if (fv1 != fv2) { // 두개의 종착접, 속해있는 집합이 다르다면 (별개의 부분집합이라면)
                answer += edges.weight; // 연결하여 가중치를 더한다
                union(edges.v1, edges.v2); // 연결했으므로 집합 정보를 갱신해준다 (같은 집합으로 연결함)
            }

        }

        System.out.println(answer);
    }

}