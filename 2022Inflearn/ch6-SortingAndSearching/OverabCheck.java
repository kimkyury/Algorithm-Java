import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static char solution(int size, int[] arr) {
        char answer = 'U';

        Arrays.sort(arr);

        for (int i = 0; i < size - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return 'D';
            }
        }

        // for (int i = 0; i < size - 1; i++) {
        // for (int j = i + 1; j < size; j++) {
        // if (arr[i] == arr[j])
        // return 'D';
        // }
        // }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] input = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, input));
    }
}