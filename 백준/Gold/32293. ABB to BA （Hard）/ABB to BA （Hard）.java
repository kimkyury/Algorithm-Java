import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M, T;

    static List<List<Integer>> tree;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        // st = new StringTokenizer(br.readLine());
        // N = Integer.parseInt(st.nextToken());
        // M = Integer.parseInt(st.nextToken());

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            // Stack 문제

            int len = Integer.parseInt(br.readLine());
            String line = br.readLine();

            if (len < 3) {
                bw.write(line + "\n");
                continue;
            }

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < len; i++) {

                stack.add(line.charAt(i));

                boolean hasABB = false;
                int cnt = 0;
                while (true) {

                    if (stack.size() < 3) {
                        break;
                    }

                    char c3 = stack.pop();
                    if (c3 != 'B') {
                        stack.add(c3);
                        break;
                    }

                    char c2 = stack.pop();
                    if (c2 != 'B') {
                        stack.add(c2);
                        stack.add(c3);
                        break;
                    }

                    char c1 = stack.pop();
                    if (c1 != 'A') {
                        stack.add(c1);
                        stack.add(c2);
                        stack.add(c3);
                        break;
                    }

                    cnt++;
                    stack.add('B');
                }

                for (int j = 0; j < cnt; j++) {
                    stack.add('A');
                }
            }

            StringBuilder sb = new StringBuilder();
            while (stack.size() != 0) {
                sb.insert(0, stack.pop());
            }

            bw.write(sb.toString() + "\n");
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
