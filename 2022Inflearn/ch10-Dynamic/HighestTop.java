import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Brick implements Comparable<Brick> {

  int area;
  int height;
  int weight;

  Brick(int area, int height, int weight) {
    this.area = area;
    this.height = height;
    this.weight = weight;
  }

  @Override
  public int compareTo(Brick o) {
    return o.area - this.area;
  }
}

class Main {

  static int N;
  static int[] dy;
  static ArrayList<Brick> arr;

  public static void solution() {
    Collections.sort(arr);
    dy[0] = arr.get(0).height;

    for (int i = 1; i < N; i++) {
      int max = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (
          arr.get(i).area < arr.get(j).area &&
          arr.get(i).weight < arr.get(j).weight
        ) {
          if (max < dy[j]) {
            max = dy[j];
          }
        }
      }
      dy[i] = max + arr.get(i).height;
    }

    Integer[] intToIntegerDy = Arrays
      .stream(dy)
      .boxed()
      .toArray(Integer[]::new);
    Arrays.sort(intToIntegerDy, Collections.reverseOrder());
    System.out.println(intToIntegerDy[0]);
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new ArrayList<Brick>();
    dy = new int[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int area = Integer.parseInt(st.nextToken());
      int height = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      arr.add(new Brick(area, height, weight));
    }

    solution();
    // int answer = main.solution(N);

  }
}
