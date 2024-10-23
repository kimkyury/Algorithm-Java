import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    // static int N, M;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static char[][] map;
    static int N;

    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };

    static boolean removedRoot = false;

    public static void main(String[] args) throws IOException {

        // 모든 지적 생명체는 동등하다, 돈을 똑같이 분배해야한다, 동일하게 분배하고 남는 돈은?

        st = new StringTokenizer(br.readLine());
        BigInteger total = new BigInteger(st.nextToken());
        BigInteger cnt = new BigInteger(st.nextToken());

        BigInteger share = total.divide(cnt);
        BigInteger remainder = total.mod(cnt);

        bw.write(share + "\n" + remainder);
        bw.flush();

    }

}
