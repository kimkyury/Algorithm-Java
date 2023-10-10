import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static StringTokenizer st;
  static StringBuilder sb;
  static int N;

  static int[] dy = { 0, -1, 0, 1 };
  static int[] dx = { 1, 0, -1, 0 };
  static int[][] map;

  static int answer;

  public static void curve(
    LinkedList<Integer> dList,
    int[] curP,
    int g,
    int maxG
  ) {
    if (g > maxG) {
      return;
    }

    LinkedList<Integer> newDList = new LinkedList<>(dList);
    // 회전하여 색칠하기
    for (int i = dList.size() - 1; i >= 0; i--) {
      int tmpD = dList.get(i);
      if (tmpD == 3) tmpD = 0; else tmpD++;

      curP[0] += dy[tmpD];
      curP[1] += dx[tmpD];
      map[curP[0]][curP[1]] = 1;
      newDList.addLast(tmpD);
    }

    curve(newDList, curP, g + 1, maxG);
  }

  public static int count() {
    int cnt = 0;
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (
          map[i][j] == 1 &&
          map[i + 1][j] == 1 &&
          map[i][j + 1] == 1 &&
          map[i + 1][j + 1] == 1
        ) {
          cnt++;
        }
      }
    }

    return cnt;
  }

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    map = new int[101][101]; //TODO: 101 x 101
    // 1. (x, y)를 시작점으로 하여, 0~d번 동안 드래곤 커브를 진행한다

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());

      // 선분 칠하기
      int[] curP = { y, x };
      map[y][x] = 1;

      curP[0] += dy[d];
      curP[1] += dx[d];
      map[curP[0]][curP[1]] = 1;

      if (g != 0) {
        LinkedList<Integer> dList = new LinkedList<>();
        dList.add(d);

        curve(dList, curP, 1, g);
      }
      // show(map);
      // 90도 회전한다면
      // 0 -> 3, 1 ->0, 2 -> 1, 3 -> 2
    }

    bw.write(String.valueOf(count()));
    bw.flush();
  }

  static void show(int[][] arr) {
    System.out.println("------------");

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println("");
    }
  }

  static void show(boolean[][] arr) {
    System.out.println("——————");
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j]) System.out.println("F "); else System.out.println("T ");
        System.out.println("");
      }
    }
  }
}
