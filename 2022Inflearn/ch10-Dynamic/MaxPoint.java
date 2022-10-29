import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Problem implements Comparable<Problem> {

  int point;
  int time;

  Problem(int point, int time) {
    this.point = point;
    this.time = time;
  }

  @Override
  public int compareTo(Problem o) {
    //오름차순
    return this.time - o.time;
  }
}

class Main {

  static int N, M;
  static int[] dy;
  static ArrayList<Problem> problems;

  public static void solution() {
    Collections.sort(problems);
    Arrays.fill(dy, 0);

    dy[0] = 0;
    for (int i = 0; i < N; i++) {
      int targetTime = problems.get(i).time;
      int targetPoint = problems.get(i).point;
      for (int j = M; j >= targetTime; j--) {
        dy[j] = Math.max(dy[j], dy[j - targetTime] + targetPoint);
      }
    }

    System.out.println(dy[M]);
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    problems = new ArrayList<>();
    dy = new int[M + 1];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int point = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());

      problems.add(new Problem(point, time));
    }

    solution();
    // int answer = main.solution(N);

  }
}
