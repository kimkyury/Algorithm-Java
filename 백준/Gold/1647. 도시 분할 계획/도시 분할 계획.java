import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;

    static List<List<int[]>> tree;
    static int[] parent;
    static List<int[]> choice;
    static int[][] edge;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        // 1. 양방향, 양수 간선
        // 다익스트라 -> 한 정점에서 모든 정점을 가기 위한 방법이고.
        // 크루스칼, 프림 -> 모든 정점을 지나는 트리를 찾기 위한 방법
        // 크루스칼로 가자.

        // 1. 가중치를 오름차순으로 정렬한다
        // 2. 사이클을 형성하지 않는 간선을 선택한다

        // 길의 유지비의 합을 최소
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new int[] { v1, v2, cost });
        }

        bw.write(kruskal(pq) + "\n");
        bw.flush();
    }

    public static long kruskal(PriorityQueue<int[]> pq) {

        long sum = 0;
        int max = 0;
        boolean[] passed = new boolean[N + 1];
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();

            if (find(edge[0]) == find(edge[1])) {
                continue;
            }
            // System.out.println(Arrays.toString(edge));
            passed[edge[0]] = true;
            union(edge[0], edge[1]);
            max = Math.max(edge[2], max);
            sum += edge[2];
        }

        return sum - max;
    }

    public static void union(int a, int b) {

        int pA = find(a);
        int pB = find(b);

        if (pA < pB) {
            parent[pB] = pA;
        } else {
            parent[pA] = pB;
        }
    }

    public static int find(int a) {

        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    public static void print(int map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
