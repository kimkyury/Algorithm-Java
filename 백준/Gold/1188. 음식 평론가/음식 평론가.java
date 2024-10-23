import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;

    public static void main(String[] args) throws IOException {

        // 1. 소세지를 한 줄로 세운다
        // 2. 하나의 소세지로 생각했을 때, M명의 사람에게 나눠준다면?
        // 3. 전체적으로는 1/M이다.
        // 4. GCD = 소세지와 평론가를 그룹으로 나눈다

        // 1. 소세지를 한 줄로 세웠다
        // 2. 각 소세지에 요리사를 분배시킨다
        // 3. 각 영역을 충족하도록 소세지를 썬다

        // M -
        // [m1 m2 m3] [m1 m2 m3]
        // [m1 m2 m3] [m1 m2 m3]

        // 2개를 5명한테?
        // [m1 m2 | m3 m4 | m5] [m1 | m2 m3 |m4 m5]

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bw.write(M - gcd(N, M) + "");
        bw.flush();
    }

    // 6, 2 -> 0, 2 -> 13, 5 -> 8, 5 -> 3, 5 ->
    public static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

}