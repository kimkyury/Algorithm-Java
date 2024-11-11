import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = { -1, -1, 1, 1 };
    static int[] dx = { -1, 1, -1, 1 };
    static int maxBlack = 0, maxWhite = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 흑과 백으로 나눠서 탐색
        dfs(0, 0, 0, true); // 흑색 칸 탐색
        dfs(0, 1, 0, false); // 백색 칸 탐색

        System.out.println(maxBlack + maxWhite);
    }

    public static void dfs(int y, int x, int count, boolean color) {
        if (x >= N) {
            y++;
            x = (x % 2 == 0) ? 1 : 0; // 체스판 색상에 따라 다음 시작 위치 조정
        }
        if (y >= N) {
            if (color) {
                maxBlack = Math.max(maxBlack, count);
            } else {
                maxWhite = Math.max(maxWhite, count);
            }
            return;
        }

        // 비숍을 놓을 수 있는 경우
        if (map[y][x] == 1 && !visited[y][x]) {
            if (canPlaceBishop(y, x)) {
                visited[y][x] = true;
                dfs(y, x + 2, count + 1, color);
                visited[y][x] = false;
            }
        }

        // 비숍을 놓지 않는 경우
        dfs(y, x + 2, count, color);
    }

    public static boolean canPlaceBishop(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y, nx = x;
            while (true) {
                ny += dy[i];
                nx += dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N)
                    break;
                if (visited[ny][nx])
                    return false;
            }
        }
        return true;
    }
}
