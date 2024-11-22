import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;

    static int[] heap;
    static StringBuilder sb = new StringBuilder();

    static int DIVIDE = 1000;
    static int[][] result;
    static int max = 0;

    static int[] arr;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        combi(0, 0, 0, new boolean[N]);
        bw.write(max + "");
        bw.flush();
    }

    private static void combi(int tIdx, int sum, int cnt, boolean[] selected) {

        if (sum > M) {
            return;
        }

        if (cnt == 3) {
            max = Math.max(max, sum);
            return;
        }

        if (tIdx == N) {
            return;
        }

        selected[tIdx] = true;
        combi(tIdx + 1, sum + arr[tIdx], cnt + 1, selected);
        selected[tIdx] = false;
        combi(tIdx + 1, sum, cnt, selected);
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
