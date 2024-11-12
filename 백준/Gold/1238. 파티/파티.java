import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, X;

    static int[] toI; // [i][j]: i -> j로 갈 때의 비용
    static int[] toX;

    static List<List<int[]>> goTo; // 단방향 그래프
    static List<List<int[]>> goFrom;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N < 10^3
        M = Integer.parseInt(st.nextToken()); // 1 <= M < 10^4
        X = Integer.parseInt(st.nextToken());

        // O(N) = 10^3 * 10^4 * 2 ? < 1초

        goTo = new ArrayList<>();
        goFrom = new ArrayList<>();
        toI = new int[N + 1];
        toX = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            goTo.add(new ArrayList<>());
            goFrom.add(new ArrayList<>());
            toI[i] = Integer.MAX_VALUE;
            toX[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int t = Integer.parseInt(st.nextToken());

            goTo.get(s).add(new int[] { e, t }); //
            goFrom.get(e).add(new int[] { s, t }); // x -> i로 가는 걸 구하기 위함

            // 1. X -> i 으로 가는 각각의 최단 거리를 구한다
            // goFrom에서 빼오기

            // 2. i -> X 로 가는 각각의 최단 거리를 구한다
            // goTo에서 빼오기

            // 3. toX[i], toI[i] 의 합이 가장 큰 것을 구한다

        }

        getGoToX();
        getGoToI();

        // System.out.println(Arrays.toString(toX));
        // System.out.println(Arrays.toString(toI));

        int maxSum = 0;
        for (int i = 1; i <= N; i++) {

            if (i == X)
                continue;

            maxSum = Math.max(toI[i] + toX[i], maxSum);
        }

        bw.write(maxSum + "");
        bw.flush();

    }

    public static void getGoToI() {

        // X -> i로 가는 실제를 구하면 된다

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> o1[1] - o2[1]);

        boolean[] passed = new boolean[N + 1];
        passed[X] = true;
        for (int[] next : goTo.get(X)) {
            toI[next[0]] = next[1];
            pq.offer(next);
        }

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            for (int[] next : goTo.get(cur[0])) {
                if (passed[next[0]]) {
                    continue;
                }

                passed[cur[0]] = true;
                if (toI[cur[0]] + next[1] < toI[next[0]]) {
                    toI[next[0]] = toI[cur[0]] + next[1];
                    pq.offer(new int[] { next[0], toI[next[0]] });
                }
            }

        }

    }

    public static void getGoToX() {
        // X로 가는 각 i의 최소길이를 구하기 toX [i]
        // 반대로, X가 각 i로 도착하는 시간을 구하면 된다

        // X에 연결된 각 간선을 구하고, 그 간선의 최소길이를 pq에 담고,
        // min갱신해주기

        boolean[] passed = new boolean[N + 1];
        passed[X] = true;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> o1[1] - o2[1] // 오름차순
        );
        for (int[] next : goFrom.get(X)) {
            pq.offer(next);
            toX[next[0]] = next[1];
        }

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();
            for (int[] next : goFrom.get(cur[0])) {
                if (passed[next[0]]) {
                    continue;
                }

                passed[cur[0]] = true;
                if (toX[cur[0]] + next[1] < toX[next[0]]) {
                    toX[next[0]] = toX[cur[0]] + next[1];
                    pq.offer(new int[] { next[0], toX[next[0]] });
                }
            }
        }

    }

}
