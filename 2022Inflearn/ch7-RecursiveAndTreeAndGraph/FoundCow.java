import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    private int dis[] = { -1, 1, 5 };
    int passed[] = new int[10000]; // 제약조건

    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int x1, int x2) { // x1: 현수, x2:송아지

        passed[x1] = 1;
        Q.offer(x1);
        int level = 0;

        while (!Q.isEmpty()) {
            int lenLevel = Q.size(); // 최초: 1

            for (int i = 0; i < lenLevel; i++) {
                int x = Q.poll();

                if (x == x2) {
                    return level;
                }

                for (int j = 0; j < 3; j++) {
                    int xn = x + dis[j];

                    // (제약조건)일정거리에 해당하면서, 앞선 레벨에서 거치지 않은 거리일 때
                    if ((xn >= 1 && xn <= 10000) && passed[xn] != 1) {
                        passed[xn] = 1;
                        Q.offer(xn);
                    }
                }
            }
            level++;
        }

        return level;
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());

        int answer = main.BFS(x1, x2);

        System.out.println(answer);
    }
}