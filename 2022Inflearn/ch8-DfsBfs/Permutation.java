import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int M;
    static int[] combination;

    // 1번부터 시작
    public void solve(int level) {

        // leaf에서 최종 개수를 확인한다
        if (level == M) {
            for (int x : combination) {
                System.out.print(x + " ");
            }
            System.out.println("");
            return;

        } else {
            // 각 원소를 조합에 삽입한다
            for (int i = 1; i <= N; i++) {
                combination[level] = i;
                solve(level + 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        combination = new int[M];

        main.solve(0);

    }
}