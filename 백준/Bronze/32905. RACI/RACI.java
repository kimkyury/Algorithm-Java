import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M, T;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // A는 한 번만 나타나야한다

        boolean isNo = false;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            int first = str.indexOf('A');
            int last = str.lastIndexOf('A');

            if (first == -1) {
                isNo = true;
            } else if (first != last) {
                isNo = true;
            }
        }

        if (isNo) {

            bw.write("No");
        } else {
            bw.write("Yes");
        }

        // bw.write(binarySearch() + "");
        bw.flush();

    }

    static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > 1 || x > N - 1) {
            return true;
        }
        return false;

    }
}
