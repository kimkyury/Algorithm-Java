import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M, T;
    static long[] arr;

    static long max = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken()) - 1;

        // N개의 방, 리프는 s번째 방
        // 몬스터를 죽이면서 Ai 받기

        // 1. 현재 위치에서, 죽을때의 최댓값을 DP로 관리하자
        // 2. 1 1 0 1 1 // 구간합 아닌가?
        // 우로 갔을 때 합이 최대인 것, 좌로 갔을때 합이 최대인 것 합한다면

        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 중심에서부터, lt rt를 늘려본다

        int lt = s, rt = s;
        long lMax = 0, rMax = 0;
        while (true) {

            lt = left(lMax, lt);
            lMax = max;

            rt = right(rMax, rt);
            rMax = max;

            if (lMax == rMax) {
                break;
            }
        }
        // 좌로 갔을 떄의 MAX를 가져온다,

        // MAX를 들고 우로 갔을 때의 MAX를 가져온다

        // 좌우를 번갈아 가는데, max가 더 이상 변하지 않는다면 끝

        // 좌, 우로 최대한 가본다
        // 각 방향에서 막힐 때, 반대방향의 max를 더하며 끝점까지 가본다

        bw.write(max + "");
        bw.flush();

    }

    static int left(long sum, int lt) {

        if (lt == -1) {
            return lt;
        }

        long curSum = max - sum + arr[lt];
        lt--;
        while (true) {

            if (lt < 0) {
                return lt;
            }
            if (curSum + arr[lt] < 0) {
                return lt + 1;
            }

            arr[lt] += curSum;
            curSum = arr[lt];
            max = Math.max(curSum, max);
            lt--;
        }
    }

    static int right(long sum, int rt) {

        if (rt == N) {
            return rt;
        }

        // 현재 점수 변화량: 최대값 - {직전의최대값} + 현재 얻을 수 있는 포인트
        long curSum = max - sum + arr[rt];
        rt++;
        while (true) {

            if (rt > N - 1) {
                return rt;
            }

            if (curSum + arr[rt] < 0) {
                return rt - 1; // 현재순번 대기
            }

            // 전
            arr[rt] += curSum; // 누적된 점수 저장
            curSum = arr[rt];
            max = Math.max(curSum, max);
            rt++;
        }
    }

    static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > 1 || x > N - 1) {
            return true;
        }
        return false;

    }
}
