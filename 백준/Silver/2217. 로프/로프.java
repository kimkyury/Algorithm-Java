import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

  public static int solve(int[] loofs) {
    // 각 loof를 택한다
    // 자신보다 큰 loof 개수를 센다 (sort 먼저 시키기)
    // max(본인xloof, max) 로 판단한다

    Arrays.sort(loofs);

    int size = loofs.length;
    int max = 0;
    for (int i = 0; i < size; i++) {
      int tmpMaxWeight = loofs[i] * (size - i);
      max = Math.max(max, tmpMaxWeight);
    }

    return max;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int loofs[] = new int[N];
    for (int i = 0; i < N; i++) {
      loofs[i] = Integer.parseInt(br.readLine());
    }

    int answer = solve(loofs);

    System.out.print(answer);
  }
}
