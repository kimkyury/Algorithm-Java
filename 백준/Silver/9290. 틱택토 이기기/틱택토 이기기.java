import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        // 현재 sign이 무엇인가에 따라서 이길 수 있는 위치 찾기
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            Queue<int[]> q = new ArrayDeque<>();
            char[][] map = new char[3][3];
            for (int i = 0; i < 3; i++) {

                String str = br.readLine();
                for (int j = 0; j < 3; j++) {
                    char c = str.charAt(j);

                    if (c == '-') {
                        int[] pos = { i, j };
                        q.offer(pos);
                    }
                    map[i][j] = c;
                }
            }

            char sign = br.readLine().charAt(0);
            while (!q.isEmpty()) {
                // 현재 삽입된 좌표가 성립하는지 확인
                if (insert(map, sign, q.poll())) {
                    break;
                }
            }

            bw.write("Case " + t + ":\n");
            for (int i = 0; i < 3; i++) {
                bw.write(String.valueOf(map[i]) + "\n");
            }
        }

        bw.flush();
    }

    private static boolean insert(char[][] map, char sign, int[] pos) {
        map[pos[0]][pos[1]] = sign;

        // 성립 확인
        for (int i = 0; i < 3; i++) {
            int rCnt = 0;
            int cCnt = 0;

            for (int j = 0; j < 3; j++) {

                if (map[i][j] == sign) { // x++
                    rCnt++;
                }

                if (map[j][i] == sign) { // y++
                    cCnt++;
                }
            }

            if (rCnt == 3 || cCnt == 3) {
                return true;
            }
        }

        int upCnt = 0; // 우상향
        int downCnt = 0; // 우하향
        for (int i = 0; i < 3; i++) {

            if (map[i][i] == sign) {
                downCnt++;
            }
            if (map[i][2 - i] == sign) {
                upCnt++;
            }
        }

        if (upCnt == 3 || downCnt == 3) {
            return true;
        }

        map[pos[0]][pos[1]] = '-'; // 원복
        return false;
    }

    private static void print(int[][] map) {
        System.out.println("-----------------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
}