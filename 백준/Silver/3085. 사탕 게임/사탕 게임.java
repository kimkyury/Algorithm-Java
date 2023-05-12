import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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

  static int N;
  static char map[][];
  static int maxLen = 0;

  static void switchMap(int y1, int x1, int y2, int x2) {
    char tmp = map[y1][x1];
    map[y1][x1] = map[y2][x2];
    map[y2][x2] = tmp;
  }

  static void searchMaxLen() {
    // 2-1. 행으로 확인
    int len = 1;
    boolean flag;
    for (int i = 0; i < N; i++) {
      flag = false;
      len = 1;

      for (int j = 0; j < N - 1; j++) {
        if (map[i][j] == map[i][j + 1]) {
          len++;
          flag = true;
        } else {
          if (!flag) continue; else break;
        }
      }
      maxLen = Math.max(maxLen, len);
    }

    for (int i = 0; i < N; i++) {
      flag = false;
      len = 1;

      for (int j = 0; j < N - 1; j++) {
        if (map[j][i] == map[j + 1][i]) {
          len++;
          flag = true;
        } else {
          if (!flag) continue; else break;
        }
      }
      maxLen = Math.max(maxLen, len);
    }
  }

  public static void main(String[] args) throws IOException {
    // 1. nxn에서 인접한 두 좌표를 고른다
    N = Integer.parseInt(br.readLine());
    map = new char[N][N];

    for (int i = 0; i < N; i++) {
      char[] str = br.readLine().toCharArray();
      for (int j = 0; j < N; j++) {
        map[i][j] = str[j];
      }
    }

    // 1-1. 인접한 두 좌표가 서로 다른 표기를 갖고 있다면 교환시킨다
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N - 1; j++) {
        if (map[i][j] != map[i][j + 1]) {
          switchMap(i, j, i, j + 1);
          // show(map);
          // 2. 바뀐 맵에서, 같은 색으로 이루어져 있는 가장 긴 연속 부분을 찾는다
          searchMaxLen();
          switchMap(i, j, i, j + 1);
        }

        if (map[j][i] != map[j + 1][i]) {
          switchMap(j, i, j + 1, i);

          searchMaxLen();

          switchMap(j, i, j + 1, i);
        }
      }
    }

    System.out.println(maxLen);
  }

  // for Problem

  // ----------for log
  static void show(char[][] arr) {
    System.out.println("----------------");
    for (char[] ar : arr) {
      System.out.println(Arrays.toString(ar));
    }
  }
}
