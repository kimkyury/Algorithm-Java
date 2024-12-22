import java.io.*;

import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M;
    static int[][] map;
    static int min;
    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {

        // K개 CCTV
        // 감시할 수 있는 방향에 있는 칸 전체를 감시 가능

        // 사각지대의 최소 크기
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // CCTV는 최대 8개
        List<int[]> cctvPoses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvPoses.add(new int[] { i, j });
                }
            }
        }

        min = Integer.MAX_VALUE;
        getOrder(cctvPoses, new int[cctvPoses.size()], 0);

        // cctv 별로 방향을 결정해본다
        // 1. CCTV 각각을 회전시키면서 탐색영역을 체크한다

        bw.write(min + "");
        bw.flush();
    }

    static void getOrder(List<int[]> cctvPos, int[] order, int idx) {

        if (idx == cctvPos.size()) {
            // 해당 order 대로 수행했을 때 사각지대의 최소 크기를 탐색한다
            int cnt = check(new boolean[N][M], order, cctvPos);
            min = Math.min(cnt, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            order[idx] = i;
            getOrder(cctvPos, order, idx + 1);
        }
    }

    static int check(boolean[][] passed, int[] order, List<int[]> cctvPos) {

        // 각 방향별로 탐색가능한 부분을 체크

        for (int i = 0; i < order.length; i++) {

            int[] pos = cctvPos.get(i);
            int num = map[pos[0]][pos[1]];
            int curOrder = order[i];

            int ny = pos[0] + dy[curOrder];
            int nx = pos[1] + dx[curOrder];
            paint(ny, nx, passed, curOrder);
            switch (num) {
                case 1:
                    break;
                case 2:

                    ny = pos[0] + dy[(curOrder + 2) % 4];
                    nx = pos[1] + dx[(curOrder + 2) % 4];
                    paint(ny, nx, passed, (curOrder + 2) % 4);
                    break;

                case 3:
                    ny = pos[0] + dy[(curOrder + 1) % 4];
                    nx = pos[1] + dx[(curOrder + 1) % 4];
                    paint(ny, nx, passed, (curOrder + 1) % 4);
                    break;

                case 4:
                    ny = pos[0] + dy[(curOrder + 1) % 4];
                    nx = pos[1] + dx[(curOrder + 1) % 4];
                    paint(ny, nx, passed, (curOrder + 1) % 4);

                    ny = pos[0] + dy[(curOrder + 2) % 4];
                    nx = pos[1] + dx[(curOrder + 2) % 4];
                    paint(ny, nx, passed, (curOrder + 2) % 4);

                    break;
                case 5:

                    ny = pos[0] + dy[(curOrder + 1) % 4];
                    nx = pos[1] + dx[(curOrder + 1) % 4];
                    paint(ny, nx, passed, (curOrder + 1) % 4);

                    ny = pos[0] + dy[(curOrder + 2) % 4];
                    nx = pos[1] + dx[(curOrder + 2) % 4];
                    paint(ny, nx, passed, (curOrder + 2) % 4);

                    ny = pos[0] + dy[(curOrder + 3) % 4];
                    nx = pos[1] + dx[(curOrder + 3) % 4]; // 3, 4, 5, 6 -> 3, 0, 1, 2
                    paint(ny, nx, passed, (curOrder + 3) % 4);

                    break;
            }
        }

        int result = 0;
        // show(passed);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!passed[i][j] && map[i][j] == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    static void show(boolean[][] passed) {
        System.out.println("----------------------");
        for (int i = 0; i < passed.length; i++) {
            for (int j = 0; j < passed[i].length; j++) {
                if (passed[i][j]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println("");
        }
    }

    static void paint(int ny, int nx, boolean[][] passed, int d) {

        while (true) {
            if (isOver(ny, nx)) {
                break;
            }
            if (map[ny][nx] == 6) {
                break;
            }
            passed[ny][nx] = true;
            ny += dy[d];
            nx += dx[d];
        }

    }

    static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > N - 1 || x > M - 1) {
            return true;
        }
        return false;
    }
}
