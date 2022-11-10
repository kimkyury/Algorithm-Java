import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  static int N;
  static int[] arr;
  static int[] dy;

  static void solve() {
    dy[0] = arr[0];

    for (int i = 1; i < N; i++) { // dy index
      dy[i] = arr[i];

      int max = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] < arr[i] && max < dy[j]) {
          max = dy[j];
        }
      }

      dy[i] += max;
    }

    Arrays.sort(dy);
    System.out.println(dy[N - 1]);
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    dy = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    solve();
  }
}
