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

  static int N, L;

  static class Pos {

    int start;
    int end;

    Pos(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static void solution() {}

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());

    PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> {
      return o1.start - o2.start;
    });

    int start, end;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());
      pq.offer(new Pos(start, end));
    }

    // 폭우로 인한 N개의 물웅덩이 발생
    // L길이의 널판지로 가리기

    // 1. 최초에 대해서 몇개가 필요한가

    int nulpanziCnt = 0;
    int length = 0;
    while (!pq.isEmpty()) {
      Pos cur = pq.poll();

      // 한 웅덩이에 대하여
      if (cur.start > length) {
        length = cur.start;
      }

      if (cur.end >= length) {
        while (cur.end > length) {
          length += L;
          nulpanziCnt++;
        }
      }
    }

    bw.write(String.valueOf(nulpanziCnt));

    bw.flush();
  }
}
