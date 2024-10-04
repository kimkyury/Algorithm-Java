import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int N, M;
    private static char[][] map;
    private static int[][] dp;
    private static boolean[][] mapR;
    private static int result = -1;

    private static int[] dy = { -1, 0, 1 };
    private static int[] dx = { 1, 1, 1 };

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // <= 50
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        mapR = new boolean[N][M];
        dp = new int[N][M];

        int[] posR = new int[2];
        int cntO = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'R') {
                    posR[0] = i;
                    posR[1] = j;
                } else if (map[i][j] == 'O') {
                    cntO++;
                }
            }
        }

        if (cntO != 0) {
            findMaxCarrot(posR);
        }

        bw.write(result + "");
        bw.flush();
    }

    private static void findMaxCarrot(int[] posR) {

        // 해당 위치에서, 이전에 가장 cnt가 큰 것을 가져온다
        // 만약 해당 위치에 c가 있다면 cnt++를 시킨다
        // 만약 해당 위치가 O라면 max를 수정한다

        mapR[posR[0]][posR[1]] = true;

        boolean isPossible;
        for (int x = posR[1] + 1; x < M; x++) {
            for (int y = 0; y < N; y++) {

                int preMax = 0;

                isPossible = false;
                for (int i = 0; i < 3; i++) {

                    int ny = y - dy[i];
                    int nx = x - dx[i];

                    if (ny < 0 || ny > N - 1 || nx > M - 1) {
                        continue;
                    }

                    if (map[ny][nx] == '#') {
                        continue;
                    } else if (mapR[ny][nx]) {
                        // R의 전파 영역인가
                        isPossible = true;
                    }

                    preMax = Math.max(preMax, dp[ny][nx]);
                }

                if (!isPossible) {
                    continue;
                }

                mapR[y][x] = true;
                if (map[y][x] == 'C') {
                    dp[y][x] += preMax + 1;
                } else if (map[y][x] == 'O') {
                    dp[y][x] = preMax;
                    result = Math.max(result, dp[y][x]);
                } else if (map[y][x] == '#') {
                    dp[y][x] = 0;
                } else if (map[y][x] == '.') {
                    dp[y][x] = preMax;
                }
            }
        }
    }

    private static void print(int[][] map) {
        System.out.println("-----------------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static void print(boolean[][] passed) {
        System.out.println("-----------------");
        for (int i = 0; i < passed.length; i++) {
            for (int j = 0; j < passed[0].length; j++) {

                if (passed[i][j])
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.println("");
        }
    }
}