import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// 16964
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // 첫째 줄에 정점의 수 N(2 ≤ N ≤ 100,000)이 주어진다.
    // 둘째 줄부터 N-1개의 줄에는 트리의 간선 정보가 주어진다.
    // 마지막 줄에는 DFS 방문 순서가 주어진다.
    // DFS 방문 순서는 항상 N개의 정수로 이루어져 있으며,
    // 1부터 N까지 자연수가 한 번씩 등장한다.

    private static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(
        new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static List<List<Integer>> tree;
    private static boolean[] isPassed;
    private static boolean isRight = false;
    private static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        // 1. 그래프 생성
        isPassed = new boolean[N + 1];
        tree = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<>());
        }

        // 2. 인접정보 저장
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree.get(node1)
                .add(node2);
            tree.get(node2)
                .add(node1);
        }

        // 3. 입력된 방문 순서 저장
        int[] order = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        // 4. 시작이 1인지 확인
        if (order[0] == 1) {
            isPassed[1] = true;
            // 함수 동작
            check(0, order);
        }

        if (!isRight) {
            bw.write("0");
        } else {
            bw.write("1");
        }

        bw.flush();
    }


    public static void check(int vIdx, int[] order) {

        if (vIdx == N - 1) {
            isRight = true;
            return;
        }

        int V = order[vIdx];
        Set<Integer> candidateList = new HashSet<>();

        // 1. V와 인접한 정보를 담는다 (아직 방문하지 않았어야 한다)
        for (int adjV : tree.get(V)) {

            if (isPassed[adjV]) {
                continue;
            }
            candidateList.add(adjV);
        }

        // 현재 입력된 Order들을 순회한다
        for (int idx = vIdx + 1; idx < N; idx++) {

            int nextV = order[idx];
            // DFS 과정 중 자식들이 해결한 index는 신경쓰지 않는다.
            if (isPassed[nextV]) {
                continue;
            }

            // 만약, 후보지에 없다면 종료한다
            if (!candidateList.contains(nextV)) {
                return;
            }

            isPassed[nextV] = true;
            check(idx, order);
        }
    }


    private void show(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
}
