import java.util.*;
import java.io.*;

//점의 위치와 이동 횟수를 저장하는 클래스를 작성하였다.
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class baek7562 {
    static int n;
    static int[][] map;
    static boolean[][] visit;
    static int end_x;
    static int end_y;
    static int l;
    static Queue<Point> q = new LinkedList<Point>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visit = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());

            Point startP = new Point(start_x, start_y);

            st = new StringTokenizer(br.readLine());
            end_x = Integer.parseInt(st.nextToken());
            end_y = Integer.parseInt(st.nextToken());

            bfs(startP);

            // 끝지점에 저장된 값을 출력시키면 횟수가 나온다
            bw.append(Integer.toString(map[end_x][end_y]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(Point p) {

        int[] Xs = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] Ys = { 1, 2, 2, 1, -1, -2, -2, -1 };

        q.clear();
        visit[p.x][p.y] = true;
        q.add(p);

        while (!q.isEmpty()) {
            // q에 연결된 좌표를 받아온다
            Point connect_P = q.poll();

            // 만약 그 좌표가 도착할 지점이라면 그만한다
            if (connect_P.x == end_x && connect_P.y == end_y)
                break;

            for (int i = 0; i < 8; i++) {
                // p에서 이동할 수 있는 좌표를 구하기 위해, 이동 가능한 z좌표들을 불러온다
                int add_x = connect_P.x + Xs[i];
                int add_y = connect_P.y + Ys[i];

                // 이때, 체스판의 범위에 속하며 방문하지 않았다면 (연결되어있다는 의미에서) q에 집어넣는다
                if ((add_x >= 0 && add_y >= 0) && (add_x < l && add_y < l) && !visit[add_x][add_y]) {
                    q.add(new Point(add_x, add_y));
                    visit[add_x][add_y] = true;

                    // 연결되었던 곳에서 뻗어나오니까, 앞에서부터 +1을 해준다
                    // 한 번 연결했던 곳이면 visit표시를 해주었고, 그것이 그곳에 도달하기 위한 최소값이니 중복의 걱정은 안 해도 된다
                    map[add_x][add_y] = map[connect_P.x][connect_P.y] + 1;
                }
            }
        }
    }
}