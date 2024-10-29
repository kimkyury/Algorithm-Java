import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static StringTokenizer st;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, K;
    static int cnt;
    static boolean[] possible;
    static int MAX = 1000001;

    public static void main(String[] args) throws IOException {

        possible = new boolean[MAX];

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            possible[num] = true;
        }

        List<Integer> result = LCM();

        if (result.size() == 0) {
            bw.write("-1");
            bw.flush();
            return;
        }

        long multi = 1;
        for (int r : result) {
            multi *= r;
        }

        // 1. 소수만 고르기
        // 2. 최소 공배수를 구하기 -> 소수들의 곱

        bw.write(multi + "");
        bw.flush();
    }

    public static List<Integer> LCM() {

        List<Integer> result = new ArrayList<>();

        for (int i = 2; i < Math.sqrt(MAX); i++) {
            for (int j = 2; j * i < MAX; j++) {
                possible[j * i] = false;
            }
        }

        for (int i = 2; i < MAX; i++) {
            if (possible[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public static void show(int[][] map) {

        System.out.println("------------------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

}