import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    // static int N, M;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static char[][] map;
    static int N, Q;

    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };

    static boolean removedRoot = false;
    static long[] arr, tree;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        tree = new long[4 * arr.length];

        make(1, 0, arr.length - 1);
        // System.out.println(Arrays.toString(tree));

        // System.out.println(Arrays.toString(tree));
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int sIdx = x < y ? x : y;
            int eIdx = x < y ? y : x;
            bw.write(getSum(1, 0, arr.length - 1, sIdx - 1, eIdx - 1) + "\n");
            change(1, 0, arr.length - 1, a - 1, b);
            // System.out.println(Arrays.toString(tree));
        }

        bw.flush();

    }

    private static void change(int idx, int lt, int rt, int tIdx, int tV) {

        if (lt == rt) {
            tree[idx] = tV;
            return;
        }

        int mid = (lt + rt) / 2;
        if (lt <= tIdx && tIdx <= mid) {
            change(2 * idx, lt, mid, tIdx, tV);
        } else {
            change(2 * idx + 1, mid + 1, rt, tIdx, tV);
        }

        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }

    private static long getSum(int idx, int lt, int rt, int sIdx, int eIdx) {

        if (lt > eIdx || rt < sIdx) {
            return 0;
        }

        // 좌인지 우인지 판별
        // 현재 찾는 idx의 lt, rt 정보가 sIdx의 내부라면
        if (lt >= sIdx && rt <= eIdx) {
            return tree[idx];
        }
        int mid = (lt + rt) / 2;

        long lTree = getSum(2 * idx, lt, mid, sIdx, eIdx);
        long rTree = getSum(2 * idx + 1, mid + 1, rt, sIdx, eIdx);

        return lTree + rTree;
    }

    private static void make(int idx, int lt, int rt) {

        if (lt == rt) {
            tree[idx] = arr[lt];
            return;
        }

        int mid = (lt + rt) / 2;

        make(2 * idx, lt, mid);
        make(2 * idx + 1, mid + 1, rt);

        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }
}
