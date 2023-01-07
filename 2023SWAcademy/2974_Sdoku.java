import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {

  public static int solve(int[][] arr) {
    int[] number = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    HashSet<Integer> hsRow;
    HashSet<Integer> hsCol;
    for (int i = 0; i < 9; i++) {
      hsRow = new HashSet<Integer>();
      hsCol = new HashSet<Integer>();

      for (int j = 0; j < 9; j++) {
        int num1 = arr[i][j];
        int num2 = arr[j][i];

        hsRow.add(num1);
        hsCol.add(num2);
      }

      if (hsRow.size() != 9 || hsCol.size() != 9) {
        return 0;
      }
    }

    int[] startPointIndex = { 0, 3, 6 };
    for (int index : startPointIndex) {
      HashSet<Integer> hsSqure = new HashSet<Integer>();
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          hsSqure.add(arr[index + i][index + j]);
        }
      }

      if (hsSqure.size() != 9) {
        return 0;
      }
    }

    return 1;
  }

  public static void showArr() {}

  public static void main(String args[]) throws Exception {
    System.setIn(new FileInputStream("res/input.txt"));

    Scanner sc = new Scanner(System.in);
    int T;
    T = Integer.parseInt(sc.nextLine());

    for (int test_case = 1; test_case <= T; test_case++) {
      // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      // NxN 행렬이 주어질 때, 90 180 280 회전한 모양 출력하기

      int[][] arr = new int[9][9];

      for (int i = 0; i < 9; i++) {
        st = new StringTokenizer(sc.nextLine());
        for (int j = 0; j < 9; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int answer = solve(arr);
      System.out.println("#" + test_case + " " + answer);
    }
  }
}
