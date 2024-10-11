import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int N, M;
    private static int[][] map;

    private static int[] dy = { -1, 0, 1, 0 };
    private static int[] dx = { 0, 1, 0, -1 };

    private static int cleanCnt;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sPos = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        int d = Integer.parseInt(st.nextToken());
        cleanCnt = 1;

        // 0: Empty, 1: wall
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(sPos, d);

        // print(map);

        bw.write(cleanCnt + "");
        bw.flush();
    }

    private static void search(int[] pos, int d) {

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { pos[0], pos[1], d });
        map[pos[0]][pos[1]] = 2;
        while (!q.isEmpty()) {

            // 현위치 청소
            int[] cur = q.poll();
            // 네 방향 탐색
            boolean possible = false;
            int nd = cur[2], ny = -1, nx = -1;

            for (int i = 0; i < 4; i++) {

                nd = (nd + 3) % 4; //
                ny = cur[0] + dy[nd];
                nx = cur[1] + dx[nd];

                if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1) {
                    continue;
                }

                if (map[ny][nx] == 0) {
                    map[ny][nx] = 2;
                    possible = true;
                    cleanCnt++;
                    q.offer(new int[] { ny, nx, nd });
                    break;
                }
            }

            if (!possible) {

                // 갈 곳이 없는 경우
                nd = (cur[2] + 2) % 4;
                ny = cur[0] + dy[nd];
                nx = cur[1] + dx[nd];

                if (map[ny][nx] == 1) {
                    return;
                }
                q.offer(new int[] { ny, nx, cur[2] });
            }
        }

        // 1. 현위치가 청소되지 않으면 청소함

        // 2. 4방향 for문 탐색
        // 3-1. 만약, 0인 칸이 없다면 pos[0] +1 을 시키고 다시 4방향 탐색

        // 현재 칸의 4칸 중 청소되지 않은 빈 칸이 있다면
        // 1.발견할 때까지 반시계 방향 90도 회전
        // 2. 민약, 자신의 바로 앞 칸이 0인 거면 전진 -> q.offer()

        // 2. 주위 4칸에 대하여 청소되지 않은 빈 칸이 없는 경우
        // 방향 유지 && 한칸유지 간으 -> 한칸 후진하고 1로 돌아감
        // 방향의 뒤칸이 벽인 경우 -> 작동 멈춤

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

    private static void print(int[][] passed) {
        System.out.println("-----------------");
        for (int i = 0; i < passed.length; i++) {
            for (int j = 0; j < passed[0].length; j++) {
                System.out.print(passed[i][j] + " ");
            }
            System.out.println("");
        }
    }
}