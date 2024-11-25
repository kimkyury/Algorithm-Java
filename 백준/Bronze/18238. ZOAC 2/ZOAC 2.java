import java.io.*;
import java.util.*;
import java.math.*;
import java.time.LocalDate;
import java.util.concurrent.Semaphore;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;

    static int[] arr;

    public static void main(String[] args) throws IOException {

        String line = br.readLine();

        // 왼쪽 또는 오른쪽
        int cnt = 0;
        int pos = 'A' - '0';
        for (int i = 0; i < line.length(); i++) {

            int diff = Math.abs(pos - (line.charAt(i) - '0'));

            if (diff > 12) {
                diff = 26 - diff;
            }

            cnt += diff;
            pos = line.charAt(i) - '0';
        }

        bw.write(cnt + "");
        bw.flush();
    }

    public static void solve() {

        // 문자열을 출력하는 데 걸리는 시간의 최솟값

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
