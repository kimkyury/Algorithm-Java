import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[] binomialCoefficient;
    static int[][] dy = new int[11][11];
    static boolean isPassed[];
    static int[] combi;

    public static void solve(int level, int start) {

        if (level == M) {
            for (int i = 0; i < N; i++) {
                if (combi[i] != 0) {
                    System.out.print(combi[i] + " ");
                }

            }
            System.out.println(" ");
            return;
        }

        for (int i = start; i <= N; i++) {
            if (!isPassed[i]) {
                // 1~N까지에 대한 원소를 집어넣기
                combi[level] = i;
                // 이미 집어넣은 원소 N에 대해 사용 여부를 쳌크
                isPassed[i] = true;
                solve(level + 1, i + 1);
                isPassed[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        binomialCoefficient = new int[N + 1];
        isPassed = new boolean[N + 1];
        combi = new int[N];
        solve(0, 1);

    }

}