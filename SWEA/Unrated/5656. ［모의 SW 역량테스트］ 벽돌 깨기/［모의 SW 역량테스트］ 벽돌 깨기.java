import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int T;
  static int N;
  static int W, H;
  static int[][] map;
  static int[][] originalMap;
  static boolean[] isPassed;
  static int[] permInfo;
  static int restCnt;
  static int originalCnt;

  static int min = Integer.MAX_VALUE;

  static int[] dy = { -1, 0, 1, 0 };
  static int[] dx = { 0, 1, 0, -1 };

  public static void breakDownBrick(int y, int x) {
    //        System.out.println("y:" + y + " x:" + x + ", size:" + map[y][x] + " counting:" + restCnt);

    int curSize = map[y][x];
    map[y][x] = 0;
    restCnt--;
    if (curSize == 1) {
      return;
    } else {
      // 4방탐색, 지울 곳 체킹
      for (int i = 0; i < 4; i++) {
        for (int weight = 1; weight < curSize; weight++) {
          int ny = y + dy[i] * weight;
          int nx = x + dx[i] * weight;

          if (ny > H || nx > W || ny < 0 || nx < 0) continue;

          if (map[ny][nx] != 0) breakDownBrick(ny, nx);
        }
      }
    }
  }

  public static void perm(int index, int cnt) {
    if (cnt == N) { // N개 만큼 뽑았으면
      //            System.out.println("--------- 해당 순열로 진행------");
      //            show(permInfo);
      for (int i = 0; i < N; i++) { // 각 perm의 index(x좌표)에 대하여
        int nx = permInfo[i];
        for (int j = 0; j < H; j++) { // 0의 값이 아닌 y좌표를 찾아서
          if (map[j][nx] != 0) {
            //                        System.out.print("routin 한 개  Y: " + j + " X: " + nx + "\n");

            breakDownBrick(j, nx); // 부서뜨릴 곳을 보냄

            // 터트릴 만한 곳은 다 없애고, 빈 공간에 의해 분리된 부분을 땡겨주기
            //                            show(map);
            //                            System.out.println("");

            // 어떤 y행에 대하여, 0이 아닌 곳을 모아서 순서대로 다시 넣는다
            for (int x = 0; x < W; x++) {
              int[] tmpArr = new int[H];
              int idx = 0;

              for (int y = H - 1; y >= 0; y--) {
                if (map[y][x] != 0) {
                  tmpArr[idx++] = map[y][x];
                }
              }
              for (int k = H - 1; k >= 0; k--) map[k][x] = tmpArr[H - 1 - k];
            }
            break;
          }
        }
      }

      int total = 0;
      for (int i = 0; i < W + 1; i++) {
        for (int j = 0; j < H + 1; j++) {
          if (map[j][i] != 0) {
            total++;
          }
        }
      }

      min = Math.min(min, total);

      // 다음 순열에 대한 조회를 위해 정보 리셋
      for (int i = 0; i < map.length; i++) System.arraycopy(
        originalMap[i],
        0,
        map[i],
        0,
        map[0].length
      );
      restCnt = originalCnt;
      return;
    }

    //if (index == W) {
      //return;
    //}

    for (int i = 0; i < W; i++) {
      permInfo[cnt] = i;
      perm(index + 1, cnt + 1);
    }
  }

  public static void show(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + "  ");
      }
      System.out.println("");
    }
  }

  public static void show(int[] arr) {
    for (int i : arr) System.out.print(i + " ");
    System.out.println("");
  }

  public static void main(String args[]) throws Exception {
    //System.setIn(new FileInputStream("res/input.txt"));
    br = new BufferedReader(new InputStreamReader(System.in));

    T = Integer.parseInt(br.readLine());

    for (int test_case = 1; test_case <= T; test_case++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      W = Integer.parseInt(st.nextToken());
      H = Integer.parseInt(st.nextToken());
      map = new int[H + 1][W + 1];

      permInfo = new int[N];
      isPassed = new boolean[W];
      originalCnt = 0;

      for (int i = 0; i < H; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < W; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());

          if (map[i][j] != 0) originalCnt++;
        }
      }

      // 기본값
      min = Integer.MAX_VALUE;
      restCnt = originalCnt;
      originalMap = new int[map.length][map[0].length];
      for (int i = 0; i < originalMap.length; i++) { // 깊은복사
        System.arraycopy(map[i], 0, originalMap[i], 0, map[0].length);
      }

      perm(0, 0);

      bw.write("#" + test_case + " " + min + "\n");
      bw.flush();
    }
  }
}
