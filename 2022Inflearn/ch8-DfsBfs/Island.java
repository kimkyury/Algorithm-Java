import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] xs = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] ys = { -1, -1, 0, 1, 1, 1, 0, -1 };

    static int N;
    static int[][] map;
    static int cnt = 0;

    public static void solve(int x, int y) {

        for (int i = 0; i < 8; i++) {
            int nx = x + xs[i];
            int ny = y + ys[i];

            if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {

                if (map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    solve(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 땅이 존재하고, 아직 조사해본 적 없는 곳이라면 조사하는 함수를 실행시킨다
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    solve(i, j);
                    cnt++;
                }

            }
        }

        System.out.println(cnt);

    }

}