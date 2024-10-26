import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;
    static int[] tree, arr;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        tree = new int[4 * N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        make(1, 0, N - 1); // 첫 노드는 0부터 N-1범위에 대한 최솟값 정보를 가짐

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sIdx = Integer.parseInt(st.nextToken()) - 1;
            int eIdx = Integer.parseInt(st.nextToken()) - 1;

            int result = getMin(1, 0, N - 1, sIdx, eIdx);

            bw.write(result + "\n");
        }

        // a 부터 b 까지 제일 작은 정수를 찾기
        // 세그먼트 트리를 통해, tree에 arr의 범위 내에서 최솟값을 저장해놓도록 한다

        bw.flush();
    }

    static int getMin(int idx, int lt, int rt, int sIdx, int eIdx) {

        // 범위 초과 여부 판단
        if (rt < sIdx || lt > eIdx) {
            return Integer.MAX_VALUE;
        }

        if (sIdx <= lt && rt <= eIdx) {
            // 해당 범위 내의 결과값이라면
            return tree[idx];
        }

        int mid = lt + (rt - lt) / 2;

        int lTree = getMin(2 * idx, lt, mid, sIdx, eIdx);
        int rTree = getMin(2 * idx + 1, mid + 1, rt, sIdx, eIdx);

        return lTree < rTree ? lTree : rTree;
    }

    static void make(int idx, int lt, int rt) {

        if (lt == rt) {
            // 본인을 가리키도록
            tree[idx] = arr[lt];
            return;
        }

        int mid = lt + (rt - lt) / 2;

        make(2 * idx, lt, mid);
        make(2 * idx + 1, mid + 1, rt);

        // 더 작은 값을 선택
        tree[idx] = tree[2 * idx] < tree[2 * idx + 1] ? tree[2 * idx] : tree[2 * idx + 1];
    }
}
