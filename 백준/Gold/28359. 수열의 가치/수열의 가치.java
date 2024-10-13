import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static int[][] map;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        // 감소하지 않는 부분 수열 P
        // 증가하지 않는 부분 수열 Q
        // Sum(P) + Sum(Q)의 최댓값

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(arr);

        // 배열의 합을 구한다
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        // 중복된 원소를 찾아 더한다
        int maxCnt = 0;
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == arr[j]) {
                    cnt++;

                }
            }
            maxCnt = Math.max(maxCnt, cnt * i);
        }

        bw.write((sum + maxCnt) + "\n");
        for (int i : arr) {
            bw.write(i + " ");
        }
        bw.flush();
    }

}