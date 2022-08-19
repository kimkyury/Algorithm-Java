package day4;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */

class Node {
    private int idx;
    private String data;
    private Node left;
    private Node right;

    public Node(int idx) {
        this.idx = idx;
        this.data = " ";
        this.left = null;
        this.right = null;
    }

    public Node(int idx, String data) {
        this.idx = idx;
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public String getData() {
        return this.data;
    }

    public int getIdx() {
        return this.idx;
    }

}

class ArtimeticOperation2 {

    private static Node root;

    public static double inOrder(Node node) {

        double result = 0;
        Node leftNode = null;
        Node rightNode = null;

        double leftData = 0;
        double rightData = 0;

        // 최하위 좌측말단노드.data 찾기
        if (node.getLeft().getLeft() == null) {
            leftNode = node.getLeft();
            leftData = Double.parseDouble(leftNode.getData());
        } else {
            leftData = inOrder(node.getLeft());
        }

        // 최하위 우측말단노드.data 찾기
        if (node.getRight().getLeft() == null) {
            rightNode = node.getRight();
            rightData = Double.parseDouble(rightNode.getData());
        } else {
            rightData = inOrder(node.getRight());
        }

        String operation = node.getData();
        if (operation.equals("*")) {
            result = leftData * rightData;
        } else if (operation.equals("/")) {
            result = leftData / rightData;
        } else if (operation.equals("-")) {
            result = leftData - rightData;
        } else if (operation.equals("+")) {
            result = leftData + rightData;
        }

        return result;

    }

    // idx를 가진 노드에 data를 집어넣고, 그 아이의 left와 right를 지정해줄 것이다
    public static void insert(int idx, String data, int leftIndex, int rightIndex) {
        if (root == null) {
            root = new Node(idx, data);
            if (leftIndex != 0)
                root.setLeft(new Node(leftIndex));
            if (rightIndex != 0)
                root.setRight(new Node(rightIndex));
        } else {
            searchForInsert(root, idx, data, leftIndex, rightIndex);
        }
    }

    public static void searchForInsert(Node node, int idx, String data, int leftIndex, int rightIndex) {
        if (node.getIdx() == idx) {
            node.setData(data);
            // data는 없는 빈 노드를 삽입해준다
            if (leftIndex != 0)
                node.setLeft(new Node(leftIndex));
            if (rightIndex != 0)
                node.setRight(new Node(rightIndex));
        } else {
            if (node.getLeft() != null)
                searchForInsert(node.getLeft(), idx, data, leftIndex, rightIndex);
            if (node.getRight() != null)
                searchForInsert(node.getRight(), idx, data, leftIndex, rightIndex);
        }
    }

    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("res/day4/cInput.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            root = null;

            int N = Integer.parseInt(sc.nextLine());
            String data;
            int leftIdx, rightIdx;

            StringTokenizer st;
            for (int i = 1; i <= N; i++) {
                leftIdx = 0;
                rightIdx = 0;

                st = new StringTokenizer(sc.nextLine());
                st.nextToken();

                data = st.nextToken();

                if (st.hasMoreTokens()) {
                    leftIdx = Integer.parseInt(st.nextToken());
                    rightIdx = Integer.parseInt(st.nextToken());
                }

                insert(i, data, leftIdx, rightIdx);
            }

            System.out.print("#" + test_case + " ");
            System.out.print((int) inOrder(root));
            System.out.println();
        }

    }
}
