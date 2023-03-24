import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] isCircleV;
    static int[] distanceInfo;
    static boolean[] isPassed;
    static boolean isConfirmed;

    public static void bfs(int startV) {
        // 가장 가까운 순환선을 찾아서 그 거리를 파악하기

        int distance = 0;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> connectVs = graph.get(startV);
        isPassed[startV] = true;

        boolean flag = false;

        for (int i = 0; i < connectVs.size(); i++) {
            q.offer(connectVs.get(i));
        }

        while (!q.isEmpty()) {

            distance++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int targetV = q.poll();

                if (isPassed[targetV])
                    continue;

                isPassed[targetV] = true;
                if (isCircleV[targetV]) {
                    distanceInfo[startV] = distance;
                    flag = true;
                    return;
                }

                connectVs = graph.get(targetV);
                for (int j = 0; j < connectVs.size(); j++) {
                    q.offer(connectVs.get(j));
                }
            }

        }
    }

    public static void dfs(int startV, int originalV, int cnt) {

        // 순환인지 확인할려면
        // 적어도 2개의 역은 걸쳐서 다시 와야함 ( 0 -> 1 -> 2, 2이상이여야 함)
        if (isConfirmed) {
            return;
        }
        if (startV == originalV && cnt >= 2) {
            // System.out.println(cnt + "번 만에 " + originalV + "에 대하여 순환 확인");
            isCircleV[originalV] = true;
            isConfirmed = true;
            return;
        }

        ArrayList<Integer> connectVs = graph.get(startV);
        for (int i = 0; i < connectVs.size(); i++) {
            int targetV = connectVs.get(i);

            if (targetV == originalV && cnt < 2) {
                continue;
            }
            if (isPassed[targetV])
                continue;

            // original로부터 탐색하지 않은 V에 대하여 DFS
            isPassed[targetV] = true;
            dfs(targetV, originalV, cnt + 1);
        }
    }

    public static void main(String args[]) throws Exception {

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        isCircleV = new boolean[N + 1];
        distanceInfo = new int[N + 1];
        isPassed = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int v1, v2;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        // dfs -> Setting isCircle, 즉 순환V 인지 파악
        for (int i = 1; i <= N; i++) {
            isPassed = new boolean[N + 1];
            isConfirmed = false;
            dfs(i, i, 0);
        }

        // 제대로 순환선과의 분리가 되었는지 보쟝
        // for (int i = 1; i <= N; i++) {
        // if (isCircleV[i])
        // System.out.println(i + "는 순환선");
        // else
        // System.out.println(i + "는 지선");
        // }

        // bfs -> Setting setCntInfo, 지선이 순환V와의 거리를 얼마나 갖는지 파악
        for (int i = 1; i <= N; i++) {
            if (isCircleV[i]) {
                bw.write("0" + " ");
            } else {
                isPassed = new boolean[N + 1];
                bfs(i);
                bw.write(String.valueOf(distanceInfo[i]) + " ");
            }
        }

        bw.flush();
    }
}
