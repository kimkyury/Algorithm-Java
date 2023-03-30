import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import javax.lang.model.util.ElementScanner6;

public class Main {

  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int map[][];
  static int N, M, K;
  static int cnt = 0;

  static int row[][];
  static int col[][];
  static int rec[][];
  static boolean flag;

  static int min = Integer.MAX_VALUE;

  public static int distinctRec(int i, int j) {
    // int zone = -1;
    // if (i < 3) {
    //   if (j < 3) return 0; else if (j < 6) return 1; else return 2;
    // } else if (i < 6) {
    //   if (j < 3) return 3; else if (j < 6) return 4; else return 5;
    // } else {
    //   if (j < 3) return 6; else if (j < 6) return 7; else return 8;
    // }
    return (j / 3) * 3 + (i / 3);
  }

  public static void show(int[][] arr) {
    for (int[] ar : arr) {
      for (int a : ar) sb.append(a);
      sb.append("\n");
    }
  }

  // 스도쿠의 각 자리를 num으로 지정, 1~81까지
  public static boolean fillSdoku(int cnt) {
    // if (flag) return;

    if (cnt == 81) {
      show(map);
      //   flag = true;
      return true;
    }

    int y = cnt / 9; // row
    int x = cnt % 9; // col

    // 채울 필요 없으니까 skip
    if (map[y][x] != 0) {
      return fillSdoku(cnt + 1);
    }

    // 해당 [y][x] 자리에 어울리는 숫자를, 가장 작은 것부터 집어넣기
    for (int i = 1; i <= 9; i++) {
      if (row[y][i] == 0 && col[x][i] == 0 && rec[distinctRec(y, x)][i] == 0) {
        // 가능한 경우라면 일단 집어넣음
        map[y][x] = i;
        // 방문체크
        row[y][i] = 1;
        col[x][i] = 1;
        rec[distinctRec(y, x)][i] = 1;

        // 다음 자릿수 채우기로 넘기기
        // 다음 번의 이동이 가능한 거라면 다음 수를 채우려고 하지 말 것.
        if (fillSdoku(cnt + 1)) return true;

        // 원상복구, 왜냐면 앞에 했던 게 나중에 숫자 중복나서 헛수고가 될 수 있그든.
        map[y][x] = 0;
        row[y][i] = 0;
        col[x][i] = 0;
        rec[distinctRec(y, x)][i] = 0;
      }
    }

    return false;
  }

  public static void main(String[] args) throws IOException {
    map = new int[9][9];

    String str;
    for (int i = 0; i < 9; i++) {
      str = br.readLine();
      for (int j = 0; j < 9; j++) {
        map[i][j] = str.charAt(j) - '0';
      }
    }

    // [rowNo][possibleNum]
    row = new int[9][10];
    // [colNo][possibleNum]
    col = new int[9][10];
    // [recNo][possibleNum] 3x3 각 구역들
    rec = new int[9][10];

    // 각 사각영영의 범위 :
    // [0~2][0~2] -> 0, [0~2][3~5] -> 1,  [0~2][6~8] -> 2
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int value = map[i][j];
        if (value != 0) {
          // 3x3에 대해서
          rec[distinctRec(i, j)][value] = 1;
          // 한 행에 대해서
          row[i][value] = 1;
          // 한 열에 대해서
          col[j][value] = 1;
        }
      }
    }

    fillSdoku(0);

    // show(map);
    bw.write(sb.toString());
    bw.flush();
  }
}
