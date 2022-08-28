import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] solution(int N, int[] arr) {

        for (int i = 0; i < N; i++) {
            int idx = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        return arr;

        // // 최소값을 찾는다
        // int minValueIndex = 0;
        // int targetIndex;
        // int min;
        // // i번째로 이동할 숫자를 j범위(i+1 ~ N)에서 찾자
        // for (int i = 0; i < N; i++) {
        // min = arr[i];
        // targetIndex = i;
        // minValueIndex = i;
        // for (int j = i + 1; j < N; j++) {
        // if (min > arr[j]) {
        // min = arr[j];
        // minValueIndex = j;
        // }
        // }
        // int tmp = arr[targetIndex];
        // arr[targetIndex] = min;
        // arr[minValueIndex] = tmp;
        // }

        // return arr;
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