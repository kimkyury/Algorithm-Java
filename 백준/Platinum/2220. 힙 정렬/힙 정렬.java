import java.io.*;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        // 4 -> 4 2 3 1
        // 최악의 경우: 맥스힙한테 가장 작은 수부터 큰수를 넣을 때다.

        // Swap을 할 때, 가장 작은 수가 맨 끝에 있어야 한다
        // root에 있는 작은 수가 내려가면서 실제 스왑을 적용시킨다
        int[] arr = new int[N + 1]; // 0을 root로 해버리니까 /2에서 상위를 보질 않음
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 1; j /= 2) {
                arr[j] = arr[j / 2]; // 1:0, 2:1, 3:1, 4:2, 5:2,
            }

            arr[1] = i + 1; // 그 다음수로 지정
        }
        arr[N] = 1;

        for (int i = 1; i <= N; i++) {
            bw.write(arr[i] + " ");
        }

        bw.close();
    }
}
