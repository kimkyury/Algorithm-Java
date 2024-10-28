import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;

    static int[] rootCnt;
    static int[] order;
    static List<List<Integer>> children;
    static boolean[] passed;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        children = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            children.add(new ArrayList<>());
        }

        order = new int[N + 1];
        rootCnt = new int[N + 1];
        passed = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            children.get(p).add(c);
            rootCnt[c]++;
        }

        BFS();
        for (int i = 1; i <= N; i++) {
            bw.write(order[i] + " ");
        }

        bw.flush();
    }

    public static int BFS() {

        PriorityQueue<Integer> q = new PriorityQueue<>(
                (o1, o2) -> {
                    return o1 - o2;
                });

        int idx = 1;
        for (int i = 1; i <= N; i++) {
            if (rootCnt[i] == 0) {
                q.offer(i);
            }
        }

        // 4 2, 3 1
        // 3 4 중에선, 3을 먼저 풀고

        while (!q.isEmpty()) {

            int v = q.poll();

            if (rootCnt[v] == 0) {

                order[idx++] = v;
            }

            for (int child : children.get(v)) {

                rootCnt[child]--;

                if (rootCnt[child] == 0 && !passed[child]) {
                    q.offer(child);
                }
            }

        }

        return 0;
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
