import java.io.*;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static int N, M;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] vaccDate = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            if (vaccDate[S] == 0) {
                vaccDate[S] = 1;
            }

            if (W >= 7) {
                W++;
            }

            // 순서대로 하는 거라면, 접종 시작일 + 대기시간을 누적해서 적용
            vaccDate[E] = Math.max(vaccDate[S] + W, vaccDate[E]);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = max > vaccDate[i] ? max : vaccDate[i];
        }

        bw.write(max + "");
        bw.flush();
    }

}