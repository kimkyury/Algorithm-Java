import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    private static int n;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine()); // 2* 10^5
        String s = br.readLine();
        // s의 사이사이에 문자를 추가한다
        // kintex -> 176, 'kkintex 와 k'kintex는 같다
        // aa -> 'aaa, a'aa, aa'a 같다

        // N + ... + 1 - s;

        bw.write(String.valueOf(26 * (N + 1) - N));
        bw.flush();
    }

}
