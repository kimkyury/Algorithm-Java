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

  static boolean isNotPrimeNum[];

  public static void main(String[] args) throws IOException {
    isNotPrimeNum = new boolean[1001];

    isNotPrimeNum[0] = isNotPrimeNum[1] = true;

    for (int i = 2; i < 1001; i++) {
      if (!isNotPrimeNum[i]) {
        for (int j = 2; j * i < 1001; j++) {
          isNotPrimeNum[j * i] = true;
        }
      }
    }

    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (!isNotPrimeNum[num]) {
        // System.out.println(num + "is PrimeNum");
        cnt++;
      }
    }

    bw.write(String.valueOf(cnt));
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
