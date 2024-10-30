import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M, R;

    static int[] depth;
    static List<List<Integer>> arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        // 1부터 N 중에서, 순열로 뽑는다
        String line = br.readLine();

        bw.write(confirm(line) + "");
        bw.flush();
    }

    public static int confirm(String str) {

        int lt = 0, rt = str.length() - 1;

        while (lt < rt) {
            if (str.charAt(lt) != str.charAt(rt)) {
                return 0;
            }
            lt++;
            rt--;
        }
        return 1;
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
