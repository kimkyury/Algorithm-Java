import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static ArrayList<int[]> chickenPos;
  static ArrayList<int[]> home;
  static int[][] selectChickenPos;
  static int N, M;
  static int min;

  public static void solve() {}

  public static void saveDistance() {
    int sum = 0;

    // 1.  각 집에서 가장 가까운 치킨집을 찾고
    // 2. 그 집에서의 거리를 tmp +=로 저장하고
    // 3. 그렇게 N개의 집에서 총 합산이 tmp인 거고
    // 4. 그게 min인지 검사하고

    for (int[] h : home) {
      // 각 집에서의 최소 거리에 위치한 치킨집을 찾자
      int minChikenDistance = Integer.MAX_VALUE;
      int hy = h[0];
      int hx = h[1];

      for (int[] chicken : selectChickenPos) {
        int cy = chicken[0];
        int cx = chicken[1];

        int tmpDistance = Math.abs(hy - cy) + Math.abs(hx - cx);
        minChikenDistance = Math.min(minChikenDistance, tmpDistance);
      }

      sum += minChikenDistance;
    }

    // System.out.println(sum);
    min = Math.min(sum, min);
  }

  public static void combi(int cnt, int index) {
    if (cnt == M) {
      // 각 hoome에 대하여 현재 조합의 치킨거리를 구하여 min을 갱신한다
      //  show(selectChickenPos);
      saveDistance();
      return;
    }

    if (index == chickenPos.size()) {
      return;
    }

    selectChickenPos[cnt][0] = chickenPos.get(index)[0];
    selectChickenPos[cnt][1] = chickenPos.get(index)[1];
    combi(cnt + 1, index + 1);
    combi(cnt, index + 1);
  }

  public static void show(int[][] map) {
    for (int[] arr : map) {
      System.out.println(arr[0] + " " + arr[1]);
    }
    System.out.println("");
  }

  public static void saveDistance(int y, int x) {}

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    home = new ArrayList<>();
    chickenPos = new ArrayList<>();
    selectChickenPos = new int[M][2];
    //    ArrayList<Pos> chickenPos = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int num = Integer.parseInt(st.nextToken());
        if (num == 1) {
          int[] pos = new int[2];
          pos[0] = i;
          pos[1] = j;

          home.add(pos);
        } else if (num == 2) {
          int[] pos = new int[2];
          pos[0] = i;
          pos[1] = j;

          chickenPos.add(pos);
        }
      }
    }

    min = Integer.MAX_VALUE;
    // 치킨 집에 대한 조합 만들기
    combi(0, 0);

    bw.write(String.valueOf(min));
    bw.flush();
  }
}
