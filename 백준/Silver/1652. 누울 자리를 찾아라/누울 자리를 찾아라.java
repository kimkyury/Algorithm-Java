import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static StringTokenizer st;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, K;
    static int cnt;
    static char[][] map;

    public static void main(String[] args) throws IOException {

        // NxN
        // 연속해서 2칸 이상의 빈칸

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // ....X
        // ..XX.
        // .....
        // .XX..
        // X....

        int rowCnt = 0;
        boolean[][] passed = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (passed[i][j]) {
                    continue;
                }

                int len = 0;
                while (j < N) {
                    if (map[i][j] == 'X') {
                        break;
                    }
                    len++;
                    passed[i][j] = true;
                    j++;
                }

                if (len >= 2) {
                    rowCnt++;
                }
            }
        }

        passed = new boolean[N][N];
        int colCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (passed[j][i]) {
                    continue;
                }

                int len = 0;
                while (j < N) {
                    if (map[j][i] == 'X') {
                        break;
                    }
                    len++;
                    passed[j][i] = true;
                    j++;
                }

                if (len >= 2) {
                    colCnt++;
                }
            }
        }

        bw.write(rowCnt + " " + colCnt);
        bw.flush();
    }

    public static void show(int[][] map) {

        System.out.println("------------------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

}