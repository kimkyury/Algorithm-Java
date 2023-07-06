import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int N, M;
  static int size;
  static int[][] arr;
  static boolean[][] isPassed;
  static int len = 0;

  static int[] dy = { -1, 0, 1, 0 };
  static int[] dx = { 0, 1, 0, -1 };

  static void bfs(int y, int x) {
    Queue<int[]> dq = new ArrayDeque<>();
    len++;
    isPassed[y][x] = true;

    for (int i = 0; i < 4; i++) {
      int newY = y + dy[i];
      int newX = x + dx[i];

      if (newY < 0 || newX < 0 || newY > N - 1 || newX > M - 1) continue;
      if (arr[newY][newX] == 0) continue;

      isPassed[newY][newX] = true;
      int[] newYX = { newY, newX };
      dq.offer(newYX);
    }

    while (!dq.isEmpty()) {
      len++;

      int size = dq.size();
      // System.out.println("-------------");
      // show(isPassed);
      for (int i = 0; i < size; i++) {
        int[] curYX = dq.poll();

        for (int j = 0; j < 4; j++) {
          int newY = curYX[0] + dy[j];
          int newX = curYX[1] + dx[j];

          if (newY < 0 || newX < 0 || newY > N - 1 || newX > M - 1) continue;
          if (arr[newY][newX] == 0) continue;
          if (isPassed[newY][newX]) continue;

          isPassed[newY][newX] = true;

          if (newY == N - 1 && newX == M - 1) {
            len++;
            return;
          }
          int[] newYX = { newY, newX };
          dq.offer(newYX);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    isPassed = new boolean[N][M];
    arr = new int[N][M];
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        arr[i][j] = str.charAt(j) - '0';
      }
    }
    // show(arr);

    bfs(0, 0);

    bw.write(String.valueOf(len));
    bw.flush();
  }

  static void show(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
  }

  static void show(boolean[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j]) System.out.print("1"); else System.out.print("0");
      }
      System.out.println("");
    }
  }
}
