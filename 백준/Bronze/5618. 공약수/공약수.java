import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );
  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );

  public static void solution() {}

  static int N;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    // 1. 공약수 : 서로를 공통으로 나눌 수 있는 수

    int min = Integer.MAX_VALUE;
    int arr[] = new int[N];
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());

      min = Math.min(min, num);
      arr[i] = num;
    }

    Arrays.sort(arr);
    ArrayList<Integer> candidate = new ArrayList<>();
    // 가장 작은 수에 대하여 나눌 수 있는 수를 후보로 구한다
    for (int i = 1; i <= arr[0]; i++) {
      if (arr[0] % i == 0) candidate.add(i);
    }

    // 후보군이 다른 숫자에도 통하는지 확인한다

    // for (int candi : candidate) {
    //   System.out.print(candi + " ");
    // }
    // System.out.println("");

    boolean flag = true;
    for (int candi : candidate) {
      flag = true;
      for (int i = 1; i < arr.length; i++) {
        if (arr[i] % candi != 0) {
          flag = false;
          break;
        }
      }
      if (flag) {
        bw.write(String.valueOf(candi) + "\n");
      }
    }

    // bw.write(String.valueOf(cnt));
    bw.flush();
  }
}
