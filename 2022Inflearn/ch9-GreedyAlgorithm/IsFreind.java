import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N, M; // 입력정보
    static int f1, f2;
    static int[] unf;

    // 친구 v를 unf[v]에
    public static int find(int v) {
        if (v == unf[v]) // 1 == unf[1]
            return unf[v]; // 1
        else
            return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b) {

        int fa = find(a); // a=1, fa = 1
        int fb = find(b); // b = 2, fa = 2

        if (fa != fb) { // 1 != 2
            unf[fa] = fb; // unf[1] = 2
        }

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 집합에 대한 초기화
        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            unf[i] = i; // 1, 2, 3, 4, 5, 6, 7
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            union(v1, v2); // 친구관계로 묶기 ex 1 2

        }

        st = new StringTokenizer(br.readLine());
        f1 = Integer.parseInt(st.nextToken());
        f2 = Integer.parseInt(st.nextToken());

        int result1 = find(f1);
        int result2 = find(f2);

        if (result1 == result2) {
            System.out.println("YES");
        } else {

            System.out.println("NO");

        }
    }

}