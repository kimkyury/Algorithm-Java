import java.io.*;

import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, T;
    static StringTokenizer st;

    static boolean[] isLeft;

    // static List<Integer> arr;
    static ArrayDeque<Integer> dq;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int t = 0; t < T; t++) {
            int num = Integer.parseInt(st.nextToken());

            int tgt = -1;
            for (int n = 0; n < num; n++) {
                if (n == num - 1) {
                    tgt = q.peek();
                    continue;
                }
                tgt = q.poll();
                q.offer(tgt);
            }

            bw.write(tgt + " ");
        }

        bw.flush();
    }

}
