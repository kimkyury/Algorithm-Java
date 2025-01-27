import java.io.*;

import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, T;
    static StringTokenizer st;

    static boolean[] isLeft;

    // static List<Integer> arr;
    static ArrayDeque<Integer> dq;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 4줄 짜리 줄임

        int[] pos1 = { (v1 + 3) % 4, (v1 + 3) / 4 - 1 }; // (2, 2)
        int[] pos2 = { (v2 + 3) % 4, (v2 + 3) / 4 - 1 }; // ( 0,8)

        bw.write((Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1])) + "\n");

        bw.flush();
    }

}
