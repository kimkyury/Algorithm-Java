package day4;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */

class Solution {

    static class Node {
        int idx;
        int parentIdx;
        int depth;
        int size;

        ArrayList<Integer> children = new ArrayList<Integer>();

        public Node(int idx, int parentIdx) {
            this.idx = idx;
            this.parentIdx = parentIdx;
            this.depth = 0;
            this.size = 0;
        }

        public void setDepth(int targetDepth) {
            this.depth = countChild(targetDepth);
        }

        public int countChild(int deptargetDepth) {
            int cnt = 1;
            for (int i = 0; i < children.size(); i++) {
                cnt += tree[children.get(i)].countChild(deptargetDepth + 1);
            }
            return cnt;

        }
    }

    static Node[] tree;
    public static Node root;

    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("res/day4/dInput.txt"));

        /*
         * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
         */
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        /*
         * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
         */
        StringTokenizer st;
        int cntV, cntE, v1, v2;
        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(sc.nextLine());
            cntV = Integer.parseInt(st.nextToken());
            cntE = Integer.parseInt(st.nextToken());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());

            // cntV개의 정점을 가지는 Tree 생성하기
            int i = 0;
            while (i < cntE) {
                StringTokenizer st2 = new StringTokenizer(sc.nextLine());
                int parentNodeData = Integer.parseInt(st2.nextToken());
                int childrenNodeData = Integer.parseInt(st2.nextToken());

                insert(parentNodeData, childrenNodeData);
                i++;
            }

            // v1과 v2의 가장 가까운 공통조상 검색하기
            int commonParent = searchCommonParent(v1, v2);
            int sizeOfSubtree = searchSizeofSubtree(commonParent);

            System.out.println("#" + test_case + " " + commonParent + sizeOfSubtree);

        }
    }
}
