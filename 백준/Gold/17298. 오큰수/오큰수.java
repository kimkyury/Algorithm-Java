import java.io.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, T;
    static StringTokenizer st;
    static long max = 0;
    static int[] tree, arr;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine()); // 10^6

        // 1. 스택에 담아 역순으로 처리한다
        // stack.top이 현재 값보다 작거나 같으면 제거함
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            result[i] = -1;
        }

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {

            while (!dq.isEmpty()) {
                if (dq.peekFirst() > arr[i]) {
                    // 큰값이면 추가하러 가야 함
                    break;
                }
                dq.pop(); // 7
            }

            // Stack의 가장 왼측을 출력
            if (!dq.isEmpty()) {
                result[i] = dq.peekFirst(); // -1, 7, 7
            }

            dq.push(arr[i]); // 7 5
        }

        for (int num : result) {
            bw.write(num + " ");
        }
        bw.flush();
    }

}
