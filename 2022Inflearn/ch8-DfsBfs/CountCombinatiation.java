import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N, R;
    static int[][] dy = new int[35][35]; // r의 종류

    public int solve(int level, int R) {

        if (dy[level][R] != 0) {
            return dy[level][R];
        }

        if (level == R || R == 0) {
            return dy[level][R] = 1;
        }

        return dy[level][R] = solve(level - 1, R) + solve(level - 1, R - 1);

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        System.out.println(main.solve(N, R));

    }

}