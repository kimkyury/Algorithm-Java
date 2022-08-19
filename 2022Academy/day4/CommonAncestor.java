package day4;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/

class Node {
    int data;
    int parentData;
    int child1Data;
    int child2Data;

    public Node(int data) {
        this.data = data;
        this.parentData = 0;
        this.child1Data = 0;
        this.child2Data = 0;
    }

}

class CommonAncestor {

    static int cntV, cntE, v1, v2;
    static ArrayList<Integer> parentsHave;
    static int commonAncestor, subSize;
    static Node nodes[];

    public static void getSize(int node) {
        subSize++;

        int left = nodes[node].child1Data;
        int right = nodes[node].child2Data;

        if (left != 0 && right != 0) {
            getSize(left);
            getSize(right);
        } else if (left != 0)
            getSize(left);
        else if (right != 0)
            getSize(right);
    }

    public static void find(int node) {
        int parent = nodes[node].parentData;

        if (parent == 0 || commonAncestor != 0)
            return;

        if (parentsHave.contains(parent))
            commonAncestor = parent;
        else
            parentsHave.add(parent);

        find(parent);
    }

    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("res/day4/dInput.txt"));
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        StringTokenizer st;
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(sc.nextLine());

            cntV = Integer.parseInt(st.nextToken()); // 13
            cntE = Integer.parseInt(st.nextToken()); // 12
            v1 = Integer.parseInt(st.nextToken()); // 8
            v2 = Integer.parseInt(st.nextToken()); // 13

            nodes = new Node[cntV + 1];
            parentsHave = new ArrayList<>();
            commonAncestor = 0;
            subSize = 0;

            for (int i = 1; i <= cntV; i++) {
                nodes[i] = new Node(i);
            }

            st = new StringTokenizer(sc.nextLine());
            for (int i = 0; i < cntE; i++) {
                int ancestor = Integer.parseInt(st.nextToken()); // 1
                int descendant = Integer.parseInt(st.nextToken()); // 2

                if (nodes[ancestor].child1Data == 0)
                    nodes[ancestor].child1Data = descendant;
                else
                    nodes[ancestor].child2Data = descendant;
                nodes[descendant].parentData = ancestor;

            }

            find(v1);
            find(v2);
            getSize(commonAncestor);

            System.out.println("#" + test_case + " " + commonAncestor + " " + subSize);

        }
    }
}
