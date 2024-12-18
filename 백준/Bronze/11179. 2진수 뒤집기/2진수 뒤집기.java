import java.io.*;

import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M, K;
    static int arr[];

    public static void main(String[] args) throws IOException {

        // 수 -> 역 이진법

        N = Integer.parseInt(br.readLine());
        String binary = Integer.toBinaryString(N);

        StringBuilder sb = new StringBuilder(binary);
        sb.reverse();

        // bw.write(sb.toString() + "\n");
        long result = get10Num(sb.toString());

        bw.write(result + "\n");
        // 1. 2진법

        // 2. 2진수 뒤집기

        // 3. 10진법

        bw.flush();
    }

    static long get10Num(String binary) {

        // 끝자리에서 부터 더해버리자

        int d = 1;
        int pos = binary.length() - 1;

        long result = 0;
        while (true) {

            if (pos == -1) {
                break;
            }

            result += (binary.charAt(pos) - '0') * d;

            pos--;
            d *= 2;
        }

        return result;
    }

}
