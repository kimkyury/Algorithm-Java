import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static char[][] map;
    static int[][] cntMap;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int maxCnt = 0;
    static boolean isEnd;
    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {

        // 네방향 1택, X만큼 이동, 구멍을 무시하고 감
        // 최대 움직일 수 있는 횟수 구하기

        // H는 구멍

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        cntMap = new int[N][M];
        isEnd = false;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        DFS(0, 0, 0, new boolean[N][M]);

        bw.write(maxCnt + "");
        bw.flush();
    }

    public static void DFS(int cnt, int y, int x, boolean[][] passed) {

        // 현재 위치가 바깥이거나, 구멍에 달하면 게임 종료

        if (isEnd) {
            return;
        }
        int num = map[y][x] - '0';

        for (int i = 0; i < 4; i++) {

            if (isEnd) {
                return;
            }
            int ny = y + dy[i] * num;
            int nx = x + dx[i] * num;

            if (isOver(ny, nx)) {
                maxCnt = Math.max(maxCnt, cnt + 1);
                continue;
            }

            if (map[ny][nx] == 'H') {
                passed[ny][nx] = true;
                maxCnt = Math.max(maxCnt, cnt + 1);
                continue;
            }

            if (passed[ny][nx]) {
                // 왔던 곳을 또 온다면 이건 무한이다
                maxCnt = -1;
                isEnd = true;
                return;
            }

            if (cntMap[ny][nx] < cnt + 1) {
                cntMap[ny][nx] = cnt + 1;
                passed[ny][nx] = true;
                DFS(cnt + 1, ny, nx, passed);
                passed[ny][nx] = false; // 원복시키기
            } else {
                // 가지치기
                continue;
            }
        }
    }

    public static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > N - 1 || x > M - 1)
            return true;
        return false;
    }
}
