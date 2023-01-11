import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  public static int solve(int L, int P, int V) {
    int count = 0;

    int cntHasP = V / P;

    count = L * cntHasP;

    count += Math.min(L, V % P);

    return count;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cntCase = 0;
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int L = Integer.parseInt(st.nextToken());
      int P = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());

      if (L == 0 && P == 0 && V == 0) {
        break;
      }
      int answer = solve(L, P, V);
      cntCase++;
      System.out.println("Case " + cntCase + ": " + answer);
    }
  }
}
