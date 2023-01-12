import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;

  public static int solve(int[] predictions, int[] cntStrike, int[] cntBall) {
    // 초기 숫자 후보들을 받아온다
    int[] candidates = pretreatmentCandidate();
    // 민혁이가 말한 숫자에 대하여 123 ~ 987 숫자들이 같은 strike, ball의 cnt값을 갖는지 확인한다
    // 해당 strike, ball의 cnt를 갖고 있지 않다면 불가능한 숫자로, candidates[index] = 0으로 체킹한다
    // for문을 돌 때, candidates[index] == 1인 것들만 조사하도록 한다

    for (int i = 0; i < N; i++) {
      String prediction = Integer.toString(predictions[i]);

      for (int j = 123; j <= 987; j++) { // j == 해당 숫자
        if (candidates[j] == 1) {
          String tmpCandidate = Integer.toString(j);

          int tmpCntStrike = 0;
          int tmpCntBall = 0;
          // strike 검사
          for (int k = 0; k < 3; k++) {
            if (prediction.charAt(k) == tmpCandidate.charAt(k)) tmpCntStrike++;
          }
          //ball검사
          for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
              if (k == l) continue;
              if (tmpCandidate.charAt(k) == prediction.charAt(l)) tmpCntBall++;
            }
          }

          // 해당 strike, ball 개수가 민혁이의 제시 결과와 같은지 확인, 아니면 제거
          if (tmpCntStrike != cntStrike[i] || tmpCntBall != cntBall[i]) {
            candidates[j] = 0;
          }
        }
      }
    }

    int answer = 0;
    for (int i = 123; i <= 987; i++) {
      if (candidates[i] == 1) {
        answer++;
      }
    }

    return answer;
  }

  public static boolean isSame(char[] tmp) {
    for (int j = 0; j < 3; j++) {
      //같은 숫자의 반복인지 체크
      for (int k = 0; k < 3; k++) {
        if (j == k) continue;
        if (tmp[j] == tmp[k]) {
          return true;
        }
      }
    }
    return false;
  }

  public static int[] pretreatmentCandidate() {
    int[] candidate = new int[988];
    // 123 ~ 987
    for (int i = 123; i < 988; i++) candidate[i] = 1;

    // 0이 들어간 숫자는 제거시킨다
    boolean flag = false;
    for (int i = 123; i < 988; i++) {
      char[] tmp = Integer.toString(i).toCharArray();

      for (int j = 0; j < 3; j++) {
        //0이 들어갔을 때 체크
        if ((tmp[j] - '0') == 0) {
          flag = true;
          break;
        }
      }

      if (flag == false) {
        flag = isSame(tmp);
      }

      if (flag) candidate[i] = 0;
      flag = false;
    }

    // 같은 숫자의 출현은 제거시킨다
    for (int i = 123; i < 988; i++) {}

    // show(candidate);
    return candidate;
  }

  // public static void show(int[] candidate) {
  //   for (int i = 123; i < 988; i++) {
  //     if (candidate[i] == 1) System.out.print(i + " ");
  //   }
  // }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    int[] predictions = new int[N];
    int[] cntStrike = new int[N];
    int[] cntBall = new int[N];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      predictions[i] = Integer.parseInt(st.nextToken());
      cntStrike[i] = Integer.parseInt(st.nextToken());
      cntBall[i] = Integer.parseInt(st.nextToken());
    }

    int asnwer = solve(predictions, cntStrike, cntBall);

    System.out.print(asnwer);
  }
}
