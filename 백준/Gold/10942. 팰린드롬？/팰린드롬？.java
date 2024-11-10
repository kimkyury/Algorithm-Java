import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static long M;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        // S와 E로 나타낼 수 있다
        N = Integer.parseInt(br.readLine());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean[][] dp = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            dp[i][i] = true; // 한자리는 다 가능
            // dp[0][0]]
            // dp[0][1] -> dp[0][0] && arr[1] == arr[2]
            // dp[0][2] -> d[1][1] && arr[0] == arr[2]
            // dp[0][3] => d[1][2] && arr[0] == arr[3]
        }

        // len ==2
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        // len >= 3
        for (int len = 3; len <= N; len++) {

            // dp[0][]
            for (int s = 0; s <= N - len; s++) {
                int e = s + len - 1;

                if (arr[s] == arr[e] && dp[s + 1][e - 1]) {
                    dp[s][e] = true;
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int lt = Integer.parseInt(st.nextToken()) - 1;
            int rt = Integer.parseInt(st.nextToken()) - 1;

            if (dp[lt][rt]) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        // 세그트리론 안 되나?

        // 한 점에서 모든 선분을 한 번씩 지나서 출발점으로 되돌아옴

        // bw.write(Arrays.toString(search(arr)) + "");
        // bw.write(order + "");
        bw.flush();

    }

    public static boolean isP(int lt, int rt) {

        // dp[lt][rt] = dp[lt+1][rt-1] && (arr[lt] == arr[rt])

        return true;
    }

}
