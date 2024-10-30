import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static StringTokenizer st;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, K;
    static int cnt;
    static int[][] lcs;
    static char[] strA, strB;

    public static void main(String[] args) throws IOException {

        strA = br.readLine().toCharArray();
        strB = br.readLine().toCharArray();

        lcs = new int[strA.length + 1][strB.length + 1];

        lcs();

        int cnt = lcs[strA.length][strB.length];
        char[] result = search(cnt, strA.length, strB.length, new char[cnt]);

        if (cnt == 0) {
            bw.write("0");
            bw.flush();
            return;
        }

        bw.write(cnt + "\n" + String.valueOf(result));
        bw.flush();
    }

    private static void lcs() {

        for (int i = 1; i <= strA.length; i++) {
            for (int j = 1; j <= strB.length; j++) {

                if (strA[i - 1] == strB[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }
    }

    private static char[] search(int cnt, int i, int j, char[] result) {

        if (cnt == 0
        // || i == 0 || j == 0
        ) {
            return result;
        }

        if (strA[i - 1] == strB[j - 1]) {
            result[cnt - 1] = strA[i - 1];
            return search(cnt - 1, i - 1, j - 1, result);
        } else {
            if (lcs[i - 1][j] > lcs[i][j - 1]) {
                return search(cnt, i - 1, j, result);
            } else {
                return search(cnt, i, j - 1, result);
            }
        }
    }

    public static void show(int[][] map) {

        System.out.println("------------------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

}