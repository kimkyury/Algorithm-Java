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
    static int N;
    static int[] dx = { 0, 1, 0, -1 }; // 시계방향으로 하자
    static int[] dy = { 1, 0, -1, 0 };

    static int map[][] = new int[8][8];
    static int dis[][] = new int[8][8];
    static int cnt = 0;
    static boolean isArrive = false;

    public static void solve(int r, int c) {

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c)); // 1,1

        while (!q.isEmpty()) {

            int size = q.size();
            for (int j = 0; j < size; j++) {

                Point p = q.poll();
                if (p.x == 7 && p.y == 7) {
                    isArrive = true;
                    return;
                }

                for (int i = 0; i < 4; i++) {

                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    Point np = new Point(nx, ny);

                    if (np.x > 0 && np.x < 8 && np.y > 0 && np.y < 8 && map[np.x][np.y] == 0) {
                        map[np.x][np.y] = 1;
                        q.offer(np);
                        dis[np.x][np.y] = dis[p.x][p.y] + 1;
                    }
                }

            }

            cnt++;

        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map[1][1] = 1; // 시작점 체크gvfcxzaaqㅁㅂ aq
        solve(1, 1);

        if (dis[7][7] == 0)
            System.out.println(-1);
        else
            System.out.println(dis[7][7]);

    }

}