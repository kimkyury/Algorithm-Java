import java.io.*;

import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M, K;
    static long[] arr, tree;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 교체 수
        K = Integer.parseInt(st.nextToken()); // 구간합 구하는 수

        tree = new long[4 * N];
        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            // make
        }

        // tree의 1부터 채워나간다
        make(0, N - 1, 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                // 교체
                // b번째를 c로 바꾼다

                // change
                // b-1
                // arr의 0~(N-1) 구역 중에서 (b-1) 번째 값을 바꾼다
                change(1, 0, N - 1, b - 1, c);
            } else {
                // 합 구하기
                // getSum
                bw.write(getSum(1, 0, N - 1, b - 1, c - 1) + "\n");
            }

        }

        bw.flush();
    }

    static long getSum(int idx, int lt, int rt, int sIdx, long eIdx) {
        // lt, rt : 포인터
        // sIdx, eIdx: 원하는 합 구간

        if (lt > eIdx || rt < sIdx) {
            return 0;
        }

        if (lt >= sIdx && rt <= eIdx) {
            return tree[idx];
        }

        int mid = lt + (rt - lt) / 2;
        long lTree = getSum(2 * idx, lt, mid, sIdx, eIdx);
        long rTree = getSum(2 * idx + 1, mid + 1, rt, sIdx, eIdx);

        return lTree + rTree;
    }

    static void change(int idx, int lt, int rt, int tIdx, long v) {
        // arr[b]를 찾아 c로 바꾼다
        // 바꾸면서 tree도 갱신해준다

        if (lt == rt) {
            tree[idx] = v;
            return;
        }

        int mid = lt + (rt - lt) / 2;
        if (tIdx <= mid) {
            // 변경시킬 arr의 idx(tIdx)의 수색 범위 좁히기
            change(2 * idx, lt, mid, tIdx, v);
        } else {
            change(2 * idx + 1, mid + 1, rt, tIdx, v);
        }

        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }

    static void make(int lt, int rt, int idx) {
        // lt ,rt 합
        // leaf에 오면 해당 값 넣기
        if (lt == rt) {
            // System.out.println(lt);
            tree[idx] = arr[lt];
            return;
        }
        int mid = lt + (rt - lt) / 2;

        make(lt, mid, 2 * idx);
        make(mid + 1, rt, 2 * idx + 1);

        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }
}
