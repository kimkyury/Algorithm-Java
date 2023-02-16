import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static int N, M, K;
  static int[][] map;
  static int[][] mapCopy;
  static int min;
  static int[][] rotation;
  static int[][] selectRotation;
  static boolean[] isContain;

  public static void solve(int r, int c, int s) {
    // 회전이 들어감

    // System.out.print("\n" + r + " " + c + " " + s + "\n");

    // 중심 (r-1,c-1)가 기준이 된다
    // (r-1-s, c-1-s)부터 (r-1+s, c-1+s)가 회전됨
    // (r, c ) = (y, x)
    int sY = r - 1 - s;
    int eY = r - 1 + s;
    int sX = c - 1 - s;
    int eX = c - 1 + s;

    while (true) {
      if ((eY < 1 + sY) || (eX < 1 + sX)) break;

      int temp = map[sY][sX];

      // 좌에서 하향할 것임
      for (int i = sY; i < eY; i++) {
        map[i][sX] = map[i + 1][sX]; // i+1 = eY
      }
      // 하에서 우향할 것임
      for (int i = sX; i < eX; i++) {
        map[eY][i] = map[eY][i + 1];
      }
      // 우에서 상향할 것임
      for (int i = eY; i > sY; i--) {
        map[i][eX] = map[i - 1][eX];
      }
      // 상에서 좌향할 것임
      for (int i = eX; i > sX; i--) {
        map[sY][i] = map[sY][i - 1];
      }

      map[sY][sX + 1] = temp;
      sY++;
      sX++;
      eY--;
      eX--;
    }
    // show(map);
  }

  public static void show(int[][] grid) {
    System.out.println("");
    for (int[] arr : grid) {
      for (int a : arr) {
        System.out.print(a + " ");
      }
      System.out.println("");
    }
  }

  public static void counting() {
    // 각 행의 합 중 가장 작은 값

    int sum;
    for (int i = 0; i < map.length; i++) {
      sum = 0;
      for (int j = 0; j < map[0].length; j++) {
        sum += map[i][j];
      }

      min = Math.min(min, sum);
    }
    // System.out.println(min);
    // return min;
  }

  public static void perm(int index) {
    if (index == K) { // permutation 길이를 채우면
      // 한개의 rotation패턴이 정해짐 ( 342, 241) (421, 342)
      // 이걸로 solve가자

      // rotation돌리기
      for (int i = 0; i < K; i++) {
        int[] tmp = selectRotation[i];
        solve(tmp[0], tmp[1], tmp[2]);
      }

      // show(selectRotation);
      // show(map);

      // 회전된 열에서 max찾기
      counting();

      for (int i = 0; i < mapCopy.length; i++) {
        for (int j = 0; j < mapCopy[0].length; j++) {
          map[i][j] = mapCopy[i][j];
        }
      }

      // show(map);
      return;
    }

    for (int i = 0; i < K; i++) {
      if (isContain[i] == false) {
        isContain[i] = true;

        // selectRotation[index] = rotation[i].clone();

        for (int j = 0; j < rotation[0].length; j++) {
          selectRotation[index][j] = rotation[i][j];
        }

        perm(index + 1);
        isContain[i] = false;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    // 주어진 배열을 반시계 방향으로 회전시켜나가기
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    min = Integer.MAX_VALUE;
    map = new int[N][M];
    mapCopy = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        mapCopy[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 회전 연산 정보
    rotation = new int[K][3];
    selectRotation = new int[K][3];
    isContain = new boolean[K];
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      rotation[i][0] = Integer.parseInt(st.nextToken());
      rotation[i][1] = Integer.parseInt(st.nextToken());
      rotation[i][2] = Integer.parseInt(st.nextToken());
    }

    perm(0);

    bw.write(String.valueOf(min));
    bw.flush();
  }
}
