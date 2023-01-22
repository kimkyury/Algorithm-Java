import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

  static int P;
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  static long[] arr;

  // 주기로 입력받기
  public static long f(int num) {
    // int fiboNum = Long.valueOf(num % Long.valueOf(P)).intValue();
    // System.out.println(arr[num]);
    if (arr[num] != 0) return arr[num];
    if (num == 0) return 0; else if (num == 1) return 1;

    return arr[num] = (f(num - 1) + f(num - 2)) % 1000000;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Long L = Long.parseLong(br.readLine());

    // 백만에 대한 주기 구하기
    P = 15 * (int) Math.pow(10, 5);
    arr = new long[P + 1];
    arr[0] = 0;
    arr[1] = 1;
    int target = Long.valueOf(L % Long.valueOf(P)).intValue();
    bw.write(String.valueOf(f(target) % 1000000));

    bw.flush();
  }
}
