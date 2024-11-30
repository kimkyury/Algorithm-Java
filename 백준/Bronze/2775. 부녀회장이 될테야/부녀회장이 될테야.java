import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        // a층 b호: 아랫 열의 1호~b호 합
        // k층 n호엔 몇명?

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int sum = 0;
            int[][] arr = new int[k][n + 1];

            for (int i = 0; i < n + 1; i++) {
                arr[0][i] = i; // 초기
            }

            for (int i = 1; i < k; i++) {
                for (int j = 0; j < n + 1; j++) {

                    for (int l = 0; l <= j; l++) {
                        arr[i][j] += arr[i - 1][l];
                    }
                }
            }

            for (int i = 0; i < n + 1; i++) {
                sum += arr[k - 1][i];
            }

            bw.write(sum + "\n");

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
