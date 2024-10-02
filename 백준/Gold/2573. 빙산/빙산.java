import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int[] dy = { 1, 0, -1, 0 };
    private static int[] dx = { 0, 1, 0, -1 };
    private static int[][] map;
    private static int N, M;

    public static void main(String[] args) throws IOException {

        // 바다: 0
        // 인접한 0만큼 높이-- (min: 0)
        // 최초로 두 덩어리 이상 되는 순간 구하기 else 0

        // 3 <= N,M <= 300, 3 * 10^4
        // map[i][j] <= 10, 10^3

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        Queue<int[]> iceQ = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    int[] info = { i, j, map[i][j] }; // y, x, H
                    iceQ.offer(info);
                }
            }
        }

        int year = 0;
        while (true) {
            if (iceQ.isEmpty()) {
                bw.write("0");
                break;
            }

            // 확인하기
            if (isDivided(iceQ)) {
                bw.write(year + "");
                break;
            }

            // 녹이기
            melt(iceQ);

            // print(map);
            if (iceQ.isEmpty()) {
                bw.write("0");
                break;
            }

            year++;
        }

        bw.flush();
    }

    private static boolean isDivided(Queue<int[]> iceQ) {

        Set<String> posSet = new HashSet<>();
        iceQ.forEach(e -> {
            String str = e[0] + "," + e[1];
            posSet.add(str);
        });

        boolean[][] isPassed = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(iceQ.peek());

        while (!q.isEmpty()) {

            int[] pos = q.poll();
            String str = pos[0] + "," + pos[1];
            posSet.remove(str);

            for (int i = 0; i < 4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];

                if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1) {
                    continue;
                }

                if (isPassed[ny][nx]) {
                    continue;
                }

                if (map[ny][nx] != 0) {
                    isPassed[ny][nx] = true;
                    int[] nextPos = { ny, nx };
                    q.offer(nextPos);
                }
            }
        }

        if (posSet.size() != 0) {
            return true;
        }

        return false;
    }

    private static void melt(Queue<int[]> q) {

        int size = q.size();
        int[][] newMap = new int[N][M];
        for (int i = 0; i < size; i++) {
            int[] info = q.poll();

            int seaCnt = 0;
            for (int j = 0; j < 4; j++) {
                int ny = info[0] + dy[j];
                int nx = info[1] + dx[j];

                if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1) {
                    continue;
                }

                if (map[ny][nx] == 0) {
                    seaCnt++;
                }
            }

            info[2] = Math.max(0, info[2] - seaCnt);
            newMap[info[0]][info[1]] = info[2];
            if (info[2] > 0) {
                q.offer(info); // 안 녹은 건 다시 녹일 대상으로 넣기
            }
        }

        map = newMap;
    }

    private static void print(int[][] map) {
        System.out.println("-----------------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
}