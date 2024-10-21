import java.io.*;
import java.util.*;

public class Main {

    // static int N, M;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static char[][] map;
    static int N;

    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };

    static boolean removedRoot = false;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        List<List<int[]>> tree = new ArrayList<>(); // [0]:번호, [1]: 삭제여부
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                root = i;
            } else {
                tree.get(parent).add(new int[] { i, 0 });
            }
        }

        // 삭제할 노드를 찾기 위한 탐색 시작
        int tgt = Integer.parseInt(br.readLine());
        remove(root, tree, tgt);

        // 예외처리 # 루프노드가 리프노드가 되는 경우
        boolean isEnd = false;
        if (tree.get(root).size() == 1) {
            // 자식 노드가 하나인데, 마침 개가 삭제상태라면
            int[] child = tree.get(root).get(0);
            if (child[1] == 1) {
                isEnd = true;
            }
        }

        if (isEnd) {
            bw.write("1");
            bw.flush();
            return;
        }

        if (!removedRoot) {
            int cnt = search(root, tree);
            bw.write(cnt + "");
        } else {
            bw.write("0");
        }

        // 삭제 이후, 리프를 찾는 탐색 시작

        // bw.write(cnt + "");
        bw.flush();
    }

    public static void remove(int root, List<List<int[]>> tree, int tgt) {

        // 루트를 삭제시키는 경우 예외처리
        if (root == tgt) {
            removedRoot = true;
            return;
        }

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] { root, 0 });

        while (!q.isEmpty()) {

            int[] p = q.poll();
            for (int[] child : tree.get(p[0])) {
                if (child[0] == tgt) {
                    child[1] = 1; // 삭제시키공 객체니까 그냥 두공
                    return;
                }
                q.offer(child);
            }
        }
    }

    public static int countChild(List<int[]> childs) {

        int size = 0;

        for (int[] child : childs) {
            if (child[1] == 0) {
                size++;
            }
        }
        return size;
    }

    public static int search(int root, List<List<int[]>> tree) {

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { root, 0 });

        int cnt = 0;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int[] child : tree.get(p[0])) {

                if (child[1] == 1) {

                    continue;
                }

                // 얘가 자식이 없는 앤지 세보기
                if (countChild(tree.get(child[0])) == 0) {
                    cnt++;
                } else {
                    q.offer(child);
                }
            }
        }
        return cnt;
    }

    public static boolean isOver(int y, int x) {
        if (y < 0 || x < 0 || y > N - 1 || x > N - 1) {
            return true;
        }
        return false;
    }

}
