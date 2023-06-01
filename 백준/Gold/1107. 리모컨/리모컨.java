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

  static boolean[] isBroken;
  static int minCnt;
  static boolean isFind = false;

  static int findApproximation(int target) {
    // target에 대하여 이용가능한 근사치 찾기

    int initValue = target;

    int weight = 0;

    boolean isPossible = true;
    while (true) {
      // System.out.println(plusT);
      int minusT = target - weight;
      if (minusT >= 0) {
        String minusStr = String.valueOf(minusT);
        isPossible = true;
        for (int i = 0; i < minusStr.length(); i++) {
          int num = minusStr.charAt(i) - '0';
          if (isBroken[num]) {
            isPossible = false;
            break;
          }
        }
        if (isPossible) {
          return minusT;
        }
      }

      int plusT = target + weight;
      String plusStr = String.valueOf(plusT);
      isPossible = true;
      for (int i = 0; i < plusStr.length(); i++) {
        int num = plusStr.charAt(i) - '0';

        if (isBroken[num]) {
          isPossible = false;
        }
      }

      if (isPossible) {
        return plusT;
      }

      weight++;
    }
  }

  public static void main(String[] args) throws IOException {
    String strN = br.readLine();
    int N = Integer.parseInt(strN);
    minCnt = Math.abs(100 - N);

    if (N == 100) {
      // 이동할 게 없으므로 Zero 리턴
      bw.write("0");
      bw.flush();
      return;
    }

    // N의 자리 수 구하기
    int lenN = 1;
    int NforLen = N;

    while (NforLen >= 10) {
      lenN++;
      NforLen /= 10;
    }

    int breakCnt = Integer.parseInt(br.readLine());
    if (breakCnt == 0) {
      // 고장난게 없으므로 길이수만큼 버튼 클릭하고 끝
      minCnt = Math.min(minCnt, lenN);

      bw.write(String.valueOf(minCnt));
      bw.flush();
      return;
    } else if (breakCnt == 10) {
      // 다 고장났으므로 100과의 차이만큼을 클릭하고 끝
      bw.write(String.valueOf(Math.abs(100 - N)));
      bw.flush();
      return;
    }

    isBroken = new boolean[10]; // 1~ 9

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < breakCnt; i++) {
      int idx = Integer.parseInt(st.nextToken());
      isBroken[idx] = true;
    }

    // 우선, cnt값을 ++과 --로 갈 수 있는 그 diff로 초기화한다

    // System.out.println("init MinCnt: " + minCnt);

    // 1. 고장나지 않은 수로 대입 가능한 근사값을 찾는다
    int approximateNum = findApproximation(N);
    String approximateStr = String.valueOf(approximateNum);

    // ex. 9 -> approximateNum : 0
    // System.out.println(approximateNum);

    int diffCnt = Math.abs(N - approximateNum);
    minCnt = Math.min(minCnt, diffCnt + approximateStr.length());

    // 2. 미지수 자리에 대하여 ,N의 각 자리에 대한 근사값을 브루트포스로 탐색한다
    // --와 ++를 번갈아가서 가장 근사치를 찾음

    // 3. 최종적인 근사치 이동값에서, 실제 N과의 차이를 구하고 cnt에 그 diff를 더한다

    bw.write(String.valueOf(minCnt));
    bw.flush();
  }

  // ----------for log
  static void show(char[][] arr) {
    System.out.println("----------------");
    for (char[] ar : arr) {
      System.out.println(Arrays.toString(ar));
    }
  }
}
