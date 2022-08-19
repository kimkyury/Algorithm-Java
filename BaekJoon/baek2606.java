import java.util.*;
import java.io.*;

public class baek2606 {
    static int[][] map;
    static int cnt = 0;
    static boolean[] passed;

    // 해당문제는 첫번재 컴퓨터가 속한 군집의 개체 수를 세는 것. 나는 DFS를 사용함.
    static void dfs(int start) {
        passed[start] = true;
        for (int i = 0; i < map.length; i++) {
            if (!passed[i] && map[start][i] == 1) {
                cnt++;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCpt = Integer.parseInt(br.readLine());
        map = new int[numCpt][numCpt];
        passed = new boolean[numCpt];

        int numConnect = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < numConnect; i++) {
            st = new StringTokenizer(br.readLine());
            int connect1 = Integer.parseInt(st.nextToken());
            int connect2 = Integer.parseInt(st.nextToken());

            map[connect1 - 1][connect2 - 1] = 1;
            map[connect2 - 1][connect1 - 1] = 1;
        }

        dfs(0);
        System.out.print(cnt);
    }
}