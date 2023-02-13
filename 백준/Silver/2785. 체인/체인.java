import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );
  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );

  static int N;
  static int[] arr;

  public static int solution(PriorityQueue<Integer> pq) {
    int cntLump = pq.size();

    int cntUsedChain = 0;
    while (!pq.isEmpty()) {
      int limit = pq.poll();

      while (limit > 0 && cntLump > 0) {
        if (cntLump == 2) {
          cntUsedChain++;
          limit--;
          cntLump -= 2;
        } else {
          limit--; // 체인 하나 소모
          cntLump--; // 덩어리 감소
          cntUsedChain++;
        }
      }
      if (limit == 0) {
        cntLump--;
      }

      if (cntLump <= 1) {
        return cntUsedChain;
      }
    }

    return -1;
  }

  // Upper, arr = {0, 0, 0, 1,/attachments/1047120651678392372/1074681943817457664/image.png 2, 3, 3, 3, 4, 4, 6, 7, 8}, target = 3, size = arr.length

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      pq.offer(Integer.parseInt(st.nextToken()));
    }

    int answer = solution(pq);

    bw.write(String.valueOf(answer));
    bw.flush();
  }
}
