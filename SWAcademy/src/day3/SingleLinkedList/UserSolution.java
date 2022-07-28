package day3;

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class UserSolution {

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;

    // 정적할당
    public Node getNode(int data) { // new_node
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() { // init()
        head = null;
        nodeCnt = 0;
    }

    public void addNode2Head(int data) { // insert()

        Node newNode = getNode(data);

        if (head != null)
            newNode.next = head;

        head = newNode;
    }

    public void addNode2Tail(int data) {

        Node newNode = getNode(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node preNode = head;

        while (preNode.next != null) {
            preNode = preNode.next;
        }

        preNode.next = newNode;
    }

    public void addNode2Num(int data, int num) {

        if (num == 1)
            addNode2Head(data);
        else {
            Node newNode = getNode(data); // newNode.data =2, newNode.next = null
            Node preNode = head;

            if (num != 2) {
                for (int i = 0; i < num - 2; i++)
                    preNode = preNode.next;
            }

            if (preNode.next != null)
                newNode.next = preNode.next;
            preNode.next = newNode;

        }
    }

    // 주어진 data값 삭제
    public void removeNode(int data) { // remove()
        Node preNode = head;
        Node target;

        if (preNode.data == data) {
            target = preNode;
            head = preNode.next;
            preNode = null;
            nodeCnt--;
            return;
        } else {
            while (preNode.next != null && preNode.next.data != data) {
                preNode = preNode.next;
            }
            if (preNode.next == null)
                return;
            else {
                target = preNode.next;
            }
        }

        preNode.next = target.next;
        target = null;
        nodeCnt--;

    }

    public int getList(int[] output) {
        Node cur = head;

        int cnt = 0;
        // cur이 할당되는 게 없으면 탈출
        while (cur != null) {
            output[cnt++] = cur.data;
            cur = cur.next;
        }

        return nodeCnt;
    }
}