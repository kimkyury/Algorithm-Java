
import java.io.*;
import java.util.*;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  private static StringBuilder sb;
  private static int R, C, cntX;
  private static char[][] map, newMap;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {

    st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    /*
     * // 1. 지도를 입력받는다
     * // 2. 완탐하며 해당 좌표의 주위가 3개 이상 '.' 이면 해당 좌표를 '.'으로 만든다
     * // --> 이때, 남은 'X'가 한 개인 경우 종료하고 X만 출력한다
     * // 3. 마지막으로, (0,0) 에서 최초의 'X'를 참고, (R, C)에서 최초 'x'를 찾는다
     * // 4. 3번의 좌표 사이의 직사각형을 출력한다
     */

    map = new char[R][C];
    newMap = new char[R][C];

    for (int i = 0; i < R; i++) {
      String line = br.readLine();
      map[i] = line.toCharArray();
    }

    search();

    if (cntX == 0) {
      bw.write("X");
      bw.flush();
      return;
    }

    int minRow = R;
    int maxRow = -1;
    int minCol = C;
    int maxCol = -1;

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (newMap[i][j] == 'X') {
          minRow = Math.min(minRow, i);
          maxRow = Math.max(maxRow, i);
          minCol = Math.min(minCol, j);
          maxCol = Math.max(maxCol, j);
        }
      }
    }

    sb = new StringBuilder();

    for (int i = minRow; i <= maxRow; i++) {
      for (int j = minCol; j <= maxCol; j++) {
        sb.append(newMap[i][j]);
      }
      if (i < maxRow) {
        sb.append('\n');
      }
    }

    bw.write(sb.toString());
    bw.flush();
  }

  public static void search() {

    int[] dy = { 0, 1, 0, -1 };
    int[] dx = { 1, 0, -1, 0 };

    for (int i = 0; i < R; i++) {
      Arrays.fill(newMap[i], '.');
    }

    cntX = 0;

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {

        if (map[i][j] == '.') {
          continue;
        }

        int cnt = 0;
        for (int k = 0; k < 4; k++) {
          int ny = i + dy[k];
          int nx = j + dx[k];

          if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == '.') {
            cnt++;
          }
        }

        if (cnt < 3) {
          newMap[i][j] = 'X';
          cntX++;
        }

      }
    }
  }
}
