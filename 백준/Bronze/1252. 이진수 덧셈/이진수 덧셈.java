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

        BigInteger num1 = new BigInteger(str1, 2);
        BigInteger num2 = new BigInteger(str2, 2);

        BigInteger sum =num1.add(num2);

        bw.write(sum.toString(2));
        bw.flush();
    }

}
