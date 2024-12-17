import java.io.*;

import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M, K;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        // N 높이를 분리시키기
        // A -> B, C -> B*C

        long N = Long.parseLong(br.readLine());

        long result = (N * (N - 1)) / 2;
        bw.write(result + "");
        bw.flush();
    }

    static void recur(int num) {

        // dp[1][1] = 1
        // dp[1][2] = dp[1][1] + dp[1][1]
        // dp[1][3] = dp[1][2] + dp[1][1]
        // dp[1][4] = dp[1][3] + dp [1][1] || dp[1][2] + dp[2][4]

    }

}
