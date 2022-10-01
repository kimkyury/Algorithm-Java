import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean passed[];
    static int N;
    static int cnt = 0;
    static int[] dis;

    // 1번부터 시작
    public void solve(int v) {

        Queue<Integer> Q = new LinkedList<>();

        passed[v] = true;
        Q.offer(v);
        while (!Q.isEmpty()) {
            int curV = Q.poll();

            // 현재 V와 연결된 nV들을 조사한다
            for (int nV : graph.get(curV)) {

                // 현재노드와 직행할 수 있는 곳이면서, 앞서 조사하지 않은 곳이라면
                // *조사하지 않았다 = 1을 시작점으로 하여금 도착할 수 있는 곳인지 판단되지 않았다
                if (passed[nV] != true) {
                    passed[nV] = true;
                    Q.offer(nV);

                    dis[nV] = dis[curV] + 1;
                }

            }
        }

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        dis = new int[N];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        passed = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            graph.get(row).add(col);
        }

        main.solve(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}