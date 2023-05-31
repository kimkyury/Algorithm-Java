import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    int answer = 0;

    // 1. 주어진 N의 길이 세기
    int num = Integer.parseInt(br.readLine());
    int numForRecur = num;
    int len = 1;

    int totalCnt = 0;
    while (numForRecur >= 10) {
      // len 2일 때, 한자리수가 9개는 보장되어있음을 반영
      // len 3일 때, 두자리수가 90개는 보장되어있음을 반영
      totalCnt += len * (Math.pow(10, len) - Math.pow(10, len - 1));

      len++;
      numForRecur /= 10;
    }
    // System.out.println("length: " + len);
    // System.out.println("totalCnt: " + totalCnt);

    totalCnt += (num - Math.pow(10, len - 1) + 1) * len;

    bw.write(String.valueOf(totalCnt));
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
