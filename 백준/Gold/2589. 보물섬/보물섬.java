import java.io.*;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static StringBuilder sb;

    private static char[][] map;
    private static int N, M;
    private static int maxShortTime = Integer.MIN_VALUE;

    private static int[] dy = { 0, 1, 0, -1 };
    private static int[] dx = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {

        // 지도 입력받으면서 L 위치 저장
        // L1 -> L2 가는 최단거리 중, 최대값 구하기
        // L1 -> L2에 대해 BFS, 그 사이에 가는 길(L1 -> L')도 표시해줄 것
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        List<int[]> posL = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'L') {
                    int[] pos = { i, j };
                    posL.add(pos);
                }
            }
        }
        // 최악의 경우: 250!
        for (int i = 0; i < posL.size() - 1; i++) {
            int[] src = posL.get(i);

            boolean[][] passed = new boolean[N][M];
            passed[src[0]][src[1]] = true;
            maxShortTime = Math.max(maxShortTime, bfs(src, passed));
        }
        // System.out.println("SRC: " + Arrays.toString(src) + ", DEST: " +
        // Arrays.toString(dest) + ", RESULT: " + time);

        bw.write(maxShortTime + "\n");
        bw.flush();

    }

    public static int bfs(int[] src, boolean[][] passed) {

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(src);
        int time = -1;
        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] pos = q.poll();

                for (int j = 0; j < 4; j++) {

                    int[] nPos = { pos[0] + dy[j], pos[1] + dx[j] };

                    if (nPos[0] < 0 || nPos[1] < 0 || nPos[0] > N - 1 || nPos[1] > M - 1) {
                        continue;
                    }

                    if (passed[nPos[0]][nPos[1]]) {
                        continue;
                    }

                    if (map[nPos[0]][nPos[1]] == 'W') {
                        continue;
                    }

                    passed[nPos[0]][nPos[1]] = true;
                    q.offer(nPos);
                }
            }
            time++;
        }

        // 종착점에 도달 불가
        return time;
    }

    public static void show(boolean[][] arr) {
        System.out.println("------------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                if (arr[i][j]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println("");
        }
    }
}