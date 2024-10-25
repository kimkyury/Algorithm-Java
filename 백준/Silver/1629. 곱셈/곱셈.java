import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, Q;
    static int[][] map;
    static int minCnt = Integer.MAX_VALUE;

    static int[] dyDiag = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dxDiag = { -2, -1, 1, 2, 2, 1, -1, -2 };

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        bw.write(calculate(A, B, C) + "");
        bw.flush();

    }

    // A^B % C = ( A^(B/2) % C)^2 %C = 16 % 12 = 4
    // 10^11 % 12 = ((10^5) % 12) ^2 % 12 = 16 % 12 = 4
    // 10^5 % 12 = ((10^2) % 12) ^2 % 12 = 100%12 = 4
    // (10^2) % 12 = (10%12 * 10^0 %C ) % 12 = 10 * 1 %12 = 10

    // A: 밑, B:지수

    private static long calculate(long A, long B, long C) {

        if (B == 1) {
            return A % C;
        }

        long half = calculate(A, B / 2, C);

        if (B % 2 == 1) {
            return ((half * half) % C) * A % C;
        }
        return half * half % C;
    }

    public static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > N - 1 || x > M - 1) {
            return true;
        }
        return false;
    }
}