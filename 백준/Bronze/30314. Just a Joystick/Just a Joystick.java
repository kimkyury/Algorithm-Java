import java.io.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static long N, M, T;
    static StringTokenizer st;
    static long max = 0;
    static long[] dp;

    public static void main(String[] args) throws IOException {

        // 원조는 3개 이니셜 허용, 현 기계는 더 ㅁ낳이 허용
        // up & down 문자 사이 다음문자 오른쪽으로
        //

        N = Integer.parseInt(br.readLine());

        String line1 = br.readLine();
        String line2 = br.readLine();

        long cnt = 0;
        for (int i = 0; i < N; i++) {

            int sub1 = Math.abs(line1.charAt(i) - line2.charAt(i));
            if (sub1 > 13)
                sub1 = 26 - sub1;

            int sub2 = Math.abs(line2.charAt(i) - line1.charAt(i));
            if (sub2 > 13)
                sub2 = 26 - sub2;

            cnt += Math.min(sub1, sub2);
        }

        bw.write((cnt) + "");
        bw.flush();
    }

}
