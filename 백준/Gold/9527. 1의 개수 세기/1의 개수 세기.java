import java.io.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static long N, M, T;
    static StringTokenizer st;
    static long max = 0;
    static long[] dp;

    public static void main(String[] args) throws IOException {

        // x를 2진수로 표현했을 때의 1의 개수

        st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 001, 010, 011, 100, 101, 110, 111

        // 02 = 0010
        // 0011, 0100, 0101, 0110, 0111, 1000
        // 12 = 1100 -> 1011, 1010, 1001

        // 01 = 0001
        // 02 = 0010
        // 03 = 0011
        // 04 = 0100
        // 05 = 0101
        // 06 = 0110
        // 07 = 0111
        // 08 = 1000

        // 2의 제곱 = 한 개
        // 3,5, 6 = 두 개

        // 2 = 0010
        // 12 = 1100

        // B로 만들 수 있는

        // dp[n] = dp[n-1]*2 + 2^n

        // 10^16개 일일이 하면 시간초과

        dp = new long[55];
        dp[0] = 1;
        for (int i = 1; i < 55; i++) {
            // dp[i] = dp[i-1]*2 + 2^n
            dp[i] = (dp[i - 1] << 1) + (1L << i);
        }

        long resultA = calcul(A - 1);
        long resultB = calcul(B);

        bw.write((resultB - resultA) + "");

        bw.flush();
    }

    static long calcul(long num) {

        long count = num % 2 == 0 ? 0 : 1;

        int n = (int) (Math.log(num) / Math.log(2));
        // 2의 제곱수만큼
        for (int i = n; i > 0; i--) {

            long next2 = 1L << i;

            // num에 next2의 비트 값이 포함되어있으면
            if ((num & next2) != 0) {
                num -= next2;
                count += dp[i - 1] + num + 1;
            }
        }

        return count;
    }

}
