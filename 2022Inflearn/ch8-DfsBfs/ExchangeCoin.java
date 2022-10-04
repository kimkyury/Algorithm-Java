import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    static int N;
    static Integer unit[];
    static int M;

    static int min = Integer.MAX_VALUE;

    // 1번부터 시작
    public void solve(int level, int sum) {

        if (sum > M || level >= min) {
            return;
        }

        if (sum == M) {
            if (level < min) {
                min = level;
            }

            return; // level == 동전의 개수
        }

        for (int i = 0; i < N; i++) {
            solve(level + 1, sum + unit[i]);
        }

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        unit = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            unit[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(unit, Collections.reverseOrder());
        M = Integer.parseInt(br.readLine());

        main.solve(0, 0);

        System.out.println(min);
    }

}