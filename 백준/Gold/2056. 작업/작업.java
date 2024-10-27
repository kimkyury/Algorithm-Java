import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N;
    static List<List<Integer>> tree;
    static int[] timeByN;
    static int[] parentCnt;
    static int[] finTime;

    public static void main(String[] args) throws IOException {

        // 작업 N개별 시간이 걸림
        // 선행 관계 존재
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        timeByN = new int[N + 1];
        parentCnt = new int[N + 1];
        finTime = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            timeByN[i] = T;

            int M = Integer.parseInt(st.nextToken());
            parentCnt[i] = M;
            for (int j = 0; j < M; j++) {
                int pV = Integer.parseInt(st.nextToken());
                tree.get(pV).add(i);
            }
        }

        // root 를 찾는다

        List<Integer> root = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (parentCnt[i] == 0) {
                root.add(i);
            }
        }

        int result = BFS(root);

        // 모든 작업을 완료하기 위한 최소시간 -> PQ , BFS

        bw.write(result + "");
        bw.flush();
    }

    public static int BFS(List<Integer> root) {

        Queue<Integer> q = new ArrayDeque<>();

        for (int r : root) {
            q.offer(r);
            finTime[r] = timeByN[r];
        }

        int totalTime = 0;
        while (!q.isEmpty()) {

            int v = q.poll();
            // 루트 개수 빼주기
            for (int child : tree.get(v)) {

                finTime[child] = Math.max(finTime[child], finTime[v] + timeByN[child]);
                parentCnt[child]--;

                if (parentCnt[child] == 0) {
                    q.offer(child);
                }
            }

            for (int i = 1; i <= N; i++) {
                totalTime = Math.max(totalTime, finTime[i]);
            }
        }

        return totalTime;
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
