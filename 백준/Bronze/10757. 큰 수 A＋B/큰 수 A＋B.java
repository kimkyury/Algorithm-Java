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

        st = new StringTokenizer(br.readLine());

        BigInteger num1 = new BigInteger(st.nextToken());
        BigInteger num2 = new BigInteger(st.nextToken());

        bw.write(num1.add(num2) + "");
        bw.flush();
    }

}
