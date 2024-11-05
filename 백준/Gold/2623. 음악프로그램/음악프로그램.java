import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;

    static int[] pCnt;
    static List<List<Integer>> tree;

    public static void main(String[] args) throws IOException {

        // 주어진 순서를 조합해내기?
        // 1 4 3
        // 6 2 5 4

        // -> 1 6 2 5 4 3
        // 2 3

        // 각 가수 N에 대하여, 본인의 좌측과 우측을 분류해놓는다
        // 트리 구조로 만들자
        // 1 > 4 > 3
        // 6 >> 2 >> 5 >> 4
        // 2 >> 3

        // 순서가 정해진다 -> 방향그래프
        // 위상정렬..? 왜 위상정렬이지 .. 본인보다 선수행되어야 하는 것을 부모로 넣어야하ㅏㄴ봐'.ㅁㄴㅇㄹㅁㄴㅇ.ㄹ

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N<= 1000
        M = Integer.parseInt(st.nextToken()); // M <= 100

        pCnt = new int[N + 1];
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            int p, c;
            p = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                c = Integer.parseInt(st.nextToken());

                tree.get(p).add(c);
                pCnt[c]++;
                p = c;
            }
        }

        // 부모가 0개인 거 찾기
        List<Integer> root = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (pCnt[i] == 0) {
                root.add(i);
            }
        }

        if (root.size() == 0) {
            bw.write("0");
            bw.flush();
            return;
        }

        List<Integer> order = search(root);

        if (order.size() < N) {
            bw.write("0");
            bw.flush();
            return;
        }

        for (int o : order) {
            bw.write(o + "\n");
        }

        bw.flush();
    }

    public static List<Integer> search(List<Integer> root) {

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] passed = new boolean[N + 1];

        for (int r : root) {
            q.offer(r);
            passed[r] = true;
        }
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                order.add(cur);

                for (int c : tree.get(cur)) {
                    if (passed[c]) {
                        continue;
                    }

                    pCnt[c]--;
                    if (pCnt[c] == 0) {
                        q.offer(c);
                        passed[c] = true;
                    }
                }
            }

        }

        return order;
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
