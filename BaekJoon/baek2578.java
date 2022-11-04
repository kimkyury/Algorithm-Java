import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

  static int[][] map = new int[5][5];
  static int[][] isPassed = new int[5][5];
  static boolean isBingo = false;

  public static void marking(int n) {
    // n의 위치 찾기
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (map[i][j] == n) {
          isPassed[i][j] = 1;
        }
      }
    }
  }

  public static void countLine() {
    int cntBingo = 0;

    // 가로, 세로, 대각선 세기
    int diagonalCnt1 = 0;
    int diagonalCnt2 = 0;
    for (int i = 0; i < 5; i++) {
      int rowCnt = 0;
      int colCnt = 0;

      for (int j = 0; j < 5; j++) {
        if (isPassed[i][j] == 1) rowCnt++;
        if (isPassed[j][i] == 1) colCnt++;
      }
      if (isPassed[i][i] == 1) diagonalCnt1++;
      if (isPassed[4 - i][i] == 1) diagonalCnt2++;
      if (rowCnt == 5) cntBingo++;
      if (colCnt == 5) cntBingo++;
    }

    if (diagonalCnt1 == 5) cntBingo++;
    if (diagonalCnt2 == 5) cntBingo++;

    if (cntBingo >= 3) {
      isBingo = true;
    }
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int cnt = 0;
    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        marking(Integer.parseInt(st.nextToken()));
        cnt++;
        if (cnt > 10) countLine();
        if (isBingo) {
          System.out.println(cnt);
          return;
        }
      }
    }
  }
}
