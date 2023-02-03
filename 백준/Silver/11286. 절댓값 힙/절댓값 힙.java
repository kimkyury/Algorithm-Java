import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static void solve() {}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // o1이 o2보다 크면 뒤로 감
    // 최소힙
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
      if (Math.abs(o1) - Math.abs(o2) == 0) {
        return o1 - o2;
      }
      return Math.abs(o1) - Math.abs(o2);
    });

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());

      if (num == 0) {
        if (pq.isEmpty()) {
          bw.write("0" + '\n'); // -> '0' + '\n'
          //   System.out.println("output: " + '0');
        } else {
          int output = pq.poll();
          bw.write(String.valueOf(output) + '\n');
          //   System.out.println("output: " + output);
        }
        // poll
      } else {
        pq.offer(num);
        //offer
      }
    }

    bw.flush();
  }
}
