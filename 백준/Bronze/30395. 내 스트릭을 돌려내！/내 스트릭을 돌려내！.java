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

        // 연속 = 스트릭 x일
        // i일 사용, i+2일에 구매후 장착

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int maxLen = 0;
        int idx = 0;
        int len = 0;
        for (int i = 0; i < N; i++) {

            int n = Integer.parseInt(st.nextToken());
            if (n > 0) {
                len++;
                maxLen = Math.max(len, maxLen);
            }

            else if (n == 0) {
                if ((i == 1 && idx == 0) || i - idx >= 2) {

                    idx = i;
                    maxLen = Math.max(len, maxLen);
                } else {
                    len = 0;
                }
            }
        }

        bw.write(maxLen + "");
        bw.flush();
    }
}