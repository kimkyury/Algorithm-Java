import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M, R;

    static int lcs[][][];

    public static void main(String[] args) throws IOException {

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        char[] str3 = br.readLine().toCharArray();

        lcs(str1, str2, str3);
        int len = lcs[str1.length][str2.length][str3.length];
        // char[] result = tracking(str1.length, str2.length, new char[len], str1, str2,
        // len - 1);
        // System.out.print(Arrays.toString(result));

        bw.write(len + "");
        bw.flush();
    }

    public static void lcs(char[] str1, char[] str2, char[] str3) {

        lcs = new int[str1.length + 1][str2.length + 1][str3.length + 1];

        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                for (int k = 1; k <= str3.length; k++) {

                    if (str1[i - 1] == str2[j - 1] && str2[j - 1] == str3[k - 1]) {
                        lcs[i][j][k] = lcs[i - 1][j - 1][k - 1] + 1;
                    } else {
                        int max = Math.max(lcs[i - 1][j][k], lcs[i][j - 1][k]);
                        max = Math.max(max, lcs[i][j][k - 1]);
                        lcs[i][j][k] = max;
                    }
                }
            }
        }
    }

    public static void print(int map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
