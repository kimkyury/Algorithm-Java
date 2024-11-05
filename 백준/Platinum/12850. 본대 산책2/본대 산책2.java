import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    // static int N, M;
    static long LIMIT = 1000000007;

    public static void main(String[] args) throws IOException {

        long D = Long.parseLong(br.readLine());

        // 1. 주어진 정보대로 인접행렬 표기하기
        // 1:정, 2:전, 3:미, 4:신, 5:한, 6:진, 7:학, 8:형
        // 2. map[a][b] = 1분만에 가는 거리
        long[][] map = {
                { 0, 1, 1, 0, 0, 0, 0, 0 }, // 정
                { 1, 0, 1, 1, 0, 0, 0, 0 }, // 전
                { 1, 1, 0, 1, 1, 0, 0, 0 }, // 미
                { 0, 1, 1, 0, 1, 1, 0, 0 }, // 신
                { 0, 0, 1, 1, 0, 1, 0, 1 }, // 한
                { 0, 0, 0, 1, 1, 0, 1, 0 }, // 진
                { 0, 0, 0, 0, 0, 1, 0, 1 }, // 학
                { 0, 0, 0, 0, 1, 0, 1, 0 } // 형
        };

        // 3. map[a][b] ^ 2 = 2분만에 가는 거리
        // 4. 분할정복
        // 5. 거듭제곱
        long[][] nMap = recur(map, D);

        // 0에서 0으로 가기
        bw.write((nMap[0][0] % LIMIT) + "");
        bw.flush();
    }

    public static long[][] recur(long[][] map, long D) {

        if (D == 1) {
            // 1초만에 가기
            return map;
        }

        if (D % 2 == 0) {
            // 반쪽으로 나누어서 제곱해버리기
            long[][] nMap = recur(map, D / 2);
            return calcul(nMap, nMap);
        } else {
            // 직전 순번까지 구해서(그럼 D%2로 가고) 마지막 순번 곱해주기
            long[][] nMap = recur(map, D - 1);
            return calcul(nMap, map);
        }
    }

    public static long[][] calcul(long[][] m1, long[][] m2) {

        long[][] nMap = new long[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    // 기존 + ( 경유지를 추가하여 곱한 수)
                    nMap[i][j] += (m1[i][k] * m2[k][j]) % LIMIT;
                    nMap[i][j] %= LIMIT;
                }
            }
        }
        return nMap;
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
