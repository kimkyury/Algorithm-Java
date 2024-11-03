import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static long[][][] dp;

    static int LIMIT = 1000000000;

    public static void main(String[] args) throws IOException {

        // N이 주질 때, 길이가 N이면서 0±9까지 숫자가 모두 등장하는 계단 수

        // 45656
        // 10 -> 길이가 10 이면서 0부터 9가 모두 계단인 수 987654321

        // N 이 10 이하라면 나올 수 없다

        // N이 11이라면? 9(?)876543210 -> 11개(맨앞, 맨 뒤)의 자리중 하나를 골라, 앞 혹은 뒤에 해당하는 숫자를 집어넣으면
        // N=11, .9.8.7.6.5.4.3.2.1.0., 9개 자리에서 앞뒤에 해당하는 수를 고름 -> 9C2 + 맨 앞은 8만 가능, 맨 뒤는
        // 1만 가능
        // N=12, N=11이었을 경우에 대해서 10개 자리에서 앞뒤에 해당하는 수 고름 -> 10C2 + 맨앞은

        int N = Integer.parseInt(br.readLine());

        if (N < 10) {
            bw.write("0");
            bw.flush();
            return;
        }

        dp = new long[N + 1][10][1 << 10];

        // init
        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1; // 자리수가 1일 때, i가 마지막인 경우에 대해서 해당 경우의 수는 1이다 (1, 2, 3, 4, 5, 6, 7, 8, 9)
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {

                // 이전의 경우의 수를 합산한다
                for (int k = 1; k < 1024; k++) {

                    int cur = (1 << j) | k; // [i][j][k] 중, k자리에 들어갈 수. k상태에서 j가 선택된 경우.

                    if (j == 0) {
                        dp[i][j][cur] += dp[i - 1][1][k];
                    } else if (j == 9) {
                        dp[i][j][cur] += dp[i - 1][8][k];
                    } else {
                        dp[i][j][cur] += dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k];
                    }
                    dp[i][j][cur] %= LIMIT;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i][1023]; // 최종적으로, N자리의 수가 만들어진 상황에서 123456789가 다 선택된 경우, 다만 어떤 숫자가 마지막인지가 분류되어있음
            sum %= LIMIT;
        }

        bw.write(sum + "\n");
        bw.flush();
    }

    public static void print(int map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
