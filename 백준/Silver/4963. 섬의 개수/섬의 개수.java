import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {

  int y;
  int x;

  Point(int y, int x) {
    this.y = y;
    this.x = x;
  }
}

public class Main {

  static int w;
  static int h;
  static int cnt;
  static int[][] map;
  static int[][] isPassed;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );
  static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
  static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };

  public static void solve(int y, int x) {
    Queue<Point> q = new LinkedList<>();
    Point startP = new Point(y, x);
    q.offer(startP);

    Point tmp;
    while (!q.isEmpty()) {
      tmp = q.poll();
      for (int i = 0; i < 8; i++) {
        int ny = tmp.y + dy[i];
        int nx = tmp.x + dx[i];

        if (ny < 0 || nx < 0 || ny >= h || nx >= w) continue;

        if (map[ny][nx] == 1 && isPassed[ny][nx] == 0) {
          isPassed[ny][nx] = 1;
          q.offer(new Point(ny, nx));
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    w = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    while (true) {
      cnt = 0;
      map = new int[h][w];
      isPassed = new int[h][w];

      if (w == 0 && h == 0) break;
      for (int i = 0; i < h; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < w; j++) map[i][j] =
          Integer.parseInt(st.nextToken());
      }

      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (map[i][j] == 1 && isPassed[i][j] == 0) {
            solve(i, j);
            cnt++;
          }
        }
      }

      bw.write(String.valueOf(cnt) + "\n");
      st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());
    }

    bw.flush();
    // for (int answer : answers) System.out.println(answer);
  }
}
