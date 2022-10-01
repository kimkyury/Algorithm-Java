import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {

    int data;
    Node right;
    Node left;

    public Node(int data) {
        this.data = data;
        this.right = left = null;
    }
}

class Main {

    private int N;
    private int arr[];

    // L이란 원소를 사용한다 vs 사용 안 한다
    public void BFS(Node node) {

        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        int L = 0;
        while (!q.isEmpty()) { // 비어있지 않을 때
            int len = q.size(); // 1
            System.out.print(L + ": ");

            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                System.out.print(cur.data + " ");

                if (cur.left != null)
                    q.offer(cur.left);

                if (cur.right != null)
                    q.offer(cur.right);

            }
            L++;
            System.out.println();
        }
    }

    Node head;

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        main.N = Integer.parseInt(st.nextToken());
        main.arr = new int[main.N + 1];

        main.head = new Node(1);

        main.head.left = new Node(2);
        main.head.right = new Node(3);

        main.head.left.right = new Node(4);
        main.head.left.left = new Node(5);

        main.head.right.right = new Node(6);
        main.head.right.left = new Node(7);

        main.BFS(main.head);

    }
}