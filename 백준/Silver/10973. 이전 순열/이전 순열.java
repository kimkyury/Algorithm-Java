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
  static int[] input;
  static boolean[] isUsed;

  public static int findAsc() {
    int idx = -1;
    for (int i = N - 1; i > 0; i--) {
      if (input[i - 1] > input[i]) {
        idx = i - 1;
        break;
      }
    }
    return idx;
  }

  public static void swapBiggerNum(int idx) {
    int temp;
    for (int i = N - 1; i > idx; i--) {
      if (input[idx] > input[i]) {
        temp = input[i];
        input[i] = input[idx];
        input[idx] = temp;

        return;
      }
    }
  }

  public static void makeDesc(int idx) {
    // 순열 뒤집기

    int start = idx + 1;
    int tmp;
    int end = N - 1;
    while (start < end) {
      tmp = input[start];
      input[start] = input[end];
      input[end] = tmp;

      start++;
      end--;
    }
  }

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    input = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    // 1. input에서 내림차순구간을 찾는다[끝난 앞위치: j]
    int descIdx = findAsc();
    if (descIdx == -1) {
      sb.append(-1);
    } else {
      // 2. j보다 큰 수를, 내림차순 구간의 뒷부분부터 찾아나간다
      // 3. 찾았다면 swap시킨다
      swapBiggerNum(descIdx);
      // 4. swap시킨 이후, 내림차순 구간을 역으로 정렬시킨다
      makeDesc(descIdx);
      for (int i = 0; i < N; i++) sb.append(input[i]).append(" ");
    }

    bw.write(sb.toString());
    bw.flush();
  }
}
