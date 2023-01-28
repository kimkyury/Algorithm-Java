import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Main {

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    char[] operation = { '*', '+', '/', '-' };

    String rex = br.readLine();
    Stack<Double> stack = new Stack<>();
    double[] tmp = new double[N];
    for (int i = 0; i < N; i++) {
      tmp[i] = Integer.parseInt(br.readLine());
    }

    int index = 0;
    for (char c : rex.toCharArray()) {
      if (Character.isAlphabetic(c)) {
        stack.push(tmp[c - 'A']);
      } else {
        double num2 = stack.pop();
        double num1 = stack.pop();

        double result = 0;
        if (c == '*') {
          result = num1 * num2;
        } else if (c == '+') {
          result = num1 + num2;
        } else if (c == '/') {
          result = num1 / num2;
        } else {
          result = num1 - num2;
        }

        stack.push(result);
      }
    }

    bw.write(String.format("%.2f", stack.pop()));
    bw.flush();
  }
}
