import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  static int N;
  static int[] sw;

  public static void onOff(int n) {
    if (sw[n] == 0) sw[n] = 1; else sw[n] = 0;
  }

  public static void change(int gender, int n) {
    if (gender == 1) {
      int i = 1; //배수역할
      int pos = n; // 위치
      while (true) {
        pos = n * i;
        if (pos > sw.length - 1) break;
        onOff(pos);
        i++;
      }
    } else if (gender == 2) {
      int i = 1; // 배수 역할
      int pos = n;

      while (true) {
        if (pos - i < 1 || pos + i > sw.length - 1) break;
        boolean flag = (sw[pos - i] == sw[pos + i]);
        if (flag) {
          onOff(pos - i);
          onOff(pos + i);
        } else {
          break;
        }
        i++;
      }
      onOff(n);
    }
  }

  public static void print() {
    if (N > 20) {
      System.out.print(sw[1] + " ");
      for (int i = 2; i <= N; i++) {
        System.out.print(sw[i] + " ");
        if (i % 20 == 0) {
          System.out.println("");
        }
      }
    } else {
      for (int i = 1; i <= N; i++) {
        System.out.print(sw[i] + " ");
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(br.readLine());
    sw = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      sw[i] = Integer.parseInt(st.nextToken());
    }

    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int gender = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());

      change(gender, n);
    }

    print();
  }
}
