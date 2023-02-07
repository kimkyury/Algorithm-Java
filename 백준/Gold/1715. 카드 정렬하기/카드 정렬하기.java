import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );
  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );

  // static int[] dx = { 1, 0, 1 }; // 우향, 하향, 우하향
  // static int[] dy = { 0, 1, 1 };

  static int N, M;

  // static int solve(int[][] map) {
  //   return dp[N - 1][M - 1];
  // }

  public static void main(String[] args) throws Exception {
    //StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(br.readLine());
    // asc로 받기
    PriorityQueue<Integer> CardBundles = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      CardBundles.offer(Integer.parseInt(br.readLine()));
    }
    // 10 20 40
    // 10+20
    int sum = CardBundles.poll();

    if (N == 1) {
      // System.out.println("엉?");
      bw.write(String.valueOf(0));
      bw.flush();
      return;
    }

    sum += CardBundles.poll();
    if (N == 2) {
      bw.write(String.valueOf(sum));
      bw.flush();
      return;
    }

    int totalSum = sum; // init Cost
    while (!CardBundles.isEmpty()) {
      CardBundles.offer(sum); //
      sum = CardBundles.poll() + CardBundles.poll();
      totalSum += sum;
    }
    // 10
    // 10 + 20 = 30
    // 30 + 40 = 70

    bw.write(String.valueOf(totalSum));
    bw.flush();
  }
}
