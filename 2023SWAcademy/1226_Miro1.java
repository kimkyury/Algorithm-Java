import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Point {

  int x;
  int y;

  Point(int y, int x) {
    this.x = x;
    this.y = y;
  }
}

class Solution {

  static int map[][];
  static int[] nx = { 1, 0, -1, 0 };
  static int[] ny = { 0, -1, 0, 1 };

  public static int solve(int startY, int startX, int endY, int endX) {
    // (y, x)에서부터 이동하기
    Point startP = new Point(startY, startX);
    Queue<Point> q = new LinkedList<>();
    q.offer(startP);

    while (!q.isEmpty()) {
      Point curP = q.poll();
      // System.out.println("current: " + curP.y + ", " + curP.x);
      if (curP.x == endX && curP.y == endY) {
        return 1;
      }
      for (int i = 0; i < 4; i++) {
        Point nextP = new Point(curP.y + ny[i], curP.x + nx[i]);
        if (map[nextP.y][nextP.x] != 1) {
          map[nextP.y][nextP.x] = 1;
          q.offer(nextP);
        }
      }
    }

    return 0;
  }

  public static void main(String args[]) throws Exception {
    System.setIn(new FileInputStream("res/input.txt"));

    Scanner sc = new Scanner(System.in);
    int T = 10;
    // T = Integer.parseInt(sc.nextLine());

    for (int test_case = 1; test_case <= T; test_case++) {
      // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(sc.nextLine());
      map = new int[16][16];
      int startX = 0, startY = 0, endX = 0, endY = 0;

      for (int i = 0; i < 16; i++) {
        String rowNum = sc.nextLine();
        for (int j = 0; j < 16; j++) {
          int n = rowNum.toCharArray()[j] - '0';
          if (n == 2) {
            startX = j; // int[i][j] == int [y][x]
            startY = i;
          } else if (n == 3) {
            endX = j;
            endY = i;
          }
          map[i][j] = n;
        }
      }

      int answer = solve(startY, startX, endY, endX);
      System.out.println("#" + test_case + " " + answer);
    }
  }
}
