import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, K;
    static StringTokenizer st;
    static int[][] gems;
    static Integer[] bag;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 손익분기점을 넣는 시점 구하기

        // 총수입이총비용보다 많아지는 시점 구하기
        if (B >= C) {
            bw.write("-1");
            bw.flush();
            return;
        }

        // 최소한, 21000000/10 만큼은 팔아야함

        long cnt = Math.abs((A / (B - C)) - 1);

        bw.write(cnt + "");
        bw.flush();
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
