import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static PriorityQueue<Integer> pq;

  public static int[] solve(int[] input, int size) {
    int[] answer = new int[size];
    pq = new PriorityQueue<>();

    int index = 0;
    for (int num : input) {
      if (num != 0) {
        pq.add(num);
      } else {
        if (pq.isEmpty()) answer[index++] = 0; else answer[index++] = pq.poll();
      }
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    int[] input = new int[N];
    // Operation INFO
    // Natural X : ADD X
    // 0 : RETURN & REMOVE SmallValue
    // StringTokenizer st = new StringTokenizer(br.readLine());
    int size = 0;
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      input[i] = num;
      if (num == 0) size++;
    }

    int[] answer = solve(input, size);

    for (int num : answer) System.out.println(num);
  }
}
