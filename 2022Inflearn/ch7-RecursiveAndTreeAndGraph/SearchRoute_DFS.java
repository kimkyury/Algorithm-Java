import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[][] graph;
    static boolean passed[];
    static int N;
    static int cnt = 0;

    public void solve(int v) {

        // 목적지에 도달했을 시, count++
        if (v == N) {
            cnt++;
        } else {

            // 인접정보를 확인하여 순환한다
            for (int i = 1; i <= N; i++) {
                // 갈 수 있는 경로이며, 거친 적이 없을 때
                if (graph[v][i] == 1 && passed[i] != true) {
                    passed[i] = true;
                    solve(i);
                    // 같은 level의 또다른 가능한 노드를 찾기 위하여, passed취소
                    passed[i] = false;
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

        graph = new int[N + 1][N + 1];
        passed = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            graph[row][col] = 1;
        }

        passed[1] = true;

        main.solve(1);
        System.out.println(cnt);
    }
}