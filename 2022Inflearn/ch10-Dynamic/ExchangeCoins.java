import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

  static int N;
  static int[] arr;
  static int[] dy;
  static int money;

  public static void solution() {
    // 내림차순 정렬
    Arrays.fill(dy, Integer.MAX_VALUE);

    dy[0] = 0;
    for (int i = 0; i < N; i++) {
      for (int j = arr[i]; j <= money; j++) {
        dy[j] = Math.min(dy[j], dy[j - arr[i]] + 1);
      }
    }

    System.out.println(dy[money - 1]);
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    money = Integer.parseInt(br.readLine());
    dy = new int[money + 1];
    solution();
    // int answer = main.solution(N);

  }
}
