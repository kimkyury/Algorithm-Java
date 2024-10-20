import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        String str1 = st.nextToken();
        String str2 = st.nextToken();

        if (str1.length() < str2.length()) {
            String temp = str2;
            str2 = str1;
            str1 = temp;
        }

        String result = calcul(str1, str2, 0, 0, new StringBuilder());

        int idx = 0;
        // 1이 될 때까지 찾기
        while (idx < result.length() && result.charAt(idx) != '1') {
            idx++;
        }

        // 모두 0이여서 idx가 끝까지 가버림
        if (idx == result.length()) {
            bw.write("0");
        } else {
            bw.write(result.substring(idx));
        }

        bw.flush();
    }

    private static String calcul(String str1, String str2, int idx, int carry, StringBuilder sb) {

        if (idx == str1.length()) {
            if (carry == 1) {
                sb.insert(0, 1);
            }
            return sb.toString();
        }

        // 짧은 이진수는 볼 거 다 봤다면
        if (idx >= str2.length()) {
            int num = str1.charAt(str1.length() - 1 - idx) - '0';
            if (num + carry == 2) {
                return calcul(str1, str2, idx + 1, 1, sb.insert(0, '0'));
            } else {
                return calcul(str1, str2, idx + 1, 0, sb.insert(0, num + carry));
            }
        }

        int num1 = str1.charAt(str1.length() - 1 - idx) - '0';
        int num2 = str2.charAt(str2.length() - 1 - idx) - '0';
        int sum = num1 + num2 + carry;
        if (sum >= 2) {
            return calcul(str1, str2, idx + 1, 1, sb.insert(0, sum - 2));
        } else {
            return calcul(str1, str2, idx + 1, 0, sb.insert(0, sum));
        }
    }

}
