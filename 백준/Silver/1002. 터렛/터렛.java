import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static int[][] map;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] dy = { 0, 0, -1, 1 };
    static int[] dx = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {

        // 류재명이 있을 수 있는 좌표의 수
        // 조규현의 거리반경과, 백승환의 거리 반경이 일치하는 곳

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            st = new StringTokenizer(br.readLine());
            int[] joP = { Integer.parseInt(st.nextToken()) + 10000, Integer.parseInt(st.nextToken()) + 10000 };
            int joR = Integer.parseInt(st.nextToken());

            int[] bcP = { Integer.parseInt(st.nextToken()) + 10000, Integer.parseInt(st.nextToken()) + 10000 };
            int bcR = Integer.parseInt(st.nextToken());

            // 원의 교점을 구하기
            // 두 지점의 차이를 구한다
            double distance = Math.sqrt(Math.pow((joP[0] - bcP[0]), 2) + Math.pow((joP[1] - bcP[1]), 2));

            int result = 0;
            if (distance == 0 && joR != bcR) {
                result = 0;
            } else if (distance == 0 && joR == bcR) {
                result = -1;
            } else if (distance == joR + bcR) {
                result = 1;

                // 내접의 경우
            } else if (distance == Math.abs(joR - bcR)) {
                result = 1;

                // 두 반지름의 차이는, 두 원의 중심의 거리보다 커야 인정된다
            } else if (distance < (joR + bcR) && distance > Math.abs(joR - bcR)) {
                result = 2;
            }

            bw.write(result + "\n");
        }
        bw.flush();
    }
}