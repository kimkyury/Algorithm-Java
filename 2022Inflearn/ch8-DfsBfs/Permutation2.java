import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int arr[];
    static boolean isAdded[];
    static int pm[];
    static int M;

    static int min = Integer.MAX_VALUE;

    public void solve(int level) {

        if (level == M) {
            for (int x : pm)
                System.out.print(x + " ");

            System.out.println("");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isAdded[i]) {
                isAdded[i] = true;
                pm[level] = arr[i];

                solve(level + 1);
                isAdded[i] = false;

            }
        }

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isAdded = new boolean[N];
        arr = new int[N];
        pm = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        main.solve(0);

    }

}