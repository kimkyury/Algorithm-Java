import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static PriorityQueue<Integer> ascPq;
  static PriorityQueue<Integer> descPq;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    //Handling Input
    int TC;
    TC = Integer.parseInt(br.readLine());
    for (int T = 0; T < TC; T++) {
      ascPq = new PriorityQueue<>();
      descPq = new PriorityQueue<>((o1, o2) -> o2 - o1);
      int M = Integer.parseInt(br.readLine());
      bw.write(String.valueOf(M / 2 + 1) + "\n"); // ouput: 홀수의 개수
      // Cut into 10

      int limit = M / 10 + 1;
      int inputCnt = 0;
      int num;
      for (int i = 0; i < limit; i++) {
        st = new StringTokenizer((br.readLine()));

        while (st.hasMoreTokens()) {
          // 20: 20개가 들어와야 10개가 출력됨
          if (inputCnt != 0 && inputCnt % 20 == 0) bw.write("\n");
          num = Integer.parseInt(st.nextToken());
          // when inputCnt is Even -> desc, Odd -> asc
          // inputCnt가 짝수 개가 되었다면, peek() 비교 후 pop 교체 작업
          if (inputCnt % 2 == 0) {
            descPq.offer(num);
            inputCnt++;

            if (!ascPq.isEmpty() && descPq.peek() > ascPq.peek()) {
              int tmpFromDesc = descPq.poll();
              int tmpFromAsc = ascPq.poll();
              descPq.offer(tmpFromAsc);
              ascPq.offer(tmpFromDesc);
            }
            bw.write(String.valueOf(descPq.peek()) + " ");
          } else {
            ascPq.offer(num);
            inputCnt++;
          }
        }
      }
      bw.write("\n");
    }
    bw.flush();
  }
  // pq
  // 1 4 5 -> poll:2 (3/2 +1)
  // 1 2 3 4 5 -> poll: 3 (5/2+1)

}
