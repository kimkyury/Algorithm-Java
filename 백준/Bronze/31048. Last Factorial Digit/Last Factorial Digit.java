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
            // 1~4와 그 이상은 정해져 있다

            switch (num) {
                case 1:
                    bw.write("1\n");
                    break;
                case 2:
                    bw.write("2\n");
                    break;
                case 3:
                    bw.write("6\n");
                    break;
                case 4:
                    bw.write("4\n");
                    break;

                default:
                    bw.write("0\n");

            }

        }
        bw.flush();
    }

}
