import java.io.*;

import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, T;
    static int arr[];

    public static void main(String[] args) throws IOException {

        // 최종적으로 두 개의 수가 남았을 때, a > b ? 상근 : 창영

        T = Integer.parseInt(br.readLine());

        String winner = "";
        for (int t = 1; t <= T; t++) {

            N = Integer.parseInt(br.readLine());

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            calcul();

            winner = arr[0] > arr[1] ? "Alice" : "Bob";
            bw.write("Case #" + t + ": " + winner + "\n");
        }

        bw.flush();
    }

    static void calcul() {

        int size = arr.length;
        while (true) {

            if (size == 2) {
                return;
            }

            for (int i = 0; i < size / 2; i++) {
                arr[i] += arr[size - 1 - i];
            }

            if (size % 2 == 1) {
                arr[size / 2] += arr[size / 2];
                size = size / 2 + 1;
            } else {
                size /= 2;
            }
        }
    }
}
