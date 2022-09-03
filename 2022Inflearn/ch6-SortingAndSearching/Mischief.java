import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] solution(int size, int[] arr) {
        int answer[] = new int[2]; // asnwer[0] = 철수, answer[1] = 짝꿍

        int tmp[] = new int[size];

        for (int i = 0; i < size; i++) {
            tmp[i] = arr[i];
        }
        Arrays.sort(tmp);

        int index = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] != tmp[i]) {
                answer[index++] = i + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] hight = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hight[i] = Integer.parseInt(st.nextToken());
        }

        for (int x : solution(N, hight)) {
            System.out.print(x + " ");
        }
    }
}