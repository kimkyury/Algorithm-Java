import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] dx = { 0, 1, 0, -1 }; // 시계방향으로 하자
    static int[] dy = { 1, 0, -1, 0 };

    static int map[][] = new int[8][8];
    static int cnt = 0;

    public static void solve(int r, int c) {

        if (r == 7 && c == 7) {
            cnt++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && map[nx][ny] == 0) {
                map[nx][ny] = 1; // checking
                solve(nx, ny);
                map[nx][ny] = 0; // back Tracking
            }

            // if (nx < 1 || ny < 1 || nx > 7 || ny > 7) {
            // return;
            // }

            // if (map[nx][ny] == 0) {
            // map[nx][ny] = 1; // checking
            // solve(nx, ny);
            // map[nx][ny] = 0; // back Tracking
            // }

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

        map[1][1] = 1; // 시작점 체크
        solve(1, 1);

        System.out.println(cnt);

    }

}