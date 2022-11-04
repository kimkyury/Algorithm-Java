import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

  static int N;

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int max = Integer.MIN_VALUE;

    // if (K == 1) {
    //   for (int i = 0; i < N; i++) {
    //     max = Math.max(max, arr[i]);
    //   }
    //   System.out.println(max);
    //   return;
    // }

    int lt = 0;
    int sum = 0;
    int cnt = 0;
    for (int rt = 0; rt < N; rt++) {
      sum += arr[rt]; //1
      cnt++;
      if (cnt == K) {
        max = Math.max(max, sum);
        sum -= arr[lt];
        lt++;
        cnt--;
      }
    }

    System.out.print(max);
  }
}
