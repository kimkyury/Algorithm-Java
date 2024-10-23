import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static List<Integer> answer;
    static List<List<Integer>> tree;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터 번호 출력하기

        answer = new ArrayList<>();
        tree = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            tree.get(p).add(c);
        }

        HashMap<Integer, Integer> cntByRoot = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            cntByRoot.put(i, 0);
        }

        // 루트인 애들만 보기
        int max = 0;
        for (int root : cntByRoot.keySet()) {
            int result = bfs(root);
            max = Math.max(max, result);
            cntByRoot.put(root, result);
        }

        // 최대값을 가지는 root 꺼내어 정렬
        for (int root : cntByRoot.keySet()) {
            if (cntByRoot.get(root) == max) {
                answer.add(root);
            }
        }
        Collections.sort(answer);

        for (int a : answer) {
            bw.write(a + " ");
        }

        bw.flush();
    }

    public static int bfs(int root) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(root);
        boolean[] passed = new boolean[N + 1];
        passed[root] = true;

        int cnt = 0;
        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int child : tree.get(cur)) {
                    if (passed[child]) {
                        continue;
                    }

                    passed[child] = true;
                    cnt++;
                    q.offer(child);
                }
            }
        }
        return cnt;
    }

}