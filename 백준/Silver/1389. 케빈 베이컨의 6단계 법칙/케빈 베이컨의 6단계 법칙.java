import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

  static int[][] map;
  static int[] isCheckedVertex;
  static int N;
  static int M;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static int bfs(int v) {
    isCheckedVertex = new int[N + 1];
    isCheckedVertex[v] = 1;
    Queue<Integer> q = new LinkedList<>();
    int cnt = 0;
    int sum = 0;
    q.offer(v);

    int tmp;
    while (!q.isEmpty()) {
      int qSize = q.size();
      cnt++;
      for (int i = 0; i < qSize; i++) { // 현 level의 잔여 큐값이 다 돌고 cnt가 증가될 수 있도록
        tmp = q.poll();
        for (int j = 1; j <= N; j++) {
          // exist Edge && UnChecked Vertex
          if (map[tmp][j] == 1 && isCheckedVertex[j] == 0) {
            // cnt++;
            isCheckedVertex[j] = 1;
            q.add(j);
            sum += cnt;
          }
        }
      }
    }

    return sum;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N + 1][N + 1];
    // isCheckedVertex = new int[N + 1];

    int v1, v2;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      v1 = Integer.parseInt(st.nextToken());
      v2 = Integer.parseInt(st.nextToken());

      map[v1][v2] = 1;
      map[v2][v1] = 1;
    }

    int answer = -1;
    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= N; i++) {
      int returnValue = bfs(i);
      // System.out.println(i + ": " + returnValue);
      if (min > returnValue) {
        min = returnValue;
        answer = i;
      }
    }

    bw.write(String.valueOf(answer));
    bw.flush();
  }
}
