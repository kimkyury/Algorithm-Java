import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static StringTokenizer st;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, Q;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        String facResult = factorial(N).toString();
        // System.out.println("\nRESULT: " + facResult);

        int idx = 0;
        int len = facResult.length() - 1;
        while (true) {
            if (facResult.charAt(len - idx) != '0') {
                break;
            }
            idx++;
        }

        bw.write(idx + "");
        bw.flush();
    }

    public static BigInteger factorial(int i) {

        if (i == 0) {
            return new BigInteger("1");
        }

        return factorial(i - 1).multiply(new BigInteger(String.valueOf(i)));
    }
}