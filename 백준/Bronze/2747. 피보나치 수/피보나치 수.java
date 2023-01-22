import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

  static int[] arr = new int[46];

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static int f(int num) {
    if (arr[num] != 0) return arr[num];
    if (num == 0) return 0;
    if (num == 1) return 1;

    arr[num] = f(num - 1) + f(num - 2);
    return arr[num];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(f(N)));
    // solve(startPoint, endPoint);

    // bw.write(String.valueOf(shortestDistance[endPoint]));
    bw.flush();
  }
}
