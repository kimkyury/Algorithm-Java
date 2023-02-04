import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

  static HashSet<String> route;
  static int limitLeft, limitRight;
  static String target;
  static char[] targetInfo;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static void DFS(int left, int right, String cur, String process) {
    if (cur.equals(target)) {
      // System.out.println(process);
      route.add(process);
      return;
    }

    String tmp = cur;
    if (left - 1 >= 0) {
      cur = targetInfo[left - 1] + cur;
      DFS(left - 1, right, cur, process + " " + cur);
    }
    if (right + 1 < limitRight) {
      cur = tmp + targetInfo[right + 1];
      DFS(left, right + 1, cur, process + " " + cur);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    route = new HashSet<>();

    target = br.readLine();
    targetInfo = target.toCharArray();
    limitLeft = 0;
    limitRight = target.length();

    for (int i = 0; i < target.length(); i++) {
      DFS(i, i, "" + targetInfo[i], "" + targetInfo[i]);
    }
    // StringTokenizer st;

    bw.write(String.valueOf(route.size()));
    bw.flush();
  }
}
