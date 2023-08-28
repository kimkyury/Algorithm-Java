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

  static int[][] isPassed;

  static int totalTime;

  public static void bfs(int aimEmogiCnt) {
    int backgroundCnt = 1;
    int storeCnt = 0;

    Queue<int[]> dq = new ArrayDeque<>();

    // 0: BackgroundCnt, 1: StoreCnt
    int[] initEmogiInfo = { backgroundCnt, storeCnt };

    dq.offer(initEmogiInfo);

    while (!dq.isEmpty()) {
      int size = dq.size();
      for (int i = 0; i < size; i++) {
        int[] curEmogiInfo = dq.poll();
        if (curEmogiInfo[0] == aimEmogiCnt) return;

        // 1. 복사 후 클립보드 저장
        // storeCnt = backgroundCnt;
        int[] newEmogiInfo1 = { curEmogiInfo[0], curEmogiInfo[0] };

        if (
          newEmogiInfo1[0] >= 0 &&
          newEmogiInfo1[1] >= 0 &&
          isPassed[newEmogiInfo1[0]][newEmogiInfo1[1]] != 1
        ) {
          isPassed[newEmogiInfo1[0]][newEmogiInfo1[1]] = 1;
          dq.offer(newEmogiInfo1);
        }

        // 2. 모든 이모티콘 화면에 붙여넣기
        // backgroundCnt += storeCnt;
        int[] newEmogiInfo2 = {
          curEmogiInfo[0] + curEmogiInfo[1],
          curEmogiInfo[1],
        };
        if (
          newEmogiInfo2[0] >= 0 &&
          newEmogiInfo2[1] >= 0 &&
          isPassed[newEmogiInfo2[0]][newEmogiInfo2[1]] != 1
        ) {
          isPassed[newEmogiInfo2[0]][newEmogiInfo2[1]] = 1;
          dq.offer(newEmogiInfo2);
        }

        // 3. 화면의 이모티콘 중 하나 삭제
        // backgroundCnt -=1;
        int[] newEmogiInfo3 = { curEmogiInfo[0] - 1, curEmogiInfo[1] };
        if (
          newEmogiInfo3[0] >= 0 &&
          newEmogiInfo3[1] >= 0 &&
          isPassed[newEmogiInfo3[0]][newEmogiInfo3[1]] != 1
        ) {
          isPassed[newEmogiInfo3[0]][newEmogiInfo3[1]] = 1;
          dq.offer(newEmogiInfo3);
        }
      }

      totalTime++;
    }
  }

  public static void main(String[] args) throws IOException {
    int aimEmogiCnt = Integer.parseInt(br.readLine());
    isPassed = new int[10001][10001];
    // 3가지 연산 -> 이모티콘 S개 만들기

    totalTime = 0;

    bfs(aimEmogiCnt);

    bw.write(String.valueOf(totalTime));
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
