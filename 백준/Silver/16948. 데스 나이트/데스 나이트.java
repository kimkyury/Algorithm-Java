
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int[] xs = { -1, 1, -2, 2, -1, 1 };
    private static int[] ys = { -2, -2, 0, 0, 2, 2 };
    private static boolean[][] isPassed;

    public static void main(String[] args) throws IOException {

        // 대각선, 앞 뒤
        // r1, c1 -> r2, c1

        int N = Integer.parseInt(br.readLine());
        isPassed = new boolean[N][N];
        st = new StringTokenizer(br.readLine());

        int[] sPos = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        int[] ePos = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

        bw.write(String.valueOf(bfs(sPos, ePos, N)));
        bw.flush();
    }

    public static int bfs(int[] sPos, int[] ePos, int N) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(sPos);
        int moveCnt = 0;

        while (!q.isEmpty()) {

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] curPos = q.poll();
                if (curPos[0] == ePos[0] && curPos[1] == ePos[1]) {
                    return moveCnt;
                }

                for (int j = 0; j < 6; j++) {
                    int ny = curPos[0] + ys[j];
                    int nx = curPos[1] + xs[j];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                        continue;
                    }

                    if (isPassed[ny][nx]) {
                        continue;
                    }

                    isPassed[ny][nx] = true;
                    int[] nPos = { ny, nx };
                    q.offer(nPos);
                }
            }
            moveCnt++;
        }

        return -1;
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