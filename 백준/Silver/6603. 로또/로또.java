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

  static int k;
  static int[] arr;
  static boolean[] isPassed;

  static void combi(int pIdx, int sIdx, int[] selected) {
    // System.out.println(pIdx + " " + sIdx + " ");

    if (sIdx == 6) {
      for (int i = 0; i < 6; i++) {
        System.out.print(selected[i] + " ");
      }
      //System.out.println(Arrays.toString(selected));
      System.out.println("");

      return;
    }
    if (pIdx == k) {
      return;
    }

    // 선택함
    selected[sIdx] = arr[pIdx];
    combi(pIdx + 1, sIdx + 1, selected);
    combi(pIdx + 1, sIdx, selected);
    // 안 선택함
  }

  public static void main(String[] args) throws IOException {
    while (true) {
      st = new StringTokenizer(br.readLine());

      k = Integer.parseInt(st.nextToken());
      if (k == 0) {
        break;
      }

      arr = new int[k];
      isPassed = new boolean[k];

      for (int i = 0; i < k; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      // k C 6 구하기
      int selected[] = new int[6];
      combi(0, 0, selected);
      System.out.println("");
    }
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
