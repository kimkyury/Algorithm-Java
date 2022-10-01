import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node rt;
    Node lt;

    Node(int data) {
        this.data = data;
        rt = lt = null;
    }

}

class Main {

    public int BFS(Node node) {
        Queue<Node> Q = new LinkedList<>();

        Q.offer(node);
        int level = 0;
        while (!Q.isEmpty()) {

            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                if (cur.lt == null) {
                    return level;
                } else {
                    Q.offer(cur.lt);
                    if (cur.rt != null) {
                        Q.offer(cur.rt);
                    }
                }
            }

            level++;
        }
        return level;

    }

    Node root;

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        // int x1 = Integer.parseInt(st.nextToken());
        // int x2 = Integer.parseInt(st.nextToken());

        main.root = new Node(1);
        main.root.lt = new Node(2);
        main.root.rt = new Node(3);

        main.root.lt.lt = new Node(4);
        main.root.lt.rt = new Node(5);

        // int answer = main.BFS(x1, x2);

        System.out.println(main.BFS(main.root));
    }
}