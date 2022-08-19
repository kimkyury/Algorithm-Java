import java.io.*;
import java.util.*;
import java.lang.Math;

public class baek_2475 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int remainder = 0;
        String str;
        while (st.hasMoreTokens()) {
            str = st.nextToken();
            remainder += Math.pow(Integer.parseInt(str), 2);
        }

        remainder = remainder % 10;
        System.out.print(remainder);
    }
}
