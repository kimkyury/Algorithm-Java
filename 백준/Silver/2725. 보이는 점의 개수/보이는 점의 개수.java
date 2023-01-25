import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static int[] dp;
  static int C;

  // 유클리드 호재법
  // num1, num2의 최대공약수와 num2, num2%num1(나머지)의 최대공약수는 같다
  public static int gcd(int num1, int num2) {
    // num1이 num2보다 큰 수로 확정짓기
    if (num1 < num2) {
      int tmp = num1;
      num1 = num2;
      num2 = tmp;
    }
    while (num2 != 0) { // rest값이 0이 되는 순간이 공약수를 의미함
      int rest = num1 % num2;
      num1 = num2;
      num2 = rest;
    }
    return num1; // 최대공약수를 리턴함
  }

  public static void solve() {
    // N=5라고 치면?
    // 1,1의 배수면 안 됨
    // 1,2의 배수면 안 됨
    // 1,3의 배수면 안 됨 -> 어차피 out of Index
    // 1,4의 배수면 안 됨 -> 어차피 out of Index

    dp[1] = 3; // 1x1인 곳에서는 3개의 직선 존재

    int cnt;
    for (int i = 2; i <= 1000; i++) { // 한 변의 길이
      cnt = 0;

      for (int j = 1; j <= i; j++) { // y축, x축이 되는 j=0은 제외
        if (i == j) continue; // 기울기가 1인 것은 제외
        int resultGCD = gcd(i, j);
        if (resultGCD == 1) {
          cnt += 2; // x=y축을 기준으로 대칭 카운팅
        }
      }

      dp[i] = dp[i - 1] + cnt;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    C = Integer.parseInt(br.readLine());
    dp = new int[1001];
    int size = 0;

    solve();
    for (int i = 0; i < C; i++) {
      int N = Integer.parseInt(br.readLine());

      bw.write(dp[N] + "\n");
    }
    // 백만에 대한 주기 구하기
    bw.flush();
  }
}
