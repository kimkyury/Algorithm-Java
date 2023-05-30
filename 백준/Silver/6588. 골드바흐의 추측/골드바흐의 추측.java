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

  static boolean isNotPrimeNum[];
  static int MAX_NUM = 1000000;
  static List<Integer> primeList;

  public static void main(String[] args) throws IOException {
    isNotPrimeNum = new boolean[MAX_NUM + 1];
    primeList = new ArrayList<>();

    // 1. 소수를 list에 담아놓을 것

    isNotPrimeNum[0] = isNotPrimeNum[1] = true;
    for (int i = 2; i * i <= MAX_NUM; i++) {
      if (!isNotPrimeNum[i]) {
        for (int j = 2; j * i <= MAX_NUM; j++) {
          isNotPrimeNum[j * i] = true;
        }
      }
    }

    for (int i = 3; i <= MAX_NUM; i++) {
      if (!isNotPrimeNum[i]) {
        primeList.add(i);
      }
    }

    // 2. 입력 케이스마다 소수의 합으로 나타내볼 것
    int input = Integer.parseInt(br.readLine());
    while (input != 0) {
      // System.out.println(input);
      boolean isCan = false;

      int a = 0, b = 0;
      // 짝수는 없다고 봐야해서 2도 가림
      for (int i = 0; i < primeList.size() / 2; i++) {
        if (primeList.get(i) > input / 2) {
          break;
        }

        a = primeList.get(i);
        b = input - a;
        // System.out.println(a + " " + b);
        if (!isNotPrimeNum[b]) {
          isCan = true;
          break;
        }
      }

      if (isCan) {
        bw.write(
          input + " = " + String.valueOf(a) + " + " + String.valueOf(b) + "\n"
        );
      } else {
        bw.write("Goldbach's conjecture is wrong.\n");
      }

      input = Integer.parseInt(br.readLine());
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
