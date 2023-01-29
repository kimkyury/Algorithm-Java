import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// class Ballon {

//   int index;
//   int value;

//   Ballon(int index, int value) {
//     this.index = index;
//     this.value = value;
//   }
// }

class Main {

  static int N;
  static int[] balloonNum;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static String solve(Deque<Integer> dq) {
    StringBuilder result = new StringBuilder();
    int balloonIndex = dq.pollFirst();
    int ballonValue = balloonNum[balloonIndex];
    result.append(balloonIndex + " ");

    // 좌, 우에 따라서 터트리는 방향도 다름
    while (!dq.isEmpty()) {
      if (ballonValue > 0) {
        for (int i = 0; i < ballonValue - 1; i++) {
          int tmp = dq.pollFirst();
          dq.offerLast(tmp);
        }
        balloonIndex = dq.pollFirst();
        ballonValue = balloonNum[balloonIndex];
        result.append(balloonIndex + " ");
      } else {
        for (int i = 0; i < Math.abs(ballonValue) - 1; i++) {
          int tmp = dq.pollLast();
          dq.offerFirst(tmp);
        }
        balloonIndex = dq.pollLast();
        ballonValue = balloonNum[balloonIndex];
        result.append(balloonIndex + " ");
      }
    }

    return result.toString();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(br.readLine());
    balloonNum = new int[N + 1];

    Deque<Integer> balloons = new ArrayDeque<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      int value = Integer.parseInt(st.nextToken());
      balloonNum[i] = value;
      balloons.offerLast(i);
    }

    bw.write(String.valueOf(solve(balloons)));
    // bw.write()
    bw.flush();
  }
}
