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

  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int N, M;
  static ArrayList<Integer> minMoveInfo;
  static int[] moveInfo;
  static boolean[] isPassed;
  static int MAX_DISTANCE = 100001;
  static int time = 0;

  static void bfs(int subin, int sister) {
    Queue<Integer> dq = new ArrayDeque<>();

    int movePos[] = new int[3];

    movePos[0] = subin - 1;
    movePos[1] = subin + 1;
    movePos[2] = subin * 2;
    time += 1;

    for (int i = 0; i < 3; i++) {
      if (movePos[i] <= -1 || movePos[i] >= MAX_DISTANCE) continue;
      moveInfo[movePos[i]] = subin; // 이전에서 온 곳
      isPassed[movePos[i]] = true;
      dq.offer(movePos[i]);
    }

    boolean flag = false;
    while (!dq.isEmpty()) {
      time++;

      int size = dq.size();
      for (int i = 0; i < size; i++) {
        int curPos = dq.poll();

        if (curPos == M) {
          flag = true;
          return;
        }
        int moveCurPos[] = new int[3];
        moveCurPos[0] = curPos - 1;
        moveCurPos[1] = curPos + 1;
        moveCurPos[2] = curPos * 2;

        for (int j = 0; j < 3; j++) {
          if (moveCurPos[j] <= -1 || moveCurPos[j] >= MAX_DISTANCE) continue;
          if (isPassed[moveCurPos[j]]) continue;

          moveInfo[moveCurPos[j]] = curPos; // 이전에서 온 곳
          isPassed[moveCurPos[j]] = true;
          dq.offer(moveCurPos[j]);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); //수빈
    M = Integer.parseInt(st.nextToken()); // 동생

    minMoveInfo = new ArrayList<>();
    moveInfo = new int[MAX_DISTANCE];
    isPassed = new boolean[MAX_DISTANCE];

    if (N == M) {
      System.out.println("0");
      System.out.println(N);
      return;
    }

    bfs(N, M);

    bw.write(time - 1 + "\n");

    int index = M;

    sb.append(index + " ");

    while (true) {
      if (index == N) break;
      sb.insert(0, moveInfo[index] + " ");
      index = moveInfo[index];
    }

    bw.write(sb.toString());
    bw.flush();
  }

  static void show(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
  }

  static void show(boolean[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j]) System.out.print("1"); else System.out.print("0");
      }
      System.out.println("");
    }
  }
}
