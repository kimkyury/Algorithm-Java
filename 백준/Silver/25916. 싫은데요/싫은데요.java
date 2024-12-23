import java.io.*;

import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static StringTokenizer st;
    static long max = 0;
    static int[] tree, arr;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 구멍 개수
        M = Integer.parseInt(st.nextToken()); // 햄스터 부피

        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, rt = 0;
        long sum = 0;
        while (rt < N) {

            sum += arr[rt];

            while (sum > M) {
                sum -= arr[lt];
                lt++;
            }

            max = Math.max(max, sum);
            rt++;
        }

        bw.write(max + "");
        bw.flush();
    }

}
