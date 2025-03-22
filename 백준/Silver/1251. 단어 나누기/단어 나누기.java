
import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static int K;

    public static void main(String[] args) throws IOException {

        // 1. 임의의 두 부분을 골라 단어를 쪼개기
        // 2. 각 부분을 뒤집는다
        // 3. 다시 합친다

        // 사전순으로 가장 앞서는 단어를 출력하는 프로그램
        // 문자열에서 두 부분을 랜덤하게 정한다

        String str = br.readLine();

        // lt = 0~ legnth-1;
        // rt = 1 ~ length -2;

        // 각각을 다 구해본다 ->
        // 만든 단어 중에서 사전순으로 가장 앞서는지는 어떻게 따지지?
        // 만들어졌을 때마다, 비교한다?

        // (1,2), (1, 3), ..., (1,6);
        // (2,3), (2,4), (2,5), (2,6)
        // (3,4), (3,5), (3, 6)

        String result = "";
        int lt = 1;
        while (lt < str.length() - 1) {

            String temp = "";
            for (int rt = lt + 1; rt < str.length(); rt++) {

                String sub1 = str.substring(0, lt);
                String sub2 = str.substring(lt, rt);
                String sub3 = str.substring(rt, str.length());

                temp = reverseStr(sub1) + reverseStr(sub2) + reverseStr(sub3);

                if (result.equals("")) {
                    result = temp;
                    continue;
                }

                for (int i = 0; i < str.length(); i++) {
                    if (result.charAt(i) < temp.charAt(i)) {
                        break;
                    } else if (result.charAt(i) == temp.charAt(i)) {
                        continue;
                    } else {
                        result = temp;
                    }
                }
            }

            // if (result.campareTo(temp) > 0){
            // result = temp;
            // }

            lt++;
        }

        bw.write(result);
        bw.flush();

    }

    static String reverseStr(String str) {

        StringBuilder sb = new StringBuilder();

        for (int j = str.length() - 1; j >= 0; j--) {
            sb.append(str.charAt(j));
        }

        return sb.toString();

    }
}