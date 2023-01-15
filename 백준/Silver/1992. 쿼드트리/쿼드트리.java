import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static String solve(int N, int[][] map) {
    // 1. 4분할시키기
    // 2. 각 분할된 곳에서 1과, 0으로만 되어있는지 체킹
    // 3. 아니라면 다시 4분할

    // 2사분면(0,  0) ~ (2/n, 2/n)
    // 1사분면 (0, 2/n) ~ (2/n, n)
    // 3사분면 (2/n, 0) ~ (n, 2/n)
    // 4사분면 ( 2/n, 2/n) ~ (n, n)

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
    if (flag) return tmp + "";

    int[][] quadrants = {
      { 0, 0, N / 2, N / 2 }, // (y1, x1) (y2, x2)
      { 0, N / 2, N / 2, N },
      { N / 2, 0, N, N / 2 },
      { N / 2, N / 2, N, N },
    };

    String result = "(";
    int[][] newMap = new int[N / 2][N / 2];
    for (int[] quadrant : quadrants) {
      // isPerpect = true;
      int startY = quadrant[0];
      int startX = quadrant[1];
      int endY = quadrant[2];
      int endX = quadrant[3];

      // 사분면 잘라내기
      int idxNewMapI = 0;
      int idxNewMapJ;
      for (int i = startY; i < endY; i++) {
        idxNewMapJ = 0;
        for (int j = startX; j < endX; j++) {
          newMap[idxNewMapI][idxNewMapJ] = map[i][j];
          idxNewMapJ++;
        }
        idxNewMapI++;
      }

      // 해당 영역이 통일되어있는지 확인
      int startNum = newMap[0][0];
      // System.out.println(startNum);
      boolean isAllSame = confirmIsAllSame(newMap, startNum);
      if (isAllSame) {
        result += startNum;
      } else {
        result += solve(N / 2, newMap);
      }
    }

    return result + ")";
  }

  public static boolean confirmIsAllSame(int[][] map, int startNum) {
    for (int[] ny : map) {
      for (int y : ny) {
        if (startNum != y) return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[][] map = new int[N][N];

    String str;
    for (int i = 0; i < N; i++) {
      str = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = str.charAt(j) - '0';
      }
    }

    String answer = solve(N, map);
    System.out.println(answer);
  }
}
