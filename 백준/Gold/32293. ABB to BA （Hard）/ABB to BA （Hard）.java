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

            int len = Integer.parseInt(br.readLine());
            String line = br.readLine();

            if (len < 3) {
                bw.write(line + "\n");
                continue;
            }

            // Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < len; i++) {

                // stack.add(line.charAt(i));
                sb.append(line.charAt(i));

                boolean hasABB = false;
                int cnt = 0;
                while (true) {

                    if (sb.length() < 3) {
                        break;
                    }

                    if (sb.charAt(sb.length() - 3) == 'A' &&
                            sb.charAt(sb.length() - 2) == 'B' &&
                            sb.charAt(sb.length() - 1) == 'B') {

                        sb.setLength(sb.length() - 3);
                        sb.append('B');
                        cnt++;
                    } else {
                        break;
                    }
                }

                for (int j = 0; j < cnt; j++) {
                    sb.append('A');
                }
            }

            bw.write(sb.toString() + "\n");
        }

        // st = new StringTokenizer(br.readLine());

        bw.flush();

    }

    static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > 1 || x > N - 1) {
            return true;
        }
        return false;

    }
}
