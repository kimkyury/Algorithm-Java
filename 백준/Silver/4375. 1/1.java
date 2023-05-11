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

  public static void main(String[] args) throws IOException {
    while (true) {
      int recurCnt = 1;
      String input = br.readLine();
      if (input == null) {
        break;
      }

      int num = Integer.parseInt(input);

      if (num == 1) {
        System.out.println(recurCnt);
        continue;
      }

      int oneNum = 1;
      while (true) {
        if (oneNum == 0) {
          System.out.println(recurCnt);
          break;
        }
        oneNum = (oneNum * 10 + 1) % num;
        recurCnt++;
      }
      // 각 자릿수가 모두 1로만 이루어진 n의 배수
      // 3 -> 111
      // 7 -> 111111

      // 2와 5로 나누어 떨어지지 않는 정수임
      // 홀수이면서 끝자리수가 5, 0을 반복하지 않음

      // 3 -> 3 6 9 12 15 18 21
      // 7 -> 7 14 21

    }
  }

  // for Problem

  // ----------for log
  static void show(char[][] arr) {
    for (char[] ar : arr) {
      System.out.println(Arrays.toString(ar));
    }
  }
}
