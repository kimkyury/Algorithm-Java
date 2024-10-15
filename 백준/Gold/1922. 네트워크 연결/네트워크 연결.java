import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int cleanCnt;
    private static Map<Character, Integer> cIntMap;
    private static String[] strArr;

    private static int N, M;

    static class Node {

        int d;
        int v;

        Node(int d, int v) {

            this.d = d;
            this.v = v;
        }
    }

    static List<List<Node>> tree;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (s == d)
                continue;
            tree.get(s).add(new Node(d, v));
            tree.get(d).add(new Node(s, v));
        }

        bw.write(bfs() + "");
        bw.flush();
    }

    private static int bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.v - o2.v;
        });

        boolean[] passed = new boolean[N + 1];

        // 나와 연결된 노드들을 넣는다
        passed[1] = true;
        for (Node node : tree.get(1)) {
            pq.offer(node);
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            // pq에서 가져온다

            Node node = pq.poll(); // 현재 V와 가장 가까운 애를 뱉고
            if (passed[node.d])
                continue;

            passed[node.d] = true; // 갔단 표시하고
            sum += node.v;

            for (Node next : tree.get(node.d)) {
                if (passed[next.d])
                    continue;
                pq.offer(next);
            }
        }

        return sum;
    }

    private static void print(boolean[][] passed) {
        System.out.println("-----------------");
        for (int i = 0; i < passed.length; i++) {
            for (int j = 0; j < passed[0].length; j++) {

                if (passed[i][j])
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.println("");
        }
    }
}