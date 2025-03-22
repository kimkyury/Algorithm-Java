
import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static int K;

    public static void main(String[] args) throws IOException {

        // 히드라의 머 그ㅇ 자르
        // 자르기 &

        K = Integer.parseInt(br.readLine()); // < 50

        for (int k = 1; k <= K; k++) {

            int max = Integer.parseInt(br.readLine());
            int cnt = max;
            String str = br.readLine();

            for (char c : str.toCharArray()) {
                if (c == 'b') {
                    // 지지면 더 안 생김
                    max--;
                    cnt--;
                } else {
                    // 머리 더 나옴 2개 나옴

                    cnt += 1;
                }
            }

            bw.write("Data Set " + k + ":\n" + cnt + "\n\n");
        }

        bw.flush();

    }
}