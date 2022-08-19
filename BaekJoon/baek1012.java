import java.io.*;
import java.util.*;

public class baek1012 {
    static int m, n, k; // 입력받을 거
    static int[][] map; // 배추 위치 공간
    static boolean[][] visit;// 지나갔는지 확인
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 개수 받기

        for (int i = 0; i < t; i++) {
            int warm = 0;

            // 밭의 크기와 배추의 갯수를 받아오자
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[m][n];
            visit = new boolean[m][n];

            // 밭에 난 배추의 위치를 설정하자
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int mapX = Integer.parseInt(st.nextToken());
                int mapY = Integer.parseInt(st.nextToken());
                map[mapX][mapY] = 1;
            }

            // 군집의 개수를 셀 수 있도록 방문표시할 dfs를 실행시킬 반복문과 조건문을 작성하자
            // 1. map의 각 성분들 마다 반복
            // 2. 각 위치에 양배추가 있고, 방문하지 않은 좌표라면 dfs를 실행
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (map[x][y] == 1 && !visit[x][y]) {
                        dfs(x, y);
                        warm++;
                    }
                }
            }
            System.out.println(warm);
        }
    }

    //
    static void dfs(int x, int y) {
        visit[x][y] = true; // 방문표시 하자
        // (x,y)기준의 (x, y-1), (x-1, y), (x, y+1), (x+1, y)를 만들자
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            // (x,y)의 수평직 좌표 존재, 방문유무, 양배추 존재 확안
            if ((cx >= 0 && cy >= 0 && cx < m && cy < n) && !visit[cx][cy] && map[cx][cy] == 1) {
                dfs(cx, cy);
            }
        }
    }
}