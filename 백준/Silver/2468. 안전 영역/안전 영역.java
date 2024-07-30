
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int[] xs = { 0, 1, 0, -1 };
    private static int[] ys = { 1, 0, -1, 0 };

    private static int[][] map;

    public static void main(String[] args) throws IOException {

        // BFS로 지나지 않은 부분들을 돌면서 +1을 시킨다
        // 물의 높이가 min ~ max 인 경우를 반복해서 최대값을 구한다 // Set으로 각 물의 높이 종류들을 관리
        // 최대: 100 * 100* 100 = 10 ^6

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        Set<Integer> hSet = new HashSet<>();
        hSet.add(0);
        int value = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                value = Integer.parseInt(st.nextToken());
                hSet.add(value);
                map[i][j] = value;
            }
        }

        Iterator<Integer> iter = hSet.iterator();
        int maxSafeCnt = 0;
        while (iter.hasNext()) {
            maxSafeCnt = Math.max(getSafeCnt(iter.next(), N), maxSafeCnt);
        }

        bw.write(String.valueOf(maxSafeCnt));
        bw.flush();

    }

    public static int getSafeCnt(int h, int N) {

        boolean[][] passed = new boolean[N][N];

        // 잠긴 곳 전처리
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] <= h) {
                    passed[i][j] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // 잠기지 않은 곳이라면 탐색 시작
                if (!passed[i][j]) {
                    cnt++;
                    int[] yx = { i, j };
                    bfs(passed, yx, N, h);
                    // show(passed);
                }
            }
        }
        // System.out.println("when h: " + h + ", result: " + cnt);
        return cnt;
    }

    public static void bfs(boolean[][] passed, int startYX[], int N, int h) {

        passed[startYX[0]][startYX[1]] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(startYX);

        while (!q.isEmpty()) {

            int[] nextYX = q.poll();

            for (int i = 0; i < 4; i++) {

                int ny = nextYX[0] - ys[i];
                int nx = nextYX[1] - xs[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) {
                    continue;
                }

                if (passed[ny][nx]) {
                    continue;
                }

                passed[ny][nx] = true;
                int[] nYX = { ny, nx };
                q.offer(nYX);
            }
        }
    }

    public static void show(boolean[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}