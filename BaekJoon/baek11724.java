import java.util.*;
import java.io.*;

public class baek11724 {
    static boolean[][] map;
    static int n, m;
    static boolean passed[];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][n];
        passed = new boolean[n];

        // 연결 여부 표로 정리하기
        int first, second;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());
            map[first - 1][second - 1] = true;
            map[second - 1][first - 1] = true;
        }

        // bfs를 써서 연결된 부분을 확인하고, 지나가지 않은 곳이라면 세도록 하자
        // 여기서 카운트는 새로 시작되는 스타트지점을 세는 것임
        for (int i = 0; i < n; i++) {

            if (!passed[i]) {
                search(i);
                cnt++;
            }
        }

        System.out.print(cnt);
    }

    static void search(int number) {
        // 시작되는 곳으로부터 연결된 곳은 LIST에 기록된다, QUEUE에 저장된 순으로(FIFO) 빠져나가면서 연결된 부분을 확인할 수 있다.

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(number);
        passed[number] = true;
        while (!q.isEmpty()) {
            int v = q.poll(); // 삽입및 삭제
            for (int i = 0; i < n; i++) {

                // 연결된 요소는 main에서 셀 수 없도록 passed에 저장한다
                if (map[v][i] == true && !passed[i]) {
                    q.add(i);
                    passed[i] = true;
                }
            }
        }
    }
}