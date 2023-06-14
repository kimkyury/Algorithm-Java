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

  static int N;
  static int[] sequence;
  static char[] inputs;
  static boolean[] isNegative;
  static int size;

  static boolean flag;

  static void checkNegative() {
    int idx = 0;
    for (int i = 0; i < size; i += (N - idx + 1)) {
      if (idx == N) break;
      if (inputs[i] == '-') isNegative[idx] = true;
      idx++;
    }
  }

  static void perm(int cnt, int[] selected) {
    if (flag) {
      // 이미 찾았으면 종료
      return;
    }

    if (cnt == N) {
      // System.out.println(
      //   "cnt: " + cnt + " selected: " + Arrays.toString(selected)
      // );
      // 확인 후, 최종 선택
      if (confirm(cnt, selected)) {
        // System.out.println(">>>>>> selected: " + Arrays.toString(selected));
        for (int i = 0; i < N; i++) sb.append(selected[i]).append(" ");
        flag = true;

        return;
      }
      return;
    } else {
      if (cnt > 0 && !confirm(cnt, selected)) {
        return;
      }
    }

    if (isNegative[cnt]) {
      for (int i = -1; i >= -10; i--) {
        selected[cnt] = i;
        perm(cnt + 1, selected);
      }
    } else {
      for (int i = 0; i <= 10; i++) {
        selected[cnt] = i;
        perm(cnt + 1, selected);
      }
    }
  }

  static boolean confirm(int cnt, int[] selected) {
    int index = 0;

    int num = N + 1;
    for (int i = 0; i < cnt; i++) {
      int sum = 0;

      // index = i * N + j ???
      int num2 = 0;
      for (int j = i; j < cnt; j++) {
        sum += selected[j];
        // System.out.println(sum);

        if (inputs[index + num2] == '-') {
          if (sum >= 0) return false;
        } else if (inputs[index + num2] == '+') {
          if (sum <= 0) return false;
        } else {
          if (sum != 0) return false;
        }

        num2++;
      }
      // i:0 -> 0 1 2 3
      // i:1 -> 4 5 6
      // i:2 -> 7 8
      // i:3 -> 9
      index += --num; // 0, 4, 7, 9
    }
    // System.out.println("okay");
    return true;
  }

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    sequence = new int[N];
    isNegative = new boolean[N];
    flag = false;

    size = N * (N + 1) / 2;
    inputs = new char[size];
    inputs = br.readLine().toCharArray();

    checkNegative();
    int[] selected = new int[N];
    perm(0, selected);

    bw.write(sb.toString());
    bw.flush();
  }
}
