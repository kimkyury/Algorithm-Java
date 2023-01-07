import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {

  public static int solve(int[] arr1, int[] arr2) {
    int shortArray[];
    int longArray[];

    // 얇은 복사
    if (arr1.length > arr2.length) {
      shortArray = arr2;
      longArray = arr1;
    } else {
      shortArray = arr1;
      longArray = arr2;
    }

    // showArray(shortArray);
    // showArray(longArray);

    int shortLen = shortArray.length;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i <= longArray.length - shortLen; i++) {
      int sum = 0;
      for (int j = 0; j < shortLen; j++) {
        sum += shortArray[j] * longArray[i + j]; // 0, 0
      }
      // System.out.println("confirm: " + sum);

      max = Math.max(max, sum);
    }
    return max;
  }

  public static void showArray(int[] arr) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println("");
  }

  public static void main(String args[]) throws Exception {
    System.setIn(new FileInputStream("res/input.txt"));

    Scanner sc = new Scanner(System.in);
    int T;
    T = Integer.parseInt(sc.nextLine());

    for (int test_case = 1; test_case <= T; test_case++) {
      // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(sc.nextLine());

      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      int[] arr1 = new int[n];
      int[] arr2 = new int[m];

      st = new StringTokenizer(sc.nextLine());
      for (int i = 0; i < n; i++) arr1[i] = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(sc.nextLine());
      for (int i = 0; i < m; i++) arr2[i] = Integer.parseInt(st.nextToken());

      int max = solve(arr1, arr2);

      System.out.println("#" + test_case + " " + max);
    }
  }
}
