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

        int N = Integer.parseInt(br.readLine());

        // 팩토리얼의 마지막 자릿수만 뱉기
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            int result = 1;

            for (int j = 2; j <= num; j++) {
                result *= j;
            }

            bw.write((result % 10) + "\n");
        }
        bw.flush();
    }

}
