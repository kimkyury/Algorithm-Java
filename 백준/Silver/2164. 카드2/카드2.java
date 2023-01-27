import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static int solve(int N) {
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      q.offer(i);
    }

    while (q.size() != 1) {
      q.poll(); // 삭제
      int tmp = q.poll();
      q.offer(tmp); // 재삽입
    }

    return q.poll();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(solve(N)));

    bw.flush();
  }
}
