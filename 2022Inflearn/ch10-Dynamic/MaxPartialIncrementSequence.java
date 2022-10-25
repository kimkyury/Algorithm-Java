import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N, M;
    static int input[];
    static int dy[];

    public static void solution() {

        dy[1] = 1;

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            int max = 0;

            for (int j = i - 1; j >= 0; j--) {
                // 현재 수보단 작은 것들 중, 연결 수들의 최대값
                if (input[j] < input[i] && dy[j] > max) {
                    max = dy[j];

                }
            }

            dy[i] = max + 1;
            cnt = Math.max(cnt, dy[i]);

        }

        System.out.println(cnt);

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        input = new int[N + 1];
        dy = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        // M = Integer.parseInt(st.nextToken());

        solution();
        // int answer = main.solution(N);

    }

}