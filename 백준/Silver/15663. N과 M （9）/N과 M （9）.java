import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;
    static int[][] tree;
    static int[] arr;

    static Set<String> set;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // 선택된 수의 합이 최대가 되는 경로를 구하기

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        set = new HashSet<>();

        perpum(0, new boolean[N], M, new StringBuilder());

        bw.write(sb.toString() + "");
        bw.flush();
    }

    private static void perpum(int tIdx, boolean[] selected, int cnt, StringBuilder sb2) {

        if (cnt == 0) {

            String result = sb2.toString().trim();
            if (!set.contains(result)) {
                set.add(result);
                sb.append(result).append("\n");
            }
            return;
        }

        if (tIdx == N) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (selected[i]) {
                continue;
            }

            selected[i] = true;
            perpum(tIdx + 1, selected, cnt - 1, new StringBuilder(sb2.toString()).append(" ").append(arr[i]));

            selected[i] = false;
        }
    }

    private static void show(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
