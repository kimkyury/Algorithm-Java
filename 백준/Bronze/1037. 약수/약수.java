import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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

  public static void main(String[] args) throws IOException {
    // N은 A의 배수여야 함
    // A는 1과 N이 아니여야 함

    // 약수들이 주어질 때, N을 구할 것

    int N = Integer.parseInt(br.readLine());
    // max 50개
    int[] nums = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(nums);

    System.out.println(nums[0] * nums[N - 1]);
    // 첫수와 마지막 수의 곱이 N이 됨

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
