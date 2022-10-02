import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] set;
    static boolean[] isPassed;
    static int N;
    static boolean flag;
    static int aimSum;

    // 1번부터 시작
    public void solve(int level) {
        if (flag == true) {
            return;
        }

        // 부분집합이 완성된 leaf에 도달하면
        if (level == N) {
            int sumSubSet1 = 0;
            int sumSubSet2 = 0;

            for (int i = 0; i < N; i++) {
                if (isPassed[i] == true) {
                    sumSubSet1 += set[i];
                } else {
                    sumSubSet2 += set[i];
                }
            }

            if (sumSubSet1 == sumSubSet2) {
                System.out.println("YES");
                flag = true;
            }
            return;

        }

        isPassed[level] = true;
        solve(level + 1);
        isPassed[level] = false;
        solve(level + 1);

        return;

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        set = new int[N];
        isPassed = new boolean[N];
        aimSum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set[i] = Integer.parseInt(st.nextToken());
            aimSum += set[i];
        }

        aimSum /= 2;

        main.solve(1);

        if (flag == false) {
            System.out.println("NO");
        }

    }
}