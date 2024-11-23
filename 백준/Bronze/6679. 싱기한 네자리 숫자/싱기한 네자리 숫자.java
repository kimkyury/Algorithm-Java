import java.io.*;
import java.util.*;
import java.math.*;
import java.util.concurrent.Semaphore;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;

    static int[] heap;
    static StringBuilder sb = new StringBuilder();

    static int DIVIDE = 1000;
    static int[][] result;
    static int max = 0;

    static int[] arr;

    public static void main(String[] args) throws IOException {

        // 숫자를 10, 12, 16으로 나타내기
        // 1000~9999

        for (int i = 1000; i < 10000; i++) {

            int sum10 = sum(i, 10);

            int sum12 = sum(i, 12);

            int sum16 = sum(i, 16);

            if (sum10 == sum12 && sum12 == sum16) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
    }

    private static int sum(int n, int base) {

        int result = 0;

        while (n > 0) {
            result += n % base; // 가장 낮은 자리 수 부터 추출, 1111(15) -> 15%2 -> 7, 7%2 -> 3 1 0
            n /= base; // 낮은 자리수 이동
        }

        return result;

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
