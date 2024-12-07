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

        // N명의 디렉톨
        // 같은 양의 연설
        // 각 스피치는 1시간 간격, K를 넘을 수 없음

        // Output: 각 스피치의 최대시간

        int K = Integer.parseInt(br.readLine());
        if (N == 1) {
            bw.write(K + "");
            bw.flush();
            return;
        }

        int total = K - (N - 1);
        bw.write(total / N + "");

        bw.flush();

    }

    static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > 1 || x > N - 1) {
            return true;
        }
        return false;

    }
}
