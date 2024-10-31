import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M, R;

    static int[] d;
    static int[] order;
    static List<List<Integer>> arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        d = new int[N + 1];
        order = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
            d[i] = -1;
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            arr.get(v1).add(v2);
            arr.get(v2).add(v1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr.get(i));
        }

        BFS();

        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += (long) d[i] * order[i];
        }

        bw.write(sum + "");
        bw.flush();

    }

    public static void BFS() {

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(R);

        int depth = 0;
        int cnt = 1;
        d[R] = depth++;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                order[cur] = cnt++;
                for (int child : arr.get(cur)) {
                    if (d[child] != -1) {
                        continue;
                    }
                    d[child] = depth;
                    q.offer(child);
                }
            }
            depth++;
        }
    }

    public static void print(int map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
