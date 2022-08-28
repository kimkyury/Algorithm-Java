import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] solution(int N, int[] arr) {

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        return arr;

        // for (int k = N; k > 1; k--) {
        // for (int i = 0; i < N; i++) {
        // for (int j = i + 1; j < N; j++) {

        // if (arr[i] > arr[j]) {
        // int tmp = arr[i];
        // arr[i] = arr[j];
        // arr[j] = tmp;
        // }
        // }
        // }
        // }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = solution(N, arr);
        for (int i = 0; i < N; i++) {
            System.out.print(answer[i] + " ");
        }
        return;
    }
}