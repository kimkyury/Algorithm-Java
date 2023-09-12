import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static StringTokenizer st;
  static int N;

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    int[][] arr = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int cnt = 0;
    int limitJ = Math.min(N, M) / 2;

    while (true) {
      int j = 0;
      if (cnt == R) break;

      while (j != limitJ) {
        int temp = arr[j][j];
        for (int i = j; i < M - 1 - j; i++) {
          arr[j][i] = arr[j][i + 1];
        }

        for (int i = j; i < N - 1 - j; i++) {
          arr[i][M - 1 - j] = arr[i + 1][M - 1 - j];
        }

        for (int i = j; i < M - 1 - j; i++) {
          arr[N - 1 - j][M - 1 - i] = arr[N - 1 - j][M - 1 - (i + 1)];
        }

        for (int i = j; i < N - 1 - j; i++) {
          arr[N - 1 - i][j] = arr[N - 1 - (i + 1)][j];
        }
        arr[j + 1][j] = temp;

        j++;
      }
      // System.out.println("------------");
      // show(arr);
      cnt++;
    }

    StringBuilder sb = new StringBuilder();
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < M; c++) sb.append(arr[r][c] + " ");
      sb.append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  static void show(int[][] arr) {
    System.out.println("------------");

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println("");
    }
  }

  static void show(boolean[][] arr) {
    System.out.println("——————");
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j]) System.out.println("F "); else System.out.println("T ");
        System.out.println("");
      }
    }
  }
}
