import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static long M;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        // M = Long.parseLong(st.nextToken());

        // st = new StringTokenizer(br.readLine());

        // LIS 구하기

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        bw.write(search(arr) + "");
        bw.flush();

    }

    public static int dp(int[] arr) {

        int[] lis = new int[N];
        for (int i = 0; i < N; i++) {
            lis[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        return lis[N - 1];
    }

    public static int search(int[] arr) {

        int[] lis = new int[N + 1];
        lis[0] = arr[0];

        int cnt = 0, i = 0;

        // 1. arr를 순회한다
        // 2. lis가 가능하다면 목차에 넣어준다
        // 3. lis에 불가능하다면 이전 자리에 끼워넣어준다
        while (i < N) {

            if (lis[cnt] < arr[i]) {
                lis[++cnt] = arr[i];
            } else {

                int idx = binary(0, cnt, arr[i], lis);
                lis[idx] = arr[i];
            }
            i++;
        }

        return cnt + 1;
    }

    public static int binary(int lt, int rt, int tgt, int[] lis) {

        while (lt < rt) {
            int mid = lt + (rt - lt) / 2;
            if (lis[mid] < tgt) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }

        return rt;
    }
}
