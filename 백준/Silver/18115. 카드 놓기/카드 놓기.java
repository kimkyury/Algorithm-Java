
import java.io.*;
import java.util.*;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  private static StringBuilder sb;
  private static int N;

  public static void main(String[] args) throws IOException {

    // 맨 위 카드
    // 두번째 카드
    // 제일 밑의 카드

    // 순서가 항상 1 2 3 4 5 ... N

    // case 2 3 3 2 1
    // 1: (맨위) 1 (아래)
    // 2: 1 2
    // 3: 1 2 3
    // 4: 1 2 3 4
    // 5: 1 5 2 3 4

    // 1: dq.offerFirst(next)
    // 3: dq.offerLast(next)
    // 2: dq.pollFirst() (임시저장), dqp.offerFirst(next), dq.offerFirst(임시저장)

    ArrayDeque<Integer> dq = new ArrayDeque<>();

    N = Integer.parseInt(br.readLine()); // 1 <= N <= 10^6
    int[] tech = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int next = 1;
    int idx = N - 1;
    while (next <= N) {

      if (tech[idx] == 1) {
        dq.offerFirst(next);
      } else if (tech[idx] == 2) {
        int temp = dq.pollFirst();
        dq.offerFirst(next);
        dq.offerFirst(temp);
      } else if (tech[idx] == 3) {
        dq.offerLast(next);
      }

      idx--;
      next++;
    }

    sb = new StringBuilder();
    while (!dq.isEmpty()) {
      sb.append(dq.pollFirst()).append(" ");
    }

    bw.write(sb.toString());
    bw.flush();
  }

}
