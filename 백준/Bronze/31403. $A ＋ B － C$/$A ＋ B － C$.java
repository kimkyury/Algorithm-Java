import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;

    static int[] heap;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        bw.write((A + B - C) + "\n");
        bw.write((Integer.parseInt(sb.append(A).append(B).toString()) - C) + "");

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
