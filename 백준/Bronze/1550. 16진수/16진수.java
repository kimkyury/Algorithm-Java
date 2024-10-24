import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, len;

    public static void main(String[] args) throws IOException {

        // 16^5 < int 범위

        String str = br.readLine();
        len = str.length();

        int result = dfs(str, 0, 0);

        bw.write(result + "");
        bw.flush();
    }

    public static int dfs(String str, int idx, int sum) {

        if (idx == str.length()) {
            return sum;
        }

        int num = (int) str.charAt(len - 1 - idx) - '0';
        if (num >= 17) {
            num -= 7;
        }

        sum += num * Math.pow(16, idx);

        return dfs(str, idx + 1, sum);
    }

}