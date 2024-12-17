import java.io.*;

import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M, K;
    static long[] arr, tree, lazy;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 기존 세그먼트 트리에서 Lazy 배열을 추가한다
        // Lazy: 각 노드에 더해져야 할 값들을 저장, 탐색 시에 저장된 값을 전파시킴

        arr = new long[N];
        tree = new long[4 * N];
        lazy = new long[4 * N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 시작Idx, {arr범위}
        make(1, 0, N - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            // long 범위 안에서 주어짐
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken()) - 1;
            long c = Long.parseLong(st.nextToken()) - 1;

            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                // b~c 변경하기
                // change
                changeLazy(1, 0, N - 1, b, c, d);
            } else {
                // b~c 합 구하기
                // getSum

                long result = getSum(1, 0, N - 1, b, c);
                bw.write(result + "\n");
            }

        }

        bw.flush();
    }

    static void lazy(int idx, long sIdx, long eIdx) {
        if (lazy[idx] == 0) {
            // 더할 값이 없으므로 탈출
            return;
        }

        // 리프 노드의 개수 : eIdx - sIdx + 1
        // 리프 노드의 개수만큼 일괄 변경값을 더해주기
        tree[idx] += (eIdx - sIdx + 1) * lazy[idx];

        // 하위 노드에 lazy 값 전파
        if (sIdx != eIdx) {
            lazy[2 * idx] += lazy[idx];
            lazy[2 * idx + 1] += lazy[idx];
        }

        lazy[idx] = 0; // 적용 완료 표시
    }

    static long getSum(int idx, int lt, int rt, long sIdx, long eIdx) {

        lazy(idx, lt, rt); // 해당 범위에 존재하는 lazy 적용 (change에서 남긴 거)

        if (lt > eIdx || rt < sIdx) {
            return 0;
        }

        if (lt >= sIdx && rt <= eIdx) {
            // 찾고자 하는 구역 안이라면
            return tree[idx];
        }

        int mid = lt + (rt - lt) / 2;
        long lTree = getSum(2 * idx, lt, mid, sIdx, eIdx);
        long rTree = getSum(2 * idx + 1, mid + 1, rt, sIdx, eIdx);

        return lTree + rTree;
    }

    static void changeLazy(int idx, int lt, int rt, long sIdx, long eIdx, long w) {

        lazy(idx, lt, rt); // 해당 범위에 존재하는 가중치 적용 적용

        if (lt > eIdx || rt < sIdx) {
            return; // 바꿀 범위가 아닐 경우.
        }

        if (lt >= sIdx && rt <= eIdx) {
            // 하위 노드에 변경시킬 가중치를 예지해주고 일단 끝냄
            lazy[idx] += w;
            lazy(idx, lt, rt);
            return;
        }

        int mid = lt + (rt - lt) / 2;
        changeLazy(2 * idx, lt, mid, sIdx, eIdx, w);
        changeLazy(2 * idx + 1, mid + 1, rt, sIdx, eIdx, w);

        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }

    // static long changeLazy(int idx, int lt, int rt, long sIdx, long eIdx, long w)
    // {

    // lazy(idx, lt, rt); // 해당 범위에 존재하는 가중치 적용 적용

    // if (lt == rt) {
    // return tree[idx];
    // }

    // if (lt > eIdx || rt < sIdx) {
    // return tree[idx]; // 바꿀 범위가 아닐 경우.
    // }

    // if (lt >= sIdx && rt <= eIdx) {
    // // 하위 노드에 변경시킬 가중치를 예지해주고 일단 끝냄
    // if (sIdx != eIdx) {
    // lazy[2 * idx] += w;
    // lazy[2 * idx + 1] += w;
    // }
    // return tree[idx] += (eIdx - sIdx + 1) * w;
    // }

    // int mid = lt + (rt - lt) / 2;
    // long lSum = changeLazy(2 * idx, lt, mid, sIdx, eIdx, w);
    // long rSum = changeLazy(2 * idx + 1, mid + 1, rt, sIdx, eIdx, w);

    // return tree[idx] = lSum + rSum;
    // }

    static void make(int idx, int lt, int rt) {

        if (lt == rt) {
            tree[idx] = arr[lt];
            return;
        }

        int mid = lt + (rt - lt) / 2;
        make(2 * idx, lt, mid);
        make(2 * idx + 1, mid + 1, rt);

        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }
}
