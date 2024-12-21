import java.io.*;

import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M;
    static int[] real, dream;
    static int min, max;

    public static void main(String[] args) throws IOException {

        // 음악의 빠르기를 통해 최대 꿈의 깊이, 최소 꿈의 깊이 계산하기

        // 한번의 꿈속 -> 음속 ++
        // (꿈)1x2x3 -> (꿈속꿈)1xx2xx3xx ->(꿈속꿈속꿈) 1xxx2xxx3xxx)

        N = Integer.parseInt(br.readLine()); // <1000, 현실 음
        real = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            real[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine()); // <1000, 꿈에서 들리는 음
        dream = new int[M];
        st = new StringTokenizer(br.readLine());
        List<Integer> starts = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            dream[i] = Integer.parseInt(st.nextToken());
            if (dream[i] == real[0]) {
                starts.add(i);
            }
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int sIdx : starts) {
            for (int diff = 1; diff <= M - N + 1; diff++) { // 수정
                if (count(sIdx, diff)) {
                    min = Math.min(min, diff - 1);
                    max = Math.max(max, diff - 1);
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            bw.write("-1\n");
        } else {
            bw.write(min + " " + max);
        }
        bw.flush();
    }

    static boolean count(int sIdx, int diff) {
        // ver1 완탐: 간격 1, 2, 3, 4 ..N 까지 수행하며 규칙이 통하는지 확인

        int idx = sIdx;

        // 현실 소리에 대하여 해당 간격으로 다 존재하는지 확인
        for (int v : real) {
            if (idx >= M || dream[idx] != v) {
                return false;
            }
            idx += diff;
        }

        return true;
    }
}
