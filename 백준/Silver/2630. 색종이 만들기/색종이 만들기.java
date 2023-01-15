import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static int[] solve(int N, int[][] map) {
    int cnt[] = new int[2]; // 0:white, 1:Blue

    boolean flag = true;
    int tmp = map[0][0];
    for (int[] row : map) {
      for (int num : row) {
        if (tmp != num) {
          flag = false;
          break;
        }
      }
      if (!flag) break;
    }
    if (flag) {
      if (tmp == 0) cnt[0]++; else if (tmp == 1) cnt[1]++;
      return cnt;
    }

    // (y1, x1) (y2, x2)
    int[][] quadrants = {
      { 0, 0, N / 2, N / 2 },
      { 0, N / 2, N / 2, N },
      { N / 2, 0, N, N / 2 },
      { N / 2, N / 2, N, N },
    };

    int[][] newMap = new int[N / 2][N / 2];

    for (int[] quadrant : quadrants) {
      int startY = quadrant[0];
      int startX = quadrant[1];
      int endY = quadrant[2];
      int endX = quadrant[3];

      //cutting to 4-Quadrnat
      int newMapI = 0;
      int newMapJ;
      for (int i = startY; i < endY; i++) {
        newMapJ = 0;
        for (int j = startX; j < endX; j++) {
          newMap[newMapI][newMapJ++] = map[i][j];
        }
        newMapI++;
      }

      int[] result = solve(N / 2, newMap);
      cnt[0] += result[0];
      cnt[1] += result[1];
    }
    return cnt;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int map[][] = new int[N][N];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
    }

    int[] answers = new int[2];
    answers = solve(N, map);

    for (int answer : answers) System.out.println(answer);
  }
}
