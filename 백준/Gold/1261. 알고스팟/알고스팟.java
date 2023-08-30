import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static StringTokenizer st;
  static int[][] map;
  static int[][] brokenBrickInfo;
  static int N, M;
  static int cnt;
  static int answer;

  static int dy[] = { 0, 1, 0, -1 };
  static int dx[] = { 1, 0, -1, 0 };

  public static void bfs() {
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
      return o1[2] - o2[2];
    });

    int[] initPos = { 1, 1, 0 };
    brokenBrickInfo[1][1] = 0;

    for (int i = 0; i < 4; i++) {
      int ny = initPos[0] + dy[i];
      int nx = initPos[1] + dx[i];

      if (ny == N - 1 && nx == M - 1) {
        answer = 0;
        return;
      }

      if (ny < 1 || nx < 1 || ny > N - 1 || nx > M - 1) continue;

      if (map[ny][nx] == 0) {
        brokenBrickInfo[ny][nx] = 0;
      } else {
        brokenBrickInfo[ny][nx] = 1;
      }

      int[] nextPos = { ny, nx, brokenBrickInfo[ny][nx] };
      pq.offer(nextPos);
    }

    int ny, nx;
    while (!pq.isEmpty()) {
      int size = pq.size();
      for (int i = 0; i < size; i++) {
        int[] curPos = pq.poll();

        for (int j = 0; j < 4; j++) {
          ny = curPos[0] + dy[j];
          nx = curPos[1] + dx[j];

          if (ny == N - 1 && nx == M - 1) {

            answer = brokenBrickInfo[curPos[0]][curPos[1]];
            return;
          }

          if (ny < 1 || nx < 1 || ny > N - 1 || nx > M - 1) continue;
          if (brokenBrickInfo[ny][nx] != -1) continue;
          if (map[ny][nx] == 0) {
            brokenBrickInfo[ny][nx] = brokenBrickInfo[curPos[0]][curPos[1]];
          } else {
            brokenBrickInfo[ny][nx] = brokenBrickInfo[curPos[0]][curPos[1]] + 1;
          }

          // System.out.println(
          //   "(y: " +
          //   ny +
          //   ", x: " +
          //   nx +
          //   "), this Broken Cnt: " +
          //   brokenBrickInfo[ny][nx]
          // );

          int[] nextPos = { ny, nx, brokenBrickInfo[ny][nx] };
          pq.offer(nextPos);
        }
        // show(brokenBrickInfo);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    // 빈 방, 벽으로 이루어짐
    // (1,1에서 N,M)까지 이동하기 위하여 벽을 최소 몇 개 부수어야 하는가?
    st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken()) + 1;
    N = Integer.parseInt(st.nextToken()) + 1;

    map = new int[N][M];
    brokenBrickInfo = new int[N][M];
    cnt = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        brokenBrickInfo[i][j] = -1;
      }
    }

    char[] line;
    for (int i = 1; i < N; i++) {
      line = br.readLine().toCharArray();
      for (int j = 1; j < M; j++) {
        map[i][j] = line[j - 1] - '0';
      }
    }

    bfs();

    bw.write(String.valueOf(answer));
    bw.flush();
  }

  static void show(int[][] arr) {
    System.out.println("------------");

    for (int i = 0; i < arr.length; i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
  }

  static void show(boolean[][] arr) {
    System.out.println("------------");
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j]) System.out.print("1"); else System.out.print("0");
      }
      System.out.println("");
    }
  }
}
