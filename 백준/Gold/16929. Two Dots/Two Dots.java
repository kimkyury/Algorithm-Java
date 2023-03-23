import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;

    static char[][] map;
    static boolean[][] isPassed;
    static boolean flag;

    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };

    public static void bfs(int sx, int sy, int originalx, int originaly, int cnt) {

        if (flag)
            return;
        // System.out.println(sx + " " + sy + " 검색중");

        if (isPassed[originaly][originalx]) {
            // System.out.println("어? 되네요!");
            flag = true;
        }

        int nx, ny;
        for (int i = 0; i < 4; i++) {
            ny = sy + dy[i];
            nx = sx + dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                continue;
            }
            if (isPassed[ny][nx]) {
                continue;
            }
            if (map[ny][nx] != map[originaly][originalx]) {
                continue;
            }
            // 최소한 3칸은 패스해야 순환으로 인정
            if (ny == originaly && nx == originalx && cnt < 3) {
                continue;
            }
            isPassed[ny][nx] = true;
            bfs(nx, ny, originalx, originaly, cnt + 1);
        }

    }

    public static void main(String args[]) throws Exception {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = line.charAt(j);
        }

        for (int i = 0; i < M - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                // System.out.println("시작----");
                isPassed = new boolean[N][M];
                bfs(i, j, i, j, 0);
            }
        }

        if (flag)
            bw.write("Yes" + "\n");
        else
            bw.write("No" + "\n");
        bw.flush();
    }
}
