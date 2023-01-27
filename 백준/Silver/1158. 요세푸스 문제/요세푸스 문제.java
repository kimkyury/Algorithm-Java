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

  public static int[] solve(int N, int K) {
    int[] answer = new int[N];
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      q.offer(i);
    }

    int answerIndex = 0;
    while (!q.isEmpty()) {
      for (int i = 0; i < K - 1; i++) {
        int tmp = q.poll();
        q.offer(tmp);
      }
      answer[answerIndex++] = q.poll();
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] answer = solve(N, K);
    bw.write("<");

    for (int i = 0; i < N - 1; i++) {
      bw.write(String.valueOf(answer[i]));
      bw.write(", ");
    }
    bw.write(answer[N - 1] + ">");

    bw.flush();
  }
}
