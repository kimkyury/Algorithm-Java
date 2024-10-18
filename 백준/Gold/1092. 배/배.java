import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static int[][] map;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        Integer[] boxes = new Integer[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        // 1. Box, 크레인을 정렬시킴
        // 2. q에다가 크레인을 넣음
        // 3. 크레인을 poll() 하면서, box를 데려감
        // 4. 만약에, 해당 box가 크레인의 max보다 모두 크다면 종료

        // C: 9 8 6
        // BOX: 7 5 4 2 2

        // box를 큐에 넣고, 빌 때까지 동작한다
        Arrays.sort(boxes, Collections.reverseOrder()); // box 정렬
        Arrays.sort(arr, Comparator.reverseOrder()); // 크레인 정렬

        if (boxes[0] > arr[0]) {
            bw.write("-1");
            bw.flush();
            return;
        }

        int time = 0; // 각 짐을 옮겨보자
        int bIdx = 0;
        int cnt = 0;
        boolean[] passed = new boolean[M];

        while (bIdx < M) {
            int idx = 0;

            // 크레인 i 탐색
            for (int i = 0; i < N && bIdx < M; i++) {

                // 크레인이 적절한 박스를 주을 때까지 반복
                // 안 실어보낸 것이면서 용량초과가 아닌 것
                while (idx < M && (passed[idx] || boxes[idx] > arr[i])) {
                    idx++; // 박스 탐색 증가
                }

                // 찾았고, 그 idx가 마지막이 아니면 여기로 온다
                if (idx < M) {
                    passed[idx] = true;
                    bIdx++;
                }
            }
            time++;

        }

        bw.write(time + "");
        bw.flush();
    }
}
