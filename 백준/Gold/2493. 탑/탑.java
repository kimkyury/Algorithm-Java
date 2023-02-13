import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {

  int index;
  int height;

  Top(int index, int height) {
    this.index = index;
    this.height = height;
  }
}

class Main {

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );
  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );

  // static int N, L;

  public static void solution() {}

  // Upper, arr = {0, 0, 0, 1,/attachments/1047120651678392372/1074681943817457664/image.png 2, 3, 3, 3, 4, 4, 6, 7, 8}, target = 3, size = arr.length

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());

    Stack<Top> tops = new Stack<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    tops.push(new Top(1, Integer.parseInt(st.nextToken())));

    int[] answer = new int[N];
    for (int i = 2; i <= N; i++) {
      Top curTop = new Top(i, Integer.parseInt(st.nextToken()));

      // 1. stack으로 입력받는다
      // 2. 입력받는 매 순간마다, 해당 높이가 이전 저장값보다 큰지 확인한다
      // 3. 해당 높이가 이전 저장값보다 크다면, 이전 값은 삭제한다 (어차피 안 닿을 애니까)
      // 4. 해당 높이가 작다면, answer배열에 직전 값의 index를 집어넣고, 그 객체를 stack에 저장한다

      Top preTop = tops.peek();
      if (preTop.height < curTop.height) {
        while (!tops.isEmpty()) {
          preTop = tops.peek();
          if (tops.peek().height < curTop.height) {
            tops.pop();
          } else {
            answer[i - 1] = preTop.index;
            break;
          }
        }
      } else { // 같거나 작다 == 그 인덱스가 answer에 들어간다
        answer[i - 1] = preTop.index;
      }

      tops.push(curTop);
    }

    for (int num : answer) {
      bw.write(String.valueOf(num) + " ");
    }

    bw.flush();
  }
}
