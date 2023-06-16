import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

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
  static int M;
  static int k;

  static int[] parents;
  static boolean[] isPassed;
  static int[][] costs;
  static int min = Integer.MAX_VALUE;

  static boolean flag = false;

  static void union(int a, int b) {
    int parentA = find(a);
    int parentB = find(b);

    if (parentA != parentB) {
      if (parentA < parentB) {
        parents[parentB] = parentA;
      } else {
        parents[parentA] = parentB;
      }
    }
  }

  static int find(int a) {
    if (a == parents[a]) return a;
    return parents[a] = find(parents[a]);
  }

  static void findMinCost(int cnt, int tIdx, int sum) {
    // System.out.println("cnt: " + cnt + ", tIdx: " + tIdx + ", sum: " + sum);

    // 가장 작은 비용의 학생부터 고른다
    if (sum > k) {
      flag = true;
      return;
    }
    if (cnt == N) {
      min = Math.min(min, sum);
      return;
    }

    while (isPassed[costs[tIdx][0]]) tIdx++;

    // 한 학생을 선택함으로써 추가적으로 연결되는 친구
    int selectedStudent = costs[tIdx][0];
    // 1. 학생의 최상위 부모를 찾는다
    int parent = find(selectedStudent);

    int tmpCnt = 0;
    for (int i = 1; i <= N; i++) {
      // 같은 부모를 공유하는 애들을 찾는다
      if (parents[i] == parent) {
        isPassed[i] = true;
        tmpCnt++;
      }
    }

    int selectedCost = costs[tIdx][1];
    sum += selectedCost;
    cnt += tmpCnt;

    findMinCost(cnt, tIdx + 1, sum);
  }

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    parents = new int[N + 1];
    for (int i = 0; i <= N; i++) parents[i] = i;
    isPassed = new boolean[N + 1];

    costs = new int[N][2];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      costs[i][0] = i + 1;
      costs[i][1] = Integer.parseInt(st.nextToken());
    }

    // System.out.println("------------");
    // print(costs);
    // System.out.println("------------");

    Arrays.sort(
      costs,
      (a, b) -> {
        if (a[1] == b[1]) return a[0] - b[0];
        return a[1] - b[1];
      }
    );

    // System.out.println("------------");
    // print(costs);
    // System.out.println("------------");
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      union(a, b);
    }

    for (int i = 1; i <= N; i++) {
      find(i);
    }

    // print(parents);
    // System.out.println("------------");

    findMinCost(0, 0, 0);

    if (flag) bw.write("Oh no"); else bw.write(String.valueOf(min));
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
