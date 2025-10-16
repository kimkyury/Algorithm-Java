
import java.io.*;
import java.util.*;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  private static StringTokenizer st;
  private static StringBuilder sb;

  public static void main(String[] args) throws IOException {

    sb = new StringBuilder();
    ArrayDeque<Character> ltDq, rtDq;
    HashSet<Character> set = new HashSet<>(Arrays.asList('(', ')', '[', ']'));
    HashMap<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put(']', '[');

    while (true) {

      String input = br.readLine();
      if (input.equals("."))
        break;

      ltDq = new ArrayDeque<>();
      rtDq = new ArrayDeque<>();

      boolean flag = true;
      for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        flag = true;
        if (!set.contains(c)) {
          // 일반문자 SKIP
          continue;
        }

        // 여는 문자 Offer
        if (c == '(' || c == '[') {
          ltDq.offerLast(c);
          continue;
        }

        // 닫는 문자 Poll()
        if (!ltDq.isEmpty() && ltDq.peekLast() == map.get(c)) {
          ltDq.pollLast();
        } else if (ltDq.isEmpty()) {
          // 닫는 문자가 먼저 나오는 경우
          flag = false;
          break;
        } else {
          break;
        }
      }

      if (flag && ltDq.isEmpty()) {
        sb.append("yes").append("\n");
      } else {
        sb.append("no").append("\n");
      }

    }

    bw.write(sb.toString());
    bw.flush();
  }

}