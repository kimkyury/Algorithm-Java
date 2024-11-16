import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;
    static int[][] tree;

    public static void main(String[] args) throws IOException {

        // 선택된 수의 합이 최대가 되는 경로를 구하기

        // N = Integer.parseInt(br.readLine());

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        bw.write(a.add(b) + "\n" + a.subtract(b) + "\n" + a.multiply(b));

        // bw.write(dp() + "");
        bw.flush();
    }

    private static void show(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
