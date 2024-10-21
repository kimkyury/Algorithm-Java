import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        int[] arr1 = new int[N];
        Integer[] arr2 = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2, Comparator.reverseOrder());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr1[i] * arr2[i];
        }

        bw.write(sum + "");
        bw.flush();
    }

}
