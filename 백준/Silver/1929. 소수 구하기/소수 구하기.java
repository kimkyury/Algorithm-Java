import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void solve(int N, int M) {
    // over N  ~ under M
    if (N == 1 && M == 1) {
      // System.out.println(""); // 1은 소수 아니잖아
      return;
    } else if (M == 2) {
      System.out.println("2");
      return;
    }

    int[] candidate = new int[M + 1];
    // avaliable -> 0, UnAvailable -> 1
    candidate[1] = 1;

    // 완전탐색 X
    // 에라토스테네스의 체를 써보자 -> 반복되는 배수들 모두 제거
    // if (N == 1) N = 2; // 상향조정
    // int num = 2;
    for (int i = 2; i <= M; i++) {
      if (candidate[i] == 0) {
        for (int j = i + i; j <= M; j += i) {
          candidate[j] = 1;
        }
      }
    }

    for (int i = N; i <= M; i++) {
      if (candidate[i] == 0) {
        System.out.println(i);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    solve(N, M);
    // for (int answer : answers) System.out.println(answer);
  }
}
