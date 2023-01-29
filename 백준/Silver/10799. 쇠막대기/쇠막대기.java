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

  // TODO: 레이저를 확인할 수 있어야한다
  public static int solve(String str) {
    char preChar;

    //Not use Stack
    // Stack<Character> s = new Stack<>();
    int total = 0;
    int cntChar = 0;

    char[] curChar = str.toCharArray();
    preChar = curChar[0];

    for (int i = 1; i < str.length(); i++) {
      // 레이저라면
      if (preChar == '(' && curChar[i] == ')') {
        total += cntChar;
      } else if (preChar == '(' && curChar[i] == '(') {
        cntChar++;
      } else if (preChar == ')' && curChar[i] == ')') {
        cntChar--;
        total++;
      }
      // else if (preChar == ')' && curChar[i] == '(') {
      //   cntChar++;
      // }

      preChar = curChar[i];
    }

    return total;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // StringTokenizer st = new StringTokenizer(br.readLine());

    String str = br.readLine();

    bw.write(String.valueOf(solve(str)));
    // bw.write()
    bw.flush();
  }
}
