import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static int[][] map;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        // gCnt, winCnt (Z% (소수점버림))
        // 최소 몇 번을 더 해야 Z가 변하는가?

        // 10, 8 -> 8/10 -> 승률은 80%
        // 10, 9 -> 9/10 -> 승률은 90%

        // 100, 80 -> 80%
        // 100, 81 -> 81%
        st = new StringTokenizer(br.readLine());
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());

        long Z = ((Y * 100 / X));

        long result = search(X, Y, Z);

        bw.write(result + "");
        bw.flush();
    }

    // Y와 X 사이를 번갈아 가며, 변하는 가장 작은 지점을 찾는다
    public static long search(long X, long Y, long Z) {
        // Z = 최초 승률
        // X가 더 큼
        long lt = 0;
        long rt = 1000000000; // rt는 X보다 더 클 수 있다

        long result = -1; // 답은 -1부터!!
        while (lt <= rt) { // 바뀌지 않는다면 result는 -1일 것이다

            long mid = (lt + rt) / 2;
            long nx = X + mid;
            long ny = Y + mid;

            long rate = ny * 100 / nx;
            if (Z < rate) {

                rt = mid - 1; // 기존보다 큰값을 찾았다면, 범위를 앞으로 가보자 ( 더 작은 값 찾기)
                result = mid;
            } else {
                lt = mid + 1; // 기존보다 작은 값이라면 범위를 뒤로 가보자
            }
        }
        return result;
    }

}

// 1000000000
// 470000000