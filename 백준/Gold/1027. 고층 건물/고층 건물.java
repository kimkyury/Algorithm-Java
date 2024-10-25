import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    // static int N, M;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static char[][] map;
    static int N, C, W;

    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };

    static boolean removedRoot = false;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        // i번째 빌딩: (i, 0) - (i, 높이)
        // 두 지붕을 잇는 선분이 A 와 B를 제외한 고층 빌딩을 안 지나야함
        // 한 지붕에서, 다른 지붕으로 가는 기울기를 구한다
        // Set으로, 한 지붕에서 다른 지붕으로 갈 때의 기울기를 넣는다
        // 기울이의 절대값이 같거나 더 크다면, 카운팅 하지 않는다

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxCnt = 0;
        for (int i = 0; i < N; i++) {

            int cnt = count(i);
            maxCnt = Math.max(maxCnt, cnt);
        }

        bw.write(maxCnt + "");
        bw.flush();

    }

    public static int count(int idx) {

        int cnt = 0;

        // 좌측보기: 왼쪽에서 오른쪽 방향으로 바라보는 기울기 비교
        double min = Double.POSITIVE_INFINITY;
        for (int i = 1; idx - i >= 0; i++) {
            double cur = (double) (arr[idx] - arr[idx - i]) / i; // [나 - 상대], 상대가 높을 수록 음수가 됨

            if (cur >= min) {
                continue;
            }

            // 기울기가 더 작아져야, 음수에 가까워 져야 인정
            min = cur;
            cnt++;
        }

        // 우측보기: 오른쪽에서 왼쪽 방향으로 바라보는 기울기 비교
        min = Double.NEGATIVE_INFINITY;
        for (int i = 1; idx + i < N; i++) {
            double cur = (double) (arr[idx + i] - arr[idx]) / i; // [상대 - 나], 상대가 높을수록 양수가 됨

            if (cur <= min) {
                continue;
            }

            min = cur;
            cnt++;
        }

        return cnt;
    }

}
