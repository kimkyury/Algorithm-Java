import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int heap[] = new int[1500 * 1500];
  static int heapSize = 0; // heap's Actural Size
  static int N;

  public static void solve() {}

  public static void offer(int num) {
    int tmpIndex = heapSize; // last Index
    heap[tmpIndex] = num; // input to lastIndex

    // 적절한 곳에 위치할 때까지 bottom -> top
    // value의 비교가 Condition
    // 가장 작은 값이 위로 올라오도록 만들자 : minHeap
    while (tmpIndex > 0 && heap[tmpIndex] < heap[(tmpIndex - 1) / 2]) {
      // switch pos
      int tmpValue = heap[tmpIndex];
      heap[tmpIndex] = heap[(tmpIndex - 1) / 2];
      heap[(tmpIndex - 1) / 2] = tmpValue;

      tmpIndex = (tmpIndex - 1) / 2;
    }

    heapSize++;
  }

  public static int poll() {
    // delete
    int tmpIndex = 0;
    int rootValue = heap[tmpIndex];
    heapSize--;

    //이번에는 top -> bottom, 최하위 leaf를 최상단으로 move
    heap[tmpIndex] = heap[heapSize]; // 삭제로 인한 Size감소 -> outofIndex 탈출

    // 현재 level, 그 아래 level이 허용범위인지 확인
    while (tmpIndex < heapSize && tmpIndex * 2 + 1 < heapSize) {
      int childIndex;

      // rightNode 없으면 예외처리
      if (tmpIndex * 2 + 2 >= heapSize) childIndex = tmpIndex * 2 + 1;
      // switch more smaller
      else childIndex =
        (heap[tmpIndex * 2 + 1] < heap[tmpIndex * 2 + 2])
          ? tmpIndex * 2 + 1
          : tmpIndex * 2 + 2;
      if (heap[tmpIndex] < heap[childIndex]) break;

      // switching
      int childValue = heap[tmpIndex];
      heap[tmpIndex] = heap[childIndex];
      heap[childIndex] = childValue;

      tmpIndex = childIndex;
    }

    return rootValue;
  }

  public static void Show() {
    System.out.println("!---- 최종 결과물--------");
    for (int i = 0; i < heapSize; i++) {
      System.out.print(heap[i] + " ");
    }
    System.out.println("\n----------------------");
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    // 초기 개수 채우기
    for (int i = 0; i < N; i++) offer(Integer.parseInt(st.nextToken()));

    // queue의 크기를 유지하기, 가장 작은 값은 remove
    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        offer(Integer.parseInt(st.nextToken()));
        poll();
      }
    }
    //Show();

    System.out.print(poll());
  }
}
