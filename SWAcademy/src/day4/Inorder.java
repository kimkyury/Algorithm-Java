package day4;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */

class Node {
    int key;
    String value;
    Node left;
    Node right;

    public Node(int x, String value) {
        this.key = x;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class Inorder {

    private final static int MAX_NODE = 10000;
    private static int nodeCnt;
    private static Node[] node = new Node[MAX_NODE];
    private static Node head;

    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("res/day4/aInput.txt"));

        /*
         * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
         */
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
        /*
         * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
         */

        for (int test_case = 1; test_case <= T; test_case++) {
            boolean hasLeftChildren = false, hasRightChildren = false;

            init();
            int vertexCnt = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < vertexCnt; i++) {
                String vertexInfo = sc.nextLine();
                StringTokenizer str = new StringTokenizer(vertexInfo, " ");
                int vertexKey = Integer.parseInt(str.nextToken());
                String vertexValue = str.nextToken();

                int leftChildrenNo, rightChildrenNo;
                if (str.hasMoreTokens()) {
                    leftChildrenNo = Integer.parseInt(str.nextToken());
                    if (str.hasMoreTokens()) {
                        rightChildrenNo = Integer.parseInt(str.nextToken());
                    }
                }

                insert(vertexKey, vertexValue);

            }
            traversal_print(head);
            System.out.println();

        }
    }

    public static void init() {
        head = null;
        nodeCnt = 0;
    }

    public static Node createNode(int x, String value) {
        node[nodeCnt] = new Node(x, value);
        return node[nodeCnt++];
    }

    // Tree에 데이터를 삽입함, ex. node번호 4자리에 O(8)를 집어넣겠다
    public static void insert(int x, String value) {
        head = insertRec(head, x, value);
    }

    //
    public static Node insertRec(Node node, int x, String value) {
        if (node == null) { // 최상위 노드일 때
            return createNode(x, value);
        } else if (x % 2 == 0) {
            node.left = insertRec(node.left, x, value);
        } else if (x % 2 == 1) {
            node.right = insertRec(node.right, x, value);
        }
        return node;
    }

    public static void traversal_print(Node node) {

        if (node == null)
            return;

        traversal_print(node.left);
        System.out.print(node.value);
        traversal_print(node.right);
    }
}