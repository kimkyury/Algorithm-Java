import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M, T;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        // st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(br.readLine());
        // M = Integer.parseInt(st.nextToken());

        // 1 -> 상근
        // 2 -> 1, 창영
        // 3 -> 상근
        // 4 -> 1, 창영 || 3, 창영
        // 5 -> 상근1, 창영3, 상근1
        // 6 -> 상근3, 창영 ||

        if (N % 2 == 0) {
            bw.write("CY");
        } else {
            bw.write("SK");
        }

        bw.flush();

    }

    static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > 1 || x > N - 1) {
            return true;
        }
        return false;

    }
}
