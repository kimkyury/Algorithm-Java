import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
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
  static int[][] map;
  static int N, L;
  static int answer;

  public static void solve(Queue<int[]> lineInfo) {
    while (!lineInfo.isEmpty()) {
      int[] curLine = lineInfo.poll();

      // 1. 각 배열의 요소가 모두 같은가? -> answer++;
      if (isSameElement(curLine)) {
        // System.out.println("isSameElement: " + Arrays.toString(curStartPos));
        answer++;
        continue;
      }
      // 2-1. 각 배열이 1씩 차이나는 오름||내림을 유지하는가?
      if (!isHasDiff1(curLine)) {
        continue;
      }
      // System.out.println(Arrays.toString(curLine));
      // 2-2. 유지한다면, 1씩 나는 것들이 L만큼 유지되는가? -> answer++;
      if (isDiffSizeL(curLine)) {
        // System.out.println("Diff L: " + Arrays.toString(curLine));
        answer++;
      }
    }
  }

  public static boolean isDiffSizeL(int[] lineInfo) {
    boolean[] isPassed = new boolean[N];

    // 굴곡이 나타났을 때, 해당 바닥이 L만큼 사이즈를 유지하고 있는가?
    for (int i = 0; i < N - 1; i++) {
      if (lineInfo[i] < lineInfo[i + 1]) {
        // 오르막
        if (isPassed[i]) return false;
        isPassed[i] = true;

        for (int j = i - 1; j > (i - 1) - (L - 1); j--) {
          if (j < 0) return false;
          if (isPassed[j]) return false;
          if (lineInfo[i] == lineInfo[j]) {
            isPassed[j] = true;
          } else {
            return false;
          }
        }
      } else if (lineInfo[i] > lineInfo[i + 1]) {
        // 내리막
        isPassed[i + 1] = true;

        for (int j = i + 2; j < (i + 2) + L - 1; j++) {
          if (j >= N) return false;
          if (lineInfo[i + 1] == lineInfo[j]) {
            isPassed[j] = true;
          } else {
            return false;
          }
        }
      }
    }
    return true;
  }

  public static boolean isHasDiff1(int[] lineInfo) {
    for (int j = 0; j < N - 1; j++) {
      if (Math.abs(lineInfo[j] - lineInfo[j + 1]) > 1) return false;
    }

    return true;
  }

  public static boolean isSameElement(int[] lineInfo) {
    int fixNum = lineInfo[0];

    for (int i = 1; i < N; i++) {
      if (fixNum != lineInfo[i]) return false;
    }

    return true;
  }

  public static void main(String[] args) throws IOException {
    // 1. 높이가 1이고 길이가 L인 경사로의 정보를 저장한다
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());

    map = new int[N][N];
    answer = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 2. 2N개를 조사한다 (조사 시작점 (i, j)12개를 지정한다
    Queue<int[]> lineInfo = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      int colLine[] = new int[N];
      for (int j = 0; j < N; j++) {
        colLine[j] = map[j][i];
      }

      lineInfo.offer(map[i]);
      lineInfo.offer(colLine);
    }

    solve(lineInfo);

    bw.write(String.valueOf(answer));
    bw.flush();
  }

  static void show(int[][] arr) {
    System.out.println("------------");

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.println(arr[i][j] + " ");
      }
      System.out.println("");
    }
  }

  static void show(boolean[][] arr) {
    System.out.println("------------");
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j]) System.out.println("F "); else System.out.println("T ");
        System.out.println("");
      }
    }
  }
}
