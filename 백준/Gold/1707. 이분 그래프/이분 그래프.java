import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
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
  static int V, E;
  static ArrayList<ArrayList<Integer>> edges;
  static boolean flag;
  static boolean[] isPassed;
  static int[] setInfo;

  // 2. 인접그래프 BFS탐색, 현V에 인접한 것들을 모두 반대색으로 칠하기
  // 3. if, 인접한 것이 같은 색으로 이미 칠해져 있다면 불가능으로 판단 후 출력

  public static void bfs(int startV) {
    if (flag) return;
    if (isPassed[startV]) return;

    setInfo[startV] = 1;
    Queue<Integer> dq = new ArrayDeque<>();

    ArrayList<Integer> adjEdges = edges.get(startV);
    for (int i = 0; i < adjEdges.size(); i++) {
      dq.offer(adjEdges.get(i));
    }

    int curSet = -1;
    int nextSet = 1;
    while (!dq.isEmpty()) {
      int size = dq.size();
      curSet *= (-1);
      nextSet = curSet * (-1);
      for (int i = 0; i < size; i++) {
        int v2 = dq.poll();

        if (curSet == setInfo[v2]) {
          flag = true;
          return;
        }

        if (!isPassed[v2]) {
          setInfo[v2] = nextSet;
          isPassed[v2] = true;

          ArrayList<Integer> adjEdges2 = edges.get(v2);
          for (int j = 0; j < adjEdges2.size(); j++) {
            dq.offer(adjEdges2.get(j));
          }
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine());
      V = Integer.parseInt(st.nextToken());
      E = Integer.parseInt(st.nextToken());
      flag = false;
      isPassed = new boolean[V + 1];
      setInfo = new int[V + 1];

      edges = new ArrayList<>();

      for (int i = 0; i <= V; i++) {
        edges.add(new ArrayList<Integer>());
      }

      // 1. 연결정보 인접 그래프로 저장
      int v1, v2;
      for (int i = 0; i < E; i++) {
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        edges.get(v1).add(v2);
        edges.get(v2).add(v1);
      }

      // BFS수행 (비연결일 수도 있으니, v를 시작으로 돌려보기)
      for (int i = 1; i <= V; i++) {
        bfs(i);
      }

      //출력
      if (flag) bw.write("NO\n"); else bw.write("YES\n");
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
