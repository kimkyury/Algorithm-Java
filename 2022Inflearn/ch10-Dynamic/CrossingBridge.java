import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N, M;
    static int dy[];

    public static void solution() {

        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= N + 1; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }

        System.out.println(dy[N + 1]);

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dy = new int[N + 2];
        // M = Integer.parseInt(st.nextToken());

        solution();
        // int answer = main.solution(N);

    }

}