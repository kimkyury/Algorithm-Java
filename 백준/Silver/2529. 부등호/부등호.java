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

  // static int N;
  static int K;
  static long min = Long.MAX_VALUE;
  static long max = Long.MIN_VALUE;
  static String minStr;
  static String maxStr;

  static char[] inequalitySign;
  static boolean[] isUsed;

  public static void perm(int cnt, StringBuilder selectedSb) {
    if (cnt == K + 1) {
      String selectedNum = selectedSb.toString();
      // System.out.println(selectedNum);
      long selectResult = Long.parseLong(selectedNum);

      if (min > selectResult) {
        min = selectResult;
        minStr = selectedNum;
      }
      if (max < selectResult) {
        max = selectResult;
        maxStr = selectedNum;
      }

      return;
    }

    // 최초에는 10개 다 넣어봄
    if (cnt == 0) {
      for (int i = 0; i < 10; i++) {
        selectedSb.append(i);
        isUsed[i] = true;
        perm(cnt + 1, selectedSb);
        isUsed[i] = false;
        selectedSb.deleteCharAt(cnt);
      }
    } else {
      // 최초가 아닐 시, 이전 수에 대하여 더 큰 수 ||작은 수 만 탐색
      int pre = selectedSb.charAt(cnt - 1) - '0';

      if (inequalitySign[cnt - 1] == '<') {
        for (int i = pre + 1; i < 10; i++) {
          if (isUsed[i]) continue;

          selectedSb.append(i);
          isUsed[i] = true;
          perm(cnt + 1, selectedSb);
          isUsed[i] = false;
          selectedSb.deleteCharAt(cnt);
        }
      } else {
        for (int i = 0; i < pre; i++) {
          if (isUsed[i]) continue;

          selectedSb.append(i);
          isUsed[i] = true;
          perm(cnt + 1, selectedSb);
          isUsed[i] = false;
          selectedSb.deleteCharAt(cnt);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    K = Integer.parseInt(br.readLine());
    inequalitySign = new char[K];
    isUsed = new boolean[10];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      inequalitySign[i] = st.nextToken().charAt(0);
    }

    StringBuilder sb = new StringBuilder();
    perm(0, sb);

    bw.write(String.valueOf(maxStr) + "\n");
    bw.write(String.valueOf(minStr));
    bw.flush();
  }
}
