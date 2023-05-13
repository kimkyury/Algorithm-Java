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

  static int N, S;
  static int[] arr;
  static int cnt = 0;

  static boolean confirmSum(int[] arr, int len) {
    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum += arr[i];
    }

    // System.out.println(sum);
    if (sum != S || len == 0) return false;
    return true;
  }

  static void subSet(int pIdx, int sIdx, int[] selected) {
    if (pIdx == N) {
      // System.out.println(Arrays.toString(selected));
      if (confirmSum(selected, sIdx)) {
        cnt++;
      }
      return;
    }

    selected[sIdx] = arr[pIdx];
    subSet(pIdx + 1, sIdx + 1, selected);
    subSet(pIdx + 1, sIdx, selected);
  }

  public static void main(String[] args) throws IOException {
    // N개의 정수로 이루어진 수열
    // 양수인 부분수열에서, 그 수열의 원소를 다 더하면 S가 되는 경우

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int[] selected = new int[N];
    subSet(0, 0, selected);
    // 해당 수열에서 조합을 만든다
    // 해당 조합의 총 합이 S된다면 cnt++시킨다

    System.out.println(cnt);
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
