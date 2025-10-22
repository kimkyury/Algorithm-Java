
import java.io.*;
import java.util.*;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  private static StringBuilder sb;
  private static int N;

  public static void main(String[] args) throws IOException {

    long n = Integer.parseInt(br.readLine());
    sb = new StringBuilder();

    sb.append(n * (n - 1) / 2 + "\n");
    // solution 함수의 시간복잡도: O(N^2)
    sb.append("2");

    bw.write(sb.toString());
    bw.flush();
  }

  /**
   * 배열이 주어졌을 때, 두 수의 곱을 구하는 식임
   * 시간복잡도
   * N=1이면 0
   * N=2면 A1*A2
   * N=3면 A1*A2 + A1*A3 + A2*A
   * N=4면 A1*A2 + A1*A3 + A1*A4 + A2*A3 + A2*A4 + A3*A4
   * N=5면 A1*A2 + A1*A3 + A1*A4 + A1*A5 + A2*A3 + A2*A4 + A2*A5 + A3*A4 + A3*A5 +
   * A4*A5
   * 즉, N*(N-1)/2 번의 수행 (시그마 i=1~N-1 (N-i) = N*(N-1)/2)
   * 
   * @param A
   * @param a
   * @return
   */
  private int solution(int[] A, int a) {
    int sum = 0;
    for (int i = 1; i < a; i++) {
      for (int j = i + 1; j <= a; j++) {
        sum += A[i] * A[j];
      }
    }

    return sum;
  }

}
