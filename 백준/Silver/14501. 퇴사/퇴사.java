import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
  static int maxPrice = 0;
  static List<int[]> arr;

  public static void recur(int date, int price) {
    if (date >= N) {
      maxPrice = Math.max(maxPrice, price);
      return;
    }
    int[] consultInfo = arr.get(date);

    if (date + consultInfo[0] > N) {
      recur(date + 1, price);
    } else {
      recur(date + consultInfo[0], price + consultInfo[1]);
    }
    recur(date + 1, price);
  }

  public static void main(String[] args) throws IOException {
    arr = new ArrayList<>();

    N = Integer.parseInt(br.readLine());
    int T, P;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      T = Integer.parseInt(st.nextToken());
      P = Integer.parseInt(st.nextToken());

      int[] consultInfo = { T, P };
      arr.add(consultInfo);
    }

    recur(0, 0);

    bw.write(String.valueOf(maxPrice));
    bw.flush();
  }
}
