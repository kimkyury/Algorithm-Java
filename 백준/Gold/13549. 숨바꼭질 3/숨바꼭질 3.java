import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

  static StringTokenizer st;

  static int[] isPassed;

  static int totalTime;

  public static boolean multiple(int k, int[] curPosAndTime, Queue<int[]> dq) {
    // 10만 = 2의 17승 정도.
    int curPos = curPosAndTime[0] * 2;
    if (curPos < 1) return false;

    while (curPos <= 100000) {
      if (isPassed[curPos] == 1) return false;
      if (curPos == k) {
        totalTime = curPosAndTime[1];
        return true;
      }
      isPassed[curPos] = 1;
      int[] nwePosAndTime = { curPos, curPosAndTime[1] };
      dq.offer(nwePosAndTime);

      curPos *= 2;
    }
    return false;
  }

  public static void bfs(int k, int n) {
    Queue<int[]> dq = new ArrayDeque<>();

    int[] initPosAndTime = { n, 0 };
    dq.offer(initPosAndTime);

    // 순간이동은 0초가 걸림.
    while (!dq.isEmpty()) {
      int size = dq.size();
      boolean flag = false;
      for (int i = 0; i < size; i++) {
        int[] curPosAndTime = dq.poll();
        int curPos = curPosAndTime[0];
        int curTime = curPosAndTime[1];

        if (curPosAndTime[0] == k) {
          totalTime = curPosAndTime[1];
          return;
        }
        // *2
        int newPos3 = curPos * 2;
        if (newPos3 > 0 && newPos3 <= 100000 && isPassed[newPos3] != 1) {
          isPassed[newPos3] = 1;
          int[] newPosAndTime = { newPos3, curTime };
          dq.offer(newPosAndTime);

          while (newPos3 * 2 <= 100000) {
            newPos3 *= 2;
            if (isPassed[newPos3] == 1) break;
            if (newPos3 == k) {
              totalTime = curTime;
              return;
            }
            isPassed[newPos3] = 1;
            int[] newPosAndTime2 = { newPos3, curTime };
            dq.offer(newPosAndTime2);
          }
        }

        // -1
        int newPos = curPos - 1;
        if (newPos > 0 && isPassed[newPos] != 1) {
          isPassed[newPos] = 1;
          int[] newPosAndTime = { newPos, curTime + 1 };
          dq.offer(newPosAndTime);
          flag = multiple(k, newPosAndTime, dq);
        }
        if (flag) return;

        // +1
        int newPos2 = curPos + 1;
        if (newPos2 <= 100000 && isPassed[newPos2] != 1) {
          isPassed[newPos2] = 1;
          int[] newPosAndTime = { newPos2, curTime + 1 };
          dq.offer(newPosAndTime);
          flag = multiple(k, newPosAndTime, dq);
        }
        if (flag) return;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    isPassed = new int[100001];
    totalTime = 0;

    if (k <= n) {
      bw.write(String.valueOf(n - k));
    } else {
      bfs(k, n);
      bw.write(String.valueOf(totalTime));
    }

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
