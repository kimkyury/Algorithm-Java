import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

  static int N;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    // int isPassed[] = new int[N + 1];
    Stack<Integer> stack = new Stack<>();

    // init case 별도 처리
    int pushNum = 1;
    StringBuilder result = new StringBuilder();
    boolean isImpossible = false;

    int targetNum;
    for (int i = 0; i < N; i++) {
      targetNum = Integer.parseInt(br.readLine());

      if (stack.isEmpty()) {
        stack.push(pushNum++);
        result.append("+" + "\n");
      }

      if (stack.peek() == targetNum) {
        stack.pop();
        result.append("-" + "\n");
      } else {
        while (stack.peek() != targetNum) {
          if (pushNum > N) {
            isImpossible = true;
            break;
          }

          stack.push(pushNum++);
          result.append("+" + "\n");
        }
        stack.pop();
        result.append("-" + "\n");
      }
    }

    if (isImpossible) bw.write("NO"); else bw.write(result.toString());

    bw.flush();
  }
}
