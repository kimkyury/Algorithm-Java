import java.io.*;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int N, R, Q;

    private static ArrayList<ArrayList<Integer>> tree;
    private static ArrayList<ArrayList<Integer>> childNodes;
    private static int[] parent;
    private static int[] childCnt;

    public static void main(String[] args) throws IOException {

        // 한 사람의 말이 가로 세로 대각선 3칸을 이으면 게임 끝
        // 두 사람은 각각 X, O 말을 번갈아 놓는다

        // 게임판의 상태가 주어졌을 때, 발생할 수 있는 최종 상태인지 판별하기

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        childNodes = new ArrayList<>();
        parent = new int[N + 1];
        childCnt = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
            childNodes.add(new ArrayList<>());

        }

        int v = 0, u = 0;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            u = Integer.parseInt(st.nextToken());

            tree.get(v).add(u);
            tree.get(u).add(v);

        }

        makeTree(R, -1);

        for (int q = 0; q < Q; q++) {
            int node = Integer.parseInt(br.readLine());
            countChild(node);
            bw.write(childCnt[node] + "\n");
        }
        bw.flush();
    }

    public static void makeTree(int curNode, int pNode) {
        for (int node : tree.get(curNode)) {
            if (node != pNode) {
                childNodes.get(curNode).add(node);
                parent[node] = curNode;
                makeTree(node, curNode);
            }
        }
    }

    public static void countChild(int curNode) {

        if (childCnt[curNode] != 0) {
            return;
        }
        childCnt[curNode] = 1;

        for (int node : childNodes.get(curNode)) {

            countChild(node);
            childCnt[curNode] += childCnt[node];
        }

    }

    public static void show(boolean[][] arr) {
        System.out.println("------------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                if (arr[i][j]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println("");
        }
    }
}