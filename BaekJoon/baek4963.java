import java.io.*;
import java.util.*;

public class baek4963 {
    static int w, h;
    static int[][] map;
    static boolean[] passed;
    static Deque<Integer> standbyList = new ArrayDeque<Integer>();

    static int[] x = { 1, 1, 1, 0, 0, -1, -1, -1 };
    static int[] y = { 1, 0, -1, 1, -1, 1, 0, -1 };
    static int cnt;

    static void dfs() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지도의 크기를 받았다
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        // "0 0"을 입력받으면 출력을 위한 baek4963실행
        if (w == 0 && h == 0) {
            dfs();
        }

        map = new int[w][h];
        // 지도의 h행 수만큼 열의 정보를 받는다
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            // i번 마다 w번 자르기
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}