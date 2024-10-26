import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;
    static int[] tree, arr;

    static List<Integer> sosu;

    static int MAX = 4000000;

    public static void main(String[] args) throws IOException {

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());

        bw.write(num1 + num2 + "");
        bw.flush();
    }

}
