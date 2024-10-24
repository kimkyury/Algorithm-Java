import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, K;
    static int[][] map;
    static int minCnt = Integer.MAX_VALUE;

    static int[] dyDiag = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dxDiag = { -2, -1, 1, 2, 2, 1, -1, -2 };

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {

        // 대각선 (-1 -2)...
        // K번만 대각선 이동
        // K번 이후 사방탐색
        // 최소한의 동작으로 도착지점까지 가는 방법 알아내기 (return: 동작수)

        // 1: 장애물, 0: 평지
        // K<30, W,H < 200

        // BFs라면, 현재 갈 수 있는 경로와 K의 개수를 넣는다 (다음 경로와 K의 개수)

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        int result = BFS(0, 0);
        bw.write(result == -1 ? "-1" : String.valueOf(result));
        bw.flush();
    }

    public static int BFS(int y, int x) {
        boolean[][][] visited = new boolean[N][M][K + 1]; // y, x, 대각선 이동 횟수
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { y, x, 0, 0 }); // y, x, 대각선 이동 횟수, 이동 횟수

        visited[y][x][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0], cx = cur[1], ck = cur[2], ccnt = cur[3];

            if (cy == N - 1 && cx == M - 1) {
                return ccnt;
            }

            // 대각선 이동 (ck < K인 경우만 가능)
            if (ck < K) {
                for (int i = 0; i < 8; i++) {
                    int ny = cy + dyDiag[i];
                    int nx = cx + dxDiag[i];

                    if (!isOver(ny, nx) && map[ny][nx] == 0 && !visited[ny][nx][ck + 1]) {
                        visited[ny][nx][ck + 1] = true;
                        q.offer(new int[] { ny, nx, ck + 1, ccnt + 1 });
                    }
                }
            }

            // 사방 탐색
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (!isOver(ny, nx) && map[ny][nx] == 0 && !visited[ny][nx][ck]) {
                    visited[ny][nx][ck] = true;
                    q.offer(new int[] { ny, nx, ck, ccnt + 1 });
                }
            }
        }

        return -1; // 도착할 수 없는 경우
    }
    // public static void BFS(int y, int x, int k) {
    // //
    // boolean[][] passedDiag = new boolean[N][M];
    // boolean[][] passed = new boolean[N][M];

    // int cnt = -1;
    // Queue<int[]> q = new ArrayDeque<>();
    // q.offer(new int[] { y, x, k });
    // passed[y][x] = true;
    // passedDiag[y][x] = true;

    // while (!q.isEmpty()) {

    // int size = q.size();
    // cnt++;
    // for (int i = 0; i < size; i++) {

    // int[] cur = q.poll();

    // if (cur[0] == N - 1 && cur[1] == M - 1) {
    // minCnt = cnt;
    // return;
    // }

    // if (cur[2] < K) {
    // // 대각선으로 가보기
    // for (int j = 0; j < 8; j++) {
    // int ny = cur[0] + dyDiag[j];
    // int nx = cur[1] + dxDiag[j];

    // if (isOver(ny, nx)) {
    // continue;
    // }

    // if (map[ny][nx] == 1) {
    // continue;
    // }

    // if (passedDiag[ny][nx]) {
    // continue;
    // }

    // passedDiag[ny][nx] = true; // 얼룩말이 간 곳.
    // // 사방탐색의 경우, 얼룩말이 간 곳도 갈 수 있어야 한다
    // q.offer(new int[] { ny, nx, cur[2] + 1 });
    // }
    // }

    // for (int j = 0; j < 4; j++) {
    // int ny = cur[0] + dy[j];
    // int nx = cur[1] + dx[j];

    // if (isOver(ny, nx)) {
    // continue;
    // }

    // if (map[ny][nx] == 1) {
    // continue;
    // }

    // if (passed[ny][nx]) {
    // continue;
    // }

    // passed[ny][nx] = true;
    // q.offer(new int[] { ny, nx, cur[2] });
    // }
    // }
    // }
    // }

    public static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > N - 1 || x > M - 1) {
            return true;
        }
        return false;
    }
}