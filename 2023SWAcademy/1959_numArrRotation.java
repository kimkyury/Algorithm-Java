import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {

  public static void solve(int[][] arr, int n) {
    int[][] arr90 = new int[n][n];
    int[][] arr180 = new int[n][n];
    int[][] arr270 = new int[n][n];

    for (int i = 0; i < n; i++) {
      int row[] = new int[n];
      for (int j = 0; j < n; j++) {
        row[j] = arr[i][j];
        arr90[j][n - 1 - i] = row[j];
        arr180[n - 1 - i][n - 1 - j] = row[j];
        arr270[n - 1 - j][i] = row[j];
      }
    }

    showArr(arr90, arr180, arr270, n);
  }

  public static void showArr(
    int[][] arr90,
    int[][] arr180,
    int[][] arr270,
    int n
  ) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) System.out.print(arr90[i][j]);
      System.out.print(" ");
      for (int j = 0; j < n; j++) System.out.print(arr180[i][j]);
      System.out.print(" ");
      for (int j = 0; j < n; j++) System.out.print(arr270[i][j]);
      System.out.println("");
    }
  }

  public static void main(String args[]) throws Exception {
    System.setIn(new FileInputStream("res/input.txt"));

    Scanner sc = new Scanner(System.in);
    int T;
    T = Integer.parseInt(sc.nextLine());

    for (int test_case = 1; test_case <= T; test_case++) {
      // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(sc.nextLine());
      // NxN 행렬이 주어질 때, 90 180 280 회전한 모양 출력하기

      int n = Integer.parseInt(st.nextToken());
      int arr[][] = new int[n][n];
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(sc.nextLine());
        for (int j = 0; j < n; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      System.out.println("#" + test_case + " ");
      solve(arr, n);
    }
  }
}
