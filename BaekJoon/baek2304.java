import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Pillar implements Comparable<Pillar> {

  int x;
  int y;

  Pillar(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Pillar o) {
    //오름차순
    // 현재가 더 크면 1 (뒤로 물러남), 현재가 더 작으면 -1 (앞으로 옴)
    return this.x - o.x;
  }
}

class Main {

  static int N;

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    ArrayList<Pillar> pillars = new ArrayList<>();

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      pillars.add(new Pillar(x, y));
    }

    Collections.sort(pillars);

    int maxIndex = 0;
    int maxY = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      Pillar p = pillars.get(i);
      if (maxY < p.y) {
        maxIndex = i;
        maxY = p.y;
      }
    }

    int pos = pillars.get(maxIndex).x;
    int width = maxY;
    // 좌측부터 pos-1까지의 면적 구하기

    int x = pillars.get(0).x;
    int y = pillars.get(0).y;
    int i = 1;
    while (i <= maxIndex) {
      if (pillars.get(i).y >= y) {
        int row = pillars.get(i).x - x;
        width += row * y;
        x = pillars.get(i).x;
        y = pillars.get(i).y;
      }

      i++;
    }

    //우측부터 pos+1까지의 면적 구하기
    x = pillars.get(N - 1).x;
    y = pillars.get(N - 1).y;
    i = N - 2;

    while (i >= maxIndex) {
      if (pillars.get(i).y >= y) {
        int row = x - pillars.get(i).x;
        width += row * y;

        x = pillars.get(i).x;
        y = pillars.get(i).y;
      }

      i--;
    }
    System.out.println(width);
  }
}
