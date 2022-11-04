import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

  static ArrayList<int[]> dises = new ArrayList<>();
  static int[] opposites = { 5, 3, 4, 1, 2, 0 };
  static int N;

  // 현재 주사위 층, 윗면 숫자
  public static int build(int n, int bottom, int sum) {
    if (n == N) return sum;

    int[] dise = dises.get(n); // 1, 2 ..., N-1

    //현재 다이스의 bottom 위치값 찾기
    int index = 0;
    for (int i = 0; i < 6; i++) {
      if (dise[i] == bottom) {
        index = i;
        break;
      }
    }
    //현재 다이스의 top값 찾기
    int top = dise[opposites[index]]; // i: 0~5

    //현재 다이스 옆면의 최대값
    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= 6; i++) {
      if (i == top || i == bottom) continue;
      max = Math.max(max, i);
    }

    sum += max;
    return build(n + 1, top, sum);
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    dises = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      int[] dise = new int[6];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 6; j++) {
        dise[j] = Integer.parseInt(st.nextToken());
      }
      dises.add(dise);
    }

    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < 6; i++) { // 첫 다이스의 인덱스 순환
      int bottom = dises.get(0)[i]; // 2, 3, 1, 6, 5, 4(i: 0~N-1)
      int top = dises.get(0)[opposites[i]]; // 4, 6, 5, 3, 1, 2

      //옆면의 최댓값
      int maxside = Integer.MIN_VALUE;
      for (int j = 1; j <= 6; j++) {
        if (j == top || j == bottom) continue;
        maxside = Math.max(maxside, j);
      }

      maxSum = Math.max(build(1, top, maxside), maxSum);
    }

    System.out.println(maxSum);
  }
}
