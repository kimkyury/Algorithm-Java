import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int M;

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    static int map[][];
    static int maxSum;
    static boolean isPassed[][];

    public static void dfs(int y, int x, int cnt, int sum) {

        if (cnt == 4) {
            // System.out.print(sum + " ");
            maxSum = Math.max(sum, maxSum);
            return;
        }

        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                continue;
            }
            if (isPassed[ny][nx] == true)
                continue;

            isPassed[ny][nx] = true;
            dfs(ny, nx, cnt + 1, sum + map[ny][nx]);
            isPassed[ny][nx] = false;
        }

    }

    public static void confirmSpectialCase(int y, int x) {

        // 상, 우, 하, 좌
        int dys[][] = {
                { -1, 0, 0 }, { -1, 0, 1 }, { 0, 1, 0 }, { 1, 0, -1 }
        };

        int dxs[][] = {
                { 0, 1, -1 }, { 0, 1, 0 }, { 1, 0, -1 }, { 0, -1, 0 }
        };

        int ny, nx;

        for (int i = 0; i < 4; i++) {
            int sum = map[y][x];
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                ny = y + dys[i][j];
                nx = x + dxs[i][j];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }
                cnt++;
                int value = map[ny][nx];
                sum += value;
            }

            if (cnt == 3) {
                maxSum = Math.max(sum, maxSum);
            }
        }

    }

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maxSum = 0;
        isPassed = new boolean[N][M];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // System.out.print("start:" + i + " " + j + " :");
                dfs(i, j, 0, 0);
                // System.out.println("");
                confirmSpectialCase(i, j);
            }
        }

        bw.write(String.valueOf(maxSum) + " ");

        bw.flush();
    }
}
