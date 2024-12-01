import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // static StringTokenizer st;

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < K; i++) {
            int next = Integer.parseInt(br.readLine());

            if (next == 0) {
                st.pop();
            } else {
                st.push(next);
            }
        }

        int sum = 0;
        while (!st.isEmpty()) {
            sum = sum + st.pop();
        }
        bw.write(sum + "");
        bw.flush();
    }

    static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > 1 || x > N - 1) {
            return true;
        }
        return false;

    }
}
