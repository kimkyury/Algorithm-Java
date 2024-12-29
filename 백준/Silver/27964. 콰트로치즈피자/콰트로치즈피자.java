import java.io.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, T;
    static StringTokenizer st;
    static long max = 0;
    static int[] tree, arr;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine()); // 10^6

        Set<String> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String next = st.nextToken();

            if (next.endsWith("Cheese")) {
                set.add(next);
            }
        }

        if (set.size() >= 4) {
            bw.write("yummy");
        } else {
            bw.write("sad");
        }

        bw.flush();
    }

}
