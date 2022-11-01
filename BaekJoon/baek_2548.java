import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {

  int x;
  int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Main {

  static int N, M, K;
  static int[][] map;
  static int[] xs = { 1, 0, -1, 0 };
  static int[] ys = { 0, 1, 0, -1 };

  public static int solution(int y, int x) {
    Queue<Point> q = new LinkedList<>();
    q.offer(new Point(x, y));
    int size = 1;

    while (!q.isEmpty()) {
      Point p = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = p.x + xs[i];
        int ny = p.y + ys[i];

        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
          if (map[ny][nx] == 0) {
            q.offer(new Point(nx, ny));
            map[ny][nx] = 1;
            size++;
          }
        }
      }
    }

    return size;
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken()); //y축의 길이
    N = Integer.parseInt(st.nextToken()); // x축의 길이
    K = Integer.parseInt(st.nextToken());
    map = new int[M][N]; // int[5][7]
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()); // 좌측하단 x
      int y = Integer.parseInt(st.nextToken()); // 좌측하단 y
      int x2 = Integer.parseInt(st.nextToken()); // 우측상단 x
      int y2 = Integer.parseInt(st.nextToken()); // 우측상단 y

      for (int ny = y; ny < y2; ny++) {
        for (int nx = x; nx < x2; nx++) {
          map[ny][nx] = 1;
        }
      }
    }

    ArrayList<Integer> size = new ArrayList<>();
    int cnt = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 0) {
          map[i][j] = 1;
          size.add(solution(i, j));
          cnt++;
        }
      }
    }

    Collections.sort(size);

    System.out.println(cnt);
    for (int i = 0; i < cnt; i++) {
      System.out.print(size.get(i) + " ");
    }
    // //printInfo
    // for (int i = 0; i < M; i++) {
    //   for (int j = 0; j < N; j++) {
    //     System.out.print(map[i][j]);
    //   }
    //   System.out.println();
    // }

    // int answer = main.solution(N);

  }
}
