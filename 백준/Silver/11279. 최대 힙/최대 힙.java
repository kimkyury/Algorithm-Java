import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static int N;

  // public static int solve() {}

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(br.readLine());

    // x > 0, add X
    // x = 0, poll()
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    int num = 0;
    for (int i = 0; i < N; i++) {
      num = Integer.parseInt(br.readLine());
      if (num == 0 && pq.isEmpty()) bw.write(
        String.valueOf(0 + "\n")
      ); else if (num == 0) bw.write(
        String.valueOf(pq.poll() + "\n")
      ); else pq.offer(num);
    }

    // bw.write()
    bw.flush();
  }
}
