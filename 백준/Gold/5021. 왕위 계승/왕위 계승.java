import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M;

    static HashMap<String, Integer> cntByName;
    static HashMap<String, List<String>> tree;
    static HashMap<String, Boolean> passedByName;
    static HashMap<String, Double> valueByName;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 혈통에서 가장 먼 놈, root

        // 자식들 정보를 집어넣기
        cntByName = new HashMap<>();
        tree = new HashMap<>();
        passedByName = new HashMap<>();
        valueByName = new HashMap<>();

        String root = br.readLine();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String next = st.nextToken();
            String p1 = st.nextToken();
            String p2 = st.nextToken();

            // 해당 인간이 혈통을 가졌는지 여부는 순서대로 알 수 없다

            passedByName.put(next, false);

            List<String> p1Children = tree.getOrDefault(p1, new ArrayList<>());
            List<String> p2Children = tree.getOrDefault(p2, new ArrayList<>());
            List<String> cChildren = tree.getOrDefault(next, new ArrayList<>());
            p1Children.add(next);
            p2Children.add(next);

            tree.put(p1, p1Children);
            tree.put(p2, p2Children);
            tree.put(next, cChildren);

            valueByName.put(next, 0.0);
        }

        // 1. 자식정보 트리구조 저장
        // 2. 부모가 없는 것부터 탐색 -> 혈동이 아닌애 거르고, root인 유토피아 거르고
        // 3. root인 사람으로부터 1/2씩 계산?

        for (String key : tree.keySet()) {
            List<String> child = tree.get(key);
        }

        Queue<String> q = new ArrayDeque<>();
        q.offer(root);

        Double addV = 0.5;
        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                String next = q.poll();
                for (String child : tree.get(next)) {
                    valueByName.put(child, valueByName.get(child) + addV);
                    q.offer(child);
                }
            }

            addV /= 2;
        }

        String maxName = "";
        double max = 0.0;
        // Set<String> candidate = new HashSet<>();
        for (int i = 0; i < M; i++) {
            // candidate.add(br.readLine());

            String candidate = br.readLine();

            if (!valueByName.containsKey(candidate)) {
                continue;
            }
            if (max < valueByName.get(candidate)) {
                max = valueByName.get(candidate);
                maxName = candidate;
            }
        }

        bw.write(maxName);
        bw.flush();
    }

    static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > 1 || x > N - 1) {
            return true;
        }
        return false;

    }
}
