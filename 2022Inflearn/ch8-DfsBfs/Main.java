import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N, F;
    static int[] binomialCoefficient;
    static int[] permutation;
    static boolean[] isPassed;
    boolean flag = false;

    static int[][] dy = new int[35][35];

    public static int saveBiomialCoefficient(int num, int require) {

        if (dy[num][require] != 0)
            return dy[num][require];

        if (require == num || require == 0)
            return dy[num][require] = 1;

        return saveBiomialCoefficient(num - 1, require) + saveBiomialCoefficient(num - 1, require - 1);

    }

    public void solve(int level, int sum) {

        if (sum > F || flag == true) {
            return;
        }

        if (level == N) { //
            if (sum == F) {
                for (int x : permutation) {
                    System.out.print(x + " ");
                }
                flag = true;
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isPassed[i]) {
                isPassed[i] = true; //
                permutation[level] = i;

                solve(level + 1, sum + (binomialCoefficient[level] * permutation[level]));
                isPassed[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        permutation = new int[N];
        binomialCoefficient = new int[N];
        isPassed = new boolean[N + 1];

        // 이항계수 세팅
        for (int i = 0; i < N; i++) {
            binomialCoefficient[i] = saveBiomialCoefficient(N - 1, i);
        }

        main.solve(0, 0);

    }

}