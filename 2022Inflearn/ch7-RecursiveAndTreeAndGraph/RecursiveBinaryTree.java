import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {

  int data;
  Node lt;
  Node rt;

  Node(int data) {
    this.data = data;
    lt = null;
    rt = null;
  }
}

class Main {

  Node root;

  public void DFS(Node node) {
    if (node == null) {
      // System.out.print(node.data + " ");
      return;
    }

    DFS(node.lt);
    DFS(node.rt);
    System.out.print(node.data + " ");
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    // int N = Integer.parseInt(st.nextToken());

    Main tree = new Main();
    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);
    tree.root.rt.lt = new Node(6);
    tree.root.rt.rt = new Node(7);

    tree.DFS(tree.root);
    // int C = Integer.parseInt(st.nextToken());

    // int[] poss = new int[N];

    // st = new StringTokenizer(br.readLine());
    // for (int i = 0; i < N; i++) {
    // poss[i] = Integer.parseInt(st.nextToken());
    // }

    // System.out.println(solution(N, C, poss));

  }
}
