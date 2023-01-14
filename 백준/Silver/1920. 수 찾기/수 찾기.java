import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int M;

  public static int[] solve(int[] ns, int[] ms) {
    // Start with Sorting
    Arrays.sort(ns);

    int[] answer = new int[ms.length];

    int midIndex;

    int lt, rt;
    for (int i = 0; i < ms.length; i++) {
      lt = 0;
      rt = ns.length - 1;
      while (lt <= rt) {
        midIndex = (lt + rt) / 2;
        if (ms[i] > ns[midIndex]) lt = midIndex + 1; else if (
          ms[i] < ns[midIndex]
        ) rt = midIndex - 1; else {
          answer[i] = 1;
          break;
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    int[] ns = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) ns[i] = Integer.parseInt(st.nextToken());

    M = Integer.parseInt(br.readLine());
    int[] ms = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) ms[i] = Integer.parseInt(st.nextToken());

    int[] answer = solve(ns, ms);
    for (int num : answer) System.out.println(num);
  }
}
