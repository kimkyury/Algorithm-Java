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
    int E, S, M;

    int limitE = 15;
    int limitS = 28;
    int limitM = 19;

    // 351, 188, 277
    st = new StringTokenizer(br.readLine());

    int resultE = Integer.parseInt(st.nextToken());
    int resultS = Integer.parseInt(st.nextToken());
    int resultM = Integer.parseInt(st.nextToken());

    while (true) {
      if (resultE == resultS && resultS == resultM) {
        break;
      }

      // System.out.println(resultE + " " + resultS + " " + resultM);
      // try {
      //   // Thread.sleep(500);
      // } catch (InterruptedException e) {
      //   e.printStackTrace();
      // }
      // 가장 min인 애만 한 번씩 증가시키자

      if (resultE <= resultS && resultE <= resultM) {
        resultE += limitE;
      } else if (resultM <= resultE && resultM <= resultM) {
        resultM += limitM;
      } else if (resultS <= resultE && resultS <= resultM) {
        resultS += limitS;
      }
    }
    bw.write(String.valueOf(resultE));
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
