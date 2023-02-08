import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );
  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static int N;
  static int order[];
  static boolean[] isSelected;

  public static void main(String[] args) throws Exception {
    //StringTokenizer st = new StringTokenizer(br.readLine());

    //N = Integer.parseInt(br.readLine());

    char[] str = br.readLine().toCharArray();
    int size = str.length;
    // isSelected = new boolean[N];
    // order = new int[N]; // 상대적인 알파벳 순위 저장

    // PriorityQueue<Integer> pq = new PriorityQueue<>();
    // for (char c : str.toCharArray()) {
    //   pq.offer(c - '0');
    // }

    StringBuilder descStr = new StringBuilder();

    descStr.append(str[0]); // first
    for (int i = 1; i < size; i++) {
      if (descStr.charAt(i - 1) < str[i]) {
        // 이전보다 (사전순으로) 큰 값이면 앞에 넣기
        descStr.insert(0, str[i]);
      } else {
        // 이전보다 (사전순으로) 작은 값이면 뒤에 넣기
        descStr.append(str[i]);
      }
    }

    String answer = descStr.reverse().toString();

    // BCDAF -> ABCDF가 되기위해선
    // 그리디하게 생각해볼까? DP로 생가가

    // 어떻게 생각할 수  있ㅡ까?
    // 각 문자열을 입력받자
    //----- 이때, 문자열의 우선순위도 함께 저장하는 배열을 만ㅡ자

    // 문자열을 탐색하다가, 가장 min값을 찾는다  ( BCDAF -> ADCBF)
    // 0~min값을 반전시켜서 배열로 갖는다
    // 다음 1~min값을 반전시켜서 배열로 갖는다

    bw.write(answer);
    bw.flush();
  }
}
