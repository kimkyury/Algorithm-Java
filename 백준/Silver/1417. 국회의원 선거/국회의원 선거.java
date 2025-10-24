import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

  private int N;
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws Exception, IOException {

    int sum = 0;
    int N = Integer.parseInt(br.readLine());
    int DASOM = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    if (N == 1) {
      bw.write("0");
      bw.flush();
      return;
    }

    for (int i = 0; i < N - 1; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
    }

    while (!pq.isEmpty() && pq.peek() >= DASOM) {
      int next = pq.poll(); // 현재 최다 득표자
      next--; 

      DASOM++; // 다솜 표 +1
      sum++; // 매수 횟수 +1
      pq.offer(next);
    }

    bw.write(sum + "");
    bw.flush();

  }
}
