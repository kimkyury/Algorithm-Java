import java.io.*;
import java.util.*;
import java.math.*;
import java.time.LocalDate;
import java.util.concurrent.Semaphore;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static long N, M, K;

    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        while (true) {

            st = new StringTokenizer(br.readLine());

            N = (long) Math.pow(Integer.parseInt(st.nextToken()), 2);
            M = (long) Math.pow(Integer.parseInt(st.nextToken()), 2);
            K = (long) Math.pow(Integer.parseInt(st.nextToken()), 2);

            if (N + M + K == 0) {
                break;
            }

            boolean isRightAngle = false;
            if (N == (M + K)) {
                isRightAngle = true;
            } else if (M == (N + K)) {
                isRightAngle = true;
            } else if (K == (N + M)) {
                isRightAngle = true;
            }

            if (isRightAngle) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }

        }

        // bw.write(solve2(subj) + "");
        bw.flush();
    }

    private static void show(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
