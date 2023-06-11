import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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

  static int N;
  static int[][] arr;
  static int min = Integer.MAX_VALUE;
  static int sum = 0;

  static void combiStats(int cnt, int tIdx, int[] members, int[] select) {
    if (cnt == 2) {
      // System.out.println(Arrays.toString(select));
      // 능력치조합에 대하여 통계내기
      int subSum = 0;
      subSum += arr[select[0]][select[1]];
      subSum += arr[select[1]][select[0]];

      sum += subSum;
      return;
    }

    if (tIdx == N / 2) {
      return;
    }

    select[cnt] = members[tIdx];
    combiStats(cnt + 1, tIdx + 1, members, select);
    combiStats(cnt, tIdx + 1, members, select);

    return;
  }

  static void combiMember(int cnt, int tIdx, boolean[] isStart) {
    if (cnt == N / 2) {
      int[] startMember = new int[N / 2];
      int[] linkMember = new int[N / 2];

      int sIdx = 0;
      int lIdx = 0;
      // System.out.println(Arrays.toString(isStart));
      for (int i = 0; i < N; i++) {
        if (isStart[i]) startMember[sIdx++] = i; else linkMember[lIdx++] = i;
      }

      // System.out.println(Arrays.toString(startMember));
      // System.out.println(Arrays.toString(linkMember));

      // 2. N/2개 중에서 2개를 뽑아 능력치 조합을 sum 하기

      int[] selectS = new int[2];
      int[] selectL = new int[2];

      sum = 0;
      combiStats(0, 0, startMember, selectS);
      int startSum = sum;

      sum = 0;
      combiStats(0, 0, linkMember, selectL);
      int linkSum = sum;

      // System.out.println("startSum: " + startSum + " linkSum: " + linkSum);

      min = Math.min(min, Math.abs(startSum - linkSum));
      return;
    }
    if (tIdx == N) {
      return;
    }

    isStart[tIdx] = true;
    combiMember(cnt + 1, tIdx + 1, isStart);
    isStart[tIdx] = false;
    combiMember(cnt, tIdx + 1, isStart);
  }

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 1. N개 중에서 N/2개 뽑기
    boolean[] selectedMember = new boolean[N];
    combiMember(0, 0, selectedMember);

    bw.write(String.valueOf(min));
    bw.flush();
  }
}
