import java.io.*;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        // 1~N 중 서로 다른 M개의 수 ^2 , N*(N-1)*...*(N-K)

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long totalCnt = comb(N, M);

        int cnt = 0;
        for (int i = K; i <= M; i++) {

            // K.. M개 일치
            long sameCnt = comb(M, i);
            // 일치하지 않는 수 구하기
            long diffCnt = comb(N - M, M - i);

            // 조합 x 조합
            cnt += sameCnt * diffCnt;
        }

        bw.write(String.valueOf((double) cnt / totalCnt));
        bw.flush();
    }

    public static long comb(int N, int M) {

        long c = 1;
        for (int i = N; i > N - M; i--) { // 8, 7, 6, 5
            c *= i;
        }

        long p = 1;
        for (int i = M; i > 0; i--) {
            p *= i;
        }

        // System.out.println("c:" + c + ", p: " + p);

        return c / p;
    }

    public static void show(boolean[][] arr) {
        System.out.println("------------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                if (arr[i][j]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println("");
        }
    }
}