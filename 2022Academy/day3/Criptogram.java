package day3;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

class CriptogramNode {
    public int data;
    public CriptogramNode prev;
    public CriptogramNode next;

    public CriptogramNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class Ciptogram {

    private final static int MAX_NODE = 30000;
    private static CriptogramNode[] node = new CriptogramNode[MAX_NODE];
    private static CriptogramNode head;
    private static int nodeCnt;

    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("res/day3/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            String printTestNumber = "#" + test_case + " ";
            // 수정된 암호문의 앞에서부터 10개 항 출력
            init();

            int N = Integer.parseInt(sc.nextLine());
            System.out.println("\n원본암호문의 길이: " + N);

            String criptogram = sc.nextLine(); // 원본 암호문
            insert(0, N, criptogram);

            int M = Integer.parseInt(sc.nextLine());
            String commands = sc.nextLine();
            StringTokenizer commandTokens = new StringTokenizer(commands, " ");

            int x;
            int y;

            for (int i = 0; i < M; i++) {
                String cmd = commandTokens.nextToken();

                switch (cmd) {
                    case "I":
                        x = Integer.parseInt(commandTokens.nextToken());
                        y = Integer.parseInt(commandTokens.nextToken());

                        criptogram = "";
                        for (int j = 0; j < y; j++) {
                            criptogram += commandTokens.nextToken();
                            criptogram += " ";
                        }

                        insert(x, y, criptogram);
                        break;

                    case "D":
                        x = Integer.parseInt(commandTokens.nextToken());
                        y = Integer.parseInt(commandTokens.nextToken());
                        delete(x, y);
                        break;

                    case "A":
                        y = Integer.parseInt(commandTokens.nextToken());

                        criptogram = "";
                        for (int j = 0; j < y; j++) {
                            criptogram += commandTokens.nextToken();
                            criptogram += " ";
                        }

                        add(y, criptogram);
                        break;

                }

            }

            System.out.print(printTestNumber + " ");
            print();

        }
    }

    public static CriptogramNode createNode(int data) {
        node[nodeCnt] = new CriptogramNode(data);
        return node[nodeCnt++];
    }

    public static void init() {
        nodeCnt = 0;
        head = null;
    }

    public static void insert(int x, int y, String criptogram) { // 앞에서부터 x위치 바로 다음에 y개 숫자 삽입
        CriptogramNode preNode = head;
        StringTokenizer criptogramToken = new StringTokenizer(criptogram, " ");
        CriptogramNode newNode;
        int i = 0;
        int j = 0;
        if (x == 0) {
            newNode = createNode(Integer.parseInt(criptogramToken.nextToken()));
            preNode = newNode;
            head = newNode;
            i++;
            j++;
        } else {
            while (i < x - 1) {
                preNode = preNode.next;
                i++;
            }
        }
        while (j < y) {
            newNode = createNode(Integer.parseInt(criptogramToken.nextToken()));
            newNode.prev = preNode;
            newNode.next = preNode.next;
            preNode.next = newNode;
            preNode = newNode;
            j++;
        }
    }

    public static void delete(int x, int y) { // 앞에서부터 x위치 바로 다음부터 y개의 숫자 삭제
        CriptogramNode preNode = head;
        int tmp = head.data;
        CriptogramNode target;

        int j = 0;
        try {
            while (j < x) {
                preNode = preNode.next;
                j++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(preNode.data);
        }

        for (int i = 0; i < y; i++) {
            target = preNode.next;
            preNode.next = target.next;
            target.next.prev = preNode;
            if (preNode.prev == null) {
                head = preNode;
                break;
            }
            preNode = preNode.prev;
        }

    }

    public static void add(int y, String criptogram) { // 맨 뒤에서부터 y개의 숫자 붙이기 ( A, 2 421257 796813 )
        CriptogramNode newNode;
        StringTokenizer criptogramToken = new StringTokenizer(criptogram, " ");
        CriptogramNode preNode = head;
        while (preNode.next != null) {
            preNode = preNode.next;
        }

        for (int i = 0; i < y; i++) {
            newNode = createNode(Integer.parseInt(criptogramToken.nextToken()));
            newNode.prev = preNode;
            newNode.next = preNode.next;
            preNode.next = newNode;
            preNode = newNode;

        }

    }

    public static void print() {

        CriptogramNode node = head;
        for (int i = 0; i < nodeCnt; i++) {
            System.out.print(node.data + " ");

            if (node.next == null) {
                return;
            }
            node = node.next;
        }
    }
}