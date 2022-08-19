package day3.DoubleLinkedList;

class Node {
    public int data;
    public Node prev;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class UserSolution {

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        nodeCnt = 0;
        head = null;
    }

    public void addNode2Head(int data) { // 1
        Node newNode = getNode(data);
        Node curNode;

        if (head != null) {
            curNode = head;
            newNode.next = curNode;
            curNode.prev = newNode;
            newNode.next.prev = newNode;
        }

        head = newNode;

    }

    public void addNode2Tail(int data) { // 2

        Node newNode = getNode(data);
        Node preNode;

        preNode = head;

        while (preNode.next != null) {
            preNode = preNode.next;
        }

        preNode.next = newNode;
        newNode.prev = preNode;
    }

    public void addNode2Num(int data, int num) { // 3
        if (num == 1) {
            addNode2Head(data);
            return;
        }

        Node newNode = getNode(data);
        Node preNode;

        preNode = head;
        if (num != 2) {
            for (int i = 0; i < num - 2; i++) {
                preNode = preNode.next;
            }
        }

        if (preNode.next != null) {
            newNode.next = preNode.next;
            newNode.next.prev = newNode;
        }
        preNode.next = newNode;
        newNode.prev = preNode;
    }

    public int findNode(int data) { // 4
        Node preNode = head;
        Node target;

        int cnt = 1;
        if (preNode.data == data) {
            return cnt;
        }

        while (preNode.next != null && preNode.next.data != data) {
            cnt++;
            preNode = preNode.next;
        }
        if (preNode.next == null) {
            return 0; // 찾는 데이터 없음
        }

        cnt++;
        return cnt;
    }

    public void removeNode(int data) { // 5
        Node preNode = head;
        Node target;

        if (preNode.data == data) {
            target = preNode;
            head = preNode.next;
            target = null;
            nodeCnt--;
            return;
        }

        while (preNode.next != null && preNode.next.data != data) {
            preNode = preNode.next;
        }
        if (preNode.next == null) {
            return;
        } else {
            target = preNode.next;
        }

        if (target.next == null) {
            preNode.next = null;
            target = null;
            nodeCnt--;
            return;
        }
        preNode.next = target.next;
        target.next.prev = preNode;

        target = null;
        nodeCnt--;

    }

    public int getList(int[] output) { // 6

        Node curNode = head;

        int i = 0;
        while (curNode != null) {
            output[i++] = curNode.data;
            curNode = curNode.next;
        }

        return nodeCnt;
    }

    // 역순 저장하고 리턴
    public int getReversedList(int[] output) { // 7
        Node curNode = head;

        int i = nodeCnt - 1;

        while (curNode != null) {
            output[i--] = curNode.data;
            curNode = curNode.next;
        }

        return nodeCnt;
    }
}