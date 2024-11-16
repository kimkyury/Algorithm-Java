import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;
    static int[][] tree;

    public static void main(String[] args) throws IOException {

        // 선택된 수의 합이 최대가 되는 경로를 구하기

        N = Integer.parseInt(br.readLine());

        tree = new int[N + 1][];
        for (int i = 0; i < N; i++) {
            tree[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        bw.write(dp() + "");
        bw.flush();
    }

    private static int dp() {
        // 하단부터 누적합 계산
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < tree[i].length; j++) {
                // 더 큰 값 선택하기.
                tree[i][j] += Math.max(tree[i + 1][j], tree[i + 1][j + 1]);
            }
        }
        return tree[0][0];
    }

    private static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();

        // v는 2n, 2n+1만 선택할수 있다

        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
        // 7 3 8 8 1 9 2 7 4 .4 .4 .5 .2 .6 .5
        // 1 -> 2/3
        // 2 -> 4/5
        int max = 0;
        q.offer(new int[] { 1, 0, tree[1][0] });
        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                if (cur[0] == N) {
                    max = Math.max(max, cur[2]);
                    continue;
                }

                if (cur[1] + 1 > tree[cur[0] + 1].length - 1) {
                    // max = Math.max(max, cur[2]);
                    continue;
                }

                q.offer(new int[] { cur[0] + 1, cur[1], cur[2] + tree[cur[0] + 1][cur[1]] });
                q.offer(new int[] { cur[0] + 1, cur[1] + 1, cur[2] + tree[cur[0] + 1][cur[1] + 1] });
            }
        }
        return max;
    }

    private static void show(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
