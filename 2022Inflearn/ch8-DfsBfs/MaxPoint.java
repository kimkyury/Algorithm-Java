import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int M; //
    static int N;
    static int[] times;
    static int[] points;

    static int max = Integer.MIN_VALUE;

    // 1번부터 시작
    public void solve(int level, int sumTime, int sumPoint) {

        // 제한시간 초과
        if (sumTime > M) {
            return;
        }

        if (level == N) {
            if (sumPoint > max) {
                max = sumPoint;
            }
            return;
        }

        solve(level + 1, sumTime + times[level], sumPoint + points[level]);
        solve(level + 1, sumTime, sumPoint);

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        points = new int[N];
        times = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = Integer.parseInt(st.nextToken());
            times[i] = Integer.parseInt(st.nextToken());
        }

        main.solve(0, 0, 0);
        System.out.println(max);

    }
}