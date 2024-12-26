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

        N = Integer.parseInt(br.readLine());

        // 2개 run, 5개 trick

        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int maxRun = 0;
            for (int j = 0; j < 2; j++) {
                maxRun = Math.max(maxRun, Integer.parseInt(st.nextToken()));

            }

            PriorityQueue<Integer> pq = new PriorityQueue<>(
                    (o1, o2) -> o2 - o1);
            for (int j = 0; j < 5; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }

            max = Math.max(max, maxRun + pq.poll() + pq.poll());

        }

        bw.write(max + "");
        bw.flush();
    }

}
