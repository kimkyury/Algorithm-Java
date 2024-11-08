import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static long M;
    // static ArrayList<int[]> app;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] memory = new int[N];
        int[] cost = new int[N];

        for (int i = 0; i < N; i++) {
            int m = Integer.parseInt(st.nextToken());
            memory[i] = m;
        }

        int totalCost = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(st.nextToken());
            cost[i] = c;
            totalCost += c;
            // app.get(i)[1] = cost;
        }

        // dp[cost] : cost로 확보할 수 있는 최대 메모리
        int[] dp = new int[totalCost + 1];

        for (int i = 0; i < N; i++) { // 앱 별로
            for (int j = totalCost; j >= cost[i]; j--) {

                // [이전비용]때의 메모리, [이전비용 - 앱비용]때의 메모리 + 현재앱메모리
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);

            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= totalCost; i++) {
            if (dp[i] >= M) {
                result = Math.min(result, i);
            }
        }

        // subSet(new int[app.size()], 0, 1, 0, 0);
        // 앱마다 m바이트 소모
        // 비활성화

        // ArrayList<int[]> app;
        // 비활성화 후 다시 실행하면 비용 C

        // 10 20 30 35 40
        // .0 .3 .3 .1 .1
        // 1. 비용이 0인 것은 다 꺼본다

        // 2. 남는 것 중에, 조합을 구해본다
        // 3. 해당 조합

        // M개에 대해 완탐?

        // bw.write(Arrays.toString(search(arr)) + "");
        bw.write(result + "");
        bw.flush();

    }

    // public static void subSet(int[] selected, int tIdx, int sIdx, int sumM, int
    // sumCost) {

    // if (sumM >= M) {
    // // System.out.print("sum: " + sumM + ", ");
    // // System.out.println(Arrays.toString(selected));
    // // minCost = Math.min(minCost, sumCost);
    // return;
    // }

    // // if (sIdx == app.size()) {
    // // return;
    // // }

    // selected[tIdx] = sIdx;
    // subSet(selected, tIdx + 1, sIdx + 1, sumM + app.get(sIdx - 1)[0], sumCost +
    // app.get(sIdx - 1)[1]);
    // selected[tIdx] = 0;
    // subSet(selected, tIdx, sIdx + 1, sumM, sumCost);
    // }
}
