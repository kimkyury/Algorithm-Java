import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, K, R;
    static long dp[];

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        dp = new long[N + 1];

        long[] pre = new long[N + 1];

        st = new StringTokenizer(br.readLine());

        if (N == 1) {
            bw.write("0\n");
            bw.flush();
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pre[i] = pre[i - 1] + arr[i]; // 나중에 곱하기 전에, 3, 3+2, 3+2+5 값을 미리 저장
        }

        // xn = x1*x2 + x2*x3 // -2 +...
        // xn = x(n-1) + x1*xn + x2*xn + x3*xn

        dp[2] = arr[1] * arr[2];

        if (N == 2) {
            bw.write(dp[2] + "\n");
            bw.flush();
            return;
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + arr[i] * pre[i - 1];
        }

        bw.write(dp[N] + "\n");
        bw.flush();

    }
}