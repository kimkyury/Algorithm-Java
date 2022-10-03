import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int C; // capacity
    static int N;
    static int[] weight;
    static int max = Integer.MIN_VALUE;

    // 1번부터 시작
    public void solve(int level, int sum) {

        // 수용량을 넘어서면 종료
        if (sum > C) {
            return;
        }

        // leaf 도달 시에 확인할 것
        if (level == N) {
            if (max < sum) {
                max = sum;
            }
            return;
        }

        sum += weight[level];
        solve(level + 1, sum);

        sum -= weight[level];
        solve(level + 1, sum);

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        weight = new int[N];

        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        main.solve(0, 0);
        System.out.println(max);

    }
}