import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static Map<String, String> teamByName;
    static Map<String, List<String>> nameListByTeam;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int cnt = 0;
    static char[][] map;

    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {

        // DFS로 25개중에 7개를 고르고
        map = new char[5][5];

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, new TreeSet<Integer>(), 0);

        bw.write(cnt + "");
        bw.flush();
    }

    public static void dfs(int sIdx, int tIdx, TreeSet<Integer> selected, int cntY) {

        if (cntY >= 4) {
            return;
        }

        // 가지치기 추가
        if (tIdx + (25 - sIdx) < 7) {
            return;
        }

        if (tIdx == 7) {
            // 7개 선택 다 했으면
            if (possible(selected)) {
                // System.out.println(selected.toString());
                cnt++;
            }
            return;
        }

        if (sIdx == 25) {
            return;
        }

        int ny = sIdx / 5;
        int nx = sIdx % 5;

        // 선택함
        selected.add(sIdx);
        dfs(sIdx + 1, tIdx + 1, selected, map[ny][nx] == 'Y' ? cntY + 1 : cntY);
        selected.remove(sIdx);
        // 선택 안 함
        dfs(sIdx + 1, tIdx, selected, cntY);
    }

    public static boolean possible(TreeSet<Integer> selected) {
        // 해당 7개가 다 인접한 애들인가

        Set<Integer> passedSet = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        passedSet.add(selected.first());
        q.offer(selected.first());

        while (!q.isEmpty()) {

            int num = q.poll();
            int y = num / 5;
            int x = num % 5;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) {
                    continue;
                }

                int next = ny * 5 + nx;

                if (passedSet.contains(next) || !selected.contains(next)) {
                    continue;
                }

                passedSet.add(next);
                q.offer(next);
            }
        }

        // 인접관계로 7개가 확인되면 가능한 케이스임
        return passedSet.size() == 7;
    }

}