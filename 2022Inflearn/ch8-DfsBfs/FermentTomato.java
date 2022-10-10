import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    static int M, N;
    static int[] dx = { 0, 1, 0, -1 }; // 시계방향으로 하자
    static int[] dy = { 1, 0, -1, 0 };

    static int[][] map;
    static int[][] dis;
    static int cnt = 0;
    static int day = 1;
    static boolean isArrive = false;

    public static void solve() {

        Queue<Point> q = new LinkedList<>();

        // 1인 지점 저장하기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1) {
                    Point p = new Point(i, j);
                    q.offer(p);
                }
            }
        }

        while (!q.isEmpty()) {
            // day에 대한 정보는 dis배열에 저장된다

            Point p = q.poll();

            for (int i = 0; i < 4; i++) {

                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx > 0 && nx <= N && ny > 0 && ny <= M && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        dis = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
            }
        }

        solve();

        boolean flag = true;
        int max = Integer.MIN_VALUE;

        // 전염여부 파악 후, 익지않은 토마토가 존재한다 => 0
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0)
                    flag = false;
            }
        }

        if (flag) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (dis[i][j] > max) {
                        max = dis[i][j];
                    }
                }
            }

            System.out.println(max);
        } else {
            System.out.println(-1);
        }

    }

}