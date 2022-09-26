import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    // public static int[] arr = new int[100];

    public static int total = 1;

    public static void solution(int N) {

        if (N < 2) {
            return;
        }

        total *= N;
        solution(N - 1);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        solution(N);
        // int C = Integer.parseInt(st.nextToken());

        // int[] poss = new int[N];

        // st = new StringTokenizer(br.readLine());
        // for (int i = 0; i < N; i++) {
        // poss[i] = Integer.parseInt(st.nextToken());
        // }

        // System.out.println(solution(N, C, poss));

        System.out.print(total);

    }
}