import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int M;
  static int[] Hs;

  public static int solve(int maxH) {
    int answerH = 0;

    int lt = 0, rt = maxH;
    int middleH;

    // for Confirm Approximation
    long minDiff = Long.MAX_VALUE;

    while (lt <= rt) {
      middleH = (lt + rt) / 2;
      long sum = 0;
      for (int H : Hs) {
        // Exception: h - middleH 가 음수일 수도 있다
        sum += Math.max(0, H - middleH);
      }

      // confirm:  Is this Sum best Approximation?
      long diff = sum - M;
      if (diff > 0 && diff < minDiff) {
        minDiff = diff;
        answerH = middleH;
      }

      // System.out.println(sum);

      // sum을 키울려면 잘리는 범위를 늘려야 한다 -> H줄이기
      if (sum < M) rt = middleH - 1; else if (sum > M) lt = middleH + 1; else {
        answerH = middleH;
        break;
      }
    }

    return answerH;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    Hs = new int[N];

    st = new StringTokenizer(br.readLine());
    int maxH = 0;
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      maxH = Math.max(maxH, num);
      Hs[i] = num;
    }

    int answer = solve(maxH);
    System.out.println(answer);
  }
}
