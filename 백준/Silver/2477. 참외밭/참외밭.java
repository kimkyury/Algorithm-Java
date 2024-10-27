import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;
    static int[] tree, arr;

    static int[][] map;

    public static void main(String[] args) throws IOException {

        // 참외밭, 반시계방향으로 둘레가 주어진다
        // 테두리 다 그린뒤 첫 점에서 DFSㅌㄹㅁㄴㅇㄹㅁㄴㅇㅌxxxx

        N = Integer.parseInt(br.readLine());

        String line = "";

        // map의 중간 : map[500][500]

        int[] lenByIdx = new int[6];
        int maxX = 0, maxXIdx = -1;
        int maxY = 0, maxYIdx = -1;
        for (int i = 0; i < 6; i++) {
            // 큰 사각변의 길이를 찾고, 그 변 길이에 인접한 곳을 찾아 뺀 만큼의 사각형을 구해서 전체 넓이에 뺀다

            line = br.readLine();

            int dir = Integer.parseInt(line.split(" ")[0]) - 1;
            int len = Integer.parseInt(line.split(" ")[1]);

            lenByIdx[i] = len;
            if (dir == 0 || dir == 1) {
                if (maxX < len) {
                    maxX = len;
                    maxXIdx = i;
                }
            } else {
                if (maxY < len) {
                    maxY = len;
                    maxYIdx = i;
                }
            }
        }

        // 가장 길었던 x,y Idx의 인접한 것중 짧은 것을 구한다
        // -1 -> 5로 만들고 싶다

        int adjX1 = lenByIdx[(maxXIdx - 1 + 6) % 6];
        int adjX2 = lenByIdx[(maxXIdx + 1) % 6];
        int adjY = adjX1 < adjX2 ? adjX1 : adjX2;

        int adjY1 = lenByIdx[(maxYIdx - 1 + 6) % 6];
        int adjY2 = lenByIdx[(maxYIdx + 1) % 6];
        int adjX = adjY1 < adjY2 ? adjY1 : adjY2;

        int result = maxX * maxY - ((maxX - adjX) * (maxY - adjY));
        result *= N;

        bw.write(result + "");
        bw.flush();
    }

    public static void print(int map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }

    }

}
