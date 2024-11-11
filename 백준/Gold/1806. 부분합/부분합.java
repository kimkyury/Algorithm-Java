import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minLength = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;

        while (end < N) {
            sum += arr[end];

            while (sum >= M) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= arr[start++];
            }
            end++;
        }

        bw.write((minLength == Integer.MAX_VALUE ? 0 : minLength) + "\n");
        bw.flush();
    }
}
