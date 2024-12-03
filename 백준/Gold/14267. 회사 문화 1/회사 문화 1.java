import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M;

    static List<List<Integer>> tree;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1. 자식 정보를 저장하기

        cnt = new int[N + 1];
        tree = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 기존: O(M*N), 쿼리마다 자식 노드를 순회중

        // int root = -1;
        for (int i = 1; i <= N; i++) {
            int next = Integer.parseInt(st.nextToken());

            if (next == -1) {
                // root = i;
                continue;
            }

            tree.get(next).add(i);
        }

        // 1. 일단 현재를 더한다.
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            cnt[i] += w;
        }

        // 2. 상위 상관부터 전파시킨,,
        // O()

        dfs(1, 0);
        for (int i = 1; i <= N; i++) {
            bw.write(cnt[i] + " ");
        }
        // bw.write(Arrays.toString(cnt) + "");
        bw.flush();
    }

    static void dfs(int cur, int w) {
        cnt[cur] += w;

        for (int child : tree.get(cur)) {
            dfs(child, cnt[cur]);
        }
    }

    static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > 1 || x > N - 1) {
            return true;
        }
        return false;

    }
}
