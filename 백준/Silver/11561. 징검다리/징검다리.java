import java.io.*;

import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, T;
    static int arr[];

    public static void main(String[] args) throws IOException {

        // N번 징검다리는 무조건 건너기

        // 2번째점프거리 >= 이전점프거리 +1 여야함
        // N번 징검다리 건넌 후는 자유
        // result: 밟을 수 있는 징검다리의 최대 수

        int T = Integer.parseInt(br.readLine());
        // 피보나치 합 별로 덧셈을 다 구해놓는다면?

        for (int t = 0; t < T; t++) {

            long N = Long.parseLong(br.readLine());

            // -^ : 한 번
            // - -^ : 한 번 (이전보다 더 먼 거리를 건너야 하니까)
            // -^ - -^ : 두 번
            // -^ - - -^ : 두 번
            // -^ - - - -^ : 두번
            // -^ - - - - -^ :

            // 1-> 3-> 6-> 10-> 15 -> 21 -> 28 -> 36 -> 45 -> 55 -> 66 -> 78 (-> 91)->100
            // 피보나치로 나아가다가 N을 넘는다면 카운팅을 멈춘다
            // 등차수열의 합공식 : (k*(k+1)/2) = N -> K기준으로 공식 변경
            long lt = 1, rt = (long) Math.sqrt(2 * N);
            long result = 0;

            while (lt <= rt) {
                long mid = lt + (rt - lt) / 2;
                long sum = mid * (mid + 1) / 2; // 등차수열의 합

                if (sum <= N) {
                    result = mid;
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }

            bw.write(result + "\n");
        }

        bw.flush();
    }
}
