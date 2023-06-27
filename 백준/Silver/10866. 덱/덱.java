import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class MyDeque {

  List<Integer> list;

  // 삽입 삭제가 빨라야함

  MyDeque() {
    list = new LinkedList<Integer>();
  }

  void pushFront(int x) {
    if (list.size() == 0) {
      list.add(x);
      return;
    }
    list.add(0, x);
  }

  void pushBack(int x) {
    list.add(x);
  }

  int popFront() {
    if (list.size() == 0) return -1;
    int removeItem = list.remove(0);
    return removeItem;
  }

  int popBack() {
    if (list.size() == 0) return -1;
    int removeItem = list.remove(list.size() - 1);
    return removeItem;
  }

  int size() {
    return list.size();
  }

  int empty() {
    if (list.size() == 0) return 1; else return 0;
  }

  int front() {
    if (list.size() == 0) return -1;
    return list.get(0);
  }

  int back() {
    if (list.size() == 0) return -1;
    return list.get(list.size() - 1);
  }
}

public class Main {

  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );
  // static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;
  static int N;

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());

    MyDeque mq = new MyDeque();

    boolean flag;
    int result = -10;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      flag = true;
      String command = st.nextToken();

      if (command.equals("push_front")) {
        int pushItem = Integer.parseInt(st.nextToken());
        flag = false;
        mq.pushFront(pushItem);
      } else if (command.equals("push_back")) {
        int pushItem = Integer.parseInt(st.nextToken());
        flag = false;
        mq.pushBack(pushItem);
      } else if (command.equals("pop_front")) {
        result = mq.popFront();
      } else if (command.equals("pop_back")) {
        result = mq.popBack();
      } else if (command.equals("size")) {
        result = mq.size();
      } else if (command.equals("empty")) {
        result = mq.empty();
      } else if (command.equals("front")) {
        result = mq.front();
      } else if (command.equals("back")) {
        result = mq.back();
      }

      if (flag) {
        bw.write(result + "\n");
        // bw.flush();
      }
    }

    bw.flush();
  }

  static void print(boolean[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
  }

  static void print(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
  }

  static void print(int[] arr) {
    System.out.println(Arrays.toString(arr));
  }
}
