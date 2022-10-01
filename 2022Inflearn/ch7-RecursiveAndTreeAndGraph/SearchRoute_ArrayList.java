import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean passed[];
    static int N;
    static int cnt = 0;

    // 1번부터 시작
    public void solve(int v) {

        if (v == N) {
            cnt++;
            return;
        }

        for (int x : graph.get(v)) {

            if (passed[x] != true) {
                passed[x] = true;
                solve(x);
                passed[x] = false;
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

        passed[1] = true;
        main.solve(1);
        System.out.println(cnt);
    }
}