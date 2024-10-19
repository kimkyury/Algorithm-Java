import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static char[][] map;
    static int[][] cntMap;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int maxCnt = 0;
    static boolean isEnd;
    static int[] dy = { 0, 1 };
    static int[] dx = { 1, 0 };

    public static void main(String[] args) throws IOException {

        // BFS?
        // 1. 해당 횟수만큼 직접 나아가기 -> 10^7 ㅏㅏㅏㅏㅏㅏ

        N = Integer.parseInt(br.readLine());

        int sum = 0;
        int idx = 1;

        // idx 가 홀수면 분모 증가
        String result = "";
        while (true) {

            if (N <= sum + idx) {
                int diff = N - sum;
                if (idx % 2 == 0) {
                    result = (N - sum) + "/" + (idx - (N - sum) + 1);
                    break;
                } else {
                    result = (idx - (N - sum) + 1) + "/" + (N - sum);
                    break;
                }
            } else {
                sum += idx++;
            }
        }

        // 수식 : (N-sum , idx - diff)

        bw.write(result);
        bw.flush();
    }

    public static void DFS(int cnt, int y, int x, boolean[][] passed) {

    }

}
