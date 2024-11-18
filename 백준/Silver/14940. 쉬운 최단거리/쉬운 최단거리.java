import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static int[][] sum;

    public static void main(String[] args) throws IOException {

        // 선택된 수의 합이 최대가 되는 경로를 구하기

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        sum = new int[N][M];

        int sy = 0, sx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    sy = i;
                    sx = j;
                }
            }
        }

        getDistance(sy, sx);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == sy && j == sx) {
                    sb.append("0" + " ");
                    continue;
                }

                if (sum[i][j] == 0 && map[i][j] != 0) {
                    sb.append("-1").append(" ");
                } else {
                    sb.append(sum[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void getDistance(int sy, int sx) {

        Queue<int[]> q = new ArrayDeque<>();

        boolean[][] passed = new boolean[N][M];
        q.offer(new int[] { sy, sx });
        passed[sy][sx] = true;

        // 우, 하, 좌, 상
        int[] dy = { 0, 1, 0, -1 };
        int[] dx = { 1, 0, -1, 0 };

        int cnt = 0;
        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] cur = q.poll();

                sum[cur[0]][cur[1]] = cnt;
                for (int j = 0; j < 4; j++) {
                    int ny = cur[0] + dy[j];
                    int nx = cur[1] + dx[j];

                    if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1) {
                        continue;
                    }

                    if (map[ny][nx] == 0) {
                        continue;
                    }

                    if (passed[ny][nx]) {
                        continue;
                    }

                    passed[ny][nx] = true;
                    q.offer(new int[] { ny, nx });
                }
            }
            cnt++;
        }

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
