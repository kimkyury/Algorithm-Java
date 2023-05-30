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

  static long[] divisorSub;
  static int MAX_INPUT = 1000001;

  public static void main(String[] args) throws IOException {
    divisorSub = new long[MAX_INPUT];

    for (int i = 1; i < MAX_INPUT; i++) {
      // 각 수(i)의 등장횟수만큼 약수의 값 더하기, i의 배수 모두를 체크함 (그 수를 가지고 있을 x에 대하여 누적합이 갱신되는 것)
      for (int j = 1; i * j < MAX_INPUT; j++) { //
        divisorSub[i * j] += i; // 최초idx: 1, 2, 3, 4, 5 ... (모두 1) , 다음: 2, 4, 6, 8... (2의 배수들은 +=2) 그 다음: 3, 6, 9, 12 ....(3의 배수들은 +=3)
      }
      divisorSub[i] += divisorSub[i - 1];
    }

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      int x = Integer.parseInt(br.readLine());

      bw.write(String.valueOf(divisorSub[x]) + "\n");
    }
    bw.flush();
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
