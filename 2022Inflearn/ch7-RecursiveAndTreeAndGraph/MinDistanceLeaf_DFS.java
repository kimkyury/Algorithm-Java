import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    int min = Integer.MAX_VALUE;
    int cnt[] = new int[5];

    public int DFS(int level, Node node) {

        if (node.lt == null && node.rt == null) {
            return level;
        }

        Math.min(DFS(level + 1, node.lt), DFS(level + 1, node.rt));

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

        System.out.println(main.DFS(0, main.root));
    }
}