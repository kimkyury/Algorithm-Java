import java.io.*;

public class baek_1157 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int len = str.length();
        boolean[] isPassed = new boolean[len];
        int[] arrCnt = new int[len]; // 각 단어의 개수
        char answer = ' '; // 리턴 값

        // 문자열을 소문자로 바꾸자
        str = str.toUpperCase();

        // 입력된 각 문자의 개수를 세어 보자, Mississipi라고 생각해보자
        int cnt;
        for (int i = 0; i < len; i++) {

            cnt = 0;
            if (isPassed[i] == true) {
                continue;
            }
            for (int j = 0; j < len; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    cnt++;
                    isPassed[j] = true;
                }
            }
            arrCnt[i] = cnt;
        }

        // 각 문자열의 개수가 arrCnt에 담겼으니, 누가 가장 큰 지 알아내자
        int max = arrCnt[0];
        answer = str.charAt(0);
        for (int i = 0; i < len; i++) {
            if (max < arrCnt[i]) {
                max = arrCnt[i];
                answer = str.charAt(i); // 최대값을 찾을 때마다 str로 바꿔주자
            }
        }

        // 최대 출현 빈도수를 가지는 문자가 두 개 이상 나타나면 answer을 '?'로 바꿔주자
        int n = 0;
        for (int i = 0; i < len; i++) {
            if (max == arrCnt[i]) {
                n++;
            }
        }

        if (n > 1) {
            answer = '?';
        }

        System.out.print(String.valueOf(answer));
    }
}