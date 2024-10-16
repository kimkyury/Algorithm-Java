import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static int[][] map;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean[] passed;
    static int[] degree;

    public static void main(String[] args) throws IOException {

        // k 광년 이동: k-1, k, k+1년 이동

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int diff = y - x;

            // 거리의 절반지점, 가장 큰 곳
            int max = (int) Math.sqrt(diff);

            int answer;
            if (max == Math.sqrt(diff)) {
                answer = 2 * max - 1;
            } else if (diff > max * max && diff <= max * max + max) {
                answer = 2 * max;
            } else {
                answer = 2 * max + 1;
            }

            // -1, 0, 1 -> 0, 1, 2 -> 1, 2, 3 -> 2, 3, 4
            // 0 -> 1 -> 2 -> 3
            // 1 -> 2 -> 4 -> 5
            // 45 -> 46 -> 48 -> 49 -> 50

            // ( x-y )/ 2 가 어디인지 구하자
            // x ~ (x-y)/2 의 차이를 구하자
            // 1 + 2 + 1 + 1 // 홀수면 그대로, 짝수면 +1ßß
            // 0 1 3 2

            // x ~ (x-y) 까지 가는 데의 수열의 합을 생각해보자
            // 1 + 2 + 3 + 4 + 3 + 2 + 1
            //
            bw.write(answer + "\n");

        }

        bw.flush();
    }
}