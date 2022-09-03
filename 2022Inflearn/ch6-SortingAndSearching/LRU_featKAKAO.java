import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] solution(int size, int[] arr) {

        int[] answer = new int[size];

        for (int x : arr) {

            int pos = -1;
            for (int i = 0; i < size; i++) {
                if (x == answer[i]) {
                    // It is HIT!
                    pos = i; // Setting - Hit Position
                }
            }

            if (pos == -1) {
                /// It is MISS!
                pos = size - 1; // Setting - LastIndex Position
            }

            for (int i = pos; i > 0; i--) {
                answer[i] = answer[i - 1];
            }

            answer[0] = x;

        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] input = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[size];
        answer = solution(size, input);
        for (int num : answer) {
            System.out.print(num + " ");
        }
    }
}